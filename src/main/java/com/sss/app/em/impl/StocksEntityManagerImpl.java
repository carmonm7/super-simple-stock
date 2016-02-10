package com.sss.app.em.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.sss.app.dom.Stock;
import com.sss.app.dom.Trade;
import com.sss.app.em.StocksEntityManager;

/**
 * Implementation of the Stock Entity Manager.
 * 
 */
public class StocksEntityManagerImpl implements StocksEntityManager {

	private final Logger logger = Logger.getLogger(StocksEntityManagerImpl.class);
	private HashMap<String, Stock> stocks = null;
	private ArrayList<Trade> trades = null;

	public StocksEntityManagerImpl() {
		trades = new ArrayList<Trade>();
		stocks = new HashMap<String, Stock>();
	}

	@Override
	public HashMap<String, Stock> getStocks() {
		return stocks;
	}

	public void setStocks(HashMap<String, Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public ArrayList<Trade> getTrades() {
		return trades;
	}

	public void setTrades(ArrayList<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public boolean recordTrade(Trade trade) throws Exception {
		boolean result = false;
		try {
			result = trades.add(trade);
		} catch (Exception exception) {
			throw new Exception("An error has occurred recording a trade in the system's backend.", exception);
		}
		return result;
	}

	public int getTradesNumber() {
		return trades.size();
	}

	@Override
	public Stock getStockBySymbol(String stockSymbol) {
		Stock stock = null;
		try {
			if (stockSymbol != null) {
				stock = stocks.get(stockSymbol);
			}
		} catch (Exception exception) {
			logger.error("An error has occurred recovering the stock object for the stock symbol: " + stockSymbol + ".", exception);
		}
		return stock;
	}
}
