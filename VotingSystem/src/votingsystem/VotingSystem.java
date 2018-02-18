/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.List;
import java.sql.SQLException;


/**
 *
 * @author ankita
 */
public class VotingSystem implements ActionListener {

    /*
     * @param args the command line arguments
     */
    int count = 0;
    JFrame f;
    JLabel l,j;
    JButton b1,b2,b3,b4;
    List l2 = new List();
    ImageIcon ic; 
    public VotingSystem()
    {
        
        f = new JFrame("WELCOME");
        l = new JLabel("Login As:");
        b1 = new JButton("Voter");
        b2 = new JButton("Election Commissioner");
        b3 = new JButton("EXIT");
        b4 = new JButton("INFO");
        ic = new ImageIcon("C:\\Users\\ankita\\androidparty.jpg");
        j = new JLabel(ic);
    }
    public void launch()
    {
        j.setSize(400,400);
        f.setSize(400,400);
        f.setLocation(400,200);
        f.setLayout(null);
        l.setBounds(150,100,200,30);
        b1.setBounds(50,150,250,30);
        b1.addActionListener(this);
        b2.setBounds(50,200,250,30);
        b2.addActionListener(this);
        b3.setBounds(270,330,100,30);
        b3.addActionListener(this);
        b4.setBounds(150,330,100,30);
        b4.addActionListener(this);
        Font font = new Font("SEGOE PRINT",Font.BOLD,20);
        l.setFont(font);
        Color color = new Color(240,40,60);
        l.setForeground(color);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        j.add(l);
        j.add(b1);
        j.add(b2);
        j.add(b3);
        j.add(b4);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try
        {
            String path = "jdbc:mysql://localhost;3306/";
            String place ="test";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("Select count(*) from candidate");
                rs.next();
                count = rs.getInt(1);
                if(count==0)
                {
                    b1.setEnabled(false);
                }
                else
                {
                    b1.setEnabled(true);
                }
                f.setVisible(true);
                con.close();
           
           
        }
        catch(Exception ae)
        {
            JOptionPane.showMessageDialog(f,ae.getMessage());
            
        }
            
    }
    public static void main(String args[])
    {
        VotingSystem v = new VotingSystem();
        v.launch();
        
    }
    public class Voter extends VotingSystem{
        Voter v1 = new Voter();
    }
    public class Admin extends VotingSystem{
        Admin a = new Admin();
    }
    public class Intro extends VotingSystem{
        Intro v1 = new Intro();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
      
        if((e.getSource().equals(b1)))
        {
            Voter v1 = new Voter();
            v1.launch();
            f.dispose();
        }
        if(e.getSource().equals(b3))
        {
            
            f.dispose();
        }
        if(e.getSource().equals(b2))
        {
            Admin a = new Admin();
            a.launch();
            f.dispose();
        }
        if(e.getSource().equals(b4))
        {
            Intro i = new Intro();
            i.launch();
            f.dispose();
        }
    }
}    
 
        