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
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import juego.Display;
import juego.Game;
import juego.elementos.Jugador;
import juego.estado.EstadoJuego;
import juego.manager.BotonManager;
import juego.manager.KeyManager;
import juego.manager.MiBoton;
import juego.manager.Recursos;
import juego.manager.StateManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaJuego extends JPanel{

	private JPanel panelJuego;
	private JButton btnArriba;
	private JButton btnAbajo;
	private JButton btnIzquierda;
	private JButton btnDerecha;
	private MiBoton btnSalir;
	private BotonManager bm;
	private KeyManager km;
	private int ancho;
	private int alto;
	private Canvas canvas;
	private JPanel panel_1;
	private JLabel lblScore;
	private JLabel lblNewLabel;
	private Game juego;
	
	public PantallaJuego(Game juego) {
		super();
		this.juego = juego;
		init(); 
	}

	public void init() {

		bm = new BotonManager();
		setLayout(new BorderLayout(0, 0));
		canvas = new Canvas();
		canvas.setSize(juego.getAncho(), juego.getAlto()-130);
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
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panelFlechas.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel = new JLabel("LIVES : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBackground(Color.BLACK);
		
		lblScore = new JLabel("SCORE:");
		lblScore.setForeground(Color.YELLOW);
		lblScore.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		panel_1.add(lblScore);
		panelFlechas.add(btnArriba);
		
		btnIzquierda = new JButton("");
		btnIzquierda.setBackground(new Color(51, 51, 51));
		btnIzquierda.setIcon(new ImageIcon(PantallaJuego.class.getResource("/Imagenes/flechaIzquierda.png")));
		btnIzquierda.setActionCommand("left");
		btnIzquierda.addActionListener(bm);
		
		btnSalir = new MiBoton("SALIR",Color.red);
		btnSalir.setForeground(Color.BLACK);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(panelJuego, "Deseas dejar la partida?","FIN DE JUEGO",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(action == JOptionPane.YES_OPTION){
					//Scores about = new Scores();
					//about.setVisible(true);
					StateManager.getInstance().setCurrentEstado(EstadoJuego.MENU);
				}
			}
		});
		panelFlechas.add(btnSalir);
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

		km = new KeyManager();
		canvas.addKeyListener(km);
		canvas.setFocusable(true);
		setVisible(true);

	}
	
	public void setScore(int score) {
		lblScore.setText("SCORE: " + score);
	}
	
	public void setLives(int lives) {
		lblNewLabel.setText("LIVES: "+ lives);
	}

	public BotonManager getBm() {
		return bm;
	}
	
	public KeyManager getKm() {
		return km;
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
