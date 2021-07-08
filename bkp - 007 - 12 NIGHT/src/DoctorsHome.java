

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.*;



public class DoctorsHome extends JFrame {

    private JPanel upperPanel, lowerPanel, rightPanel, bottomPanel;

    private JLabel lblSearch;
    private static JTextField txtSearch;
    private JButton btnSearch, btnAdd, btnEdit, btnDelete, btnBack, btOne, backToHome, addNewPatient;
    private JLabel lblOne, lblTwo, lblThree, lblFour;
    private JTextField tfOne, tfTwo, tfThree;
    private JComboBox userType;
    private String docId;

    private static JTable tblUsers;

    public DoctorsHome(String vbOne) {
        // public ReceptionistsHome() {
        super("Doctor's Home");
        this.docId = vbOne;
        this.setLocation(150, 150);
        this.setSize(550, 600);
        //this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        lowerPanel = new JPanel(null);
        this.lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 1), "Patient List"));
        this.lowerPanel.setBounds(5, 50, 460, 360);
        add(this.lowerPanel);

        this.AddLowerComponent();

        /*
        upperPanel = new JPanel(new FlowLayout());
        this.upperPanel.setBorder(new LineBorder(Color.black, 1));
        this.upperPanel.setBounds(120, 5, 270, 40);
        add(this.upperPanel);

        // LogOut button

        bottomPanel = new JPanel(new FlowLayout());
        this.bottomPanel.setBorder(new LineBorder(Color.black, 1));
        this.bottomPanel.setBounds(10, 480, 450, 40);
        add(this.bottomPanel);

        lowerPanel = new JPanel(null);
        this.lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 1), "Data"));
        this.lowerPanel.setBounds(5, 50, 460, 360);
        add(this.lowerPanel);

		/*
		rightPanel = new JPanel(new GridBagLayout());
		rightPanel.setSize(250, 350);
		rightPanel.setLocation(500, 30);
		// rightPanel.setLayout(new GridBagLayout());
		add(this.rightPanel);

		 */

        /*
        this.AddUpperComponent();
        this.AddLowerComponent();
        // this.AddRightComponent();
        this.AddBottomComponent();
        */

    }

    /*
    private void AddUpperComponent() {

        lblSearch = new JLabel("Search");
        this.upperPanel.add(lblSearch);

        txtSearch = new JTextField(10);
        this.upperPanel.add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                populateTable();
            }
        });
        this.upperPanel.add(btnSearch);

		/*
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Add a = new Add();
				a.setVisible(true);

			}
		});
		this.upperPanel.add(btnAdd);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int row = tblUsers.getSelectedRow();

				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "Please Select A Row First");
					return;
				}

				int id = (int)tblUsers.getValueAt(row, 0);
				JOptionPane.showMessageDialog(null, id);
				txtSearch.setText((String)tblUsers.getValueAt(row, 1));
			}
		});
		this.upperPanel.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		this.upperPanel.add(btnDelete);
		 */
    /*

    }

    */

    /*
    private void AddLowerComponent() {

        tblUsers = new JTable();
        tblUsers.setBackground(Color.white);

        JScrollPane sp = new JScrollPane();
        sp.setBounds(5, 25, 450, 320);
        this.lowerPanel.add(sp);
        sp.setViewportView(tblUsers);

        this.populateTable();
    }

    public static void populateTable() {

        ReceptionistsTableModel model = new ReceptionistsTableModel(txtSearch.getText());
        tblUsers.setModel(model);
    }

     */

//	took right components form here

    /*
    public void AddBottomComponent() {

        backToHome = new JButton("Log out");
        backToHome.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                dispose();
                LoginFrame.setVisible(true);

            }
        });
        this.bottomPanel.add(backToHome);


        addNewPatient = new JButton("Register Patient");
        addNewPatient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                int row = tblUsers.getSelectedRow();
                int id = (int) tblUsers.getValueAt(row, 0);
                // System.out.println(id);

                NewPatientInfo np = new NewPatientInfo(id);
                np.setVisible(true);
            }
        });
        this.bottomPanel.add(addNewPatient);
    }
    */

    private void AddLowerComponent() {

        tblUsers = new JTable();
        tblUsers.setBackground(Color.white);

        JScrollPane sp = new JScrollPane();
        sp.setBounds(5, 25, 450, 320);
        this.lowerPanel.add(sp);
        sp.setViewportView(tblUsers);

        this.populateTable();
    }

    // the method was static, populateTable()

    public void populateTable() {

        PatientsTableModel model = new PatientsTableModel(docId);
        tblUsers.setModel(model);
    }



}








