package citemain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

public class Loading1 extends JFrame {
    JLabel lblPUP, logoLabel;
    JLabel lblLoad;
    JProgressBar lbLoad;
    
    Loading1(){
        
        setTitle("IBITS PUPBC - Institute of Bachelors in Information Technology Studies");
        setSize(1200,800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(135, 206, 235));


        
        ImageIcon icon = new ImageIcon("C:\\Users\\ADMIN\\Documents\\BRYLE 2024 2nd sem\\citemain\\src\\images\\ibits.png");
        setIconImage(icon.getImage());
        
        ImageIcon logoImage = new ImageIcon("C:\\Users\\ADMIN\\Documents\\BRYLE 2024 2nd sem\\citemain\\src\\images\\ibits.png");
        Image scaledLogoImage = logoImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(25, 15, 100, 100);
        add(logoLabel);
        
        lblPUP = new JLabel("              IBITS PUPBC - Institute of Bachelors in Information Technology Studies");
        lblPUP.setBounds(30, 15, 1200, 100);
        lblPUP.setFont(new Font("Arial", Font.BOLD, 30));
        add(lblPUP);



        lblLoad = new JLabel("LOADING PLEASE WAIT.....");
        lblLoad.setBounds(350,350,500,30);
        lblLoad.setFont((new Font("Arial", Font.BOLD, 25)));
        add(lblLoad);
        
        lbLoad = new JProgressBar();
        lbLoad.setValue(0);
        lbLoad.setStringPainted(true);
        lbLoad.setBounds(350,400,500,50);
        lbLoad.setBackground(new Color(245,237,207));
        lbLoad.setForeground((Color.WHITE));
        lbLoad.setFont(new Font("Arial",Font.PLAIN,12));
        add(lbLoad);
        
        smallrectangle();
        
        new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() throws Exception {
                fill();
                return null;
            }

            @Override
            public void done() {
                dispose();
                Viewing view = new Viewing();
                view.setVisible(true);
            }
        }.execute();
    }

    private void fill() {
        int i = 0;
        try {
            while (i < 100) {
                lbLoad.setValue(i + 10);
                Thread.sleep(120);
                i += 10;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void smallrectangle() {
        JPanel smallrectangle = new JPanel();
        smallrectangle.setBounds(0,0,1200,80);
        smallrectangle.setBackground(Color.WHITE);
        smallrectangle.setVisible(true);
        add(smallrectangle);
    }
}