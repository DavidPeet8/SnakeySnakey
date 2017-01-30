package snakey.snakey.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import snakey.snakey.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width = 600;
                config.height = 600;
                config.backgroundFPS = 2;
                config.foregroundFPS = 2;
		new LwjglApplication(new Main(), config);
	}
}
