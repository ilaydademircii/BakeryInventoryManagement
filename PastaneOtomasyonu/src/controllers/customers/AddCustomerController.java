package controllers.customers;

import view.MainFrame;
import view.customers.AddCustomerFrame;

public class AddCustomerController {

	private MainFrame mainFrame;
	AddCustomerFrame frame;
	
	public AddCustomerController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new AddCustomerFrame();
		
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
