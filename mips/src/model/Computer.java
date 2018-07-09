package model;

public class Computer {
	
	int PC;
	public Memory myMemory;
	public Register myRegister;
	Binary currentInstruction;
	int currentOperation;
	DecodedInstruction decodedInstruction;
	String currentStage;
	
	public Computer() {
		myRegister = new Register();
		myMemory = new Memory();
		PC = -1;
		//step();
	}
	
	public void setCurrentInstruction(Binary theInstruction) {
		currentInstruction = theInstruction;
	}
	
	public Binary getCurrentInstruction() {
		return currentInstruction;
	}
	
	public void step() {
		
		Fetch.step(this);
		//System.out.println(currentInstruction);
		decodedInstruction = Decode.decodeInstruction(currentInstruction);
		Execute.executeInstruction(this);
	}

	public int getPC() {
		return PC;
	}

	public void setRegister(int destination, int value) {
		myRegister.setRegister(destination, new Binary(value));
		
	}
	
	public void setRegister(int destination, Binary value) {
		myRegister.setRegister(destination, value);
	}
	
	public void loadMemory(int index, Instruction instruction) {
		myMemory.load(index, new Binary(instruction));
	}
	
	public void loadMemory(int index, int value) {
		myMemory.load(index, new Binary(value));
	}
	
	public void loadMemory(int index, Binary value) {
		myMemory.load(index, value);
	}
	
	public void setPC(int pc) {
		PC = pc;
		
	}
	
	public void reset() {
		PC = -1;
		for(int i = 0; i < myMemory.getAddressability(); i++) {
			loadMemory(i, 0);
		}
		
		for(int i = 0; i < myRegister.getSize(); i++) {
			setRegister(i, 0);
		}
	}
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("PC: " + PC + "\n");
		//sb.append("Current instruction: " + currentInstruction.toString() + "\n");
		sb.append(myRegister.toString());
		
		sb.append("\n");
		
		sb.append(myMemory.toString() + "\n");
		
		
		return sb.toString();
	}

}
