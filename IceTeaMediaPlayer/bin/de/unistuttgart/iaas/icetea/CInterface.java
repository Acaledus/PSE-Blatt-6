/*
 * Übungsblatt 6
 *
 *Daniel Capkan, Matrikelnummer: 3325960, st156303@stud.uni-stuttgart.de
 * Mario Scheich, Matrikelnummer: 3232655 , st151491@stud.uni-stuttgart.de
 * Florian Walcher, Matrikelnummer: 3320185, st156818@stud.uni-stuttgart.de
 * 
 */
package de.unistuttgart.iaas.icetea;


import java.io.IOException;
import java.util.Scanner;

public class CInterface {

	
	public static void main(String[] args) throws IOException{
		System.out.println("Hauptmenü");
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Lied hinzufügen(drücke hierfür die 1)\n2.Playlist hinzufügen(drücke hierfür die 2)\n-\n"
				+ "3.Lied abspielen(drücke hierfür die 3)\n4.Playlist abspielen(drücke hierfür die 4)\n-\n"
				+ "5.Play(drücke hierfür die 5)\n6.Skip(drücke hierfür die 6)\n7.Pause(drücke hierfür die 7)\n8.Stop(drücke hierfür die 8)\n-\n"
				+ "0.Programm beenden(drücke hierfür die 9)");
		
		
		int Auswahl = scanner.nextInt();
		
		if(Auswahl>0 && Auswahl<10){
			if(Auswahl == 1){
				System.out.println("gib den Name des Liedes an:");
				
				Player.addSong( = scanner.nextLine() );
				
				System.out.println("gib den Pfad des Liedes an:");
			}
			if(Auswahl == 2){
				System.out.println("gib den Name der Playlist an:");
				Player.addPlaylist();
				
				
				System.out.println("gib die Liste der Lieder an:");
				//
				
				
				
			}
				if(Auswahl == 3){ 
				System.out.println("geben sie das zu spielende Lied an:" );
				Player.play(Song);
				}
					if(Auswahl == 4){ 
				System.out.println("geben sie die abzuspielende Playlist an");
				  Player.play(Playlist);
					}
						if(Auswahl ==5){ 
							Player.play();
							
						}
							if(Auswahl == 6){
							Player.skip();
							}
							if(Auswahl == 7){
							Player.pause();
							}
								if(Auswahl == 8){
								Player.stop();
								}
									if(Auswahl == 9){
										System.exit(0);
									}
						
					
			

		else{
			throws IllegalArgumentException
		}
			
		}
	
		
	
		}
			
		
		
		
		
		
	
		
	}

