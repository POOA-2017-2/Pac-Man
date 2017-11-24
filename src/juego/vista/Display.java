package juego.vista;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.vista.panel.PantallaJuego;
import juego.vista.panel.PantallaPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
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

public class Display extends JFrame implements Runnable{

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
	private Canvas canvas;
	private JMenuBar menuBar;
	private JMenuItem About;
	private JMenuItem Rules;
	private JMenuItem Scores;
	private JMenu File;

	
	public Display(int ancho, int alto, String titulo) throws HeadlessException {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		t = new Thread(this);
		init();
	}
		public void init() {
		setTitle(titulo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Display.class.getResource("/Imagenes/cute-juegos-sonriente-pelota-pacman-icono-7066-48.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, ancho, alto);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.BLACK);
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		panelJuego = new JPanel();
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new CardLayout(0, 0));
		
		PantallaPrincipal inicio = new PantallaPrincipal();
		inicio.setBackground(Color.BLACK);
		panelJuego.add(inicio,"PACMAN");
		
		pacman = new PantallaJuego();
		panelJuego.add(pacman,"PACMANJuego");
		
		btnPlay = new JButton("PLAY");
		btnPlay.setForeground(Color.BLACK);
		btnPlay.setBackground(Color.RED);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPlay.setActionCommand("play");
		//btnPlay.addActionListener(ctlBotones);
		panelBotones.add(btnPlay);
		
		menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		File = new JMenu("File");
		menuBar.add(File);
		
		About = new JMenuItem("About");
		File.add(About);
		About.setIcon(new ImageIcon(Display.class.getResource("/Imagenes/punto-de-interrogacion-icono-9434-16.png")));
		
		Rules = new JMenuItem("Rules");
		File.add(Rules);
		Rules.setIcon(new ImageIcon(Display.class.getResource("/Imagenes/protocolo-jabber-icono-5655-16.png")));
		
		Scores = new JMenuItem("High scores");
		File.add(Scores);
		Scores.setIcon(new ImageIcon(Display.class.getResource("/Imagenes/gold-3-icono-6695-16.png")));
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c= (CardLayout)panelJuego.getLayout();
				c.show(panelJuego, "PACMANJuego");
				//pacman.getCanvas().setFocusable(true);
				//btnPlay.setFocusable(false);
				btnPlay.setEnabled(false);
				btnPlay.setBackground(Color.BLACK);
				btnPlay.setText("");
				t.start();
			}
		});
		
	}


		public JPanel getPanelJuego() {
			return panelJuego;
		}

		public void setPanelJuego(JPanel panelJuego) {
			this.panelJuego = panelJuego;
		}

		public int getAncho() {
			return ancho;
		}

		public void setAncho(int ancho) {
			this.ancho = ancho;
		}

		public int getAlto() {
			return alto;
		}

		public void setAlto(int alto) {
			this.alto = alto;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


	public void update() {
		jugador.update();
		//escenario.update();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public void render() {
		bs = getCanvas().getBufferStrategy();
		if (bs == null) {
			getCanvas().createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics(); 
		g.clearRect(0, 0, ancho, alto); 
		//PINTAR ELEMENTOS
		//escenario.render(g);
		jugador.render(g);
		//FIN DE PINTADO
		bs.show();
		g.dispose();
	}
	
	
	public void run() {
		int fps = 60;
		double nanoPorFrame = 1000000000/fps;
		long nuevo;
		long pasado = System.nanoTime();
		double delta = 0;
		while(activo) {
			nuevo = System.nanoTime();
			delta+=(nuevo-pasado)/nanoPorFrame;
			pasado = nuevo;
			if(delta >= 1) {
				update();//actualizacion de logica
				render();//repintado	
				delta --;
			}
		}	
	}
	
	public synchronized void start() {
		if(activo)
			return;
		activo = true;
		t = new Thread (this);
		t.start();
	}
	
	public synchronized void stop() {
		if(!activo)
			return;
		activo = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	

}
