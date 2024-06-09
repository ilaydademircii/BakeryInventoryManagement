package controllers.customers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.customerCommands.ListingAllCustomersCommand;
import view.MainFrame;
import view.customers.ListingCustomersFrame;

public class ListingCustomersController {

	private MainFrame mainFrame;
	ListingCustomersFrame frame;
	ListingAllCustomersCommand listingAllCustomersCommand;
	
	public ListingCustomersController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new ListingCustomersFrame();
		this.listingAllCustomersCommand=new ListingAllCustomersCommand(frame);
		
	}
	
	
	public void execute() {
		fillFrameInstance();
		listing();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
	
	
	 private void listing() {
			frame.listingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listingAllCustomersCommand.execute();
				}
			});
	 }
		
}
