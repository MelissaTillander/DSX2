package message;

import price.Price;

public class FillMessage implements Comparable<FillMessage> {

	private String user;
	private String product;
	private Price price;
	private int volume;
	private String details;
	private String side;
	public String id;

	public FillMessage(String u, String prd, Price p, int v, String dt,
			String s, String i) {
		user = u;
		product = prd;
		price = p;
		volume = v;
		details = dt;
		side = s;
		id = i;
	}

	public String getUser() {
		return user;
	}

	public String getProduct() {
		return product;
	}

	public Price getPrice() {
		return price;
	}

	public int getVolume() {
		return volume;
	}

	public String getDetails() {
		return details;
	}

	public String getSide() {
		return side;
	}

	public String getId() {
		return id;
	}

	public int compareTo(FillMessage fm) {
		return price.compareTo(fm.getPrice());
	}

	public String toString() {
		return "User: " + user + " Product: " + product + " Price: " + price
				+ " Volume: " + " Details: " + " SIDE: " + side;
	}

}