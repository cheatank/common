package com.github.cheatank.common.data

import com.github.cheatank.common.util.bytes
import com.github.cheatank.common.util.readShort

/**
 * ゲームの設定
 *
 * @see com.github.cheatank.common.PacketType.StartGame
 */
data class GameData(
    val id: Short,
    val lifeCount: Byte,
    val timeLimit: Short,
) : PacketData {
    companion object : PacketData.Converter<GameData> {
        override fun toByteArray(data: GameData): ByteArray {
            return byteArrayOf(
                *data.id.bytes(),
                data.lifeCount,
                *data.timeLimit.bytes(),
            )
        }

        override fun fromByteArray(array: ByteArray): GameData? {
            val id = array.readShort(0) ?: return null
            val lifeCount = array.getOrNull(2) ?: return null
            val timeLimit = array.readShort(3) ?: return null
            return GameData(id, lifeCount, timeLimit)
        }
    }
}
