package view.customers;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeleteCustomerFrame extends JInternalFrame {
	public JTextField taxNo;
	public JTextField phoneNumber;
	public JTextField taxAdministration;
	public JComboBox cafeName;
	public JFormattedTextField dateArea;
	public JTextArea address;
	public JTextArea explanation;
	public JButton deletingButton;	
//	private static final long serialVersionUID = 1L;


	public DeleteCustomerFrame() {
		setBounds(100, 100, 552, 675);
		setTitle("Müşteri Silme");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Kafe Adı");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(47, 29, 90, 30);
		getContentPane().add(label);
		
		taxNo = new JTextField();
		taxNo.setEditable(false);
		taxNo.setColumns(10);
		taxNo.setBounds(201, 79, 240, 30);
		getContentPane().add(taxNo);
		
		JLabel lblNewLabel_1 = new JLabel("Vergi No");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(47, 79, 90, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Vergi Dairesi");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(47, 130, 112, 30);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblTelefonNo = new JLabel("Telefon No");
		lblTelefonNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefonNo.setBounds(47, 180, 112, 30);
		getContentPane().add(lblTelefonNo);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Açıklama");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(47, 380, 90, 30);
		getContentPane().add(lblNewLabel_1_2_3);
		
		phoneNumber = new JTextField();
		phoneNumber.setEditable(false);
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(201, 180, 240, 30);
		getContentPane().add(phoneNumber);
		
		 explanation = new JTextArea();
		explanation.setBounds(201, 380, 240, 120);
		getContentPane().add(explanation);
		
		 dateArea = new JFormattedTextField();
		dateArea.setEditable(false);
		dateArea.setEnabled(false);
		dateArea.setBounds(201, 522, 240, 30);
		getContentPane().add(dateArea);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Eklenme Zamanı");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_3_1.setBounds(47, 521, 144, 30);
		getContentPane().add(lblNewLabel_1_2_3_1);
		
		taxAdministration = new JTextField();
		taxAdministration.setEditable(false);
		taxAdministration.setColumns(10);
		taxAdministration.setBounds(201, 130, 240, 30);
		getContentPane().add(taxAdministration);
		
		JLabel lblAddress = new JLabel("Adres");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(47, 230, 112, 30);
		getContentPane().add(lblAddress);
		
		 deletingButton = new JButton("Sil");
		deletingButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deletingButton.setBounds(341, 571, 100, 30);
		getContentPane().add(deletingButton);
		
		 address = new JTextArea();
		address.setEditable(false);
		address.setBounds(201, 230, 240, 120);
		getContentPane().add(address);
		
		 cafeName = new JComboBox();
		cafeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		cafeName.setBounds(201, 29, 240, 30);
		getContentPane().add(cafeName);
		

	}

}
