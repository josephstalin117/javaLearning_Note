package com.hehe.wakaka;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;

public class Music {

	File musicFile;
	URI uri;
	java.net.URL url = null;
	AudioClip clip = null;

	// 背景音乐
	public void startMusic() {
		musicFile = new File(System.getProperty("user.dir")
				+ "\\sounds\\begin.wav");
		uri = musicFile.toURI();
		try {
			url = uri.toURL();
		} catch (Exception e) {
		}
		clip = Applet.newAudioClip(url);
		clip.loop();
		clip.play();

	}

	public void stopMusic() {
		clip.stop();
	}

}
