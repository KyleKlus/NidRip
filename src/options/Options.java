package options;

public class Options {
	//Applicationoptions
	public static final String DEFAULT_GAME_TITLE="Dimension Jumpers";
	public static boolean devMode;
	public static int window_width;
	public static int window_height;
	//Gameoptions
	public static int nPlayers;
	
	public static void init() {
		devMode=true;
		nPlayers=1;
		window_width=1080;
		window_height=768;
	}
}
