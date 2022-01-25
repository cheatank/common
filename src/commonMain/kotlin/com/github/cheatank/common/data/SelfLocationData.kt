package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readSelfLocationData

/**
 * プレイヤーの位置情報
 *
 * @property x x座標
 * @property y y座標
 * @property yaw 銃口の角度
 *
 * @see com.github.cheatank.common.PacketType.UpdateSelfLocation
 */
data class SelfLocationData(
    val x: Int,
    val y: Int,
    val yaw: Int,
) : PacketData {
    companion object : PacketData.Converter<SelfLocationData> {
        override fun toByteArray(data: SelfLocationData): ByteArray {
            return byteArrayOf(
                *data.x.bytes(),
                *data.y.bytes(),
                *data.yaw.bytes(),
            )
        }

        override fun fromByteArray(array: ByteArray): SelfLocationData? {
            return array.readSelfLocationData(0)
        }
    }
}
