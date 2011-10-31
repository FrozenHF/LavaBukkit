// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureVillagePieceWeight, ComponentVillageHouse4_Garden, MathHelper, ComponentVillageChurch, 
//            ComponentVillageHouse1, ComponentVillageWoodHut, ComponentVillageHall, ComponentVillageField, 
//            ComponentVillageField2, ComponentVillageHouse2, ComponentVillageHouse3, ComponentVillageStartPiece, 
//            ComponentVillageTorch, StructureBoundingBox, StructureComponent, MapGenVillage, 
//            WorldChunkManager, ComponentVillagePathGen, ComponentVillage

public class StructureVillagePieces
{

    public StructureVillagePieces()
    {
    }

    public static ArrayList func_35705_a(Random random, int i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse4_Garden.class, 4, MathHelper.func_35598_a(random, 2 + i, 4 + i * 2)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageChurch.class, 20, MathHelper.func_35598_a(random, 0 + i, 1 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse1.class, 20, MathHelper.func_35598_a(random, 0 + i, 2 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageWoodHut.class, 3, MathHelper.func_35598_a(random, 2 + i, 5 + i * 3)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHall.class, 15, MathHelper.func_35598_a(random, 0 + i, 2 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageField.class, 3, MathHelper.func_35598_a(random, 1 + i, 4 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageField2.class, 3, MathHelper.func_35598_a(random, 2 + i, 4 + i * 2)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse2.class, 15, MathHelper.func_35598_a(random, 0, 1 + i)));
        arraylist.add(new StructureVillagePieceWeight(net.minecraft.src.ComponentVillageHouse3.class, 8, MathHelper.func_35598_a(random, 0 + i, 3 + i * 2)));
        Iterator iterator = arraylist.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            if(((StructureVillagePieceWeight)iterator.next()).field_35604_d == 0)
            {
                iterator.remove();
            }
        } while(true);
        return arraylist;
    }

    private static int func_35703_a(ArrayList arraylist)
    {
        boolean flag = false;
        int i = 0;
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            StructureVillagePieceWeight structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();
            if(structurevillagepieceweight.field_35604_d > 0 && structurevillagepieceweight.field_35606_c < structurevillagepieceweight.field_35604_d)
            {
                flag = true;
            }
            i += structurevillagepieceweight.field_35605_b;
        }

        return flag ? i : -1;
    }

    private static ComponentVillage func_35699_a(StructureVillagePieceWeight structurevillagepieceweight, List list, Random random, int i, int j, int k, int l, int i1)
    {
        Class class1 = structurevillagepieceweight.field_35607_a;
        Object obj = null;
        if(class1 == (net.minecraft.src.ComponentVillageHouse4_Garden.class))
        {
            obj = ComponentVillageHouse4_Garden.func_35082_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageChurch.class))
        {
            obj = ComponentVillageChurch.func_35097_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse1.class))
        {
            obj = ComponentVillageHouse1.func_35095_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageWoodHut.class))
        {
            obj = ComponentVillageWoodHut.func_35091_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHall.class))
        {
            obj = ComponentVillageHall.func_35078_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageField.class))
        {
            obj = ComponentVillageField.func_35080_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageField2.class))
        {
            obj = ComponentVillageField2.func_35089_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse2.class))
        {
            obj = ComponentVillageHouse2.func_35085_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentVillageHouse3.class))
        {
            obj = ComponentVillageHouse3.func_35101_a(list, random, i, j, k, l, i1);
        }
        return ((ComponentVillage) (obj));
    }

    private static ComponentVillage func_35700_c(ComponentVillageStartPiece var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7) {
        int var8 = func_35703_a(var0.field_35107_d);
        if(var8 <= 0) {
           return null;
        } else {
           int var9 = 0;

           while(var9 < 5) {
              ++var9;
              int var10 = var2.nextInt(var8);
              Iterator var11 = var0.field_35107_d.iterator();

              while(var11.hasNext()) {
                 StructureVillagePieceWeight var12 = (StructureVillagePieceWeight)var11.next();
                 var10 -= var12.field_35605_b;
                 if(var10 < 0) {
                    if(!var12.func_35602_a(var7) || var12 == var0.field_35110_c && var0.field_35107_d.size() > 1) {
                       break;
                    }

                    ComponentVillage var13 = func_35699_a(var12, var1, var2, var3, var4, var5, var6, var7);
                    if(var13 != null) {
                       ++var12.field_35606_c;
                       var0.field_35110_c = var12;
                       if(!var12.func_35603_a()) {
                          var0.field_35107_d.remove(var12);
                       }

                       return var13;
                    }
                 }
              }
           }

           StructureBoundingBox var14 = ComponentVillageTorch.func_35099_a(var1, var2, var3, var4, var5, var6);
           if(var14 != null) {
              return new ComponentVillageTorch(var7, var2, var14, var6);
           } else {
              return null;
           }
        }
     }

    private static StructureComponent func_35702_d(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        if(i1 > 50)
        {
            return null;
        }
        if(Math.abs(i - componentvillagestartpiece.func_35021_b().field_35753_a) > 112 || Math.abs(k - componentvillagestartpiece.func_35021_b().field_35752_c) > 112)
        {
            return null;
        }
        ComponentVillage componentvillage = func_35700_c(componentvillagestartpiece, list, random, i, j, k, l, i1 + 1);
        if(componentvillage != null)
        {
            int j1 = (((StructureComponent) (componentvillage)).field_35024_g.field_35753_a + ((StructureComponent) (componentvillage)).field_35024_g.field_35749_d) / 2;
            int k1 = (((StructureComponent) (componentvillage)).field_35024_g.field_35752_c + ((StructureComponent) (componentvillage)).field_35024_g.field_35748_f) / 2;
            int l1 = ((StructureComponent) (componentvillage)).field_35024_g.field_35749_d - ((StructureComponent) (componentvillage)).field_35024_g.field_35753_a;
            int i2 = ((StructureComponent) (componentvillage)).field_35024_g.field_35748_f - ((StructureComponent) (componentvillage)).field_35024_g.field_35752_c;
            int j2 = l1 <= i2 ? i2 : l1;
            if(componentvillagestartpiece.func_35105_a().func_35562_a(j1, k1, j2 / 2 + 4, MapGenVillage.field_35635_a))
            {
                list.add(componentvillage);
                componentvillagestartpiece.field_35108_e.add(componentvillage);
                return componentvillage;
            }
        }
        return null;
    }

    private static StructureComponent func_35698_e(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        if(i1 > 3 + componentvillagestartpiece.field_35109_b)
        {
            return null;
        }
        if(Math.abs(i - componentvillagestartpiece.func_35021_b().field_35753_a) > 112 || Math.abs(k - componentvillagestartpiece.func_35021_b().field_35752_c) > 112)
        {
            return null;
        }
        StructureBoundingBox structureboundingbox = ComponentVillagePathGen.func_35087_a(componentvillagestartpiece, list, random, i, j, k, l);
        if(structureboundingbox != null && structureboundingbox.field_35751_b > 10)
        {
            ComponentVillagePathGen componentvillagepathgen = new ComponentVillagePathGen(i1, random, structureboundingbox, l);
            int j1 = (((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35753_a + ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35749_d) / 2;
            int k1 = (((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35752_c + ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35748_f) / 2;
            int l1 = ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35749_d - ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35753_a;
            int i2 = ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35748_f - ((StructureComponent) (componentvillagepathgen)).field_35024_g.field_35752_c;
            int j2 = l1 <= i2 ? i2 : l1;
            if(componentvillagestartpiece.func_35105_a().func_35562_a(j1, k1, j2 / 2 + 4, MapGenVillage.field_35635_a))
            {
                list.add(componentvillagepathgen);
                componentvillagestartpiece.field_35106_f.add(componentvillagepathgen);
                return componentvillagepathgen;
            }
        }
        return null;
    }

    static StructureComponent func_35704_a(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        return func_35702_d(componentvillagestartpiece, list, random, i, j, k, l, i1);
    }

    static StructureComponent func_35701_b(ComponentVillageStartPiece componentvillagestartpiece, List list, Random random, int i, int j, int k, int l, int i1)
    {
        return func_35698_e(componentvillagestartpiece, list, random, i, j, k, l, i1);
    }
}
