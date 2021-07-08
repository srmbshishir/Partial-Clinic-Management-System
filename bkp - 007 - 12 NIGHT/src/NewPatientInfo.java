import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.*;

public class NewPatientInfo extends JFrame {
    private JPanel panelOne;
    private JComboBox patientGender;
    private JLabel lblOne, lblTwo, lblThree, lblFour;
    private JTextField tfOne, tfTwo, tfThree;
    private JButton btOne;
    private int pKey;

    public NewPatientInfo(int primaryKey) {
        super("New Patient");
        pKey = primaryKey;
        this.setLocation(1000, 150);
        this.setSize(400, 400);
        // this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panelOne = new JPanel(new GridBagLayout());
        panelOne.setSize(250, 350);
        panelOne.setLocation(70, -60);
        // rightPanel.setLayout(new GridBagLayout());
        add(this.panelOne);

        this.AddRightComponent();
    }


    public void AddRightComponent() {


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        this.add(panelOne, gbc);
        gbc.gridwidth = 1;

        lblOne = new JLabel("Patient Name");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        panelOne.add(lblOne, gbc);
        // this.lowerPanel.add(lblOne);

        tfOne = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelOne.add(tfOne, gbc);
        // that code,
        // tfOne.requestFocusInWindow();

        lblTwo = new JLabel("Age");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        panelOne.add(lblTwo, gbc);
        // this.lowerPanel.add(lblTwo);

        tfTwo = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelOne.add(tfTwo, gbc);

        lblThree = new JLabel("Phone No");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        panelOne.add(lblThree, gbc);
        // this.lowerPanel.add(lblTwo);

        tfThree = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelOne.add(tfThree, gbc);

        lblFour = new JLabel("Gender");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 0, 0);
        panelOne.add(lblFour, gbc);


        String stPatientGender[] = {"empty", "Male", "Female"};
        patientGender = new JComboBox(stPatientGender);
        // cbUserType.setBounds(50, 50 , 90, 20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 5, 5, 5);
        // this.add(userType);
        panelOne.add(patientGender, gbc);


        btOne = new JButton("Insert data");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelOne.add(btOne, gbc);


        btOne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String stPatientGenderData = (String) patientGender.getItemAt(patientGender.getSelectedIndex());

                String sql = "INSERT INTO `doctor#"+ pKey +"` VALUES ('" + tfOne.getText() + "','" + tfTwo.getText() + "','" + tfThree.getText() + "','" + stPatientGenderData + "')";
                // specialtyType
                // cb.getItemAt(cb.getSelectedIndex())
                // String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";

                DataAccess d = new DataAccess();
                d.insert(sql);

                // System.out.println(stSpecialtyData);

                dispose();

            }


        });

        // maybe other class error too
        // add(btOne);


    }


}


