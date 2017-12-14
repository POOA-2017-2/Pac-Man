package juego;

import java.awt.EventQueue;
import juego.manager.AudioManager;

public class Pacman {
	private static nivel Nivel;
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Game ventana = new Game (700,500,"JUEGO");
				ventana.start();
		//	AudioManager manager=new AudioManager("/sounds/pacman_beginning.wav");
		//	manager.start();
				
			}
		});

	}

}
