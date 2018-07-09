package gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Computer;
import model.Instruction;

public class Mips extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7738023728213057110L;
	private Computer myComputer;
	RegisterPane registerPane;
	//DisplayPanel myDisplayPane;
	DisplayPanel myDisplayPanel;
	//private boolean isLoaded = false;
	private JButton myResetButton;
	private JPanel myResetPanel;
	private String myInstructionPath;
	JPanel myLoadInstructionPanel;
	
	JPanel myStepPanel;
	private boolean isLoaded;
	private JButton myStepButton;
	private JPanel myButtonPanel;
	private JLabel myPcLabel;
	
	public Mips(Computer c) {
		super("MIPS Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myComputer = c;
		setLayout(new BorderLayout());
		registerPane = new RegisterPane(this, c, myComputer.myRegister);
		myDisplayPanel = new DisplayPanel(myComputer);
		
		myStepButton = new JButton(new StepAction(myComputer, this));
		myStepPanel = new JPanel();
		myStepPanel.add(myStepButton);

		
		
		myResetPanel = new JPanel();
		myResetButton = new JButton(new ResetAction(myComputer, this, registerPane, myDisplayPanel));
		myResetPanel.add(myResetButton);
		
		myLoadInstructionPanel = new LoadInstructionPanel(this);
		
		myButtonPanel = new JPanel();
		myButtonPanel.setLayout(new GridLayout(4,1));
		
		
		add(registerPane, BorderLayout.NORTH);
		add(myDisplayPanel, BorderLayout.CENTER);
		myButtonPanel.add(myResetPanel);
		myButtonPanel.add(myStepPanel);
		myButtonPanel.add(myLoadInstructionPanel);
		
		
		add(myButtonPanel, BorderLayout.EAST);
		
		myPcLabel = new JLabel();
		myPcLabel.setText("pc    " + String.format("%04x", myComputer.getPC()));
		//myPcLabel.
		add(myPcLabel, BorderLayout.SOUTH);
		this.setSize(900, 1000);
		//pack();
		this.setResizable(false);
		setVisible(true);
		
		
	}

	public void setLoaded(boolean b) {
		isLoaded = b;
		registerPane.myLoadRegistersButton.setEnabled(!b);
		
	}
	
	public boolean isLoaded() {
		return isLoaded;
	}

	public void setInstructionPath(String s) {
		myInstructionPath = s;
		loadInstructions();
		
	}
	
	public void repaint() {
		registerPane.repaint();
		myDisplayPanel.repaint();
		myPcLabel.setText(String.format("%04x", myComputer.getPC()));
		
	}
	private void loadInstructions() {
		 File file = new File(myInstructionPath);
		 try {

			 Scanner sc = new Scanner(file);
			 int count = 0;
		     while (sc.hasNextLine() && count < myComputer.myMemory.getAddressability()) {
		    	 String s = sc.nextLine();
		    	 //System.out.print(s);
		         myComputer.loadMemory(count, new Instruction(s));
		         count+=1;
		     }
		     sc.close();
		     myDisplayPanel.repaint();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }	
	}
}
	

