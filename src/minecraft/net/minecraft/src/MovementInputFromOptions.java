// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MovementInput, GameSettings, KeyBinding, EntityPlayer

public class MovementInputFromOptions extends MovementInput
{

    public MovementInputFromOptions(GameSettings gamesettings)
    {
        gameSettings = gamesettings;
    }

    public void updatePlayerMoveState(EntityPlayer entityplayer)
    {
        moveStrafe = 0.0F;
        moveForward = 0.0F;
        if(gameSettings.keyBindForward.field_35965_e)
        {
            moveForward++;
        }
        if(gameSettings.keyBindBack.field_35965_e)
        {
            moveForward--;
        }
        if(gameSettings.keyBindLeft.field_35965_e)
        {
            moveStrafe++;
        }
        if(gameSettings.keyBindRight.field_35965_e)
        {
            moveStrafe--;
        }
        jump = gameSettings.keyBindJump.field_35965_e;
        sneak = gameSettings.keyBindSneak.field_35965_e;
        if(sneak)
        {
            moveStrafe *= 0.29999999999999999D;
            moveForward *= 0.29999999999999999D;
        }
    }

    private GameSettings gameSettings;
}
