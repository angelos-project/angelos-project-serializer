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
import org.angproj.io.buf.stream.mutableStreamByteBufferOf

sealed class Packer(
    internal val encodeDefaults: Boolean,
    override val serializersModule: SerializersModule
) : ByteBufferFormat {
    //companion object Default : Packer(false, EmptySerializersModule)

    override fun <T> encodeToByteBuffer(serializer: SerializationStrategy<T>, value: T): MutableBuffer {
        /*val output = ByteBufferOutput()
        val encoder = ByteBufferPackerEncoder(this, ByteBufferPackerWriter(output), serializer.descriptor)
        encoder.encodeSerializableValue(serializer, value)
        return output.toByteArray()*/
        return mutableStreamByteBufferOf(1024)
    }

    /*override fun <T> decodeFromByteBuffer(deserializer: DeserializationStrategy<T>, bytes: Buffer): T {
        val input = ByteBufferInput(bytes)
        val decoder = ByteBufferPackerDecoder(this, ByteBufferPackerReader(input), deserializer.descriptor)
        return decoder.decodeSerializableValue(deserializer)
    }*/
}

/*fun Packer(from: Packer = Packer.Default, builderAction: PackerBuilder.() -> Unit): Packer {
    val b = PackerBuilder(from)
    b.builderAction()
    return PackerImpl(b.encodeDefaults, b.serializersModule)
}*/

class PackerBuilder internal constructor(packer: Packer) {
    var encodeDefaults: Boolean = packer.encodeDefaults

    var serializersModule: SerializersModule = packer.serializersModule
}

/*private class PackerImpl(encodeDefaults: Boolean, serializersModule: SerializersModule) :
    Packer(encodeDefaults, serializersModule)*/