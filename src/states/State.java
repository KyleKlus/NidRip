package states;

import java.awt.Graphics;

import main.Game;

public abstract class State {
	//Statemanager
	private static State currentState = null;
	public static State getState() {
		return currentState;
	}
	public static void setState(State state) {
		currentState=state;
	}
	//Class
	protected Game game;
	public State(Game game) {
		this.game=game;
	}
	public abstract void update();
	public abstract void render(Graphics g);
}
