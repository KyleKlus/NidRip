package gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;

public abstract class Entity extends GameObject{
	//entity default variables
	public static final float DEFAULT_SPEED=6;
	//entity variables
	protected boolean pxRight;
	protected float speed;
	protected float xMove;
	protected float yMove;
	//Entity ID
	protected int entityID;
	
	public Entity(Game game, float px, float py, int width, int height, int entityID, boolean pxRight) {
		super(game, (short)1, px, py, width, height);
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
		this.pxRight=pxRight;
		this.entityID=entityID;
	}
	public void move(Entity[][] entitys) {
		//detect collision
		for(int j=0;j<entitys.length;j++) {
			for(int i=0;i<entitys[j].length;i++) {
				if((!(categoryIndex==j&&entityIndex==i)&&(entitys[j][i]).hasCollision())) {
					if(Math.signum(xMove)==1.0) {
						if(!entitys[j][i].getBounds().contains(px+width+xMove, py)&&!entitys[j][i].getBounds().contains(px+width+xMove, py+height)) {
							px+=xMove;
						}else {
							xMove=0;
						}
					}else if(Math.signum(xMove)==-1.0){
						if(!entitys[j][i].getBounds().contains(px+xMove, py)&&!entitys[j][i].getBounds().contains(px+xMove, py+height)) {
							px+=xMove;
						}else {
							xMove=0;
						}
					}
					if(Math.signum(yMove)==1.0) {
						if(!entitys[j][i].getBounds().contains(px, py+height+yMove)&&!entitys[j][i].getBounds().contains(px+width, py+height+yMove)) {
							py+=yMove;
						}else {
							yMove=0;
						}
					}else if(Math.signum(yMove)==-1.0){
						if(!entitys[j][i].getBounds().contains(px, py+yMove)&&!entitys[j][i].getBounds().contains(px+width, py+yMove)) {
							py+=yMove;
						}else {
							yMove=0;
						}
					}
				}
			}
		}
	}
	/**
	 * @return the speed
	 */
	public float getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	/**
	 * @return the xMove
	 */
	public float getxMove() {
		return xMove;
	}
	/**
	 * @return the yMove
	 */
	public float getyMove() {
		return yMove;
	}
	/**
	 * @return the entityID
	 */
	public int getEntityID() {
		return entityID;
	}
}
