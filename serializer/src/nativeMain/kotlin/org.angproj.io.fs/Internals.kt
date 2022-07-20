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

import cserializer.*
import org.angproj.io.buf.MutableNativeBuffer
import org.angproj.io.buf.NativeBuffer
import org.angproj.io.pipe.Seek

internal actual class Internals {
    actual companion object {
        actual fun openFile(path: Path, mode: Mode): Descriptor {
            return fs_fopen(path.toString(), mode.mode)
        }

        actual fun closeFile(filePointer: Descriptor): Boolean = when(fs_fclose(filePointer)) {
            0 -> true
            -1 -> false
            else -> error("Unknown return code")
        }

        actual fun readFile(filePointer: Descriptor, buffer: NativeBuffer): Long {
            return fs_fread(buffer.getPointer(), buffer.limit, filePointer)
        }

        actual fun writeFile(filePointer: Descriptor, buffer: MutableNativeBuffer): Long {
            return fs_fwrite(buffer.getPointer(), buffer.limit, filePointer)
        }

        actual fun seekFile(filePointer: Descriptor, position: Long, whence: Seek): Long {
            return fs_fseek(filePointer, position, whence.whence)
        }

        actual fun tellFile(filePointer: Descriptor): Long {
            return fs_ftell(filePointer)
        }

        actual fun truncateFile(filePointer: Descriptor, offset: Long): Long {
            return fs_ftruncate(filePointer, offset)
        }

    }
}