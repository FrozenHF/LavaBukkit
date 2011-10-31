// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelChest, ModelRenderer

public class ModelLargeChest extends ModelChest
{

    public ModelLargeChest()
    {
        field_35405_a = (new ModelRenderer(this, 0, 0)).func_35968_a(128, 64);
        field_35405_a.addBox(0.0F, -5F, -14F, 30, 5, 14, 0.0F);
        field_35405_a.rotationPointX = 1.0F;
        field_35405_a.rotationPointY = 7F;
        field_35405_a.rotationPointZ = 15F;
        field_35404_c = (new ModelRenderer(this, 0, 0)).func_35968_a(128, 64);
        field_35404_c.addBox(-1F, -2F, -15F, 2, 4, 1, 0.0F);
        field_35404_c.rotationPointX = 16F;
        field_35404_c.rotationPointY = 7F;
        field_35404_c.rotationPointZ = 15F;
        field_35403_b = (new ModelRenderer(this, 0, 19)).func_35968_a(128, 64);
        field_35403_b.addBox(0.0F, 0.0F, 0.0F, 30, 10, 14, 0.0F);
        field_35403_b.rotationPointX = 1.0F;
        field_35403_b.rotationPointY = 6F;
        field_35403_b.rotationPointZ = 1.0F;
    }
}
