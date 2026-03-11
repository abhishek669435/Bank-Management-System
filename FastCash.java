package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6;
    String pin;

    FastCash(String pin){

        this.pin = pin;

        setLayout(null);

        b1 = new JButton("100");
        b1.setBounds(50,100,100,40);
        add(b1);

        b2 = new JButton("500");
        b2.setBounds(200,100,100,40);
        add(b2);

        b3 = new JButton("1000");
        b3.setBounds(50,200,100,40);
        add(b3);

        b4 = new JButton("2000");
        b4.setBounds(200,200,100,40);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setSize(400,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String amount = ((JButton)ae.getSource()).getText();

        try{

            Conn c = new Conn();

            String query = "insert into bank(pin,date,type,amount) values('"+pin+"',now(),'Withdraw','"+amount+"')";

            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawn Successfully");
            setVisible(false);
            new Transactions(pin);  


        } catch(Exception e){
            System.out.println(e);
        }
    }
}