package de.unistuttgart.iaas.icetea;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 * Class which manages the songs and playlists and handles playback
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class Player implements BasicPlayerListener {
	
	private PlayerState state = PlayerState.NO_FILE;
	
	public PlayerState getState() {
		return state;
	}

	/** is the player that handles low level playback */
	private PlayerCore player;
	
	/** Stores all playlists */
	private ArrayList<Playlist> playlists;
	/** Stores all songs */
	private ArrayList<Song> songs;
	
	/** 
	 * an Iterator over the songs of the current playlist
	 * used for playback of a whole playlist
	 */
	private Iterator<Song> currentPlaylist;
	/** Variable holding the currently played song */
	private Song currentSong;
	
	/**
	 * Standard constructor
	 */
	public Player() {
		this.player = new PlayerCore(this);
		this.playlists = new ArrayList<Playlist>();
		this.songs = new ArrayList<Song>();
	}
	
	/**
	 * Adds a playlist to playlists and ensures 
	 * all songs of the playlist are known
	 * 
	 * @param list
	 *            is a playlist that should be added to playlists
	 */
	public void addPlaylist(Playlist list) {
		for (Song song : list.getSongs()) {
			if (!songs.contains(song)) {
				songs.add(song);
			}
		}
		
		playlists.add(list);
	}
	
	/**
	 * Adds a song to songs
	 * 
	 * @param song
	 *            is a song that should be added to songs
	 */
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	/**
	 * getter for all the stored songs
	 *
	 * @return returns all the songs as a ArrayList
	 */
	public ArrayList<Song> getSongs() {
		return this.songs;
	}
	
	/**
	 * getter for all the stored playlists
	 *
	 * @return returns all the playlists as a ArrayList
	 */
	public ArrayList<Playlist> getPlaylists() {
		return this.playlists;
	}
	
	/**
	 * If a song was played before and the player stopped playback
	 * this method starts playback with the last played song.
	 *
	 * If a playlist was played before this method will continue
	 * the playlist at the position at which playback was stopped
	 */
	public void play() {
		if (this.currentSong != null) {
			this.player.open(this.currentSong);
			this.player.play();		
			state = PlayerState.PLAYING;
		}
	}
	
	/**
	 * plays a song
	 * 
	 * @param song
	 *            is a song that should be played
	 */
	public void play(Song song) {
		this.currentPlaylist = null;
		this.currentSong = song;
		this.player.open(this.currentSong);
		this.player.play();
		state = PlayerState.PLAYING;
	}
	
	/**
	 * Starts playback of a whole playlist
	 * 
	 * @param list
	 *            is a playlist that should be played
	 */
	public void play(Playlist playlist) {
		this.currentPlaylist = playlist.getSongs().iterator();
		if (this.currentPlaylist.hasNext()) {
			this.currentSong = this.currentPlaylist.next();
			this.player.open(this.currentSong);
			this.player.play();		
			state = PlayerState.PLAYING;
		}
	}
	
	/**
	 * This skips right to the next song in a playlist if a playlist is beeing
	 * played and has a next song. If the playlist has no next song playback is
	 * stopped.
	 */
	public void skip() {
		if (this.currentPlaylist != null) {
			this.player.stop();
			if (this.currentPlaylist.hasNext()) {
				this.currentSong = this.currentPlaylist.next();
				this.player.open(this.currentSong);
				this.player.play();
				state = PlayerState.PLAYING;
			}
		}
	}

	/**
	 * pauses playback
	 */
	public void pause() {
		this.player.pause();
		state = PlayerState.PAUSED;
	}

	/**
	 * resumes playback
	 */
	public void resume() {
		this.player.resume();
		state = PlayerState.PLAYING;
	}

	/**
	 * stops playback
	 */
	public void stop() {
		this.player.stop();
		state = PlayerState.STOPPED;
	}
	
	@Override
	public void opened(Object arg0, Map arg1) {
		// Nothing todo here
	}

	@Override
	public void progress(int arg0, long arg1, byte[] arg2, Map arg3) {
		// Nothing todo here
	}

	@Override
	public void setController(BasicController arg0) {
		// Nothing todo here
	}

	@Override
	public void stateUpdated(BasicPlayerEvent event) {
		if (event.getCode() == BasicPlayerEvent.EOM) {
			// Song finished playing
			if ((this.currentPlaylist != null) && (this.currentPlaylist.hasNext())) {
				this.currentSong = this.currentPlaylist.next();
				this.player.open(currentSong);
				this.player.play();
				state = PlayerState.PLAYING;
			}
		}
	}
}
