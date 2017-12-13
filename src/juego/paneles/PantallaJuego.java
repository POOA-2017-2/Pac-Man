package juego.paneles;

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

import juego.Display;
import juego.Game;
import juego.elementos.Jugador;
import juego.manager.BotonManager;
import juego.manager.Recursos;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.Font;

public class PantallaJuego extends JPanel{

	private JPanel panelJuego;
	private JButton btnArriba;
	private JButton btnAbajo;
	private JButton btnIzquierda;
	private JButton btnDerecha;
	private BotonManager bm;
	private int ancho;
	private int alto;
	private Canvas canvas;
	private Game juego;
	
	public PantallaJuego(Game juego) {
		super();
		this.juego = juego;
		bm = new BotonManager();
		init(); 
	}

	public void init() {
	
		setLayout(new BorderLayout(0, 0));
		canvas = new Canvas();
		canvas.setSize(700, 370);
		canvas.setBackground(Color.BLACK);
		add(canvas,BorderLayout.CENTER);
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
		btnArriba.setBackground(new Color(51, 51, 51));
		btnArriba.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaArriba.png")));
		btnArriba.setActionCommand("up");
		btnArriba.addActionListener(bm);
		
		JLabel lblNewLabel = new JLabel("LIVES : ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.BLACK);
		panelFlechas.add(lblNewLabel);
		panelFlechas.add(btnArriba);
		
		btnIzquierda = new JButton("");
		btnIzquierda.setBackground(new Color(51, 51, 51));
		btnIzquierda.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaIzquierda.png")));
		btnIzquierda.setActionCommand("left");
		btnIzquierda.addActionListener(bm);
		
		JLabel lblNewLabel_1 = new JLabel("SCORE : ");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBackground(Color.BLACK);
		panelFlechas.add(lblNewLabel_1);
		panelFlechas.add(btnIzquierda);
		
		btnAbajo = new JButton("");
		btnAbajo.setBackground(new Color(51, 51, 51));
		btnAbajo.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaAbajo.png")));
		btnAbajo.setActionCommand("down");
		btnAbajo.addActionListener(bm);
		panelFlechas.add(btnAbajo);
		
		btnDerecha = new JButton("");
		btnDerecha.setBackground(new Color(51, 51, 51));
		btnDerecha.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaDerecha.png")));
		btnDerecha.setActionCommand("right");
		btnDerecha.addActionListener(bm);
		panelFlechas.add(btnDerecha);
	
		panelJuego = new JPanel();
		panelJuego.setBorder(new LineBorder(Color.RED, 3, true));
		panelJuego.setSize(200, 200);
		panelJuego.setBackground(Color.BLACK);
		panel.add(panelJuego);
		
		//addKeyListener
		setFocusable(true);

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
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
}
