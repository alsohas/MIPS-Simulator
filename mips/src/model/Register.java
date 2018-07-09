package model;
public class Register {

	int SIZE = 17;
	Binary[] myRegisters = new Binary[SIZE];
	
	public Register() {
		for (int i = 0; i < SIZE; i++) {
			myRegisters[i] = new Binary(0);
		}
	}
	
	public void setRegister(int index, Binary theBin) {
		if (index > myRegisters.length - 1) {
			return;
		} else {
			myRegisters[index] = theBin;
		}
	}
	
	public Binary getRegisterContent(int index) {
		if (index > myRegisters.length -1) {
			return null;
		} else {
			return myRegisters[index];
		}
	}
	
//	public int getRegisterContentDecimal(int index) {
//		
//	}
	public int getSize() {
		return SIZE;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < myRegisters.length; i++) {
			if (i == 0) {
				sb.append("$zero:\t" + myRegisters[i].toString() + "\n\n");
			} else if (i < 9) {
				sb.append("$t" + (i-1)+ ":\t" + myRegisters[i].toString() + "\n\n");
			} else if (i >= 9) {
				sb.append("$s" + (i-9)+ ":\t" + myRegisters[i].toString() + "\n\n");
			}
		}
		return sb.toString();
	}
}
