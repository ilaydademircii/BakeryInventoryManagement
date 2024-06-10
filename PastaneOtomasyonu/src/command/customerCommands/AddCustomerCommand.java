package command.customerCommands;

import model.Customer;
import view.customers.AddCustomerFrame;

public class AddCustomerCommand {

	AddCustomerFrame frame;
	Customer customer;

	public AddCustomerCommand(AddCustomerFrame frame) {
		super();
		this.frame = frame;
		this.customer = Customer.getInstance();
	}

	public void execute() {

		customer.setCafeName(frame.cafeName.getText().trim());
		customer.setTaxNo(frame.taxNumber.getText().trim());
		customer.setTaxAdministration(frame.taxAdministration.getText().trim());
		customer.setPhoneNumber(frame.phoneNumber.getText().trim());
		customer.setAddress(frame.address.getText().trim());
		customer.setExplanation(frame.explanation.getText().trim());

	}

}
