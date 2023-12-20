
package grocerymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class addcustomer extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number=ran.nextInt(999999);
    JTextField tfname,tfid,tfaddress,tfphone,tfemail;
    String Cust_ID;
    JComboBox tftype;
    JButton view,add;
    addcustomer(String Cust_ID)
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Customer Detail");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/custss.jpg"));
        Image i2 =i1.getImage().getScaledInstance(430,280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(430,160,430,280);
        add(image);
        
        
        JLabel labelroll = new JLabel("Customer_ID");
        labelroll.setBounds(50,150,150,30);
        labelroll.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelroll);
        
        tfid =new JTextField();
        tfid.setBounds(230, 150, 150, 30);
        add(tfid);
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
         tfname =new JTextField();
        tfname.setBounds(230, 220, 150, 30);
        add(tfname);
        
        
        
   
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,430,150,30);
        labelemail.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(230,430, 150, 30);
        add(tfemail);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,360,150,30);
        labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelphone);
        
         tfphone =new JTextField();
        tfphone.setBounds(230, 360, 150, 30);
        add(tfphone);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,290,150,30);
        labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(230, 290, 150, 30);
        add(tfaddress);
        
     
        
        
        add = new JButton("Add ");
        add.setBounds(220,520,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,520,150,40);
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
            String roll=tfid.getText();
            String name =tfname.getText();
            
            String phone =tfphone.getText();
            String email=tfemail.getText();
            String address=tfaddress.getText();
           
            
                try 
        {
            conn c = new conn();
            String query = "insert into customer values("+roll+",'"+name+"','"+address+"',"+phone+",'"+email+"')";
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
        new addcustomer(" ");
    }
}




