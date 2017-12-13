package de.unistuttgart.iaas.icetea;

import java.util.ArrayList;

/**
 * Class which stores a playlist
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class Playlist {
	
	/** is the name of the playlist */
	private String name;
	/** is a list of all the songs */
	private ArrayList<Song> songs;
	
	/**
	 * constructor for the playlist
	 *
	 * @param name is the name of the playlist
	 */
	public Playlist(String name) {
		this.name = name;
		this.songs = new ArrayList<Song>();
	}

	/**
	 * getter for the playlist name
	 *
	 * @return returns the name of the playlist
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * getter for all the songs in the playlist
	 *
	 * @return returns a list of Songs
	 */
	public ArrayList<Song> getSongs() {
		return this.songs;
	}
	
	/**
	 * adds a song to the playlist
	 *
	 * @param song is the new song
	 */
	public void addSong(Song song) {
		this.songs.add(song);
	}
}
