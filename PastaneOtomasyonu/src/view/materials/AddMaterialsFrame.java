package view.materials;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class AddMaterialsFrame extends JInternalFrame {
	public JTextField unit;
	public JTextField barcode;
	public JTextField amount;
	public JTextField price;
	public JComboBox name;
	public JComboBox category;
	public JButton addingButton;

	public AddMaterialsFrame() {
		setTitle("Malzeme Alım");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 610, 345);
		getContentPane().setLayout(null);

		JLabel lblrnAd = new JLabel("Kategori");
		lblrnAd.setHorizontalAlignment(SwingConstants.LEFT);
		lblrnAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrnAd.setBounds(78, 11, 90, 30);
		getContentPane().add(lblrnAd);

		JLabel lblNewLabel_1 = new JLabel("Ürün");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(78, 61, 90, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Barkodu");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(78, 112, 112, 30);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblTelefonNo = new JLabel("Alım Miktarı");
		lblTelefonNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefonNo.setBounds(78, 162, 112, 30);
		getContentPane().add(lblTelefonNo);

		JLabel lblNewLabel_1_2_3 = new JLabel("Fiyatı");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(78, 212, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);

		unit = new JTextField();
		unit.setEditable(false);
		unit.setColumns(10);
		unit.setBounds(482, 162, 90, 30);
		getContentPane().add(unit);

		barcode = new JTextField();
		barcode.setEditable(false);
		barcode.setColumns(10);
		barcode.setBounds(232, 112, 240, 30);
		getContentPane().add(barcode);

		addingButton = new JButton("Ekle");
		addingButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addingButton.setBounds(348, 268, 100, 30);
		getContentPane().add(addingButton);

		category = new JComboBox();
		category.setModel(new DefaultComboBoxModel(new String[] {"", "Süt Ürünleri ", "Katkı Maddeleri"}));
		category.setFont(new Font("Tahoma", Font.BOLD, 11));
		category.setBounds(232, 11, 240, 30);
		getContentPane().add(category);

		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(232, 162, 240, 30);
		getContentPane().add(amount);

		name = new JComboBox();
		name.setFont(new Font("Tahoma", Font.BOLD, 11));
		name.setBounds(232, 61, 240, 30);
		getContentPane().add(name);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(232, 212, 240, 30);
		getContentPane().add(price);

	}
}
