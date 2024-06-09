package command.saleCommands;

import java.util.List;

import model.recipecard.RecipeCards;
import view.sale.SaleFrame;

public class SetProductNamesCommand {
	SaleFrame frame;
	List<String> list;

	public SetProductNamesCommand(SaleFrame frame) {
		super();
		this.frame = frame;

	}

	@SuppressWarnings("unchecked")
	public void execute() {
		list = RecipeCards.getInstance().getAllRecipeCardNames();
		frame.productName.addItem("");
		for (String model : list) {
			frame.productName.addItem(model);
		}
	}
}
