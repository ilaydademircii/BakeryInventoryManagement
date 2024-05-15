package view.payments;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReceivingPaymentFrame extends JInternalFrame {
	public JTextField remainingPaymentAmount;
	public JTextField receivedPayment;
	public JButton getPaymentsButton;
	public JButton searchButton;
	public JComboBox cafeName;

	// private static final long serialVersionUID = 1L;

	public ReceivingPaymentFrame() {
		setTitle("Ödeme Alma");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 583, 444);
		getContentPane().setLayout(null);

		JLabel lblVergiNumaras = new JLabel("Kafe Adı :");
		lblVergiNumaras.setHorizontalAlignment(SwingConstants.LEFT);
		lblVergiNumaras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVergiNumaras.setBounds(63, 54, 122, 30);
		getContentPane().add(lblVergiNumaras);

		remainingPaymentAmount = new JTextField();
		remainingPaymentAmount.setEditable(false);
		remainingPaymentAmount.setColumns(10);
		remainingPaymentAmount.setBounds(217, 106, 240, 30);
		getContentPane().add(remainingPaymentAmount);

		JLabel lblKalandeme_1 = new JLabel("Kalan Ödeme :");
		lblKalandeme_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblKalandeme_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKalandeme_1.setBounds(63, 106, 109, 30);
		getContentPane().add(lblKalandeme_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(51, 196, 473, 2);
		getContentPane().add(separator);

		JLabel receivingPayment = new JLabel("Ödeme Alış ");
		receivingPayment.setFont(new Font("Tahoma", Font.BOLD, 15));
		receivingPayment.setBounds(63, 208, 109, 22);
		getContentPane().add(receivingPayment);

		receivedPayment = new JTextField();
		receivedPayment.setColumns(10);
		receivedPayment.setBounds(217, 270, 240, 30);
		getContentPane().add(receivedPayment);

		JLabel lblAlnandeme = new JLabel("Alınan Ödeme Miktarı :");
		lblAlnandeme.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlnandeme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlnandeme.setBounds(63, 268, 154, 30);
		getContentPane().add(lblAlnandeme);

		getPaymentsButton = new JButton("Ödeme al");

		getPaymentsButton.setBounds(362, 326, 89, 23);
		getContentPane().add(getPaymentsButton);

		searchButton = new JButton("");

		searchButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\icons8-search-20.png"));
		searchButton.setBounds(399, 147, 58, 26);
		getContentPane().add(searchButton);
		
		
		
		cafeName = new JComboBox();
		cafeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		cafeName.setBounds(217, 56, 240, 30);
		getContentPane().add(cafeName);

	}
}
