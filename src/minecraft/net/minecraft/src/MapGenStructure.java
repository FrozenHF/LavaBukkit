// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenBase, ChunkCoordIntPair, StructureStart, StructureBoundingBox, 
//            IChunkProvider, World

public abstract class MapGenStructure extends MapGenBase
{

    public MapGenStructure()
    {
        field_35631_e = new HashMap();
    }

    public void generate(IChunkProvider ichunkprovider, World world, int i, int j, byte abyte0[])
    {
        super.generate(ichunkprovider, world, i, j, abyte0);
    }

    protected void recursiveGenerate(World world, int i, int j, int k, int l, byte abyte0[])
    {
        if(field_35631_e.containsKey(Long.valueOf(ChunkCoordIntPair.chunkXZ2Int(i, j))))
        {
            return;
        }
        rand.nextInt();
        if(func_35628_a(i, j))
        {
            StructureStart structurestart = func_35630_b(i, j);
            field_35631_e.put(Long.valueOf(ChunkCoordIntPair.chunkXZ2Int(i, j)), structurestart);
        }
    }

    public boolean func_35629_a(World world, Random random, int i, int j)
    {
        int k = (i << 4) + 8;
        int l = (j << 4) + 8;
        boolean flag = false;
        Iterator iterator = field_35631_e.values().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureStart structurestart = (StructureStart)iterator.next();
            if(structurestart.func_35715_c() && structurestart.func_35712_a().func_35746_a(k, l, k + 15, l + 15))
            {
                structurestart.func_35711_a(world, random, new StructureBoundingBox(k, l, k + 15, l + 15));
                flag = true;
            }
        } while(true);
        return flag;
    }

    protected abstract boolean func_35628_a(int i, int j);

    protected abstract StructureStart func_35630_b(int i, int j);

    protected HashMap field_35631_e;
}
