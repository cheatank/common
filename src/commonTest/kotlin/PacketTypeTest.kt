
import com.github.cheatank.common.PacketType
import com.github.cheatank.common.data.GameData
import com.github.cheatank.common.data.EmptyPacketData
import com.github.cheatank.common.data.IntData
import com.github.cheatank.common.data.LocationData
import com.github.cheatank.common.data.SelfLocationData
import com.github.cheatank.common.data.ShortData
import util.assertConvertedPacket
import kotlin.test.Test

class PacketTypeTest {
    @Test
    fun GetVersionPacket_can_be_converted() {
        assertConvertedPacket(PacketType.GetVersion, EmptyPacketData, 2)
    }

    @Test
    fun SendVersionPacket_can_be_converted() {
        assertConvertedPacket(PacketType.SendVersion, IntData(12), 6)
    }

    @Test
    fun JoinQueue_can_be_converted() {
        assertConvertedPacket(PacketType.JoinQueue, EmptyPacketData, 2)
    }

    @Test
    fun StartGamePacket_can_be_converted() {
        assertConvertedPacket(PacketType.StartGame, GameData(5, 3, 100), 7)
    }

    @Test
    fun CountdownPacket_can_be_converted() {
        assertConvertedPacket(PacketType.Countdown, ShortData(12), 4)
    }

    @Test
    fun EndGamePacket_can_be_converted() {
        assertConvertedPacket(PacketType.EndGame, ShortData(1), 4)
    }

    @Test
    fun UpdateLocationPacket_can_be_converted() {
        assertConvertedPacket(PacketType.UpdateLocation, LocationData(1, 2, 3, 4), 16)
    }

    @Test
    fun UpdateLocationSelfPacket_can_be_converted() {
        assertConvertedPacket(PacketType.UpdateSelfLocation, SelfLocationData(2, 3, 4), 14)
    }
}
