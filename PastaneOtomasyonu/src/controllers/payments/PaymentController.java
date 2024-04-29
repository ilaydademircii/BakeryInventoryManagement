package controllers.payments;

import view.MainFrame;
import view.payments.PaymentFrame;

public class PaymentController {

	private MainFrame mainFrame;
	PaymentFrame frame;
	
	public PaymentController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame=new PaymentFrame();
		
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
