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

    fun seek(position: Long, whence: Seek): Int {
        check(isSeekable())

        return endPoint.doSeek(position, whence)
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
    override fun readByte(): Byte = readByBreak { endShared.middleBuffer.getReadByte() }

    override fun readUByte(): UByte = readByBreak { endShared.middleBuffer.getReadUByte() }

    override fun readChar(): Char = readByBreak { endShared.middleBuffer.getReadChar() }

    override fun readShort(): Short = readByBreak { endShared.middleBuffer.getReadShort() }

    override fun readUShort(): UShort = readByBreak { endShared.middleBuffer.getReadUShort() }

    override fun readInt(): Int = readByBreak { endShared.middleBuffer.getReadInt() }

    override fun readUInt(): UInt = readByBreak { endShared.middleBuffer.getReadUInt() }

    override fun readLong(): Long = readByBreak { endShared.middleBuffer.getReadLong() }

    override fun readULong(): ULong = readByBreak { endShared.middleBuffer.getReadULong() }

    override fun readFloat(): Float = readByBreak { endShared.middleBuffer.getReadFloat() }

    override fun readDouble(): Double = readByBreak { endShared.middleBuffer.getReadDouble() }

    // Writable interface implementation

    override fun writeByte(value: Byte) = writeByBreak { endShared.middleBuffer.setWriteByte(value) }

    override fun writeUByte(value: UByte) = writeByBreak { endShared.middleBuffer.setWriteUByte(value) }

    override fun writeChar(value: Char) = writeByBreak { endShared.middleBuffer.setWriteChar(value) }

    override fun writeShort(value: Short) = writeByBreak { endShared.middleBuffer.setWriteShort(value) }

    override fun writeUShort(value: UShort) = writeByBreak { endShared.middleBuffer.setWriteUShort(value) }

    override fun writeInt(value: Int) = writeByBreak { endShared.middleBuffer.setWriteInt(value) }

    override fun writeUInt(value: UInt) = writeByBreak { endShared.middleBuffer.setWriteUInt(value) }

    override fun writeLong(value: Long) = writeByBreak { endShared.middleBuffer.setWriteLong(value) }

    override fun writeULong(value: ULong) = writeByBreak { endShared.middleBuffer.setWriteULong(value) }

    override fun writeFloat(value: Float) = writeByBreak { endShared.middleBuffer.setWriteFloat(value) }

    override fun writeDouble(value: Double) = writeByBreak { endShared.middleBuffer.setWriteDouble(value) }

}

fun open(file: VirtualPath, mode: Mode ): FileIO {
    return PassThroughTransformer(Internals.openFile(file, mode),4096).assemble(
        { i ->  FileIO(i as PassThroughTransformer) },
        { e, i -> BlockDevice(e, i as PassThroughTransformer) }
    ) as FileIO
}