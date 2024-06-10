package controllers.customers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import command.customerCommands.DeleteCustomerCommand;
import command.customerCommands.SetCafeNamesComboBoxForCustomerCommand;
import command.paymentCommands.GetCustomerInfoCommand;
import model.Customer;
import view.MainFrame;
import view.customers.DeleteCustomerFrame;

public class DeleteCustomerController {

	private MainFrame mainFrame;
	DeleteCustomerFrame frame;
	DeleteCustomerCommand deleteCustomerCommand;
	SetCafeNamesComboBoxForCustomerCommand cafeNamesComboBoxCommand;
	Customer customer;
	GetCustomerInfoCommand customerInfoCommand;

	public DeleteCustomerController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.frame = new DeleteCustomerFrame();
		this.customer = Customer.getInstance();
		this.deleteCustomerCommand = new DeleteCustomerCommand(frame);
		this.cafeNamesComboBoxCommand = new SetCafeNamesComboBoxForCustomerCommand(frame);
		this.cafeNamesComboBoxCommand.execute();
		this.customerInfoCommand=new GetCustomerInfoCommand(frame);
	}

	public void execute() {
		fillFrameInstance();
		setCustomerInfo();
		delete();

	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	public void delete() {
		frame.deletingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCustomerCommand.execute();
				customer.deleteCustomer();

			}
		});
	}
	
	private void setCustomerInfo() {
		frame.cafeName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.cafeName.removeItemListener(this);
				
						customer.setCafeName(frame.cafeName.getSelectedItem().toString().trim());
						customerInfoCommand.execute();

						frame.cafeName.addItemListener(this);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
	}

}
