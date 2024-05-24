package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
        
public class Login extends JFrame implements ActionListener{
    
    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1,button2,button3;
    
    Login(){
        setTitle("Bank Management System");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img.png"));
        Image i2 = i1.getImage().getScaledInstance(390,160,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(220,10,390,100);
        add(image);
        
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel  iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);
        
        label1=new JLabel("AUTOMATIC TELLER MACHINE");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(130,125,600,40);
        add(label1);
        
        
        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Raleway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,210,375,30);
        add(label2);
        
        textField2 = new JTextField(15);
        textField2.setBounds(325,210,230,30);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("Pin:");
        label3.setFont(new Font("Raleway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,270,375,30);
        add(label3);
        
        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325,270,230,30);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField3);
        
        button1=new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(325,320,110,30);
        button1.addActionListener(this);
        add(button1);
        
        button2=new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(445,320,110,30);
        button2.addActionListener(this);
        add(button2);
        
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(325,360,230,30);
        button3.addActionListener(this);
        add(button3);
        
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);
        
        
        
        
        
        setLayout(null);
        setSize(850,480);
        setLocation(400,200);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                Conn conn = new Conn();
                String cardnumber = textField2.getText();
                String pinnumber = passwordField3.getText();
                String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"';";
                try{
                    ResultSet rs = conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    } else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                    }
                        
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
            else if(e.getSource()== button2){
                textField2.setText("");
                passwordField3.setText("");
            }
            else{
                setVisible(false);
                new SignupOne().setVisible(true);
            }
            
        } 
    public static void main(String args[]){
        new Login();
    }
}