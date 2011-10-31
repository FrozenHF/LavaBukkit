// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, Block, EnumDoor, World

public class ComponentStrongholdCrossing extends ComponentStronghold
{

    public ComponentStrongholdCrossing(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35025_h = j;
        field_35044_a = func_35031_a(random);
        field_35024_g = structureboundingbox;
        field_35042_b = random.nextBoolean();
        field_35043_c = random.nextBoolean();
        field_35040_d = random.nextBoolean();
        field_35041_e = random.nextBoolean();
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
        func_35028_a((ComponentStrongholdStairs2)structurecomponent, list, random, 5, 1);
        if(field_35042_b)
        {
            func_35032_b((ComponentStrongholdStairs2)structurecomponent, list, random, 3, 1);
        }
        if(field_35043_c)
        {
            func_35032_b((ComponentStrongholdStairs2)structurecomponent, list, random, 5, 7);
        }
        if(field_35040_d)
        {
            func_35029_c((ComponentStrongholdStairs2)structurecomponent, list, random, 3, 1);
        }
        if(field_35041_e)
        {
            func_35029_c((ComponentStrongholdStairs2)structurecomponent, list, random, 5, 7);
        }
    }

    public static ComponentStrongholdCrossing func_35039_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, -4, -3, 0, 10, 9, 11, l);
        if(!func_35030_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdCrossing(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(func_35013_a(world, structureboundingbox))
        {
            return false;
        }
        func_35022_a(world, structureboundingbox, 0, 0, 0, 9, 8, 10, true, random, StructureStrongholdPieces.func_35852_b());
        func_35033_a(world, random, structureboundingbox, field_35044_a, 4, 3, 0);
        if(field_35042_b)
        {
            func_35011_a(world, structureboundingbox, 0, 3, 1, 0, 5, 3, 0, 0, false);
        }
        if(field_35040_d)
        {
            func_35011_a(world, structureboundingbox, 9, 3, 1, 9, 5, 3, 0, 0, false);
        }
        if(field_35043_c)
        {
            func_35011_a(world, structureboundingbox, 0, 5, 7, 0, 7, 9, 0, 0, false);
        }
        if(field_35041_e)
        {
            func_35011_a(world, structureboundingbox, 9, 5, 7, 9, 7, 9, 0, 0, false);
        }
        func_35011_a(world, structureboundingbox, 5, 1, 10, 7, 3, 10, 0, 0, false);
        func_35022_a(world, structureboundingbox, 1, 2, 1, 8, 2, 6, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 4, 1, 5, 4, 4, 9, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 8, 1, 5, 8, 4, 9, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 1, 4, 7, 3, 4, 9, false, random, StructureStrongholdPieces.func_35852_b());
        func_35022_a(world, structureboundingbox, 1, 3, 5, 3, 3, 6, false, random, StructureStrongholdPieces.func_35852_b());
        func_35011_a(world, structureboundingbox, 1, 3, 4, 3, 3, 4, Block.stairSingle.blockID, Block.stairSingle.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 4, 6, 3, 4, 6, Block.stairSingle.blockID, Block.stairSingle.blockID, false);
        func_35022_a(world, structureboundingbox, 5, 1, 7, 7, 1, 8, false, random, StructureStrongholdPieces.func_35852_b());
        func_35011_a(world, structureboundingbox, 5, 1, 9, 7, 1, 9, Block.stairSingle.blockID, Block.stairSingle.blockID, false);
        func_35011_a(world, structureboundingbox, 5, 2, 7, 7, 2, 7, Block.stairSingle.blockID, Block.stairSingle.blockID, false);
        func_35011_a(world, structureboundingbox, 4, 5, 7, 4, 5, 9, Block.stairSingle.blockID, Block.stairSingle.blockID, false);
        func_35011_a(world, structureboundingbox, 8, 5, 7, 8, 5, 9, Block.stairSingle.blockID, Block.stairSingle.blockID, false);
        func_35011_a(world, structureboundingbox, 5, 5, 7, 7, 5, 9, Block.stairDouble.blockID, Block.stairDouble.blockID, false);
        func_35018_a(world, Block.torchWood.blockID, 0, 6, 5, 6, structureboundingbox);
        return true;
    }

    protected final EnumDoor field_35044_a;
    private boolean field_35042_b;
    private boolean field_35043_c;
    private boolean field_35040_d;
    private boolean field_35041_e;
}
