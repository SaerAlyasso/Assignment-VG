package otherclasses;

import java.io.File;

import javax.swing.JFileChooser;

import interfaces.PlayerInterface;

import jaco.mp3.player.MP3Player;

/**
 *  This class implements the interface PlayerInterface. An external
 *  library is used here, the jaco mp3 player. In this class we got
 *  an player object with getter and setter and we got four methods
 *  open(),play(),pause(),stop() to manipulate the player object.
 *  
 * @author Saer Alyasso
 * @version 1.0
 * @since 2016-10-24
 *
 */

public class PlayerMethods implements PlayerInterface{

	// creating a MP3Player object player.
	private MP3Player player = new MP3Player() ;
	
	
	/**
	 * This method take a mp3 file and add it to playlist 
	 * then plays it. if the playlist already has a track
	 */
	@Override
	public void open(File file) {
	
		
		if(player.getPlayList().size()!=0){
			player.getPlayList().clear();
		}
		
		player.addToPlayList(file);
		player.play();
		
		
	}

	/**
	 * This method plays the selected file
	 */
	@Override
	public void play() {
		
		if(player.isPaused()||player.isStopped()){
		
		
		player.play();
		
		}
	}

	/**
	 * This method pauses the selected file from playing.
	 */
	@Override
	public void pause() {
		
		player.pause();
		
	}

	/**
	 * This method stops the selected file from playing.
	 */
	@Override
	public void stop() {
		
		player.stop();
		
	}

	/**
	 * @return the player
	 */
	public MP3Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(MP3Player player) {
		this.player = player;
	}

}
