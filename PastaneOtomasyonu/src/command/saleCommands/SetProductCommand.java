package command.saleCommands;

import model.recipecard.RecipeCards;
import model.sales.Sale;
import view.sale.SaleFrame;

public class SetProductCommand {
	SaleFrame frame;
	RecipeCards recipeCards;

	public SetProductCommand(SaleFrame frame) {
		super();
		this.frame = frame;
		
	}

	public void execute() {
		this.recipeCards =new RecipeCards();
		recipeCards.setName(frame.productName.getSelectedItem().toString().trim());
		recipeCards.setBarcode(frame.productBarcode.getText().trim());
		recipeCards.setAmount(frame.productAmount.getText().trim());
		recipeCards.setPrice(frame.productPrice.getText().trim());
		recipeCards.setUnit(frame.productUnit.getText().trim());
		Sale.getInstance().list.add(recipeCards);

	}

}
