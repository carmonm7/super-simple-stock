package com.sss.app.arch.impl;

import com.sss.app.arch.SimpleStockServicesFactory;
import com.sss.app.arch.SpringService;
import com.sss.app.services.SimpleStockService;

/**
 * Implementation of the Factory of the services in the Super Simple Stock
 * application.
 * 
 * As design decision, all possible external systems or high level layers in the
 * application will access to the services through this factory and because of
 * that it is implemented as a singleton, following the singleton pattern
 * proposed by Bill Pugh.
 */
public class SimpleStockServicesFactoryImpl implements SimpleStockServicesFactory {

	/**
	 * Private constructor for the factory which prevents new instance
	 */
	private SimpleStockServicesFactoryImpl() {
		SpringService.INSTANCE.getClass();
	}

	/**
	 * Holder class for the singleton factory instance.
	 * {@link SimpleStockServicesFactoryHolder} is loaded on the first execution
	 * of {@link SimpleStockServicesFactoryImpl#getInstance()} or the first
	 * access to {@link SimpleStockServicesFactoryHolder#INSTANCE}, not before.
	 */
	private static class SimpleStockServicesFactoryHolder {
		private static final SimpleStockServicesFactory INSTANCE = new SimpleStockServicesFactoryImpl();
	}

	/**
	 * Gets the singleton instance of the factory of the services in the Super
	 * Simple Stock application.
	 * 
	 * @return An object of the SimpleStockServicesFactory, which represents the
	 *         factory to access to all services in the Super Simple Stock
	 *         application.
	 */
	public static SimpleStockServicesFactory getInstance() {
		return SimpleStockServicesFactoryHolder.INSTANCE;
	}

	@Override
	public SimpleStockService getSimpleStockService() {
		return SpringService.INSTANCE.getBean("simpleStocksService", SimpleStockService.class);
	}
}
