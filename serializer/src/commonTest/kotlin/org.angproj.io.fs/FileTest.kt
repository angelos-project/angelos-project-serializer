package org.angproj.io.fs

import org.angproj.io.buf.Buffer
import org.angproj.io.buf.NativeBuffer
import org.angproj.io.buf.stream.nativeStreamByteBufferOf
import org.angproj.io.pipe.Seek

fun open(path: VirtualPath, mode: Mode): FileImpl {

}

class FileImpl internal constructor(val path: Path, val descriptor: Descriptor, val mode: Mode) {
    // https://github.com/python/cpython/blob/main/Lib/_pyio.py
    protected var _fd = -1
    protected var _created = false
    protected var _readable = false
    protected var _writable = false
    protected var _appending = false
    protected var _seekable = false
    protected var _closefd = true

    fun read(size: Int): NativeBuffer {
        checkClosed()
        checkReadable()

        val buffer = nativeStreamByteBufferOf(size)
        val length = Internals.readFile(descriptor, buffer)
        buffer.flip(length)
        return buffer
    }

    fun write(buffer: Buffer): Int {
        TODO("Not yet implemented")
    }

    val closed: Boolean
        get() = TODO("Not yet implemented")

    fun seek(position: Long, whence: Seek) {
        TODO("Not yet implemented")
    }

    fun tell(): Long {
        TODO("Not yet implemented")
    }

    fun truncate(position: Long): Long {
        TODO("Not yet implemented")
    }

    fun flush() {
        TODO("Not yet implemented")
    }

    fun close() {
        TODO("Not yet implemented")
    }

    fun isSeekable(): Boolean {
        return _seekable
    }

    fun isReadable(): Boolean {
        return _readable
    }

    fun isWritable(): Boolean {
        return _writable
    }

    fun isInteractive(): Boolean {
        return false
    }

    fun fileNo(): Int {
        TODO("Not yet implemented")
    }

    protected fun checkReadable() {
        if(!isReadable()) throw UnsupportedOperationException("File not open for reading.")
    }

    protected fun checkWritable() {
        if(!isWritable()) throw UnsupportedOperationException("File not open for writing.")
    }

    protected fun checkSeekable() {
        if(!isSeekable()) throw UnsupportedOperationException("File or stream is not seekable.")
    }

    protected fun checkClosed() {
        if(closed) throw UnsupportedOperationException("File descriptor is closed.")
    }
}

class FileTest {
}