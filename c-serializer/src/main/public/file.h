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

#ifndef SRC_FILE_H
#define SRC_FILE_H


extern long fs_fopen(const char *path, const char *mode);


extern int fs_fclose(long fp);


extern long fs_fread(long buffer, int count, long fp);


extern long fs_fwrite(long buffer, int count, long fp);


extern long fs_fseek(long fp, long offset, int whence);


extern long fs_ftell(long fp);


extern long fs_ftruncate(long fp, long length);

#endif //SRC_FILE_H