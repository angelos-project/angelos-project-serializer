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
package org.angproj.io.serializer

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import org.angproj.io.buf.Buffer
import org.angproj.io.buf.MutableBuffer

interface ByteBufferFormat : SerializationFormat {
    fun <T> encodeToByteBuffer(serializer: SerializationStrategy<T>, value: T): MutableBuffer

    fun <T> decodeFromByteBuffer(deserializer: DeserializationStrategy<T>, buffer: Buffer): T
}