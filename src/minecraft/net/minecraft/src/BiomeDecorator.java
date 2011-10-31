// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenClay, WorldGenSand, Block, WorldGenMinable, 
//            WorldGenFlowers, BlockFlower, WorldGenReed, WorldGenCactus, 
//            World, WorldGenerator, BiomeGenBase, WorldGenTallGrass, 
//            BlockTallGrass, WorldGenDeadBush, BlockDeadBush, WorldGenPumpkin, 
//            WorldGenLiquids

public class BiomeDecorator
{

    public BiomeDecorator(BiomeGenBase biomegenbase)
    {
        field_35897_a = new WorldGenClay(4);
        field_35895_b = new WorldGenSand(7, Block.sand.blockID);
        field_35896_c = new WorldGenSand(6, Block.gravel.blockID);
        field_35893_d = new WorldGenMinable(Block.dirt.blockID, 32);
        field_35894_e = new WorldGenMinable(Block.gravel.blockID, 32);
        field_35891_f = new WorldGenMinable(Block.oreCoal.blockID, 16);
        field_35892_g = new WorldGenMinable(Block.oreIron.blockID, 8);
        field_35904_h = new WorldGenMinable(Block.oreGold.blockID, 8);
        field_35905_i = new WorldGenMinable(Block.oreRedstone.blockID, 7);
        field_35902_j = new WorldGenMinable(Block.oreDiamond.blockID, 7);
        field_35903_k = new WorldGenMinable(Block.oreLapis.blockID, 6);
        field_35900_l = new WorldGenFlowers(Block.plantYellow.blockID);
        field_35901_m = new WorldGenFlowers(Block.plantYellow.blockID);
        field_35898_n = new WorldGenFlowers(Block.mushroomBrown.blockID);
        field_35899_o = new WorldGenFlowers(Block.mushroomRed.blockID);
        field_35913_p = new WorldGenReed();
        field_35912_q = new WorldGenCactus();
        field_35911_r = 0;
        field_35910_s = 2;
        field_35909_t = 1;
        field_35908_u = 0;
        field_35907_v = 0;
        field_35906_w = 0;
        field_35916_x = 0;
        field_35915_y = 1;
        field_35914_z = 3;
        field_35888_A = 1;
        field_35887_F = biomegenbase;
    }

    public void func_35881_a(World world, Random random, int i, int j)
    {
        if(field_35889_B != null)
        {
            throw new RuntimeException("Already decorating!!");
        } else
        {
            field_35889_B = world;
            field_35890_C = random;
            field_35885_D = i;
            field_35886_E = j;
            func_35882_b();
            field_35889_B = null;
            field_35890_C = null;
            return;
        }
    }

    private void func_35882_b()
    {
        func_35880_a();
        for(int i = 0; i < field_35914_z; i++)
        {
            int i1 = field_35885_D + field_35890_C.nextInt(16) + 8;
            int i5 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35895_b.generate(field_35889_B, field_35890_C, i1, field_35889_B.getTopSolidOrLiquidBlock(i1, i5), i5);
        }

        for(int j = 0; j < field_35888_A; j++)
        {
            int j1 = field_35885_D + field_35890_C.nextInt(16) + 8;
            int j5 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35897_a.generate(field_35889_B, field_35890_C, j1, field_35889_B.getTopSolidOrLiquidBlock(j1, j5), j5);
        }

        for(int k = 0; k < field_35915_y; k++)
        {
            int k1 = field_35885_D + field_35890_C.nextInt(16) + 8;
            int k5 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35895_b.generate(field_35889_B, field_35890_C, k1, field_35889_B.getTopSolidOrLiquidBlock(k1, k5), k5);
        }

        int l = field_35911_r;
        if(field_35890_C.nextInt(10) == 0)
        {
            l++;
        }
        for(int l1 = 0; l1 < l; l1++)
        {
            int l5 = field_35885_D + field_35890_C.nextInt(16) + 8;
            int k9 = field_35886_E + field_35890_C.nextInt(16) + 8;
            WorldGenerator worldgenerator = field_35887_F.getRandomWorldGenForTrees(field_35890_C);
            worldgenerator.func_517_a(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(field_35889_B, field_35890_C, l5, field_35889_B.getHeightValue(l5, k9), k9);
        }

        for(int i2 = 0; i2 < field_35910_s; i2++)
        {
            int i6 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int l9 = field_35890_C.nextInt(128);
            int j13 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35900_l.generate(field_35889_B, field_35890_C, i6, l9, j13);
            if(field_35890_C.nextInt(4) == 0)
            {
                int j6 = field_35885_D + field_35890_C.nextInt(16) + 8;
                field_35889_B.getClass();
                int i10 = field_35890_C.nextInt(128);
                int k13 = field_35886_E + field_35890_C.nextInt(16) + 8;
                field_35901_m.generate(field_35889_B, field_35890_C, j6, i10, k13);
            }
        }

        for(int j2 = 0; j2 < field_35909_t; j2++)
        {
            int k6 = 1;
            int j10 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int l13 = field_35890_C.nextInt(128);
            int i16 = field_35886_E + field_35890_C.nextInt(16) + 8;
            (new WorldGenTallGrass(Block.tallGrass.blockID, k6)).generate(field_35889_B, field_35890_C, j10, l13, i16);
        }

        for(int k2 = 0; k2 < field_35908_u; k2++)
        {
            int l6 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int k10 = field_35890_C.nextInt(128);
            int i14 = field_35886_E + field_35890_C.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.deadBush.blockID)).generate(field_35889_B, field_35890_C, l6, k10, i14);
        }

        for(int l2 = 0; l2 < field_35907_v; l2++)
        {
            if(field_35890_C.nextInt(4) == 0)
            {
                int i7 = field_35885_D + field_35890_C.nextInt(16) + 8;
                int l10 = field_35886_E + field_35890_C.nextInt(16) + 8;
                int j14 = field_35889_B.getHeightValue(i7, l10);
                field_35898_n.generate(field_35889_B, field_35890_C, i7, j14, l10);
            }
            if(field_35890_C.nextInt(8) == 0)
            {
                int j7 = field_35885_D + field_35890_C.nextInt(16) + 8;
                int i11 = field_35886_E + field_35890_C.nextInt(16) + 8;
                field_35889_B.getClass();
                int k14 = field_35890_C.nextInt(128);
                field_35899_o.generate(field_35889_B, field_35890_C, j7, k14, i11);
            }
        }

        if(field_35890_C.nextInt(4) == 0)
        {
            int i3 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int k7 = field_35890_C.nextInt(128);
            int j11 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35898_n.generate(field_35889_B, field_35890_C, i3, k7, j11);
        }
        if(field_35890_C.nextInt(8) == 0)
        {
            int j3 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int l7 = field_35890_C.nextInt(128);
            int k11 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35899_o.generate(field_35889_B, field_35890_C, j3, l7, k11);
        }
        for(int k3 = 0; k3 < field_35906_w; k3++)
        {
            int i8 = field_35885_D + field_35890_C.nextInt(16) + 8;
            int l11 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int l14 = field_35890_C.nextInt(128);
            field_35913_p.generate(field_35889_B, field_35890_C, i8, l14, l11);
        }

        for(int l3 = 0; l3 < 10; l3++)
        {
            int j8 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int i12 = field_35890_C.nextInt(128);
            int i15 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35913_p.generate(field_35889_B, field_35890_C, j8, i12, i15);
        }

        if(field_35890_C.nextInt(32) == 0)
        {
            int i4 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int k8 = field_35890_C.nextInt(128);
            int j12 = field_35886_E + field_35890_C.nextInt(16) + 8;
            (new WorldGenPumpkin()).generate(field_35889_B, field_35890_C, i4, k8, j12);
        }
        for(int j4 = 0; j4 < field_35916_x; j4++)
        {
            int l8 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int k12 = field_35890_C.nextInt(128);
            int j15 = field_35886_E + field_35890_C.nextInt(16) + 8;
            field_35912_q.generate(field_35889_B, field_35890_C, l8, k12, j15);
        }

        for(int k4 = 0; k4 < 50; k4++)
        {
            int i9 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int l12 = field_35890_C.nextInt(field_35890_C.nextInt(128 - 8) + 8);
            int k15 = field_35886_E + field_35890_C.nextInt(16) + 8;
            (new WorldGenLiquids(Block.waterMoving.blockID)).generate(field_35889_B, field_35890_C, i9, l12, k15);
        }

        for(int l4 = 0; l4 < 20; l4++)
        {
            int j9 = field_35885_D + field_35890_C.nextInt(16) + 8;
            field_35889_B.getClass();
            int i13 = field_35890_C.nextInt(field_35890_C.nextInt(field_35890_C.nextInt(128 - 16) + 8) + 8);
            int l15 = field_35886_E + field_35890_C.nextInt(16) + 8;
            (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(field_35889_B, field_35890_C, j9, i13, l15);
        }

    }

    protected void func_35884_a(int i, WorldGenerator worldgenerator, int j, int k)
    {
        for(int l = 0; l < i; l++)
        {
            int i1 = field_35885_D + field_35890_C.nextInt(16);
            int j1 = field_35890_C.nextInt(k - j) + j;
            int k1 = field_35886_E + field_35890_C.nextInt(16);
            worldgenerator.generate(field_35889_B, field_35890_C, i1, j1, k1);
        }

    }

    protected void func_35883_b(int i, WorldGenerator worldgenerator, int j, int k)
    {
        for(int l = 0; l < i; l++)
        {
            int i1 = field_35885_D + field_35890_C.nextInt(16);
            int j1 = field_35890_C.nextInt(k) + field_35890_C.nextInt(k) + (j - k);
            int k1 = field_35886_E + field_35890_C.nextInt(16);
            worldgenerator.generate(field_35889_B, field_35890_C, i1, j1, k1);
        }

    }

    protected void func_35880_a()
    {
        field_35889_B.getClass();
        func_35884_a(20, field_35893_d, 0, 128);
        field_35889_B.getClass();
        func_35884_a(10, field_35894_e, 0, 128);
        field_35889_B.getClass();
        func_35884_a(20, field_35891_f, 0, 128);
        field_35889_B.getClass();
        func_35884_a(20, field_35892_g, 0, 128 / 2);
        field_35889_B.getClass();
        func_35884_a(2, field_35904_h, 0, 128 / 4);
        field_35889_B.getClass();
        func_35884_a(8, field_35905_i, 0, 128 / 8);
        field_35889_B.getClass();
        func_35884_a(1, field_35902_j, 0, 128 / 8);
        field_35889_B.getClass();
        field_35889_B.getClass();
        func_35883_b(1, field_35903_k, 128 / 8, 128 / 8);
    }

    private World field_35889_B;
    private Random field_35890_C;
    private int field_35885_D;
    private int field_35886_E;
    private BiomeGenBase field_35887_F;
    protected WorldGenerator field_35897_a;
    protected WorldGenerator field_35895_b;
    protected WorldGenerator field_35896_c;
    protected WorldGenerator field_35893_d;
    protected WorldGenerator field_35894_e;
    protected WorldGenerator field_35891_f;
    protected WorldGenerator field_35892_g;
    protected WorldGenerator field_35904_h;
    protected WorldGenerator field_35905_i;
    protected WorldGenerator field_35902_j;
    protected WorldGenerator field_35903_k;
    protected WorldGenerator field_35900_l;
    protected WorldGenerator field_35901_m;
    protected WorldGenerator field_35898_n;
    protected WorldGenerator field_35899_o;
    protected WorldGenerator field_35913_p;
    protected WorldGenerator field_35912_q;
    protected int field_35911_r;
    protected int field_35910_s;
    protected int field_35909_t;
    protected int field_35908_u;
    protected int field_35907_v;
    protected int field_35906_w;
    protected int field_35916_x;
    protected int field_35915_y;
    protected int field_35914_z;
    protected int field_35888_A;
}
