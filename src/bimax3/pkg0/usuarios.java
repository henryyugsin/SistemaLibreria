
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
public class usuarios {
   public int id;
   public String nombre;
   public String usuario;
   public String contraseña;
   int i=0;
   public usuarios(int id, String nombre, String usuario, String contraseña){
       this.id=id;
       this.nombre=nombre;
       this.usuario=usuario;
       this.contraseña=contraseña;
   }
   public void registrar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios (nombre,usuario,contraseña) VALUES (?,?,?)");
        ps.setString(1,nombre);
        ps.setString(2,usuario);
        ps.setString(3,contraseña);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido 3");
        }
    }
   public void consultar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        //PreparedStatement psu;
        ResultSet rs;
        //ResultSet rsu;
        ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario=?");
        ps.setString(1,usuario);
        rs=ps.executeQuery();
        contraseña="*/11111112222444fffffftttttttt88887777798888833333445555555httt";
   while(rs.next()){
       id=rs.getInt("id");
       nombre=rs.getString("nombre");
       usuario=rs.getString("usuario");
       contraseña=rs.getString("contraseña");
   }
   con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
   public void consultarc(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        PreparedStatement psu;
        ResultSet rs;
        ResultSet rsu;
        ps = con.prepareStatement("SELECT * FROM usuarios");
        rs=ps.executeQuery();
   while(rs.next()){
       i=i+1;
   }
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
   public void eliminar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement psu = con.prepareStatement("DELETE FROM usuarios WHERE id=?");
        psu.setInt(1,id);
        psu.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro eliminado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
   
}
