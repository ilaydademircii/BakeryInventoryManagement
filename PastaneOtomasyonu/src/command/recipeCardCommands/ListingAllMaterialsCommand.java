package command.recipeCardCommands;

import model.materials.Materials;
import model.recipecard.RecipeCards;
import view.recipecards.SetRecipeCardFrame;

public class ListingAllMaterialsCommand {

	SetRecipeCardFrame frame;

	public ListingAllMaterialsCommand(SetRecipeCardFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);
		for (Materials m : RecipeCards.getInstance().materials) {
			Object[] rowData = { m.getCategory(), m.getName(), m.getAmount(), m.getUnit() };
			frame.modelim.addRow(rowData);

		}
		frame.table.setModel(frame.modelim);
	}
}
