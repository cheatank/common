package com.github.cheatank.common.util

import com.github.cheatank.common.data.LocationData

/**
 * [ByteArray] から指定した [length] で整数値を取り出す。取り出せなければ null
 */
private fun ByteArray.read(length: Int, offset: Int): Int? {
    if ((size - offset) < length) return null
    var result = 0
    repeat(length) {
        result = result shl 8
        result = result or get(it + offset).toUByte().toInt()
    }
    return result
}

/**
 * [ByteArray] から [Short] のデータを取り出す。取り出せなければ null
 */
fun ByteArray.readShort(offset: Int): Short? {
    return read(2, offset)?.toShort()
}

/**
 * [ByteArray] から [Int] のデータを取り出す。取り出せなければ null
 */
fun ByteArray.readInt(offset: Int): Int? {
    return read(4, offset)
}
/**
 * [ByteArray] から [LocationData] のデータを取り出す。取り出せなければ null
 */
fun ByteArray.readLocationData(offset: Int): LocationData? {
    val id = readShort(offset) ?: return null
    val x = readInt(offset + 2) ?: return null
    val y = readInt(offset + 6) ?: return null
    val direction = readInt(offset + 10) ?: return null
    return LocationData(id, x, y, direction)
}

/**
 * [Short] を [ByteArray] として取得する
 */
fun Short.bytes() = byteArrayOf(
    ((toInt() shr 8) and 0xFF).toByte(),
    ((toInt() shr 0) and 0xFF).toByte()
)

/**
 * [Int] を [ByteArray] として取得する
 */
fun Int.bytes() = byteArrayOf(
    ((this shr 24) and 0xFF).toByte(),
    ((this shr 16) and 0xFF).toByte(),
    ((this shr 8) and 0xFF).toByte(),
    ((this shr 0) and 0xFF).toByte()
)
