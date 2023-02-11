package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

//Homemade
import display.Display;
import gfx.Assets;

//States
import states.GameState;
//import states.MenuState;
//import states.OptState;
import states.State;

//Input
import input.KeyManager;
import options.Options;

public class Game implements Runnable{
	private Display display;
	private State /*menuState, optState,*/ gameState;
	private KeyManager keyManager;	
	
	private Thread thr;
	private BufferStrategy bs;
	private Graphics g;
	
	private int fps = 60;
	private boolean running=false;
	
	public Game() {
		keyManager=new KeyManager();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}
	public State getGameState() {
		return gameState;
	}
	private void init() {
		Options.init();
		display = new Display(Options.DEFAULT_GAME_TITLE, Options.window_width, Options.window_height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		//menuState = new MenuState(this);
		//optState = new OptState(this);
		gameState = new GameState(this);
		State.setState(gameState);
	}
	private void update() {
		keyManager.update();
		if(State.getState()!=null)
			State.getState().update();
	}
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, Options.window_width, Options.window_height);
		//Drawing
		if(State.getState()!=null)
			State.getState().render(g);
		//End drawing
		bs.show();
		g.dispose();
	}
	@Override
	public void run() {
		init();
		//Clock variables
		long lastTime=System.nanoTime();
		double timePerTick=1000000000/fps;//1Billion Nanoseconds=1Second
		int updates=0;
		int frames=0;
		long now=0;
		double delta=0;
		
		long lastTimer=System.currentTimeMillis();
		
		while(running) {
			//Clock code
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			lastTime=now;
			
			if(delta>=1) {
				updates++;
				update();//Variables get processed & changed
				delta--;
			}
			frames++;
			render();//Variables get processed into graphical changes for the canvas
			if(System.currentTimeMillis()-lastTimer>=1000) {
				lastTimer+=1000;
				System.out.println("FPS: "+frames+" / UPS: "+updates);
				frames=0;
				updates=0;
			}
		}
		stop();//Stops the game
	}
	public synchronized void start() {
		if(running)
			return;
		running=true;
		thr = new Thread(this);
		thr.start();
	}
	public synchronized void stop() {
		if(!running)
			return;
		running=false;
		try {
			thr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
