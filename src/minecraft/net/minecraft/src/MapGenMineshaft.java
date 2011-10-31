// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, StructureMineshaftStart, StructureStart

public class MapGenMineshaft extends MapGenStructure
{

    public MapGenMineshaft()
    {
    }

    protected boolean func_35628_a(int i, int j)
    {
        return rand.nextInt(80) == 0 && rand.nextInt(80) < Math.max(Math.abs(i), Math.abs(j));
    }

    protected StructureStart func_35630_b(int i, int j)
    {
        return new StructureMineshaftStart(field_35625_d, rand, i, j);
    }
}
