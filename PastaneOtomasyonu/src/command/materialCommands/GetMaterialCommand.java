package command.materialCommands;

import model.materials.Materials;
import view.materials.AddMaterialsFrame;

public class GetMaterialCommand {
	
	AddMaterialsFrame frame;
	Materials materials;
	
	public GetMaterialCommand(AddMaterialsFrame frame) {
		super();
		this.frame = frame;
		this.materials = Materials.getInstance();
	}


	public void execute() {
		
		materials.getMaterial();
		frame.barcode.setText(materials.getBarcode());		
		frame.unit.setText(materials.getUnit());		

	}

}
