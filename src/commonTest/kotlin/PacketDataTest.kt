import com.github.cheatank.common.data.ByteData
import com.github.cheatank.common.data.GameData
import com.github.cheatank.common.data.IntData
import com.github.cheatank.common.data.LocationData
import com.github.cheatank.common.data.SelfLocationData
import com.github.cheatank.common.data.ShortData
import util.assertEmptyPacketIsNull
import util.fromToByteArray
import util.repeatByte
import util.repeatGameData
import util.repeatInt
import util.repeatLocationData
import util.repeatSelfLocationData
import util.repeatShort
import kotlin.test.Test
import kotlin.test.assertEquals

class PacketDataTest {
    @Test
    fun IntData_can_be_converted() {
        assertEmptyPacketIsNull(IntData)
        repeatInt {
            assertEquals(it, IntData.fromToByteArray(IntData(it))?.int)
        }
    }

    @Test
    fun ShortData_can_be_converted() {
        assertEmptyPacketIsNull(ShortData)
        repeatShort {
            assertEquals(it, ShortData.fromToByteArray(ShortData(it))?.short)
        }
    }

    @Test
    fun ByteData_can_be_converted() {
        assertEmptyPacketIsNull(ByteData)
        repeatByte {
            assertEquals(it, ByteData.fromToByteArray(ByteData(it))?.byte)
        }
    }

    @Test
    fun GameData_can_be_converted() {
        assertEmptyPacketIsNull(GameData)
        repeatGameData {
            assertEquals(it, GameData.fromToByteArray(it))
        }
    }

    @Test
    fun LocationData_can_be_converted() {
        assertEmptyPacketIsNull(LocationData)
        repeatLocationData {
            assertEquals(it, LocationData.fromToByteArray(it))
        }
    }

    @Test
    fun SelfLocationData_can_be_converted() {
        assertEmptyPacketIsNull(SelfLocationData)
        repeatSelfLocationData {
            assertEquals(it, SelfLocationData.fromToByteArray(it))
        }
    }
}
