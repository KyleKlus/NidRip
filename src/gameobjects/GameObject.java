package gameobjects;

import java.awt.Graphics;

import main.Game;

public abstract class GameObject {
	//entity default variables
	public static final boolean DEFAULT_DEAD_STATE=false;
	public static final boolean DEFAULT_HAS_GRAVITY=true;
	public static final boolean DEFAULT_HAS_COLLISION=true;
	public static final float DEFAULT_GRAVITY=10;
	//Gameobject Variables
	protected Game game;
	protected boolean existanceState;
	protected boolean collisionState;
	protected boolean gravityState;
	protected float gravity;
	protected float px, py;
	protected int width, height;
	protected short typeID;
	
	public GameObject(Game game, short typeID, float px, float py, int width, int height) {
		this.game=game;
		this.px=px;
		this.py=py;
		this.width=width;
		this.height=height;
		this.typeID=typeID;
		existanceState=DEFAULT_DEAD_STATE;
		collisionState=DEFAULT_HAS_COLLISION;
		gravityState=DEFAULT_HAS_GRAVITY;
		gravity=DEFAULT_GRAVITY;
	}
	public GameObject(Game game, float px, float py, int width, int height) {
		this.game=game;
		this.px=px;
		this.py=py;
		this.width=width;
		this.height=height;
		typeID=0;
		existanceState=DEFAULT_DEAD_STATE;
		collisionState=DEFAULT_HAS_COLLISION;
		gravityState=DEFAULT_HAS_GRAVITY;
		gravity=DEFAULT_GRAVITY;
	}
	public abstract void update();
	public abstract void render(Graphics g);
	/**
	 * @return the existanceState
	 */
	public boolean getExistanceState() {
		return existanceState;
	}
	/**
	 * @param existanceState the existanceState to set
	 */
	public void setExistanceState(boolean existanceState) {
		this.existanceState = existanceState;
	}
	/**
	 * @return the collisionState
	 */
	public boolean getCollisionState() {
		return collisionState;
	}
	/**
	 * @param collisionState the collisionState to set
	 */
	public void setCollisionState(boolean collisionState) {
		this.collisionState = collisionState;
	}
	/**
	 * @return the gravityState
	 */
	public boolean getGravityState() {
		return gravityState;
	}
	/**
	 * @param gravityState the gravityState to set
	 */
	public void setGravityState(boolean gravityState) {
		this.gravityState = gravityState;
	}
	/**
	 * @return the gravity
	 */
	public float getGravity() {
		return gravity;
	}
	/**
	 * @param gravity the gravity to set
	 */
	public void setGravity(float gravity) {
		this.gravity = gravity;
	}
	/**
	 * @return the px
	 */
	public float getPx() {
		return px;
	}
	/**
	 * @return the py
	 */
	public float getPy() {
		return py;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}
	/**
	 * @return the typeID
	 */
	public short getTypeID() {
		return typeID;
	}
	
}
