package com.sss.app.dom;

import org.apache.log4j.Logger;

public class Stock {

	private final Logger logger = Logger.getLogger(Stock.class);
	private String stockSymbol = null;
	private StockType stockType = StockType.COMMON;
	private double lastDividend = 0.0;
	private double fixedDividend = 0.0;
	private double parValue = 0.0;
	private double tickerPrice = 0.0;

	public Stock() {
		// Empty constructor
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public double getParValue() {
		return parValue;
	}

	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	public double getDividendYield() {
		double dividendYield = -1.0;
		if (tickerPrice > 0.0) {
			if (stockType == StockType.COMMON) {
				dividendYield = lastDividend / tickerPrice;
			} else {
				dividendYield = (fixedDividend * parValue) / tickerPrice;
			}
		}
		return dividendYield;
	}

	public double getPeRatio() {
		double peRatio = -1.0;

		if (tickerPrice > 0.0) {
			peRatio = tickerPrice / getDividendYield();
		}
		return peRatio;
	}

	public double getTickerPrice() {
		return tickerPrice;
	}

	public void setTickerPrice(double tickerPrice) {
		logger.debug("Changing ticker price to: " + tickerPrice);
		this.tickerPrice = tickerPrice;
		logger.debug("Ticker price for " + stockSymbol + ": " + tickerPrice);

	}

	@Override
	public String toString() {
		String pattern = "Stock Object [stockSymbol: %s, stockType: %s, lastDividend: %7.0f, fixedDividend: %7.2f, parValue: %7.2f]";
		return String.format(pattern, stockSymbol, stockType, lastDividend, fixedDividend, parValue);
	}
}
