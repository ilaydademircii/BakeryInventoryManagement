package command.customerCommands;

import model.Customer;
import view.customers.DeleteCustomerFrame;

public class DeleteCustomerCommand {
	
	DeleteCustomerFrame frame;
	
	public DeleteCustomerCommand(DeleteCustomerFrame frame ) {
		this.frame=frame;
	}

	public void execute() {
		Customer customer = Customer.getInstance();
		customer.setCafeName(frame.cafeName.getSelectedItem().toString());

	}

}
