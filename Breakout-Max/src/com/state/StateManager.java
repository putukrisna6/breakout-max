package com.state;

import java.awt.Graphics2D;

public class StateManager {
//	private ArrayList<State> states;
	private State[] states;
	private int currentState;
	
	public static final int NUMGAMESTATES = 4;
	
	public static final int MENUSTATE = 0;
	public static final int SELECTSTATE = 1;
	public static final int OPTIONSTATE = 2;
	public static final int LEVEL1STATE = 3;
	
	public StateManager() {
//		states = new ArrayList<State>();
		
		states = new State[NUMGAMESTATES];
		
		currentState = MENUSTATE;
		loadState(currentState);
	}
	
	private void loadState(int state) {
		if (state == MENUSTATE) {
			states[state] = new MenuState(this);
		}
		else if (state == SELECTSTATE) {
			states[state] = new LevelSelectState(this);
		}
		else if (state == OPTIONSTATE) {
			states[state] = new OptionState(this);
		}
		else if (state == LEVEL1STATE) {
			states[state] = new Level1State(this);
		}
	}
	private void unloadState(int state) {
		states[state] = null;
	}
	
	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		
		loadState(currentState);
	}
	public void update() {
		try {
			states[currentState].update();
		}
		catch (Exception e) {
			
		}
	}
	public void draw(Graphics2D g2d) {
		try {
			states[currentState].draw(g2d);
		}
		catch (Exception e) {
		}
	}
	public void keyPressed(int k) {
		states[currentState].keyPressed(k);
	}
	public void keyReleased(int k) {
		states[currentState].keyReleased(k);
	}
}