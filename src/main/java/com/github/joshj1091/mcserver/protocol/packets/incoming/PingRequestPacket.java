package com.github.joshj1091.mcserver.protocol.packets.incoming;

import com.github.joshj1091.mcserver.protocol.IncomingPacket;
import com.github.joshj1091.mcserver.util.ByteReader;

import java.util.Arrays;

/**
 * This class represents the ping request packet from the client.
 * <p>
 * Standard Packet Format
 * <p>
 * | Field            | Data Type      |
 * -------------------------------------
 * | Packet Size      | VarInt         |
 * | Packet ID        | VarInt         |
 * | Data             | Byte Array     |
 * <p>
 * <p>
 * Ping Request Data Format
 * <p>
 * | Field            | Data Type      |
 * -------------------------------------
 * | Long             | Long           |
 */
public class PingRequestPacket extends IncomingPacket {

    private byte[] longBytes;

    public PingRequestPacket(ByteReader reader) {
        super(reader.getData());

        this.longBytes = Arrays.copyOfRange(reader.getData(), 1, getData().length); // this should always be 8 bytes
    }

    /**
     * The bytes that represent the long sent from the Minecraft client
     *
     * @return the bytes in an array
     */
    public byte[] getLongBytes() {
        return longBytes;
    }

    public int getId() {
        return 0x01;
    }
}
