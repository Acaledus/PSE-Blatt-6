package de.unistuttgart.iaas.icetea;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class which stores a Song
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class Song {
	
	/** is the name of the song */
	private String name;
	/** is the path to the file */
	private String path;
	
	/**
	 * constructor of a Song
	 *
	 * @param name is the name of the new song
	 * @param path is the path to the new file
	 */
	public Song(String name, String path) {
		this.name = name;
		this.path = path;
	}
	
	/**
	 * getter for the URL to the File
	 *
	 * @return returns the path as URL
	 */
	public URL getURL() {
		try {
			return new URL(path);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * getter for the name
	 *
	 * @return returns the name as String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getter for the path
	 *
	 * @return returns the path as String
	 */
	public String getPath() {
		return this.path;
	}
}
