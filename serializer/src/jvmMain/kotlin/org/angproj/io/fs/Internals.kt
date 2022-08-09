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
package org.angproj.io.fs

import org.angproj.io.buf.NativeBuffer
import org.angproj.io.pipe.Seek

actual class Internals {
    actual companion object {
        actual fun openFile(path: Path, mode: Mode): Descriptor = fs_fopen(path.toString(), mode.mode)

        actual fun closeFile(filePointer: Descriptor): Int = fs_fclose(filePointer)

        actual fun readFile(filePointer: Descriptor, buffer: NativeBuffer): Int = fs_fread(buffer.getPointer(), buffer.limit, filePointer)

        actual fun writeFile(filePointer: Descriptor, buffer: NativeBuffer): Int = fs_fwrite(buffer.getPointer(), buffer.limit, filePointer)

        actual fun seekFile(filePointer: Descriptor, position: Long, whence: Seek): Int = fs_fseek(filePointer, position, whence.whence)

        actual fun tellFile(filePointer: Descriptor): Long = fs_ftell(filePointer)

        actual fun truncateFile(filePointer: Descriptor, offset: Long): Int = fs_ftruncate(filePointer, offset)

        @JvmStatic
        private external fun fs_fopen(path: String, mode: String): Long

        @JvmStatic
        private external fun fs_fclose(fp: Long): Int

        @JvmStatic
        private external fun fs_fread(buffer: Long, count: Int, fp: Long): Int

        @JvmStatic
        private external fun fs_fwrite(buffer: Long, count: Int, fp: Long): Int

        @JvmStatic
        private external fun fs_fseek(fp: Long, offset: Long, whence: Int): Int

        @JvmStatic
        private external fun fs_ftell(fp: Long): Long

        @JvmStatic
        private external fun fs_ftruncate(fp: Long, length: Long): Int
    }
}