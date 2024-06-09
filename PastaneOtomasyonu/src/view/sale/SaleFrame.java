package view.sale;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleFrame extends JInternalFrame {
	public JTextField productAmount;
	public JTextField productUnit;
	public JTextField taxNo;
	public JTextField phoneNumber;
	public JTextField taxAdministration;
	public JTextArea address;
	public JTable table;
	public JComboBox productName;
	public JComboBox cafeName;
	public JButton saleButton;
	public JButton addingProductButton;
	public DefaultTableModel modelim;
	
	
	Object[] colums = { "Ürün", "Barkodu", "Miktarı", "Fiyatı" };
	private JLabel lblNewLabel_1;
	public JTextField productPrice;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	public JTextField productBarcode;

	public SaleFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Satış");
		setBounds(100, 100, 928, 737);
		getContentPane().setLayout(null);

		JLabel textf = new JLabel("Kafe Adı");
		textf.setHorizontalAlignment(SwingConstants.LEFT);
		textf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textf.setBounds(38, 54, 90, 30);
		getContentPane().add(textf);

		 addingProductButton = new JButton("Ürün Ekle");

		addingProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addingProductButton.setBounds(293, 628, 126, 30);
		getContentPane().add(addingProductButton);

		JLabel Ürün = new JLabel("Kategori");
		Ürün.setHorizontalAlignment(SwingConstants.LEFT);
		Ürün.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Ürün.setBounds(38, 432, 90, 30);
		getContentPane().add(Ürün);

		JLabel lblNewLabel_1_1 = new JLabel("Miktar");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(38, 528, 90, 30);
		getContentPane().add(lblNewLabel_1_1);

		productAmount = new JTextField();
		productAmount.setColumns(10);
		productAmount.setBounds(192, 528, 240, 30);
		getContentPane().add(productAmount);

		productName = new JComboBox();
		productName.setFont(new Font("Tahoma", Font.BOLD, 11));
		productName.setBounds(192, 432, 240, 30);
		getContentPane().add(productName);

		JLabel lblNewLabel = new JLabel("Satılacak Ürünler");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(38, 387, 233, 34);
		getContentPane().add(lblNewLabel);

		productUnit = new JTextField();
		productUnit.setEditable(false);
		productUnit.setColumns(10);
		productUnit.setBounds(445, 530, 90, 30);
		getContentPane().add(productUnit);

		cafeName = new JComboBox();
		cafeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		cafeName.setBounds(192, 54, 240, 30);
		getContentPane().add(cafeName);

		taxNo = new JTextField();
		taxNo.setEditable(false);
		taxNo.setColumns(10);
		taxNo.setBounds(192, 106, 240, 30);
		getContentPane().add(taxNo);

		JLabel lblNewLabel_1_2 = new JLabel("Vergi No");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(38, 106, 90, 30);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_2 = new JLabel("Vergi Dairesi");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(38, 157, 112, 30);
		getContentPane().add(lblNewLabel_1_2_2);

		JLabel lblTelefonNo = new JLabel("Telefon No");
		lblTelefonNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefonNo.setBounds(38, 207, 112, 30);
		getContentPane().add(lblTelefonNo);

		phoneNumber = new JTextField();
		phoneNumber.setEditable(false);
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(192, 207, 240, 30);
		getContentPane().add(phoneNumber);

		taxAdministration = new JTextField();
		taxAdministration.setEditable(false);
		taxAdministration.setColumns(10);
		taxAdministration.setBounds(192, 157, 240, 30);
		getContentPane().add(taxAdministration);

		JLabel lblAddress = new JLabel("Adres");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(38, 257, 112, 30);
		getContentPane().add(lblAddress);

		address = new JTextArea();
		address.setEditable(false);
		address.setBounds(192, 257, 240, 120);
		getContentPane().add(address);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(518, 89, 356, 331);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		modelim = new DefaultTableModel();
		modelim.setColumnIdentifiers(colums);

		saleButton = new JButton("Satış");

		saleButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saleButton.setBounds(720, 457, 126, 30);
		getContentPane().add(saleButton);
		
		lblNewLabel_1 = new JLabel("Birim Fiyatı");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(38, 575, 90, 30);
		getContentPane().add(lblNewLabel_1);
		
		productPrice = new JTextField();
		productPrice.setColumns(10);
		productPrice.setBounds(192, 575, 240, 30);
		getContentPane().add(productPrice);
		
		lblNewLabel_1_3 = new JLabel("TL");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(445, 571, 90, 30);
		getContentPane().add(lblNewLabel_1_3);
		
		lblNewLabel_1_4 = new JLabel("Barkod");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(38, 482, 90, 30);
		getContentPane().add(lblNewLabel_1_4);
		
		productBarcode = new JTextField();
		productBarcode.setEditable(false);
		productBarcode.setColumns(10);
		productBarcode.setBounds(192, 482, 240, 30);
		getContentPane().add(productBarcode);

	}
}
