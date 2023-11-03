
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Persona {

    public String CDI;
    public String Nombres;
    public String Apellidos;
    public String eMail;
    public long Celular;
    public String Direccion;
    public String Producto;

    public Persona(String CDI, String Nombres, String Apellidos, String eMail, long Celular, String Direccion, String Producto) {
        this.CDI = CDI;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.eMail = eMail;
        this.Celular = Celular;
        this.Direccion = Direccion;
        this.Producto=Producto;
    }
    
    public void registrar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        if(Producto.equalsIgnoreCase("")){
        PreparedStatement ps = con.prepareStatement("INSERT INTO clientes (Cedula,Nombres,Apellidos,CorreoElectronico,Telefono,Direccion) VALUES (?,?,?,?,?,?)");
        ps.setString(1, CDI);
        ps.setString(2,Nombres);
        ps.setString(3,Apellidos);
        ps.setString(4,eMail);
        ps.setInt(5, (int) Celular);
        ps.setString(6,Direccion);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        }else{
        PreparedStatement ps = con.prepareStatement("INSERT INTO clientes (Cedula,Nombres,Apellidos,CorreoElectronico,Telefono,Direccion,Producto) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, CDI);
        ps.setString(2,Nombres);
        ps.setString(3,Apellidos);
        ps.setString(4,eMail);
        ps.setInt(5, (int) Celular);
        ps.setString(6,Direccion);
        ps.setString(7,Producto);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        }
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }    
    public void consultar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * FROM clientes WHERE cedula=?");
        ps.setString(1, CDI);
        rs=ps.executeQuery();
   while(rs.next()){
       CDI=rs.getString("Cedula");
       Nombres=rs.getString("Nombres");
       Apellidos=rs.getString("Apellidos");
       eMail=rs.getString("CorreoElectronico");
       Celular=Integer.parseInt(rs.getString("Telefono"));
       Direccion=rs.getString("Direccion");
       Producto=rs.getString("Producto");
   }
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    public void eliminar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("DELETE FROM clientes WHERE cedula=?");
        ps.setString(1,CDI);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro eliminado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    public void modificar(){
    try{
        Connection cont =  ConexionMySQL.getConexion();
        String sql = "UPDATE clientes SET nombres=?, apellidos=?, correoelectronico=?, telefono=?, direccion=?, producto=? WHERE cedula=?";
        PreparedStatement ps = cont.prepareStatement(sql);
        ps.setString(1,Nombres);
        ps.setString(2,Apellidos);
        ps.setString(3,eMail);
        ps.setInt(4, (int) Celular);
        ps.setString(5,Direccion);
        ps.setString(6,Producto);
        ps.setString(7,CDI);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro modificado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
}
