package interfaces;

import java.io.File;

/**
 * This interface got four methods that will be used to manipulate 
 * a player object when implemented in PlayerMethods class.
 * 
 * @author Saer Alyasso
 * @version 1.0
 * @since 2016-10-24
 */

public interface PlayerInterface {

	/**
	 * This method takes a mp3 file and add it to playlist 
	 * then plays it.If the playlist already has a track
	 * it will be removed before adding the new one.
	 * @param file
	 */
	public void open(File file);
	
	/**
	 * This method plays the track added to the player object playlist
	 */
	public void play();
	
	/**
	 * This method pauses the track added to the player object playlist
	 */
	public void pause();
	
	/**
	 * This method stops the track added to the player object playlist
	 */
	public void stop();
}
