// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet43Experience extends Packet
{

    public Packet43Experience()
    {
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        field_35230_a = datainputstream.readByte();
        field_35229_c = datainputstream.readByte();
        field_35228_b = datainputstream.readShort();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(field_35230_a);
        dataoutputstream.writeByte(field_35229_c);
        dataoutputstream.writeShort(field_35228_b);
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.func_35777_a(this);
    }

    public int getPacketSize()
    {
        return 4;
    }

    public int field_35230_a;
    public int field_35228_b;
    public int field_35229_c;
}
