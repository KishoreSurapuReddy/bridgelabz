package stockmanagement;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class StockManagementMain {
	StockManagementDAOImpl stock = new StockManagementDAOImpl();
	public void menu() throws IOException, ParseException {
		System.out.println("--------------------");
		System.out.println("  STOCK MANAGEMENT  ");
		System.out.println("  1.add stock       ");
		System.out.println("  2.view stock      ");
		System.out.println("  3.view all stocks ");
		System.out.println("  4.delete stock    ");
		System.out.println("  5.update stock    ");
		System.out.println("  6.exit            ");
		System.out.println("enter the choice");
		int choice = stock.scanner.nextInt();
		switch(choice) {
		case 1:
			stock.addStock();
			menu();
			break;
		case 2:
			System.out.println("enter the stock name :");
			String name = stock.scanner.next();
			stock.viewStock(name);
			menu();
			break;
		case 3:
			stock.viewAllStocks();
			menu();
			break;
		case 4:
			System.out.println("enter the stock name to delete ");
			String deletename = stock.scanner.next();
			stock.deleteStock(deletename);
			menu();
			break;
		case 5:
			System.out.println("enter the name stock to update ");
			String update  = stock.scanner.next();
			stock.updateStock(update);
			menu();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("enter the range between 1-6 only");

		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		StockManagementMain stockmain = new StockManagementMain();
		stockmain.menu();

	}

}
