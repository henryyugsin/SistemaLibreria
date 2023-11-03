
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Cosas {
    public int id;
    public String codigo;
    public String Descripcion;
    public float costo;
    public float valorGanancia;
    public float valorFinal;
    public int cantidadunidades;
    public String iva;
    public String descuento;

    public Cosas(int id, String codigo, String Descripcion, float costo, float valorGanancia, float valorFinal,int cantidadunidades,String iva, String descuento) {
        this.id = id;
        this.codigo = codigo;
        this.Descripcion = Descripcion;
        this.costo = costo;
        this.valorGanancia=valorGanancia;
        this.valorFinal=valorFinal;
        this.cantidadunidades=cantidadunidades;
        this.iva=iva;
        this.descuento=descuento;
    }
    public void registrar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps = con.prepareStatement("INSERT INTO productos (codigo,descripcion,costo,valorGanancia,valorFinal,cantidadunidades,iva,descuento) VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1, codigo);
        ps.setString(2,Descripcion);
        ps.setFloat(3,costo);
        ps.setFloat(4,valorGanancia);
        ps.setFloat(5,valorFinal);
        ps.setFloat(6,cantidadunidades);
        ps.setString(7,iva);
        ps.setString(8,descuento);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro guardado");
        con.close();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    
    }
        public void consultar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * FROM productos WHERE codigo=?");
        ps.setString(1,codigo);
        rs=ps.executeQuery();
   while(rs.next()){
       id=rs.getInt("id");
       codigo=rs.getString("codigo");
       Descripcion=rs.getString("descripcion");
       costo=rs.getFloat("costo");
       valorGanancia=rs.getFloat("valorganancia");
       valorFinal=rs.getFloat("valorfinal");
       cantidadunidades=rs.getInt("cantidadunidades");
       iva=rs.getString("iva");
       descuento=rs.getString("descuento");
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
        ps = con.prepareStatement("SELECT productos.cantidadunidades FROM productos WHERE codigo=?");
        ps.setString(1,codigo);
        rs=ps.executeQuery(); 
   while(rs.next()){
        cantidadunidades=rs.getInt("cantidadunidades");
   }
    con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
  }
  
  public void consultar3(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT productos.descripcion, productos.valorfinal, productos.descuento FROM productos WHERE codigo=?");
        ps.setString(1,codigo);
        rs=ps.executeQuery(); 
   while(rs.next()){
        Descripcion=rs.getString("descripcion");
        valorFinal=rs.getFloat("valorfinal");
        descuento=rs.getString("descuento");
   }
    con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
  }
  public void consultar4(String codigo){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT productos.iva FROM productos WHERE codigo=?");
        ps.setString(1,codigo);
        rs=ps.executeQuery(); 
   while(rs.next()){
        iva=rs.getString("iva");
   }
    con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
  }
    
    public void modificar(){
    try{
        Connection cont =  ConexionMySQL.getConexion();
        PreparedStatement ps = cont.prepareStatement("UPDATE productos SET descripcion=?, costo=?, valorganancia=?, valorfinal=?,cantidadunidades=?, iva=?, descuento=?  WHERE codigo=?");
        ps.setString(1,Descripcion);
        ps.setFloat(2, costo);
        ps.setFloat(3,valorGanancia);
        ps.setFloat(4,valorFinal);
        ps.setFloat(5,cantidadunidades);
        ps.setString(6,iva);
        ps.setString(7,descuento);
        ps.setString(8,codigo);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro modificado");
        cont.close();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    
    }
    
    public void modificarcantidad(int cantidadunidades, String codigo){
    try{
        Connection cont =  ConexionMySQL.getConexion();
        PreparedStatement ps = cont.prepareStatement("UPDATE productos SET cantidadunidades=?  WHERE codigo=?");
        ps.setFloat(1,cantidadunidades);
        ps.setString(2,codigo);
        ps.executeUpdate();
        cont.close();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    public void modificarcantidad2(int cantidadunidades, String codigo){
    try{
        Connection cont =  ConexionMySQL.getConexion();
        PreparedStatement ps = cont.prepareStatement("UPDATE productos SET cantidadunidades=(cantidadunidades-"+cantidadunidades+")  WHERE codigo=?");
        ps.setString(1,codigo);
        ps.executeUpdate();
        cont.close();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    
    
    public void eliminar(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement psu = con.prepareStatement("DELETE FROM productos WHERE codigo=?");
        psu.setString(1,codigo);
        psu.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro eliminado");
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
    
}
