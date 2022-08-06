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
import org.angproj.io.pipe.*

class BlockDevice(entryPoint: File, entryShared: IntermittentTransformer) : AbstractDevice(entryPoint, entryShared) {
    override fun doFlush(): Unit = when(entryShared.flipper) {
        Flipper.WRITE -> forwardWrite()
        else -> Unit
    }

    override fun doTell(): Long = entryShared.position

    override fun doSeek(position: Long, whence: Seek): Long {
        return Internals.seekFile(entryShared.descriptor, position, whence)
    }

    override fun doTruncate(position: Long): Long {
        return Internals.truncateFile(entryShared.descriptor, position)
    }

    override fun doClose() {
        Internals.closeFile(entryShared.descriptor)
    }

    override fun forwardWrite() {
        check(entryShared.flipper == Flipper.WRITE)

        val buffer = entryShared.bufferSwap()
        check(Internals.writeFile(entryShared.descriptor, buffer as MutableNativeBuffer) == buffer.limit.toLong())
    }
}