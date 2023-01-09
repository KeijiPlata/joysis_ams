package try3;
import java.util.Scanner;
import java.sql.*;

public class Try3 {
    public static void main(String[] args) {
            // new object
      inputAndConnection ic = new inputAndConnection();
      ic.start();
      ic.connectionDB();
    }
    
}
class inputAndConnection{
    String fname, mname, lname, address, number;
    public void start(){
        // Userinput
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter Data: ");
        System.out.print("First Name: ");
        fname = input.nextLine();
        System.out.print("Middle Name: ");
        mname = input.nextLine();
        System.out.print("Last Name: ");
        lname = input.nextLine();
        System.out.print("Address: ");
        address = input.nextLine();
        System.out.print("Contact Number: ");
        number = input.nextLine();
    }
    
    public void connectionDB(){
       try{
            String db = "jdbc:mysql://localhost:3306/try2";
            Connection conn = DriverManager.getConnection(db, "root", null);
            String qry = "INSERT INTO personalinfo values (null, ? ,?, ?, ?, ?)";
            PreparedStatement pstmnt = conn.prepareStatement(qry);
            pstmnt.setString(1, fname);
            pstmnt.setString(2, mname);
            pstmnt.setString(3, lname);
            pstmnt.setString(4, address);
            pstmnt.setString(5, number);
            pstmnt.executeUpdate();
            System.out.println("Data Inserted");
       
        }
        catch(SQLException a){
            System.out.println("Error");
            a.printStackTrace();
        }
    }
}