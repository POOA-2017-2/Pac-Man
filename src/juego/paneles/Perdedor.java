package juego.paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.estado.EstadoJuego;
import juego.manager.AudioManager;
import juego.manager.MiBoton;
import juego.manager.StateManager;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Perdedor extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Perdedor dialog = new Perdedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Perdedor() {
		AudioManager manager=new AudioManager("/sounds/pac man dies.wav");
		manager.start();
		
		int altoP=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int anchoP=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int x= (anchoP/2) - (450/2);
		int y= (altoP/2) - (300/2);
		getContentPane().setBackground(Color.BLACK);
		setBounds(x, y, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new LineBorder(new Color(255, 215, 0), 8));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblGameOver = new JLabel("GAME OVER !!!");
			lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameOver.setForeground(Color.RED);
			lblGameOver.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
			contentPanel.add(lblGameOver, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				MiBoton okButton = new MiBoton("  OK",Color.blue);
				okButton.setForeground(new Color(0, 0, 0));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
					}
				});
				okButton.setBackground(Color.BLACK);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
