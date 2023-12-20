
package grocerymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class addproducts extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number=ran.nextInt(999999);
    JTextField tfname,tfid,tfprice,tfBarcode;
    String Product_ID;
    JComboBox tftype;
    JButton view,add;
    addproducts(String Product_ID)
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("ADD PRODUCT DETAIL");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelroll = new JLabel("Product_ID");
        labelroll.setBounds(50,150,150,30);
        labelroll.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelroll);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/p.jpg"));
        Image i2 =i1.getImage().getScaledInstance(430,280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(430,160,430,280);
        add(image);
        
        tfid =new JTextField();
        tfid.setBounds(230, 150, 150, 30);
        add(tfid);
        
        
        JLabel labelname = new JLabel("Product_Name");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
         tfname =new JTextField();
        tfname.setBounds(230, 220, 150, 30);
        add(tfname);
        
        
        
        
         JLabel labelphone = new JLabel("Price");
        labelphone.setBounds(50,360,150,30);
        labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelphone);
        
         tfprice =new JTextField();
        tfprice.setBounds(230, 360, 150, 30);
        add(tfprice);
        
        JLabel labelBarcode = new JLabel("Barcode");
        labelBarcode.setBounds(50,430,150,30);
        labelBarcode.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelBarcode);
        
        tfBarcode =new JTextField(""+number);
        tfBarcode.setBounds(230,430, 150, 30);
        add(tfBarcode);
        
        
        JLabel labelgrade = new JLabel("Type");
        labelgrade.setBounds(50,290,150,30);
        labelgrade.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelgrade);
        
        String TYPE[]={" ","Dairy","Frutis","Vegetables","Cereals"};
        tftype =new JComboBox(TYPE);
       tftype.setBackground(Color.WHITE);
        tftype.setBounds(230, 290, 150, 30);;
        add(tftype);
        
        
        
        add = new JButton("Add ");
        add.setBounds(220,580,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,580,150,40);
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
            String id=tfid.getText();
            String name =tfname.getText();
            String type = (String) tftype.getSelectedItem();
            String price =tfprice.getText();
            
            String Barcode=tfBarcode.getText();
            
            
                try 
        {
            conn c = new conn();
            String query = "insert into product values("+id+",'"+name+"','"+type+"',"+price+","+Barcode+")";
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
        new addproducts(" ");
    }
}

