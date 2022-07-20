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

import org.angproj.io.pipe.Flipper
import org.angproj.io.pipe.IntermittentTransformer

class BlockTransformer(descriptor: Descriptor, bufferSize: Int) : IntermittentTransformer(descriptor, bufferSize) {

    protected fun flipModeRead() { flip = Flipper.READ }

    protected fun flipModeWrite() { flip = Flipper.WRITE }
}