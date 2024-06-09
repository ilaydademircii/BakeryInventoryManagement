package command.saleCommands;

import java.util.List;

import model.Customer;
import view.sale.SaleFrame;

public class SetCafeNamesCommand {
	SaleFrame frame;
	List<String> list;

	public SetCafeNamesCommand(SaleFrame frame) {
		super();
		this.frame = frame;

	}

	@SuppressWarnings("unchecked")
	public void execute() {
		list = Customer.getInstance().getAllCafeNames();
		frame.cafeName.addItem("");
		for (String model : list) {
			frame.cafeName.addItem(model);
		}
	}
}
