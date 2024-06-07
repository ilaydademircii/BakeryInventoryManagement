package command.materialCommands;

import model.materials.Materials;
import view.materials.AddMaterialTypeFrame;

public class AddMaterialTypeCommand {
	AddMaterialTypeFrame frame;
	Materials materials;
	
	public AddMaterialTypeCommand(AddMaterialTypeFrame frame) {
		super();
		this.frame = frame;
		this.materials = Materials.getInstance();
	}


	public void execute() {
		
		materials.setCategory(frame.category.getSelectedItem().toString().trim());
		materials.setName(frame.name.getText().toString().trim());
		materials.setBarcode(frame.barcode.getText().toString().trim());
		materials.setUnit(frame.unit.getSelectedItem().toString().trim());
		


	}
}
