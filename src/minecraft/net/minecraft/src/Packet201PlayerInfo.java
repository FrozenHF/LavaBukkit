// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet201PlayerInfo extends Packet
{

    public Packet201PlayerInfo()
    {
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        field_35257_a = readString(datainputstream, 16);
        field_35255_b = datainputstream.readByte() != 0;
        field_35256_c = datainputstream.readShort();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        writeString(field_35257_a, dataoutputstream);
        dataoutputstream.writeByte(field_35255_b ? 1 : 0);
        dataoutputstream.writeShort(field_35256_c);
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.func_35779_a(this);
    }

    public int getPacketSize()
    {
        return field_35257_a.length() + 2 + 1 + 2;
    }

    public String field_35257_a;
    public boolean field_35255_b;
    public int field_35256_c;
}
