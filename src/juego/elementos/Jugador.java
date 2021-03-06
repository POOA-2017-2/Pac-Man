package juego.elementos;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import juego.Cell;
import juego.estado.Juego;
import juego.manager.Animacion;
import juego.manager.AudioManager;
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
	public Cell[][] cells;
    public int livesLeft;
    public int score;
    public AudioManager manager;
	
	public Jugador(Juego juego, int x, int y,int lives) {
		super();
		this.juego = juego;
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		imagen = Recursos.jugador;
		jugadorL = new Animacion(100,Recursos.jugadorLeft);
		jugadorR = new Animacion(100,Recursos.jugadorRight);
		jugadorU = new Animacion(100,Recursos.jugadorUp);
		jugadorD = new Animacion(100,Recursos.jugadorDown);
        livesLeft = lives;
        cells     = juego.getCells();
	}
	
	public void update() {
		manager=new AudioManager("/sounds/pacman_chomp.wav");
		if(juego.getPnlJuego().getBm().isRight() || juego.getPnlJuego().getKm().isDerecha()) {
			if(x<(juego.getJuego().getAncho()- 50)) 
				if (isCellNavigable(y, x + dx)){
					x+=dx;
					jugadorL.stop();
					jugadorU.stop();
					jugadorD.stop();
					jugadorR.start();
				}else {}
			else
			jugadorR.stop();
			
		}
			
		else if(juego.getPnlJuego().getBm().isLeft() || juego.getPnlJuego().getKm().isIzquierda()) {
			if(x>0)
				if (isCellNavigable(y,x-dx)){
				x-=dx;
				jugadorU.stop();
				jugadorR.stop();
				jugadorD.stop();
				jugadorL.start();
				}else {}
			else
			jugadorL.stop();
			
		}
		else if(juego.getPnlJuego().getBm().isUp() || juego.getPnlJuego().getKm().isArriba()) {
			if(y>0)
				if (isCellNavigable(y-dy,x)){
				y-=dy;
				jugadorL.stop();
				jugadorR.stop();
				jugadorD.stop();
				jugadorU.start();
				}else {}
			else
			jugadorU.stop();
		}
		else if(juego.getPnlJuego().getBm().isDown() || juego.getPnlJuego().getKm().isAbajo()) {
			if(y<(juego.getJuego().getAlto() - 200))
				if (isCellNavigable(y+dy,x)){
				y+=dy;
				jugadorL.stop();
				jugadorU.stop();
				jugadorR.stop();
				jugadorD.start();
				}else {}
			else
			jugadorD.stop();
		}
		eatPellet(y, x);
	}
	
	public void render(Graphics g) {
		g.drawImage(currentFrame(), x*20, y*20, juego.getPnlJuego());
	//	g.dispose();
	}
	
	public BufferedImage currentFrame() {
		if(juego.getPnlJuego().getBm().isRight() || juego.getPnlJuego().getKm().isDerecha()) {
			return jugadorR.currentFrame();
		}
		else if(juego.getPnlJuego().getBm().isLeft() || juego.getPnlJuego().getKm().isIzquierda()) {
			return jugadorL.currentFrame();
		}
		else if(juego.getPnlJuego().getBm().isDown() || juego.getPnlJuego().getKm().isAbajo()){
			return jugadorD.currentFrame();
		}
		else if(juego.getPnlJuego().getBm().isUp() || juego.getPnlJuego().getKm().isArriba()) {
			return jugadorU.currentFrame();
		}else
		return Recursos.jugador;
	}
	
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}



	    public void eatPellet(int column, int row) {
	    	
	        if (cells[column][row].getType() == 'd') {
	            score  += 10;
	            cells[column][row].type = 'o';
	            manager.start();
	        }

	        if (cells[column][row].getType() == 'p') {
	            score += 50;
	            cells[column][row].type = 'o';
	            juego.setEdible();
	        }
	    }

	    /*
	     * celda navegable
	     *
	     */
	    public boolean isCellNavigable(int column, int row) {
	        return ((cells[column][row].getType() == 'o') || (cells[column][row].getType() == 'd')
	                || (cells[column][row].getType() == 'p'));
	    }
	    /*
	     * score
	     *
	     */
	    public int getScore() {
	        return score;
	    }
	    /*
	     * vidas
	     *
	     */
	    public int getLives() {
	        return livesLeft;
	    }
	    
}
