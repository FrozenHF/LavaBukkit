// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStrongholdPieceWeight, ComponentStrongholdStraight, ComponentStrongholdPrison, ComponentStrongholdLeftTurn, 
//            ComponentStrongholdRightTurn, ComponentStrongholdRoomCrossing, ComponentStrongholdStairsStraight, ComponentStrongholdStairs, 
//            ComponentStrongholdCrossing, ComponentStrongholdLibrary, ComponentStrongholdStairs2, ComponentStrongholdCorridor, 
//            StructureBoundingBox, StructureStrongholdPieceWeight2, StructureStrongholdStones, ComponentStronghold, 
//            StructureComponent

public class StructureStrongholdPieces
{

    public StructureStrongholdPieces()
    {
    }

    public static void func_35849_a()
    {
        field_35856_c = new ArrayList();
        StructureStrongholdPieceWeight astructurestrongholdpieceweight[] = field_35855_b;
        int i = astructurestrongholdpieceweight.length;
        for(int j = 0; j < i; j++)
        {
            StructureStrongholdPieceWeight structurestrongholdpieceweight = astructurestrongholdpieceweight[j];
            structurestrongholdpieceweight.field_35617_c = 0;
            field_35856_c.add(structurestrongholdpieceweight);
        }

    }

    private static boolean func_35853_c()
    {
        boolean flag = false;
        field_35857_a = 0;
        for(Iterator iterator = field_35856_c.iterator(); iterator.hasNext();)
        {
            StructureStrongholdPieceWeight structurestrongholdpieceweight = (StructureStrongholdPieceWeight)iterator.next();
            if(structurestrongholdpieceweight.field_35615_d > 0 && structurestrongholdpieceweight.field_35617_c < structurestrongholdpieceweight.field_35615_d)
            {
                flag = true;
            }
            field_35857_a += structurestrongholdpieceweight.field_35616_b;
        }

        return flag;
    }

    private static ComponentStronghold func_35851_a(StructureStrongholdPieceWeight structurestrongholdpieceweight, List list, Random random, int i, int j, int k, int l, int i1)
    {
        Class class1 = structurestrongholdpieceweight.field_35618_a;
        Object obj = null;
        if(class1 == (net.minecraft.src.ComponentStrongholdStraight.class))
        {
            obj = ComponentStrongholdStraight.func_35047_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdPrison.class))
        {
            obj = ComponentStrongholdPrison.func_35063_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdLeftTurn.class))
        {
            obj = ComponentStrongholdLeftTurn.func_35045_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdRightTurn.class))
        {
            obj = ComponentStrongholdRightTurn.func_35045_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdRoomCrossing.class))
        {
            obj = ComponentStrongholdRoomCrossing.func_35059_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdStairsStraight.class))
        {
            obj = ComponentStrongholdStairsStraight.func_35053_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdStairs.class))
        {
            obj = ComponentStrongholdStairs.func_35034_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdCrossing.class))
        {
            obj = ComponentStrongholdCrossing.func_35039_a(list, random, i, j, k, l, i1);
        } else
        if(class1 == (net.minecraft.src.ComponentStrongholdLibrary.class))
        {
            obj = ComponentStrongholdLibrary.func_35055_a(list, random, i, j, k, l, i1);
        }
        return ((ComponentStronghold) (obj));
    }

    private static ComponentStronghold func_35847_b(ComponentStrongholdStairs2 var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7) {
        if(!func_35853_c()) {
           return null;
        } else {
           int var8 = 0;

           while(var8 < 5) {
              ++var8;
              int var9 = var2.nextInt(field_35857_a);
              Iterator var10 = field_35856_c.iterator();

              while(var10.hasNext()) {
                 StructureStrongholdPieceWeight var11 = (StructureStrongholdPieceWeight)var10.next();
                 var9 -= var11.field_35616_b;
                 if(var9 < 0) {
                    if(!var11.func_35613_a(var7) || var11 == var0.field_35038_a) {
                       break;
                    }

                    ComponentStronghold var12 = func_35851_a(var11, var1, var2, var3, var4, var5, var6, var7);
                    if(var12 != null) {
                       ++var11.field_35617_c;
                       var0.field_35038_a = var11;
                       if(!var11.func_35614_a()) {
                          field_35856_c.remove(var11);
                       }

                       return var12;
                    }
                 }
              }
           }

           StructureBoundingBox var13 = ComponentStrongholdCorridor.func_35051_a(var1, var2, var3, var4, var5, var6);
           if(var13 != null && var13.field_35751_b > 1) {
              return new ComponentStrongholdCorridor(var7, var2, var13, var6);
           } else {
              return null;
           }
        }
     }

    private static StructureComponent func_35848_c(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j, int k, int l, int i1)
    {
        if(i1 > 50)
        {
            return null;
        }
        if(Math.abs(i - componentstrongholdstairs2.func_35021_b().field_35753_a) > 112 || Math.abs(k - componentstrongholdstairs2.func_35021_b().field_35752_c) > 112)
        {
            return null;
        }
        ComponentStronghold componentstronghold = func_35847_b(componentstrongholdstairs2, list, random, i, j, k, l, i1 + 1);
        if(componentstronghold != null)
        {
            list.add(componentstronghold);
            componentstrongholdstairs2.field_35037_b.add(componentstronghold);
        }
        return componentstronghold;
    }

    static StructureComponent func_35850_a(ComponentStrongholdStairs2 componentstrongholdstairs2, List list, Random random, int i, int j, int k, int l, int i1)
    {
        return func_35848_c(componentstrongholdstairs2, list, random, i, j, k, l, i1);
    }

    static StructureStrongholdStones func_35852_b()
    {
        return field_35854_d;
    }

    private static final StructureStrongholdPieceWeight field_35855_b[];
    private static List field_35856_c;
    static int field_35857_a = 0;
    private static final StructureStrongholdStones field_35854_d = new StructureStrongholdStones(null);

    static 
    {
        field_35855_b = (new StructureStrongholdPieceWeight[] {
            new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStraight.class, 40, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdPrison.class, 5, 5), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdLeftTurn.class, 20, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdRightTurn.class, 20, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdRoomCrossing.class, 10, 6), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStairsStraight.class, 5, 10), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStairs.class, 5, 10), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdCrossing.class, 5, 4), new StructureStrongholdPieceWeight2(net.minecraft.src.ComponentStrongholdLibrary.class, 10, 1)
        });
    }
}
