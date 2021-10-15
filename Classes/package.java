import java.util.*;

public class package {

	private double price;
	private Collection<item> item;

	public String getDescriptions() {
		// TODO - implement package.getDescriptions
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public item getItem() {
		return this.item;
	}

	/**
	 * 
	 * @param item
	 */
	public void setItem(item item) {
		this.item = item;
	}

}