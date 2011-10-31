// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet42RemoveEntityEffect extends Packet
{

    public Packet42RemoveEntityEffect()
    {
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        field_35253_a = datainputstream.readInt();
        field_35252_b = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_35253_a);
        dataoutputstream.writeByte(field_35252_b);
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.func_35783_a(this);
    }

    public int getPacketSize()
    {
        return 5;
    }

    public int field_35253_a;
    public byte field_35252_b;
}
