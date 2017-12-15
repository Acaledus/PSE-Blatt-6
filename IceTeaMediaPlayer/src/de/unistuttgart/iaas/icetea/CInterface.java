package de.unistuttgart.iaas.icetea;

import java.util.Scanner;

/**
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
					String liedName = scanner.next();
					System.out.println("Gib den Pfad des Liedes an:");
					String liedPfad = scanner.next();
					song = new Song(liedName, liedPfad);
					player.addSong(song);
					System.out.println("Song " + song.getName() + " mit dem Pfad " + song.getPath() + "hinzugefügt.");
					break;
				case 2:
					System.out.println("Gib den Namen der Playlist an:");
					String playlistName = scanner.next();
					playlist = new Playlist(playlistName);
					player.addPlaylist(playlist);				
					System.out.println("Gib die Liste der Lieder an:");
					break;
				case 3: 
					System.out.println("Gib das zu spielende Lied an:" );
					player.play(song);
					break;
				case 4: 
					System.out.println("Gib die abzuspielende Playlist an:");
					if (playlist != null) {
						player.play(playlist);
					}
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
				case 9:
					run = false;
					break;
				default:
					throw new IllegalArgumentException();
			}
		}
		scanner.close();
	}
}