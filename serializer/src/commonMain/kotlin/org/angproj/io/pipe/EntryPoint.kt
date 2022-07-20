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

import kotlin.reflect.KProperty

/**
 * Entrypoint for IO operations.
 *
 * @constructor Create empty Entry point
 */
interface EntryPoint<P: Intermix, S: Intermittent> : Intermix {
    var endPoint: P
    val endShared: S

    /**
     * Attach works as a delegate for later attachment of the EndPoint
     * to simplify complex initialization of a build.
     *
     * @param EndPoint<P: Intermix, S: Intermittent>
     * @constructor Create empty Attach
     */
    class Attach<P> {
        private var _value: P? = null
        operator fun getValue(thisRef: Any?, property: KProperty<*>): P = _value ?: error("Must be set first.")
        operator fun setValue(thisRef: Intermix, property: KProperty<*>, value: P) = when (_value ) {
            null -> _value = value
            else -> error("Can only be set once.")
        }
    }
}