package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdraw, balance, exit, fastCash, miniStatement, pinChange;
    String pin;

    Transactions(String pin){

        this.pin = pin;
        setLayout(null);

        // ATM Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,850,600);
        add(image);

        // Welcome text
        JLabel welcome = new JLabel("Welcome to ATM");
        welcome.setBounds(300,130,300,30);
        welcome.setFont(new Font("Raleway",Font.BOLD,22));
        welcome.setForeground(Color.WHITE);
        image.add(welcome);

        JLabel label = new JLabel("ATM Transactions");
        label.setBounds(280,160,350,40);
        label.setFont(new Font("Raleway",Font.BOLD,28));
        label.setForeground(Color.WHITE);
        image.add(label);

        // LEFT SIDE BUTTONS

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(170,230,170,40);
        miniStatement.addActionListener(this);
        miniStatement.setFocusPainted(false);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,290,170,40);
        pinChange.addActionListener(this);
        pinChange.setFocusPainted(false);
        image.add(pinChange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(170,350,170,40);
        balance.addActionListener(this);
        balance.setFocusPainted(false);
        image.add(balance);

        // RIGHT SIDE BUTTONS

        deposit = new JButton("Deposit");
        deposit.setBounds(380,230,170,40);
        deposit.addActionListener(this);
        deposit.setFocusPainted(false);
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(380,290,170,40);
        withdraw.addActionListener(this);
        withdraw.setFocusPainted(false);
        image.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(380,350,170,40);
        fastCash.addActionListener(this);
        fastCash.setFocusPainted(false);
        image.add(fastCash);

        // EXIT BUTTON

        exit = new JButton("Exit");
        exit.setBounds(275,420,170,40);
        exit.addActionListener(this);
        exit.setFocusPainted(false);
        image.add(exit);

        setSize(850,600);
        setLocation(350,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(pin);
        }

        else if(e.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pin);
        }

        else if(e.getSource() == fastCash){
            setVisible(false);
            new FastCash(pin);
        }

        else if(e.getSource() == balance){
            setVisible(false);
            new BalanceEnquiry(pin);
        }

        else if(e.getSource() == miniStatement){
            setVisible(false);
            new MiniStatement(pin);
        }

        else if(e.getSource() == pinChange){
            setVisible(false);
            new PinChange(pin);
        }

        else if(e.getSource() == exit){
            setVisible(false);
            new Login();
        }
    }
}