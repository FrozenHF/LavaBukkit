// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityXPOrb, MathHelper, NetHandler

public class Packet26EntityExpOrb extends Packet
{

    public Packet26EntityExpOrb()
    {
    }

    public Packet26EntityExpOrb(EntityXPOrb entityxporb)
    {
        field_35241_a = entityxporb.entityId;
        field_35239_b = MathHelper.floor_double(entityxporb.posX * 32D);
        field_35240_c = MathHelper.floor_double(entityxporb.posY * 32D);
        field_35237_d = MathHelper.floor_double(entityxporb.posZ * 32D);
        field_35238_e = entityxporb.func_35119_j_();
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        field_35241_a = datainputstream.readInt();
        field_35239_b = datainputstream.readInt();
        field_35240_c = datainputstream.readInt();
        field_35237_d = datainputstream.readInt();
        field_35238_e = datainputstream.readShort();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(field_35241_a);
        dataoutputstream.writeInt(field_35239_b);
        dataoutputstream.writeInt(field_35240_c);
        dataoutputstream.writeInt(field_35237_d);
        dataoutputstream.writeShort(field_35238_e);
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.func_35778_a(this);
    }

    public int getPacketSize()
    {
        return 18;
    }

    public int field_35241_a;
    public int field_35239_b;
    public int field_35240_c;
    public int field_35237_d;
    public int field_35238_e;
}
