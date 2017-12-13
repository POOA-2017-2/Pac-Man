package juego.vista.panel;

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
		
		setBackground(new Color(204, 255, 204));
		setBorder(new LineBorder(new Color(0, 128, 0), 3, true));
		setLayout(new BorderLayout(0, 0));
	
		JLabel lblUabc = new JLabel("");
		lblUabc.setHorizontalAlignment(SwingConstants.CENTER);
		lblUabc.setIcon(new ImageIcon(PantallaAbout.class.getResource("/Imagenes/escudo-uabc.png")));
		add(lblUabc, BorderLayout.WEST);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel labelUABC = new JLabel("UNIVERSIDAD AUTONOMA DE BAJA CALIFORNIA");
		labelUABC.setForeground(new Color(0, 100, 0));
		labelUABC.setHorizontalAlignment(SwingConstants.CENTER);
		labelUABC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(labelUABC);
		
		JLabel labelFcqi = new JLabel("FACULTAD DE CIENCIAS QUIMICAS E INGENIERIA");
		labelFcqi.setForeground(new Color(0, 0, 139));
		labelFcqi.setHorizontalAlignment(SwingConstants.CENTER);
		labelFcqi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(labelFcqi);
		
		JLabel LabelIC = new JLabel("INGENIERIA EN COMPUTACI\u00D3N");
		LabelIC.setForeground(new Color(0, 0, 139));
		LabelIC.setFont(new Font("Times New Roman", Font.BOLD, 14));
		LabelIC.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(LabelIC);
		
		JLabel lblProgramacinOrientadaA = new JLabel("PROGRAMACI\u00D3N ORIENTADA A OBJETOS AVANZADA");
		lblProgramacinOrientadaA.setForeground(new Color(0, 0, 139));
		lblProgramacinOrientadaA.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblProgramacinOrientadaA);
		
		JLabel lblAngie = new JLabel("ANGELICA JAZMIN AVILA HUIZAR");
		lblAngie.setForeground(new Color(30, 144, 255));
		lblAngie.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngie.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblAngie);
	
		JLabel lblLuna = new JLabel("LUIS MIGUEL LUNA LOPEZ");
		lblLuna.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuna.setForeground(new Color(30, 144, 255));
		lblLuna.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel.add(lblLuna);
	
		JLabel lblNombre = new JLabel(cad);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNombre.setForeground(new Color(0, 0, 139));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNombre);
	
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new LineBorder(new Color(0, 128, 0), 3));
		buttonPane.setBackground(new Color(204, 255, 204));
		add(buttonPane, BorderLayout.SOUTH);
		
		cancelButton = new MiBoton("CANCELAR");
		cancelButton.setForeground(new Color(204, 255, 204));
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
