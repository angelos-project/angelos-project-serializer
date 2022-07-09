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
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import org.angproj.io.buf.Buffer
import org.angproj.io.buf.MutableBuffer

sealed class Packer(override val serializersModule: SerializersModule) : ByteBufferFormat, ByteArrayFormat {
    companion object Default : Packer(EmptySerializersModule)

    override fun <T> encodeToByteBuffer(serializer: SerializationStrategy<T>, value: T): MutableBuffer {
        TODO("Not yet implemented")
    }

    override fun <T> decodeFromByteBuffer(deserializer: DeserializationStrategy<T>, buffer: Buffer): T {
        TODO("Not yet implemented")
    }

    override fun <T> encodeToByteArray(serializer: SerializationStrategy<T>, value: T): ByteArray {
        TODO("Not yet implemented")
    }

    override fun <T> decodeFromByteArray(deserializer: DeserializationStrategy<T>, array: ByteArray): T {
        TODO("Not yet implemented")
    }
}

fun Packer(from: Packer = Packer.Default): Packer = from