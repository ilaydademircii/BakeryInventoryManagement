package controllers.sales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import command.saleCommands.GetCafeInfoCommand;
import command.saleCommands.GetProductInfoCommand;
import command.saleCommands.ListingAllProductsCommand;
import command.saleCommands.SetCafeNamesCommand;
import command.saleCommands.SetProductCommand;
import command.saleCommands.SetProductNamesCommand;
import model.Customer;
import model.recipecard.RecipeCards;
import model.sales.Sale;
import view.MainFrame;
import view.sale.SaleFrame;

public class SaleController {

	private MainFrame mainFrame;
	SaleFrame frame;
	Customer customer;
	RecipeCards recipeCards;
	Sale sale;

	SetCafeNamesCommand setCafeNamesCommand;
	GetCafeInfoCommand getcafeInfoCommand;
	SetProductNamesCommand setProductNamesCommand;
	GetProductInfoCommand getProductInfoCommand;
	ListingAllProductsCommand listingAllProductsCommand;
	SetProductCommand setProductCommand;

	public SaleController(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		this.customer = Customer.getInstance();
		this.recipeCards = RecipeCards.getInstance();
		this.sale = Sale.getInstance();
		this.frame = new SaleFrame();
		this.setCafeNamesCommand = new SetCafeNamesCommand(frame);
		setCafeNamesCommand.execute();
		this.getcafeInfoCommand = new GetCafeInfoCommand(frame);
		this.setProductNamesCommand = new SetProductNamesCommand(frame);
		setProductNamesCommand.execute();
		this.getProductInfoCommand = new GetProductInfoCommand(frame);
		this.listingAllProductsCommand = new ListingAllProductsCommand(frame);
		this.setProductCommand = new SetProductCommand(frame);
	}

	public void execute() {
		fillFrameInstance();
		setCustomerInfo();
		setProductInfo();
		addProductToList();
		sale();
	}

	private void fillFrameInstance() {
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		frame.toFront();
	}

	private void sale() {
		frame.saleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sale.sale(frame.taxNo.getText().trim());
			}
		});
	}

	private void setCustomerInfo() {
		frame.cafeName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.cafeName.removeItemListener(this);
						clearCustomerInfo();
						customer.setCafeName(frame.cafeName.getSelectedItem().toString().trim());
						getcafeInfoCommand.execute();

						frame.cafeName.addItemListener(this);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
	}

	public void addProductToList() {
		frame.addingProductButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setProductCommand.execute();
				listingAllProductsCommand.execute();
			}
		});

	}

	private void setProductInfo() {
		frame.productName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						frame.productName.removeItemListener(this);
						clearProductInfo();
						recipeCards.setName(frame.productName.getSelectedItem().toString().trim());
						getProductInfoCommand.execute();

						frame.productName.addItemListener(this);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
	}

	private void clearCustomerInfo() {
		frame.address.setText("");
		frame.phoneNumber.setText("");
		frame.taxNo.setText("");
		frame.taxAdministration.setText("");
	}

	private void clearProductInfo() {
		frame.productBarcode.setText("");
		frame.productUnit.setText("");
		frame.productPrice.setText("");
		frame.productUnit.setText("");
	}

}
