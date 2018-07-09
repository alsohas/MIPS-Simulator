package gui;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterBox extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel myLabel;
	JTextField myTextField;
	int myValue;
	
	public RegisterBox(String s) {
		super();
		myLabel = new JLabel(s);
		
		myTextField = new JTextField(3);
		myTextField.setText("0");
		myValue = Integer.parseInt(myTextField.getText());
		setLayout(new BorderLayout());
		setVisible(true);
		this.add(myLabel, BorderLayout.SOUTH);
		this.add(myTextField, BorderLayout.CENTER);
	}
	
	public void setValue(int val) {
		myValue = val;
		myTextField.setText(String.valueOf(myValue));
		repaint();
	}
	
	public int getValue() {
		return Integer.parseInt(myTextField.getText());
	}
	
	public void setEditable(boolean b) {
		myTextField.setEditable(b);
	}
}
