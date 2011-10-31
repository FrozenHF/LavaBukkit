// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, EntityPlayer, FoodStats, 
//            World, PotionEffect, EnumAction

public class ItemFood extends Item
{

    public ItemFood(int i, int j, float f, boolean flag)
    {
        super(i);
        healAmount = j;
        isWolfsFavoriteMeat = flag;
        field_35428_c = f;
    }

    public ItemFood(int i, int j, boolean flag)
    {
        this(i, j, 0.6F, flag);
    }

    public ItemStack func_35413_b(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.stackSize--;
        entityplayer.func_35191_at().func_35761_a(this);
        if(!world.multiplayerWorld && field_35433_bx > 0 && world.rand.nextFloat() < field_35429_bA)
        {
            entityplayer.func_35165_a(new PotionEffect(field_35433_bx, field_35432_by * 20, field_35427_bz));
        }
        return itemstack;
    }

    public int func_35411_c(ItemStack itemstack)
    {
        return 32;
    }

    public EnumAction func_35412_b(ItemStack itemstack)
    {
        return EnumAction.eat;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.func_35197_b(field_35431_bw))
        {
            entityplayer.func_35199_b(itemstack, func_35411_c(itemstack));
        }
        return itemstack;
    }

    public int getHealAmount()
    {
        return healAmount;
    }

    public float func_35426_m()
    {
        return field_35428_c;
    }

    public boolean getIsWolfsFavoriteMeat()
    {
        return isWolfsFavoriteMeat;
    }

    public ItemFood func_35425_a(int i, int j, int k, float f)
    {
        field_35433_bx = i;
        field_35432_by = j;
        field_35427_bz = k;
        field_35429_bA = f;
        return this;
    }

    public ItemFood func_35424_o()
    {
        field_35431_bw = true;
        return this;
    }

    public Item setItemName(String s)
    {
        return super.setItemName(s);
    }

    public final int field_35430_a = 32;
    private final int healAmount;
    private final float field_35428_c;
    private final boolean isWolfsFavoriteMeat;
    private boolean field_35431_bw;
    private int field_35433_bx;
    private int field_35432_by;
    private int field_35427_bz;
    private float field_35429_bA;
}
