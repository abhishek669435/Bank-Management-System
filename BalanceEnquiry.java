package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame {

    String pin;

    BalanceEnquiry(String pin){

        this.pin = pin;

        setLayout(null);

        int balance = 0;

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");

            while(rs.next()){

                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Balance is Rs "+balance);
        text.setBounds(200,200,400,40);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        JButton back = new JButton("Back");
        back.setBounds(300,300,100,30);
        back.addActionListener(e -> {
            setVisible(false);
            new Transactions(pin);
        });
        add(back);

        setSize(850,600);
        setLocation(450,200);
        setVisible(true);
    }
}