
package grocerymanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class viewproducts extends JFrame implements ActionListener {
    
    JTable tables;
    Choice Product_id ;
    JButton Search,Print,Add,Back;
    
     viewproducts()
     {
         setLayout(null);
         getContentPane().setBackground(Color.LIGHT_GRAY);
      
        
        JLabel searchlbl =new JLabel("Search by Product id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        Product_id = new Choice();
        Product_id .setBounds(180,20,150,20);
        add(Product_id );
        tables = new JTable();
      
        
        try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from product");
            tables.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                Product_id .add(rs.getString("Product_id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from product");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                Product_id.add(rs.getString("Product_Id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(tables);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        Search = new JButton("Search");
        Search.setBounds(20,70,80,20);
        Search.addActionListener(this);
        add(Search);
        
        Print = new JButton("Print ");
        Print .setBounds(260,70,80,20);
        Print .addActionListener(this);
        add(Print );
        
        Add = new JButton("Add_Product");
        Add.setBounds(120,70,120,20);
        Add.addActionListener(this);
        add(Add);
        
        Back = new JButton("Back");
        Back.setBounds(360,70,80,20);
        Back.addActionListener(this);
        add(Back);
        
       setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Search)
        {
            String query = "select * from grocerymanagementsystem where  product_id = "+Product_id.getSelectedItem()+"";
            try
            {
                conn c=new conn();
                ResultSet rs = c.s.executeQuery(query);
                tables.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== Print)
        {
            try
            {
                tables.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== Add)
        {
           setVisible(false);
           new addproducts(Product_id.getSelectedItem());
            
        }
        else
        {
          setVisible(false);
          new home();
        }
        
        
        
     }
     
      public static void main(String [] args)
      {
        new viewproducts();  
      }
      
    
}
