package juego.manager;

import java.awt.image.BufferedImage;

import juego.elementos.Escenario;

public class Recursos {

	public static BufferedImage jugador;
	public static BufferedImage [] jugadorLeft;
	public static BufferedImage [] jugadorRight;
	public static BufferedImage [] jugadorUp;
	public static BufferedImage [] jugadorDown;
	public static BufferedImage []enemigo;
	public static void init() {
		SpriteManager sm = new SpriteManager("/Imagenes/pacmanSprites.png");
		jugador = sm.subImagen(0, 298, 27, 27);
		jugadorLeft = new BufferedImage[4];
		jugadorRight = new BufferedImage[4];
		jugadorUp = new BufferedImage[4];
		jugadorDown = new BufferedImage[4];
		
		jugadorLeft [0] = sm.subImagen(189, 298, 27, 27);
		jugadorLeft [1] = sm.subImagen(216, 270, 27, 27);
		jugadorLeft [2] = sm.subImagen(189, 298, 27, 27);
		jugadorLeft [3] = sm.subImagen(81, 81, 27, 27);
		
		jugadorRight [0] = sm.subImagen(0, 297, 27, 27);
		jugadorRight [1] = sm.subImagen(27, 216, 27, 27);
		jugadorRight [2] = sm.subImagen(0, 297, 27, 27);
		jugadorRight [3] = sm.subImagen(81, 81, 27, 27);
		
		jugadorUp [0] = sm.subImagen(27, 189, 27, 27);
		jugadorUp [1] = sm.subImagen(216, 189, 27, 27);
		jugadorUp [2] = sm.subImagen(27, 189, 27, 27);
		jugadorUp [3] = sm.subImagen(81, 81, 27, 27);
		
		jugadorDown [0] = sm.subImagen(0, 81, 27, 27);
		jugadorDown [1] = sm.subImagen(27, 81, 27, 27);
		jugadorDown [2] = sm.subImagen(0, 81, 27, 27);
		jugadorDown [3] = sm.subImagen(81, 81, 27, 27);
		
	}
	
}
