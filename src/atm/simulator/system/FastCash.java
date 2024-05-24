package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    
    JButton rs_100, rs_500, rs_1000, rs_2000, rs_5000, rs_10000, back; 
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system", Font.BOLD, 16));
        image.add(text);
        
        rs_100 = new JButton("Rs 100");
        rs_100.setBounds(170, 415, 150, 30);
        rs_100.addActionListener(this);
        image.add(rs_100);
        
        rs_500 = new JButton("Rs 500");
        rs_500.setBounds(355, 415, 150, 30);
        rs_500.addActionListener(this);        
        image.add(rs_500);
        
        rs_1000 = new JButton("Rs 1000");
        rs_1000.setBounds(170, 450, 150, 30);
        rs_1000.addActionListener(this);
        image.add(rs_1000);
        
        rs_2000 = new JButton("Rs 2000");
        rs_2000.setBounds(355, 450, 150, 30);
        rs_2000.addActionListener(this);        
        image.add(rs_2000);
        
        rs_5000 = new JButton("Rs 5000");
        rs_5000.setBounds(170, 485, 150, 30);
        rs_5000.addActionListener(this);
        image.add(rs_5000);

        rs_10000 = new JButton("Rs 10000");
        rs_10000.setBounds(355, 485, 150, 30);
        rs_10000.addActionListener(this);        
        image.add(rs_10000);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);        
        image.add(back);
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount+ " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }   
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]) {
        new FastCash("");
    }
    
}
