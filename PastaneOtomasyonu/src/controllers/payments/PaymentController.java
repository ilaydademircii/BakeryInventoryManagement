package controllers.payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.paymentCommands.SetCafeNamesForPaymentComboBoxCommand;
import command.paymentCommands.SetAllReceivedPaymentsCommand;
import model.payments.Payment;
import view.MainFrame;
import view.payments.PaymentFrame;

public class PaymentController {

	private MainFrame mainFrame;
	PaymentFrame frame;
	
	Payment payment; 
	SetAllReceivedPaymentsCommand allReceivedPaymentsCommand;
	SetCafeNamesForPaymentComboBoxCommand cafeNamesComboBoxCommand;
	
	public PaymentController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new PaymentFrame();
		this.allReceivedPaymentsCommand= new SetAllReceivedPaymentsCommand(frame);
		this.cafeNamesComboBoxCommand= new SetCafeNamesForPaymentComboBoxCommand(frame);
		cafeNamesComboBoxCommand.execute();
	}
	
	
	public void execute() {
		fillFrameInstance();
		search();
		

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
	
	private void search() {
		 frame.searchButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		allReceivedPaymentsCommand.execute();
			 		
			 	}
			 });
		
	}
}
