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
		jugador = sm.subImagen(0, 374, 32, 32);
		jugadorLeft = new BufferedImage[4];
		jugadorRight = new BufferedImage[4];
		jugadorUp = new BufferedImage[4];
		jugadorDown = new BufferedImage[4];
		enemigo = new BufferedImage[4];
		
		jugadorLeft [0] = sm.subImagen(297, 340, 32, 32);
		jugadorLeft [1] = sm.subImagen(264, 340, 32, 32);
		jugadorLeft [2] = sm.subImagen(297, 340, 32, 32);
		jugadorLeft [3] = sm.subImagen(99, 102, 32, 32);
		
		jugadorRight [0] = sm.subImagen(0, 374, 32, 32);
		jugadorRight [1] = sm.subImagen(33, 272, 32, 32);
		jugadorRight [2] = sm.subImagen(0, 374, 32, 32);
		jugadorRight [3] = sm.subImagen(99, 102, 32, 32);
		
		jugadorUp [0] = sm.subImagen(33, 238, 32, 32);
		jugadorUp [1] = sm.subImagen(264, 238, 32, 32);
		jugadorUp [2] = sm.subImagen(33, 238, 32, 32);
		jugadorUp [3] = sm.subImagen(99, 102, 32, 32);
		
		jugadorDown [0] = sm.subImagen(0, 102, 32, 32);
		jugadorDown [1] = sm.subImagen(33, 102, 32, 32);
		jugadorDown [2] = sm.subImagen(0, 102, 32, 32);
		jugadorDown [3] = sm.subImagen(99, 102, 32, 32);
		
	}
	
}
