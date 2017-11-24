package juego.manager;

import java.awt.image.BufferedImage;

public class Recursos {

	public static BufferedImage fondo;
	public static BufferedImage piso;
	public static BufferedImage jugador;
	public static BufferedImage [] jugadorLeft;
	public static BufferedImage [] jugadorRight;
	public static BufferedImage [] jugadorUp;
	public static BufferedImage [] jugadorDown;
	
	public static void init() {
	//	fondo = ImageManager.cargaImagen("/imagen/country-platform-back.png");
	//	piso = ImageManager.cargaImagen("/imagen/country-platform-tiles-example.png");
		SpriteManager sm = new SpriteManager("/Imagenes/pacmanSprites.png");
		jugador = sm.subImagen(0, 374, 33, 34);
		jugadorLeft = new BufferedImage[4];
		jugadorRight = new BufferedImage[4];
		jugadorUp = new BufferedImage[4];
		jugadorDown = new BufferedImage[4];
		
		jugadorLeft [0] = sm.subImagen(297, 340, 33, 34);
		jugadorLeft [1] = sm.subImagen(264, 340, 33, 34);
		jugadorLeft [2] = sm.subImagen(297, 340, 33, 34);
		jugadorLeft [3] = sm.subImagen(99, 102, 33, 34);
		
		jugadorRight [0] = sm.subImagen(0, 374, 33, 34);
		jugadorRight [1] = sm.subImagen(33, 272, 33, 34);
		jugadorRight [2] = sm.subImagen(0, 374, 33, 34);
		jugadorRight [3] = sm.subImagen(99, 102, 33, 34);
		
		jugadorUp [0] = sm.subImagen(33, 238, 33, 34);
		jugadorUp [1] = sm.subImagen(264, 238, 33, 34);
		jugadorUp [2] = sm.subImagen(33, 238, 33, 34);
		jugadorUp [3] = sm.subImagen(99, 102, 33, 34);
		
		jugadorDown [0] = sm.subImagen(0, 102, 33, 34);
		jugadorDown [1] = sm.subImagen(33, 102, 33, 34);
		jugadorDown [2] = sm.subImagen(0, 102, 33, 34);
		jugadorDown [3] = sm.subImagen(99, 102, 33, 34);
		
	}
	
}
