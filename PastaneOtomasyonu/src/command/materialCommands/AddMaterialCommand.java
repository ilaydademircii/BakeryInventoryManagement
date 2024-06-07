package command.materialCommands;

import model.materials.Materials;
import view.materials.AddMaterialsFrame;

public class AddMaterialCommand {
	AddMaterialsFrame frame;
	Materials materials;
	
	public AddMaterialCommand(AddMaterialsFrame frame) {
		super();
		this.frame = frame;
		this.materials = Materials.getInstance();
	}


	public void execute() {
		
		materials.setAmount(frame.amount.getText().trim());
		materials.setPrice(frame.price.getText().trim());
		


	}
}
