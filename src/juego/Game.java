package juego;

import java.awt.Graphics;

import juego.Display;
import juego.estado.AcercaDe;
import juego.estado.Juego;
import juego.estado.Menu;
import juego.estado.Principal;
import juego.estado.Reglas;
import juego.manager.StateManager;

public class Game implements Runnable{

	private Display ventana;
	private int ancho;
	private int alto;
	private String titulo;
	private boolean activo;
	private Thread t;
	private Graphics g;

	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
	}
	
	public void init(){
		ventana=new Display(ancho, alto, titulo);
		

		Principal p = new Principal(this,ventana); 
		Menu m=new Menu(this);
		Juego j=new Juego(this);
		AcercaDe ad = new AcercaDe("PROYECTO FINAL: PACMAN",this);
		Reglas r = new Reglas(this);
		StateManager.getInstance().addEstado(p);
		StateManager.getInstance().addEstado(m);
		StateManager.getInstance().addEstado(j);
		StateManager.getInstance().addEstado(ad);
		StateManager.getInstance().addEstado(r);
		
	}

	public synchronized void start(){
		if(activo)
			return;
		
		activo=true;
		t=new Thread(this);
		t.start();
	}
	
	public  synchronized void stop(){
		if(!activo)
			return;
		activo=false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
	   if(StateManager.getInstance()!=null)
		   StateManager.getInstance().getCurrentEstado().update();
	}
	
	public void render(){
		if(StateManager.getInstance()!=null)
			StateManager.getInstance().getCurrentEstado().render(g);
	}
	
	public void run() {
		
		init();//<--- INICIALIZAR JUEGO
		int fps=60;
		double nanoPorFrame=1000000000/fps;
		long nuevo;
		long pasado=System.nanoTime();
		double delta=0;
		// variables auxiliares o de testeo
		long time=0;
		int ticks=0;
		
		while(activo){
			
			nuevo=System.nanoTime();
			time+=nuevo-pasado; //<--- testeo  
			delta+=(nuevo-pasado)/nanoPorFrame;
			pasado=nuevo;
			
			if(delta>=1){
				update();// actualizacion logica
				render();// repintado
				delta--;
				ticks++;
			}
			
			// testeo
			if(time>=1000000000){
		//		System.out.println("Frames por segundo: "+ticks);
				ticks=0;
				time=0;
			}

		}
		
	}

	

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public Display getVentana() {
		return ventana;
	}
	
	

}
