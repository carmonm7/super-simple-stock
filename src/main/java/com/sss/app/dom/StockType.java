package com.sss.app.dom;

/**
 * Constants for the stock type available in the Simple Stocks application.
 * 
 */
public enum StockType {
	/**
	 * Indicates that a stock is common and the dividend yield is calculated
	 * with last dividend.
	 */
	COMMON,

	/**
	 * Indicates that a stock is preferred and the dividend yield is calculated
	 * with fixed dividend.
	 */
	PREFERRED
}
