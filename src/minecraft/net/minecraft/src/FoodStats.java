// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemFood, EntityPlayer, World, DamageSource, 
//            NBTTagCompound

public class FoodStats
{

    public FoodStats()
    {
        field_35772_d = 0;
        field_35776_a = 20;
        field_35773_e = 20;
        field_35774_b = 5F;
    }

    public void func_35771_a(int i, float f)
    {
        field_35776_a = Math.min(i + field_35776_a, 20);
        field_35774_b = Math.min(field_35774_b + (float)i * f * 2.0F, field_35776_a);
    }

    public void func_35761_a(ItemFood itemfood)
    {
        func_35771_a(itemfood.getHealAmount(), itemfood.func_35426_m());
    }

    public void func_35768_a(EntityPlayer entityplayer)
    {
        int i = entityplayer.worldObj.difficultySetting;
        field_35773_e = field_35776_a;
        if(field_35775_c > 4F)
        {
            field_35775_c -= 4F;
            if(field_35774_b > 0.0F)
            {
                field_35774_b = Math.max(field_35774_b - 1.0F, 0.0F);
            } else
            if(i > 0)
            {
                field_35776_a = Math.max(field_35776_a - 1, 0);
            }
        }
        if(field_35776_a >= 18 && entityplayer.func_35194_au())
        {
            field_35772_d++;
            if(field_35772_d >= 80)
            {
                entityplayer.heal(1);
                field_35772_d = 0;
            }
        } else
        if(field_35776_a <= 0)
        {
            field_35772_d++;
            if(field_35772_d >= 80)
            {
                if(entityplayer.health > 10 || i >= 3 || entityplayer.health > 1 && i >= 2)
                {
                    entityplayer.attackEntityFrom(DamageSource.field_35536_f, 1);
                }
                field_35772_d = 0;
            }
        } else
        {
            field_35772_d = 0;
        }
    }

    public void func_35766_a(NBTTagCompound nbttagcompound)
    {
        if(nbttagcompound.hasKey("foodLevel"))
        {
            field_35776_a = nbttagcompound.getInteger("foodLevel");
            field_35772_d = nbttagcompound.getInteger("foodTickTimer");
            field_35774_b = nbttagcompound.getFloat("foodSaturationLevel");
            field_35775_c = nbttagcompound.getFloat("foodExhaustionLevel");
        }
    }

    public void func_35763_b(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setInteger("foodLevel", field_35776_a);
        nbttagcompound.setInteger("foodTickTimer", field_35772_d);
        nbttagcompound.setFloat("foodSaturationLevel", field_35774_b);
        nbttagcompound.setFloat("foodExhaustionLevel", field_35775_c);
    }

    public int func_35765_a()
    {
        return field_35776_a;
    }

    public int func_35769_b()
    {
        return field_35773_e;
    }

    public boolean func_35770_c()
    {
        return field_35776_a < 20;
    }

    public void func_35762_a(float f)
    {
        field_35775_c = Math.min(field_35775_c + f, 40F);
    }

    public float func_35760_d()
    {
        return field_35774_b;
    }

    public void func_35764_a(int i)
    {
        field_35776_a = i;
    }

    public void func_35767_b(float f)
    {
        field_35774_b = f;
    }

    private int field_35776_a;
    private float field_35774_b;
    private float field_35775_c;
    private int field_35772_d;
    private int field_35773_e;
}
