// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureVillagePieces, World, 
//            ComponentVillageStartPiece

abstract class ComponentVillage extends StructureComponent
{

    protected ComponentVillage(int i)
    {
        super(i);
    }

    protected StructureComponent func_35077_a(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 1, func_35012_c());

        case 0: // '\0'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35753_a - 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 1, func_35012_c());

        case 1: // '\001'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c - 1, 2, func_35012_c());

        case 3: // '\003'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c - 1, 2, func_35012_c());
        }
        return null;
    }

    protected StructureComponent func_35076_b(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j)
    {
        switch(field_35025_h)
        {
        case 2: // '\002'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 3, func_35012_c());

        case 0: // '\0'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35749_d + 1, field_35024_g.field_35751_b + i, field_35024_g.field_35752_c + j, 3, func_35012_c());

        case 1: // '\001'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35748_f + 1, 0, func_35012_c());

        case 3: // '\003'
            return StructureVillagePieces.func_35704_a(componentvillagestartpiece, list, random, field_35024_g.field_35753_a + j, field_35024_g.field_35751_b + i, field_35024_g.field_35748_f + 1, 0, func_35012_c());
        }
        return null;
    }

    protected int func_35075_b(World world, StructureBoundingBox structureboundingbox)
    {
        int i = 0;
        int j = 0;
        for(int k = field_35024_g.field_35752_c; k <= field_35024_g.field_35748_f; k++)
        {
            for(int l = field_35024_g.field_35753_a; l <= field_35024_g.field_35749_d; l++)
            {
                if(structureboundingbox.func_35742_b(l, 64, k))
                {
                    world.getClass();
                    i += Math.max(world.getTopSolidOrLiquidBlock(l, k), 63);
                    j++;
                }
            }

        }

        if(j == 0)
        {
            return -1;
        } else
        {
            return i / j;
        }
    }

    protected static boolean func_35074_a(StructureBoundingBox structureboundingbox)
    {
        return structureboundingbox != null && structureboundingbox.field_35751_b > 10;
    }
}
