/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basecon;
import java.sql.*;

/**
 *
 * @author natna
 */
public class Basecon {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String [] args) 
    {   
//    //isnert
//        insert();
//        
//     // select
//     select();
        System.out.println("---------------------------------------------------");
        
        
        
    }
   static Connection con()
   {
   Connection jdbc_con = null;
   
   try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        jdbc_con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pdborcl","hr", "hr");
        
        System.out.println("Database Connected!");
        }catch(Exception e)
        {
        
        e.printStackTrace();
        }
   
  
  return jdbc_con;
   }
    
   
   static void select()
   {
   Connection con_jdbc = con();
       try {
           Statement st = con_jdbc.createStatement();
           
           String q = "select * from jobs";
           
           ResultSet listresult = st.executeQuery(q);
           while(listresult.next())
           {
           System.out.println(listresult.getString(1) +"  " + listresult.getString(2));
           
           }
           
           
           con_jdbc.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
   
   
   
   }
   
   static void insert()
   {
       
         Connection con_jdbc = con();
       try {
           Statement st = con_jdbc.createStatement();
           String up_string = "insert into jobs values ('SS', 'ShoeShine', 2100, 6000)";
           
           st.executeUpdate(up_string);
           
           System.out.println("1 Row Inserted!");
           
           con_jdbc.close();
           
       } catch (Exception e) {
           
           e.printStackTrace();
       }
           
    
   }

    }
    

