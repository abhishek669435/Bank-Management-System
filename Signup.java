
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {

    JTextField textName, textFname, textEmail, textAdd, textCity, textState, textPin;
    JRadioButton r1, r2, m1, m2, m3;
    JButton next;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String formno = "" + Math.abs(first4);

    Signup() {

        setTitle("APPLICATION FORM");

        JLabel label1 = new JLabel("APPLICATION FORM NO. " + formno);
        label1.setFont(new Font("Raleway", Font.BOLD, 30));
        label1.setBounds(160,20,600,40);
        add(label1);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(100,100,200,30);
        add(labelName);

        textName = new JTextField();
        textName.setBounds(300,100,400,30);
        add(textName);

        JLabel labelFName = new JLabel("Father's Name:");
        labelFName.setBounds(100,150,200,30);
        add(labelFName);

        textFname = new JTextField();
        textFname.setBounds(300,150,400,30);
        add(textFname);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(100,200,200,30);
        add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBounds(300,200,100,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(400,200,100,30);
        add(r2);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel labelDOB = new JLabel("Date of Birth:");
        labelDOB.setBounds(100,250,200,30);
        add(labelDOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,250,400,30);
        add(dateChooser);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(100,300,200,30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(300,300,400,30);
        add(textEmail);

        JLabel labelMarital = new JLabel("Marital Status:");
        labelMarital.setBounds(100,350,200,30);
        add(labelMarital);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,350,100,30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(420,350,120,30);
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(560,350,100,30);
        add(m3);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(m1);
        maritalGroup.add(m2);
        maritalGroup.add(m3);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setBounds(100,400,200,30);
        add(labelAddress);

        textAdd = new JTextField();
        textAdd.setBounds(300,400,400,30);
        add(textAdd);

        JLabel labelCity = new JLabel("City:");
        labelCity.setBounds(100,450,200,30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setBounds(300,450,400,30);
        add(textCity);

        JLabel labelState = new JLabel("State:");
        labelState.setBounds(100,500,200,30);
        add(labelState);

        textState = new JTextField();
        textState.setBounds(300,500,400,30);
        add(textState);

        JLabel labelPin = new JLabel("Pin Code:");
        labelPin.setBounds(100,550,200,30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setBounds(300,550,400,30);
        add(textPin);

        next = new JButton("Next");
        next.setBounds(620,620,100,30);
        next.addActionListener(this);
        add(next);

        setLayout(null);
        setSize(850,700);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(r1.isSelected()) gender = "Male";
        else if(r2.isSelected()) gender = "Female";

        String email = textEmail.getText();

        String marital = null;
        if(m1.isSelected()) marital = "Married";
        else if(m2.isSelected()) marital = "Unmarried";
        else if(m3.isSelected()) marital = "Other";

        String address = textAdd.getText();
        String city = textCity.getText();
        String state = textState.getText();
        String pincode = textPin.getText();

        try {

            if(name.equals("")) {
                JOptionPane.showMessageDialog(null,"Please fill all fields");
            } else {

                Conn c = new Conn();

                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);

                new Signup2(formno);
                setVisible(false);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}