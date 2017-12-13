package juego.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonModel;
import javax.swing.JButton;



public class MiBoton extends JButton{

	String text;
	
	public MiBoton(String text) {
		super(text);
		setContentAreaFilled(false);
		setOpaque(false);
		setBorderPainted(false);
		this.text=text;
		
		//addActionListener(new AccionBoton(juego));
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		ButtonModel modelo=getModel();
		FontMetrics fm=g.getFontMetrics();
		Rectangle2D r2d=fm.getStringBounds(text,g);
		int x=(int) (getWidth()/2-r2d.getWidth()/2);
		int y=(int) (getHeight()/2+r2d.getHeight()/2);
		g.setColor(Color.red);
		g.setFont(new Font("Tahoma", Font.BOLD, 13));
		//g.setFont(Font.BOLD);
	
		if(modelo.isArmed() && modelo.isPressed()){
			g.setColor(Color.yellow.brighter());
			g.drawString(text, x, y);
			
		}
		g.drawString(text, x, y);
		
		
	}
	
}