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

import org.angproj.io.fs.Descriptor

/**
 * Intermittent executor for processing input and output according to TTY de facto standards.
 *
 * @constructor Create empty Intermittent executor
 */
open class IntermittentExecutor(descriptor: Descriptor) : Intermittent(descriptor)