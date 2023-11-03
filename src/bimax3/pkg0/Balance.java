
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Balance {
    public int numeroventa;
    public String numerofactura;
    public String nombrecliente;
    public String ruc;
    public String monto;
    public String fecha;
    public String vendedor;
    public String sinimpuesto;
    public String impuesto;
    public String propina;
    public String costo;
    public String ganancia;

    public Balance(int numeroventa, String numerofactura, String nombrecliente, String ruc, String monto, String fecha, String vendedor, String sinimpuesto, String impuesto, String propina, String costo, String ganancia) {
        this.numeroventa = numeroventa;
        this.numerofactura = numerofactura;
        this.nombrecliente = nombrecliente;
        this.ruc = ruc;
        this.monto = monto;
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.sinimpuesto = sinimpuesto;
        this.impuesto = impuesto;
        this.propina = propina;
        this.costo = costo;
        this.ganancia = ganancia;
    }
    public void registrar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("INSERT INTO balance (numerofactura,nombrecliente,ruc,monto,fecha,vendedor,sinimpuesto,impuesto,propina,costo,ganancia) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,numerofactura);
        ps.setString(2,nombrecliente);
        ps.setString(3,ruc);
        ps.setString(4,monto);
        ps.setString(5,fecha);
        ps.setString(6,vendedor);
        ps.setString(7,sinimpuesto);
        ps.setString(8,impuesto);
        ps.setString(9,propina);
        ps.setString(10,costo);
        ps.setString(11,ganancia);
        ps.executeUpdate();
        con.close();
        JOptionPane.showMessageDialog(null,"Venta registrada");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Venta fallida");
        }
    }
       
    public void consultar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        //PreparedStatement psu;
        ResultSet rs;
        //ResultSet rsu;
        ps = con.prepareStatement("SELECT * FROM balance WHERE fecha=?");
        ps.setString(1,fecha);
        rs=ps.executeQuery();
   while(rs.next()){
       
   }
   con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    public void consultar2(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * from balance order by numeroventa desc limit 1");
        rs=ps.executeQuery();
   while(rs.next()){
       numeroventa=rs.getInt("numeroventa");
   }
   con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
}
