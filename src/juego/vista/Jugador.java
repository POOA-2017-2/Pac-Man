package juego.vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.manager.Animacion;
import juego.manager.Recursos;
import juego.vista.panel.PantallaJuego;

public class Jugador {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private BufferedImage imagen;
	private Animacion jugadorL;
	private Animacion jugadorR;
	private Animacion jugadorU;
	private Animacion jugadorD;
	private PantallaJuego pantallaJuego;

	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	public Jugador(PantallaJuego pantallaJuego, int x, int y) {
		super();
		this.pantallaJuego = pantallaJuego;
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		imagen = Recursos.jugador;
		jugadorL = new Animacion(500,Recursos.jugadorLeft);
		jugadorR = new Animacion(500,Recursos.jugadorRight);
		jugadorU = new Animacion(500,Recursos.jugadorUp);
		jugadorD = new Animacion(500,Recursos.jugadorDown);
	}
	
	public void update() {
		if(pantallaJuego.getBm().isRight()) {
			if(x<=pantallaJuego.getAncho()) {
				x+=dx;
				stopAll();
				jugadorR.start();
			}
			
		}
			
		else if(pantallaJuego.getBm().isLeft()) {
			if(x>=0){
				x-=dx;
				stopAll();
				jugadorL.start();
			}
			
		}
		else if(pantallaJuego.getBm().isUp()) {
			if(y>0){
				y-=dy;
				stopAll();
				jugadorU.start();
			}
		}
		else if(pantallaJuego.getBm().isDown()) {
			if(y<=pantallaJuego.getAlto()){
				y+=dy;
				stopAll();
				jugadorD.start();
			}
		}
	}
	
	public void stopAll() {
		jugadorL.stop();
		jugadorU.stop();
		jugadorR.stop();
		jugadorD.stop();
	}
	
	public void render(Graphics g) {
		g.drawImage(currentFrame(), x, y, null);
	//	g.dispose();
	}
	
	public BufferedImage currentFrame() {
		if(pantallaJuego.getBm().isRight()) {
			return jugadorR.currentFrame();
		}
		else if(pantallaJuego.getBm().isLeft()) {
			return jugadorL.currentFrame();
		}
		else if(pantallaJuego.getBm().isDown()){
			return jugadorD.currentFrame();
		}
		else if(pantallaJuego.getBm().isUp()) {
			return jugadorU.currentFrame();
		}
		return Recursos.jugador;
	}
}
