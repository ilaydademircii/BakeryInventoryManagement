package command.recipeCardCommands;

import java.util.List;

import model.materials.Materials;
import view.recipecards.SetRecipeCardFrame;

public class SetAllMaterialNamesForRecipeCardsComboBoxCommand {
	SetRecipeCardFrame frame;
	List<String> list;

	public SetAllMaterialNamesForRecipeCardsComboBoxCommand(SetRecipeCardFrame frame) {
		super();
		this.frame = frame;

	}

	@SuppressWarnings("unchecked")
	public void execute() {

		list = Materials.getInstance().getAllMaterialNames(Materials.getInstance().getCategory());

		for (String model : list) {
			frame.material_name.addItem(model);
		}
	}
}
