
package grocerymanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
        
public class addsaless extends JFrame implements ActionListener {
    JButton add,view;
     Random ran = new Random();
    int number=ran.nextInt(9999);
    JTextField tfsid;
    String sale_id;
    Choice tfcid,tfname;
    JDateChooser dcdate;
    addsaless(String sale_id)
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading =new JLabel("Add Sales Detail");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/sale.png"));
        Image i2 =i1.getImage().getScaledInstance(430,280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(430,160,430,280);
        add(image);
        
        
        JLabel labelid = new JLabel("Sales_ID");
        labelid.setBounds(50,150,150,30);
        labelid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelid);
        
        tfsid =new JTextField(""+number);
        tfsid.setBounds(230, 150, 150, 30);
        add(tfsid);
        JLabel labeldate=new JLabel("Date");
        labeldate.setBounds(50,220,150,30);
        labeldate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeldate);
        
        dcdate=new JDateChooser();
        dcdate.setBounds(230, 220, 150, 30);
        dcdate.setFont(new Font("SERIF",Font.PLAIN,20));
        add(dcdate);
        
        JLabel labelcid= new JLabel("Customer_id");
        labelcid.setBounds(50,290,150,30);
        labelcid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelcid);
        
        tfcid =new Choice();
        tfcid.setBounds(230, 290, 150, 30);
        add(tfcid);
        
        try
        {
            conn c= new conn();
            String query = "Select * from customer";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfcid.add(rs.getString("cust_Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel labelcided= new JLabel("Customer_id");
        labelcided.setBounds(50,290,150,30);
        labelcided.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelcided);
        
        tfcid =new Choice();
        tfcid.setBounds(230, 290, 150, 30);
        add(tfcid);
        
        try
        {
            conn c= new conn();
            String query = "Select * from customer";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfcid.add(rs.getString("cust_Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel labelcidd= new JLabel("Product_Name");
        labelcidd.setBounds(50,360,150,30);
        labelcidd.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelcidd);
        
        tfname=new Choice();
        tfname.setBounds(230, 360, 150, 30);
        
        add(tfname);
        
        try
        {
            conn c= new conn();
            String query = "Select * from product";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfname.add(rs.getString("product_name"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        add = new JButton("Add ");
        add.setBounds(220,470,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,470,150,40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        add(view);
        
        
        
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String sid=tfsid.getText();
            String date= ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String cid=(String)tfcid.getSelectedItem();
            String name=(String)tfname.getSelectedItem();
       
            
            
                try 
        {
            conn c = new conn();
            String query = "insert into sales values("+sid+",'"+date+"',"+cid+",'"+name+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details Added Successfully");
            setVisible(false);
            new home();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        } 
        else
            {
               setVisible(false);
               new home();
            }
    }
        
   
        
    
    public static void main(String [] args)
    {
        new addsaless("");
    }
}
