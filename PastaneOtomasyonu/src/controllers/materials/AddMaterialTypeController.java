package controllers.materials;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.materialCommands.AddMaterialTypeCommand;
import model.materials.Materials;
import view.MainFrame;
import view.materials.AddMaterialTypeFrame;

public class AddMaterialTypeController {

	private MainFrame mainFrame;
	AddMaterialTypeFrame frame;

	Materials materials;
	AddMaterialTypeCommand addMaterialTypeCommand;

	public AddMaterialTypeController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new AddMaterialTypeFrame();
		this.addMaterialTypeCommand = new AddMaterialTypeCommand(frame);
		this.materials = Materials.getInstance();
	}

	public void execute() {
		fillFrameInstance();
		save();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	public void save() {
		frame.addingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMaterialTypeCommand.execute();
				materials.saveMaterialType();
			}
		});
	}
}
