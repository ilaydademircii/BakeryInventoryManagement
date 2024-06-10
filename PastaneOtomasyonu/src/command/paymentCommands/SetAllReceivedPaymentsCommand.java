package command.paymentCommands;

import model.payments.Payment;
import view.payments.PaymentFrame;

public class SetAllReceivedPaymentsCommand {

	PaymentFrame frame;

	public SetAllReceivedPaymentsCommand(PaymentFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);
		for (Payment p : Payment.getInstance()
				.getAllReceivedPaymentsWithCustomerId(frame.cafeName.getSelectedItem().toString())) {
			Object[] rowData = { p.getAmount(), p.getDate() };

			frame.modelim.addRow(rowData);

		}
		
		frame.table.setModel(frame.modelim);
	}

}
