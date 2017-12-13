package juego.estado;

import java.awt.Graphics;

public abstract class Estado {

	public Estado() {
		
	}
	private EstadoJuego state;
	
	public Estado(EstadoJuego state) {
		// TODO Auto-generated constructor stub
		this.state=state;
	}
	
	public abstract void init();
	public abstract void render(Graphics g);
	public abstract void update();
	public abstract void exit();
	public abstract void show();

	public EstadoJuego getState() {
		return state;
	}

	public void setState(EstadoJuego state) {
		this.state = state;
	}

}
