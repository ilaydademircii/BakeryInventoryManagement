package controllers.payments;

import view.MainFrame;
import view.payments.RemainingPaymentFrame;

public class RemainingPaymentsController {

	private MainFrame mainFrame;
	RemainingPaymentFrame frame;
	
	public RemainingPaymentsController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new RemainingPaymentFrame();
		
	}
	
	
	public void execute() {
		fillFrameInstance();
		

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}
}
