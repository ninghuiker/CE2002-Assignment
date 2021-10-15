public class order {

	private item[] orderItems;
	private package[] orderPackage;
	private staff staff;
	private boolean isMember;
	private datetime date;
	private datetime time;

	/**
	 * 
	 * @param item
	 */
	public void addItem(item item) {
		// TODO - implement order.addItem
		throw new UnsupportedOperationException();
	}

	public item removeItem() {
		// TODO - implement order.removeItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param package_add
	 */
	public void addPackage(package package_add) {
		// TODO - implement order.addPackage
		throw new UnsupportedOperationException();
	}

	public package removePackage() {
		// TODO - implement order.removePackage
		throw new UnsupportedOperationException();
	}

	public String displayOrder() {
		// TODO - implement order.displayOrder
		throw new UnsupportedOperationException();
	}

	public String displayInvoice() {
		// TODO - implement order.displayInvoice
		throw new UnsupportedOperationException();
	}

	public boolean getIsMember() {
		return this.isMember;
	}

	/**
	 * 
	 * @param isMember
	 */
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public datetime getTime() {
		return this.time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(datetime time) {
		this.time = time;
	}

	public datetime getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(datetime date) {
		this.date = date;
	}

}