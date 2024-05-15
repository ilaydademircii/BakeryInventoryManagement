package controllers.customers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.customerCommands.DeleteCustomerCommand;
import command.customerCommands.SetCafeNamesComboBoxForCustomerCommand;
import model.Customer;
import view.MainFrame;
import view.customers.DeleteCustomerFrame;

public class DeleteCustomerController {

	private MainFrame mainFrame;
	DeleteCustomerFrame frame;
	DeleteCustomerCommand deleteCustomerCommand;
	SetCafeNamesComboBoxForCustomerCommand cafeNamesComboBoxCommand;
	Customer customer;
	
	public DeleteCustomerController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new DeleteCustomerFrame();
		this.customer=Customer.getInstance();
		this.deleteCustomerCommand=new DeleteCustomerCommand(frame);
		this.cafeNamesComboBoxCommand=new SetCafeNamesComboBoxForCustomerCommand(frame);
		this.cafeNamesComboBoxCommand.execute();
	}
	
	
	public void execute() {
		fillFrameInstance();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
	
	
	public void delete() {
		frame.deletingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCustomerCommand.execute();
				customer.deleteCustomer();

			}
		});
	}
		
	
}
