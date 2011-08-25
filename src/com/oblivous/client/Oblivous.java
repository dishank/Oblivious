package com.oblivous.client;

import com.jme3.app.SimpleApplication;
import com.jme3.input.controls.ActionListener;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import com.oblivous.test.TestCube;

/**
 * 
 * @author Dishank Patel 8/22/2011
 *
 */
public class Oblivous extends SimpleApplication implements Runnable, ActionListener
{
	
	
	public static void main(String[] args)
	{
		//change what needs to start over here
		TestCube app = new TestCube();
		
        AppSettings gameSettings = null;
        gameSettings = new AppSettings(false);
        gameSettings.setResolution(1280, 720);
        gameSettings.setFullscreen(true);
        gameSettings.setVSync(true);
        gameSettings.setTitle("Oblivous");
        gameSettings.setUseInput(true);
        gameSettings.setFrameRate(500);
        gameSettings.setSamples(0);
        gameSettings.setRenderer("LWJGL-OpenGL2");
        app.setSettings(gameSettings);
    app.setShowSettings(false);
    app.start();
	}
	
	//Constructors
	public Oblivous(boolean fullscreen, boolean showInitializeScreen, int wPixels, int hPixels) 
	{

		
		
	}
	
	public Oblivous() 
	{
		
	}
	
	//Initialize Game//
	
	@Override
	public void onAction(String name, boolean isPressed, float tpf) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void simpleInitApp() {
		
		// TODO Auto-generated method stub
		

		
	}

}
	
	

