package com.oblivous.src;

public class State
{
	static boolean game;

	static boolean map;

	public static boolean checkState(boolean state)
	{
		if(game = true)
		{

			state = true;
		}
		else
		{ 
			state = false;
		
		}
		
		return state;
	}
	
	public static void changeState(boolean state)
	{
		if(state = true)
		{
			game = true;
			
		}
		else
		{
			game = false;
			
		}
	}
	
	public static boolean changeMapToFPS()
	{
		map = false;
		return map;
	}
	

	
}

