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
package org.angproj.io.pipes

import org.angproj.io.pipe.Seek

interface IOBase {

    val closed: Boolean

    fun seek(position: Long, whence: Seek = Seek.SET)

    fun tell(): Long

    fun truncate(position: Long = 0): Long

    fun flush()

    fun close()

    fun isSeekable(): Boolean

    fun isReadable(): Boolean

    fun isWritable(): Boolean

    fun fileNo(): Int

    /**
     * Is interactive tells whether the underlying stream is a TTY.
     *
     * @return
     */
    fun isInteractive(): Boolean

    fun readLine(size: Int = -1): ByteArray

    fun readLines(hint: Long = -1): List<ByteArray>

    fun writeLines(lines: List<ByteArray>)
}

// https://github.com/python/cpython/blob/3.10/Lib/_pyio.py
