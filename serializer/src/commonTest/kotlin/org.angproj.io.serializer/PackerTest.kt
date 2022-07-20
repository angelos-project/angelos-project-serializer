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
package org.angproj.io.serializer

import kotlinx.serialization.Serializable
import kotlin.test.Test

@Serializable
enum class Sex(val type: Byte) {
    MAN(1),
    WOMAN(2),
    EUNUCH(-1)
}

@Serializable
data class Person(val name: String, val sex: Sex, val age: Int) {
}

class PackerTest {

    @Test
    fun encodeToByteBuffer() {
        //val entity = Person("John Roe", Sex.MAN, 74)
        //val data = Packer.encodeToByteArray(entity)
    }

    @Test
    fun decodeFromByteBuffer() {

    }
}