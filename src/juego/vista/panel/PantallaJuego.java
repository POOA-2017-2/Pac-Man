package juego.vista.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferStrategy;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import juego.manager.BotonManager;
import juego.manager.Recursos;
import juego.vista.Jugador;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

public class PantallaJuego extends JPanel{

	private JPanel panelJuego;
	private JButton btnArriba;
	private JButton btnAbajo;
	private JButton btnIzquierda;
	private JButton btnDerecha;
	private BotonManager bm;
	private int ancho;
	private int alto;
	private Jugador jugador;
	
	public PantallaJuego() {
		super();
		bm = new BotonManager();
		init(); 
	}

	public void init() {
		jugador = new Jugador (this,this.getWidth()/2,this.getHeight()/2);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelFlechas = new JPanel();
		panelFlechas.setBorder(new LineBorder(Color.RED, 3, true));
		panelFlechas.setBackground(Color.BLACK);
		panelFlechas.setLayout(new GridLayout(2, 6, 0, 0));
		panel.add(panelFlechas, BorderLayout.SOUTH);
		
		btnArriba = new JButton("");
		btnArriba.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaArriba.png")));
		btnArriba.setActionCommand("up");
		btnArriba.addActionListener(bm);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelFlechas.add(lblNewLabel_1);
		panelFlechas.add(btnArriba);
		
		btnIzquierda = new JButton("");
		btnIzquierda.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaIzquierda.png")));
		btnIzquierda.setActionCommand("left");
		btnIzquierda.addActionListener(bm);
		
		JLabel lblNewLabel = new JLabel("");
		panelFlechas.add(lblNewLabel);
		panelFlechas.add(btnIzquierda);
		
		btnAbajo = new JButton("");
		btnAbajo.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaAbajo.png")));
		btnAbajo.setActionCommand("down");
		btnAbajo.addActionListener(bm);
		panelFlechas.add(btnAbajo);
		
		btnDerecha = new JButton("");
		btnDerecha.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaDerecha.png")));
		btnDerecha.setActionCommand("right");
		btnDerecha.addActionListener(bm);
		panelFlechas.add(btnDerecha);
	
		panelJuego = new JPanel();
		panelJuego.setBorder(new LineBorder(Color.RED, 3, true));
		panelJuego.setSize(200, 200);
		panelJuego.setBackground(Color.BLACK);
		panel.add(panelJuego);

	}

	public BotonManager getBm() {
		return bm;
	}


	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
}
