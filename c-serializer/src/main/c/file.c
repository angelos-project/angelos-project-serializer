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
#include <stdio.h>
#include <unistd.h>
#include "file.h"

long fs_fopen(const char *path, const char *mode) {
    FILE* fp = fopen(path, mode);
    return fp == NULL ? (long)-1 : (long) fp;
}


int fs_fclose(long fp) {
    int result = fclose((FILE *) fp);
    return feof((FILE *) fp) ? -1 : 0;
}


long fs_fread(long buffer, int count, long fp) {
    int length = fread((void *) buffer, 1, count, (FILE *) fp);
    if (length > 0) {
        return length;
    } else {
        if (feof((FILE *) fp)) { return 0; }
        if (ferror((FILE *) fp)) { return -1; }
    }
    return -1;
}


long fs_fwrite(long buffer, int count, long fp) {
    int length = fwrite((void *) buffer, 1, count, (FILE *) fp);
    if (length > 0) {
        return length;
    } else {
        if (feof((FILE *) fp)) { return 0; }
        if (ferror((FILE *) fp)) { return -1; }
    }
    return -1;
}


long fs_fseek(long fp, long offset, int whence) {
    return (long)fseek((FILE *) fp, offset, whence) == 0 ? 0 : -1;
}


long fs_ftell(long fp) {
    long position = ftell((FILE *) fp);
    return position < 0 ? (long)-1: (long)position;
}


long fs_ftruncate(long fp, long length) {
    return (long)ftruncate(fileno((FILE *) fp), (off_t)length);
}