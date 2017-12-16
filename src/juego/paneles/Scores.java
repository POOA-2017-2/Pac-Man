package juego.paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.manager.MiBoton;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Scores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Scores dialog = new Scores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Scores() {
		getContentPane().setBackground(Color.BLACK);
		setBounds(100, 100, 450, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(3, 1, 0, 0));
		{
			JLabel lblPuntajeMayor = new JLabel("PUNTAJE MAYOR!!!");
			lblPuntajeMayor.setForeground(Color.RED);
			lblPuntajeMayor.setBackground(Color.BLACK);
			lblPuntajeMayor.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblPuntajeMayor.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblPuntajeMayor);
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			panel.setBackground(Color.BLACK);
			contentPanel.add(panel);
			{
				JLabel lblNombre = new JLabel("NOMBRE:");
				lblNombre.setForeground(Color.ORANGE);
				lblNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
				panel.add(lblNombre);
			}
			{
				textNombre = new JTextField();
				textNombre.setBackground(Color.BLACK);
				panel.add(textNombre);
				textNombre.setColumns(20);
			}
			{
				JLabel lblScore = new JLabel("SCORE:");
				lblScore.setForeground(Color.ORANGE);
				lblScore.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
				panel.add(lblScore);
			}
			{
				JLabel lblPoints = new JLabel("000000");
				lblPoints.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
				lblPoints.setForeground(Color.BLUE);
				panel.add(lblPoints);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				MiBoton okButton = new MiBoton("OK", Color.blue);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				MiBoton cancelButton = new MiBoton("Cancel",Color.red);
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}
