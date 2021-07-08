import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class Add extends JFrame{

	JButton btOne;
	JComboBox userType, specialtyType;
	private JPanel upperPanel;
	private JPanel lowerPanel;
	private JLabel lblOne, lblTwo, lblThree, lblFour;
	private JTextField tfOne,tfTwo,tfThree,tfFour;


	public Add(){
		super("Enter Employee Info");
		this.setLocation(450, 550);
		this.setSize(550, 250);
		// this.setVisible(true);
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.gray);
		// this.setLayout(new FlowLayout());
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/*
		super("Home");
		this.setLocation(50, 50);
		this.setSize(600, 600);
		//this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		upperPanel = new JPanel(new FlowLayout());
		this.upperPanel.setBorder(new LineBorder(Color.black, 1));
		this.upperPanel.setBounds(5, 5, 570, 40);
		add(this.upperPanel);
		*/

		/*
		upperPanel = new JPanel(new FlowLayout());
		this.upperPanel.setBorder(new LineBorder(Color.black, 1));
		this.upperPanel.setBounds(5, 5, 570, 40);
		add(this.upperPanel);

		 */

		/*
		lowerPanel = new JPanel(new FlowLayout());
		this.lowerPanel.setBorder(new LineBorder(Color.black, 1));
		this.lowerPanel.setBounds(5, 50, 570, 40);
		add(this.lowerPanel);

		 */

		lowerPanel = new JPanel(new GridBagLayout());
		// this.lowerPanel.GridBagConstraints gbc = new GridBagConstraints();
		// this.lowerPanel.setLayout(grid);
		GridBagConstraints gbc = new GridBagConstraints();
		// this.lowerPanel.setLayout(new GridBagLayout());
		// this.lowerPanel.

		//this.lowerPanel.setBorder(new LineBorder(Color.black, 1));
		//this.lowerPanel.setBounds(5, 5, 570, 270);


		/*
		tfOne = new JTextField(10);
		this.lowerPanel.add(tfOne);

		 */

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(5,5,5,5);
		this.add(lowerPanel, gbc);
		gbc.gridwidth = 1;

		lblOne = new JLabel("ID");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblOne, gbc);
		// this.lowerPanel.add(lblOne);

		tfOne = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(tfOne,gbc);
		// that code,
		// tfOne.requestFocusInWindow();

		lblTwo = new JLabel("Username");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblTwo, gbc);
		// this.lowerPanel.add(lblTwo);

		tfTwo = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(tfTwo,gbc);

		lblThree = new JLabel("Passowrd");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblThree, gbc);
		// this.lowerPanel.add(lblTwo);

		tfThree = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(tfThree,gbc);

		lblFour = new JLabel("Designation");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblFour, gbc);

		/*
		userType = new JComboBox();
		DefaultComboBoxModel userModel = new DefaultComboBoxModel();
		userModel.addElement("doctor");
		userModel.addElement("receptionist");
		// userModel.addElement("patient");
		userType.setModel(userModel);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(userType,gbc);
		 */


		String stUserType[]={"empty", "doctor", "receptionist"};
		userType = new JComboBox(stUserType);
		// cbUserType.setBounds(50, 50 , 90, 20);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(5,5,5,5);
		// this.add(userType);
		lowerPanel.add(userType,gbc);


		String specialtySt[]={"empty", "cardiologist", "neurologist"};
		specialtyType = new JComboBox(specialtySt);
		// cbUserType.setBounds(50, 50 , 90, 20);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(5,5,5,5);
		// this.add(userType);
		lowerPanel.add(specialtyType,gbc);



		btOne = new JButton("Insert data");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(btOne, gbc);

		btOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0){
				String stUserTypeData = (String) userType.getItemAt(userType.getSelectedIndex());
				String stSpecialtyData = (String) specialtyType.getItemAt(userType.getSelectedIndex());
				String sql = "INSERT INTO user VALUES ('"+tfOne.getText()+"','"+tfTwo.getText()+"','"+tfThree.getText()+"','"+stUserTypeData+"','"+stSpecialtyData+"')";
				// specialtyType
				// cb.getItemAt(cb.getSelectedIndex())
				// String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";

				DataAccess d = new DataAccess();
				d.insert(sql);

				// System.out.println(stSpecialtyData);

				//d.insert(sql);


				// AdminHome.populateTable();
				// Home.populateTable();

				if(stUserTypeData.equals("doctor")) {
					String sqlLocal = "CREATE TABLE `user`.`doctor#"+tfOne.getText()+"` ( `name` VARCHAR(25) NOT NULL , `age` VARCHAR(5) NOT NULL , " +
										"`contact no` VARCHAR(15) NOT NULL , `gender` VARCHAR(10) NOT NULL , PRIMARY KEY (`name`)) ENGINE = InnoDB;";

					d.newDocDb(sqlLocal);
				}

				if(LoginGui.typeLogIn.equals("admin")) {
					AdminHome.populateTable();
				}
				else if(LoginGui.typeLogIn.equals("receptionist")) {
					ReceptionistsHome.populateTable();

				}

				dispose();
				// why it's here?
				// got it
			}


		});

		add(btOne);



		// add(this.lowerPanel);

		// this.AddUpperComponent();
		// this.AddLowerComponent();

	}

	private void AddUpperComponent() {

		/*
		t1 = new JTextField(10);
		add(t1);
		t2 = new JTextField(10);
		add(t2);
		t3 = new JTextField(10);
		add(t3);

		 */

		/*
		lblOne = new JLabel("ID");
		this.upperPanel.add(lblOne);

		tfOne = new JTextField(10);
		this.upperPanel.add(tfOne);
		 */


		/*
		t4 = new JTextField(10);
		add(t4);
		 */

		/*
		userType = new JComboBox();
		DefaultComboBoxModel userModel = new DefaultComboBoxModel();
		userModel.addElement("doctor");
		userModel.addElement("receptionist");
		// userModel.addElement("patient");
		userType.setModel(userModel);
		 */

		/*
		String userType[]={"doctor", "receptionist"};
		cbUserType = new JComboBox(userType);
		// cbUserType.setBounds(50, 50 , 90, 20);
		this.add(cbUserType);

		b = new JButton("insert");


		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0){
				String cbUserTypeData = (String) userType.getItemAt(userType.getSelectedIndex());
				String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+cbUserTypeData+"')";
				// cb.getItemAt(cb.getSelectedIndex())
				// String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
				DataAccess d = new DataAccess();
				d.insert(sql);
				// AdminHome.populateTable();
				// Home.populateTable();

				if(LoginGui.typeLogIn.equals("admin")) {
					AdminHome.populateTable();
				}
				else if(LoginGui.typeLogIn.equals("receptionist")) {
					Home.populateTable();
				}
			}
		});
		add(b);

		 */

	}

	public void AddLowerComponent() {

	}



}













/*

String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
DataAccess d = new DataAccess();
d.insert(sql);
*/