package command.paymentCommands;

import model.Customer;
import view.customers.DeleteCustomerFrame;

public class GetCustomerInfoCommand {
	DeleteCustomerFrame frame;
	Customer customer;

	public GetCustomerInfoCommand(DeleteCustomerFrame frame) {
		super();
		this.frame = frame;
		this.customer = Customer.getInstance();
	}

	public void execute() {
		customer.getCustomer();
		frame.taxNo.setText(customer.getTaxNo());
		frame.taxAdministration.setText(customer.getTaxAdministration());
		frame.phoneNumber.setText(customer.getPhoneNumber());
		frame.address.setText(customer.getAddress());
		frame.explanation.setText(customer.getExplanation());

		
	}

}
