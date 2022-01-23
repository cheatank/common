import com.github.cheatank.common.data.ByteData
import com.github.cheatank.common.data.ConfigData
import com.github.cheatank.common.data.IntData
import com.github.cheatank.common.data.ShortData
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class PacketDataTest {
    @Test
    fun EmptyIntData_can_be_null() {
        assertNull(IntData.fromByteArray(byteArrayOf()))
    }

    @Test
    fun IntData_can_be_converted() {
        listOf(
            Int.MAX_VALUE,
            Int.MIN_VALUE,
            0,
        ).forEach {
            assertEquals(it, IntData.fromByteArray(IntData.toByteArray(IntData(it)))?.int)
        }
    }

    @Test
    fun EmptyShortata_can_be_null() {
        assertNull(ShortData.fromByteArray(byteArrayOf()))
    }

    @Test
    fun ShortData_can_be_converted() {
        listOf(
            Short.MAX_VALUE,
            Short.MIN_VALUE,
            0,
        ).forEach {
            assertEquals(it, ShortData.fromByteArray(ShortData.toByteArray(ShortData(it)))?.short)
        }
    }

    @Test
    fun EmptyByteData_can_be_null() {
        assertNull(ByteData.fromByteArray(byteArrayOf()))
    }

    @Test
    fun ByteData_can_be_converted() {
        listOf(
            Byte.MAX_VALUE,
            Byte.MIN_VALUE,
            0,
        ).forEach {
            assertEquals(it, ByteData.fromByteArray(ByteData.toByteArray(ByteData(it)))?.byte)
        }
    }

    @Test
    fun ConfigData_can_be_null() {
        assertNull(ConfigData.fromByteArray(byteArrayOf()))
    }

    @Test
    fun ConfigData_can_be_converted() {
        listOf(
            Byte.MAX_VALUE,
            Byte.MIN_VALUE,
            0,
        ).forEach { lifeCount ->
            listOf(
                Short.MAX_VALUE,
                Short.MIN_VALUE,
                0,
            ).forEach { timeLimit ->
                val data = ConfigData.fromByteArray(ConfigData.toByteArray(ConfigData(lifeCount, timeLimit)))
                assertEquals(lifeCount, data?.lifeCount)
                assertEquals(timeLimit, data?.timeLimit)
            }
        }
    }
}