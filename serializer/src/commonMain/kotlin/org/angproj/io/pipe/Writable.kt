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

interface Writable {
    /**
     * Write a byte.
     *
     * @param value a byte of data
     */
    fun writeByte(value: Byte)

    /**
     * Write an unsigned byte.
     *
     * @param value an unsigned byte of data
     */
    fun writeUByte(value: UByte)

    /**
     * Write a character.
     *
     * @param value a character of data
     */
    fun writeChar(value: Char)

    /**
     * Write a short integer.
     *
     * @param value a short integer of data.
     */
    fun writeShort(value: Short)

    /**
     * Write an unsigned short integer.
     *
     * @param value an unsigned short integer of data.
     */
    fun writeUShort(value: UShort)

    /**
     * Write an integer.
     *
     * @param value an integer of data
     */
    fun writeInt(value: Int)

    /**
     * Write an unsigned integer.
     *
     * @param value an unsigned integer of data
     */
    fun writeUInt(value: UInt)

    /**
     * Write a long integer.
     *
     * @param value a long integer of data
     */
    fun writeLong(value: Long)

    /**
     * Write an unsigned long integer.
     *
     * @param value an unsigned long integer of data
     */
    fun writeULong(value: ULong)

    /**
     * Write a float.
     *
     * @param value a float of data
     */
    fun writeFloat(value: Float)

    /**
     * Write a double.
     *
     * @param value a double of data
     */
    fun writeDouble(value: Double)
}