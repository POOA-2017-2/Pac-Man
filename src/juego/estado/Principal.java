package juego.estado;

import java.awt.CardLayout;
import java.awt.Graphics;

import juego.Display;
import juego.Game;
import juego.paneles.PantallaMenu;
import juego.paneles.PantallaPrincipal;

public class Principal extends Estado{

	private PantallaPrincipal pnlPrincipal;
	private Game juego;
	private Display ventana;
	
	public Principal(Game juego,Display ventana) {
		super(EstadoJuego.INICIO);
		this.juego=juego;
		this.ventana = ventana;
		init();
		
	}

	@Override
	public void init() {
		pnlPrincipal=new PantallaPrincipal(juego,ventana);
		juego.getVentana().getPnlVista().add(pnlPrincipal, "Principal");
		
	}


	public void update() {
		
	}

	@Override
	public void exit() {
		
	}

	@Override
	public void show() {
		CardLayout c=(CardLayout) juego.getVentana().getPnlVista().getLayout();
		c.show(juego.getVentana().getPnlVista(), "Principal");
		juego.getVentana().setVisible(true);

	}

	@Override
	public void render(Graphics g) {
		
	}

}
