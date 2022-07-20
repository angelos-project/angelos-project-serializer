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

import org.angproj.io.buf.MutableNativeBuffer
import org.angproj.io.buf.NativeBuffer
import org.angproj.io.pipe.Seek

internal actual class Internals {
    actual companion object {
        actual fun openFile(path: Path, mode: Mode): Descriptor {
            throw UnsupportedOperationException("Not implemented")
        }

        actual fun closeFile(filePointer: Descriptor): Boolean {
            throw UnsupportedOperationException("Not implemented")
        }

        actual fun readFile(filePointer: Descriptor, buffer: NativeBuffer): Long {
            throw UnsupportedOperationException("Not implemented")
        }

        actual fun writeFile(filePointer: Descriptor, buffer: MutableNativeBuffer): Long {
            throw UnsupportedOperationException("Not implemented")
        }

        actual fun seekFile(filePointer: Descriptor, position: Long, whence: Seek): Long {
            throw UnsupportedOperationException("Not implemented")
        }

        actual fun tellFile(filePointer: Descriptor): Long {
            throw UnsupportedOperationException("Not implemented")
        }

        actual fun truncateFile(filePointer: Descriptor, offset: Long): Long {
            throw UnsupportedOperationException("Not implemented")
        }
    }

}