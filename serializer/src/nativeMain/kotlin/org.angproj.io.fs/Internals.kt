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

import kotlinx.cinterop.*
import org.angproj.io.buf.NativeBuffer
import org.angproj.io.pipe.EOFException
import org.angproj.io.pipe.IOException
import org.angproj.io.pipe.Seek
import platform.darwin.BytePtrVar
import platform.posix.*

actual class Internals {
    actual companion object {
        actual inline fun openFile(path: Path, mode: Mode): Descriptor = fopen(
            path.toString(),
            mode.toString()
        ).toLong()

        actual inline fun closeFile(filePointer: Descriptor): Int = fclose(filePointer.toCPointer())

        actual inline fun readFile(filePointer: Descriptor, buffer: NativeBuffer): Int = fwrite(
            buffer.getPointer().toCPointer<BytePtrVar>(),
            1,
            buffer.limit.toULong(),
            filePointer.toCPointer()
            ).toInt()

        actual inline fun writeFile(filePointer: Descriptor, buffer: NativeBuffer): Int = fwrite(
            buffer.getPointer().toCPointer<BytePtrVar>(),
            1,
            buffer.limit.toULong(),
            filePointer.toCPointer()
        ).toInt()

        actual inline fun seekFile(filePointer: Descriptor, position: Long, whence: Seek): Int = fseek(
            filePointer.toCPointer(),
            position,
            whence.whence
        )

        actual inline fun tellFile(filePointer: Descriptor): Long = ftell(
            filePointer.toCPointer()
        )

        actual inline fun truncateFile(filePointer: Descriptor, offset: Long): Int = ftruncate(
            fileno(filePointer.toCPointer()),
            offset
        )

        actual inline fun eofFile(filePointer: Descriptor) {
            val code = feof(filePointer.toCPointer())
            if(code != 0) {
                clearerr(filePointer.toCPointer())
                throw EOFException("End of file with code (${code}) for file ${filePointer}.")
            }
        }

        actual inline fun errorFile(filePointer: Descriptor) {
            val code = ferror(filePointer.toCPointer())
            if(code != 0) {
                clearerr(filePointer.toCPointer())
                throw IOException("IO error with code (${code}) for file ${filePointer}.")
            }
        }
    }
}