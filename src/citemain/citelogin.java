package citemain;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class citelogin extends JFrame implements ActionListener {
    private JTextField txtStudentNumber;
    private JComboBox<String> cbMonth, cbDay, cbYear;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnForgotPassword;
    private JCheckBox chShow;
    private int Logins = 0;
    private long cdEnd;
    private Timer cdTimer;
    private JLabel lblCD;
    private static final long cdDuration = 10000; // 10 seconds cooldown

    public citelogin() {
        setTitle("Login");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        lblCD = new JLabel();
        lblCD.setBounds(900, 550, 200, 30);
        lblCD.setForeground(Color.BLACK);
        lblCD.setVisible(false); 
        add(lblCD);
        StudentNumber();
        Birthdate();
        Password();
        LoginButton();
        ForgotPassword();
        ShowPassword();
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

    public void StudentNumber() {
        JLabel lblStudentNumber = new JLabel("Student Number:");
        lblStudentNumber.setBounds(450, 270, 150, 30);
        add(lblStudentNumber);

        txtStudentNumber = new JTextField();
        txtStudentNumber.setBounds(450, 300, 300, 30);
        add(txtStudentNumber);
    }

    public void Password() {
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(450, 350, 150, 30);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(450, 380, 300, 30);
        add(txtPassword);
    }

    public void Birthdate() {
        JLabel lblBirthdate = new JLabel("Birthdate:");
        lblBirthdate.setBounds(450, 460, 150, 30);
        add(lblBirthdate);

        cbMonth = new JComboBox<>(new String[]{"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
        cbMonth.setBounds(450, 490, 100, 30);
        add(cbMonth);

        cbDay = new JComboBox<>(new String[]{"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
                "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
        cbDay.setBounds(570, 490, 70, 30);
        add(cbDay);

        cbYear = new JComboBox<>(new String[]{"", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995",
                "1994", "1992", "1991", "1990"});
        cbYear.setBounds(650, 490, 100, 30);
        add(cbYear);
    }

    public void LoginButton() {
        btnLogin = new JButton("Login");
        btnLogin.setBounds(550, 550, 100, 30);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(70, 130, 180));
        btnLogin.addActionListener(this);
        add(btnLogin);
    }

    public void ForgotPassword() {
        btnForgotPassword = new JButton("Forgot my password?");
        btnForgotPassword.setBounds(510, 590, 180, 30);
        btnForgotPassword.setForeground(Color.WHITE);
        btnForgotPassword.setBackground(new Color(70, 130, 180));
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setOpaque(true);
        btnForgotPassword.addActionListener(this);
        add(btnForgotPassword);
    }

    public void ShowPassword() {
        chShow = new JCheckBox("Show Password");
        chShow.setBounds(450, 420, 130, 30);
        chShow.addActionListener(this);
        add(chShow);
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
        if (e.getSource() == btnLogin) {
            String number = txtStudentNumber.getText();
            String pass = new String(txtPassword.getPassword());
            Object month = cbMonth.getSelectedItem();
            Object day = cbDay.getSelectedItem();
            Object year = cbYear.getSelectedItem();

            if (number.equalsIgnoreCase("Atienza") && pass.equals("bryle") && month.equals("May") && day.equals("11") && year.equals("2004")) {
                Logins = 0;
                JOptionPane.showMessageDialog(this, "Redirecting to Viewing Table...", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Loading1().setVisible(true);
            } else if (number.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your student ID.", "Missing ID", JOptionPane.ERROR_MESSAGE);
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your password.", "Missing password", JOptionPane.ERROR_MESSAGE);
            } else if (month.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your birth month.", "Missing birth month", JOptionPane.ERROR_MESSAGE);
            } else if (day.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your birth day.", "Missing birth day", JOptionPane.ERROR_MESSAGE);
            } else if (year.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your birth year.", "Missing birth year", JOptionPane.ERROR_MESSAGE);
            } else {
                Logins++;
                if (Logins >= 5) {
                    cdEnd = System.currentTimeMillis() + cdDuration;
                    JOptionPane.showMessageDialog(this, "Too many failed login attempts. Please try again later.", "Login limit reached", JOptionPane.ERROR_MESSAGE);
                    lblCD.setVisible(true); // Show cooldown label
                    startCDTimer(); // Start cooldown timer
                    btnLogin.setEnabled(false); // Disable login button during cooldown
                } else {
                    JOptionPane.showMessageDialog(this, "Information incorrect. Please try again.", "Login invalid", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == chShow) {
            if (chShow.isSelected()) {
                txtPassword.setEchoChar((char) 0);
            } else {
                txtPassword.setEchoChar('•');
            }
        }
    }

    private void startCDTimer() {
        cdTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTime = System.currentTimeMillis();
                if (currentTime < cdEnd) {
                    long remCD = (cdEnd - currentTime) / 1000;
                    lblCD.setText("Cooldown: " + remCD + " seconds remaining.");
                } else {
                    cdTimer.stop();
                    lblCD.setVisible(false); // Hide cooldown label
                    btnLogin.setEnabled(true); // Enable login button
                    Logins = 0; // Reset login attempts counter
                }
            }
        });
        cdTimer.start();
    }
}
