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

class StreamReader(val limit: Int) {
    fun setTransport(transport: Transport) {
        TODO("Not yet implemented")
    }

    fun feedEof() {
        TODO("Not yet implemented")
    }

    fun atEof(): Boolean {
        TODO("Not yet implemented")
    }

    fun feedData(data: ByteArray) {
        TODO("Not yet implemented")
    }

    suspend fun readLine(): Line {
        TODO("Not yet implemented")
    }

    suspend fun readUntil(separator: String = "\n"): ByteArray {
        TODO("Not yet implemented")
    }

    suspend fun read(n: Int = -1): ByteArray {
        TODO("Not yet implemented")
    }

    suspend fun readExactly(n: Int): ByteArray {
        TODO("Not yet implemented")
    }

    // Add an iterator
}

// https://docs.python.org/3/library/asyncio-stream.html?highlight=streamreader