
package bimax3.pkg0;

import BasedeDatos.ConexionMySQL;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
public class print {
    // TODO code application logic here
    int numeroproductos;
    public String vector1[]=new String[5];
     public String vfinal[]=new String[6];
    public String nfactura;
    public String nventa;
    
    public void cantidadproductos(int numeroproductos){
    this.numeroproductos=numeroproductos;
    }
    public String matriz[][]=new String[numeroproductos][7];
    
    public void imprimir(String nfactura,String vector1[],String matrizProductos1[][], String vfinal[], String nventa ) throws IOException{
        this.vector1=vector1;
        this.nfactura=nfactura;
        this.matriz=matrizProductos1;
        this.vfinal=vfinal;
        this.nventa=nventa;
        //Obtencion de Datos
        //Fecha y hora
        //tomar Hora
        LocalDateTime hora=LocalDateTime.now();
        LocalDate fecha=LocalDate.now();
        int año=fecha.getYear();
        int mes =fecha.getMonthValue();
        int dia=fecha.getDayOfMonth();
        int hor= hora.getHour();
        int min= hora.getMinute();
        //Datos del facturador
        String CorreoElectronico=null;
        String razonSocial1=null;
        String nombreComercial1=null;
        String ruc1=null;
        String dirMatriz1=null;
        String obligadoContabilidad1=null;
        String tipocontribuyente=null;
        try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * FROM administrador");
        rs=ps.executeQuery();
        while (rs.next()){
        ruc1=""+rs.getString("RUC");
        razonSocial1=rs.getString("RAZONSOCIAL");
        nombreComercial1=rs.getString("NOMBRECOMERCIAL");
        CorreoElectronico=rs.getString("CORREOELECTRONICO");
        dirMatriz1=rs.getString("DIRECCIONMATRIZ");
        obligadoContabilidad1=rs.getString("OBLIGADOCONTABILIDAD");
        tipocontribuyente=rs.getString("tipocontribuyente");
        }
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
        }
        //Datos del comprador
        //Datos del comprador
    String concumidorfinal="9999999999999";
    String tipodeIdentificacionComprador1="05";
    int longitudcedula=vector1[0].length();
    if (longitudcedula==10){
    tipodeIdentificacionComprador1="05";
    }else{
        if(vector1[0].equals(concumidorfinal)){
        tipodeIdentificacionComprador1="07";
        }else{
        tipodeIdentificacionComprador1="04";
        }
    }
    String identificacionComprador=vector1[0];
    String razonSocialComprador=vector1[1];
    String campoemail=vector1[2];
    String campotelefono=vector1[3];
    String direccionComprador=vector1[4];
        //Llenar el txt para imprimir
        PrinterMatrix printer= new PrinterMatrix();
        Extenso e  = new Extenso();
        e.setNumber(101.85);
        printer.setOutSize(37+numeroproductos, 45);
        printer.printCharAtCol(1, 1, 32,"-------------------");
        printer.printTextWrap(1, 2, 8, 32, "COMPROBANTE "+nventa);
        printer.printTextWrap(2, 3, 1, 32, "Clave de Acceso: ");
        printer.printTextWrap(3, 3, 1, 32, ""+nfactura);
        printer.printTextWrap(5, 3, 1, 32, "Fecha de Emision: "+dia+":"+mes+":"+año);
        printer.printTextWrap(6, 3, 1, 32, "Hora: "+hor+":"+min);
        printer.printTextWrap(7, 3, 1, 32, "Nombre Comercial: "+nombreComercial1);
        printer.printTextWrap(8, 3, 1, 32, "RUC: "+ruc1);
        printer.printTextWrap(9, 3, 1, 32, "Correo: "+CorreoElectronico);
        printer.printTextWrap(10, 3, 1, 32, "Direccion: "+dirMatriz1);
        printer.printTextWrap(11, 3, 1, 32, "Contabilidad: "+obligadoContabilidad1);
        printer.printTextWrap(12, 3, 1, 32, "Regimen: ");
        printer.printTextWrap(13, 3, 1, 32, ""+tipocontribuyente);
        printer.printTextWrap(14, 3, 1, 32, " ");
        printer.printTextWrap(15, 3, 1, 32, "Identificacion: "+identificacionComprador);
        printer.printTextWrap(16, 3, 1, 32, "Nombre: "+razonSocialComprador);
        printer.printTextWrap(17, 3, 1, 32, "Telefono: "+campotelefono);
        printer.printTextWrap(18, 3, 1, 32, "Direccion: "+direccionComprador);
        printer.printTextWrap(19, 3, 1, 32, "Correo: "+campoemail);
        printer.printTextWrap(20, 3, 1, 32, "----------------------- ");
        printer.printTextWrap(21, 3, 1, 5, "Cant");
        printer.printTextWrap(21, 3, 7, 32, "Descripcion");
        printer.printTextWrap(21, 3, 35, 45, "V.Final");
        //System.out.print("Numero productos: "+numeroproductos);
        //System.out.print("Numero matriz: "+matriz[0][2]);
        for(int i = 0; i <= numeroproductos-1; i++){
            printer.printTextWrap(22+i, 22+i, 1, 5, ""+matriz[i][0]);
            printer.printTextWrap(22+i, 22+i, 7, 32, ""+matriz[i][2]);
            printer.printTextWrap(22+i, 22+i, 35, 45, ""+matriz[i][5]);
        }
        printer.printTextWrap(23+numeroproductos,3, 24, 35, "Base 0:");
        printer.printTextWrap(23+numeroproductos,3, 36, 45, ""+vfinal[0]);
        printer.printTextWrap(24+numeroproductos,3, 24, 45, "Base 12: ");
        printer.printTextWrap(24+numeroproductos,3, 36, 45, ""+vfinal[1]);
        printer.printTextWrap(25+numeroproductos,3, 24, 35, "SubTotal:");
        printer.printTextWrap(25+numeroproductos,3, 36, 45, ""+vfinal[4]);
        printer.printTextWrap(26+numeroproductos,3, 24, 35, "Desc T:");
        printer.printTextWrap(26+numeroproductos,3, 36, 45, ""+vfinal[3]);
        printer.printTextWrap(27+numeroproductos,3, 24, 35, "Iva 12:");
        printer.printTextWrap(27+numeroproductos,3, 36, 45, ""+vfinal[2]);
        printer.printTextWrap(28+numeroproductos,3, 24, 35, "Total:");
        printer.printTextWrap(28+numeroproductos,3, 36, 45, ""+vfinal[5]);
        printer.toFile("C:\\imp\\impresion.txt");
        FileInputStream inputStream=null;
        try {
        inputStream=new FileInputStream("C:\\imp\\impresion.txt");
        
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        if (inputStream==null){
            return;
        }
        DocFlavor docFormat= DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document =new SimpleDoc(inputStream, docFormat,null);
        PrintRequestAttributeSet attributeSet=new HashPrintRequestAttributeSet();
        PrintService defaultPrintService =PrintServiceLookup.lookupDefaultPrintService();
        if(defaultPrintService!=null){
        DocPrintJob printJob=defaultPrintService.createPrintJob();
        try{
        printJob.print(document, attributeSet);
        }catch(Exception ex){
        System.out.println("Error:"+ex.toString());
        }
        }else {
        System.err.println("No hay una impresora instalada");
        }
    inputStream.close();
    }
    public print(){
        
    }
        
    
}
