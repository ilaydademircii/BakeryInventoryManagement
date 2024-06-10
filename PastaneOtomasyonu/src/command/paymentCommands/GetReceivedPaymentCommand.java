package command.paymentCommands;

import model.payments.ReceivingPayment;
import view.payments.ReceivingPaymentFrame;

public class GetReceivedPaymentCommand {

	ReceivingPaymentFrame frame;
	ReceivingPayment receivingPayment;

	public GetReceivedPaymentCommand(ReceivingPaymentFrame frame) {
		super();
		this.frame = frame;
		this.receivingPayment = ReceivingPayment.getInstance();
	}

	public void execute() {

		receivingPayment.setCustomerName(frame.cafeName.getSelectedItem().toString().trim());
		receivingPayment.setReceivedAmount(frame.receivedPaymentAmount.getText().trim());
	}

}
