package de.unistuttgart.iaas.icetea;

import java.io.File;
import java.util.Scanner;

/**
 * Ein textbasiertes Menü für die Benutzung des MediaPlayers.
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class CInterface {
	public static void main(String[] args) {
		Player player = new Player();
		Song song = null;
		Playlist playlist = null;
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		while (run == true) {
			System.out.println("Hauptmenü");
			System.out.println("1. Lied hinzufügen\n2. Playlist hinzufügen\n-\n"
					+ "3. Lied abspielen\n4. Playlist abspielen\n-\n"
					+ "5. Play\n6. Skip\n7. Pause\n8. Stop\n-\n"
					+ "0. Programm beenden");
			int auswahl = scanner.nextInt();
			switch (auswahl) {
				case 1:
					System.out.println("Gib den Namen des Liedes an:");
					String lied = scanner.next();
					File liedDatei = new File(lied);
					song = new Song(lied, liedDatei.getAbsolutePath());
					player.addSong(song);
					System.out.println("Song " + song.getName() + " mit dem Pfad " + song.getPath() + " hinzugefügt.");
					break;
				case 2:
					System.out.println("Gib den Namen der Playlist an:");
					String playlistName = scanner.next();
					playlist = new Playlist(playlistName);
					player.addPlaylist(playlist);				
					break;
				case 3: 
					player.play(song);
					break;
				case 4: 
					player.play(playlist);
					break;
				case 5:
					player.play();
					break;
				case 6:
					player.skip();
					break;
				case 7:
					player.pause();
					break;
				case 8:
					player.stop();
					break;
				case 0:
					run = false;
					break;
				default:
					System.out.println("Ungültige Eingabe.");
			}
		}
		scanner.close();
	}
}