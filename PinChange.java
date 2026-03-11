package bank.management.system;

import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JTextField newPin;
    JButton change;
    String pin;

    PinChange(String pin){

        this.pin = pin;

        setLayout(null);

        JLabel label = new JLabel("Enter New PIN");
        label.setBounds(100,100,200,30);
        add(label);

        newPin = new JTextField();
        newPin.setBounds(100,140,200,30);
        add(newPin);

        change = new JButton("Change");
        change.setBounds(100,200,100,30);
        add(change);

        change.addActionListener(this);

        setSize(400,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String npin = newPin.getText();

        try{

            Conn c = new Conn();

            c.s.executeUpdate(
            "update login set pin = '"+npin+"' where pin = '"+pin+"'");

            JOptionPane.showMessageDialog(null,"PIN Changed");

        }catch(Exception e){
            System.out.println(e);
        }
    }
}