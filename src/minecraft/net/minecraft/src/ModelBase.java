// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ModelRenderer, Entity, EntityLiving

public abstract class ModelBase
{

    public ModelBase()
    {
        isRiding = false;
        field_35394_j = new ArrayList();
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

    public void setLivingAnimations(EntityLiving entityliving, float f, float f1, float f2)
    {
    }

    public ModelRenderer func_35393_a(Random random)
    {
        return (ModelRenderer)field_35394_j.get(random.nextInt(field_35394_j.size()));
    }

    public float onGround;
    public boolean isRiding;
    public List field_35394_j;
}
