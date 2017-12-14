package juego.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import juego.Display;
import juego.Game;
import juego.estado.EstadoJuego;
import juego.manager.MiBoton;
import juego.manager.StateManager;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;

public class PantallaPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private Game juego;
	private MiBoton btnNuevo;
	private MiBoton btnNewButton;
	private Display display;
	
	public PantallaPrincipal(Game juego,Display display) {
		setBorder(new LineBorder(new Color(255, 215, 0), 8));
		this.juego = juego;
		this.display = display;
		init();
	}
	
	public void init() {
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		btnNuevo = new MiBoton("EXIT",Color.RED);
		btnNuevo.setForeground(Color.BLACK);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnNewButton = new MiBoton("START", Color.BLUE.brighter());
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.MENU);
			}
		});	
		panel.add(btnNewButton);
		panel.add(btnNuevo);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image imagen = new ImageIcon(PantallaPrincipal.class.getResource("/Imagenes/pacman.png")).getImage();
		int x = getWidth()/2 - imagen.getWidth(this)/2;
		int y = getHeight()/2 - imagen.getHeight(this)/3;
		g.drawImage(imagen, x, y, this);
		
		Image imagenD = new ImageIcon(PantallaPrincipal.class.getResource("/Imagenes/pacman-logo.png")).getImage();
		int xd = getWidth()/2 - imagenD.getWidth(this)/2;
		int yd = y -  imagenD.getHeight(this);
		g.drawImage(imagenD, xd, yd, this);	
		
		
	}
}
