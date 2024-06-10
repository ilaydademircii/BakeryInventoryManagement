package view.materials;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddMaterialTypeFrame extends JInternalFrame {
	public JTextField name;
	public JTextField barcode;
	public JComboBox category;
	public JComboBox unit;
	public JButton addingButton;

	public AddMaterialTypeFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setFrameIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\foto\\cancan\\Pink Minimalist Cake Shop & Café Logo.png"));
		setTitle("Malzeme Türü Ekleme");
		setBounds(100, 100, 555, 303);
		getContentPane().setLayout(null);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(203, 11, 240, 30);
		getContentPane().add(name);

		JLabel textfield = new JLabel("Ürün Adı");
		textfield.setHorizontalAlignment(SwingConstants.LEFT);
		textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textfield.setBounds(49, 11, 90, 30);
		getContentPane().add(textfield);

		JLabel lblNewLabel_1 = new JLabel("Kategori");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(49, 61, 90, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel text = new JLabel("Barkodu");
		text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text.setBounds(49, 112, 112, 30);
		getContentPane().add(text);

		JLabel lblAlm = new JLabel("Birimi");
		lblAlm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlm.setBounds(49, 162, 112, 30);
		getContentPane().add(lblAlm);

		barcode = new JTextField();
		barcode.setColumns(10);
		barcode.setBounds(203, 112, 240, 30);
		getContentPane().add(barcode);

		addingButton = new JButton("Ekle");

		addingButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addingButton.setBounds(300, 203, 100, 30);
		getContentPane().add(addingButton);

		category = new JComboBox();
		category.setModel(new DefaultComboBoxModel(new String[] {"Süt Ürünleri ", "Katkı Maddeleri"}));
		category.setBounds(203, 61, 240, 30);
		getContentPane().add(category);

		unit = new JComboBox();
		unit.setModel(new DefaultComboBoxModel(new String[] {"Kg", "Lt", "Paket", "Koli", "Adet"}));
		unit.setBounds(203, 162, 240, 30);
		getContentPane().add(unit);

	}
}
