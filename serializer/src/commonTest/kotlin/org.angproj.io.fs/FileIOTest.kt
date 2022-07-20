package org.angproj.io.fs

import kotlin.test.Test

class FileIOTest {

    @Test
    fun openFile() {
        open(VirtualPath("/tmp/test"), Mode.WRITE_PLUS_BIN)
    }

    companion object {
        const val BUFFER_SIZE = 4096
    }
}