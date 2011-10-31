// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet1Login extends Packet
{

    public Packet1Login()
    {
    }

    public Packet1Login(String s, int i)
    {
        username = s;
        protocolVersion = i;
    }

    public void readPacketData(DataInputStream datainputstream)
        throws IOException
    {
        protocolVersion = datainputstream.readInt();
        username = readString(datainputstream, 16);
        mapSeed = datainputstream.readLong();
        field_35249_d = datainputstream.readInt();
        field_35250_e = datainputstream.readByte();
        field_35247_f = datainputstream.readByte();
        field_35248_g = datainputstream.readByte();
        field_35251_h = datainputstream.readByte();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(protocolVersion);
        writeString(username, dataoutputstream);
        dataoutputstream.writeLong(mapSeed);
        dataoutputstream.writeInt(field_35249_d);
        dataoutputstream.writeByte(field_35250_e);
        dataoutputstream.writeByte(field_35247_f);
        dataoutputstream.writeByte(field_35248_g);
        dataoutputstream.writeByte(field_35251_h);
    }

    public void processPacket(NetHandler nethandler)
    {
        nethandler.handleLogin(this);
    }

    public int getPacketSize()
    {
        return 4 + username.length() + 4 + 7 + 4;
    }

    public int protocolVersion;
    public String username;
    public long mapSeed;
    public int field_35249_d;
    public byte field_35250_e;
    public byte field_35247_f;
    public byte field_35248_g;
    public byte field_35251_h;
}
