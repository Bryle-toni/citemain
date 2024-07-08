package citemain;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class citelogsign implements ActionListener {
    
    private JFrame frame = new JFrame();
    private JLabel BG,logoLabel, lblPUP;
    private JButton Login, Signin;

    public citelogsign() {
        
        Login();
        Signin();
        smallrectangle();
        label();
        rectangle2();
        rectangle();
        smallrectangle2();
        background();
        
        frame.setSize(1200,800);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }
    
    
    public void background() {
        JLabel backgroundImage = new JLabel();
        backgroundImage.setSize(1200, 800);
        backgroundImage.setBackground(new Color(135, 206, 235));
        backgroundImage.setOpaque(true); 
        frame.add(backgroundImage);
    }

    
    public void Login() {
        Login = new JButton();
        Login.setBounds(500,400,200,100);
        Login.setBackground(new Color(135, 206, 235));
        Login.setBorderPainted(false);
        Login.setText("Login");
        Login.setFont(new Font("Impact", Font.PLAIN, 20));
        Login.addActionListener(this);
        frame.add(Login);
    }

    public void Signin() {
        Signin = new JButton();
        Signin.setBounds(500,550,200,100);
        Signin.setBackground(new Color(135, 206, 235));
        Signin.setBorderPainted(false);
        Signin.setText("Register");
        Signin.setFont(new Font("Impact", Font.PLAIN, 20));
        Signin.addActionListener(this);
        frame.add(Signin);   
    }
     
    public void smallrectangle() {
        JPanel smallrectangle = new JPanel();
        smallrectangle.setBounds(0,0,1200,80);
        smallrectangle.setBackground(new Color(128, 0, 0));
        smallrectangle.setVisible(true);
        frame.add(smallrectangle);
        

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
        lblPUP.setBounds(80, 10, 1100, 60);
        lblPUP.setFont(new Font("Arial", Font.BOLD, 24));
        lblPUP.setForeground(Color.WHITE); 
        smallrectangle.add(lblPUP);
    }
     
    public void smallrectangle2() {
        JPanel smallrectangle2 = new JPanel();
        smallrectangle2.setBounds(0,680,1200,80);
        smallrectangle2.setBackground(new Color(135, 206, 235));
        smallrectangle2.setVisible(true);
        frame.add(smallrectangle2);
    }
     
    public void rectangle() {
        JPanel rectangle = new JPanel();
        rectangle.setBounds(100, 120, 1000, 600);
        rectangle.setBackground(new Color(255,255,255));
        rectangle.setVisible(true);
        frame.add(rectangle);
    }

    public void rectangle2() {
        JPanel rectangle2 = new JPanel();
        rectangle2.setBounds(130,130,950,100);
        rectangle2.setBackground(new Color(128, 0, 0));
        rectangle2.setVisible(true);
        frame.add(rectangle2);
    }
     
    public void label() {
        JLabel label = new JLabel("WELCOME TO THE IBITS WEBSITE!");
        label.setBounds(450,130,500,100);
        label.setFont(new Font("Impact", Font.PLAIN, 24));
        label.setForeground(Color.WHITE); 
        frame.add(label);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            new citelogin();
            frame.dispose();
        } else if (e.getSource() == Signin) {
            new citesignin();
            frame.dispose();
        }
    }
   
}
