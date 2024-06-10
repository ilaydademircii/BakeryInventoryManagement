package command.recipeCardCommands;

import java.util.List;

import model.recipecard.RecipeCards;
import view.recipecards.ProducingRecipeCardFrame;

public class SetRecipeCardNamesCommand {
	ProducingRecipeCardFrame frame;
	List<String> list;

	public SetRecipeCardNamesCommand(ProducingRecipeCardFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {

		list = RecipeCards.getInstance().getAllRecipeCardNames();

		for (String model : list) {
			frame.name.addItem(model);
		}
	}
}
