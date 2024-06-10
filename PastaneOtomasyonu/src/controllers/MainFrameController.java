package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.customers.AddCustomerController;
import controllers.customers.DeleteCustomerController;
import controllers.customers.ListingCustomersController;
import controllers.materials.AddMaterialTypeController;
import controllers.materials.AddMaterialsController;
import controllers.payments.PaymentController;
import controllers.payments.ReceivingPaymentController;
import controllers.payments.RemainingPaymentsController;
import controllers.recipecards.ProducingRecipeCardController;
import controllers.recipecards.SetRecipeCardController;
import controllers.sales.SaleController;
import view.MainFrame;

public class MainFrameController {
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);

		mainFrame.addCustomerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerController controller = new AddCustomerController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.deleteCustomerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCustomerController controller = new DeleteCustomerController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.listCustomersMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListingCustomersController controller = new ListingCustomersController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.paymentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentController controller = new PaymentController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.receivingPaymentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReceivingPaymentController controller = new ReceivingPaymentController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.remainingPaymentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemainingPaymentsController controller = new RemainingPaymentsController(mainFrame);
				controller.execute();
			}
		});

		mainFrame.materialTypeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMaterialTypeController controller = new AddMaterialTypeController(mainFrame);
				controller.execute();
			}
		});
		mainFrame.materialMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMaterialsController controller = new AddMaterialsController(mainFrame);
				controller.execute();
			}
		});
		mainFrame.recipeCardMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetRecipeCardController controller = new SetRecipeCardController(mainFrame);
				controller.execute();
			}
		});
		mainFrame.productMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProducingRecipeCardController controller = new ProducingRecipeCardController(mainFrame);
				controller.execute();
			}
		});
		mainFrame.saleMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleController controller = new SaleController(mainFrame);
				controller.execute();
			}
		});
	}
}
