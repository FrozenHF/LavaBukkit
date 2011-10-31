package net.minecraft.src;

import java.awt.*;
import java.util.*;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class LavaBukkit {
	static boolean[] keyStates = new boolean[256];
	
	public static boolean jumpHack = false;
	public static int jumpHeight = 2;
	
	public static ArrayList activatedHacks = new ArrayList();
	
	
	public static void tick(){
		activatedHacks = new ArrayList();
		if(checkKey(Keyboard.KEY_J)){ jumpHack = !jumpHack;}
		if(jumpHack){ activatedHacks.add("Jump Heck");}
	}
	
	private static boolean checkKey(int i){
		if(Minecraft.currentScreen != null){
			return false;
		}
		 if(Keyboard.isKeyDown(i) != keyStates[i]){
			 return keyStates[i] = !keyStates[i];
		 }else{
			 return false;
		 }
	}
}
