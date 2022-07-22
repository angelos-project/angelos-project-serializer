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
package org.angproj.io.pipe

interface Device : EndPoint<File, IntermittentTransformer> {
    fun doFlush()

    fun doTell(): Long

    fun doSeek(position: Long, whence: Seek): Long

    fun doTruncate(position: Long): Long

    fun doClose()

    fun forwardWrite()
}