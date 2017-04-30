package registrar;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class CRNButton extends JButton {
	
	private Dimension size;
	
	public CRNButton(String text) {
		super(text);
		size = new Dimension(30, this.getHeight());
		this.setSize(30, this.getHeight());
		this.setMaximumSize(size);
		this.setMinimumSize(size);
	}
	
	public void add() {
		this.setForeground(Color.RED);
	}
	
	public void drop() {
		this.setForeground(Color.BLACK);
	}

}
