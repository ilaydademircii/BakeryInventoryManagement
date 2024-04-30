package command.comboBoxCommand;

import java.util.List;

import model.Customer;
import view.customers.DeleteCustomerFrame;


public class SetCafeNamesComboBoxCommand {
	DeleteCustomerFrame frame;
	List<String> list;

	public SetCafeNamesComboBoxCommand(DeleteCustomerFrame frame) {
		super();
		this.frame = frame;
		this.frame = frame;

		this.frame = frame;

	}

	public void execute() {
		list = Customer.getInstance().getAllCafeNames();

		for (String model : list) {
			frame.cafeName.addItem(model);
		}
	}
}
