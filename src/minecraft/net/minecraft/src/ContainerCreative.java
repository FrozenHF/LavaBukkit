// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Block, ItemStack, Item, 
//            EntityPlayer, Slot, GuiContainerCreative, InventoryBasic

class ContainerCreative extends Container
{

    public ContainerCreative(EntityPlayer entityplayer)
    {
        field_35375_a = new ArrayList();
        Block ablock[] = {
            Block.cobblestone, Block.stone, Block.oreDiamond, Block.oreGold, Block.oreIron, Block.oreCoal, Block.oreLapis, Block.oreRedstone, Block.field_35285_bn, Block.field_35285_bn, 
            Block.field_35285_bn, Block.blockClay, Block.blockDiamond, Block.blockGold, Block.blockSteel, Block.bedrock, Block.blockLapis, Block.brick, Block.cobblestoneMossy, Block.stairSingle, 
            Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.obsidian, Block.netherrack, Block.slowSand, Block.glowStone, Block.wood, 
            Block.wood, Block.wood, Block.leaves, Block.dirt, Block.grass, Block.sand, Block.sandStone, Block.gravel, Block.web, Block.planks, 
            Block.sapling, Block.sapling, Block.sapling, Block.deadBush, Block.sponge, Block.ice, Block.blockSnow, Block.plantYellow, Block.plantRed, Block.mushroomBrown, 
            Block.mushroomRed, Block.reed, Block.cactus, Block.field_35281_bs, Block.pumpkin, Block.pumpkinLantern, Block.field_35278_bv, Block.field_35288_bq, Block.field_35282_br, Block.chest, 
            Block.workbench, Block.glass, Block.tnt, Block.bookShelf, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, 
            Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, 
            Block.dispenser, Block.stoneOvenIdle, Block.music, Block.jukebox, Block.pistonStickyBase, Block.pistonBase, Block.fence, Block.field_35277_bw, Block.ladder, Block.rail, 
            Block.railPowered, Block.railDetector, Block.torchWood, Block.stairCompactPlanks, Block.stairCompactCobblestone, Block.field_35280_bx, Block.field_35279_by, Block.lever, Block.pressurePlateStone, Block.pressurePlatePlanks, 
            Block.torchRedstoneActive, Block.button, Block.cake, Block.trapdoor
        };
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        for(int j1 = 0; j1 < ablock.length; j1++)
        {
            int i2 = 0;
            if(ablock[j1] == Block.cloth)
            {
                i2 = i++;
            } else
            if(ablock[j1] == Block.stairSingle)
            {
                i2 = j++;
            } else
            if(ablock[j1] == Block.wood)
            {
                i2 = k++;
            } else
            if(ablock[j1] == Block.sapling)
            {
                i2 = l++;
            } else
            if(ablock[j1] == Block.field_35285_bn)
            {
                i2 = i1++;
            }
            field_35375_a.add(new ItemStack(ablock[j1], 1, i2));
        }

        for(int k1 = 256; k1 < Item.itemsList.length; k1++)
        {
            if(Item.itemsList[k1] != null)
            {
                field_35375_a.add(new ItemStack(Item.itemsList[k1]));
            }
        }

        for(int l1 = 1; l1 < 16; l1++)
        {
            field_35375_a.add(new ItemStack(Item.dyePowder.shiftedIndex, 1, l1));
        }

        InventoryPlayer inventoryplayer = entityplayer.inventory;
        for(int j2 = 0; j2 < 9; j2++)
        {
            for(int l2 = 0; l2 < 8; l2++)
            {
                addSlot(new Slot(GuiContainerCreative.func_35310_g(), l2 + j2 * 8, 8 + l2 * 18, 18 + j2 * 18));
            }

        }

        for(int k2 = 0; k2 < 9; k2++)
        {
            addSlot(new Slot(inventoryplayer, k2, 8 + k2 * 18, 184));
        }

        func_35374_a(0.0F);
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return true;
    }

    public void func_35374_a(float f)
    {
        int i = (field_35375_a.size() / 8 - 8) + 1;
        int j = (int)((double)(f * (float)i) + 0.5D);
        if(j < 0)
        {
            j = 0;
        }
        for(int k = 0; k < 9; k++)
        {
            for(int l = 0; l < 8; l++)
            {
                int i1 = l + (k + j) * 8;
                if(i1 >= 0 && i1 < field_35375_a.size())
                {
                    GuiContainerCreative.func_35310_g().setInventorySlotContents(l + k * 8, (ItemStack)field_35375_a.get(i1));
                } else
                {
                    GuiContainerCreative.func_35310_g().setInventorySlotContents(l + k * 8, null);
                }
            }

        }

    }

    protected void func_35373_b(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
    }

    public List field_35375_a;
}
