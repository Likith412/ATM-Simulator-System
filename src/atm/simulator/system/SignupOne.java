package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser dateChooser ;
    
    Random ran = new Random();
    long random = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(random);
    
    
    SignupOne (){
        
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + first);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,800,40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
    
                
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
                
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(new Color(222,255,228));
        male.setBounds(300,290,60,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBackground(new Color(222,255,228));
        female.setBounds(450,290,100,30);
        add(female);
 
        others = new JRadioButton("Others");
        others.setBackground(new Color(222,255,228));
        others.setBounds(600,290,100,30);
        add(others);
        
        ButtonGroup gendergroup = new  ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);
                
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
                
        JLabel marital = new JLabel("Marital  Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBackground(new Color(222,255,228));
        married.setBounds(300,390,100,30);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(new Color(222,255,228));
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
        
        ButtonGroup maritalgroup = new  ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
                
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
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
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = first;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        } else if(others.isSelected()){
            gender = "Others";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else {
                Conn c = new Conn();
                String query ="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupOne();
    }
}