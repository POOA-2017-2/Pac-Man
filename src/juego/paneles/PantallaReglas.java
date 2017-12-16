package juego.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import juego.Game;
import juego.estado.EstadoJuego;
import juego.manager.MiBoton;
import juego.manager.StateManager;
import javax.swing.ImageIcon;
public class PantallaReglas extends JPanel{

	private Game juego;
	public PantallaReglas(Game juego) {
		this.juego = juego;
	
		init();
	}
	
	public void init() {
		setBackground(new Color(0, 0, 0));
		setBorder(new LineBorder(new Color(255, 215, 0), 10));
			setLayout(new BorderLayout(0, 0));
			
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(0, 0, 0));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(buttonPane, BorderLayout.SOUTH);
				
		MiBoton okButton = new MiBoton("OK",Color.BLUE);
		okButton.setForeground(new Color(0, 0, 0));
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.MENU);
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantallaReglas.class.getResource("/Imagenes/aceptar-verde-ok-si-icono-8925-16.png")));
		buttonPane.add(label);
		buttonPane.add(okButton);
			
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, (int)(juego.getAncho()*0.175), (int) (juego.getAncho()*0.825), 0};
		int row = (int)(juego.getAncho()*0.075);
		gbl_panel.rowHeights = new int[] {row, row, row, row, row, row, 30};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		JLabel lblR1 = new JLabel("REGLA 1.");
		GridBagConstraints gbc_lblR1 = new GridBagConstraints();
		gbc_lblR1.fill = GridBagConstraints.BOTH;
		gbc_lblR1.insets = new Insets(0, 0, 5, 5);
		gbc_lblR1.gridx = 1;
		gbc_lblR1.gridy = 1;
		panel.add(lblR1, gbc_lblR1);
		lblR1.setForeground(new Color(255, 0, 0));
		lblR1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblR1.setHorizontalAlignment(SwingConstants.CENTER);
				
		JLabel lblR1R = new JLabel("DEVORA LOS PUNTOS BLANCOS PARA OBTENER PUNTOS");
		lblR1R.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblR1R = new GridBagConstraints();
		gbc_lblR1R.fill = GridBagConstraints.BOTH;
		gbc_lblR1R.insets = new Insets(0, 0, 5, 0);
		gbc_lblR1R.gridx = 2;
		gbc_lblR1R.gridy = 1;
		panel.add(lblR1R, gbc_lblR1R);
		lblR1R.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblR1R.setHorizontalAlignment(SwingConstants.CENTER);
			
		JLabel lblR2 = new JLabel("REGLA 2.");
		GridBagConstraints gbc_lblR2 = new GridBagConstraints();
		gbc_lblR2.fill = GridBagConstraints.BOTH;
		gbc_lblR2.insets = new Insets(0, 0, 5, 5);
		gbc_lblR2.gridx = 1;
		gbc_lblR2.gridy = 2;
		panel.add(lblR2, gbc_lblR2);
		lblR2.setForeground(new Color(255, 0, 0));
		lblR2.setHorizontalAlignment(SwingConstants.CENTER);
		lblR2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		JLabel lblR2R = new JLabel("OPRIME LOS BOTONES PARA DIRECCIONARTE POR EL MAPA");
		lblR2R.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblR2R = new GridBagConstraints();
		gbc_lblR2R.fill = GridBagConstraints.BOTH;
		gbc_lblR2R.insets = new Insets(0, 0, 5, 0);
		gbc_lblR2R.gridx = 2;
		gbc_lblR2R.gridy = 2;
		panel.add(lblR2R, gbc_lblR2R);
		lblR2R.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblR2R.setHorizontalAlignment(SwingConstants.CENTER);
	
		JLabel lblR3 = new JLabel("REGLA 3.");
		GridBagConstraints gbc_lblR3 = new GridBagConstraints();
		gbc_lblR3.fill = GridBagConstraints.BOTH;
		gbc_lblR3.insets = new Insets(0, 0, 5, 5);
		gbc_lblR3.gridx = 1;
		gbc_lblR3.gridy = 3;
		panel.add(lblR3, gbc_lblR3);
		lblR3.setForeground(new Color(255, 0, 0));
		lblR3.setHorizontalAlignment(SwingConstants.CENTER);
		lblR3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
	
		JLabel lblR3R = new JLabel("EVITA QUE LOS FANTASMAS TE ALCANCEN");
		lblR3R.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblR3R = new GridBagConstraints();
		gbc_lblR3R.fill = GridBagConstraints.BOTH;
		gbc_lblR3R.insets = new Insets(0, 0, 5, 0);
		gbc_lblR3R.gridx = 2;
		gbc_lblR3R.gridy = 3;
		panel.add(lblR3R, gbc_lblR3R);
		lblR3R.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblR3R.setHorizontalAlignment(SwingConstants.CENTER);
			
		JLabel lblR4 = new JLabel("REGLA 4.");
		GridBagConstraints gbc_lblR4 = new GridBagConstraints();
		gbc_lblR4.fill = GridBagConstraints.BOTH;
		gbc_lblR4.insets = new Insets(0, 0, 5, 5);
		gbc_lblR4.gridx = 1;
		gbc_lblR4.gridy = 4;
		panel.add(lblR4, gbc_lblR4);
		lblR4.setForeground(new Color(255, 0, 0));
		lblR4.setHorizontalAlignment(SwingConstants.CENTER);
		lblR4.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		JLabel lblR4R = new JLabel("SI UN FANTASMA TE ATRAPA EL RESTO SIGUE COMPITIENDO");
		lblR4R.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblR4R = new GridBagConstraints();
		gbc_lblR4R.fill = GridBagConstraints.BOTH;
		gbc_lblR4R.insets = new Insets(0, 0, 5, 0);
		gbc_lblR4R.gridx = 2;
		gbc_lblR4R.gridy = 4;
		panel.add(lblR4R, gbc_lblR4R);
		lblR4R.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblR4R.setHorizontalAlignment(SwingConstants.CENTER);
	
		JLabel lblR5 = new JLabel("REGLA 5.");
		GridBagConstraints gbc_lblR5 = new GridBagConstraints();
		gbc_lblR5.fill = GridBagConstraints.BOTH;
		gbc_lblR5.insets = new Insets(0, 0, 5, 5);
		gbc_lblR5.gridx = 1;
		gbc_lblR5.gridy = 5;
		panel.add(lblR5, gbc_lblR5);
		lblR5.setForeground(new Color(255, 0, 0));
		lblR5.setHorizontalAlignment(SwingConstants.CENTER);
		lblR5.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		JLabel lblR5R = new JLabel("EL GANADOR SERA EL DE MAYOR PUNTAJE AL FINAL DE LA PARTIDA");
		lblR5R.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblR5R = new GridBagConstraints();
		gbc_lblR5R.insets = new Insets(0, 0, 5, 0);
		gbc_lblR5R.fill = GridBagConstraints.BOTH;
		gbc_lblR5R.gridx = 2;
		gbc_lblR5R.gridy = 5;
		panel.add(lblR5R, gbc_lblR5R);
		lblR5R.setHorizontalAlignment(SwingConstants.CENTER);
		lblR5R.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 0, 0));
		add(panelTitulo, BorderLayout.NORTH);
		
		JLabel titulo = new JLabel("REGLAS DEL JUEGO");
		titulo.setForeground(new Color(0, 0, 255));
		titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		panelTitulo.add(titulo);
	}
}
