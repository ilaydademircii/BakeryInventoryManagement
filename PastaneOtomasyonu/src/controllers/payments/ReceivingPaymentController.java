package controllers.payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.paymentCommands.GetReceivedPaymentCommand;
import command.paymentCommands.SetCafeNamesForReceivingPaymentComboBoxCommand;
import model.Customer;
import model.payments.ReceivingPayment;
import view.MainFrame;
import view.payments.ReceivingPaymentFrame;

public class ReceivingPaymentController {

	private MainFrame mainFrame;
	ReceivingPaymentFrame frame;

	ReceivingPayment receivingPayment;

	SetCafeNamesForReceivingPaymentComboBoxCommand cafeNamesForReceivingPaymentComboBoxCommand;
	GetReceivedPaymentCommand getReceivedPaymentCommand;

	public ReceivingPaymentController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new ReceivingPaymentFrame();
		this.cafeNamesForReceivingPaymentComboBoxCommand = new SetCafeNamesForReceivingPaymentComboBoxCommand(frame);
		this.cafeNamesForReceivingPaymentComboBoxCommand.execute();
		this.receivingPayment = ReceivingPayment.getInstance();
		this.getReceivedPaymentCommand = new GetReceivedPaymentCommand(frame);
	}

	public void execute() {
		fillFrameInstance();
		search();
		getPayment();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void search() {
		frame.searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				receivingPayment.setCustomerName(frame.cafeName.getSelectedItem().toString());
				frame.remainingPaymentAmount.setText(receivingPayment.getRemainingAmount());

			}
		});
	}

	private void getPayment() {
		frame.getPaymentsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getReceivedPaymentCommand.execute();
				receivingPayment.savePayment();
				frame.remainingPaymentAmount.setText(receivingPayment.getRemainingAmount());
			}
		});
	}

}
