package org.angproj.io.serializer

/**
 * Packer type
 *
 * The various sizes refers to:
 * SMALL: 0-(2^8-1) bytes
 * MEDIUM: 2^8-(2^16-1) bytes
 * LARGE: 2^16-(2^32-1) bytes
 * HUGE: 2^32-(2^63-1) bytes
 *
 * @constructor
 *
 * @param type
 */
enum class PackerType(type: Byte) {

    /**
     * Small array of bytes.
     *
     * @constructor Create empty ArrBytesSmall
     */
    ARR_BYTES_SMALL(0xF0.toByte()),

    /**
     * Medium array of bytes.
     *
     * @constructor Create empty ArrBytesMedium
     */
    ARR_BYTES_MEDIUM(0xF1.toByte()),

    /**
     * Large array of bytes.
     *
     * @constructor Create empty ArrBytesLarge
     */
    ARR_BYTES_LARGE(0xF2.toByte()),

    /**
     * Huge array of bytes.
     *
     * @constructor Create empty ArrBytesHuge
     */
    ARR_BYTES_HUGE(0xF3.toByte()),

    /**
     * Small UTF8 String
     *
     * @constructor Create empty StrUtf8Small
     */
    STR_UTF8_SMALL(0xF4.toByte()),

    /**
     * Medium UTF8 String
     *
     * @constructor Create empty StrUtf8Medium
     */
    STR_UTF8_MEDIUM(0xF5.toByte()),

    /**
     * Large UTF8 String
     *
     * @constructor Create empty StrUtf8Large
     */
    STR_UTF8_LARGE(0xF6.toByte()),

    /**
     * Huge UTF8 String
     *
     * @constructor Create empty StrUtf8Huge
     */
    STR_UTF8_HUGE(0xF7.toByte()),

    /**
     * Small UTF16 String
     *
     * @constructor Create empty StrUtf16Small
     */
    STR_UTF16_SMALL(0xF8.toByte()),

    /**
     * Medium UTF16 String
     *
     * @constructor Create empty StrUtf16Medium
     */
    STR_UTF16_MEDIUM(0xF9.toByte()),

    /**
     * Large UTF16 String
     *
     * @constructor Create empty StrUtf16Large
     */
    STR_UTF16_LARGE(0xFA.toByte()),

    /**
     * Huge UTF16 String
     *
     * @constructor Create empty StrUtf16Huge
     */
    STR_UTF16_HUGE(0xFB.toByte())
}