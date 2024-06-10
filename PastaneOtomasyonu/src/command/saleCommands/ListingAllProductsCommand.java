package command.saleCommands;

import model.recipecard.RecipeCards;
import model.sales.Sale;
import view.sale.SaleFrame;

public class ListingAllProductsCommand {
	SaleFrame frame;
	Sale sale;

	public ListingAllProductsCommand(SaleFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);
		for (RecipeCards rc : Sale.getInstance().list) {
			rc.setTotalPrice(carpim(rc.getPrice(), rc.getAmount()));

			Object[] rowData = { rc.getName(), rc.getBarcode(), rc.getAmount(), rc.getTotalPrice() };
			frame.modelim.addRow(rowData);

		}
		
		frame.table.setModel(frame.modelim);
	}

	private String carpim(String price, String amount) {
		int priceInt = Integer.parseInt(price);
		int amountInt = Integer.parseInt(amount);

		int result = priceInt * amountInt;

		String resultString = Integer.toString(result);
		return resultString;
	}

}
