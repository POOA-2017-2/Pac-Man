package juego.vista.panel;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import juego.manager.MiBoton;
import juego.manager.StateManager;
import juego.Display;
import juego.Game;
import juego.estado.EstadoJuego;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class PantallaMenu extends JPanel {

	private MiBoton btnNuevo;
	private MiBoton btnAcercaDe;
	private MiBoton btnReglas;
	private MiBoton btnSalir;
	private Game juego;
	
	
	public PantallaMenu(Game juego) {
		this.juego = juego;
		init();
	}
	
	public void init() {
		
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
		
		btnNuevo = new MiBoton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.JUEGO);
			}
		});
		setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(PantallaMenu.class.getResource("/Imagenes/pacman-logo2.png")));
		add(lblNewLabel_1);
		add(btnNuevo);
		
		btnAcercaDe = new MiBoton("ACERCA DE");
		btnAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.ACERCADE);
			}
		});
		add(btnAcercaDe);
		
		btnReglas = new MiBoton("REGLAS");
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.REGLAS);
			}
		});
		add(btnReglas);
		      
		btnSalir = new MiBoton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.INICIO);
			}
		});
		add(btnSalir);

	}
}
