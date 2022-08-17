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
        actual fun openFile(path: Path, mode: Mode): Descriptor { TODO("Contribution required for implementation.") }

        actual fun closeFile(filePointer: Descriptor): Int { TODO("Contribution required for implementation.") }

        actual fun readFile(filePointer: Descriptor, buffer: NativeBuffer): Int { TODO("Contribution required for implementation.") }

        actual fun writeFile(filePointer: Descriptor, buffer: NativeBuffer): Int { TODO("Contribution required for implementation.") }

        actual fun seekFile(filePointer: Descriptor, position: Long, whence: Seek): Int { TODO("Contribution required for implementation.") }

        actual fun tellFile(filePointer: Descriptor): Long { TODO("Contribution required for implementation.") }

        actual fun truncateFile(filePointer: Descriptor, offset: Long): Int { TODO("Contribution required for implementation.") }

        actual fun eofFile(filePointer: Descriptor): Int { TODO("Contribution required for implementation.") }

        actual fun errorFile(filePointer: Descriptor): Int  { TODO("Contribution required for implementation.") }

        actual fun clearErrorFile(filePointer: Descriptor) { TODO("Contribution required for implementation.") }

        actual fun flushFile(filePointer: Descriptor): Int { TODO("Contribution required for implementation.") }

        actual fun numberFile(filePointer: Descriptor): Int { TODO("Contribution required for implementation.") }
    }
}