package model;

public class NumberABB {

	private long value;
	private NumberABB left;
	private NumberABB right;
	private NumberABB parent;
	
	public NumberABB(long value) {
		this.value = value;
	}

	
	public NumberABB getParent() {
		return parent;
	}


	public void setParent(NumberABB parent) {
		this.parent = parent;
	}


	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public NumberABB getLeft() {
		return left;
	}

	public void setLeft(NumberABB left) {
		this.left = left;
	}

	public NumberABB getRight() {
		return right;
	}

	public void setRight(NumberABB right) {
		this.right = right;
	}
	
	
}
