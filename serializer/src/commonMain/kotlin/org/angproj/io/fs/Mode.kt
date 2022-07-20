/**
 * Copyright (c) 2021 by Kristoffer Paulsson <kristoffer.paulsson@talenten.se>.
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

/**
Code	Mode	Type	Create	Truncate
r	    RO	    TXT	    FALSE	FALSE
w	    WO	    TXT	    TRUE	TRUE
a	    AO	    TXT	    TRUE	FALSE
r+	    RW	    TXT	    FALSE	FALSE
w+	    RW	    TXT	    TRUE	TRUE
a+	    AO	    TXT	    TRUE	FALSE
rb	    RO	    BIN	    FALSE	FALSE
wb	    WO	    BIN	    TRUE	TRUE
ab	    AO	    BIN	    TRUE	FALSE
rb+	    RW	    BIN	    FALSE	FALSE
wb+	    RW	    BIN	    TRUE	TRUE
ab+	    AO	    BIN	    TRUE	FALSE
 */

enum class Mode(val mode: String) {

    /**
     * Open existing text file as READ_ONLY positioned at the beginning.
     *
     * @constructor Create empty Read Only Txt
     */
    READ_ONLY_TXT("r"),

    /**
     * Open existing text file truncated or create a new one as WRITE_ONLY positioned at the beginning.
     *
     * @constructor Create empty Write Only Txt
     */
    WRITE_ONLY_TXT("w"),

    /**
     * Append existing text file or create a new one as APPENDING positioned at the end.
     *
     * @constructor Create empty Appending Txt
     */
    APPENDING_TXT("a"),

    /**
     * Open existing text file as READ & WRITE positioned at the beginning.
     *
     * @constructor Create empty Read Plus Txt
     */
    READ_PLUS_TXT("r+"),

    /**
     * Open existing text file truncated or create a new one as READ & WRITE positioned at the beginning.
     *
     * @constructor Create empty Write Plus Txt
     */
    WRITE_PLUS_TXT("w+"),

    /**
     * Append existing text file or create a new one as READ & WRITE positioned at the end. (?)
     *
     * @constructor Create empty Append Plus Txt
     */
    APPEND_PLUS_TXT("a+"),

    /**
     * Open existing binary file as READ_ONLY positioned at the beginning.
     *
     * @constructor Create empty Read Only Bin
     */
    READ_ONLY_BIN("rb"),

    /**
     * Open existing binary file truncated or create a new one as WRITE_ONLY positioned at the beginning.
     *
     * @constructor Create empty Write Only Bin
     */
    WRITE_ONLY_BIN("wb"),

    /**
     * Append binary file or create a new one as APPENDING positioned at the end.
     *
     * @constructor Create empty Appending Bin
     */
    APPENDING_BIN("ab"),

    /**
     * Open existing binary file as READ & WRITE positioned at the beginning.
     *
     * @constructor Create empty Read Plus Bin
     */
    READ_PLUS_BIN("rb+"),

    /**
     * Open existing binary file truncated or create a new one as READ & WRITE positioned at the beginning.
     *
     * @constructor Create empty Write Plus Bin
     */
    WRITE_PLUS_BIN("wb+"),

    /**
     * Append existing binary file or create a new one as READ & WRITE positioned at the end. (?)
     *
     * @constructor Create empty Append Plus Bin
     */
    APPEND_PLUS_BIN("ab+"),
}