
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Administrador {
    public String RUC;
    public String RazonSocial;
    public String NombreComercial;
    public String CorreoElectronico;
    public int telefono;
    public String Direccion;
    public String Ciudad;
    public String TipoContribuyente;
    public String Contabilidad;
    public String UbicacionFirma;
    public String ContraseñaFirmaElectronica;
    public String ContraseñaCorreo;
    public String UbicacionFactura;
    public String UbicacionLogo;

    public Administrador( String RUC, String RazonSocial,String NombreComercial, String CorreElectronico, int telefono, String Direccion,String Ciudad, String TipoContribuyente, String Contabilidad, String UbicacionFirma, String ContraseñaFirmaElectronica, String ContraseñaCorreo,String UbicacionFactura,String UbicacionLogo) {
        this.RUC = RUC;
        this.RazonSocial = RazonSocial;
        this.NombreComercial=NombreComercial;
        this.CorreoElectronico = CorreElectronico;
        this.telefono = telefono;
        this.Direccion = Direccion;
        this.Ciudad=Ciudad;
        this.TipoContribuyente = TipoContribuyente;
        this.Contabilidad = Contabilidad;
        this.UbicacionFirma = UbicacionFirma;
        this.ContraseñaFirmaElectronica = ContraseñaFirmaElectronica;
        this.ContraseñaCorreo = ContraseñaCorreo;
        this.UbicacionFactura=UbicacionFactura;
        this.UbicacionLogo=UbicacionLogo;
    }
    public void añadir() {
        
        try {
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement psp = con.prepareStatement("INSERT INTO administrador (RUC,RAZONSOCIAL,NOMBRECOMERCIAL,CORREOELECTRONICO,TELEFONO,DIRECCIONMATRIZ,CIUDADMATRIZ,TIPOCONTRIBUYENTE,OBLIGADOCONTABILIDAD,FIRMAELECTRONICA,CONTRASEÑAFIRMAELECTRONICA,contraseñacorreo,carpetafacturas,carpetalogo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        psp.setString(1, RUC);
        psp.setString(2, RazonSocial);
        psp.setString(3, NombreComercial);
        psp.setString(4, CorreoElectronico);
        psp.setInt(5,telefono);
        psp.setString(6, Direccion);
        psp.setString(7, Ciudad);
        psp.setString(8,TipoContribuyente);
        psp.setString(9,Contabilidad);
        psp.setString(10, UbicacionFirma);
        psp.setString(11,ContraseñaFirmaElectronica);
        psp.setString(12,ContraseñaCorreo);
        psp.setString(13,UbicacionFactura);
        psp.setString(14,UbicacionLogo);
        psp.executeUpdate();
        JOptionPane.showMessageDialog(null,"Registro Guardado");
        con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Registro Fallido");
        }
        
    }
      
        public void modificar() {
            Connection cont1 =  ConexionMySQL.getConexion();
        String sql1 = "UPDATE administrador SET nombrecomercial=?, correoelectronico=?, telefono=?, direccionmatriz=?,ciudadmatriz=?, tipocontribuyente=?, obligadocontabilidad=?, firmaelectronica=?,contraseñafirmaelectronica=?,contraseñacorreo=?, carpetafacturas=?, carpetalogo=? WHERE ruc=?;";
        PreparedStatement ps1;
        try {
            ps1 = cont1.prepareStatement(sql1);
           ps1.setString(1,NombreComercial);
            ps1.setString(2,CorreoElectronico);
            ps1.setInt(3,telefono);
            ps1.setString(4,Direccion);
            ps1.setString(5,Ciudad);
            ps1.setString(6, TipoContribuyente);
            ps1.setString(7,Contabilidad);
            ps1.setString(8,UbicacionFirma);
            ps1.setString(9,ContraseñaFirmaElectronica);
            ps1.setString(10,ContraseñaCorreo);
            ps1.setString(11,UbicacionFactura);
            ps1.setString(12,UbicacionLogo);
            ps1.setString(13,RUC);
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Modificado");
            cont1.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Registro fallido");
        }
    }
         public void consultar(){
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * FROM administrador");
        rs=ps.executeQuery();
       while (rs.next()){
      RUC=rs.getString("RUC");
     RazonSocial=rs.getString("RAZONSOCIAL");
     NombreComercial=rs.getString("NOMBRECOMERCIAL");
     CorreoElectronico=rs.getString("CORREOELECTRONICO");
     telefono=rs.getInt("TELEFONO");
     Direccion=rs.getString("DIRECCIONMATRIZ");
     Ciudad=rs.getString("CIUDADMATRIZ");
     TipoContribuyente=rs.getString("tipocontribuyente");
     Contabilidad=rs.getString("Obligadocontabilidad");
     UbicacionFirma=rs.getString("firmaelectronica");
     ContraseñaFirmaElectronica=rs.getString("contraseñafirmaelectronica");
     ContraseñaCorreo=rs.getString("contraseñacorreo");
     UbicacionFactura=rs.getString("carpetafacturas");
     UbicacionLogo=rs.getString("carpetalogo");
     //con.close();
   }
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
        
    }
}
