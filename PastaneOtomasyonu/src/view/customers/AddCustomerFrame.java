package view.customers;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCustomerFrame extends JInternalFrame {
	private JTextField cafeName;
	public JTextField taxNumber;
	public JTextField phoneNumber;
	public JTextField taxAdministration;
	public JTextArea explanation;
	public JFormattedTextField dateArea;
	public JButton addingButton;
	public JTextArea address;

	public AddCustomerFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 714, 665);
		getContentPane().setLayout(null);

		cafeName = new JTextField();
		cafeName.setColumns(10);
		cafeName.setBounds(207, 29, 240, 30);
		getContentPane().add(cafeName);

		JLabel label = new JLabel("Kafe Adı");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(53, 29, 90, 30);
		getContentPane().add(label);

		taxNumber = new JTextField();
		taxNumber.setColumns(10);
		taxNumber.setBounds(207, 79, 240, 30);
		getContentPane().add(taxNumber);

		JLabel lblNewLabel_1 = new JLabel("Vergi No");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(53, 79, 90, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Vergi Dairesi");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(53, 130, 112, 30);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblTelefonNo = new JLabel("Telefon No");
		lblTelefonNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefonNo.setBounds(53, 180, 112, 30);
		getContentPane().add(lblTelefonNo);

		JLabel lblNewLabel_1_2_3 = new JLabel("Açıklama");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(53, 380, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);

		phoneNumber = new JTextField();
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(207, 180, 240, 30);
		getContentPane().add(phoneNumber);

		explanation = new JTextArea();
		explanation.setBounds(207, 380, 240, 120);
		getContentPane().add(explanation);

		dateArea = new JFormattedTextField();
		dateArea.setEnabled(false);
		dateArea.setBounds(207, 522, 240, 30);
		getContentPane().add(dateArea);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Eklenme Zamanı");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_3_1.setBounds(53, 521, 144, 30);
		getContentPane().add(lblNewLabel_1_2_3_1);

		taxAdministration = new JTextField();
		taxAdministration.setColumns(10);
		taxAdministration.setBounds(207, 130, 240, 30);
		getContentPane().add(taxAdministration);

		JLabel lblAddress = new JLabel("Adres");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(53, 230, 112, 30);
		getContentPane().add(lblAddress);

		addingButton = new JButton("Ekle");

		
		addingButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addingButton.setBounds(347, 571, 100, 30);
		getContentPane().add(addingButton);

		address = new JTextArea();
		address.setBounds(207, 230, 240, 120);
		getContentPane().add(address);

	}
}
