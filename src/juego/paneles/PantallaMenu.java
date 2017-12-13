package juego.paneles;

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
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;

public class PantallaMenu extends JPanel {

	private MiBoton btnNuevo;
	private MiBoton btnNuevoM;
	private MiBoton btnAcercaDe;
	private MiBoton btnReglas;
	private MiBoton btnSalir;
	private Game juego;
	
	
	public PantallaMenu(Game juego) {
		
		this.juego = juego;
		init();
	}
	
	public void init() {
		setBorder(new LineBorder(new Color(255, 215, 0), 10));
		setBackground(new Color(0, 0, 0));
		setForeground(new Color(0, 0, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{700, 0};
		gridBagLayout.rowHeights = new int[] {100, 60, 60, 60, 60, 60, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(PantallaMenu.class.getResource("/Imagenes/pacman-logo2.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		btnNuevo = new MiBoton("UNIPLAYER",Color.YELLOW);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.JUEGO);
			}
		});
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.BOTH;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 0);
		gbc_btnNuevo.gridx = 0;
		gbc_btnNuevo.gridy = 1;
		add(btnNuevo, gbc_btnNuevo);
		
		btnNuevoM = new MiBoton("MULTIPLAYER",Color.ORANGE);
		GridBagConstraints gbc_btnNuevoM = new GridBagConstraints();
		gbc_btnNuevoM.fill = GridBagConstraints.BOTH;
		gbc_btnNuevoM.insets = new Insets(0, 0, 5, 0);
		gbc_btnNuevoM.gridx = 0;
		gbc_btnNuevoM.gridy = 2;
		add(btnNuevoM, gbc_btnNuevoM);
		
		btnSalir = new MiBoton("SALIR",Color.RED);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.INICIO);
			}
		});
		
		btnReglas = new MiBoton("REGLAS",Color.WHITE.darker());
		btnReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.REGLAS);
			}
		});
		
		btnAcercaDe = new MiBoton("ACERCA DE",Color.BLUE);
		btnAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.ACERCADE);
			}
		});
		GridBagConstraints gbc_btnAcercaDe = new GridBagConstraints();
		gbc_btnAcercaDe.fill = GridBagConstraints.BOTH;
		gbc_btnAcercaDe.insets = new Insets(0, 0, 5, 0);
		gbc_btnAcercaDe.gridx = 0;
		gbc_btnAcercaDe.gridy = 3;
		add(btnAcercaDe, gbc_btnAcercaDe);
		GridBagConstraints gbc_btnReglas = new GridBagConstraints();
		gbc_btnReglas.fill = GridBagConstraints.BOTH;
		gbc_btnReglas.insets = new Insets(0, 0, 5, 0);
		gbc_btnReglas.gridx = 0;
		gbc_btnReglas.gridy = 4;
		add(btnReglas, gbc_btnReglas);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.BOTH;
		gbc_btnSalir.gridx = 0;
		gbc_btnSalir.gridy = 5;
		add(btnSalir, gbc_btnSalir);

	}
}
