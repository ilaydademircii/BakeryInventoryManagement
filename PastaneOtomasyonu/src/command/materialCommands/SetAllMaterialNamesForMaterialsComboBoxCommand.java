package command.materialCommands;

import java.util.List;

import model.materials.Materials;
import view.materials.AddMaterialsFrame;

public class SetAllMaterialNamesForMaterialsComboBoxCommand {
	AddMaterialsFrame frame;
	List<String> list;

	public SetAllMaterialNamesForMaterialsComboBoxCommand(AddMaterialsFrame frame) {
		super();
		this.frame = frame;

	}
	
	
	
	public void execute() {
	
		list = Materials.getInstance().getAllMaterialNames(Materials.getInstance().getCategory());

		for (String model : list) {
			frame.name.addItem(model);
		}
	}
}
