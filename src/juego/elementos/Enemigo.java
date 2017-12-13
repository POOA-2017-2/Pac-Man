package juego.elementos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.manager.Recursos;

public class Enemigo {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private BufferedImage imagen;
	

	public Enemigo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		//imagen= Recursos.enemigo;
	}

	public void update() {
		x-=dx;
	}
	
	public void render(Graphics g) {
		//g.drawImage(imagen,x,y,null);
	}

}
