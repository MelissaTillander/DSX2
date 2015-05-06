package tradable;

import price.InvalidPriceOperation;
import price.Price;

public class QuoteSide implements Tradable {

	String user;
	String id;
	Price sideP;
	int volume;
	long time = System.nanoTime();
	String side;
	String userName;
	String product;
	Price price;
	int originalVolume;
	int remainingVolume;
	int cancelledVolume;
	boolean quote;

	public QuoteSide(String userName, String productSymbol, Price sidePrice,
			int originalVolume, String sideB) throws InvalidPriceOperation {
		if(originalVolume < 1){
			throw new InvalidPriceOperation("Cannot have 0 or negative buy volume");
		}
		user = userName;
		product = productSymbol;
		sideP = sidePrice;
		volume = originalVolume;
		side = sideB;
		price = sidePrice;

		id = userName + product + time;

	}

	public QuoteSide(QuoteSide qs) {
		user = qs.getUserName();
		product = qs.getProduct();
		volume = qs.getVolume();
		side = qs.getSide();
	}

	public String getUserName() {
		return user;
	}


	public QuoteSide getQuoteSide(String sideln) {

		return null;
	}

	public int getVolume() {
		return volume;
	}

	public String getProduct() {
		return product;
	}

	public Price getPrice() {
		return price;
	}

	public int getOriginalVolume() {
		return originalVolume;
	}

	public int getRemainingVolume() {
		return remainingVolume;
	}

	public int getCancelledVolume() {
		return cancelledVolume;
	}

	public void setRemainingVolume(int newRemainingVolume) throws InvalidPriceOperation{
		if(newRemainingVolume > originalVolume){
			throw new InvalidPriceOperation("Cannot cancel more volume than original volume");
		}
		remainingVolume = newRemainingVolume;
	}
	
	public void setCancelledVolume(int newCancelledVolume) throws InvalidPriceOperation {
		if(newCancelledVolume > originalVolume){
			throw new InvalidPriceOperation("Cannot cancel more volume than original volume");
		}
		cancelledVolume = newCancelledVolume;
	}

	public String getUser() {
		return userName;
	}

	public String getSide() {
		return side;
	}

	public boolean isQuote() {
		return false;
	}

	public String getId() {
		return user + product + time;
	}
	
	public String toString(){
		return price + " x " + originalVolume + "(Original Vol: " + originalVolume + ", CXL'd Vol: " + cancelledVolume + ") [" + id + "]"; 
	}


}