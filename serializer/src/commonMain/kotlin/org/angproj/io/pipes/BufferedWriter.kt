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

import org.angproj.io.buf.Buffer
import org.angproj.io.buf.MutableBuffer
import org.angproj.io.pipe.Seek

open class BufferedWriter(val raw: RawIOBase, bufferSize: Int) : BufferedIOBase {
    override fun read(size: Int): ByteArray {
        TODO("Not yet implemented")
    }

    override fun read1(size: Int): MutableBuffer {
        TODO("Not yet implemented")
    }

    override fun readInto(buffer: ByteArray): Int {
        TODO("Not yet implemented")
    }

    override fun readInto1(buffer: MutableBuffer): Int {
        TODO("Not yet implemented")
    }

    override fun write(buffer: Buffer): Int {
        TODO("Not yet implemented")
    }

    override fun detach(): RawIOBase {
        TODO("Not yet implemented")
    }

    override val closed: Boolean
        get() = TODO("Not yet implemented")

    override fun seek(position: Long, whence: Seek) {
        TODO("Not yet implemented")
    }

    override fun tell(): Long {
        TODO("Not yet implemented")
    }

    override fun truncate(position: Long): Long {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }

    override fun isSeekable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isReadable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isWritable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun fileNo(): Int {
        TODO("Not yet implemented")
    }

    override fun isInteractive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun readLine(size: Int): ByteArray {
        TODO("Not yet implemented")
    }

    override fun readLines(hint: Long): List<ByteArray> {
        TODO("Not yet implemented")
    }

    override fun writeLines(lines: List<ByteArray>) {
        TODO("Not yet implemented")
    }
}