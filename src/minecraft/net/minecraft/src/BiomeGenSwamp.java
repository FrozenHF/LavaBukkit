// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, BiomeDecorator, WorldGenerator

public class BiomeGenSwamp extends BiomeGenBase
{

    protected BiomeGenSwamp(int i)
    {
        super(i);
        field_35488_u.field_35911_r = 2;
        field_35488_u.field_35910_s = -999;
        field_35488_u.field_35908_u = 1;
        field_35488_u.field_35907_v = 8;
        field_35488_u.field_35906_w = 10;
        field_35488_u.field_35888_A = 1;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        return field_35482_C;
    }
}
