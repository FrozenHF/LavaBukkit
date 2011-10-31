// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, World, Material, 
//            AxisAlignedBB, EntityPlayer, Block, DamageSource, 
//            NBTTagCompound

public class EntityXPOrb extends Entity
{

    public EntityXPOrb(World world, double d, double d1, double d2, 
            int i)
    {
        super(world);
        field_35124_b = 0;
        field_35123_e = 5;
        field_35122_d = (float)(Math.random() * 3.1415926535897931D * 2D);
        setSize(0.5F, 0.5F);
        yOffset = height / 2.0F;
        setPosition(d, d1, d2);
        rotationYaw = (float)(Math.random() * 360D);
        motionX = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        motionY = (float)(Math.random() * 0.20000000000000001D) * 2.0F;
        motionZ = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F;
        field_35125_ap = i;
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    public EntityXPOrb(World world)
    {
        super(world);
        field_35124_b = 0;
        field_35123_e = 5;
        field_35122_d = (float)(Math.random() * 3.1415926535897931D * 2D);
        setSize(0.25F, 0.25F);
        yOffset = height / 2.0F;
    }

    protected void entityInit()
    {
    }

    public int func_35115_a(float f)
    {
        float f1 = 0.75F;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f1 > 1.0F)
        {
            f1 = 1.0F;
        }
        int i = super.func_35115_a(f);
        int j = i & 0xff;
        int k = i >> 16 & 0xff;
        j += (int)(f1 * 15F * 16F);
        if(j > 240)
        {
            j = 240;
        }
        return j | k << 16;
    }

    public void onUpdate()
    {
        super.onUpdate();
        if(field_35126_c > 0)
        {
            field_35126_c--;
        }
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        motionY -= 0.029999999329447746D;
        if(worldObj.getBlockMaterial(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) == Material.lava)
        {
            motionY = 0.20000000298023224D;
            motionX = (rand.nextFloat() - rand.nextFloat()) * 0.2F;
            motionZ = (rand.nextFloat() - rand.nextFloat()) * 0.2F;
            worldObj.playSoundAtEntity(this, "random.fizz", 0.4F, 2.0F + rand.nextFloat() * 0.4F);
        }
        pushOutOfBlocks(posX, (boundingBox.minY + boundingBox.maxY) / 2D, posZ);
        double d = 8D;
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, d);
        if(entityplayer != null)
        {
            double d1 = (entityplayer.posX - posX) / d;
            double d2 = ((entityplayer.posY + (double)entityplayer.getEyeHeight()) - posY) / d;
            double d3 = (entityplayer.posZ - posZ) / d;
            double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            double d5 = 1.0D - d4;
            if(d5 > 0.0D)
            {
                d5 *= d5;
                motionX += (d1 / d4) * d5 * 0.10000000000000001D;
                motionY += (d2 / d4) * d5 * 0.10000000000000001D;
                motionZ += (d3 / d4) * d5 * 0.10000000000000001D;
            }
        }
        moveEntity(motionX, motionY, motionZ);
        float f = 0.98F;
        if(onGround)
        {
            f = 0.5880001F;
            int i = worldObj.getBlockId(MathHelper.floor_double(posX), MathHelper.floor_double(boundingBox.minY) - 1, MathHelper.floor_double(posZ));
            if(i > 0)
            {
                f = Block.blocksList[i].slipperiness * 0.98F;
            }
        }
        motionX *= f;
        motionY *= 0.98000001907348633D;
        motionZ *= f;
        if(onGround)
        {
            motionY *= -0.89999997615814209D;
        }
        field_35127_a++;
        field_35124_b++;
        if(field_35124_b >= 6000)
        {
            setEntityDead();
        }
    }

    public boolean handleWaterMovement()
    {
        return worldObj.handleMaterialAcceleration(boundingBox, Material.water, this);
    }

    protected void dealFireDamage(int i)
    {
        attackEntityFrom(DamageSource.field_35542_a, i);
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        setBeenAttacked();
        field_35123_e -= i;
        if(field_35123_e <= 0)
        {
            setEntityDead();
        }
        return false;
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setShort("Health", (byte)field_35123_e);
        nbttagcompound.setShort("Age", (short)field_35124_b);
        nbttagcompound.setShort("Value", (short)field_35125_ap);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        field_35123_e = nbttagcompound.getShort("Health") & 0xff;
        field_35124_b = nbttagcompound.getShort("Age");
        field_35125_ap = nbttagcompound.getShort("Value");
    }

    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if(worldObj.multiplayerWorld)
        {
            return;
        }
        if(field_35126_c == 0 && entityplayer.field_35214_aG == 0)
        {
            entityplayer.field_35214_aG = 2;
            worldObj.playSoundAtEntity(this, "random.pop", 0.2F, 0.5F * ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F));
            entityplayer.onItemPickup(this, 1);
            entityplayer.func_35204_c(field_35125_ap);
            setEntityDead();
        }
    }

    public int func_35119_j_()
    {
        return field_35125_ap;
    }

    public int func_35120_i()
    {
        if(field_35125_ap >= 2477)
        {
            return 10;
        }
        if(field_35125_ap >= 1237)
        {
            return 9;
        }
        if(field_35125_ap >= 617)
        {
            return 8;
        }
        if(field_35125_ap >= 307)
        {
            return 7;
        }
        if(field_35125_ap >= 149)
        {
            return 6;
        }
        if(field_35125_ap >= 73)
        {
            return 5;
        }
        if(field_35125_ap >= 37)
        {
            return 4;
        }
        if(field_35125_ap >= 17)
        {
            return 3;
        }
        if(field_35125_ap >= 7)
        {
            return 2;
        }
        return field_35125_ap < 3 ? 0 : 1;
    }

    public static int func_35121_b(int i)
    {
        if(i >= 2477)
        {
            return 2477;
        }
        if(i >= 1237)
        {
            return 1237;
        }
        if(i >= 617)
        {
            return 617;
        }
        if(i >= 307)
        {
            return 307;
        }
        if(i >= 149)
        {
            return 149;
        }
        if(i >= 73)
        {
            return 73;
        }
        if(i >= 37)
        {
            return 37;
        }
        if(i >= 17)
        {
            return 17;
        }
        if(i >= 7)
        {
            return 7;
        }
        return i < 3 ? 1 : 3;
    }

    public int field_35127_a;
    public int field_35124_b;
    public int field_35126_c;
    private int field_35123_e;
    private int field_35125_ap;
    public float field_35122_d;
}
