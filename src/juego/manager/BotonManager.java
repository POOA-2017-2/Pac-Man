package juego.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonManager implements ActionListener{

	private boolean left;
	private boolean right;
	private boolean down;
	private boolean up;
	
	public BotonManager() {
		clearAll();
	}

	
	public void actionPerformed(ActionEvent e) {
		String type = e.getActionCommand();
		clearAll();
		switch(type) {
		case "up" :		setUp(true);
						break;
		case "down" :	setDown(true);
						break;
		case "left" :	setLeft(true);
						break;
		case "right" :	setRight(true);
						break;
		
		}
		
	}
	
	public void setLeft(boolean left) {
		this.left = left;
	}


	public void setRight(boolean right) {
		this.right = right;
	}


	public void setDown(boolean down) {
		this.down = down;
	}


	public void setUp(boolean up) {
		this.up = up;
	}
	
	public void clearAll() {
		left = true;
		right = true;
		up = true;
		down = true;
	}


	public boolean isLeft() {
		return left;
	}
	public boolean isRight() {
		return right;
	}
	public boolean isUp() {
		return up;
	}
	public boolean isDown() {
		return down;
	}

}