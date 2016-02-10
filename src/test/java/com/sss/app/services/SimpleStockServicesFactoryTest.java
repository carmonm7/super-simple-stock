package com.sss.app.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.sss.app.arch.SimpleStockServicesFactory;
import com.sss.app.arch.SpringService;
import com.sss.app.dom.Trade;
import com.sss.app.em.StocksEntityManager;

public class SimpleStockServicesFactoryTest {

	Logger logger = Logger.getLogger(SimpleStockServicesFactoryTest.class);

	/**
	 * Exercise A III) Record a trade, with timestamp, quantity of shares, buy
	 * or sell indicator and price.
	 */
	@Test
	public void recordATradeTest() {
		logger.info("Start  recordATradeTest ...");

		// Create the stock service and verify it's not null object
		SimpleStockService simpleStockService = SimpleStockServicesFactory.INSTANCE.getSimpleStockService();
		Assert.assertNotNull(simpleStockService);

		// Recover the trades configured in spring for the unit test
		@SuppressWarnings("unchecked")
		ArrayList<Trade> tradeList = SpringService.INSTANCE.getBean("tradeList", ArrayList.class);
		Assert.assertNotNull(tradeList);
		logger.info("Trade List size: " + tradeList.size());

		try {
			// Initial trades are empty, means, trades number equals to cero (0)
			StocksEntityManager stocksEntityManager = SpringService.INSTANCE.getBean("stocksEntityManager", StocksEntityManager.class);
			int tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: " + tradesNumber);
			Assert.assertEquals(tradesNumber, 0);

			// Insert many trades in the stock system
			for (Trade trade : tradeList) {
				boolean result = simpleStockService.recordTrade(trade);
				Assert.assertTrue(result);
			}

			// After record trades, the number of trades should be equal to the
			// trades list
			tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: " + tradesNumber);
			Assert.assertEquals(tradesNumber, tradeList.size());

		} catch (Exception exception) {
			logger.error(exception);
			Assert.assertTrue(false);
		}

		logger.info("Finish recordATradeTest ...OK");
	}

	/**
	 * Exercise A I) Calculate the dividend yield.
	 */
	@Test
	public void calculateDividendYieldTest() {
		logger.info("Start  calculateDividendYieldTest ...");

		try {
			// Create the stock service and verify it's not null object
			SimpleStockService simpleStockService = SimpleStockServicesFactory.INSTANCE.getSimpleStockService();
			Assert.assertNotNull(simpleStockService);

			StocksEntityManager stocksEntityManager = SpringService.INSTANCE.getBean("stocksEntityManager", StocksEntityManager.class);
			Integer tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: " + tradesNumber);

			// Calculates the dividend yield for the stock symbol
			String[] stockSymbols = { "TEA", "POP", "ALE", "GIN", "JOE" };
			for (String stockSymbol : stockSymbols) {
				double dividendYield = simpleStockService.calculateDividendYield(stockSymbol);
				logger.info(stockSymbol + " - DividendYield calculated: " + dividendYield);
				Assert.assertTrue(dividendYield >= 0.0);
			}
		} catch (Exception exception) {
			logger.error(exception);
			Assert.assertTrue(false);
		}

		logger.info("Finish calculateDividendYieldTest ...OK");
	}

	/**
	 * Exercise A II) Calculate the P/E Ratio.
	 */
	@Test
	public void calculatePERatioTest() {
		logger.info("Start  calculatePERatioTest ...");

		try {
			// Create the stock service and verify it's not null object
			SimpleStockService simpleStockService = SimpleStockServicesFactory.INSTANCE.getSimpleStockService();
			Assert.assertNotNull(simpleStockService);

			StocksEntityManager stocksEntityManager = SpringService.INSTANCE.getBean("stocksEntityManager", StocksEntityManager.class);
			int tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: " + tradesNumber);

			// Calculates the P/E Ratio for the stock Symbol
			String[] stockSymbols = { "TEA", "POP", "ALE", "GIN", "JOE" };
			for (String stockSymbol : stockSymbols) {
				double peRatio = simpleStockService.calculatePERatio(stockSymbol);
				logger.info(stockSymbol + " - P/E Ratio calculated: " + peRatio);
				Assert.assertTrue(peRatio >= 0.0);
			}
		} catch (Exception exception) {
			logger.error(exception);
			Assert.assertTrue(false);
		}

		logger.info("Finish calculatePERatioTest ...OK");
	}

	/**
	 * Exercise A IV) Calculate Stock Price based on trades recorded in past 15
	 * minutes.
	 */
	@Test
	public void calculateStockPriceTest() {
		try {
			// Create the stock service and verify it's not null object
			SimpleStockService simpleStockService = SimpleStockServicesFactory.INSTANCE.getSimpleStockService();
			Assert.assertNotNull(simpleStockService);

			StocksEntityManager stocksEntityManager = SpringService.INSTANCE.getBean("stocksEntityManager", StocksEntityManager.class);
			int tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: " + tradesNumber);

			// Calculates the Stock Price for all stocks
			String[] stockSymbols = { "TEA", "POP", "ALE", "GIN", "JOE" };
			for (String stockSymbol : stockSymbols) {
				double stockPrice = simpleStockService.calculateStockPrice(stockSymbol);
				logger.info(stockSymbol + " - Stock Price calculated: " + stockPrice);
				Assert.assertTrue(stockPrice >= 0.0);
			}
		} catch (Exception exception) {
			logger.error(exception);
			Assert.assertTrue(false);
		}
	}

	/**
	 * Exercise B) Calculate the GBCE All Share Index using the geometric mean
	 * of prices for all stocks.
	 */
	@Test
	public void calculateGBCEAllShareIndexTest() {
		try {
			// Create the stock service and verify it's not null object
			SimpleStockService simpleStockService = SimpleStockServicesFactory.INSTANCE.getSimpleStockService();
			Assert.assertNotNull(simpleStockService);

			StocksEntityManager stocksEntityManager = SpringService.INSTANCE.getBean("stocksEntityManager", StocksEntityManager.class);
			int tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: " + tradesNumber);

			double GBCEAllShareIndex = simpleStockService.calculateGBCEAllShareIndex();
			logger.info("GBCE All Share Index: " + GBCEAllShareIndex);
			Assert.assertTrue(GBCEAllShareIndex > 0.0);

		} catch (Exception exception) {
			logger.error(exception);
			Assert.assertTrue(false);
		}
	}
}
