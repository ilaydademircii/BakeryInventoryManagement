package command.recipeCardCommands;

import model.materials.Materials;
import model.recipecard.RecipeCards;
import view.recipecards.SetRecipeCardFrame;

public class SetMaterialCommand {
	SetRecipeCardFrame frame;
	Materials materials;
	
	public SetMaterialCommand(SetRecipeCardFrame frame) {
		super();
		this.frame = frame;
	}


	public void execute() {
		this.materials = new Materials();

		materials.setCategory(frame.material_category.getSelectedItem().toString().trim());
		materials.setName(frame.material_name.getSelectedItem().toString().trim());
		materials.setUnit(frame.material_unit.getText().trim());
		materials.setAmount(frame.material_amount.getText().trim());
		RecipeCards.getInstance().materials.add(materials);
	}
}
