// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityDamageSource, EntityDamageSourceIndirect, EntityLiving, EntityPlayer, 
//            EntityArrow, Entity, EntityFireball

public class DamageSource
{

    public static DamageSource func_35525_a(EntityLiving entityliving)
    {
        return new EntityDamageSource("mob", entityliving);
    }

    public static DamageSource func_35527_a(EntityPlayer entityplayer)
    {
        return new EntityDamageSource("player", entityplayer);
    }

    public static DamageSource func_35535_a(EntityArrow entityarrow, Entity entity)
    {
        return new EntityDamageSourceIndirect("arrow", entityarrow, entity);
    }

    public static DamageSource func_35530_a(EntityFireball entityfireball, Entity entity)
    {
        return new EntityDamageSourceIndirect("fireball", entityfireball, entity);
    }

    public static DamageSource func_35524_a(Entity entity, Entity entity1)
    {
        return new EntityDamageSourceIndirect("thrown", entity, entity1);
    }

    public boolean func_35534_b()
    {
        return field_35543_n;
    }

    public float func_35533_c()
    {
        return field_35551_p;
    }

    public boolean func_35529_d()
    {
        return field_35544_o;
    }

    protected DamageSource(String s)
    {
        field_35543_n = false;
        field_35544_o = false;
        field_35551_p = 0.3F;
        field_35546_m = s;
    }

    public Entity func_35526_e()
    {
        return func_35532_a();
    }

    public Entity func_35532_a()
    {
        return null;
    }

    private DamageSource func_35528_f()
    {
        field_35543_n = true;
        field_35551_p = 0.0F;
        return this;
    }

    private DamageSource func_35531_g()
    {
        field_35544_o = true;
        return this;
    }

    public static DamageSource field_35542_a = new DamageSource("inFire");
    public static DamageSource field_35540_b = (new DamageSource("onFire")).func_35528_f();
    public static DamageSource field_35541_c = new DamageSource("lava");
    public static DamageSource field_35538_d = (new DamageSource("inWall")).func_35528_f();
    public static DamageSource field_35539_e = (new DamageSource("drown")).func_35528_f();
    public static DamageSource field_35536_f = (new DamageSource("starve")).func_35528_f();
    public static DamageSource field_35537_g = new DamageSource("cactus");
    public static DamageSource field_35549_h = new DamageSource("fall");
    public static DamageSource field_35550_i = (new DamageSource("outOfWorld")).func_35528_f().func_35531_g();
    public static DamageSource field_35547_j = (new DamageSource("generic")).func_35528_f();
    public static DamageSource field_35548_k = new DamageSource("explosion");
    public static DamageSource field_35545_l = (new DamageSource("magic")).func_35528_f();
    private boolean field_35543_n;
    private boolean field_35544_o;
    private float field_35551_p;
    public String field_35546_m;

}
