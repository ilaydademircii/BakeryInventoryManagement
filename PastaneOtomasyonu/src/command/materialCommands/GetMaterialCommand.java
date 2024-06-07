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
		
		Materials.getInstance().getMaterial();
		frame.barcode.setText(Materials.getInstance().getBarcode());		
		frame.unit.setText(Materials.getInstance().getUnit());		

	}

}
