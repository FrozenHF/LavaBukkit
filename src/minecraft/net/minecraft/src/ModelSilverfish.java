// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelSilverfish extends ModelBase
{

    public ModelSilverfish()
    {
        field_35399_c = new float[7];
        field_35400_a = new ModelRenderer[7];
        float f = -3.5F;
        for(int i = 0; i < field_35400_a.length; i++)
        {
            field_35400_a[i] = new ModelRenderer(this, field_35397_e[i][0], field_35397_e[i][1]);
            field_35400_a[i].addBox((float)field_35396_d[i][0] * -0.5F, 0.0F, (float)field_35396_d[i][2] * -0.5F, field_35396_d[i][0], field_35396_d[i][1], field_35396_d[i][2]);
            field_35400_a[i].setRotationPoint(0.0F, 24 - field_35396_d[i][1], f);
            field_35399_c[i] = f;
            if(i < field_35400_a.length - 1)
            {
                f += (float)(field_35396_d[i][2] + field_35396_d[i + 1][2]) * 0.5F;
            }
        }

        field_35398_b = new ModelRenderer[3];
        field_35398_b[0] = new ModelRenderer(this, 20, 0);
        field_35398_b[0].addBox(-5F, 0.0F, (float)field_35396_d[2][2] * -0.5F, 10, 8, field_35396_d[2][2]);
        field_35398_b[0].setRotationPoint(0.0F, 16F, field_35399_c[2]);
        field_35398_b[1] = new ModelRenderer(this, 20, 11);
        field_35398_b[1].addBox(-3F, 0.0F, (float)field_35396_d[4][2] * -0.5F, 6, 4, field_35396_d[4][2]);
        field_35398_b[1].setRotationPoint(0.0F, 20F, field_35399_c[4]);
        field_35398_b[2] = new ModelRenderer(this, 20, 18);
        field_35398_b[2].addBox(-3F, 0.0F, (float)field_35396_d[4][2] * -0.5F, 6, 5, field_35396_d[1][2]);
        field_35398_b[2].setRotationPoint(0.0F, 19F, field_35399_c[1]);
    }

    public int func_35395_a()
    {
        return 38;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        for(int i = 0; i < field_35400_a.length; i++)
        {
            field_35400_a[i].render(f5);
        }

        for(int j = 0; j < field_35398_b.length; j++)
        {
            field_35398_b[j].render(f5);
        }

    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        for(int i = 0; i < field_35400_a.length; i++)
        {
            field_35400_a[i].rotateAngleY = MathHelper.cos(f2 * 0.9F + (float)i * 0.15F * 3.141593F) * 3.141593F * 0.05F * (float)(1 + Math.abs(i - 2));
            field_35400_a[i].rotationPointX = MathHelper.sin(f2 * 0.9F + (float)i * 0.15F * 3.141593F) * 3.141593F * 0.2F * (float)Math.abs(i - 2);
        }

        field_35398_b[0].rotateAngleY = field_35400_a[2].rotateAngleY;
        field_35398_b[1].rotateAngleY = field_35400_a[4].rotateAngleY;
        field_35398_b[1].rotationPointX = field_35400_a[4].rotationPointX;
        field_35398_b[2].rotateAngleY = field_35400_a[1].rotateAngleY;
        field_35398_b[2].rotationPointX = field_35400_a[1].rotationPointX;
    }

    private ModelRenderer field_35400_a[];
    private ModelRenderer field_35398_b[];
    private float field_35399_c[];
    private static final int field_35396_d[][] = {
        {
            3, 2, 2
        }, {
            4, 3, 2
        }, {
            6, 4, 3
        }, {
            3, 3, 3
        }, {
            2, 2, 3
        }, {
            2, 1, 2
        }, {
            1, 1, 2
        }
    };
    private static final int field_35397_e[][] = {
        {
            0, 0
        }, {
            0, 4
        }, {
            0, 9
        }, {
            0, 16
        }, {
            0, 22
        }, {
            11, 0
        }, {
            13, 4
        }
    };

}
