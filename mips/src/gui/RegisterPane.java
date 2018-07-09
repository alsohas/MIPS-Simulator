package gui;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Computer;
import model.Register;


public class RegisterPane extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Computer myComputer;
	
	Mips myMips;
	
	private Register myRegister;
	
	private List<RegisterBox> myRegisterBoxes;
	
	JButton myLoadRegistersButton;

	public RegisterPane(Mips m, Computer c, Register theRegister) {
		super();
		myMips = m;
		myComputer = c;
		myRegister = theRegister;
		myRegisterBoxes = new ArrayList<RegisterBox>();
		
		//setLayout(new BorderLayout());
		setUpRegisters();
		addLoadButton();
		setVisible(true);
	}

	private void addLoadButton() {
		myLoadRegistersButton = new JButton(new LoadRegisterAction("Set registers", myComputer,
				myMips, myRegisterBoxes));
		add(myLoadRegistersButton, BorderLayout.CENTER);

	}

	public int getRegSize() {
		return myRegister.getSize();
	}
	
	private void setUpRegisters() {
		
		try {
			for (int i = 0; i < myRegister.getSize(); i++) {
				RegisterBox regBox;;
				if (i == 0) {
					regBox = new RegisterBox("$zero");
					regBox.setEditable(false);
				} else if (i < 9) {
					regBox = new RegisterBox("$t" + (i-1));
				} else {
					regBox = new RegisterBox("$s" + (i-9));
				}
				
				myRegisterBoxes.add(regBox);
				this.add(regBox);
			}
		} catch (Exception e) {
			return;
		}	
	}
	
	public void repaint() {
		setUpRegisters();
	}
	public void reset() {
		for (RegisterBox rb: myRegisterBoxes) {
			if (!rb.equals(myRegisterBoxes.get(0))) {
				rb.setValue(0);
				rb.setEditable(true);
			}
			
		}
		myMips.setLoaded(false);
		repaint();
	}
}