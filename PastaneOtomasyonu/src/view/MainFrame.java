package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JDesktopPane;

public class MainFrame extends JFrame {

//	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JDesktopPane desktopPane;
	public JMenu paymentsMenu;
	public JMenuItem receivingPaymentsMenuItem;
	public JMenuItem paymentMenuItem;
	public JMenuItem remainingPaymentsMenuItem;
	
	public JMenu customersMenu;
	public JMenuItem addCustomerMenuItem;
	public JMenuItem deleteCustomerMenuItem;
	public JMenuItem listCustomersMenuItem;
	public JMenuItem materialMenuItem;
	public JMenuItem materialTypeMenuItem;
	public JMenu mnNewMenu_1;
	public JMenuItem recipeCardMenuItem;
	public JMenuItem productMenuItem;
	public JMenuItem saleMenuItem;
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		paymentsMenu = new JMenu("Ödemeler");
		menuBar.add(paymentsMenu);
		
		receivingPaymentsMenuItem = new JMenuItem("Ödeme alış");
		paymentsMenu.add(receivingPaymentsMenuItem);
		
		paymentMenuItem = new JMenuItem("Geçmiş Ödemeler");
		paymentsMenu.add(paymentMenuItem);
		
		remainingPaymentsMenuItem = new JMenuItem("Kalan Ödemeler");
		paymentsMenu.add(remainingPaymentsMenuItem);
		
		customersMenu = new JMenu("Müşteriler");
		menuBar.add(customersMenu);
		
		addCustomerMenuItem = new JMenuItem("Müşteri Ekleme");
		customersMenu.add(addCustomerMenuItem);
		
		deleteCustomerMenuItem = new JMenuItem("Müşteri Silme");
		customersMenu.add(deleteCustomerMenuItem);
		
		listCustomersMenuItem = new JMenuItem("Listeleme");
		customersMenu.add(listCustomersMenuItem);
		
		JMenu mnNewMenu = new JMenu("Malzemeler");
		menuBar.add(mnNewMenu);
		
		 materialTypeMenuItem = new JMenuItem("Malzeme Türü Ekleme");
		mnNewMenu.add(materialTypeMenuItem);
		
		 materialMenuItem = new JMenuItem("Malzeme Ekleme");
		mnNewMenu.add(materialMenuItem);
		
		mnNewMenu_1 = new JMenu("Tarif Kartı");
		menuBar.add(mnNewMenu_1);
		
		recipeCardMenuItem = new JMenuItem("Tarif Kartı Ekle");
		mnNewMenu_1.add(recipeCardMenuItem);
		
		productMenuItem = new JMenuItem("Ürün Ekle");
		mnNewMenu_1.add(productMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Satış");
		menuBar.add(mnNewMenu_2);
		
		 saleMenuItem = new JMenuItem("Satış");
		mnNewMenu_2.add(saleMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 434, 239);
		contentPane.add(desktopPane);
	}
}
