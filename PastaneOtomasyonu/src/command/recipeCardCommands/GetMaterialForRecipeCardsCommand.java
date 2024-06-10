package command.recipeCardCommands;

import model.materials.Materials;
import view.recipecards.SetRecipeCardFrame;

public class GetMaterialForRecipeCardsCommand {
	SetRecipeCardFrame frame;
	Materials materials;

	public GetMaterialForRecipeCardsCommand(SetRecipeCardFrame frame) {
		super();
		this.frame = frame;
		this.materials = Materials.getInstance();
	}

	public void execute() {

		Materials.getInstance().getMaterial();
		frame.material_unit.setText(Materials.getInstance().getUnit());

	}
}
