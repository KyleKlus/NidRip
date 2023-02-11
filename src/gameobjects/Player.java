package gameobjects;

import java.awt.Graphics;

import gfx.Assets;
import main.Game;

public class Player extends Entity{
	private final int DEFAULT_PLAYER_TEXTURE_WIDTH=46;
	private final int DEFAULT_PLAYER_TEXTURE_HEIGHT=50;
	private static double sizeMultiplicator=1.5;
	public Player(Game game, float px, float py, int width, int height, int entityID, boolean pxRight) {
		super(game, px, py, (int)(width*sizeMultiplicator), (int)(height*sizeMultiplicator), entityID, pxRight);
	}
	
	private void getInput() {
		xMove=0;
		yMove=0;
		if(game.getKeyManager().up) {
			yMove= -speed-10-5;
		}
		if(game.getKeyManager().down) {
			
		}
		if(game.getKeyManager().left) {
			xMove= -speed;
			pxRight=false;
		}
		if(game.getKeyManager().right) {
			xMove= speed;
			pxRight=true;
		}
		yMove+=gravity;
	}
	
	@Override
	public void update() {
		getInput();
		move();
	}

	@Override
	public void render(Graphics g) {
		if(!(Math.signum(yMove)==1.0)&&yMove!=0) {
			if(pxRight) {
				g.drawImage(Assets.player_right_jumping, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}else {
				g.drawImage(Assets.player_left_jumping, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}
		}else if(!(Math.signum(yMove)==-1.0)&&yMove!=0) {
			if(pxRight) {
				g.drawImage(Assets.player_right_falling, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}else {
				g.drawImage(Assets.player_left_falling, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}
		}else if(Math.signum(xMove)==-1.0&&yMove==0) {
			g.drawImage(Assets.player_left_running_01, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
		}else if(Math.signum(xMove)==1.0&&yMove==0) {
			g.drawImage(Assets.player_right_running_01, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
		}else if(xMove==0&&yMove==0&&!game.getKeyManager().down) {
			if(pxRight) {
				g.drawImage(Assets.player_right_standing, (int) (px-(width-DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator)/2), (int) (py-(height-DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator)/2), (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}else {
				g.drawImage(Assets.player_left_standing, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}
		}else if(xMove==0&&yMove==0&&game.getKeyManager().down) {
			if(pxRight) {
				g.drawImage(Assets.player_right_crouching, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}else {
				g.drawImage(Assets.player_left_crouching, (int) px, (int) py, (int)(DEFAULT_PLAYER_TEXTURE_WIDTH*sizeMultiplicator), (int)(DEFAULT_PLAYER_TEXTURE_HEIGHT*sizeMultiplicator), null);
			}
		}
		
	}
}
