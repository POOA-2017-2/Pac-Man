package juego.estado;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import juego.Cell;
import juego.Game;
import juego.elementos.Enemigo;
import juego.elementos.Escenario;
import juego.elementos.Jugador;
import juego.elementos.Maze;
import juego.manager.Recursos;
import juego.manager.StateManager;
import juego.paneles.PantallaJuego;
import juego.paneles.Perdedor;
import juego.paneles.Scores;

public class Juego extends Estado{

	private PantallaJuego pnlJuego;
	private int ghostInitialColumn  = 13;
    private int ghostInitialRow     = 21;
	private Escenario escenario;
	private Jugador jugador;
	private Game juego;
	private Cell[][] cells;
	private BufferStrategy bs;
	private Enemigo inky;
	private Enemigo blinky;
	private Enemigo pinky;
	private Enemigo clyde;
	private int lives = 3;
	
	public Juego(Game juego) {
		super(EstadoJuego.JUEGO);
		this.juego=juego;
		init();
	}

	public void init() {
		Recursos.init();
		pnlJuego=new PantallaJuego(juego);
		juego.getVentana().getPnlVista().add(pnlJuego,"Juego");
		escenario = new Escenario(this);
	    cells = escenario.getCells();
		jugador=new Jugador(this,21,7, lives);
		inky   = new Enemigo(ghostInitialRow, ghostInitialColumn, this, "inky.png");
	    blinky = new Enemigo(ghostInitialRow + 3, ghostInitialColumn, this, "blinky.png");
        pinky  = new Enemigo(ghostInitialRow, ghostInitialColumn + 3, this, "pinky.png");
        clyde  = new Enemigo(ghostInitialRow + 3, ghostInitialColumn + 3, this, "clyde.png");
      
	}

	public void render(Graphics g) {
		bs=pnlJuego.getCanvas().getBufferStrategy();
		if(bs==null){
			pnlJuego.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		g.clearRect(0, 0,juego.getAncho(), juego.getAlto());
		// PINTAR ELEMENTOS
		escenario.render(g);
		jugador.render(g);
		inky.render(g);
		blinky.render(g);
		pinky.render(g);
		clyde.render(g);
		//for(int i=0; i<listaEnemigos.size();i++){
			//listaEnemigos.get(i).render(g);
		//}
		// FIN DEL PINTADO
		bs.show();
		g.dispose();
		
	}

	public void update() {
		
		jugador.update();
		inky.update();
		blinky.update();
		pinky.update();
		clyde.update();
		checkCollision();
		pnlJuego.setScore(getScore());
		pnlJuego.setLives(getLives());
		
	}
	
	 public Cell[][] getCells() {
	        return cells;
	    }

	    public int getScore() {
	        return jugador.getScore();
	    }

	    public int getLives() {
	        return jugador.getLives();
	    }

	    public void setEdible() {
	        inky.setDeadly(false);
	        blinky.setDeadly(false);
	        pinky.setDeadly(false);
	        clyde.setDeadly(false);
	        inky.setEdibleLifeRemaining(inky.getEdibleLifeRemaining());
	        blinky.setEdibleLifeRemaining(blinky.getEdibleLifeRemaining());
	        pinky.setEdibleLifeRemaining(pinky.getEdibleLifeRemaining());
	        clyde.setEdibleLifeRemaining(clyde.getEdibleLifeRemaining());
	       // System.out.println("OMNOMNOM!");
	    }

	    public void checkCollision() {
	        if (pinky.isDeadly() && (pinky.getCol() == jugador.getY()) && (pinky.getRow() == jugador.getX())) {
	            loseLife();
	        } else if (inky.isDeadly() && (inky.getCol() == jugador.getY()) && (inky.getRow() == jugador.getX())) {
	            loseLife();
	        } else if (blinky.isDeadly() && (blinky.getCol() == jugador.getY()) && (blinky.getRow() == jugador.getX())) {
	            loseLife();
	        } else if (clyde.isDeadly() && (clyde.getCol() == jugador.getY()) && (clyde.getRow() == jugador.getX())) {
	            loseLife();
	        }
	    }

	    public void loseLife() {
	        lives--;
	        if (lives <= 0) {
	        	Perdedor perdio = new Perdedor();
	        	perdio.setVisible(true);
	        	perdio.setAlwaysOnTop(true);
	        	StateManager.getInstance().setCurrentEstado(EstadoJuego.MENU);
				int score = jugador.getScore();
	        	int scoreGuardado = getJuego().getPuntuacion();
	        	if(score>scoreGuardado) {
	        		Scores about = new Scores();
					about.setVisible(true);
	        	}
				 	
				 
	        }
	    }
	public void exit() {
		
	}

	public void show() {
		CardLayout c=(CardLayout)juego.getVentana().getPnlVista().getLayout();
		c.show(juego.getVentana().getPnlVista(), "Juego");
		juego.getVentana().setVisible(true);
	}

	public PantallaJuego getPnlJuego() {
		return pnlJuego;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Game getJuego() {
		return juego;
	}
	

}
