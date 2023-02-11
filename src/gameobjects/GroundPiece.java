package gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;

public class GroundPiece extends GameObject{
	private BufferedImage pieceTexture;
	private int objectID;
	public GroundPiece(Game game, float px, float py, int width, int height, int objectID, BufferedImage pieceTexture) {
		super(game, px, py, width, height);
		this.pieceTexture=pieceTexture;
		this.objectID=objectID;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(pieceTexture, (int) px, (int) py, width, height, null);
	}
}
