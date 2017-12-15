package de.unistuttgart.iaas.icetea;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * @author Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * @author Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 */
public class CInterface {
	public static void main(String[] args) throws IOException{
		Player player = new Player();
		Song song = null;
		Playlist playlist = null;
		System.out.println("Hauptmenü");
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Lied hinzufügen\n2. Playlist hinzufügen\n-\n"
				+ "3. Lied abspielen\n4. Playlist abspielen\n-\n"
				+ "5. Play\n6. Skip\n7. Pause\n8. Stop\n-\n"
				+ "0. Programm beenden");
		int Auswahl = scanner.nextInt();
		if(Auswahl > 0 && Auswahl < 10){
			if(Auswahl == 1){
				System.out.println("Gib den Name des Liedes an:");
				String lied = scanner.next();
				File datei = new File(lied);
				song = new Song(lied, datei.getAbsolutePath());
				player.addSong(song);
				System.out.println("Gib den Pfad des Liedes an:");
			}
			if(Auswahl == 2){
				System.out.println("Gib den Namen der Playlist an:");
				String playlistName = scanner.next();
				playlist = new Playlist(playlistName);
				player.addPlaylist(playlist);				
				System.out.println("Gib die Liste der Lieder an:");
			}
			if(Auswahl == 3){ 
				System.out.println("Gib das zu spielende Lied an:" );
				player.play(song);
			}
			if(Auswahl == 4){ 
				System.out.println("Gib die abzuspielende Playlist an");
				if (playlist != null) {
					player.play(playlist);
				}
			}
			if(Auswahl == 5){ 
				player.play();
			}
			if(Auswahl == 6){
				player.skip();
			}
			if(Auswahl == 7){
				player.pause();
			}
			if(Auswahl == 8){
				player.stop();
			}
			if(Auswahl == 9){
				System.exit(0);
			} else { 
				throw new IllegalArgumentException();
			}
		}
		scanner.close();
	}
}