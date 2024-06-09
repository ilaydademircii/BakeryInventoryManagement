package controllers.recipecards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import command.recipeCardCommands.GetProducingRecipeCardCommand;
import command.recipeCardCommands.SetProducingRecipeCardCommand;
import command.recipeCardCommands.SetRecipeCardNamesCommand;
import model.recipecard.RecipeCards;
import view.MainFrame;
import view.recipecards.ProducingRecipeCardFrame;

public class ProducingRecipeCardController {

	private MainFrame mainFrame;
	ProducingRecipeCardFrame frame;

	RecipeCards recipeCards;
	GetProducingRecipeCardCommand getProducingRecipeCardCommand;
	SetProducingRecipeCardCommand setProducingRecipeCardCommand;
	SetRecipeCardNamesCommand setRecipeCardNamesCommand;

	public ProducingRecipeCardController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new ProducingRecipeCardFrame();
		this.recipeCards = RecipeCards.getInstance();
		this.getProducingRecipeCardCommand = new GetProducingRecipeCardCommand(frame);
		this.setProducingRecipeCardCommand = new SetProducingRecipeCardCommand(frame);
		this.setRecipeCardNamesCommand = new SetRecipeCardNamesCommand(frame);
		this.setRecipeCardNamesCommand.execute();
	}

	public void execute() {
		fillFrameInstance();
		setMaterialInfo();
		save();
	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void save() {
		frame.addingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setProducingRecipeCardCommand.execute();
				recipeCards.saveProducingRecipeCard();
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
						recipeCards.setName(frame.name.getSelectedItem().toString().trim());
						getProducingRecipeCardCommand.execute();

						frame.name.addItemListener(this);
					}
				} catch (Exception ex) {
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
