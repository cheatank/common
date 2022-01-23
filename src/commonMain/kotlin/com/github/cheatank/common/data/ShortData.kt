package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readShort

/**
 * 2バイトデータ
 */
data class ShortData(val short: Short) : PacketData {
    companion object : PacketData.Converter<ShortData> {
        override fun toByteArray(data: ShortData): ByteArray {
            return data.short.bytes()
        }

        override fun fromByteArray(array: ByteArray): ShortData? {
            return array.readShort(0)?.let(::ShortData)
        }
    }
}
