package command.saleCommands;

import model.Customer;
import view.sale.SaleFrame;

public class GetCafeInfoCommand {
	SaleFrame frame;
	Customer customer;

	public GetCafeInfoCommand(SaleFrame frame) {
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

	}

}
