package controllers.customers;

import view.MainFrame;
import view.customers.DeleteCustomerFrame;

public class DeleteCustomerController {

	private MainFrame mainFrame;
	DeleteCustomerFrame frame;
	
	public DeleteCustomerController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new DeleteCustomerFrame();
		
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
