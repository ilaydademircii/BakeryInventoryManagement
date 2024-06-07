package controllers.recipecards;

import model.recipecard.RecipeCards;
import view.MainFrame;
import view.recipecards.ProducingRecipeCardFrame;

public class ProducingRecipeCardController {
	
	
	private MainFrame mainFrame;
	ProducingRecipeCardFrame frame;
	
	RecipeCards recipeCards;
	

	public ProducingRecipeCardController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new ProducingRecipeCardFrame();
		
	}
	
	
	public void execute() {
		fillFrameInstance();


	}
	
	
	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
	
	
	

}
