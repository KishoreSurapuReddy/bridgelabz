package stockmanagement;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface StockManagementDAO {
	
	public void addStock() throws IOException, ParseException;
	public void viewStock(String stockName) throws IOException, ParseException;
	public void viewAllStocks() throws IOException, ParseException;
	public void updateStock(String stockName) throws IOException, ParseException;
	public void deleteStock(String stockName) throws IOException, ParseException;
	public void writeIntoFile(String stockName,int numberOfShares , double sharePrice) throws IOException, ParseException;

}
