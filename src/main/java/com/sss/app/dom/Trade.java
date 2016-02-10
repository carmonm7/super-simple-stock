package com.sss.app.dom;

import java.util.Date;

public class Trade {

	private Date timeStamp = null;
	private Stock stock = null;
	private TradeIndicator tradeIndicator = TradeIndicator.BUY;
	private int sharesQuantity = 0;
	private double price = 0.0;

	public Trade() {
		// Empty constructor
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getSharesQuantity() {
		return sharesQuantity;
	}

	public void setSharesQuantity(int sharesQuantity) {
		this.sharesQuantity = sharesQuantity;
	}

	public TradeIndicator getTradeIndicator() {
		return tradeIndicator;
	}

	public void setTradeIndicator(TradeIndicator tradeIndicator) {
		this.tradeIndicator = tradeIndicator;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		String pattern = "Trade Object [timeStamp: %tF %tT, stock: %s, indicator: %s, shares quantity: %7d, price: %8.2f]";
		return String.format(pattern, timeStamp, timeStamp, stock, tradeIndicator, sharesQuantity, price);
	}
}
