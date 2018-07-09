package model;

public class Instruction {
	
	String[] myInstruction;
	
	String test;
	public Instruction(String theInstruction) {
		myInstruction = theInstruction.split(" ");
		test = theInstruction;
		//System.out.println(this.toString());

	}
	
	public String getOPCode() {
		if (myInstruction != null) {
			return myInstruction[0];
		}
		return "null";
	}
	
	public int getDestination() {
		int register = -1;
		if (myInstruction != null && 
				(myInstruction[0].equals("add") ||
				myInstruction[0].equals("sub") ||
				myInstruction[0].equals("or") ||
				myInstruction[0].equals("and"))) {
					
			if (myInstruction[1].substring(0,2).equals("$t")) {
				if (myInstruction[1].equals("$t0")) {
					register = 1;
				} else if (myInstruction[1].equals("$t1")) {
					register = 2;
				} else if (myInstruction[1].equals("$t2")) {
					register = 3;
				} else if (myInstruction[1].equals("$t3")) {
					register = 4;
				} else if (myInstruction[1].equals("$t4")) {
					register = 5;
				} else if (myInstruction[1].equals("$t5")) {
					register = 6;
				} else if (myInstruction[1].equals("$t6")) {
					register = 7;
				} else if (myInstruction[1].equals("$t7")) {
					register = 8;
				} 
			} else {
				if (myInstruction[1].equals("$s0")) {
					register = 9;
				} else if (myInstruction[1].equals("$s1")) {
					register = 10;
				} else if (myInstruction[1].equals("$s2")) {
					register = 11;
				} else if (myInstruction[1].equals("$s3")) {
					register = 12;
				} else if (myInstruction[1].equals("$s4")) {
					register = 13;
				} else if (myInstruction[1].equals("$s5")) {
					register = 14;
				} else if (myInstruction[1].equals("$s6")) {
					register = 15;
				} else if (myInstruction[1].equals("s7")) {
					register = 16;
				} 
			}
		} else {
			register = iTypeRegister(myInstruction[2]);
		}
		
		return register;
		
	}

	public int getSource() {
		int register = -1;
		if (myInstruction != null && 
				(myInstruction[0].equals("add") ||
				myInstruction[0].equals("sub") ||
				myInstruction[0].equals("or") ||
				myInstruction[0].equals("and"))) {
			
			if (myInstruction[2].substring(0,2).equals("$t")) {
				if (myInstruction[2].equals("$t0")) {
					register = 1;
				} else if (myInstruction[2].equals("$t1")) {
					register = 2;
				} else if (myInstruction[2].equals("$t2")) {
					register = 3;
				} else if (myInstruction[2].equals("$t3")) {
					register = 4;
				} else if (myInstruction[2].equals("$t4")) {
					register = 5;
				} else if (myInstruction[2].equals("$t5")) {
					register = 6;
				} else if (myInstruction[2].equals("$t6")) {
					register = 7;
				} else if (myInstruction[2].equals("$t7")) {
					register = 8;
				} 
			} else if (myInstruction[2].substring(0,2).equals("$s")){
				if (myInstruction[2].equals("$s0")) {
					register = 9;
				} else if (myInstruction[2].equals("$s1")) {
					register = 10;
				} else if (myInstruction[2].equals("$s2")) {
					register = 11;
				} else if (myInstruction[2].equals("$s3")) {
					register = 12;
				} else if (myInstruction[2].equals("$s4")) {
					register = 13;
				} else if (myInstruction[2].equals("$s5")) {
					register = 14;
				} else if (myInstruction[2].equals("$s6")) {
					register = 15;
				} else if (myInstruction[2].equals("$s7")) {
					register = 16;
				} 
			} else if (myInstruction[2].equals("zero")) {
				register = 0;
			}
		} else {
			if (myInstruction[1].substring(0, 2).equals("$t")) {
				if (myInstruction[1].equals("$t0")) {
					register = 1;
				} else if (myInstruction[1].equals("$t1")) {
					register = 2;
				} else if (myInstruction[1].equals("$t2")) {
					register = 3;
				} else if (myInstruction[1].equals("$t3")) {
					register = 4;
				} else if (myInstruction[1].equals("$t4")) {
					register = 5;
				} else if (myInstruction[1].equals("$t5")) {
					register = 6;
				} else if (myInstruction[1].equals("$t6")) {
					register = 7;
				} else if (myInstruction[1].equals("$t7")) {
					register = 8;
				} 
			} else if(myInstruction[1].substring(0, 2).equals("$s")){
				if (myInstruction[1].equals("$s0")) {
					register = 9;
				} else if (myInstruction[1].equals("$s1")) {
					register = 10;
				} else if (myInstruction[1].equals("$s2")) {
					register = 11;
				} else if (myInstruction[1].equals("$s3")) {
					register = 12;
				} else if (myInstruction[1].equals("$s4")) {
					register = 13;
				} else if (myInstruction[1].equals("$s5")) {
					register = 14;
				} else if (myInstruction[1].equals("$s6")) {
					register = 15;
				} else if (myInstruction[1].equals("$s7")) {
					register = 16;
				} 
			} else if (myInstruction[1].equals("$zero")) {
				register = 0;
			}
		}
		return register;
		
	}
	
	private int iTypeRegister(String s) {
		int register = -1;
		
		int l = s.length();
		
		String registerString = s.substring(l-4, l-1);
		if (registerString.substring(0,2).equals("$t")) {
			
			if (registerString.equals("$t0")) {
				register = 1;
			} else if (registerString.equals("$t1")) {
				register = 2;
			} else if (registerString.equals("$t2")) {
				register = 3;
			} else if (registerString.equals("$t3")) {
				register = 4;
			} else if (registerString.equals("$t4")) {
				register = 5;
			} else if (registerString.equals("$t5")) {
				register = 6;
			} else if (registerString.equals("$t6")) {
				register = 7;
			} else if (registerString.equals("$t7")) {
				register = 8;
			} 
		} else if (registerString.substring(0,2).equals("$s")){ 
			if (registerString.equals("$s0")) {
				register = 9;
			} else if (registerString.equals("$s1")) {
				register = 10;
			} else if (registerString.equals("$s2")) {
				register = 11;
			} else if (registerString.equals("$s3")) {
				register = 12;
			} else if (registerString.equals("$s4")) {
				register = 13;
			} else if (registerString.equals("$s5")) {
				register = 14;
			} else if (registerString.equals("$s6")) {
				register = 15;
			} else if (registerString.equals("$s7")) {
				register = 16;
			} 
		} else if (registerString.equals("$zero")){
			register = 0;
		}
		//System.out.println("reg: " + register);
		return register;
		
	}

	
	public int getSource2() {
		int register = -1;
		if (myInstruction != null && 
				(myInstruction[0].equals("add") ||
				myInstruction[0].equals("sub") ||
				myInstruction[0].equals("or") ||
				myInstruction[0].equals("and"))) {
			
			if (myInstruction[3].substring(0, 2).equals("$t")) {
				if (myInstruction[3].equals("$t0")) {
					register = 1;
				} else if (myInstruction[3].equals("$t1")) {
					register = 2;
				} else if (myInstruction[3].equals("$t2")) {
					register = 3;
				} else if (myInstruction[3].equals("$t3")) {
					register = 4;
				} else if (myInstruction[3].equals("$t4")) {
					register = 5;
				} else if (myInstruction[3].equals("$t5")) {
					register = 6;
				} else if (myInstruction[3].equals("$t6")) {
					register = 7;
				} else if (myInstruction[3].equals("$t7")) {
					register = 8;
				}
			} else if(myInstruction[3].substring(0,2).equals("$s")){
				if (myInstruction[3].equals("$s0")) {
					register = 9;
				} else if (myInstruction[3].equals("$s1")) {
					register = 10;
				} else if (myInstruction[3].equals("$s2")) {
					register = 11;
				} else if (myInstruction[3].equals("$s3")) {
					register = 12;
				} else if (myInstruction[3].equals("$s4")) {
					register = 13;
				} else if (myInstruction[3].equals("$s5")) {
					register = 14;
				} else if (myInstruction[3].equals("$s6")) {
					register = 15;
				} else if (myInstruction[3].equals("$s7")) {
					register = 16;
				}
			} else if (myInstruction[3].equals("$zero")){
				register = 0;
			}
		} else {
			register = iTypeOffset(myInstruction[2]);
			//System.out.println("offset: " + register);
		}
		return register;
	}
	
	private int iTypeOffset(String string) {
		char c = 0;
		String s = "";
		int i = 0;
		while (c != '(') {
			s+=string.charAt(i);
			c = string.charAt(i+1);
			i++;
		}
		
		return Integer.parseInt(s);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (myInstruction != null) {
			for(String s: myInstruction) {
				sb.append(s + " "); 
			}
		}
		return sb.toString();
	}
}
