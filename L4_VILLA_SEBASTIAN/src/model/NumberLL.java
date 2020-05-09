package model;

public class NumberLL {

	private Long number;
	private NumberLL nextNumber;
	
	public NumberLL (Long num) {
		
		number= num;
	}

	public Long getNumber() {
		return number;
	}

	public NumberLL getNextNumber() {
		return nextNumber;
	}

	public void setNextNumber(NumberLL nextNumber) {
		this.nextNumber = nextNumber;
	}
	
	
}

