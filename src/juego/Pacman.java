package juego;

import juego.manager.Recursos;
import juego.vista.Display;

public class Pacman {
	private static nivel Nivel;
	public static void main(String args[]) {
		Display ventana = new Display (700,500,"JUEGO");
		Recursos.init();
	}

}
