package states;

import java.awt.Graphics;

import gameobjects.Entity;
import gameobjects.GameObject;
import gameobjects.GroundPiece;
import gameobjects.Player;
import gfx.Assets;
import main.Game;
import options.Options;

public class GameState extends State{
	//Objects
	public static GameObject[] gameobjects;//collection of gameobjects
	public static Entity[] players;//collection of players
	
	public GameState(Game game) {
		super(game);
		players = new Entity[Options.nPlayers];
		for(int i=0;i<players.length;i++) {
			players[i] = new Player(game, Options.window_width/2, 0, 30, 48, i, true);
		}
		gameobjects = new GameObject[1];
		gameobjects[0] = new GroundPiece(game,  (Options.window_width-1000)/2,  Options.window_height,  1000,  100,  0, Assets.groundpiece_01);
	}
	@Override
	public void update() {
		for(int i=0; i<gameobjects.length;i++) {
			if(!gameobjects[i].getExistanceState()) {
				gameobjects[i].update();
			}
		}
		for(int i=0; i<players.length;i++) {
			if(!players[i].getExistanceState()) {
				players[i].update();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.background_01, 0, 0, Options.window_width, Options.window_height, null);
		for(int i=0; i<gameobjects.length;i++) {
			if(!gameobjects[i].getExistanceState()) {
				gameobjects[i].render(g);
			}
		}
		for(int i=0; i<players.length;i++) {
			if(!players[i].getExistanceState()) {
				players[i].render(g);
			}
		}
	}
}
