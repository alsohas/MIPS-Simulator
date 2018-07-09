package model;

public class Memory {
	
	Binary[] myMemory;
	private int myAddressability = 32;

	public Memory() {
		myMemory = new Binary[myAddressability];
		for (int i = 0; i < myAddressability; i++) {
			myMemory[i] = new Binary(0);
		}
	}
		
	public Binary getContent(int index) {
		if (index < myAddressability) {
			return myMemory[index];
		} else {
			return null;
		}
	}

	public void load(int index, Binary binary) {
		if (index >= myMemory.length) {
			System.out.println("too much " + index);
			return;
		}
		myMemory[index] = binary;
		
	}

	public int getAddressability() {
		return myAddressability ;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < myAddressability; i++) {
			sb.append("0x"+String.format("%04x", i) + ":\t" + myMemory[i].toString() + "\n\n");
		}
		return sb.toString();
	}
	
}
