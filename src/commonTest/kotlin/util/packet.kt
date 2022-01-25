package util

import com.github.cheatank.common.data.PacketData
import kotlin.test.assertNull

/**
 * 空のバイト配列の変換が行えるかのテスト
 */
fun <T : PacketData> assertEmptyPacketIsNull(converter: PacketData.Converter<T>) {
    assertNull(converter.fromByteArray(byteArrayOf()))
}

fun <T : PacketData> PacketData.Converter<T>.fromToByteArray(data: T): T? {
    return fromByteArray(toByteArray(data))
}
