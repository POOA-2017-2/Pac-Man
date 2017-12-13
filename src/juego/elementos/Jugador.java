package juego.elementos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.estado.Juego;
import juego.manager.Animacion;
import juego.manager.Recursos;
import juego.paneles.PantallaJuego;

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
	private Juego juego;

	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	public Jugador(Juego juego, int x, int y) {
		super();
		this.juego = juego;
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
		if(juego.getPnlJuego().getBm().isRight()) {
			if(x<=juego.getPnlJuego().getAncho()) {
				x+=dx;
				stopAll();
				jugadorR.start();
			}
			
		}
			
		else if(juego.getPnlJuego().getBm().isLeft()) {
			if(x>=0){
				x-=dx;
				stopAll();
				jugadorL.start();
			}
			
		}
		else if(juego.getPnlJuego().getBm().isUp()) {
			if(y>0){
				y-=dy;
				stopAll();
				jugadorU.start();
			}
		}
		else if(juego.getPnlJuego().getBm().isDown()) {
			if(y<=juego.getPnlJuego().getAlto()){
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
		if(juego.getPnlJuego().getBm().isRight()) {
			return jugadorR.currentFrame();
		}
		else if(juego.getPnlJuego().getBm().isLeft()) {
			return jugadorL.currentFrame();
		}
		else if(juego.getPnlJuego().getBm().isDown()){
			return jugadorD.currentFrame();
		}
		else if(juego.getPnlJuego().getBm().isUp()) {
			return jugadorU.currentFrame();
		}
		return Recursos.jugador;
	}
}
