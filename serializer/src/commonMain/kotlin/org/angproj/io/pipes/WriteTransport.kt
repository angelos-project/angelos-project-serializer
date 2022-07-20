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

interface WriteTransport : BaseTransport {
    fun setWriteBufferLimits(high: UInt, low: UInt)

    fun getWriteBufferSize(): Int

    fun getWriteBufferLimits(): Pair<UInt, UInt>

    fun write(data: ByteArray)

    fun writeLines(listOfData: List<Line>)

    fun writeEof()

    fun canWriteEof(): Boolean

    fun abort()
}