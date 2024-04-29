package controllers.customers;

import view.MainFrame;
import view.customers.ListingCustomersFrame;

public class ListingCustomersController {

	private MainFrame mainFrame;
	ListingCustomersFrame frame;
	
	public ListingCustomersController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new ListingCustomersFrame();
		
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
