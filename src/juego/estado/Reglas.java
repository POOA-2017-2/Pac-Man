package juego.estado;

import java.awt.CardLayout;
import java.awt.Graphics;

import juego.Game;
import juego.vista.panel.PantallaAbout;
import juego.vista.panel.PantallaReglas;

public class Reglas extends Estado{

	private PantallaReglas reglas;
	private Game juego;
	public Reglas(Game juego) {
		super(EstadoJuego.REGLAS);
		this.juego=juego;
		init();
	}

	@Override
	public void init() {
		reglas=new PantallaReglas(juego);
		juego.getVentana().getPnlVista().add(reglas, "Reglas");
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void exit() {
		
	}

	@Override
	public void show() {
		CardLayout c=(CardLayout) juego.getVentana().getPnlVista().getLayout();
		c.show(juego.getVentana().getPnlVista(), "Reglas");
		juego.getVentana().setVisible(true);
		
	}

}
