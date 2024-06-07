package command.paymentCommands;

import java.util.List;

import model.Customer;
import view.payments.ReceivingPaymentFrame;

public class SetCafeNamesForReceivingPaymentComboBoxCommand {
	ReceivingPaymentFrame frame;
	List<String> list;

	public SetCafeNamesForReceivingPaymentComboBoxCommand(ReceivingPaymentFrame frame) {
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
