package command.paymentCommands;

import model.payments.RemainingPayments;
import view.payments.RemainingPaymentFrame;

public class ListingAllRemainingPaymentsCommand {

	RemainingPaymentFrame frame;

	public ListingAllRemainingPaymentsCommand(RemainingPaymentFrame frame) {
		super();
		this.frame = frame;

	}

	public void execute() {
		frame.modelim.setRowCount(0);
		for (RemainingPayments p : RemainingPayments.getInstance().getAllRemainingPayments()) {
			Object[] rowData = { p.getCustomerCafeName(), p.getCustomerTaxNumber(), p.getCustomerTaxAdministration(),
					p.getCustomerPhoneNumber(), p.getCustomerAddress(), p.getAmount() };
			frame.modelim.addRow(rowData);

		}
		
		frame.table.setModel(frame.modelim);
	}

}
