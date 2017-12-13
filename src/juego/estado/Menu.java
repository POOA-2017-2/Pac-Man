package juego.estado;
import java.awt.CardLayout;
import java.awt.Graphics;
import juego.Game;
import juego.estado.EstadoJuego;
import juego.vista.panel.PantallaMenu;

public class Menu extends Estado{

	private PantallaMenu pnlMenu;
	private Game juego;
	public Menu(Game juego) {
		super(EstadoJuego.MENU);
		this.juego=juego;
		init();
		
	}

	@Override
	public void init() {
		pnlMenu=new PantallaMenu(juego);
		juego.getVentana().getPnlVista().add(pnlMenu, "Menu");
	}


	public void update() {
		
	}

	public void exit() {
		// TODO Auto-generated method stub
		
	}

	public void show() {
		// TODO Auto-generated method stub
		CardLayout c=(CardLayout) juego.getVentana().getPnlVista().getLayout();
		c.show(juego.getVentana().getPnlVista(), "Menu");
		juego.getVentana().setVisible(true);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
