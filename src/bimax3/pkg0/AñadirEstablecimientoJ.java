
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AñadirEstablecimientoJ {
    String numeroestablecimiento;
    String numerofacturero;
    String numerofactura;
    String direccion;
    String ciudad;

    public AñadirEstablecimientoJ(String numeroestablecimiento, String numerofacturero, String numerofactura, String direccion, String ciudad) {
        this.numeroestablecimiento = numeroestablecimiento;
        this.numerofacturero = numerofacturero;
        this.numerofactura = numerofactura;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
    public void añadir(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("INSERT INTO detallesfactura (numeroestablecimiento,numerofacturero,numerofactura,direccion,ciudad) VALUES (?,?,?,?,?)");
        ps.setString(1, numeroestablecimiento);
        ps.setString(2,numerofacturero);
        ps.setString(3,numerofactura);
        ps.setString(4,direccion);
        ps.setString(5,ciudad);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    public void eliminar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("DELETE FROM detallesfactura WHERE numeroestablecimiento=? and numerofacturero=?");
        ps.setString(1, numeroestablecimiento);
        ps.setString(2, numerofacturero);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    public void actualizar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("UPDATE detallesfactura SET numerofactura=? WHERE numeroestablecimiento=? and numerofacturero=?");
        ps.setString(1, numerofactura);
        ps.setString(2,numeroestablecimiento);
        ps.setString(3, numerofacturero);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    
}
