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

expect class Internals {
    companion object {
        fun openFile(path: Path, mode: Mode): Descriptor

        fun closeFile(filePointer: Descriptor): Int

        fun readFile(filePointer: Descriptor, buffer: NativeBuffer): Int

        fun writeFile(filePointer: Descriptor, buffer: NativeBuffer): Int

        fun seekFile(filePointer: Descriptor, position: Long, whence: Seek): Int

        fun tellFile(filePointer: Descriptor): Long

        fun truncateFile(filePointer: Descriptor, offset: Long): Int

        fun eofFile(filePointer: Descriptor)

        fun errorFile(filePointer: Descriptor)
    }
}