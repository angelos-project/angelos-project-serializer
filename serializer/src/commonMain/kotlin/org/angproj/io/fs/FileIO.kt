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
        TODO("Not yet implemented")
    }

    fun <T: Serializable> write(info: T): Int {
        TODO("Not yet implemented")
    }

    fun flush() {
        TODO("Not yet implemented")
    }

    fun tell(): Long = endPoint.doTell()

    fun seek(position: Long, whence: Seek): Long {
        TODO("Not yet implemented")
    }

    fun truncate(position: Long): Long {
        TODO("Not yet implemented")
    }

    fun close() {
        TODO("Not yet implemented")
    }

    fun isReadable(): Boolean {
        TODO("Not yet implemented")
    }

    fun isWritable(): Boolean {
        TODO("Not yet implemented")
    }

    fun isSeekable(): Boolean {
        TODO("Not yet implemented")
    }

    fun isInteractive(): Boolean = false

}

fun open(file: VirtualPath, mode: Mode ): FileIO {
    return PassThroughTransformer(Internals.openFile(file, mode),4096).assemble(
        { i ->  FileIO(i as PassThroughTransformer) },
        { e, i -> BlockDevice(e, i as PassThroughTransformer) }
    ) as FileIO
}