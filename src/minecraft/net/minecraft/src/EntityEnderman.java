// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, InventoryPlayer, ItemStack, Block, 
//            Vec3D, AxisAlignedBB, DamageSource, MathHelper, 
//            Entity, Material, Item, BlockGrass, 
//            BlockLeaves, BlockFlower

public class EntityEnderman extends EntityMob
{

    public EntityEnderman(World world)
    {
        super(world);
        field_35187_a = false;
        field_35184_d = 0;
        field_35185_e = 0;
        texture = "/mob/enderman.png";
        moveSpeed = 0.2F;
        attackStrength = 5;
        setSize(0.6F, 2.9F);
        stepHeight = 1.0F;
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, new Byte((byte)0));
        dataWatcher.addObject(17, new Byte((byte)0));
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("carried", (short)func_35176_r());
        nbttagcompound.setShort("carriedData", (short)func_35180_s());
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        func_35177_b(nbttagcompound.getShort("carried"));
        func_35181_c(nbttagcompound.getShort("carryingData"));
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 64D);
        if(entityplayer != null)
        {
            if(func_35183_c(entityplayer))
            {
                if(field_35185_e++ == 5)
                {
                    field_35185_e = 0;
                    return entityplayer;
                }
            } else
            {
                field_35185_e = 0;
            }
        }
        return null;
    }

    public int func_35115_a(float f)
    {
        return super.func_35115_a(f);
    }

    public float getEntityBrightness(float f)
    {
        return super.getEntityBrightness(f);
    }

    private boolean func_35183_c(EntityPlayer entityplayer)
    {
        ItemStack itemstack = entityplayer.inventory.armorInventory[3];
        if(itemstack != null && itemstack.itemID == Block.pumpkin.blockID)
        {
            return false;
        }
        Vec3D vec3d = entityplayer.getLook(1.0F).normalize();
        Vec3D vec3d1 = Vec3D.createVector(posX - entityplayer.posX, ((boundingBox.minY + (double)(height / 2.0F)) - entityplayer.posY) + (double)entityplayer.getEyeHeight(), posZ - entityplayer.posZ);
        double d = vec3d1.lengthVector();
        vec3d1 = vec3d1.normalize();
        double d1 = vec3d.func_35612_b(vec3d1);
        if(d1 > 1.0D - 0.025000000000000001D / d)
        {
            return entityplayer.canEntityBeSeen(this);
        } else
        {
            return false;
        }
    }

    public void onLivingUpdate()
    {
        if(isWet())
        {
            attackEntityFrom(DamageSource.field_35539_e, 1);
        }
        field_35187_a = entityToAttack != null;
        moveSpeed = entityToAttack == null ? 0.3F : 4.5F;
        if(!worldObj.multiplayerWorld)
        {
            if(func_35176_r() == 0)
            {
                if(rand.nextInt(20) == 0)
                {
                    int i = MathHelper.floor_double((posX - 2D) + rand.nextDouble() * 4D);
                    int l = MathHelper.floor_double(posY + rand.nextDouble() * 3D);
                    int j1 = MathHelper.floor_double((posZ - 2D) + rand.nextDouble() * 4D);
                    int l1 = worldObj.getBlockId(i, l, j1);
                    if(field_35186_b[l1])
                    {
                        func_35177_b(worldObj.getBlockId(i, l, j1));
                        func_35181_c(worldObj.getBlockMetadata(i, l, j1));
                        worldObj.setBlockWithNotify(i, l, j1, 0);
                    }
                }
            } else
            if(rand.nextInt(2000) == 0)
            {
                int j = MathHelper.floor_double((posX - 1.0D) + rand.nextDouble() * 2D);
                int i1 = MathHelper.floor_double(posY + rand.nextDouble() * 2D);
                int k1 = MathHelper.floor_double((posZ - 1.0D) + rand.nextDouble() * 2D);
                int i2 = worldObj.getBlockId(j, i1, k1);
                int j2 = worldObj.getBlockId(j, i1 - 1, k1);
                if(i2 == 0 && j2 > 0 && Block.blocksList[j2].renderAsNormalBlock())
                {
                    worldObj.setBlockAndMetadataWithNotify(j, i1, k1, func_35176_r(), func_35180_s());
                    func_35177_b(0);
                }
            }
        }
        for(int k = 0; k < 2; k++)
        {
            worldObj.spawnParticle("portal", posX + (rand.nextDouble() - 0.5D) * (double)width, (posY + rand.nextDouble() * (double)height) - 0.25D, posZ + (rand.nextDouble() - 0.5D) * (double)width, (rand.nextDouble() - 0.5D) * 2D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2D);
        }

        if(worldObj.isDaytime() && !worldObj.multiplayerWorld)
        {
            float f = getEntityBrightness(1.0F);
            if(f > 0.5F && worldObj.canBlockSeeTheSky(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) && rand.nextFloat() * 30F < (f - 0.4F) * 2.0F)
            {
                fire = 300;
            }
        }
        isJumping = false;
        if(entityToAttack != null)
        {
            faceEntity(entityToAttack, 100F, 100F);
        }
        if(!worldObj.multiplayerWorld)
        {
            if(entityToAttack != null)
            {
                if((entityToAttack instanceof EntityPlayer) && func_35183_c((EntityPlayer)entityToAttack))
                {
                    moveStrafing = moveForward = 0.0F;
                    moveSpeed = 0.0F;
                    if(entityToAttack.getDistanceSqToEntity(this) < 16D)
                    {
                        func_35178_q();
                    }
                    field_35184_d = 0;
                } else
                if(entityToAttack.getDistanceSqToEntity(this) > 256D && field_35184_d++ >= 30 && func_35182_c(entityToAttack))
                {
                    field_35184_d = 0;
                }
            } else
            {
                field_35184_d = 0;
            }
        }
        super.onLivingUpdate();
    }

    protected boolean func_35178_q()
    {
        double d = posX + (rand.nextDouble() - 0.5D) * 64D;
        double d1 = posY + (double)(rand.nextInt(64) - 32);
        double d2 = posZ + (rand.nextDouble() - 0.5D) * 64D;
        return func_35179_a_(d, d1, d2);
    }

    protected boolean func_35182_c(Entity entity)
    {
        Vec3D vec3d = Vec3D.createVector(posX - entity.posX, ((boundingBox.minY + (double)(height / 2.0F)) - entity.posY) + (double)entity.getEyeHeight(), posZ - entity.posZ);
        vec3d = vec3d.normalize();
        double d = 16D;
        double d1 = (posX + (rand.nextDouble() - 0.5D) * 8D) - vec3d.xCoord * d;
        double d2 = (posY + (double)(rand.nextInt(16) - 8)) - vec3d.yCoord * d;
        double d3 = (posZ + (rand.nextDouble() - 0.5D) * 8D) - vec3d.zCoord * d;
        return func_35179_a_(d1, d2, d3);
    }

    protected boolean func_35179_a_(double d, double d1, double d2)
    {
        double d3 = posX;
        double d4 = posY;
        double d5 = posZ;
        posX = d;
        posY = d1;
        posZ = d2;
        boolean flag = false;
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posY);
        int k = MathHelper.floor_double(posZ);
        if(worldObj.blockExists(i, j, k))
        {
            boolean flag1;
            for(flag1 = false; !flag1 && j > 0;)
            {
                int i1 = worldObj.getBlockId(i, j - 1, k);
                if(i1 == 0 || !Block.blocksList[i1].blockMaterial.getIsSolid())
                {
                    posY--;
                    j--;
                } else
                {
                    flag1 = true;
                }
            }

            if(flag1)
            {
                setPosition(posX, posY, posZ);
                if(worldObj.getCollidingBoundingBoxes(this, boundingBox).size() == 0 && !worldObj.getIsAnyLiquid(boundingBox))
                {
                    flag = true;
                }
            }
        }
        if(!flag)
        {
            setPosition(d3, d4, d5);
            return false;
        }
        int l = 128;
        for(int j1 = 0; j1 < l; j1++)
        {
            double d6 = (double)j1 / ((double)l - 1.0D);
            float f = (rand.nextFloat() - 0.5F) * 0.2F;
            float f1 = (rand.nextFloat() - 0.5F) * 0.2F;
            float f2 = (rand.nextFloat() - 0.5F) * 0.2F;
            double d7 = d3 + (posX - d3) * d6 + (rand.nextDouble() - 0.5D) * (double)width * 2D;
            double d8 = d4 + (posY - d4) * d6 + rand.nextDouble() * (double)height;
            double d9 = d5 + (posZ - d5) * d6 + (rand.nextDouble() - 0.5D) * (double)width * 2D;
            worldObj.spawnParticle("portal", d7, d8, d9, f, f1, f2);
        }

        return true;
    }

    protected String getLivingSound()
    {
        return "mob.zombie";
    }

    protected String getHurtSound()
    {
        return "mob.zombiehurt";
    }

    protected String getDeathSound()
    {
        return "mob.zombiedeath";
    }

    protected int getDropItemId()
    {
        return Item.field_35416_bo.shiftedIndex;
    }

    protected void a(boolean flag)
    {
        int i = getDropItemId();
        if(i > 0)
        {
            int j = rand.nextInt(2);
            for(int k = 0; k < j; k++)
            {
                dropItem(i, 1);
            }

        }
    }

    public void func_35177_b(int i)
    {
        dataWatcher.updateObject(16, Byte.valueOf((byte)(i & 0xff)));
    }

    public int func_35176_r()
    {
        return dataWatcher.getWatchableObjectByte(16);
    }

    public void func_35181_c(int i)
    {
        dataWatcher.updateObject(17, Byte.valueOf((byte)(i & 0xff)));
    }

    public int func_35180_s()
    {
        return dataWatcher.getWatchableObjectByte(17);
    }

    private static boolean field_35186_b[];
    public boolean field_35187_a;
    private int field_35184_d;
    private int field_35185_e;

    static 
    {
        field_35186_b = new boolean[256];
        field_35186_b[Block.stone.blockID] = true;
        field_35186_b[Block.grass.blockID] = true;
        field_35186_b[Block.dirt.blockID] = true;
        field_35186_b[Block.cobblestone.blockID] = true;
        field_35186_b[Block.planks.blockID] = true;
        field_35186_b[Block.sand.blockID] = true;
        field_35186_b[Block.gravel.blockID] = true;
        field_35186_b[Block.oreGold.blockID] = true;
        field_35186_b[Block.oreIron.blockID] = true;
        field_35186_b[Block.oreCoal.blockID] = true;
        field_35186_b[Block.wood.blockID] = true;
        field_35186_b[Block.leaves.blockID] = true;
        field_35186_b[Block.sponge.blockID] = true;
        field_35186_b[Block.glass.blockID] = true;
        field_35186_b[Block.oreLapis.blockID] = true;
        field_35186_b[Block.blockLapis.blockID] = true;
        field_35186_b[Block.sandStone.blockID] = true;
        field_35186_b[Block.cloth.blockID] = true;
        field_35186_b[Block.plantYellow.blockID] = true;
        field_35186_b[Block.plantRed.blockID] = true;
        field_35186_b[Block.mushroomBrown.blockID] = true;
        field_35186_b[Block.mushroomRed.blockID] = true;
        field_35186_b[Block.blockGold.blockID] = true;
        field_35186_b[Block.blockSteel.blockID] = true;
        field_35186_b[Block.brick.blockID] = true;
        field_35186_b[Block.tnt.blockID] = true;
        field_35186_b[Block.bookShelf.blockID] = true;
        field_35186_b[Block.cobblestoneMossy.blockID] = true;
        field_35186_b[Block.oreDiamond.blockID] = true;
        field_35186_b[Block.blockDiamond.blockID] = true;
        field_35186_b[Block.workbench.blockID] = true;
        field_35186_b[Block.oreRedstone.blockID] = true;
        field_35186_b[Block.oreRedstoneGlowing.blockID] = true;
        field_35186_b[Block.ice.blockID] = true;
        field_35186_b[Block.cactus.blockID] = true;
        field_35186_b[Block.blockClay.blockID] = true;
        field_35186_b[Block.pumpkin.blockID] = true;
        field_35186_b[Block.netherrack.blockID] = true;
        field_35186_b[Block.slowSand.blockID] = true;
        field_35186_b[Block.glowStone.blockID] = true;
        field_35186_b[Block.pumpkinLantern.blockID] = true;
        field_35186_b[Block.field_35285_bn.blockID] = true;
        field_35186_b[Block.field_35286_bo.blockID] = true;
        field_35186_b[Block.field_35287_bp.blockID] = true;
        field_35186_b[Block.field_35281_bs.blockID] = true;
    }
}
