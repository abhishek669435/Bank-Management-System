package bank.management.system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Signup3 extends JFrame implements ActionListener {

    String formno;
    JButton submit;

    Signup3(String formno) {

        this.formno = formno;

        setLayout(null);

        JLabel label = new JLabel("Page 3 : Account Details");
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(250,80,400,40);
        add(label);

        submit = new JButton("Submit");
        submit.setBounds(350,200,120,30);
        submit.addActionListener(this);
        add(submit);

        setSize(850,600);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try{

            Random random = new Random();

            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            Conn c = new Conn();

            String query = "insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,
            "Account Created Successfully\n\nCard Number: "+cardnumber+"\nPIN: "+pin);

            new Login();
            setVisible(false);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}