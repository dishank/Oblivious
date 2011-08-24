package com.oblivous.src;

import com.jme3.input.KeyInput;


public abstract class Weapons 
{
	
	public abstract void triggerButton(KeyInput key);
	public abstract void scope(int zoom, boolean typeOfScope);
	public abstract void speedOfBullet(int speedOfBullet);
	public abstract void typeOfBullet();
	public abstract void firingAnimation();
	public abstract void damage();

}
