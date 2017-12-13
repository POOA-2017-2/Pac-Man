package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.elementos.Jugador;
import juego.estado.EstadoJuego;
import juego.estado.Juego;
import juego.estado.Menu;
import juego.estado.Principal;
import juego.manager.StateManager;
import juego.vista.panel.PantallaJuego;
import juego.vista.panel.PantallaMenu;
import juego.vista.panel.PantallaPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JMenu;

public class Display extends JFrame{

	private JPanel contentPane;
	private JPanel panelJuego ;
	private int ancho;
	private int alto;
	private String titulo;
	private JButton btnPlay ;
	private boolean activo;
	private Graphics g;
	private BufferStrategy bs;
	private PantallaJuego pacman;
	private Jugador jugador;
	private Thread t;
	private JMenuBar menuBar;
	private JMenuItem About;
	private JMenuItem Rules;
	private JMenuItem Scores;
	private JMenu File;
	private int altoP;
	


	private int anchoP;

	
	public Display(int ancho, int alto, String titulo) throws HeadlessException {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		altoP=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		anchoP=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		init();
	}
		public void init() {
		setTitle(titulo);
		int x= (anchoP/2) - (ancho/2);
		int y= (altoP/2) - (alto/2);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Display.class.getResource("/Imagenes/cute-juegos-sonriente-pelota-pacman-icono-7066-48.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, ancho, alto);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelJuego = new JPanel();
		panelJuego.setLayout(new CardLayout(0, 0));
		contentPane.add(panelJuego, BorderLayout.CENTER);
		
		
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public String getTitulo() {
		return titulo;
	}

	public JPanel getPnlVista() {
		return panelJuego;
	}
	
	public int getAltoP() {
		return altoP;
	}
	
	public int getAnchoP() {
		return anchoP;
	}
	
	}
