/*purpose:it contains abstract methods
 * @author kishorereddy
 * @version 1.0
 * @since 16/01/2020
 * @file StockManagementDAO.java
 */
package com.bridgelabz.stockmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface StockManagementDAO {
	
	public void addStock(StockManagement stock) throws IOException, ParseException;
	public void viewStock(String stockName) throws IOException, ParseException;
	public void viewAllStocks() throws IOException, ParseException;
	public void updateStock(String stockName) throws IOException, ParseException;
	public void deleteStock(String stockName) throws IOException, ParseException;
	public void writeIntoFile(String stockName,int numberOfShares , double sharePrice) throws IOException, ParseException;
	
	public void stockAccount(CustomerStockAccount customer) throws IOException, ParseException;
	public int[] valueOfAccount(String customerName) throws IOException, ParseException;
	public void buyShare(int amount , String stockName) throws IOException, ParseException;
	public void sellShare(int amount , String stockName) throws FileNotFoundException, IOException, ParseException;
	public void saveFile(String fileName) throws FileNotFoundException, IOException, ParseException;
	public void printReport(String customerName) throws IOException, ParseException;
	public void write(String customerName , int customerId,String[] stockName ,int[] numberOfshares ,double[] shareValue ) throws IOException, ParseException;

}
