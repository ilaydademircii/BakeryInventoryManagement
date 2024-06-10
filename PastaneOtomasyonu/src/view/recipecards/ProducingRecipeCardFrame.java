package view.recipecards;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProducingRecipeCardFrame extends JInternalFrame {
	public JTextField unit;
	public JTextField barcode;
	public JTextField amount;
	public JComboBox name;
	public JButton addingButton;

	public ProducingRecipeCardFrame() {
		setTitle("Üretim");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 577, 322);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Ürün");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(39, 45, 90, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Barkodu");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(39, 96, 112, 30);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblSatMiktar = new JLabel("Üretim Miktarı ");
		lblSatMiktar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSatMiktar.setBounds(39, 146, 112, 30);
		getContentPane().add(lblSatMiktar);

		unit = new JTextField();
		unit.setEditable(false);
		unit.setColumns(10);
		unit.setBounds(443, 146, 90, 30);
		getContentPane().add(unit);

		barcode = new JTextField();
		barcode.setEditable(false);
		barcode.setColumns(10);
		barcode.setBounds(193, 96, 240, 30);
		getContentPane().add(barcode);

		addingButton = new JButton("Ekle");

		addingButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addingButton.setBounds(309, 203, 100, 30);
		getContentPane().add(addingButton);

		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(193, 146, 240, 30);
		getContentPane().add(amount);

		name = new JComboBox();
		name.setFont(new Font("Tahoma", Font.BOLD, 11));
		name.setBounds(193, 45, 240, 30);
		getContentPane().add(name);

	}
}
