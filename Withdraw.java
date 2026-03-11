package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Withdraw extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pin;

    Withdraw(String pin){

        this.pin = pin;

        setLayout(null);

        JLabel text = new JLabel("Enter Amount You Want to Withdraw");
        text.setBounds(200,200,300,30);
        add(text);

        amount = new JTextField();
        amount.setBounds(200,240,200,30);
        add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(200,300,100,30);
        withdraw.addActionListener(this);
        add(withdraw);

        back = new JButton("Back");
        back.setBounds(320,300,100,30);
        back.addActionListener(this);
        add(back);

        setSize(850,600);
        setLocation(450,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == withdraw){

            String number = amount.getText();
            java.util.Date date = new java.util.Date();

            try{

                Conn c = new Conn();
                int balance = 0;

                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");

                while(rs.next()){

                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(balance < Integer.parseInt(number)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                String query = "insert into bank(pin,date,type,amount) values('"+pin+"','"+date+"','Withdraw','"+number+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawn Successfully");

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