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
package org.angproj.io.pipe

import org.angproj.io.buf.MutableBuffer
import org.angproj.io.buf.stream.mutableStreamByteBufferOf
import org.angproj.io.fs.Descriptor

/**
 * Intermittent duplexer for sending and receiving pipes.
 *
 * @constructor Create empty Intermittent duplexer
 */
open class IntermittentDuplexer(descriptor: Descriptor, val bufferSize: Int) : Intermittent(descriptor) {
    protected var readingBuffer: MutableBuffer = mutableStreamByteBufferOf(bufferSize)
    protected var writingBuffer: MutableBuffer = mutableStreamByteBufferOf(bufferSize)
}