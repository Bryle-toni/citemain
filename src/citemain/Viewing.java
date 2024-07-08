package citemain;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Viewing extends JFrame implements ActionListener {

    private JLabel lblStud, lblFirst, lblLast, lblMiddle, lblNumber, lblCourse, lblYear, lblAddress, lblPosition, lblOrg, lblSearch;
    private JTextField tfStud, tfFirst, tfLast, tfMiddle, tfNumber, tfCourse, tfYear, tfAddress, tfPosition, tfOrg, tfSearch;
    private JComboBox<String> cbMonth, cbDay, cbYear;
    private JButton btnLogout, btnSearch, btnRegis, btnClear;
    private Connection conn;

    public Viewing() {
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        createFormFields();
        Birthdate();
        RectanglesAndLabels();
        background();
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
        btnLogout = new JButton("Logout");
        btnLogout.setBounds(775, 680, 175, 30);
        btnLogout.setBackground(new Color(70, 130, 180));
        btnLogout.setFont(new Font("Arial", Font.BOLD, 15));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.addActionListener(this);
        add(btnLogout);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(650, 175, 80, 20);
        btnSearch.setBackground(new Color(70, 130, 180));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 10));
        btnSearch.addActionListener(this);
        add(btnSearch);

        btnRegis = new JButton("Register");
        btnRegis.setBounds(760, 175, 80, 20);
        btnRegis.setBackground(new Color(70, 130, 180));
        btnRegis.setForeground(Color.WHITE);
        btnRegis.setFont(new Font("Arial", Font.BOLD, 10));
        btnRegis.addActionListener(this);
        add(btnRegis);

        btnClear = new JButton("Clear");
        btnClear.setBounds(870, 175, 80, 20);
        btnClear.setBackground(new Color(70, 130, 180));
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Arial", Font.BOLD, 10));
        btnClear.addActionListener(this);
        add(btnClear);

        lblSearch = new JLabel("Student No.");
        lblSearch.setBounds(150, 165, 120, 40);
        lblSearch.setForeground(Color.WHITE);
        lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(lblSearch);

        tfSearch = new JTextField();
        tfSearch.setBounds(260, 170, 335, 30);
        add(tfSearch);
        
        //
        lblStud = new JLabel("Student Number:");
        lblStud.setBounds(230, 260, 120, 40);
        lblStud.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblStud);

        tfStud = new JTextField();
        tfStud.setBounds(230, 290, 300, 30);
        tfStud.setHorizontalAlignment(JTextField.CENTER);
        tfStud.setBackground(Color.WHITE);
        tfStud.setEditable(false);
        tfStud.setFocusable(false);
        add(tfStud);

        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(650, 260, 120, 40);
        lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(650, 290, 300, 30);
        tfAddress.setHorizontalAlignment(JTextField.CENTER);
        tfAddress.setBackground(Color.WHITE);
        tfAddress.setEditable(false);
        tfAddress.setFocusable(false);
        add(tfAddress);

        lblLast = new JLabel("Last Name:");
        lblLast.setBounds(230, 340, 120, 40);
        lblLast.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblLast);
        tfLast = new JTextField();
        tfLast.setBounds(230, 370, 300, 30);
        tfLast.setHorizontalAlignment(JTextField.CENTER);
        tfLast.setBackground(Color.WHITE);
        tfLast.setEditable(false);
        tfLast.setFocusable(false);
        add(tfLast);

        lblFirst = new JLabel("First Name:");
        lblFirst.setBounds(230, 420, 120, 40);
        lblFirst.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblFirst);
        tfFirst = new JTextField();
        tfFirst.setBounds(230, 450, 300, 30);
        tfFirst.setHorizontalAlignment(JTextField.CENTER);
        tfFirst.setBackground(Color.WHITE);
        tfFirst.setEditable(false);
        tfFirst.setFocusable(false);
        add(tfFirst);

        lblCourse = new JLabel("Course:");
        lblCourse.setBounds(650, 420, 120, 40);
        lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblCourse);
        tfCourse = new JTextField();
        tfCourse.setBounds(650, 450, 145, 30);
        tfCourse.setHorizontalAlignment(JTextField.CENTER);
        tfCourse.setBackground(Color.WHITE);
        tfCourse.setEditable(false);
        tfCourse.setFocusable(false);
        add(tfCourse);

        lblYear = new JLabel("Year Level:");
        lblYear.setBounds(805, 420, 120, 40);
        lblYear.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblYear);
        tfYear = new JTextField();
        tfYear.setBounds(805, 450, 145, 30);
        tfYear.setHorizontalAlignment(JTextField.CENTER);
        tfYear.setBackground(Color.WHITE);
        tfYear.setEditable(false);
        tfYear.setFocusable(false);
        add(tfYear);

        lblMiddle = new JLabel("Middle Name:");
        lblMiddle.setBounds(230, 500, 120, 40);
        lblMiddle.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblMiddle);
        tfMiddle = new JTextField();
        tfMiddle.setBounds(230, 530, 300, 30);
        tfMiddle.setHorizontalAlignment(JTextField.CENTER);
        tfMiddle.setBackground(Color.WHITE);
        tfMiddle.setEditable(false);
        tfMiddle.setFocusable(false);
        add(tfMiddle);

        lblPosition = new JLabel("Position:");
        lblPosition.setBounds(650, 500, 120, 40);
        lblPosition.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblPosition);
        tfPosition = new JTextField();
        tfPosition.setBounds(650, 530, 300, 30);
        tfPosition.setHorizontalAlignment(JTextField.CENTER);
        tfPosition.setBackground(Color.WHITE);
        tfPosition.setEditable(false);
        tfPosition.setFocusable(false);
        add(tfPosition);

        lblNumber = new JLabel("Contact Number:");
        lblNumber.setBounds(230, 580, 120, 40);
        lblNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblNumber);
        tfNumber = new JTextField();
        tfNumber.setBounds(230, 610, 300, 30);
        tfNumber.setHorizontalAlignment(JTextField.CENTER);
        tfNumber.setBackground(Color.WHITE);
        tfNumber.setEditable(false);
        tfNumber.setFocusable(false);
        add(tfNumber);

        lblOrg = new JLabel("Organization:");
        lblOrg.setBounds(650, 580, 120, 40);
        lblOrg.setFont(new Font("Times New Roman", Font.BOLD, 12));
        add(lblOrg);
        tfOrg = new JTextField();
        tfOrg.setBounds(650, 610, 300, 30);
        tfOrg.setHorizontalAlignment(JTextField.CENTER);
        tfOrg.setBackground(Color.WHITE);
        tfOrg.setEditable(false);
        tfOrg.setFocusable(false);
        add(tfOrg);
        
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cite", "root","");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void Birthdate() {
        JLabel lblBirthdate = new JLabel("Birthdate:");
        lblBirthdate.setBounds(650, 340, 150, 30);
        add(lblBirthdate);

        cbMonth = new JComboBox<>(new String[]{"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
        cbMonth.setBounds(650, 370, 100, 30);
        cbMonth.setEditable(false);
        cbMonth.setFocusable(false);
        add(cbMonth);

        cbDay = new JComboBox<>(new String[]{"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        cbDay.setBounds(770, 370, 70, 30);
        add(cbDay);
        cbDay.setEditable(false);
        cbDay.setFocusable(false);
        
        cbYear = new JComboBox<>(new String[]{"", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995",
                "1994", "1993", "1992", "1991", "1990"});
        cbYear.setBounds(850, 370, 100, 30);
        cbYear.setEditable(false);
        cbYear.setFocusable(false);
        add(cbYear);
    }

    public void RectanglesAndLabels() {
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
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnLogout)
        {
            dispose();
            citelogin login = new citelogin();
        }
        
        else if(e.getSource()==btnClear)
        {
            tfSearch.setText("");
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
        
        else if(e.getSource()==btnSearch)
        {
            Search();
        }
        
        else if(e.getSource()==btnRegis)
        {
            dispose();
            citesignin regis = new citesignin();
            regis.setVisible(true);
        }
    }
    
    private void Search()
    {
        String searchNum = tfSearch.getText();
        if(searchNum.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter a student number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try
        {
            String query = "SELECT * FROM tbl_cite WHERE stud_ID = ?";
            PreparedStatement withdrawPS = conn.prepareStatement(query);
            withdrawPS.setString(1, searchNum);
            ResultSet withdrawRS = withdrawPS.executeQuery();
            
            if (withdrawRS.next())
            {
                String ID = withdrawRS.getString("stud_ID");
                String LName = withdrawRS.getString("stud_LName");
                String FName = withdrawRS.getString("stud_FName");
                String MName = withdrawRS.getString("stud_MName");
                String c = withdrawRS.getString("course");
                String yL = withdrawRS.getString("yearLevel");
                String a = withdrawRS.getString("address");
                String cN = withdrawRS.getString("contactNum");
                String BD = withdrawRS.getString("BDAY");
                String pos = withdrawRS.getString("Position");
                String o = withdrawRS.getString("Organization");

                tfStud.setText(ID);
                tfLast.setText(LName);
                tfFirst.setText(FName);
                tfMiddle.setText(MName);
                tfCourse.setText(c);
                tfYear.setText(yL);
                tfAddress.setText(a);
                tfNumber.setText(cN);
                tfPosition.setText(pos);
                tfOrg.setText(o);
                
                String[] birthdateParts = BD.split("-");
                if (birthdateParts.length == 3) {
                String year = birthdateParts[0];
                String month = birthdateParts[1];
                String day = birthdateParts[2];

                cbYear.setSelectedItem(year);
                cbMonth.setSelectedIndex(Integer.parseInt(month) - 0);
                cbDay.setSelectedItem(day);
            }
            }
            
            else
            {
                JOptionPane.showMessageDialog(null,"Student number not found.","Error",JOptionPane.ERROR_MESSAGE);
            }


        }
        
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Database error.","Error",JOptionPane.ERROR_MESSAGE);
        } 
    }
}
