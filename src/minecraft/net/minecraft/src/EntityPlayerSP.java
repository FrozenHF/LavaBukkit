// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, MouseFilter, Session, MovementInput, 
//            PlayerController, AchievementList, StatFileWriter, GuiAchievement, 
//            World, SoundManager, Potion, PotionEffect, 
//            AxisAlignedBB, FoodStats, PlayerCapabilities, ItemStack, 
//            Item, NBTTagCompound, GuiEditSign, GuiChest, 
//            GuiCrafting, GuiFurnace, GuiDispenser, EntityCrit2FX, 
//            EffectRenderer, EntityPickupFX, InventoryPlayer, DamageSource, 
//            GuiIngame, StatBase, Achievement, MathHelper, 
//            TileEntitySign, IInventory, TileEntityFurnace, TileEntityDispenser, 
//            Entity

public class EntityPlayerSP extends EntityPlayer
{

    public EntityPlayerSP(Minecraft minecraft, World world, Session session, int i)
    {
        super(world);
        field_35224_c = 0;
        field_35221_d = 0;
        field_21903_bJ = new MouseFilter();
        field_21904_bK = new MouseFilter();
        field_21902_bL = new MouseFilter();
        mc = minecraft;
        dimension = i;
        if(session != null && session.username != null && session.username.length() > 0)
        {
            skinUrl = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftSkins/").append(session.username).append(".png").toString();
        }
        username = session.username;
    }

    public void moveEntity(double d, double d1, double d2)
    {
        super.moveEntity(d, d1, d2);
    }

    public void updateEntityActionState()
    {
        super.updateEntityActionState();
        moveStrafing = movementInput.moveStrafe;
        moveForward = movementInput.moveForward;
        isJumping = movementInput.jump;
        field_35226_aq = field_35222_e;
        field_35225_ar = field_35223_ap;
        field_35223_ap += (double)(rotationPitch - field_35223_ap) * 0.5D;
        field_35222_e += (double)(rotationYaw - field_35222_e) * 0.5D;
    }

    public void onLivingUpdate()
    {
        if(field_35221_d > 0)
        {
            field_35221_d--;
            if(field_35221_d == 0)
            {
                func_35113_c(false);
            }
        }
        if(field_35224_c > 0)
        {
            field_35224_c--;
        }
        if(mc.playerController.func_35643_e())
        {
            posX = posZ = 0.5D;
            posX = 0.0D;
            posZ = 0.0D;
            rotationYaw = (float)ticksExisted / 12F;
            rotationPitch = 10F;
            posY = 68.5D;
            return;
        }
        if(!mc.statFileWriter.hasAchievementUnlocked(AchievementList.openInventory))
        {
            mc.guiAchievement.queueAchievementInformation(AchievementList.openInventory);
        }
        prevTimeInPortal = timeInPortal;
        if(inPortal)
        {
            if(!worldObj.multiplayerWorld && ridingEntity != null)
            {
                mountEntity(null);
            }
            if(mc.currentScreen != null)
            {
                mc.displayGuiScreen(null);
            }
            if(timeInPortal == 0.0F)
            {
                mc.sndManager.playSoundFX("portal.trigger", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
            }
            timeInPortal += 0.0125F;
            if(timeInPortal >= 1.0F)
            {
                timeInPortal = 1.0F;
                if(!worldObj.multiplayerWorld)
                {
                    timeUntilPortal = 10;
                    mc.sndManager.playSoundFX("portal.travel", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
                    mc.usePortal();
                }
            }
            inPortal = false;
        } else
        if(func_35160_a(Potion.field_35684_k) && func_35167_b(Potion.field_35684_k).func_35802_b() > 60)
        {
            timeInPortal += 0.006666667F;
            if(timeInPortal > 1.0F)
            {
                timeInPortal = 1.0F;
            }
        } else
        {
            if(timeInPortal > 0.0F)
            {
                timeInPortal -= 0.05F;
            }
            if(timeInPortal < 0.0F)
            {
                timeInPortal = 0.0F;
            }
        }
        if(timeUntilPortal > 0)
        {
            timeUntilPortal--;
        }
        boolean flag = movementInput.jump;
        float f = 0.8F;
        boolean flag1 = movementInput.moveForward >= f;
        movementInput.updatePlayerMoveState(this);
        if(func_35196_Z())
        {
            movementInput.moveStrafe *= 0.2F;
            movementInput.moveForward *= 0.2F;
            field_35224_c = 0;
        }
        if(movementInput.sneak && ySize < 0.2F)
        {
            ySize = 0.2F;
        }
        pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ + (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ - (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ - (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ + (double)width * 0.34999999999999998D);
        boolean flag2 = (float)func_35191_at().func_35765_a() > 6F;
        if(onGround && !flag1 && movementInput.moveForward >= f && !func_35117_Q() && flag2 && !func_35196_Z())
        {
            if(field_35224_c == 0)
            {
                field_35224_c = 7;
            } else
            {
                func_35113_c(true);
                field_35224_c = 0;
            }
        }
        if(func_35117_Q() && (movementInput.moveForward < f || isCollidedHorizontally || !flag2))
        {
            func_35113_c(false);
        }
        if(field_35212_aW.field_35758_c && !flag && movementInput.jump)
        {
            if(field_35216_aw == 0)
            {
                field_35216_aw = 7;
            } else
            {
                field_35212_aW.field_35757_b = !field_35212_aW.field_35757_b;
                field_35216_aw = 0;
            }
        }
        if(field_35212_aW.field_35757_b)
        {
            if(movementInput.sneak)
            {
                motionY -= 0.14999999999999999D;
            }
            if(movementInput.jump)
            {
                motionY += 0.14999999999999999D;
            }
        }
        super.onLivingUpdate();
        if(onGround && field_35212_aW.field_35757_b)
        {
            field_35212_aW.field_35757_b = false;
        }
    }

    public float func_35220_u_()
    {
        float f = 1.0F;
        if(field_35212_aW.field_35757_b)
        {
            f *= 1.1F;
        }
        f *= ((field_35169_bv * func_35166_t_()) / field_35215_ba + 1.0F) / 2.0F;
        if(func_35196_Z() && func_35195_X().itemID == Item.bow.shiftedIndex)
        {
            int i = func_35192_aa();
            float f1 = (float)i / 20F;
            if(f1 > 1.0F)
            {
                f1 = 1.0F;
            } else
            {
                f1 *= f1;
            }
            f *= 1.0F - f1 * 0.15F;
        }
        return f;
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Score", score);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        score = nbttagcompound.getInteger("Score");
    }

    public void closeScreen()
    {
        super.closeScreen();
        mc.displayGuiScreen(null);
    }

    public void displayGUIEditSign(TileEntitySign tileentitysign)
    {
        mc.displayGuiScreen(new GuiEditSign(tileentitysign));
    }

    public void displayGUIChest(IInventory iinventory)
    {
        mc.displayGuiScreen(new GuiChest(inventory, iinventory));
    }

    public void displayWorkbenchGUI(int i, int j, int k)
    {
        mc.displayGuiScreen(new GuiCrafting(inventory, worldObj, i, j, k));
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        mc.displayGuiScreen(new GuiFurnace(inventory, tileentityfurnace));
    }

    public void displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        mc.displayGuiScreen(new GuiDispenser(inventory, tileentitydispenser));
    }

    public void func_35200_b(Entity entity)
    {
        mc.effectRenderer.addEffect(new EntityCrit2FX(mc.theWorld, entity));
    }

    public void onItemPickup(Entity entity, int i)
    {
        mc.effectRenderer.addEffect(new EntityPickupFX(mc.theWorld, entity, this, -0.5F));
    }

    public int getPlayerArmorValue()
    {
        return inventory.getTotalArmorValue();
    }

    public void sendChatMessage(String s)
    {
    }

    public boolean isSneaking()
    {
        return movementInput.sneak && !sleeping;
    }

    public void setHealth(int i)
    {
        int j = health - i;
        if(j <= 0)
        {
            health = i;
            if(j < 0)
            {
                heartsLife = heartsHalvesLife / 2;
            }
        } else
        {
            field_9346_af = j;
            prevHealth = health;
            heartsLife = heartsHalvesLife;
            b(DamageSource.field_35547_j, j);
            hurtTime = maxHurtTime = 10;
        }
    }

    public void respawnPlayer()
    {
        mc.respawn(false, 0);
    }

    public void func_6420_o()
    {
    }

    public void addChatMessage(String s)
    {
        mc.ingameGUI.addChatMessageTranslate(s);
    }

    public void addStat(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(statbase.isAchievement())
        {
            Achievement achievement = (Achievement)statbase;
            if(achievement.parentAchievement == null || mc.statFileWriter.hasAchievementUnlocked(achievement.parentAchievement))
            {
                if(!mc.statFileWriter.hasAchievementUnlocked(achievement))
                {
                    mc.guiAchievement.queueTakenAchievement(achievement);
                }
                mc.statFileWriter.readStat(statbase, i);
            }
        } else
        {
            mc.statFileWriter.readStat(statbase, i);
        }
    }

    private boolean isBlockTranslucent(int i, int j, int k)
    {
        return worldObj.isBlockNormalCube(i, j, k);
    }

    protected boolean pushOutOfBlocks(double d, double d1, double d2)
    {
        int i = MathHelper.floor_double(d);
        int j = MathHelper.floor_double(d1);
        int k = MathHelper.floor_double(d2);
        double d3 = d - (double)i;
        double d4 = d2 - (double)k;
        if(isBlockTranslucent(i, j, k) || isBlockTranslucent(i, j + 1, k))
        {
            boolean flag = !isBlockTranslucent(i - 1, j, k) && !isBlockTranslucent(i - 1, j + 1, k);
            boolean flag1 = !isBlockTranslucent(i + 1, j, k) && !isBlockTranslucent(i + 1, j + 1, k);
            boolean flag2 = !isBlockTranslucent(i, j, k - 1) && !isBlockTranslucent(i, j + 1, k - 1);
            boolean flag3 = !isBlockTranslucent(i, j, k + 1) && !isBlockTranslucent(i, j + 1, k + 1);
            byte byte0 = -1;
            double d5 = 9999D;
            if(flag && d3 < d5)
            {
                d5 = d3;
                byte0 = 0;
            }
            if(flag1 && 1.0D - d3 < d5)
            {
                d5 = 1.0D - d3;
                byte0 = 1;
            }
            if(flag2 && d4 < d5)
            {
                d5 = d4;
                byte0 = 4;
            }
            if(flag3 && 1.0D - d4 < d5)
            {
                double d6 = 1.0D - d4;
                byte0 = 5;
            }
            float f = 0.1F;
            if(byte0 == 0)
            {
                motionX = -f;
            }
            if(byte0 == 1)
            {
                motionX = f;
            }
            if(byte0 == 4)
            {
                motionZ = -f;
            }
            if(byte0 == 5)
            {
                motionZ = f;
            }
        }
        return false;
    }

    public void func_35113_c(boolean flag)
    {
        super.func_35113_c(flag);
        if(!flag)
        {
            field_35221_d = 0;
        } else
        {
            field_35221_d = 600;
        }
    }

    public void func_35219_c(int i, int j, int k)
    {
        field_35211_aX = i;
        field_35209_aZ = j;
        field_35210_aY = k;
    }

    public MovementInput movementInput;
    protected Minecraft mc;
    protected int field_35224_c;
    public int field_35221_d;
    public float field_35222_e;
    public float field_35223_ap;
    public float field_35226_aq;
    public float field_35225_ar;
    private MouseFilter field_21903_bJ;
    private MouseFilter field_21904_bK;
    private MouseFilter field_21902_bL;
}
