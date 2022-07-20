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
 * Intermittent interface of classes to be shared in between layers.
 *
 * @constructor Create empty Intermittent
 */
abstract class Intermittent(val descriptor: Descriptor) {
    var flip = Flipper.PAUSE

    @Suppress("NAME_SHADOWING")
    open fun <E0: EntryPoint<E1, *>, E1: EndPoint<E0, *>> assemble (
        entry: (i: Intermittent) -> E0,
        end: (e: E0, i: Intermittent) -> E1
    ) : E0 {
        val entry = entry(this)
        val end = end(entry, this)
        entry.endPoint = end
        return entry
    }
}