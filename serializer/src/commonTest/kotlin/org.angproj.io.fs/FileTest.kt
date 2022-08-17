package org.angproj.io.fs

import org.angproj.io.buf.stream.*
import org.angproj.io.err.AbstractError
import org.angproj.io.pipe.IOException
import org.angproj.io.pipe.Seek

fun open(path: VirtualPath, mode: Mode): FileImpl {

}

fun errorBySizePredicate(size: Int, msg: String, predicate: () -> Int): Int = when (val outcome = predicate()) {
    size -> throw IOException(AbstractError.error(msg).toString())
    else -> outcome
}

class FileImpl internal constructor(val path: Path, val descriptor: Descriptor, val mode: Mode) {
    // https://github.com/python/cpython/blob/main/Lib/_pyio.py

    private var _readable = false
    val readable: Boolean
        get() = _readable

    private var _writable = false
    val writable: Boolean
        get() = _writable

    private var _seekable = false
    val seekable: Boolean
        get() = _seekable


    private var _closed: Boolean = false
    val closed: Boolean
        get() = _closed

    init {
        _seekable = try {
            tell()
            true
        } catch (_: IOException) {
            false
        }
    }

    fun read(buffer: ImmutableNativeStreamBuffer, size: Int = buffer.limit) {
        require(buffer.limit >= size)
        check(!_closed) { "File descriptor is closed." }
        check(!_readable) { "File not open for reading." }

        val length = Internals.readFile(descriptor, buffer)
        buffer.flip(length)
        if(length != size){
            Internals.errorFile(descriptor)
            Internals.eofFile(descriptor)
        }
    }

    fun write(buffer: MutableNativeStreamBuffer) {
        check(!_closed) { "File descriptor is closed." }
        check(!_writable) { "File not open for writing." }

        errorBySizePredicate(buffer.limit, "Failed writing to file") {
            Internals.writeFile(descriptor, buffer)
        }
    }

    fun seek(position: Long, whence: Seek) {
        check(!_closed) { "File descriptor is closed." }

        when(Internals.seekFile(descriptor, position, whence)) {
            in 1..Long.MAX_VALUE -> throw IOException(AbstractError.error("Failed seek in file").toString())
            else -> Unit
        }
    }

    fun tell(): Long {
        check(!_closed) { "File descriptor is closed." }

        return when(val outcome = Internals.tellFile(descriptor)) {
            -1L -> throw IOException(AbstractError.error("Failed tell position in file").toString())
            else -> outcome
        }
    }

    fun truncate(position: Long) {
        check(!_writable) { "File not open for writing." }

        when(Internals.truncateFile(descriptor, position)) {
            -1 -> throw IOException(AbstractError.error("Failed to truncate file").toString())
            else -> Unit
        }
    }

    fun flush() {
        check(!_closed) { "File descriptor is closed." }

        when(Internals.flushFile(descriptor)) {
            in 1..Long.MAX_VALUE -> throw IOException(AbstractError.error("Failed to flush file").toString())
            else -> Unit
        }
    }

    fun fileNo(): Int {
        check(!_closed) { "File descriptor is closed." }
        return Internals.numberFile(descriptor)
    }

    fun close(): Unit = when(_closed) {
        false -> {
            flush()
            Internals.closeFile(descriptor)
            _closed = true
        }
        else -> Unit
    }
}

class FileTest {
}