package juego.estado;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import juego.Game;
import juego.elementos.Escenario;
import juego.elementos.Jugador;
import juego.manager.Recursos;
import juego.vista.panel.PantallaJuego;

public class Juego extends Estado{

	private PantallaJuego pnlJuego;
	private Escenario escenario;
	private Jugador jugador;
	//private ArrayList<Enemigo> listaEnemigos;
	private Game juego;
	private BufferStrategy bs;
	//private Timer t;
	
	public Juego(Game juego) {
		super(EstadoJuego.JUEGO);
		this.juego=juego;
		init();
	}

	public void init() {
		Recursos.init();
		pnlJuego=new PantallaJuego(juego);
		juego.getVentana().getPnlVista().add(pnlJuego,"Juego");
		
		jugador=new Jugador(this,10,160);
		
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
		//escenario.render(g);
		jugador.render(g);
		//for(int i=0; i<listaEnemigos.size();i++){
			//listaEnemigos.get(i).render(g);
		//}
		// FIN DEL PINTADO
		bs.show();
		g.dispose();
		
	}

	public void update() {
		//escenario.update();
		jugador.update();
		/*for(int i=0; i<listaEnemigos.size();i++){
			Enemigo e=listaEnemigos.get(i);
			e.update();
			if(jugador.getBounds().intersects(e.getBounds())){
				listaEnemigos.remove(i);
			}
			
		}*/
		
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

	/*public ArrayList<Enemigo> getListaEnemigos() {
		return listaEnemigos;
	}

	public void setListaEnemigos(ArrayList<Enemigo> listaEnemigos) {
		this.listaEnemigos = listaEnemigos;
	}*/
	

}
