package util

import com.github.cheatank.common.data.GameData

fun repeatByte(action: (Byte) -> Unit) {
    listOf(Byte.MAX_VALUE, Byte.MIN_VALUE, 0).forEach(action)
}

fun repeatShort(action: (Short) -> Unit) {
    listOf(Short.MAX_VALUE, Short.MIN_VALUE, 0).forEach(action)
}

fun repeatInt(action: (Int) -> Unit) {
    listOf(Int.MAX_VALUE, Int.MIN_VALUE, 0).forEach(action)
}

fun repeatGameData(action: (GameData) -> Unit) {
    repeatShort { id ->
        repeatByte { lifeCount ->
            repeatShort { timeLimit ->
                action(GameData(id, lifeCount, timeLimit))
            }
        }
    }
}
