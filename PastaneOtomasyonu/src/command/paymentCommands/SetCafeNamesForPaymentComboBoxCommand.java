package command.paymentCommands;

import java.util.List;

import model.Customer;
import view.payments.PaymentFrame;

public class SetCafeNamesForPaymentComboBoxCommand {
	PaymentFrame frame;
	List<String> list;

	public SetCafeNamesForPaymentComboBoxCommand(PaymentFrame frame) {
		super();
		this.frame = frame;

	}

	@SuppressWarnings("unchecked")
	public void execute() {
		list = Customer.getInstance().getAllCafeNames();

		for (String model : list) {
			frame.cafeName.addItem(model);
		}
	}
}
