package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField panNoTextField,aadharNoTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religionBox,categoryBox,incomeBox,educationBox,occupationBox;
    String formno;
    
    SignupTwo (String formno){
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
    
                
        JLabel religion = new JLabel("Relegion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","other"};
        religionBox = new JComboBox(valReligion); 
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);
       
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String valCategory[]={"General","OBC","SC","ST","Other"};
        categoryBox = new JComboBox(valCategory); 
        categoryBox.setBounds(300,190,400,30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valIncome[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000"};
        incomeBox = new JComboBox(valIncome); 
        incomeBox.setBounds(300,240,400,30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
                
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);
                
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String valEducation[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        educationBox = new JComboBox(valEducation); 
        educationBox.setBounds(300,315,400,30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);
        
                
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String valOccupation[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupationBox = new JComboBox(valOccupation); 
        occupationBox.setBounds(300,390,400,30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);
        
        
        JLabel panNo = new JLabel("PAN Number:");
        panNo.setFont(new Font("Raleway",Font.BOLD,20));
        panNo.setBounds(100,440,200,30);
        add(panNo);
        
        panNoTextField = new JTextField();
        panNoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panNoTextField.setBounds(300,440,400,30);
        add(panNoTextField);

        JLabel aadharNo = new JLabel("Aadhar Number:");
        aadharNo.setFont(new Font("Raleway",Font.BOLD,20));
        aadharNo.setBounds(100,490,200,30);
        add(aadharNo);
        
        aadharNoTextField = new JTextField();
        aadharNoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharNoTextField.setBounds(300,490,400,30);
        add(aadharNoTextField);
        
        JLabel sCitizen = new JLabel("Senior Citizen: ");
        sCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        sCitizen.setBounds(100,540,200,30);
        add(sCitizen);
                
        syes = new JRadioButton("yes");
        syes.setBackground(new Color(222,255,228));
        syes.setBounds(300,540,100,30);
        add(syes);
        
        sno = new JRadioButton("no");
        sno.setBackground(new Color(222,255,228));
        sno.setBounds(450,540,100,30);
        add(sno);
        
        ButtonGroup seniorCitizenGroup = new  ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);
        
        
        JLabel eAccount= new JLabel("Existing Account:");
        eAccount.setFont(new Font("Raleway",Font.BOLD,20));
        eAccount.setBounds(100,590,200,30);
        add(eAccount);
        
        eyes = new JRadioButton("yes");
        eyes.setBackground(new Color(222,255,228));
        eyes.setBounds(300,590,100,30);
        add(eyes);
        
        eno = new JRadioButton("no");
        eno.setBackground(new Color(222,255,228));
        eno.setBounds(450,590,100,30);
        add(eno);
        
        ButtonGroup eAccountGroup = new  ButtonGroup();
        eAccountGroup.add(eyes);
        eAccountGroup.add(eno);
        
        
        
        next = new  JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
                
        getContentPane().setBackground(new Color(222,255,228));
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religionBox.getSelectedItem();
        String scategory = (String) categoryBox.getSelectedItem();
        String sincome = (String) incomeBox.getSelectedItem();
        String seducation  = (String) educationBox.getSelectedItem();
        String soccupation  = (String) occupationBox.getSelectedItem();
        String seniorcitizen = null;
        if(eyes.isSelected()){
            seniorcitizen = "Yes";
        } else if(eno.isSelected()){
            seniorcitizen = "No";
        }   
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        String spanNo = panNoTextField.getText();
        String saadharNo = aadharNoTextField.getText();
   
        try {
                Conn c = new Conn();
                String query ="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+spanNo+"','"+saadharNo+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                //Signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        } catch(Exception e){
            System.out.println(e);
        }
        
    }   
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}