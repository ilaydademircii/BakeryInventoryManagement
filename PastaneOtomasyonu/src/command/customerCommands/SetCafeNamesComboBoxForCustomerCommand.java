package command.customerCommands;

import java.util.List;

import model.Customer;
import view.customers.DeleteCustomerFrame;


public class SetCafeNamesComboBoxForCustomerCommand {
	DeleteCustomerFrame frame;
	List<String> list;

	public SetCafeNamesComboBoxForCustomerCommand(DeleteCustomerFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		list = Customer.getInstance().getAllCafeNames();

		for (String model : list) {
			frame.cafeName.addItem(model);
		}
	}
}
