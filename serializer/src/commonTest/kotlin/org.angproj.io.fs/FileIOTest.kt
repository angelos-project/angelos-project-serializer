package org.angproj.io.fs

import org.angproj.io.pipe.Seek
import kotlin.test.Test
import kotlin.test.assertEquals

class FileIOTest {

    fun getRandomBytes(size: Int): ByteArray {
        val data = ByteArray(size)
        for (index in data.indices) {
            data[index] = index.toByte()
        }
        data.shuffle()
        return data
    }

    @Test
    fun openFile() {
        val SIZE = 2048
        val data = getRandomBytes(SIZE)
        val file = open(VirtualPath("/tmp/test"), Mode.WRITE_PLUS_BIN)

        for (index in data.indices)
            file.writeByte(data[index])
        file.flush()

        assertEquals(file.tell(), SIZE.toLong())
        assertEquals(file.seek(0, Seek.SET), 0)

        val data2 = ByteArray(SIZE)
        for (index in data.indices) {
            data[index] = file.readByte()
        }

        assertEquals(data, data2)

        file.truncate(0)
        file.close()
    }

    companion object {
        const val BUFFER_SIZE = 4096
    }
}