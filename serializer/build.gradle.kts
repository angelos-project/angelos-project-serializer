/**
 * Copyright (c) 2022 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
 *
 * This software is available under the terms of the MIT license. Parts are licensed
 * under different terms if stated. The legal terms are attached to the LICENSE file
 * and are made available on:
 *
 *      https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 *
 * Contributors:
 *      Kristoffer Paulsson - initial implementation
 */
plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
    id("module-publish-setup")
}

repositories {
    mavenCentral()
    mavenLocal()
}

tasks {
    dokkaHtml {
        dokkaSourceSets {}
        outputDirectory.set(buildDir.resolve("dokka"))
    }
    create<Jar>("javadocJar") {
        dependsOn(dokkaHtml)
        archiveClassifier.set("javadoc")
        from(dokkaHtml.get().outputDirectory.get())
    }
}

kotlin {
    jvm {
        val main by compilations.getting
        val processResources = main.processResourcesTaskName
        (tasks[processResources] as ProcessResources).apply {
            dependsOn(":jni-serializer:assemble")
            from("${project(":jni-serializer").buildDir}/lib/main/release/stripped")

            dependsOn(":jni-fs:assemble")
            from("${project(":jni-fs").buildDir}/lib/main/release/stripped")
        }

        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnit()
            systemProperty(
                "java.library.path",
                file("${buildDir}/processedResources/jvm/main").absolutePath
            )
        }
    }
    js(IR) {
        moduleName = MetaProject.artifact
        nodejs()
    }
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        val includePath = file("${project(":c-serializer").projectDir}/src/main/public/").absolutePath
        val libraryPathMain = file(project.file("${project(":c-serializer").buildDir}/lib/main/release/")).absolutePath
        val libraryPathTest = file(project.file("${project(":c-serializer").buildDir}/lib/main/debug/")).absolutePath

        val main by compilations.getting

        val cnative by main.cinterops.creating {
            defFile(project.file("src/nativeInterop/cinterop/c-serializer.def"))
            compilerOpts("-I$includePath")
            includeDirs.allHeaders(includePath)
            extraOpts("-libraryPath", "$libraryPathMain")
            extraOpts("-libraryPath", "$libraryPathTest")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.angproj.io.buf:angelos-project-buffer:1.0.1")
                implementation("org.angproj.io.err:angelos-project-errno:1.0.2")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        /*val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting*/
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.CInteropProcess::class) {
    dependsOn(":c-serializer:assemble")
}