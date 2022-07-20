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

class BlockDevice(entryPoint: File, entryShared: IntermittentTransformer) : AbstractDevice(entryPoint, entryShared) {

    override fun doTell(): Long = Internals.tellFile(entryShared.descriptor)

    override fun doSeek(position: Long, whence: Seek): Long {

    }

    override fun doTruncate(position: Long): Long {

    }
}