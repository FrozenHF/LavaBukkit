// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenStructure, BiomeGenBase, ChunkCoordIntPair, World, 
//            WorldChunkManager, ChunkPosition, StructureStrongholdStart, StructureStart

public class MapGenStronghold extends MapGenStructure
{

    public MapGenStronghold()
    {
        field_35634_a = (new BiomeGenBase[] {
            BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.field_35483_e, BiomeGenBase.swampland
        });
        field_35633_g = new ChunkCoordIntPair[3];
    }

    protected boolean func_35628_a(int i, int j)
    {
        if(!field_35632_f)
        {
            rand.setSeed(field_35625_d.getRandomSeed());
            double d = rand.nextDouble() * 3.1415926535897931D * 2D;
            for(int l = 0; l < field_35633_g.length; l++)
            {
                double d1 = (1.25D + rand.nextDouble()) * 32D;
                int j1 = (int)Math.round(Math.cos(d) * d1);
                int k1 = (int)Math.round(Math.sin(d) * d1);
                ArrayList arraylist = new ArrayList();
                BiomeGenBase abiomegenbase[] = field_35634_a;
                int l1 = abiomegenbase.length;
                for(int i2 = 0; i2 < l1; i2++)
                {
                    BiomeGenBase biomegenbase = abiomegenbase[i2];
                    arraylist.add(biomegenbase);
                }

                ChunkPosition chunkposition = field_35625_d.getWorldChunkManager().func_35556_a((j1 << 4) + 8, (k1 << 4) + 8, 112, arraylist, rand);
                if(chunkposition != null)
                {
                    j1 = chunkposition.x >> 4;
                    k1 = chunkposition.z >> 4;
                } else
                {
                    System.out.println((new StringBuilder()).append("Placed stronghold in INVALID biome at (").append(j1).append(", ").append(k1).append(")").toString());
                }
                field_35633_g[l] = new ChunkCoordIntPair(j1, k1);
                d += 6.2831853071795862D / (double)field_35633_g.length;
            }

            field_35632_f = true;
        }
        ChunkCoordIntPair achunkcoordintpair[] = field_35633_g;
        int k = achunkcoordintpair.length;
        for(int i1 = 0; i1 < k; i1++)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[i1];
            if(i == chunkcoordintpair.chunkXPos && j == chunkcoordintpair.chunkZPos)
            {
                return true;
            }
        }

        return false;
    }

    protected StructureStart func_35630_b(int i, int j)
    {
        return new StructureStrongholdStart(field_35625_d, rand, i, j);
    }

    private BiomeGenBase field_35634_a[];
    private boolean field_35632_f;
    private ChunkCoordIntPair field_35633_g[];
}
