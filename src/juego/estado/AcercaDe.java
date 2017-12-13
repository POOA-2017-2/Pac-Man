package juego.estado;

import java.awt.CardLayout;
import java.awt.Graphics;

import juego.Game;
import juego.vista.panel.PantallaAbout;
import juego.vista.panel.PantallaMenu;

public class AcercaDe extends Estado{

	private PantallaAbout about;
	private Game juego;
	private String cad;
	public AcercaDe(String cad,Game juego) {
		super(EstadoJuego.ACERCADE);
		this.juego=juego;
		this.cad = cad;
		init();
	}

	public void init() {
		about=new PantallaAbout(cad,juego);
		juego.getVentana().getPnlVista().add(about, "AcercaDe");
	}

	public void render(Graphics g) {
		
	}

	public void update() {
		
	}

	public void exit() {
		
	}

	public void show() {
		
		CardLayout c=(CardLayout) juego.getVentana().getPnlVista().getLayout();
		c.show(juego.getVentana().getPnlVista(), "AcercaDe");
		juego.getVentana().setVisible(true);
	}

}
