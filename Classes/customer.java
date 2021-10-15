public class customer extends person {

	private boolean isMember;
	private int contNum;
	private boolean isActive;

	public boolean getMember() {
		// TODO - implement customer.getMember
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param member
	 */
	public void setMember(boolean member) {
		// TODO - implement customer.setMember
		throw new UnsupportedOperationException();
	}

	public int getContNum() {
		return this.contNum;
	}

	/**
	 * 
	 * @param contNum
	 */
	public void setContNum(int contNum) {
		this.contNum = contNum;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	/**
	 * 
	 * @param isActive
	 */
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}