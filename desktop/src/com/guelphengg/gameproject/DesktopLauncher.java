package com.guelphengg.gameproject;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("TravelingSalesman");
		//config.setFullscreenMode(new Graphics.DisplayMode(100, 100, 100, 100));

		// Christian
		config.setMaximized(true);
		config.setResizable(true);
		config.setWindowedMode(1200, 800);

		new Lwjgl3Application(new TravelingSalesman(), config);
	}
}