package bank.management.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pin;

    Deposit(String pin){

        this.pin = pin;

        setLayout(null);
        

        JLabel text = new JLabel("Enter Amount You Want to Deposit");
        text.setBounds(200,200,300,30);
        add(text);

        amount = new JTextField();
        amount.setBounds(200,240,200,30);
        add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(200,300,100,30);
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("Back");
        back.setBounds(320,300,100,30);
        back.addActionListener(this);
        add(back);

        setSize(850,600);
        setLocation(450,200);   
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == deposit){

    String number = amount.getText();
    if(number.equals("")){
    JOptionPane.showMessageDialog(null,"Please enter amount");
    return;
}

try{
    Integer.parseInt(number);
}catch(Exception e){
    JOptionPane.showMessageDialog(null,"Enter valid number");
    return;
}
    java.util.Date date = new java.util.Date();

    try{

        Conn c = new Conn();

      String query = "insert into bank(pin,date,type,amount) values('"+pin+"','"+date+"','Deposit','"+number+"')";

        c.s.executeUpdate(query);

        JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited Successfully");

        setVisible(false);
        new Transactions(pin);

    }catch(Exception e){
        System.out.println(e);
    }
}

    else if(ae.getSource() == back){
    setVisible(false);
    new Transactions(pin);
}
    }
}