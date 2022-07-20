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

import org.angproj.io.buf.*
import org.angproj.io.pipe.Seek

internal expect class Internals {
    companion object {
        fun openFile(path: Path, mode: Mode): Descriptor

        fun closeFile(filePointer: Descriptor): Boolean

        fun readFile(filePointer: Descriptor, buffer: NativeBuffer): Long

        fun writeFile(filePointer: Descriptor, buffer: MutableNativeBuffer): Long

        fun seekFile(filePointer: Descriptor, position: Long, whence: Seek): Long

        fun tellFile(filePointer: Descriptor): Long

        fun truncateFile(filePointer: Descriptor, offset: Long): Long
    }
}