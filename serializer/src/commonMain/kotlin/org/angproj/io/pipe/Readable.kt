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

interface Readable {
    /**
     * Read a byte.
     *
     * @return a byte of data
     */
    fun readByte(): Byte

    /**
     * Read an unsigned byte.
     *
     * @return an unsigned byte of data
     */
    fun readUByte(): UByte

    /**
     * Read a character.
     *
     * @return a character of data
     */
    fun readChar(): Char

    /**
     * Read a short integer.
     *
     * @return a short integer of data
     */
    fun readShort(): Short

    /**
     * Read an unsigned short integer.
     *
     * @return an unsigned short integer of data
     */
    fun readUShort(): UShort

    /**
     * Read an integer.
     *
     * @return an integer of data
     */
    fun readInt(): Int

    /**
     * Read an unsigned integer.
     *
     * @return an unsigned integer of data
     */
    fun readUInt(): UInt

    /**
     * Read a long integer.
     *
     * @return a long integer of data.
     */
    fun readLong(): Long

    /**
     * Read an unsigned long integer.
     *
     * @return an unsigned long integer of data
     */
    fun readULong(): ULong

    /**
     * Read a float.
     *
     * @return a float of data
     */
    fun readFloat(): Float

    /**
     * Read a double.
     *
     * @return a double of data
     */
    fun readDouble(): Double
}