import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginGui extends JFrame{
	private JTextField txtID;
	private JPasswordField txtPass;
	private JLabel lblUsername, lblPass, lblWelcome;
	private JButton btnLogin, btnClear;
	private Font font;
	private DataAccess da;
	public static String typeLogIn, doctorIdStr;
	private LoginGui thisVbOne = this;
	
	public LoginGui(){
		//super("Login");
		this.setLocation(250, 350);
		this.setSize(600, 600);
		//this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.initComponents();
		this.da = new DataAccess();
	}
	
	private void initComponents(){
		this.lblWelcome = new JLabel("Login Frame");
		this.lblWelcome.setBounds(230, 20, 80, 30);
		this.add(this.lblWelcome);
		
		this.lblUsername = new JLabel("User Name");
		this.lblUsername.setBounds(180, 80, 80, 30);
		this.add(this.lblUsername);
		
		this.lblPass = new JLabel("Password");
		this.lblPass.setBounds(180, 140, 80, 30);
		this.add(lblPass);
		
		this.txtID = new JTextField("makeChange");
		this.txtID.setBounds(280, 80, 150, 30);
		this.add(this.txtID);
		
		this.txtPass = new JPasswordField("123");
		this.txtPass.setBounds(280, 140, 150, 30);
		this.add(this.txtPass);
		
		this.btnLogin = new JButton("Login");
		this.btnLogin.setBounds(180, 220, 100, 30);
		this.btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				boolean b = da.login(txtID.getText(), txtPass.getText());

				/*
				if(b == true && typeLogIn.equals("receptionist")) {
					// typeLogIn = "GO";
					// b == true && typeLogIn.equals("receptionist")
					System.out.println(typeLogIn);
					setVisible(false);
					// Home h = new Home();
					// h.setVisible(true);
					// && typeLogIn.equals("admin")
				}
				*/

				if(b == true && typeLogIn.equals("receptionist")) {
					setVisible(false);
					// ReceptionistsHome rh = new ReceptionistsHome();
					ReceptionistsHome rh = new ReceptionistsHome(thisVbOne);
					rh.setVisible(true);
				}

				else if(b == true && typeLogIn.equals("admin")) {
					// System.out.println(typeLogIn);
					setVisible(false);
					AdminHome ah = new AdminHome();
					ah.setVisible(true);
				}
				else if(b == true && typeLogIn.equals("doctor")) {
					// System.out.println(typeLogIn);
					setVisible(false);
					DoctorsHome dh = new DoctorsHome(doctorIdStr);
					dh.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		add(btnLogin);
		
		this.btnClear = new JButton("Clear");
		this.btnClear.setBounds(300, 220, 100, 30);
		this.btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtPass.setText("");				
			}
		});
		add(this.btnClear);
	}
}
