// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityLiving, InventoryPlayer, FoodStats, PlayerCapabilities, 
//            ContainerPlayer, World, ChunkCoordinates, DataWatcher, 
//            ItemStack, Item, EnumAction, Container, 
//            StatList, Vec3D, Potion, PotionEffect, 
//            MathHelper, AxisAlignedBB, Entity, EntityItem, 
//            Material, NBTTagCompound, NBTTagList, DamageSource, 
//            EntityMob, EntityArrow, EntityCreeper, EntityGhast, 
//            EntityWolf, EnumStatus, WorldProvider, BlockBed, 
//            Block, IChunkProvider, EntityMinecart, AchievementList, 
//            EntityBoat, EntityPig, EntityFish, IInventory, 
//            TileEntityFurnace, TileEntityDispenser, TileEntitySign, StatBase

public abstract class EntityPlayer extends EntityLiving
{

    public EntityPlayer(World world)
    {
        super(world);
        inventory = new InventoryPlayer(this);
        field_35217_av = new FoodStats();
        field_35216_aw = 0;
        field_9371_f = 0;
        score = 0;
        isSwinging = false;
        swingProgressInt = 0;
        field_35214_aG = 0;
        timeUntilPortal = 20;
        inPortal = false;
        field_35212_aW = new PlayerCapabilities();
        field_35215_ba = 0.1F;
        field_35213_bb = 0.02F;
        damageRemainder = 0;
        fishEntity = null;
        inventorySlots = new ContainerPlayer(inventory, !world.multiplayerWorld);
        craftingInventory = inventorySlots;
        yOffset = 1.62F;
        ChunkCoordinates chunkcoordinates = world.getSpawnPoint();
        setLocationAndAngles((double)chunkcoordinates.posX + 0.5D, chunkcoordinates.posY + 1, (double)chunkcoordinates.posZ + 0.5D, 0.0F, 0.0F);
        health = 20;
        entityType = "humanoid";
        field_9353_B = 180F;
        fireResistance = 20;
        texture = "/mob/char.png";
    }

    protected void entityInit()
    {
        super.entityInit();
        dataWatcher.addObject(16, Byte.valueOf((byte)0));
        dataWatcher.addObject(17, Byte.valueOf((byte)0));
    }

    public ItemStack func_35195_X()
    {
        return field_34907_d;
    }

    public int func_35205_Y()
    {
        return field_34906_e;
    }

    public boolean func_35196_Z()
    {
        return field_34907_d != null;
    }

    public int func_35192_aa()
    {
        if(func_35196_Z())
        {
            return field_34907_d.func_35866_m() - field_34906_e;
        } else
        {
            return 0;
        }
    }

    public void func_35206_ab()
    {
        if(field_34907_d != null)
        {
            field_34907_d.func_35862_a(worldObj, this, field_34906_e);
        }
        func_35207_ac();
    }

    public void func_35207_ac()
    {
        field_34907_d = null;
        field_34906_e = 0;
        if(!worldObj.multiplayerWorld)
        {
            func_35116_d(false);
        }
    }

    public boolean func_35162_ad()
    {
        return func_35196_Z() && Item.itemsList[field_34907_d.itemID].func_35412_b(field_34907_d) == EnumAction.block;
    }

    public void onUpdate()
    {
        if(field_34907_d != null)
        {
            ItemStack itemstack = inventory.getCurrentItem();
            if(itemstack != field_34907_d)
            {
                func_35207_ac();
            } else
            {
                if(field_34906_e <= 25 && field_34906_e % 4 == 0)
                {
                    func_35201_a(itemstack, 5);
                }
                if(--field_34906_e == 0 && !worldObj.multiplayerWorld)
                {
                    func_35208_ae();
                }
            }
        }
        if(field_35214_aG > 0)
        {
            field_35214_aG--;
        }
        if(isPlayerSleeping())
        {
            sleepTimer++;
            if(sleepTimer > 100)
            {
                sleepTimer = 100;
            }
            if(!worldObj.multiplayerWorld)
            {
                if(!isInBed())
                {
                    wakeUpPlayer(true, true, false);
                } else
                if(worldObj.isDaytime())
                {
                    wakeUpPlayer(false, true, true);
                }
            }
        } else
        if(sleepTimer > 0)
        {
            sleepTimer++;
            if(sleepTimer >= 110)
            {
                sleepTimer = 0;
            }
        }
        super.onUpdate();
        if(!worldObj.multiplayerWorld && craftingInventory != null && !craftingInventory.canInteractWith(this))
        {
            closeScreen();
            craftingInventory = inventorySlots;
        }
        if(field_35212_aW.field_35757_b)
        {
            for(int i = 0; i < 8; i++) { }
        }
        if(fire > 0 && field_35212_aW.field_35759_a)
        {
            fire = 0;
        }
        field_20066_r = field_20063_u;
        field_20065_s = field_20062_v;
        field_20064_t = field_20061_w;
        double d = posX - field_20063_u;
        double d1 = posY - field_20062_v;
        double d2 = posZ - field_20061_w;
        double d3 = 10D;
        if(d > d3)
        {
            field_20066_r = field_20063_u = posX;
        }
        if(d2 > d3)
        {
            field_20064_t = field_20061_w = posZ;
        }
        if(d1 > d3)
        {
            field_20065_s = field_20062_v = posY;
        }
        if(d < -d3)
        {
            field_20066_r = field_20063_u = posX;
        }
        if(d2 < -d3)
        {
            field_20064_t = field_20061_w = posZ;
        }
        if(d1 < -d3)
        {
            field_20065_s = field_20062_v = posY;
        }
        field_20063_u += d * 0.25D;
        field_20061_w += d2 * 0.25D;
        field_20062_v += d1 * 0.25D;
        addStat(StatList.minutesPlayedStat, 1);
        if(ridingEntity == null)
        {
            startMinecartRidingCoordinate = null;
        }
        if(!worldObj.multiplayerWorld)
        {
            field_35217_av.func_35768_a(this);
        }
    }

    protected void func_35201_a(ItemStack itemstack, int i)
    {
        if(itemstack.func_35865_n() == EnumAction.eat)
        {
            for(int j = 0; j < i; j++)
            {
                Vec3D vec3d = Vec3D.createVector(((double)rand.nextFloat() - 0.5D) * 0.10000000000000001D, Math.random() * 0.10000000000000001D + 0.10000000000000001D, 0.0D);
                vec3d.rotateAroundX((-rotationPitch * 3.141593F) / 180F);
                vec3d.rotateAroundY((-rotationYaw * 3.141593F) / 180F);
                Vec3D vec3d1 = Vec3D.createVector(((double)rand.nextFloat() - 0.5D) * 0.29999999999999999D, (double)(-rand.nextFloat()) * 0.59999999999999998D - 0.29999999999999999D, 0.59999999999999998D);
                vec3d1.rotateAroundX((-rotationPitch * 3.141593F) / 180F);
                vec3d1.rotateAroundY((-rotationYaw * 3.141593F) / 180F);
                vec3d1 = vec3d1.addVector(posX, posY + (double)getEyeHeight(), posZ);
                worldObj.spawnParticle((new StringBuilder()).append("iconcrack_").append(itemstack.getItem().shiftedIndex).toString(), vec3d1.xCoord, vec3d1.yCoord, vec3d1.zCoord, vec3d.xCoord, vec3d.yCoord + 0.050000000000000003D, vec3d.zCoord);
            }

            worldObj.playSoundAtEntity(this, "mob.eat", 0.5F + 0.5F * (float)rand.nextInt(2), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected void func_35208_ae()
    {
        if(field_34907_d != null)
        {
            func_35201_a(field_34907_d, 16);
            int i = field_34907_d.stackSize;
            ItemStack itemstack = field_34907_d.func_35863_b(worldObj, this);
            if(itemstack != field_34907_d || itemstack != null && itemstack.stackSize != i)
            {
                inventory.mainInventory[inventory.currentItem] = itemstack;
                if(itemstack.stackSize == 0)
                {
                    inventory.mainInventory[inventory.currentItem] = null;
                }
            }
            func_35207_ac();
        }
    }

    public void handleHealthUpdate(byte byte0)
    {
        if(byte0 == 9)
        {
            func_35208_ae();
        } else
        {
            super.handleHealthUpdate(byte0);
        }
    }

    protected boolean isMovementBlocked()
    {
        return health <= 0 || isPlayerSleeping();
    }

    protected void closeScreen()
    {
        craftingInventory = inventorySlots;
    }

    public void updateCloak()
    {
        playerCloakUrl = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftCloaks/").append(username).append(".png").toString();
        cloakUrl = playerCloakUrl;
    }

    public void updateRidden()
    {
        double d = posX;
        double d1 = posY;
        double d2 = posZ;
        super.updateRidden();
        prevCameraYaw = cameraYaw;
        cameraYaw = 0.0F;
        addMountedMovementStat(posX - d, posY - d1, posZ - d2);
    }

    public void preparePlayerToSpawn()
    {
        yOffset = 1.62F;
        setSize(0.6F, 1.8F);
        super.preparePlayerToSpawn();
        health = 20;
        deathTime = 0;
    }

    private int func_35202_aE()
    {
        if(func_35160_a(Potion.field_35675_e))
        {
            return 6 - (1 + func_35167_b(Potion.field_35675_e).func_35801_c()) * 1;
        }
        if(func_35160_a(Potion.field_35672_f))
        {
            return 6 + (1 + func_35167_b(Potion.field_35672_f).func_35801_c()) * 2;
        } else
        {
            return 6;
        }
    }

    protected void updateEntityActionState()
    {
        int i = func_35202_aE();
        if(isSwinging)
        {
            swingProgressInt++;
            if(swingProgressInt >= i)
            {
                swingProgressInt = 0;
                isSwinging = false;
            }
        } else
        {
            swingProgressInt = 0;
        }
        swingProgress = (float)swingProgressInt / (float)i;
    }

    public void onLivingUpdate()
    {
        if(field_35216_aw > 0)
        {
            field_35216_aw--;
        }
        if(worldObj.difficultySetting == 0 && health < 20 && (ticksExisted % 20) * 12 == 0)
        {
            heal(1);
        }
        inventory.decrementAnimations();
        prevCameraYaw = cameraYaw;
        super.onLivingUpdate();
        field_35169_bv = field_35215_ba;
        field_35168_bw = field_35213_bb;
        if(func_35117_Q())
        {
            field_35169_bv += (double)field_35215_ba * 0.29999999999999999D;
            field_35168_bw += (double)field_35213_bb * 0.29999999999999999D;
        }
        float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
        float f1 = (float)Math.atan(-motionY * 0.20000000298023224D) * 15F;
        if(f > 0.1F)
        {
            f = 0.1F;
        }
        if(!onGround || health <= 0)
        {
            f = 0.0F;
        }
        if(onGround || health <= 0)
        {
            f1 = 0.0F;
        }
        cameraYaw += (f - cameraYaw) * 0.4F;
        cameraPitch += (f1 - cameraPitch) * 0.8F;
        if(health > 0)
        {
            List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(1.0D, 0.0D, 1.0D));
            if(list != null)
            {
                for(int i = 0; i < list.size(); i++)
                {
                    Entity entity = (Entity)list.get(i);
                    if(!entity.isDead)
                    {
                        collideWithPlayer(entity);
                    }
                }

            }
        }
    }

    private void collideWithPlayer(Entity entity)
    {
        entity.onCollideWithPlayer(this);
    }

    public int getScore()
    {
        return score;
    }

    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);
        setSize(0.2F, 0.2F);
        setPosition(posX, posY, posZ);
        motionY = 0.10000000149011612D;
        if(username.equals("Notch"))
        {
            dropPlayerItemWithRandomChoice(new ItemStack(Item.appleRed, 1), true);
        }
        inventory.dropAllItems();
        if(damagesource != null)
        {
            motionX = -MathHelper.cos(((attackedAtYaw + rotationYaw) * 3.141593F) / 180F) * 0.1F;
            motionZ = -MathHelper.sin(((attackedAtYaw + rotationYaw) * 3.141593F) / 180F) * 0.1F;
        } else
        {
            motionX = motionZ = 0.0D;
        }
        yOffset = 0.1F;
        addStat(StatList.deathsStat, 1);
    }

    public void addToPlayerScore(Entity entity, int i)
    {
        score += i;
        if(entity instanceof EntityPlayer)
        {
            addStat(StatList.playerKillsStat, 1);
        } else
        {
            addStat(StatList.mobKillsStat, 1);
        }
    }

    public void dropCurrentItem()
    {
        dropPlayerItemWithRandomChoice(inventory.decrStackSize(inventory.currentItem, 1), false);
    }

    public void dropPlayerItem(ItemStack itemstack)
    {
        dropPlayerItemWithRandomChoice(itemstack, false);
    }

    public void dropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
        if(itemstack == null)
        {
            return;
        }
        EntityItem entityitem = new EntityItem(worldObj, posX, (posY - 0.30000001192092896D) + (double)getEyeHeight(), posZ, itemstack);
        entityitem.delayBeforeCanPickup = 40;
        float f = 0.1F;
        if(flag)
        {
            float f2 = rand.nextFloat() * 0.5F;
            float f4 = rand.nextFloat() * 3.141593F * 2.0F;
            entityitem.motionX = -MathHelper.sin(f4) * f2;
            entityitem.motionZ = MathHelper.cos(f4) * f2;
            entityitem.motionY = 0.20000000298023224D;
        } else
        {
            float f1 = 0.3F;
            entityitem.motionX = -MathHelper.sin((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F) * f1;
            entityitem.motionZ = MathHelper.cos((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F) * f1;
            entityitem.motionY = -MathHelper.sin((rotationPitch / 180F) * 3.141593F) * f1 + 0.1F;
            f1 = 0.02F;
            float f3 = rand.nextFloat() * 3.141593F * 2.0F;
            f1 *= rand.nextFloat();
            entityitem.motionX += Math.cos(f3) * (double)f1;
            entityitem.motionY += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
            entityitem.motionZ += Math.sin(f3) * (double)f1;
        }
        joinEntityItemWithWorld(entityitem);
        addStat(StatList.dropStat, 1);
    }

    protected void joinEntityItemWithWorld(EntityItem entityitem)
    {
        worldObj.entityJoinedWorld(entityitem);
    }

    public float getCurrentPlayerStrVsBlock(Block block)
    {
        float f = inventory.getStrVsBlock(block);
        if(isInsideOfMaterial(Material.water))
        {
            f /= 5F;
        }
        if(!onGround)
        {
            f /= 5F;
        }
        if(func_35160_a(Potion.field_35675_e))
        {
            f *= 1.0F + (float)(func_35167_b(Potion.field_35675_e).func_35801_c() + 1) * 0.2F;
        }
        if(func_35160_a(Potion.field_35672_f))
        {
            f *= 1.0F - (float)(func_35167_b(Potion.field_35672_f).func_35801_c() + 1) * 0.2F;
        }
        return f;
    }

    public boolean canHarvestBlock(Block block)
    {
        return inventory.canHarvestBlock(block);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Inventory");
        inventory.readFromNBT(nbttaglist);
        dimension = nbttagcompound.getInteger("Dimension");
        sleeping = nbttagcompound.getBoolean("Sleeping");
        sleepTimer = nbttagcompound.getShort("SleepTimer");
        field_35211_aX = nbttagcompound.getInteger("Xp");
        field_35210_aY = nbttagcompound.getInteger("XpLevel");
        field_35209_aZ = nbttagcompound.getInteger("XpTotal");
        if(sleeping)
        {
            bedChunkCoordinates = new ChunkCoordinates(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ));
            wakeUpPlayer(true, true, false);
        }
        if(nbttagcompound.hasKey("SpawnX") && nbttagcompound.hasKey("SpawnY") && nbttagcompound.hasKey("SpawnZ"))
        {
            playerSpawnCoordinate = new ChunkCoordinates(nbttagcompound.getInteger("SpawnX"), nbttagcompound.getInteger("SpawnY"), nbttagcompound.getInteger("SpawnZ"));
        }
        field_35217_av.func_35766_a(nbttagcompound);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setTag("Inventory", inventory.writeToNBT(new NBTTagList()));
        nbttagcompound.setInteger("Dimension", dimension);
        nbttagcompound.setBoolean("Sleeping", sleeping);
        nbttagcompound.setShort("SleepTimer", (short)sleepTimer);
        nbttagcompound.setInteger("Xp", field_35211_aX);
        nbttagcompound.setInteger("XpLevel", field_35210_aY);
        nbttagcompound.setInteger("XpTotal", field_35209_aZ);
        if(playerSpawnCoordinate != null)
        {
            nbttagcompound.setInteger("SpawnX", playerSpawnCoordinate.posX);
            nbttagcompound.setInteger("SpawnY", playerSpawnCoordinate.posY);
            nbttagcompound.setInteger("SpawnZ", playerSpawnCoordinate.posZ);
        }
        field_35217_av.func_35763_b(nbttagcompound);
    }

    public void displayGUIChest(IInventory iinventory)
    {
    }

    public void displayWorkbenchGUI(int i, int j, int k)
    {
    }

    public void onItemPickup(Entity entity, int i)
    {
    }

    public float getEyeHeight()
    {
        return 0.12F;
    }

    protected void resetHeight()
    {
        yOffset = 1.62F;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        if(field_35212_aW.field_35759_a && !damagesource.func_35529_d())
        {
            return false;
        }
        entityAge = 0;
        if(health <= 0)
        {
            return false;
        }
        if(isPlayerSleeping() && !worldObj.multiplayerWorld)
        {
            wakeUpPlayer(true, true, false);
        }
        Entity entity = damagesource.func_35532_a();
        if((entity instanceof EntityMob) || (entity instanceof EntityArrow))
        {
            if(worldObj.difficultySetting == 0)
            {
                i = 0;
            }
            if(worldObj.difficultySetting == 1)
            {
                i = i / 3 + 1;
            }
            if(worldObj.difficultySetting == 3)
            {
                i = (i * 3) / 2;
            }
        }
        if(i == 0)
        {
            return false;
        }
        Entity entity1 = entity;
        if((entity1 instanceof EntityArrow) && ((EntityArrow)entity1).shootingEntity != null)
        {
            entity1 = ((EntityArrow)entity1).shootingEntity;
        }
        if(entity1 instanceof EntityLiving)
        {
            alertWolves((EntityLiving)entity1, false);
        }
        addStat(StatList.damageTakenStat, i);
        return super.attackEntityFrom(damagesource, i);
    }

    protected boolean isPVPEnabled()
    {
        return false;
    }

    protected void alertWolves(EntityLiving entityliving, boolean flag)
    {
        if((entityliving instanceof EntityCreeper) || (entityliving instanceof EntityGhast))
        {
            return;
        }
        if(entityliving instanceof EntityWolf)
        {
            EntityWolf entitywolf = (EntityWolf)entityliving;
            if(entitywolf.isWolfTamed() && username.equals(entitywolf.getWolfOwner()))
            {
                return;
            }
        }
        if((entityliving instanceof EntityPlayer) && !isPVPEnabled())
        {
            return;
        }
        List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityWolf.class, AxisAlignedBB.getBoundingBoxFromPool(posX, posY, posZ, posX + 1.0D, posY + 1.0D, posZ + 1.0D).expand(16D, 4D, 16D));
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Entity entity = (Entity)iterator.next();
            EntityWolf entitywolf1 = (EntityWolf)entity;
            if(entitywolf1.isWolfTamed() && entitywolf1.getEntityToAttack() == null && username.equals(entitywolf1.getWolfOwner()) && (!flag || !entitywolf1.isWolfSitting()))
            {
                entitywolf1.setIsSitting(false);
                entitywolf1.setEntityToAttack(entityliving);
            }
        } while(true);
    }

    protected void b(DamageSource damagesource, int i)
    {
        if(!damagesource.func_35534_b() && func_35162_ad())
        {
            i = 1 + i >> 1;
        }
        if(!damagesource.func_35534_b())
        {
            int j = 25 - inventory.getTotalArmorValue();
            int k = i * j + damageRemainder;
            inventory.damageArmor(i);
            i = k / 25;
            damageRemainder = k % 25;
        }
        func_35198_d(damagesource.func_35533_c());
        super.b(damagesource, i);
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
    }

    public void displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
    }

    public void displayGUIEditSign(TileEntitySign tileentitysign)
    {
    }

    public void useCurrentItemOnEntity(Entity entity)
    {
        if(entity.interact(this))
        {
            return;
        }
        ItemStack itemstack = getCurrentEquippedItem();
        if(itemstack != null && (entity instanceof EntityLiving))
        {
            itemstack.useItemOnEntity((EntityLiving)entity);
            if(itemstack.stackSize <= 0)
            {
                itemstack.onItemDestroyedByUse(this);
                destroyCurrentEquippedItem();
            }
        }
    }

    public ItemStack getCurrentEquippedItem()
    {
        return inventory.getCurrentItem();
    }

    public void destroyCurrentEquippedItem()
    {
        inventory.setInventorySlotContents(inventory.currentItem, null);
    }

    public double getYOffset()
    {
        return (double)(yOffset - 0.5F);
    }

    public void swingItem()
    {
        if(!isSwinging || swingProgressInt >= func_35202_aE() / 2 || swingProgressInt < 0)
        {
            swingProgressInt = -1;
            isSwinging = true;
        }
    }

    public void attackTargetEntityWithCurrentItem(Entity entity)
    {
        int i = inventory.getDamageVsEntity(entity);
        if(i > 0)
        {
            boolean flag = motionY < 0.0D && !onGround && !isOnLadder() && !isInWater();
            if(flag)
            {
                i = (i * 3) / 2 + 1;
            }
            boolean flag1 = entity.attackEntityFrom(DamageSource.func_35527_a(this), i);
            if(flag1)
            {
                if(func_35117_Q())
                {
                    entity.addVelocity(-MathHelper.sin((rotationYaw * 3.141593F) / 180F) * 1.0F, 0.10000000000000001D, MathHelper.cos((rotationYaw * 3.141593F) / 180F) * 1.0F);
                    motionX *= 0.59999999999999998D;
                    motionZ *= 0.59999999999999998D;
                    func_35113_c(false);
                }
                if(flag)
                {
                    func_35200_b(entity);
                }
            }
            ItemStack itemstack = getCurrentEquippedItem();
            if(itemstack != null && (entity instanceof EntityLiving))
            {
                itemstack.hitEntity((EntityLiving)entity, this);
                if(itemstack.stackSize <= 0)
                {
                    itemstack.onItemDestroyedByUse(this);
                    destroyCurrentEquippedItem();
                }
            }
            if(entity instanceof EntityLiving)
            {
                if(entity.isEntityAlive())
                {
                    alertWolves((EntityLiving)entity, true);
                }
                addStat(StatList.damageDealtStat, i);
            }
            func_35198_d(0.3F);
        }
    }

    public void func_35200_b(Entity entity)
    {
    }

    public void respawnPlayer()
    {
    }

    public abstract void func_6420_o();

    public void onItemStackChanged(ItemStack itemstack)
    {
    }

    public void setEntityDead()
    {
        super.setEntityDead();
        inventorySlots.onCraftGuiClosed(this);
        if(craftingInventory != null)
        {
            craftingInventory.onCraftGuiClosed(this);
        }
    }

    public boolean isEntityInsideOpaqueBlock()
    {
        return !sleeping && super.isEntityInsideOpaqueBlock();
    }

    public EnumStatus sleepInBedAt(int i, int j, int k)
    {
        if(!worldObj.multiplayerWorld)
        {
            if(isPlayerSleeping() || !isEntityAlive())
            {
                return EnumStatus.OTHER_PROBLEM;
            }
            if(worldObj.worldProvider.isNether)
            {
                return EnumStatus.NOT_POSSIBLE_HERE;
            }
            if(worldObj.isDaytime())
            {
                return EnumStatus.NOT_POSSIBLE_NOW;
            }
            if(Math.abs(posX - (double)i) > 3D || Math.abs(posY - (double)j) > 2D || Math.abs(posZ - (double)k) > 3D)
            {
                return EnumStatus.TOO_FAR_AWAY;
            }
        }
        setSize(0.2F, 0.2F);
        yOffset = 0.2F;
        if(worldObj.blockExists(i, j, k))
        {
            int l = worldObj.getBlockMetadata(i, j, k);
            int i1 = BlockBed.getDirectionFromMetadata(l);
            float f = 0.5F;
            float f1 = 0.5F;
            switch(i1)
            {
            case 0: // '\0'
                f1 = 0.9F;
                break;

            case 2: // '\002'
                f1 = 0.1F;
                break;

            case 1: // '\001'
                f = 0.1F;
                break;

            case 3: // '\003'
                f = 0.9F;
                break;
            }
            func_22052_e(i1);
            setPosition((float)i + f, (float)j + 0.9375F, (float)k + f1);
        } else
        {
            setPosition((float)i + 0.5F, (float)j + 0.9375F, (float)k + 0.5F);
        }
        sleeping = true;
        sleepTimer = 0;
        bedChunkCoordinates = new ChunkCoordinates(i, j, k);
        motionX = motionZ = motionY = 0.0D;
        if(!worldObj.multiplayerWorld)
        {
            worldObj.updateAllPlayersSleepingFlag();
        }
        return EnumStatus.OK;
    }

    private void func_22052_e(int i)
    {
        field_22063_x = 0.0F;
        field_22061_z = 0.0F;
        switch(i)
        {
        case 0: // '\0'
            field_22061_z = -1.8F;
            break;

        case 2: // '\002'
            field_22061_z = 1.8F;
            break;

        case 1: // '\001'
            field_22063_x = 1.8F;
            break;

        case 3: // '\003'
            field_22063_x = -1.8F;
            break;
        }
    }

    public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2)
    {
        setSize(0.6F, 1.8F);
        resetHeight();
        ChunkCoordinates chunkcoordinates = bedChunkCoordinates;
        ChunkCoordinates chunkcoordinates1 = bedChunkCoordinates;
        if(chunkcoordinates != null && worldObj.getBlockId(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ) == Block.bed.blockID)
        {
            BlockBed.setBedOccupied(worldObj, chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, false);
            ChunkCoordinates chunkcoordinates2 = BlockBed.getNearestEmptyChunkCoordinates(worldObj, chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, 0);
            if(chunkcoordinates2 == null)
            {
                chunkcoordinates2 = new ChunkCoordinates(chunkcoordinates.posX, chunkcoordinates.posY + 1, chunkcoordinates.posZ);
            }
            setPosition((float)chunkcoordinates2.posX + 0.5F, (float)chunkcoordinates2.posY + yOffset + 0.1F, (float)chunkcoordinates2.posZ + 0.5F);
        }
        sleeping = false;
        if(!worldObj.multiplayerWorld && flag1)
        {
            worldObj.updateAllPlayersSleepingFlag();
        }
        if(flag)
        {
            sleepTimer = 0;
        } else
        {
            sleepTimer = 100;
        }
        if(flag2)
        {
            setPlayerSpawnCoordinate(bedChunkCoordinates);
        }
    }

    private boolean isInBed()
    {
        return worldObj.getBlockId(bedChunkCoordinates.posX, bedChunkCoordinates.posY, bedChunkCoordinates.posZ) == Block.bed.blockID;
    }

    public static ChunkCoordinates verifyRespawnCoordinates(World world, ChunkCoordinates chunkcoordinates)
    {
        IChunkProvider ichunkprovider = world.getIChunkProvider();
        ichunkprovider.loadChunk(chunkcoordinates.posX - 3 >> 4, chunkcoordinates.posZ - 3 >> 4);
        ichunkprovider.loadChunk(chunkcoordinates.posX + 3 >> 4, chunkcoordinates.posZ - 3 >> 4);
        ichunkprovider.loadChunk(chunkcoordinates.posX - 3 >> 4, chunkcoordinates.posZ + 3 >> 4);
        ichunkprovider.loadChunk(chunkcoordinates.posX + 3 >> 4, chunkcoordinates.posZ + 3 >> 4);
        if(world.getBlockId(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ) != Block.bed.blockID)
        {
            return null;
        } else
        {
            ChunkCoordinates chunkcoordinates1 = BlockBed.getNearestEmptyChunkCoordinates(world, chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, 0);
            return chunkcoordinates1;
        }
    }

    public float getBedOrientationInDegrees()
    {
        if(bedChunkCoordinates != null)
        {
            int i = worldObj.getBlockMetadata(bedChunkCoordinates.posX, bedChunkCoordinates.posY, bedChunkCoordinates.posZ);
            int j = BlockBed.getDirectionFromMetadata(i);
            switch(j)
            {
            case 0: // '\0'
                return 90F;

            case 1: // '\001'
                return 0.0F;

            case 2: // '\002'
                return 270F;

            case 3: // '\003'
                return 180F;
            }
        }
        return 0.0F;
    }

    public boolean isPlayerSleeping()
    {
        return sleeping;
    }

    public boolean isPlayerFullyAsleep()
    {
        return sleeping && sleepTimer >= 100;
    }

    public int func_22060_M()
    {
        return sleepTimer;
    }

    public void addChatMessage(String s)
    {
    }

    public ChunkCoordinates getPlayerSpawnCoordinate()
    {
        return playerSpawnCoordinate;
    }

    public void setPlayerSpawnCoordinate(ChunkCoordinates chunkcoordinates)
    {
        if(chunkcoordinates != null)
        {
            playerSpawnCoordinate = new ChunkCoordinates(chunkcoordinates);
        } else
        {
            playerSpawnCoordinate = null;
        }
    }

    public void triggerAchievement(StatBase statbase)
    {
        addStat(statbase, 1);
    }

    public void addStat(StatBase statbase, int i)
    {
    }

    protected void jump()
    {
        super.jump();
        addStat(StatList.jumpStat, 1);
        if(func_35117_Q())
        {
            func_35198_d(0.8F);
        } else
        {
            func_35198_d(0.2F);
        }
    }

    public void moveEntityWithHeading(float f, float f1)
    {
        double d = posX;
        double d1 = posY;
        double d2 = posZ;
        if(field_35212_aW.field_35757_b)
        {
            double d3 = motionY;
            float f2 = field_35168_bw;
            field_35168_bw = 0.05F;
            super.moveEntityWithHeading(f, f1);
            motionY = d3 * 0.59999999999999998D;
            field_35168_bw = f2;
        } else
        {
            super.moveEntityWithHeading(f, f1);
        }
        addMovementStat(posX - d, posY - d1, posZ - d2);
    }

    public void addMovementStat(double d, double d1, double d2)
    {
        if(ridingEntity != null)
        {
            return;
        }
        if(isInsideOfMaterial(Material.water))
        {
            int i = Math.round(MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2) * 100F);
            if(i > 0)
            {
                addStat(StatList.distanceDoveStat, i);
                func_35198_d(0.015F * (float)i * 0.01F);
            }
        } else
        if(isInWater())
        {
            int j = Math.round(MathHelper.sqrt_double(d * d + d2 * d2) * 100F);
            if(j > 0)
            {
                addStat(StatList.distanceSwumStat, j);
                func_35198_d(0.015F * (float)j * 0.01F);
            }
        } else
        if(isOnLadder())
        {
            if(d1 > 0.0D)
            {
                addStat(StatList.distanceClimbedStat, (int)Math.round(d1 * 100D));
            }
        } else
        if(onGround)
        {
            int k = Math.round(MathHelper.sqrt_double(d * d + d2 * d2) * 100F);
            if(k > 0)
            {
                addStat(StatList.distanceWalkedStat, k);
                if(func_35117_Q())
                {
                    func_35198_d(0.09999999F * (float)k * 0.01F);
                } else
                {
                    func_35198_d(0.01F * (float)k * 0.01F);
                }
            }
        } else
        {
            int l = Math.round(MathHelper.sqrt_double(d * d + d2 * d2) * 100F);
            if(l > 25)
            {
                addStat(StatList.distanceFlownStat, l);
            }
        }
    }

    private void addMountedMovementStat(double d, double d1, double d2)
    {
        if(ridingEntity != null)
        {
            int i = Math.round(MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2) * 100F);
            if(i > 0)
            {
                if(ridingEntity instanceof EntityMinecart)
                {
                    addStat(StatList.distanceByMinecartStat, i);
                    if(startMinecartRidingCoordinate == null)
                    {
                        startMinecartRidingCoordinate = new ChunkCoordinates(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ));
                    } else
                    if(startMinecartRidingCoordinate.getSqDistanceTo(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ)) >= 1000D)
                    {
                        addStat(AchievementList.onARail, 1);
                    }
                } else
                if(ridingEntity instanceof EntityBoat)
                {
                    addStat(StatList.distanceByBoatStat, i);
                } else
                if(ridingEntity instanceof EntityPig)
                {
                    addStat(StatList.distanceByPigStat, i);
                }
            }
        }
    }

    protected void fall(float f)
    {
        if(field_35212_aW.field_35758_c)
        {
            return;
        }
        if(f >= 2.0F)
        {
            addStat(StatList.distanceFallenStat, (int)Math.round((double)f * 100D));
        }
        super.fall(f);
    }

    public void onKillEntity(EntityLiving entityliving)
    {
        if(entityliving instanceof EntityMob)
        {
            triggerAchievement(AchievementList.killEnemy);
        }
    }

    public int getItemIcon(ItemStack itemstack)
    {
        int i = super.getItemIcon(itemstack);
        if(itemstack.itemID == Item.fishingRod.shiftedIndex && fishEntity != null)
        {
            i = itemstack.getIconIndex() + 16;
        } else
        if(field_34907_d != null && itemstack.itemID == Item.bow.shiftedIndex)
        {
            int j = itemstack.func_35866_m() - field_34906_e;
            if(j >= 18)
            {
                return 133;
            }
            if(j > 13)
            {
                return 117;
            }
            if(j > 0)
            {
                return 101;
            }
        }
        return i;
    }

    public void setInPortal()
    {
        if(timeUntilPortal > 0)
        {
            timeUntilPortal = 10;
            return;
        } else
        {
            inPortal = true;
            return;
        }
    }

    public void func_35204_c(int i)
    {
        field_35211_aX += i;
        field_35209_aZ += i;
        for(; field_35211_aX >= func_35193_as(); func_35203_aG())
        {
            field_35211_aX -= func_35193_as();
        }

    }

    public int func_35193_as()
    {
        return (field_35210_aY + 1) * 10;
    }

    private void func_35203_aG()
    {
        field_35210_aY++;
    }

    public void func_35198_d(float f)
    {
        if(field_35212_aW.field_35759_a)
        {
            return;
        }
        if(!worldObj.multiplayerWorld)
        {
            field_35217_av.func_35762_a(f);
        }
    }

    public FoodStats func_35191_at()
    {
        return field_35217_av;
    }

    public boolean func_35197_b(boolean flag)
    {
        return (flag || field_35217_av.func_35770_c()) && !field_35212_aW.field_35759_a;
    }

    public boolean func_35194_au()
    {
        return health > 0 && health < 20;
    }

    public void func_35199_b(ItemStack itemstack, int i)
    {
        if(itemstack == field_34907_d)
        {
            return;
        }
        field_34907_d = itemstack;
        field_34906_e = i;
        if(!worldObj.multiplayerWorld)
        {
            func_35116_d(true);
        }
    }

    public boolean func_35190_e(int i, int j, int k)
    {
        return true;
    }

    protected int a(EntityPlayer entityplayer)
    {
        return field_35209_aZ >> 1;
    }

    protected boolean func_35163_av()
    {
        return true;
    }

    public InventoryPlayer inventory;
    public Container inventorySlots;
    public Container craftingInventory;
    protected FoodStats field_35217_av;
    protected int field_35216_aw;
    public byte field_9371_f;
    public int score;
    public float prevCameraYaw;
    public float cameraYaw;
    public boolean isSwinging;
    public int swingProgressInt;
    public String username;
    public int dimension;
    public String playerCloakUrl;
    public int field_35214_aG;
    public double field_20066_r;
    public double field_20065_s;
    public double field_20064_t;
    public double field_20063_u;
    public double field_20062_v;
    public double field_20061_w;
    protected boolean sleeping;
    public ChunkCoordinates bedChunkCoordinates;
    private int sleepTimer;
    public float field_22063_x;
    public float field_22062_y;
    public float field_22061_z;
    private ChunkCoordinates playerSpawnCoordinate;
    private ChunkCoordinates startMinecartRidingCoordinate;
    public int timeUntilPortal;
    protected boolean inPortal;
    public float timeInPortal;
    public float prevTimeInPortal;
    public PlayerCapabilities field_35212_aW;
    public int field_35211_aX;
    public int field_35210_aY;
    public int field_35209_aZ;
    private ItemStack field_34907_d;
    private int field_34906_e;
    protected float field_35215_ba;
    protected float field_35213_bb;
    private int damageRemainder;
    public EntityFish fishEntity;
}
