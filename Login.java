package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    Login() {

        super("Bank Management System");
        setLayout(null);

        // Bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        // Card image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image i5 = i4.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(630,350,100,100);
        add(image2);

        // Title
        label1 = new JLabel("Welcome to the ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new java.awt.Font("Osward", java.awt.Font.BOLD, 38));
        label1.setBounds(230,125,450,40);
        add(label1);

        // Card number label
        label2 = new JLabel("Card Number:");
        label2.setForeground(Color.WHITE);
        label2.setFont(new java.awt.Font("Raleway", java.awt.Font.BOLD, 28));
        label2.setBounds(150,200,250,30);
        add(label2);

        // Card number field
        textField2 = new JTextField();
        textField2.setFont(new java.awt.Font("Raleway", java.awt.Font.BOLD, 14));
        textField2.setBounds(350,200,250,30);
        add(textField2);

        // PIN label
        label3 = new JLabel("PIN:");
        label3.setForeground(Color.WHITE);
        label3.setFont(new java.awt.Font("Raleway", java.awt.Font.BOLD, 28));
        label3.setBounds(150,250,250,30);
        add(label3);

        // PIN field
        passwordField3 = new JPasswordField();
        passwordField3.setFont(new java.awt.Font("Raleway", java.awt.Font.BOLD, 14));
        passwordField3.setBounds(350,250,250,30);
        add(passwordField3);

        // SIGN IN button
        button1 = new JButton("SIGN IN");
        button1.setBounds(350,300,100,30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(this);
        add(button1);

        // CLEAR button
        button2 = new JButton("CLEAR");
        button2.setBounds(500,300,100,30);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.addActionListener(this);
        add(button2);

        // SIGN UP button
        button3 = new JButton("SIGN UP");
        button3.setBounds(350,350,250,30);
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.addActionListener(this);
        add(button3);

        // Background image
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image i8 = i7.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image3 = new JLabel(i9);
        image3.setBounds(0,0,850,480);
        add(image3);

        setSize(850,480);
        setLocation(450,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            // SIGN IN
            if(e.getSource() == button1){

                Conn c = new Conn();

                String cardno = textField2.getText();
                String pin = passwordField3.getText();

                String query = "select * from login where cardnumber='"+cardno+"' and pin='"+pin+"'";

                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
    JOptionPane.showMessageDialog(null,"Login Successful");
    new Transactions(pin);
    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }

            }

            // CLEAR
            else if(e.getSource() == button2){
                textField2.setText("");
                passwordField3.setText("");
            }

            // SIGN UP
            else if(e.getSource() == button3){
                new Signup();
                setVisible(false);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}