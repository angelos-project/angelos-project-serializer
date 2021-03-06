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
package org.angproj.io.serializer

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

interface ByteArrayFormat : SerializationFormat {
    fun <T> encodeToByteArray(serializer: SerializationStrategy<T>, value: T): ByteArray

    fun <T> decodeFromByteArray(deserializer: DeserializationStrategy<T>, array: ByteArray): T
}