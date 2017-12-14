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
import juego.paneles.PantallaJuego;

public class Juego extends Estado{

	private PantallaJuego pnlJuego;
	private int ghostInitialColumn  = 13;
    private int ghostInitialRow     = 21;
	private Escenario escenario;
	private Jugador jugador;
	private Game juego;
	private Cell[][] cells;
	private BufferStrategy bs;
	//private Juego maze;
	private Enemigo inky;
	private Enemigo blinky;
	private Enemigo pinky;
	private Enemigo clyde;
	private int lives;
	
	public Juego(Game juego) {
		super(EstadoJuego.JUEGO);
		this.juego=juego;
		//maze = new Maze();
		init();
	}

	public void init() {
		Recursos.init();
		pnlJuego=new PantallaJuego();
		juego.getVentana().getPnlVista().add(pnlJuego,"Juego");
		
		jugador=new Jugador(this,10,160, this, 3);
		inky   = new Enemigo(ghostInitialRow, ghostInitialColumn, this, "inky.png");
	    blinky = new Enemigo(ghostInitialRow + 3, ghostInitialColumn, this, "blinky.png");
        pinky  = new Enemigo(ghostInitialRow, ghostInitialColumn + 3, this, "pinky.png");
        clyde  = new Enemigo(ghostInitialRow + 3, ghostInitialColumn + 3, this, "clyde.png");
        escenario = new Escenario();
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
	            System.out.println("Pacman eaten by Pinky!");
	            loseLife();
	        } else if (inky.isDeadly() && (inky.getCol() == jugador.getY()) && (inky.getRow() == jugador.getX())) {
	            System.out.println("Pacman eaten by Inky!");
	            loseLife();
	        } else if (blinky.isDeadly() && (blinky.getCol() == jugador.getY()) && (blinky.getRow() == jugador.getX())) {
	            System.out.println("Pacman eaten by Blinky!");
	            loseLife();
	        } else if (clyde.isDeadly() && (clyde.getCol() == jugador.getY()) && (clyde.getRow() == jugador.getX())) {
	            System.out.println("Pacman eaten by Clyde!");
	            loseLife();
	        }
	    }

	    public void loseLife() {
	        lives--;
	       // PacmanGUI.newDisp();    // actualizar vidas

	        //integrar animacion muerte
	        if (lives <= 0) {
	        /*	inky.endgame();
	            blinky.endgame();
	            pinky.endgame();
	            clyde.endgame();
	            pacman.endgame();*/
	            System.out.println("Game Over!");
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
