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
#include "file.h"

#ifndef _Included_org_angproj_io_fs_Internals
#define _Included_org_angproj_io_fs_Internals
#ifdef __cplusplus
extern "C" {
#endif

static const char *JNIT_CLASS = "org/angproj/io/fs/Internals";


/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    _fopen
 * Signature: (Ljava/lang/String;Ljava/lang/String;)J
 */
static jint _fopen(JNIEnv * env, jclass thisClass, jstring path, jstring mode) {
    const char *cpath = (*env)->GetStringUTFChars(env, path, NULL);
    const char *cmode = (*env)->GetStringUTFChars(env, mode, NULL);

    long fp = fs_fopen(cpath, cmode);

    (*env)->ReleaseStringUTFChars(env, cpath, NULL);
    (*env)->ReleaseStringUTFChars(env, cmode, NULL);

    return fp;
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    _fclose
 * Signature: (J)I
 */
static jint _fclose(JNIEnv * env, jclass thisClass, jlong fp) {
    return fs_fclose(fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    _fread
 * Signature: (JIJ)J
 */
static jlong _fread(JNIEnv * env, jclass thisClass, jlong buffer, jint count, jlong fp) {
    return fs_fread(buffer, count, fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    _fwrite
 * Signature: (JIJ)J
 */
static jlong _fwrite(JNIEnv * env, jclass thisClass, jlong buffer, jint count, jlong fp) {
    return fs_fwrite(buffer, count, fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    _fseek
 * Signature: (JJI)J
 */
static jlong _fseek(JNIEnv * env, jclass thisClass, jlong fp, jlong offset, jint whence) {
    return fs_fseek(fp, offset, whence);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    _ftell
 * Signature: (J)J
 */
static jlong _ftell(JNIEnv * env, jclass thisClass, jlong fp) {
    return fs_ftell(fp);
}

/*
 * Class:     org_angproj_io_fs_Internals
 * Method:    _ftruncate
 * Signature: (JJ)J
 */
static jlong _ftruncate(JNIEnv * env, jclass thisClass, jlong fp, jlong length) {
    return fs_ftruncate(fp, length);
}

static JNINativeMethod funcs[] = {
	{ "fs_fopen", "(Ljava/lang/String;Ljava/lang/String;)J", (void *)&_fopen },
	{ "fs_fclose", "(J)I", (void *)&_fclose },
	{ "fs_fread", "(JIJ)J", (void *)&_fread },
	{ "fs_fwrite", "(JIJ)J", (void *)&_fwrite },
	{ "fs_fseek", "(JJI)J", (void *)&_fseek },
	{ "fs_ftell", "(J)J", (void *)&_ftell },
	{ "fs_ftruncate", "(JJ)J", (void *)&_ftruncate }
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