package controllers.materials;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import command.materialCommands.AddMaterialCommand;
import command.materialCommands.GetMaterialCommand;
import command.materialCommands.SetAllMaterialNamesForMaterialsComboBoxCommand;
import model.materials.Materials;
import view.MainFrame;
import view.materials.AddMaterialsFrame;

public class AddMaterialsController {
	private MainFrame mainFrame;
	AddMaterialsFrame frame;
	
	Materials materials;
	AddMaterialCommand addMaterialCommand ;
	SetAllMaterialNamesForMaterialsComboBoxCommand allMaterialNamesForMaterialsComboBoxCommand;
	GetMaterialCommand getMaterialCommand;
	

	public AddMaterialsController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new AddMaterialsFrame();
		this.addMaterialCommand= new AddMaterialCommand(frame);
		this.allMaterialNamesForMaterialsComboBoxCommand=new SetAllMaterialNamesForMaterialsComboBoxCommand(frame);

		this.getMaterialCommand=new GetMaterialCommand(frame);
		this.materials=Materials.getInstance();
	}
	
	
	public void execute() {
		fillFrameInstance();
		save();
		setMaterials();
		setMaterialInfo();


	}
	
	
	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
	
	
	public void save() {
		frame.addingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMaterialCommand.execute();
				materials.saveMaterial();
			}
		});
	}
	
	
	

	private void setMaterials() {
		frame.category.addItemListener(new ItemListener() {
			

			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.category.removeItemListener(this);
						frame.name.removeAllItems();
						clearMaterialInfo();

						Materials.getInstance().setCategory(frame.category.getSelectedItem().toString().trim());
						allMaterialNamesForMaterialsComboBoxCommand.execute();
						}
					} catch (Exception ex) {
						ex.printStackTrace();
				}	
			}
		});
	}

	private void setMaterialInfo() {
		frame.name.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.name.removeItemListener(this);
						clearMaterialInfo();
						Materials.getInstance().setName(frame.name.getSelectedItem().toString().trim());
						getMaterialCommand.execute();
						} 
					}catch (Exception ex) {
					ex.printStackTrace();
				}
				}
			
		});
	}
	
	
	
	private void clearMaterialInfo() {
		frame.barcode.setText("");
		frame.unit.setText("");


	}



	
	
	
	
	
	
	
	
}
