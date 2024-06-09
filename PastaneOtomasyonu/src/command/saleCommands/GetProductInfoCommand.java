package command.saleCommands;

import model.recipecard.RecipeCards;
import view.sale.SaleFrame;

public class GetProductInfoCommand {
	SaleFrame frame;
	RecipeCards recipecard;
	
	public GetProductInfoCommand(SaleFrame frame) {
		super();
		this.frame = frame;
		this.recipecard = RecipeCards.getInstance();
	}


	public void execute() {
		recipecard.setName(frame.productName.getSelectedItem().toString().trim());
		recipecard.getRecipeCard();
		
		frame.productBarcode.setText(recipecard.getBarcode());		
		frame.productUnit.setText(recipecard.getUnit());		



	}

}
