package bank.management.system;

import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pin){

        setTitle("Mini Statement");

        JTextArea area = new JTextArea();
        area.setBounds(20,20,360,400);
        add(area);

        try{

            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery(
            "select * from bank where pin = '"+pin+"'");

            while(rs.next()){

                area.append(
                rs.getString("date")+"  "
                +rs.getString("type")+"  "
                +rs.getString("amount")+"\n");

            }

        }catch(Exception e){
            System.out.println(e);
        }
        JButton back = new JButton("Back");
        back.setBounds(150,420,100,30);
        add(back);
        back.addActionListener(e -> {
            setVisible(false);
            new Transactions(pin);
        });

        setLayout(null);
        setSize(400,500);
        setLocation(450,200);
        setVisible(true);
    }
}