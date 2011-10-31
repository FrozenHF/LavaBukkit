// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityLiving, DamageSource, EntityPlayer, PotionHealth

public class Potion
{

    protected Potion(int i)
    {
        field_35671_I = "";
        field_35670_H = i;
        field_35678_a[i] = this;
    }

    public void func_35662_a(EntityLiving entityliving, int i)
    {
        if(field_35670_H == field_35681_l.field_35670_H)
        {
            if(entityliving.health < 20)
            {
                entityliving.heal(1);
            }
        } else
        if(field_35670_H == field_35689_u.field_35670_H)
        {
            if(entityliving.health > 1)
            {
                entityliving.attackEntityFrom(DamageSource.field_35545_l, 1);
            }
        } else
        if(field_35670_H == field_35691_s.field_35670_H && (entityliving instanceof EntityPlayer))
        {
            ((EntityPlayer)entityliving).func_35198_d(0.025F * (float)(i + 1));
        } else
        if(field_35670_H == field_35685_h.field_35670_H)
        {
            entityliving.heal(4 << i);
        } else
        if(field_35670_H == field_35686_i.field_35670_H)
        {
            entityliving.attackEntityFrom(DamageSource.field_35545_l, 4 << i);
        }
    }

    public boolean func_35660_a(int i, int j)
    {
        if(field_35670_H == field_35681_l.field_35670_H || field_35670_H == field_35689_u.field_35670_H)
        {
            int k = 25 >> j;
            if(k > 0)
            {
                return i % k == 0;
            } else
            {
                return true;
            }
        }
        return field_35670_H == field_35691_s.field_35670_H;
    }

    public Potion func_35661_a(String s)
    {
        field_35671_I = s;
        return this;
    }

    public static final Potion field_35678_a[] = new Potion[32];
    public static final Potion field_35676_b = null;
    public static final Potion field_35677_c = (new Potion(1)).func_35661_a("potion.moveSpeed");
    public static final Potion field_35674_d = (new Potion(2)).func_35661_a("potion.moveSlowdown");
    public static final Potion field_35675_e = (new Potion(3)).func_35661_a("potion.digSpeed");
    public static final Potion field_35672_f = (new Potion(4)).func_35661_a("potion.digSlowDown");
    public static final Potion field_35673_g = (new Potion(5)).func_35661_a("potion.damageBoost");
    public static final Potion field_35685_h = (new PotionHealth(6)).func_35661_a("potion.heal");
    public static final Potion field_35686_i = (new PotionHealth(7)).func_35661_a("potion.harm");
    public static final Potion field_35683_j = (new Potion(8)).func_35661_a("potion.jump");
    public static final Potion field_35684_k = (new Potion(9)).func_35661_a("potion.confusion");
    public static final Potion field_35681_l = (new Potion(10)).func_35661_a("potion.regeneration");
    public static final Potion field_35682_m = (new Potion(11)).func_35661_a("potion.resistance");
    public static final Potion field_35679_n = (new Potion(12)).func_35661_a("potion.fireResistance");
    public static final Potion field_35680_o = (new Potion(13)).func_35661_a("potion.waterBreathing");
    public static final Potion field_35694_p = (new Potion(14)).func_35661_a("potion.invisibility");
    public static final Potion field_35693_q = (new Potion(15)).func_35661_a("potion.blindness");
    public static final Potion field_35692_r = (new Potion(16)).func_35661_a("potion.nightVision");
    public static final Potion field_35691_s = (new Potion(17)).func_35661_a("potion.hunger");
    public static final Potion field_35690_t = (new Potion(18)).func_35661_a("potion.weakness");
    public static final Potion field_35689_u = (new Potion(19)).func_35661_a("potion.poison");
    public static final Potion field_35688_v = null;
    public static final Potion field_35687_w = null;
    public static final Potion field_35697_x = null;
    public static final Potion field_35696_y = null;
    public static final Potion field_35695_z = null;
    public static final Potion field_35667_A = null;
    public static final Potion field_35668_B = null;
    public static final Potion field_35669_C = null;
    public static final Potion field_35663_D = null;
    public static final Potion field_35664_E = null;
    public static final Potion field_35665_F = null;
    public static final Potion field_35666_G = null;
    public final int field_35670_H;
    private String field_35671_I;

}
