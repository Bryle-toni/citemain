package citemain;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class citesignin extends JFrame implements ActionListener {

    private Connection conn;
    private JLabel lblStud, lblFirst, lblLast, lblMiddle,
            lblNumber, lblCourse, lblYear, lblAddress, lblPosition, lblOrg;
    
    private JTextField tfStud, tfFirst, tfLast, tfMiddle, tfNumber, tfCourse, tfYear, tfAddress, tfPosition, tfOrg;
    
    private JComboBox<String> cbMonth, cbDay, cbYear;
    
    private JButton btnSignup, btnback, btnViewing;

    public citesignin() {
        setTitle("Register");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        Birthdate();
        createFormFields();
        RectanglesAndLabels();
        background();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cite", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);
    }


    public void background() {
        JLabel backgroundImage = new JLabel();
        backgroundImage.setSize(1200, 800);
        backgroundImage.setBackground(new Color(135, 206, 235));
        backgroundImage.setOpaque(true);
        add(backgroundImage);
    }

    public void createFormFields() {
        
        btnSignup = new JButton("Register");
        btnSignup.setBounds(650, 670, 100, 30);
        btnSignup.setBackground(new Color(70, 130, 180));
        btnSignup.setForeground(Color.WHITE);
        btnSignup.setFont(new Font("Arial", Font.BOLD, 15));
        btnSignup.addActionListener(this);
        add(btnSignup);
        
        btnback = new JButton("Back ");
        btnback.setBounds(430,670,100,30);
        btnback.setBackground(new Color(70, 130, 180));
        btnback.setForeground(Color.WHITE);
        btnback.setFont(new Font("Arial", Font.BOLD, 15));
        btnback.addActionListener(this); 
        add(btnback);
        
        btnViewing = new JButton("View");
        btnViewing.setBounds(850,670,100,30);
        btnViewing.setBackground(new Color(70, 130, 180));
        btnViewing.setForeground(Color.WHITE);
        btnViewing.setFont(new Font("Arial", Font.BOLD, 15));
        btnViewing.addActionListener(this);
        add(btnViewing);
        
        lblStud = new JLabel("Student Number:");
        lblStud.setBounds(230, 260, 120, 40);
        lblStud.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblStud);

        tfStud = new JTextField();
        tfStud.setBounds(230, 290, 300, 30);
        tfStud.setHorizontalAlignment(JTextField.CENTER);
        tfStud.setBackground(Color.WHITE);
        add(tfStud);


        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(650, 260, 120, 40);
        lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(650, 290, 300, 30);
        tfAddress.setHorizontalAlignment(JTextField.CENTER);
        tfAddress.setBackground(Color.WHITE);
        add(tfAddress);
        
        //
        lblLast = new JLabel("Last Name:");
        lblLast.setBounds(230, 340, 120, 40);
        lblLast.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblLast);

        tfLast = new JTextField();
        tfLast.setBounds(230, 370, 300, 30);
        tfLast.setHorizontalAlignment(JTextField.CENTER);
        tfLast.setBackground(Color.WHITE);
        add(tfLast);
        //
        lblFirst = new JLabel("First Name:");
        lblFirst.setBounds(230, 420, 120, 40);
        lblFirst.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblFirst);

        tfFirst = new JTextField();
        tfFirst.setBounds(230, 450, 300, 30);
        tfFirst.setHorizontalAlignment(JTextField.CENTER);
        tfFirst.setBackground(Color.WHITE);
        add(tfFirst);
        
        lblCourse = new JLabel("Course:");
        lblCourse.setBounds(650, 420, 120, 40);
        lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblCourse);
        tfCourse = new JTextField();
        tfCourse.setBounds(650, 450, 145, 30);
        tfCourse.setHorizontalAlignment(JTextField.CENTER);
        tfCourse.setBackground(Color.WHITE);
        add(tfCourse);
        
        lblYear = new JLabel("Year Level:");
        lblYear.setBounds(805,420,120,40);
        lblYear.setFont(new Font("Times New Roman", Font.BOLD,12));
        add(lblYear);
        tfYear = new JTextField();
        tfYear.setBounds(805,450,145,30);
        tfYear.setHorizontalAlignment(JTextField.CENTER);
        tfYear.setBackground(Color.WHITE);
        add(tfYear);
        
        //
        
        lblMiddle = new JLabel("Middle Name:");
        lblMiddle.setBounds(230, 500, 120, 40);
        lblMiddle.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblMiddle);

        tfMiddle = new JTextField();
        tfMiddle.setBounds(230, 530, 300, 30);
        tfMiddle.setHorizontalAlignment(JTextField.CENTER);
        tfMiddle.setBackground(Color.WHITE);
        add(tfMiddle);
        
        lblPosition = new JLabel("Position:");
        lblPosition.setBounds(650, 500, 120, 40);
        lblPosition.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblPosition);
        tfPosition = new JTextField();
        tfPosition.setBounds(650, 530, 300, 30);
        tfPosition.setHorizontalAlignment(JTextField.CENTER);
        tfPosition.setBackground(Color.WHITE);
        add(tfPosition);
        
        //
        
        lblNumber = new JLabel("Contact Number:");
        lblNumber.setBounds(230, 580, 120, 40);
        lblNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(230, 610, 300, 30);
        tfNumber.setHorizontalAlignment(JTextField.CENTER);
        tfNumber.setBackground(Color.WHITE);
        add(tfNumber);
        
        lblOrg = new JLabel("Organization:");
        lblOrg.setBounds(650, 580, 120, 40);
        lblOrg.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblOrg);
        tfOrg = new JTextField();
        tfOrg.setBounds(650, 610, 300, 30);
        tfOrg.setHorizontalAlignment(JTextField.CENTER);
        tfOrg.setBackground(Color.WHITE);
        add(tfOrg);
    }

    public void Birthdate() {
        JLabel lblBirthdate = new JLabel("Birthdate:");
        lblBirthdate.setBounds(650, 340, 150, 30);
        add(lblBirthdate);

        cbMonth = new JComboBox<>(new String[]{"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
        cbMonth.setBounds(650, 370, 100, 30);
        add(cbMonth);

        cbDay = new JComboBox<>(new String[]{"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        cbDay.setBounds(770, 370, 70, 30);
        add(cbDay);

        cbYear = new JComboBox<>(new String[]{"", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995",
                "1994", "1993", "1992", "1991", "1990"});
        cbYear.setBounds(850, 370, 100, 30);
        add(cbYear);
    }


    public void RectanglesAndLabels() {

        JLabel label = new JLabel("WELCOME TO THE IBITS WEBSITE!");
        label.setBounds(450, 130, 500, 100);
        label.setFont(new Font("Impact", Font.PLAIN, 24));
        label.setForeground(Color.WHITE);
        add(label);

        JPanel rectangle2 = new JPanel();
        rectangle2.setBounds(130, 130, 950, 100);
        rectangle2.setBackground(new Color(128, 0, 0));
        add(rectangle2);

        JPanel rectangle = new JPanel();
        rectangle.setBounds(100, 120, 1000, 600);
        rectangle.setBackground(new Color(224, 224, 224));
        add(rectangle);

        JPanel smallrectangle = new JPanel();
        smallrectangle.setBounds(0, 0, 1200, 80);
        smallrectangle.setBackground(new Color(128, 0, 0));
        smallrectangle.setLayout(null);
        add(smallrectangle);

        ImageIcon logoImage = new ImageIcon("C:\\Users\\ADMIN\\Documents\\BRYLE 2024 2nd sem\\citemain\\src\\images\\ibits.png");
        Image scaledLogoImage = logoImage.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(10, 10, 60, 60);
        smallrectangle.add(logoLabel);

        ImageIcon pupImage = new ImageIcon("C:\\Users\\ADMIN\\Documents\\BRYLE 2024 2nd sem\\citemain\\src\\images\\PUP.png");
        Image scaledPupImage = pupImage.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledPupIcon = new ImageIcon(scaledPupImage);
        JLabel pupLabel = new JLabel(scaledPupIcon);
        pupLabel.setBounds(80, 10, 60, 60);
        smallrectangle.add(pupLabel);

        JLabel lblPUP = new JLabel("IBITS PUPBC - Institute of Bachelors in Information Technology Studies");
        lblPUP.setBounds(150, 10, 1000, 60);
        lblPUP.setFont(new Font("Arial", Font.BOLD, 24));
        lblPUP.setForeground(Color.WHITE);
        smallrectangle.add(lblPUP);

        JPanel smallrectangle2 = new JPanel();
        smallrectangle2.setBounds(0, 680, 1200, 80);
        smallrectangle2.setBackground(Color.LIGHT_GRAY);
        add(smallrectangle2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignup) {
            registerUser();
        } else if (e.getSource() == btnback) {
            new citelogsign();
            dispose();
        } else if (e.getSource() == btnViewing) {
            dispose();
            Viewing view = new Viewing();
            view.setVisible(true);
        }
    }
    
    private void registerUser() {
        String noID = tfStud.getText().trim();
        String noLN = tfLast.getText().trim();
        String noFN = tfFirst.getText().trim();
        String noMN = tfMiddle.getText().trim();
        String noC = tfCourse.getText().trim();
        String noYL = tfYear.getText().trim();
        String noA = tfAddress.getText().trim();
        String noCN = tfNumber.getText().trim();
        String noP = tfPosition.getText().trim();
        String noAf = tfOrg.getText().trim();


        if (noID.isEmpty() || noLN.isEmpty() || noFN.isEmpty() || noC.isEmpty() || noMN.isEmpty() || noYL.isEmpty()
                || noA.isEmpty() || noCN.isEmpty() || noP.isEmpty() || noAf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
 
            String birthdate = "";
            if (cbYear.getSelectedIndex() != 0 && cbMonth.getSelectedIndex() != 0 && cbDay.getSelectedIndex() != 0) {
                birthdate = cbYear.getSelectedItem().toString() + "-" +
                        String.format("%02d", cbMonth.getSelectedIndex()) + "-" +
                        String.format("%02d", cbDay.getSelectedIndex());
            }

  
            String query = "INSERT INTO tbl_cite (stud_ID, stud_LName, stud_FName, stud_MName, course, yearLevel, address, contactNum, BDAY, Position, Organization)" +
                            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement PS = conn.prepareStatement(query);

            PS.setString(1, noID);
            PS.setString(2, noLN);
            PS.setString(3, noFN);
            PS.setString(4, noMN);
            PS.setString(5, noC);
            PS.setString(6, noYL);
            PS.setString(7, noA);
            PS.setString(8, noCN);
            PS.setString(9, birthdate);
            PS.setString(10, noP);
            PS.setString(11, noAf);

            PS.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registered Successfully");

            dispose();
            Viewing view = new Viewing();
            view.setVisible(true);
            
        } catch (SQLException ex) {
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Error registering data. See console for details.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conn != null) {
                    conn.close(); 
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        tfStud.setText("");
        tfLast.setText("");
        tfFirst.setText("");
        tfMiddle.setText("");
        tfCourse.setText("");
        tfYear.setText("");
        tfAddress.setText("");
        tfNumber.setText("");
        tfPosition.setText("");
        tfOrg.setText("");

        cbYear.setSelectedIndex(0);
        cbMonth.setSelectedIndex(0);
        cbDay.setSelectedIndex(0);
    }
}
