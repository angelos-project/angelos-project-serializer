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

import kotlinx.serialization.encoding.AbstractEncoder
import kotlinx.serialization.modules.SerializersModule
import org.angproj.io.buf.*

class ByteArrayPackerEncoder: ByteArrayCodec, PackerEncoder, AbstractEncoder() {
    override val packer: Packer
        get() = TODO("Not yet implemented")
    override val serializersModule: SerializersModule
        get() = TODO("Not yet implemented")

    override val array: ByteArray
        get() = TODO("Not yet implemented")
    override var index: Int
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun encodeBoolean(value: Boolean): Unit {
        array[index] = when (value) {
            true -> 1
            false -> 0
        }
        index += Buffer.BYTE_SIZE
    }

    override fun encodeByte(value: Byte): Unit {
        array[index] = value
        index += Buffer.BYTE_SIZE
    }

    override fun encodeShort(value: Short): Unit {
        array.writeShortAt(index, value)
        index += Buffer.SHORT_SIZE
    }

    override fun encodeInt(value: Int): Unit {
        array.writeIntAt(index, value)
        index += Buffer.INT_SIZE
    }

    override fun encodeLong(value: Long): Unit {
        array.writeLongAt(index, value)
        index += Buffer.LONG_SIZE
    }

    override fun encodeFloat(value: Float): Unit {
        array.writeFloatAt(index, value)
        index += Buffer.FLOAT_SIZE
    }

    override fun encodeDouble(value: Double): Unit {
        array.writeDoubleAt(index, value)
        index += Buffer.DOUBLE_SIZE
    }

    override fun encodeChar(value: Char): Unit {
        array.writeCharAt(index, value)
        index += Buffer.CHAR_SIZE
    }

    override fun encodeString(value: String): Unit {
        val ba = value.encodeToByteArray()
    }

}