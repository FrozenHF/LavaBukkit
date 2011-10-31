// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.PrintStream;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelSilverfish, EntitySilverfish, EntityLiving, 
//            Entity

public class RenderSilverfish extends RenderLiving
{

    public RenderSilverfish()
    {
        super(new ModelSilverfish(), 0.3F);
    }

    protected float func_35447_a(EntitySilverfish entitysilverfish)
    {
        return 180F;
    }

    public void func_35448_a(EntitySilverfish entitysilverfish, double d, double d1, double d2, 
            float f, float f1)
    {
        int i = ((ModelSilverfish)mainModel).func_35395_a();
        if(i != field_35450_c)
        {
            field_35450_c = i;
            mainModel = new ModelSilverfish();
            System.out.println("new silverfish model");
        }
        super.doRenderLiving(entitysilverfish, d, d1, d2, f, f1);
    }

    protected boolean func_35449_a(EntitySilverfish entitysilverfish, int i, float f)
    {
        return false;
    }

    protected float getDeathMaxRotation(EntityLiving entityliving)
    {
        return func_35447_a((EntitySilverfish)entityliving);
    }

    protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return func_35449_a((EntitySilverfish)entityliving, i, f);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        func_35448_a((EntitySilverfish)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_35448_a((EntitySilverfish)entity, d, d1, d2, f, f1);
    }

    private int field_35450_c;
}
