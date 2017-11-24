package juego.vista.jDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;

public class ReglasDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReglasDialog dialog = new ReglasDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReglasDialog() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReglasDialog.class.getResource("/Imagenes/protocolo-jabber-icono-5655-16.png")));
		setTitle("REGLAS DEL JUEGO");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 255), 4, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {2, 300, 0};
		gbl_contentPanel.rowHeights = new int[] {36, 36, 36, 36, 36, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblR1 = new JLabel("REGLA 1.");
			lblR1.setForeground(new Color(0, 128, 0));
			lblR1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblR1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblR1 = new GridBagConstraints();
			gbc_lblR1.fill = GridBagConstraints.BOTH;
			gbc_lblR1.insets = new Insets(0, 0, 5, 5);
			gbc_lblR1.gridx = 0;
			gbc_lblR1.gridy = 0;
			contentPanel.add(lblR1, gbc_lblR1);
		}
		{
			JLabel lblR1R = new JLabel("DEVORA LOS PUNTOS BLANCOS PARA OBTENER PUNTOS");
			lblR1R.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblR1R.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblR1R = new GridBagConstraints();
			gbc_lblR1R.fill = GridBagConstraints.VERTICAL;
			gbc_lblR1R.insets = new Insets(0, 0, 5, 0);
			gbc_lblR1R.gridx = 1;
			gbc_lblR1R.gridy = 0;
			contentPanel.add(lblR1R, gbc_lblR1R);
		}
		{
			JLabel lblR2 = new JLabel("REGLA 2.");
			lblR2.setForeground(new Color(0, 128, 0));
			lblR2.setHorizontalAlignment(SwingConstants.CENTER);
			lblR2.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblR2 = new GridBagConstraints();
			gbc_lblR2.fill = GridBagConstraints.BOTH;
			gbc_lblR2.insets = new Insets(0, 0, 5, 5);
			gbc_lblR2.gridx = 0;
			gbc_lblR2.gridy = 1;
			contentPanel.add(lblR2, gbc_lblR2);
		}
		{
			JLabel lblR2R = new JLabel("OPRIME LOS BOTONES PARA DIRECCIONARTE POR EL MAPA");
			lblR2R.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblR2R.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblR2R = new GridBagConstraints();
			gbc_lblR2R.fill = GridBagConstraints.BOTH;
			gbc_lblR2R.insets = new Insets(0, 0, 5, 0);
			gbc_lblR2R.gridx = 1;
			gbc_lblR2R.gridy = 1;
			contentPanel.add(lblR2R, gbc_lblR2R);
		}
		{
			JLabel lblR3 = new JLabel("REGLA 3.");
			lblR3.setForeground(new Color(0, 128, 0));
			lblR3.setHorizontalAlignment(SwingConstants.CENTER);
			lblR3.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblR3 = new GridBagConstraints();
			gbc_lblR3.fill = GridBagConstraints.BOTH;
			gbc_lblR3.insets = new Insets(0, 0, 5, 5);
			gbc_lblR3.gridx = 0;
			gbc_lblR3.gridy = 2;
			contentPanel.add(lblR3, gbc_lblR3);
		}
		{
			JLabel lblR3R = new JLabel("EVITA QUE LOS FANTASMAS TE ALCANCEN");
			lblR3R.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblR3R.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblR3R = new GridBagConstraints();
			gbc_lblR3R.fill = GridBagConstraints.BOTH;
			gbc_lblR3R.insets = new Insets(0, 0, 5, 0);
			gbc_lblR3R.gridx = 1;
			gbc_lblR3R.gridy = 2;
			contentPanel.add(lblR3R, gbc_lblR3R);
		}
		{
			JLabel lblR4 = new JLabel("REGLA 4.");
			lblR4.setForeground(new Color(0, 128, 0));
			lblR4.setHorizontalAlignment(SwingConstants.CENTER);
			lblR4.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblR4 = new GridBagConstraints();
			gbc_lblR4.fill = GridBagConstraints.BOTH;
			gbc_lblR4.insets = new Insets(0, 0, 5, 5);
			gbc_lblR4.gridx = 0;
			gbc_lblR4.gridy = 3;
			contentPanel.add(lblR4, gbc_lblR4);
		}
		{
			JLabel lblR4R = new JLabel("SI UN FANTASMA TE ATRAPA EL RESTO SIGUE COMPITIENDO");
			lblR4R.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblR4R.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblR4R = new GridBagConstraints();
			gbc_lblR4R.fill = GridBagConstraints.BOTH;
			gbc_lblR4R.insets = new Insets(0, 0, 5, 0);
			gbc_lblR4R.gridx = 1;
			gbc_lblR4R.gridy = 3;
			contentPanel.add(lblR4R, gbc_lblR4R);
		}
		{
			JLabel lblR5 = new JLabel("REGLA 5.");
			lblR5.setForeground(new Color(0, 128, 0));
			lblR5.setHorizontalAlignment(SwingConstants.CENTER);
			lblR5.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblR5 = new GridBagConstraints();
			gbc_lblR5.fill = GridBagConstraints.BOTH;
			gbc_lblR5.insets = new Insets(0, 0, 5, 5);
			gbc_lblR5.gridx = 0;
			gbc_lblR5.gridy = 4;
			contentPanel.add(lblR5, gbc_lblR5);
		}
		{
			JLabel lblR5R = new JLabel("EL GANADOR SERA EL DE MAYOR PUNTAJE AL FINAL DE LA PARTIDA");
			lblR5R.setHorizontalAlignment(SwingConstants.CENTER);
			lblR5R.setFont(new Font("Tahoma", Font.BOLD, 11));
			GridBagConstraints gbc_lblR5R = new GridBagConstraints();
			gbc_lblR5R.fill = GridBagConstraints.BOTH;
			gbc_lblR5R.insets = new Insets(0, 0, 5, 0);
			gbc_lblR5R.gridx = 1;
			gbc_lblR5R.gridy = 4;
			contentPanel.add(lblR5R, gbc_lblR5R);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 255), 4, true));
			buttonPane.setBackground(new Color(204, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(ReglasDialog.class.getResource("/Imagenes/aceptar-verde-ok-si-icono-8925-16.png")));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setBackground(new Color(0, 102, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				buttonPane.add(okButton);
			}
		}
	}

}
