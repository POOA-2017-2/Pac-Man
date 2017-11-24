package juego.vista.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import juego.vista.Display;

import java.awt.BorderLayout;
import java.awt.CardLayout;

public class PantallaPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PantallaPrincipal() {

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
