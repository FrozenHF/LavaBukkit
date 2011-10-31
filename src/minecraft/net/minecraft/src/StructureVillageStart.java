// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStart, StructureVillagePieces, ComponentVillageStartPiece, World, 
//            StructureComponent, ComponentVillageRoadPiece

class StructureVillageStart extends StructureStart
{

    public StructureVillageStart(World world, Random random, int i, int j)
    {
        field_35718_c = false;
        int k = 0;
        ArrayList arraylist = StructureVillagePieces.func_35705_a(random, k);
        ComponentVillageStartPiece componentvillagestartpiece = new ComponentVillageStartPiece(world.getWorldChunkManager(), 0, random, (i << 4) + 2, (j << 4) + 2, arraylist, k);
        field_35717_a.add(componentvillagestartpiece);
        componentvillagestartpiece.func_35004_a(componentvillagestartpiece, field_35717_a, random);
        ArrayList arraylist1 = componentvillagestartpiece.field_35106_f;
        for(ArrayList arraylist2 = componentvillagestartpiece.field_35108_e; !arraylist1.isEmpty() || !arraylist2.isEmpty();)
        {
            if(!arraylist1.isEmpty())
            {
                int l = random.nextInt(arraylist1.size());
                StructureComponent structurecomponent = (StructureComponent)arraylist1.remove(l);
                structurecomponent.func_35004_a(componentvillagestartpiece, field_35717_a, random);
            } else
            {
                int i1 = random.nextInt(arraylist2.size());
                StructureComponent structurecomponent1 = (StructureComponent)arraylist2.remove(i1);
                structurecomponent1.func_35004_a(componentvillagestartpiece, field_35717_a, random);
            }
        }

        func_35714_b();
        int j1 = 0;
        Iterator iterator = field_35717_a.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureComponent structurecomponent2 = (StructureComponent)iterator.next();
            if(!(structurecomponent2 instanceof ComponentVillageRoadPiece))
            {
                j1++;
            }
        } while(true);
        field_35718_c = j1 > 2;
    }

    public boolean func_35715_c()
    {
        return field_35718_c;
    }

    private boolean field_35718_c;
}
