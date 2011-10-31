// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet107CreativeSetSlot extends Packet
{

    public Packet107CreativeSetSlot()
    {
    }

    public Packet107CreativeSetSlot(int i, int j, int k, int l)
    {
        field_35236_a = i;
        field_35234_b = j;
        field_35235_c = k;
        field_35233_d = l;
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.func_35781_a(this);
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        field_35236_a = datainputstream.readShort();
        field_35234_b = datainputstream.readShort();
        field_35235_c = datainputstream.readShort();
        field_35233_d = datainputstream.readShort();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(field_35236_a);
        dataoutputstream.writeShort(field_35234_b);
        dataoutputstream.writeShort(field_35235_c);
        dataoutputstream.writeShort(field_35233_d);
    }

    public int getPacketSize()
    {
        return 8;
    }

    public int field_35236_a;
    public int field_35234_b;
    public int field_35235_c;
    public int field_35233_d;
}
