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
#include <jni.h>

#include <stdio.h>
#include <unistd.h>

#ifndef _Included_org_angproj_io_fs_Internals
#define _Included_org_angproj_io_fs_Internals
#ifdef __cplusplus
extern "C" {
#endif

static const char *JNIT_CLASS = "org/angproj/io/fs/Internals";


/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    fs_fopen
 * Signature: (Ljava/lang/String;Ljava/lang/String;)J
 */
static jlong fs_fopen(JNIEnv * env, jclass thisClass, jstring path, jstring mode) {
    const char *cpath = (*env)->GetStringUTFChars(env, path, NULL);
    const char *cmode = (*env)->GetStringUTFChars(env, mode, NULL);

    jlong fp = (jlong) fopen(cpath, cmode);

    (*env)->ReleaseStringUTFChars(env, cpath, NULL);
    (*env)->ReleaseStringUTFChars(env, cmode, NULL);

    return fp;
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    fs_fclose
 * Signature: (J)I
 */
static jint fs_fclose(JNIEnv * env, jclass thisClass, jlong fp) {
    return (jint) fclose((FILE *) fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    fs_fread
 * Signature: (JIJ)I
 */
static jint fs_fread(JNIEnv * env, jclass thisClass, jlong buffer, jint count, jlong fp) {
    return (jint) fread((void *) buffer, 1, count, (FILE *) fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    fs_fwrite
 * Signature: (JIJ)I
 */
static jint fs_fwrite(JNIEnv * env, jclass thisClass, jlong buffer, jint count, jlong fp) {
    return (jint) fwrite((void *) buffer, 1, count, (FILE *) fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    fs_fseek
 * Signature: (JJI)I
 */
static jint fs_fseek(JNIEnv * env, jclass thisClass, jlong fp, jlong offset, jint whence) {
    return (jint) fseek((FILE *) fp, offset, whence);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    fs_ftell
 * Signature: (J)J
 */
static jlong fs_ftell(JNIEnv * env, jclass thisClass, jlong fp) {
    return (jlong) ftell((FILE *) fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    fs_ftruncate
 * Signature: (JJ)I
 */
static jlong fs_ftruncate(JNIEnv * env, jclass thisClass, jlong fp, jlong length) {
    return (jint) ftruncate(fileno((FILE *) fp), (off_t) length);
}

static JNINativeMethod funcs[] = {
	{ "fs_fopen", "(Ljava/lang/String;Ljava/lang/String;)J", (void *)&fs_fopen },
	{ "fs_fclose", "(J)I", (void *)&fs_fclose },
	{ "fs_fread", "(JIJ)I", (void *)&fs_fread },
	{ "fs_fwrite", "(JIJ)I", (void *)&fs_fwrite },
	{ "fs_fseek", "(JJI)I", (void *)&fs_fseek },
	{ "fs_ftell", "(J)J", (void *)&fs_ftell },
	{ "fs_ftruncate", "(JJ)I", (void *)&fs_ftruncate }
};

#define CURRENT_JNI JNI_VERSION_1_6

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
	JNIEnv *env;
	jclass  cls;
	jint    res;

	(void)reserved;

	if ((*vm)->GetEnv(vm, (void **)&env, CURRENT_JNI) != JNI_OK)
		return -1;

	cls = (*env)->FindClass(env, JNIT_CLASS);
	if (cls == NULL)
		return -1;

	res = (*env)->RegisterNatives(env, cls, funcs, sizeof(funcs)/sizeof(*funcs));
	if (res != 0)
		return -1;

	return CURRENT_JNI;
}

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved)
{
	JNIEnv *env;
	jclass  cls;

	(void)reserved;

	if ((*vm)->GetEnv(vm, (void **)&env, CURRENT_JNI) != JNI_OK)
		return;

	cls = (*env)->FindClass(env, JNIT_CLASS);
	if (cls == NULL)
		return;

	(*env)->UnregisterNatives(env, cls);
}


#ifdef __cplusplus
}
#endif
#endif // _Included_org_angproj_io_fs_Internals