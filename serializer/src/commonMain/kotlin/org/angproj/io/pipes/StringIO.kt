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
package org.angproj.io.pipes

class StringIO : TextIOBase {
    override val encodings: String
        get() = TODO("Not yet implemented")
    override val newLine: Char
        get() = TODO("Not yet implemented")

    fun getValue(): ByteArray {
        TODO("Not yet implemented")
    }

    override fun detach(): RawIOBase {
        TODO("Not yet implemented")
    }
}