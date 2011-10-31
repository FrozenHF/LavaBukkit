// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelQuadruped, ModelRenderer, Entity

public class ModelPig extends ModelQuadruped
{

    public ModelPig()
    {
        this(0.0F);
    }

    public ModelPig(float f)
    {
        super(6, f);
        field_35401_a = new ModelRenderer(this, 16, 16);
        field_35401_a.addBox(-2F, 0.0F, -9F, 4, 3, 1, f);
        field_35401_a.setRotationPoint(0.0F, 12F, -6F);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5);
        field_35401_a.func_35969_a(head);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        field_35401_a.render(f5);
    }

    public ModelRenderer field_35401_a;
}
