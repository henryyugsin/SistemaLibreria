
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class detallesventa {
    public int id;
    public int numeroventa;
    public int cantidad;
    public String codigo;
    public String descripcion;
    public String total;
    
    public detallesventa(int id, int numeroventa, int cantidad, String codigo, String descripcion, String total){
        this.id=id;
        this.numeroventa=numeroventa;
        this.cantidad=cantidad;
        this.codigo=codigo;
        this.descripcion=descripcion;
        this.total=total;
    }
    public void registrar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("INSERT INTO detallesventas (numeroventa,cantidad,codigo,descripcion,total) VALUES (?,?,?,?,?)");
        ps.setInt(1,numeroventa);
        ps.setInt(2,cantidad);
        ps.setString(3,codigo);
        ps.setString(4,descripcion);
        ps.setString(5,total);
        ps.executeUpdate();
        
        con.close();
        }catch(SQLException e){
        
        }
        
    }
}
