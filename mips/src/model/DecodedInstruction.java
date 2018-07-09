package model;

public class DecodedInstruction {
	
	char myType;
	int myDestination; 
	int mySource1;
	int mySource2;
	int myOperation;
	int myOffset;
	int myValue;
	
	DecodedInstruction(char theType, int theDestination, int source1, int source2orOffset, int theOperation) {
		if (theType == 'r') {
			myType = theType;
			myDestination = theDestination;
			mySource1 = source1;
			mySource2 = source2orOffset;
			myOperation = theOperation;
			myOffset = -1;
		} else {
			myType = 'i';
			myDestination = theDestination;
			mySource1 = source1;
			myOffset = source2orOffset;
			myOperation = theOperation;
			mySource2 = -1;
		}
		//System.out.println(this.toString() + "---------------");
	}
	
	DecodedInstruction(char theType, int theValue) {
		if (theType == '0') {
			myType = theType;
			myValue = theValue;
			myDestination = -1; 
			mySource1 = -1;
			mySource2 = -1;
			myOperation = -1;
			myOffset = -1;
		}
	}
	
	public char getType() {
		return myType;
	}
	
	public int getDestination() {
		return myDestination;
	}
	
	public int getSource1() {
		return mySource1;
	}
	
	public int getSource2() {
		if (myType == 'r') {
			return mySource2;
		} else {
			return -1;
		}
	}
	
	public int getOffset() {
		if (myType == 'i') {
			return myOffset;
		} else {
			return -1;
		}
	}
	
	public int getOperation() {
		return myOperation;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(myType + " ");
		sb.append(myDestination+ " "); 
		sb.append( mySource1+ " ");
		sb.append(mySource2+ " ");
		sb.append(myOperation+ " ");
		sb.append(myOffset+ " ");
		sb.append(myValue+ " ");
		return sb.toString();
	}
		
}
