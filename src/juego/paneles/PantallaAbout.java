package juego.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import juego.Game;
import juego.estado.EstadoJuego;
import juego.manager.MiBoton;
import juego.manager.StateManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaAbout extends JPanel{


	private String cad;
	private MiBoton cancelButton;
	private Game juego;

	public PantallaAbout(String cad, Game juego) {
		this.cad = cad;
		this.juego = juego;
		init();
	}
	
	public void init() {
		
		setBackground(new Color(0, 0, 0));
		setBorder(new LineBorder(new Color(255, 215, 0), 10));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(0, 0, 0));
		add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[] {210, 450, 0};
		gbl_panelPrincipal.rowHeights = new int[] {440, 0};
		gbl_panelPrincipal.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelPrincipal.rowWeights = new double[]{0.0, 1.0};
		panelPrincipal.setLayout(gbl_panelPrincipal);
						
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panelPrincipal.add(panel, gbc_panel);
		panel.setBackground(new Color(0, 0, 0));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{460, 0};
		gbl_panel.rowHeights = new int[] {55, 55, 55, 55, 55, 55, 55, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel labelUABC = new JLabel("UNIVERSIDAD AUTONOMA DE BAJA CALIFORNIA");
		labelUABC.setForeground(new Color(154, 205, 50));
		labelUABC.setHorizontalAlignment(SwingConstants.CENTER);
		labelUABC.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_labelUABC = new GridBagConstraints();
		gbc_labelUABC.fill = GridBagConstraints.BOTH;
		gbc_labelUABC.insets = new Insets(0, 0, 5, 0);
		gbc_labelUABC.gridx = 0;
		gbc_labelUABC.gridy = 0;
		panel.add(labelUABC, gbc_labelUABC);
		
		JLabel labelFcqi = new JLabel("FACULTAD DE CIENCIAS QUIMICAS E INGENIERIA");
		labelFcqi.setForeground(new Color(72, 209, 204));
		labelFcqi.setHorizontalAlignment(SwingConstants.CENTER);
		labelFcqi.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_labelFcqi = new GridBagConstraints();
		gbc_labelFcqi.fill = GridBagConstraints.BOTH;
		gbc_labelFcqi.insets = new Insets(0, 0, 5, 0);
		gbc_labelFcqi.gridx = 0;
		gbc_labelFcqi.gridy = 1;
		panel.add(labelFcqi, gbc_labelFcqi);
		
		JLabel LabelIC = new JLabel("INGENIERIA EN COMPUTACI\u00D3N");
		LabelIC.setForeground(new Color(72, 209, 204));
		LabelIC.setFont(new Font("Tahoma", Font.BOLD, 14));
		LabelIC.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_LabelIC = new GridBagConstraints();
		gbc_LabelIC.fill = GridBagConstraints.BOTH;
		gbc_LabelIC.insets = new Insets(0, 0, 5, 0);
		gbc_LabelIC.gridx = 0;
		gbc_LabelIC.gridy = 2;
		panel.add(LabelIC, gbc_LabelIC);
		
		JLabel lblProgramacinOrientadaA = new JLabel("PROGRAMACI\u00D3N ORIENTADA A OBJETOS AVANZADA");
		lblProgramacinOrientadaA.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramacinOrientadaA.setForeground(new Color(72, 209, 204));
		lblProgramacinOrientadaA.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblProgramacinOrientadaA = new GridBagConstraints();
		gbc_lblProgramacinOrientadaA.fill = GridBagConstraints.BOTH;
		gbc_lblProgramacinOrientadaA.insets = new Insets(0, 0, 5, 0);
		gbc_lblProgramacinOrientadaA.gridx = 0;
		gbc_lblProgramacinOrientadaA.gridy = 3;
		panel.add(lblProgramacinOrientadaA, gbc_lblProgramacinOrientadaA);
		
		JLabel lblAngie = new JLabel("ANGELICA JAZMIN AVILA HUIZAR");
		lblAngie.setForeground(new Color(255, 215, 0));
		lblAngie.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngie.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblAngie = new GridBagConstraints();
		gbc_lblAngie.fill = GridBagConstraints.BOTH;
		gbc_lblAngie.insets = new Insets(0, 0, 5, 0);
		gbc_lblAngie.gridx = 0;
		gbc_lblAngie.gridy = 4;
		panel.add(lblAngie, gbc_lblAngie);
				
		JLabel lblLuna = new JLabel("LUIS MIGUEL LUNA LOPEZ");
		lblLuna.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuna.setForeground(new Color(255, 215, 0));
		lblLuna.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblLuna = new GridBagConstraints();
		gbc_lblLuna.fill = GridBagConstraints.BOTH;
		gbc_lblLuna.insets = new Insets(0, 0, 5, 0);
		gbc_lblLuna.gridx = 0;
		gbc_lblLuna.gridy = 5;
		panel.add(lblLuna, gbc_lblLuna);

		JLabel lblNombre = new JLabel(cad);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setForeground(new Color(255, 0, 0));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 6;
		panel.add(lblNombre, gbc_lblNombre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panelPrincipal.add(panel_1, gbc_panel_1);
					
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{1, 0};
		gbl_panel_1.rowHeights = new int[] {440, 30};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
					
		JLabel lblUabc = new JLabel("");
		GridBagConstraints gbc_lblUabc = new GridBagConstraints();
		gbc_lblUabc.insets = new Insets(0, 0, 5, 0);
		gbc_lblUabc.fill = GridBagConstraints.BOTH;
		gbc_lblUabc.gridx = 0;
		gbc_lblUabc.gridy = 0;
		panel_1.add(lblUabc, gbc_lblUabc);
		lblUabc.setBackground(new Color(152, 251, 152));
		lblUabc.setHorizontalAlignment(SwingConstants.CENTER);
		lblUabc.setIcon(new ImageIcon(PantallaAbout.class.getResource("/Imagenes/escudo-uabc.png")));

		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(null);
		buttonPane.setBackground(new Color(0, 0, 0));
		add(buttonPane, BorderLayout.SOUTH);
		
		cancelButton = new MiBoton("CANCELAR",Color.RED);
		cancelButton.setForeground(new Color(0, 0, 0));
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateManager.getInstance().setCurrentEstado(EstadoJuego.MENU);
			}
		});
		buttonPane.setLayout(new BorderLayout(0, 0));
		buttonPane.add(cancelButton);
		
		
	}
}
