package command.recipeCardCommands;

import model.recipecard.RecipeCards;
import view.recipecards.ProducingRecipeCardFrame;

public class GetProducingRecipeCardCommand {
	ProducingRecipeCardFrame frame;
	RecipeCards recipecard;
	
	public GetProducingRecipeCardCommand(ProducingRecipeCardFrame frame) {
		super();
		this.frame = frame;
		this.recipecard = RecipeCards.getInstance();
	}


	public void execute() {
		recipecard.setName(frame.name.getSelectedItem().toString().trim());
		recipecard.getRecipeCard();
		
		frame.barcode.setText(recipecard.getBarcode());		
		frame.unit.setText(recipecard.getUnit());		

	}
	
	
}
