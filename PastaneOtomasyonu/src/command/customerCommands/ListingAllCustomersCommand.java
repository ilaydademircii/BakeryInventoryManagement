package command.customerCommands;

import model.Customer;
import view.customers.ListingCustomersFrame;

public class ListingAllCustomersCommand {

	ListingCustomersFrame frame;

	public ListingAllCustomersCommand(ListingCustomersFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);

		for (Customer c : Customer.getInstance().getAllCustomers()) {
			Object[] rowData = { c.getCafeName(), c.getTaxNo(), c.getTaxAdministration(), c.getPhoneNumber(),
					c.getAddress() };
			frame.modelim.addRow(rowData);

		}
		frame.table.setModel(frame.modelim);
	}

}
