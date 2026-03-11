
package bank.management.system;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup2 extends JFrame implements ActionListener {

    JTextField textPan, textAadhar;
    JButton next;
    JRadioButton r1, r2;
    JComboBox<String> religion, category, income, education, occupation;

    String formno;

    Signup2(String formno){

        this.formno = formno;

        setLayout(null);
        setTitle("APPLICATION FORM - PAGE 2");

        JLabel label = new JLabel("Page 2: Additional Details");
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(250,80,400,40);
        add(label);

        JLabel labelReligion = new JLabel("Religion:");
        labelReligion.setBounds(100,140,100,30);
        add(labelReligion);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300,140,200,30);
        add(religion);

        JLabel labelCategory = new JLabel("Category:");
        labelCategory.setBounds(100,190,200,30);
        add(labelCategory);

        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300,190,200,30);
        add(category);

        JLabel labelIncome = new JLabel("Income:");
        labelIncome.setBounds(100,240,200,30);
        add(labelIncome);

        String valIncome[] = {"< 1,50,000","< 2,50,000","< 5,00,000","Above 5,00,000"};
        income = new JComboBox<>(valIncome);
        income.setBounds(300,240,200,30);
        add(income);

        JLabel labelEducation = new JLabel("Education:");
        labelEducation.setBounds(100,290,200,30);
        add(labelEducation);

        String valEducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctorate"};
        education = new JComboBox<>(valEducation);
        education.setBounds(300,290,200,30);
        add(education);

        JLabel labelOccupation = new JLabel("Occupation:");
        labelOccupation.setBounds(100,340,200,30);
        add(labelOccupation);

        String valOccupation[] = {"Salaried","Self-Employed","Business","Student","Retired"};
        occupation = new JComboBox<>(valOccupation);
        occupation.setBounds(300,340,200,30);
        add(occupation);

        JLabel labelPan = new JLabel("PAN Number:");
        labelPan.setBounds(100,390,200,30);
        add(labelPan);

        textPan = new JTextField();
        textPan.setBounds(300,390,200,30);
        add(textPan);

        JLabel labelAadhar = new JLabel("Aadhar Number:");
        labelAadhar.setBounds(100,440,200,30);
        add(labelAadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(300,440,200,30);
        add(textAadhar);

        JLabel labelSenior = new JLabel("Senior Citizen:");
        labelSenior.setBounds(100,490,200,30);
        add(labelSenior);

        r1 = new JRadioButton("Yes");
        r1.setBounds(300,490,100,30);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setBounds(400,490,100,30);
        add(r2);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(r1);
        seniorGroup.add(r2);

        next = new JButton("Next");
        next.setBounds(420,550,80,30);
        next.addActionListener(this);
        add(next);

        setSize(850,700);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();

        String pan = textPan.getText();
        String aadhar = textAadhar.getText();

        String senior = null;
        if(r1.isSelected()){
            senior = "Yes";
        }else if(r2.isSelected()){
            senior = "No";
        }

        try{

            Conn c = new Conn();

            String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+senior+"')";

            c.s.executeUpdate(query);

            new Signup3(formno);
            setVisible(false);

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

