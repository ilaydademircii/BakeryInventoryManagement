package command.recipeCardCommands;

import model.recipecard.RecipeCards;
import view.recipecards.ProducingRecipeCardFrame;

public class SetProducingRecipeCardCommand {
	ProducingRecipeCardFrame frame;
	RecipeCards recipecard;
	
	public SetProducingRecipeCardCommand(ProducingRecipeCardFrame frame) {
		super();
		this.frame = frame;
		this.recipecard = RecipeCards.getInstance();
	}


	public void execute() {
	 	recipecard.setBarcode(frame.barcode.getText().trim());
	 	recipecard.setName(frame.name.getSelectedItem().toString().trim());
		recipecard.setUnit(frame.unit.getText().trim());
		recipecard.setAmount(frame.amount.getText().trim());
	}

}
