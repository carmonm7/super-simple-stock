package com.sss.app.arch;

import com.sss.app.arch.impl.SimpleStockServicesFactoryImpl;
import com.sss.app.services.SimpleStockService;

/**
 * Factory of the services in the Super Simple Stock application.
 * 
 */
public interface SimpleStockServicesFactory {

	/**
	 * Singleton instance of the factory SimpleStockServicesFactory.
	 */
	public SimpleStockServicesFactory INSTANCE = SimpleStockServicesFactoryImpl.getInstance();

	/**
	 * Gets the singleton instance of the Super Simple Service, which implements
	 * the five operations to calculate the dividend yield, P/E Ratio, Stock
	 * Price, GBCE All Share Index and record trades for a given stock.
	 * 
	 * @return An object of type SimpleStockService, representing a instance of
	 *         the Super Simple Service
	 */
	public SimpleStockService getSimpleStockService();

}
