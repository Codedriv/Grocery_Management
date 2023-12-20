
package grocerymanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class home extends JFrame implements ActionListener{
    JButton product ,sales, Orders;
    home()
    {
         setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/k.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,120,1120,630);
        add(image);
        
        product = new JButton("Products");
        product.setBounds(150,35,150,40);
        product.addActionListener(this);
        add(product);
        
        Orders = new JButton("Customers");
        Orders.setBounds(750,35,150,40);
        Orders.addActionListener(this);
        add(Orders);
        
        sales= new JButton("Sales");
        sales.setBounds(450,35,150,40);
        sales.addActionListener(this);
        add(sales);
        
        
        
        
        
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==product)
        {
            setVisible(false);
            new viewproducts();
        }
        else if(ae.getSource()==sales)
        {
            
            setVisible(false);
            new viewsales();
        }
        else 
        {
           setVisible(false);
           new viewcustomers();
        }
        
    }
    public static void main(String [] args)
    {
        new home();
    }
    
        
    }
    

