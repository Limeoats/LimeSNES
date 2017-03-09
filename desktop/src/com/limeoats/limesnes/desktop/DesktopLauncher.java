package com.limeoats.limesnes.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.limeoats.limesnes.LimeSNES;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1200;
		config.height = 600;
		config.title = "LimeSNES";
		new LwjglApplication(new LimeSNES(), config);
	}
}
