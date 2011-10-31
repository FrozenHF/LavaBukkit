// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, InventoryPlayer, EntityArrow, 
//            World, EnumAction, ItemStack

public class ItemBow extends Item
{

    public ItemBow(int i)
    {
        super(i);
        maxStackSize = 1;
    }

    public void func_35414_a(ItemStack itemstack, World world, EntityPlayer entityplayer, int i)
    {
        if(entityplayer.inventory.func_35157_d(Item.arrow.shiftedIndex))
        {
            int j = func_35411_c(itemstack) - i;
            float f = (float)j / 20F;
            f = (f * f + f * 2.0F) / 3F;
            if((double)f < 0.10000000000000001D)
            {
                return;
            }
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            EntityArrow entityarrow = new EntityArrow(world, entityplayer, f * 2.0F);
            if(f == 1.0F)
            {
                entityarrow.field_35140_d = true;
            }
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            entityplayer.inventory.consumeInventoryItem(Item.arrow.shiftedIndex);
            if(!world.multiplayerWorld)
            {
                world.entityJoinedWorld(entityarrow);
            }
        }
    }

    public ItemStack func_35413_b(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        return itemstack;
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 0x11940;
    }

    public EnumAction func_35412_b(ItemStack itemstack)
    {
        return EnumAction.bow;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.inventory.func_35157_d(Item.arrow.shiftedIndex))
        {
            entityplayer.func_35199_b(itemstack, func_35411_c(itemstack));
        }
        return itemstack;
    }
}
