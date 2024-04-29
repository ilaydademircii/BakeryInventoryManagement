package controllers.customers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.customerCommands.AddCustomerCommand;
import model.Customer;
import view.MainFrame;
import view.customers.AddCustomerFrame;

public class AddCustomerController {

	private MainFrame mainFrame;
	AddCustomerFrame frame;
	Customer customer;
	
	AddCustomerCommand addCustomerCommand;
	
	public AddCustomerController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new AddCustomerFrame();
		this.customer = Customer.getInstance();
		this.addCustomerCommand=new AddCustomerCommand(frame);
		
		
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
	
	private void save() {
		frame.addingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerCommand.execute();
				customer.save();

			}
		});
	}
}
