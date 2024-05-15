package controllers.payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import command.paymentCommands.ListingAllRemainingPaymentsCommand;
import model.payments.RemainingPayments;
import view.MainFrame;
import view.payments.RemainingPaymentFrame;

public class RemainingPaymentsController {

	private MainFrame mainFrame;
	RemainingPaymentFrame frame;
	
	RemainingPayments remainingPayments;
	
	ListingAllRemainingPaymentsCommand listingAllRemainingPaymentsCommand;
	
	public RemainingPaymentsController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new RemainingPaymentFrame();
		this.remainingPayments=RemainingPayments.getInstance();
		this.listingAllRemainingPaymentsCommand=new ListingAllRemainingPaymentsCommand(frame);
	}
	
	
	public void execute() {
		fillFrameInstance();
		listing();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
	
	 private void listing() {
			frame.listingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listingAllRemainingPaymentsCommand.execute();
				}
			});
	 }
		
	
}
