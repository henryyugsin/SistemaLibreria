
package BasedeDatos;

import bimax3.pkg0.Bimax30;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionMySQL {
    public static Connection getConexion(){
        Connection cone = null;
        String user ="megared";
        String password="Megared09*";
        String url = "jdbc:mysql://10.30.30.4:3306/bimax4";
    try {  
        cone = DriverManager.getConnection(url,user,password);
        return cone;
    }catch(SQLException e){
       Logger.getLogger(Bimax30.class.getName()).log(Level.SEVERE, null, e);
    }
        return null; 
    }  
}
