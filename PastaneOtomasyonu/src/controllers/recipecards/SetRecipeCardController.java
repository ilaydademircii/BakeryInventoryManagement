package controllers.recipecards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import command.recipeCardCommands.GetMaterialForRecipeCardsCommand;
import command.recipeCardCommands.ListingAllMaterialsCommand;
import command.recipeCardCommands.SetAllMaterialNamesForRecipeCardsComboBoxCommand;
import command.recipeCardCommands.SetMaterialCommand;
import model.materials.Materials;
import model.recipecard.RecipeCards;
import view.MainFrame;
import view.recipecards.SetRecipeCardFrame;

public class SetRecipeCardController {

	
	
	
	private MainFrame mainFrame;
	SetRecipeCardFrame frame;
	
	RecipeCards recipeCards;
	Materials materials;
	SetAllMaterialNamesForRecipeCardsComboBoxCommand allMaterialNamesForRecipeCardsComboBoxCommand;
	GetMaterialForRecipeCardsCommand getMaterialForRecipeCardsCommand;
	ListingAllMaterialsCommand listingAllMaterialsCommand;
	SetMaterialCommand setMaterialCommand;

	public SetRecipeCardController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new SetRecipeCardFrame();
		this.recipeCards=RecipeCards.getInstance();
		this.allMaterialNamesForRecipeCardsComboBoxCommand=new SetAllMaterialNamesForRecipeCardsComboBoxCommand(frame);
		this.listingAllMaterialsCommand=new ListingAllMaterialsCommand(frame);
		this.getMaterialForRecipeCardsCommand=new GetMaterialForRecipeCardsCommand(frame);
		this.setMaterialCommand=new SetMaterialCommand(frame);
		this.materials=Materials.getInstance();
	}
	
	
	public void execute() {
		fillFrameInstance();
		addMaterialToList();
		setMaterials();
		setMaterialInfo();
		save();

	}
	
	
	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
	
	
	

	
	
	public void save() {
		 frame.saveButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 	recipeCards.setBarcode(frame.barcode.getText().trim());
			 	recipeCards.setName(frame.name.getText().trim());
			 	recipeCards.save();
			 	}
			 });
		
		
	}
	
	
	public void addMaterialToList() {
		frame.addingMaterialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMaterialCommand.execute();
				RecipeCards.getInstance().materials.add(Materials.getInstance());
				listingAllMaterialsCommand.execute();
				for(Materials m :RecipeCards.getInstance().materials ) {
					System.out.println(m.getBarcode());
				}
			}
		});
		
		
	}
	
	

	private void setMaterials() {
		frame.material_category.addItemListener(new ItemListener() {
			

			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.material_category.removeItemListener(this);
						frame.material_name.removeAllItems();
						clearMaterialInfo();

						Materials.getInstance().setCategory(frame.material_category.getSelectedItem().toString().trim());
						allMaterialNamesForRecipeCardsComboBoxCommand.execute();
						}
					} catch (Exception ex) {
						ex.printStackTrace();
				}	
			}
		});
	}

	private void setMaterialInfo() {
		frame.material_name.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.material_name.removeItemListener(this);
						clearMaterialInfo();
						Materials.getInstance().setName(frame.material_name.getSelectedItem().toString().trim());
						getMaterialForRecipeCardsCommand.execute();
						} 
					}catch (Exception ex) {
					ex.printStackTrace();
				}
				}
			
		});
	}
	private void clearMaterialInfo() {
		frame.material_unit.setText("");


	}
}
