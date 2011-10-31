// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet9Respawn extends Packet
{

    public Packet9Respawn()
    {
    }

    public Packet9Respawn(byte byte0, byte byte1, long l, int i, int j)
    {
        field_35244_b = byte0;
        field_35245_c = byte1;
        field_35246_a = l;
        field_35242_d = i;
        field_35243_e = j;
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.handleRespawn(this);
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        field_35244_b = datainputstream.readByte();
        field_35245_c = datainputstream.readByte();
        field_35243_e = datainputstream.readByte();
        field_35242_d = datainputstream.readShort();
        field_35246_a = datainputstream.readLong();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_35244_b);
        dataoutputstream.writeByte(field_35245_c);
        dataoutputstream.writeByte(field_35243_e);
        dataoutputstream.writeShort(field_35242_d);
        dataoutputstream.writeLong(field_35246_a);
    }

    public int getPacketSize()
    {
        return 13;
    }

    public long field_35246_a;
    public int field_35244_b;
    public int field_35245_c;
    public int field_35242_d;
    public int field_35243_e;
}
