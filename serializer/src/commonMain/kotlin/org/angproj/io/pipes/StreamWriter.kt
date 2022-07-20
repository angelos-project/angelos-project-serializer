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

class StreamWriter(val transport: Transport, protocol: Protocol, reader: StreamReader) {
    fun write(data: ByteArray) {
        TODO("Not yet implemented")
    }

    fun writeLines(data: ByteArray) {
        TODO("Not yet implemented")
    }

    fun writeEof() {
        TODO("Not yet implemented")
    }

    fun canWriteEof(): Boolean {
        TODO("Not yet implemented")
    }

    fun close() {
        TODO("Not yet implemented")
    }

    fun isClosing(): Boolean {
        TODO("Not yet implemented")
    }

    suspend fun waitClosed() {
        TODO("Not yet implemented")
    }

    fun getExtraInfo(name: String): String {
        TODO("Not yet implemented")
    }

    suspend fun drain() {
        TODO("Not yet implemented")
    }
}

// https://docs.python.org/3/library/asyncio-stream.html?highlight=streamreader