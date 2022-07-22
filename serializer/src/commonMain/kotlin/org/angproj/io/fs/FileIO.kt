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
package org.angproj.io.fs

import org.angproj.io.pipe.*
import kotlinx.serialization.Serializable

class FileIO(endShared: IntermittentTransformer) : AbstractFile(endShared), Readable, Writable {

    protected var _closed: Boolean = false
    val closed: Boolean
        get() = _closed

    fun <T: Serializable> read(): T {
        check(isReadable())
        endShared.flipModeRead()

        TODO("Not yet implemented")
    }

    fun <T: Serializable> write(info: T): Int {
        check(isWritable())
        endShared.flipModeWrite()

        TODO("Not yet implemented")
    }

    fun flush() {
        endPoint.doFlush()
    }

    fun tell(): Long {
        check(isSeekable())
        return endPoint.doTell()
    }

    fun seek(position: Long, whence: Seek): Long {
        check(isSeekable())

        TODO("Not yet implemented")
    }

    fun truncate(position: Long): Long {
        check(isWritable())
        check(isReadable())

        TODO("Not yet implemented")
    }

    fun close() {
        if (!_closed) {
            endPoint.doClose()
        }
    }

    fun isReadable(): Boolean {
        check(!_closed)
        return trueEnd.isReadable
    }

    fun isWritable(): Boolean {
        check(!_closed)
        return trueEnd.isWritable
    }

    fun isSeekable(): Boolean {
        check(!_closed)
        return trueEnd.isReadable and trueEnd.isWritable
    }

    fun isInteractive(): Boolean {
        check(!_closed)
        return false
    }

    // Readable interface implementation
    override fun readByte(): Byte = readByBreak { endShared.middleBuffer.getNextByte() }

    override fun readUByte(): UByte = readByBreak { endShared.middleBuffer.getNextUByte() }

    override fun readChar(): Char = readByBreak { endShared.middleBuffer.getNextChar() }

    override fun readShort(): Short = readByBreak { endShared.middleBuffer.getNextShort() }

    override fun readUShort(): UShort = readByBreak { endShared.middleBuffer.getNextUShort() }

    override fun readInt(): Int = readByBreak { endShared.middleBuffer.getNextInt() }

    override fun readUInt(): UInt = readByBreak { endShared.middleBuffer.getNextUInt() }

    override fun readLong(): Long = readByBreak { endShared.middleBuffer.getNextLong() }

    override fun readULong(): ULong = readByBreak { endShared.middleBuffer.getNextULong() }

    override fun readFloat(): Float = readByBreak { endShared.middleBuffer.getNextFloat() }

    override fun readDouble(): Double = readByBreak { endShared.middleBuffer.getNextDouble() }

    // Writable interface implementation

    override fun writeByte(value: Byte) = writeByBreak { endShared.middleBuffer.setNextByte(value) }

    override fun writeUByte(value: UByte) = writeByBreak { endShared.middleBuffer.setNextUByte(value) }

    override fun writeChar(value: Char) = writeByBreak { endShared.middleBuffer.setNextChar(value) }

    override fun writeShort(value: Short) = writeByBreak { endShared.middleBuffer.setNextShort(value) }

    override fun writeUShort(value: UShort) = writeByBreak { endShared.middleBuffer.setNextUShort(value) }

    override fun writeInt(value: Int) = writeByBreak { endShared.middleBuffer.setNextInt(value) }

    override fun writeUInt(value: UInt) = writeByBreak { endShared.middleBuffer.setNextUInt(value) }

    override fun writeLong(value: Long) = writeByBreak { endShared.middleBuffer.setNextLong(value) }

    override fun writeULong(value: ULong) = writeByBreak { endShared.middleBuffer.setNextULong(value) }

    override fun writeFloat(value: Float) = writeByBreak { endShared.middleBuffer.setNextFloat(value) }

    override fun writeDouble(value: Double) = writeByBreak { endShared.middleBuffer.setNextDouble(value) }

}

fun open(file: VirtualPath, mode: Mode ): FileIO {
    return PassThroughTransformer(Internals.openFile(file, mode),4096).assemble(
        { i ->  FileIO(i as PassThroughTransformer) },
        { e, i -> BlockDevice(e, i as PassThroughTransformer) }
    ) as FileIO
}