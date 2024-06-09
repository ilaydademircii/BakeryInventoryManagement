package command.recipeCardCommands;

import model.recipecard.RecipeCards;
import view.recipecards.SetRecipeCardFrame;

public class SetRecipeCardCommand {
	SetRecipeCardFrame frame;
	RecipeCards recipecard;
	
	public SetRecipeCardCommand(SetRecipeCardFrame frame) {
		super();
		this.frame = frame;
		this.recipecard = RecipeCards.getInstance();
	}


	public void execute() {
	 	recipecard.setBarcode(frame.barcode.getText().trim());
	 	recipecard.setName(frame.name.getText().trim());
		recipecard.setUnit(frame.unit.getSelectedItem().toString().trim());
		recipecard.setAmount(frame.material_amount.getText().trim());
	}

}
