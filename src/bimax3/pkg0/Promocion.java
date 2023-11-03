
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author henry
 */
public class Promocion {
    public int id;
    public String nombre;
    public String porcentaje;
    
    public Promocion(int id, String nombre, String porcentaje){
        this.id=id;
        this.nombre=nombre;
        this.porcentaje=porcentaje;
    }
    public void registrar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("INSERT INTO promocion (nombre,porcentaje) VALUES (?,?)");
        ps.setString(1, nombre);
        ps.setString(2,porcentaje);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    public void consultar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        PreparedStatement psu;
        ResultSet rs;
        ResultSet rsu;
        ps = con.prepareStatement("SELECT * FROM promocion WHERE id=?");
        ps.setInt(1,id);
        rs=ps.executeQuery();
   while(rs.next()){
       nombre=rs.getString("nombre");
       porcentaje=rs.getString("porcentaje");  
   }
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    public void consultarnombre(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        PreparedStatement psu;
        ResultSet rs;
        ResultSet rsu;
        ps = con.prepareStatement("SELECT * FROM promocion WHERE nombre=?");
        ps.setString(1,nombre);
        rs=ps.executeQuery();
   while(rs.next()){
       nombre=rs.getString("nombre");
       porcentaje=rs.getString("porcentaje");  
   }
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    public void modificar(){
    try{
        Connection cont =  ConexionMySQL.getConexion();
        PreparedStatement ps = cont.prepareStatement("UPDATE promocion SET nombre=?, porcentaje=? WHERE id=?");
        ps.setString(1,nombre);
        ps.setString(2, porcentaje);
        ps.setInt(3,id);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro modificado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    public void eliminar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement psu = con.prepareStatement("DELETE FROM promocion WHERE id=?");
        psu.setInt(1,id);
        psu.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro eliminado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    
}
