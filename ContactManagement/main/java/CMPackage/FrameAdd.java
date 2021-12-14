package CMPackage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.Toolkit;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameAdd extends JFrame {
	private JPanel contentPanel;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField PhoneNumber;
	private Contact contact;

	public FrameAdd() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameAdd.class.getResource("/images/main-icon.png")));
		setTitle("Enter Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel headerLabel = new JLabel("Note: Enter phone number of 10 digits only. Only numbers are allowed in phone number.");
		headerLabel.setForeground(Color.RED);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		headerLabel.setBounds(12, 95, 928, 39);
		contentPanel.add(headerLabel);

		JLabel firstname = new JLabel("First Name");
		firstname.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		firstname.setHorizontalAlignment(SwingConstants.RIGHT);
		firstname.setBounds(221, 165, 144, 34);
		contentPanel.add(firstname);

		FirstName = new JTextField();
		FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FirstName.setBounds(387, 164, 265, 37);
		contentPanel.add(FirstName);
		FirstName.setColumns(10);

		JLabel lastname = new JLabel("Last Name");
		lastname.setHorizontalAlignment(SwingConstants.RIGHT);
		lastname.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lastname.setBounds(221, 215, 144, 34);
		contentPanel.add(lastname);

		LastName = new JTextField();
		LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LastName.setBounds(387, 214, 265, 37);
		contentPanel.add(LastName);
		LastName.setColumns(10);

		JLabel phonenumber = new JLabel("Phone Number");
		phonenumber.setHorizontalAlignment(SwingConstants.RIGHT);
		phonenumber.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		phonenumber.setBounds(221, 264, 144, 37);
		contentPanel.add(phonenumber);

		PhoneNumber = new JTextField();
		PhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PhoneNumber.setBounds(387, 264, 265, 37);
		contentPanel.add(PhoneNumber);
		PhoneNumber.setColumns(10);

		JButton OKButton = new JButton(" SAVE");
		OKButton.setIcon(new ImageIcon(FrameAdd.class.getResource("/images/icon-5.png")));
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = FirstName.getText();
				String lastName = LastName.getText();
				String phoneNumber = PhoneNumber.getText();
				contact = new Contact(firstName, lastName, phoneNumber);
				
				if(Main.contactManager.isPresent(contact))
					JOptionPane.showMessageDialog(null, "Contact Already Exists");
				else if(!ContactManager.isFirstNameValid(contact))
					JOptionPane.showMessageDialog(null, "First Name is Missing");
				else if(!ContactManager.isLastNameValid(contact))
					JOptionPane.showMessageDialog(null, "Last Name is Missing");
				else if(!ContactManager.isPhoneValid(contact))
					JOptionPane.showMessageDialog(null, "Phone Number is not valid");
				else
				{
					Main.contactManager.addContact(firstName, lastName, phoneNumber);
					JOptionPane.showMessageDialog(null, "Contact Added Successfully");
				}
				FirstName.setText(null);
				LastName.setText(null);
				PhoneNumber.setText(null);
			}
		});
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OKButton.setBounds(397, 376, 111, 39);
		contentPanel.add(OKButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameAdd.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(531, 376, 111, 39);
		contentPanel.add(backButton);
		setLocationRelativeTo(null);

	}
}
