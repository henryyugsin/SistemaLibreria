
package InterfazGrafica;

import BasedeDatos.ConexionMySQL;
import bimax3.pkg0.Balance;
import bimax3.pkg0.Cosas;
import bimax3.pkg0.Facturar;
import bimax3.pkg0.Persona;
import bimax3.pkg0.Promocion;
import bimax3.pkg0.print;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

public class Facturacion extends javax.swing.JFrame implements ActionListener{
        float costo=0;
        String vectorcliente[]=new String[5];
        int auxi=1;
        private String dato;
        private int idusu;
        public String claveaccesoaux2;
        public int numeroventa1;
    public void modificacioninventario(){
    int numerodefilas=tblProductos.getRowCount();
    Cosas producto = new Cosas(1,"",null,1,1,1,1,"","");
    for(int i = 0; i < numerodefilas; i++) {
    int cantidad=Integer.parseInt(tblProductos.getValueAt(i, 0).toString());
    String codigo=tblProductos.getValueAt(i, 1).toString();
        producto.modificarcantidad2(cantidad,codigo);
    }
    }
    
    
    public Facturacion() {
        initComponents();
        txtpropina.setText("0");
        txtunidadtiempo.setText("dias");
        txtplazo.setText("0");
        numeroEstablecimiento(); 
        numeroFacturero();
        numerofacturas();
        DefaultTableModel modeloTabla= (DefaultTableModel) tblProductos.getModel();
        modeloTabla.setRowCount(0);
        promocion();
        //Diseño Grafico
        Color c1= new Color(0x336b87); 
        Color c2= new Color(0xCDCDC0); 
        Color c3= new Color(0xBBC3C6); 
        this.getContentPane().setBackground(c3);
        jPanel1.setBackground(c2);
        jPanel4.setBackground(c2);
        jPanel8.setBackground(c2);
        jPanel3.setBackground(c2);
        jPanel5.setBackground(c2);
        jPanel6.setBackground(c2);
        jPanel2.setBackground(c2);
        
    } 
    public void busquedaClientes(){
        
        String cedula = txtruc.getText();
        Persona usu = new Persona(cedula,null,null,null,1,null,null);
        usu.consultar();
        if (usu.Nombres==null){
        JOptionPane.showMessageDialog(null, "No existe el usuario");
        }else{
        String CDI = usu.CDI;
        String Nombres = usu.Nombres;
        String Apellidos = usu.Apellidos;
        String eMail = usu.eMail;
        long Celular = usu.Celular;
        String Direccion = usu.Direccion;
        txtruc.setText(""+CDI);
        txtnombres.setText(Nombres+" "+Apellidos);
        txtcorreoelectronico.setText(eMail);
        txttelefono.setText(""+Celular);
        txtdireccion.setText(Direccion);
        //Consultar si el usuario tiene un servicio relacionado
        if(usu.Producto!=null){   
        Cosas servi = new Cosas(1,usu.Producto,null,1,1,1,1,"","");
        servi.consultar();
        cargartabla(1,servi.codigo,servi.Descripcion,servi.valorFinal,0);
        calculovalores();
        }  
    }
    }
    public int verificarDatosEstenLlenosComprador(){
    //Este metodo se utilizara para verificar que todos los datos de la tabla esten llenados correctamente
    int verificador=0;
            int longitud2= txtruc.getText().length();
            if(longitud2==0){
                verificador=1;
            JOptionPane.showMessageDialog(null, "El campo RUC/CEDULA esta vacio");
            }else{
                int longitud = txtruc.getText().length();
                if (longitud==13 || longitud==10){
                }else{
                    verificador=1;
                JOptionPane.showMessageDialog(null, "El campo RUC/CEDULA es incorrecto");
                }
            }
            if(txtnombres.getText().length()==0){
                verificador=1;
            JOptionPane.showMessageDialog(null, "Los nombres no pueden estar vacio");
            }
            if(txtcorreoelectronico.getText().length()==0){
                verificador=1;
            JOptionPane.showMessageDialog(null, "El Correo Electronico no pueden estar vacio");
            }
            if(txttelefono.getText().length()==0){
                verificador=1;
            JOptionPane.showMessageDialog(null, "El Telefono no pueden estar vacio");
            }
            if(txtdireccion.getText().length()==0){
                verificador=1;
            JOptionPane.showMessageDialog(null, "La direccion no pueden estar vacio");
            }
            return verificador;
    }
    
    public int verificarDatosEstenLlenosProducto(){
    int verificador=0;
            int numerodefilas=tblProductos.getRowCount();
            if(numerodefilas==0){
                verificador=1;
            JOptionPane.showMessageDialog(null, "No ha añadido ningun producto a la Lista");
            }
            
    for(int i = 0; i < numerodefilas; i++) {
    for(int j = 0; j < 6; j++) {
    if(tblProductos.getValueAt(i, j)==null){
                verificador=1;
            JOptionPane.showMessageDialog(null, "La Tabla productos tiene algun o algunos campos vacios");
            }
    }
    }
            return verificador;
    }
    public void cargartabla(int cantidad, String codigo, String descripcion,double preciounitario,double descuento){
    //Calcular el precio total del producto
    double total=cantidad*preciounitario-descuento;
    DefaultTableModel modeloTabla= (DefaultTableModel) tblProductos.getModel();
    modeloTabla.setRowCount(0);
    Object[]vec= new Object[6];
    vec[0]=cantidad;
    vec[1]=codigo;
    vec[2]=descripcion;
    vec[3]=preciounitario;
    vec[4]=descuento;
    vec[5]=total;
    modeloTabla.addRow(vec);
    }
    public void calculovalores1(){
        costo=0;
    //Total del producto
    float totalsum=0;
    float descuentototal=0;
    int numerodefilas=tblProductos.getRowCount();
    float base0=0;
    float base12=0;
    Cosas producto = new Cosas(1,"",null,1,1,1,1,"","");
    for(int i = 0; i < numerodefilas; i++) {             
    int cantidad=Integer.parseInt(tblProductos.getValueAt(i, 0).toString());
    float preciounitario=Float.parseFloat(tblProductos.getValueAt(i, 3).toString());
    float descuento=cantidad*Float.parseFloat(tblProductos.getValueAt(i, 4).toString());
    descuentototal=descuentototal+descuento;
    float total=cantidad*preciounitario-descuento;
    BigDecimal db17= new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    double iva17=db17.doubleValue();
    if(iva17<=0){
        JOptionPane.showMessageDialog(null, "El valor del producto no puede ser Menor o Igual a Cero");
        tblProductos.setValueAt("0.0", i, 4);
        descuentototal=0;
        //tblProductos.setValueAt(iva17, i, 5);
        total=Float.parseFloat(tblProductos.getValueAt(i, 5).toString());
    totalsum=totalsum+total;
    //Sacar el costo de cada producto
        String codigo = tblProductos.getValueAt(i, 1).toString();
        //Cosas producto = new Cosas(1,codigo,null,1,1,1,1,"","");
        producto.consultar4(codigo);
        //Ver que cantidad va en base 0 y base 12
        String comparar1="12";
        if(comparar1.equals(producto.iva)){
            base12=base12+total;
        }else{
        base0=base0+total;
        }
        //costob=0;  
    }else{
        tblProductos.setValueAt(iva17, i, 5);
    totalsum=totalsum+total;
    //Sacar el costo de cada producto
        String codigo = tblProductos.getValueAt(i, 1).toString();
        //Cosas producto = new Cosas(1,codigo,null,1,1,1,1,"","");
        producto.consultar4(codigo);
        //Ver que cantidad va en base 0 y base 12
        String comparar1="12";
        if(comparar1.equals(producto.iva)){
            base12=base12+total;
        }else{
        base0=base0+total;
        }
        //costob=0;  
    }
    }
    BigDecimal db5= new BigDecimal(descuentototal).setScale(2, RoundingMode.HALF_UP);
    double desc11=db5.doubleValue();
    txttotaldescuento.setText(""+desc11);
    double propina = Double.parseDouble(txtpropina.getText());
//Prueba de llena de datos
//Base 0
BigDecimal db2= new BigDecimal(base0).setScale(2, RoundingMode.HALF_UP);
    double iva1=db2.doubleValue();
    txtbase0.setText(""+iva1);
    //Base 12
    double auxb121=base12/1.12;
    BigDecimal db12z1= new BigDecimal(auxb121).setScale(3, RoundingMode.DOWN);
    String auxb121z1=""+db12z1;
    double auxb121zx1=Double.parseDouble(auxb121z1);
    
    BigDecimal db12= new BigDecimal(auxb121zx1).setScale(2, RoundingMode.HALF_UP);
    double iva12=db12.doubleValue();
    txtbase12.setText(""+iva12);
    //Iva
    double auxb12=auxb121*12/100;
    BigDecimal db12z= new BigDecimal(auxb12).setScale(3, RoundingMode.HALF_UP);
    String auxb121z=""+db12z;
    double auxb121zx=Double. parseDouble(auxb121z);
    BigDecimal db121= new BigDecimal(auxb121zx).setScale(2, RoundingMode.HALF_UP);
    double iva121=db121.doubleValue();
    txtiva12.setText(""+iva121);
//Subtotal
String auxb121zt=""+db12;
double auxb121zxt=Double. parseDouble(auxb121zt);
double subtotalsinimpuesto1=base0+auxb121zxt;
BigDecimal db4= new BigDecimal(subtotalsinimpuesto1).setScale(2, RoundingMode.HALF_UP);
    double sb=db4.doubleValue();
txtsubtotalsinimpuestos.setText(""+sb);
//Valor final
float subtotalsinimpuesto=totalsum;
double valortotal=subtotalsinimpuesto+propina;
    BigDecimal db= new BigDecimal(valortotal).setScale(2, RoundingMode.HALF_UP);
    double val2=db.doubleValue();
    txtvalortotal.setText(""+val2);
    }
    public void calculovalores(){
        int proaux=jComboBoxprom.getItemCount();
        System.out.println(proaux);
        if (proaux==1){
            costo=0;
    //Total del producto
    float totalsum=0;
    float descuentototal=0;
    int numerodefilas=tblProductos.getRowCount();
    float base0=0;
    float base12=0;
    Cosas producto = new Cosas(1,"",null,1,1,1,1,"","");
    for(int i = 0; i < numerodefilas; i++) {
    int cantidad=Integer.parseInt(tblProductos.getValueAt(i, 0).toString());
    float preciounitario=Float.parseFloat(tblProductos.getValueAt(i, 3).toString());
    float descuento=cantidad*Float.parseFloat(tblProductos.getValueAt(i, 4).toString());
    descuentototal=descuentototal+descuento;
    float total=cantidad*preciounitario-descuento;
    BigDecimal db177= new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    double iva177=db177.doubleValue();
    tblProductos.setValueAt(iva177, i, 5);
    totalsum=totalsum+total;
    //Sacar el costo de cada producto
        String codigo = tblProductos.getValueAt(i, 1).toString();
        producto.consultar4(codigo);
        //Ver que cantidad va en base 0 y base 12
        String comparar1="12";
        if(comparar1.equals(producto.iva)){
            base12=base12+total;
        }else{
        base0=base0+total;
        }
        //costob=0;  
    }
    BigDecimal db5= new BigDecimal(descuentototal).setScale(2, RoundingMode.HALF_UP);
    double desc11=db5.doubleValue();
    txttotaldescuento.setText(""+desc11);
    double propina = Double.parseDouble(txtpropina.getText());
//Prueba de llena de datos
//Base 0
BigDecimal db2= new BigDecimal(base0).setScale(2, RoundingMode.HALF_UP);
    double iva1=db2.doubleValue();
    txtbase0.setText(""+iva1);
    //Base 12
    double auxb121=base12/1.12;
    double auxb12=auxb121*12/100;
    BigDecimal db12= new BigDecimal(auxb121).setScale(2, RoundingMode.HALF_UP);
    double iva12=db12.doubleValue();
    txtbase12.setText(""+iva12);
    BigDecimal db121= new BigDecimal(auxb12).setScale(2, RoundingMode.HALF_UP);
    double iva121=db121.doubleValue();
    txtiva12.setText(""+iva121);
//Subtotal
double subtotalsinimpuesto1=base0+auxb121;
BigDecimal db4= new BigDecimal(subtotalsinimpuesto1).setScale(2, RoundingMode.HALF_UP);
    double sb=db4.doubleValue();
txtsubtotalsinimpuestos.setText(""+sb);
//Valor final
float subtotalsinimpuesto=totalsum;
double valortotal=subtotalsinimpuesto+propina;
    BigDecimal db= new BigDecimal(valortotal).setScale(2, RoundingMode.HALF_UP);
    double val2=db.doubleValue();
    txtvalortotal.setText(""+val2);
        }else{
            String comp="0";
            if(jComboBoxprom.getSelectedItem().toString().equals(comp)){
                   costo=0;
    //Total del producto
    float totalsum=0;
    float descuentototal=0;
    int numerodefilas=tblProductos.getRowCount();
    float base0=0;
    float base12=0;
    Cosas producto = new Cosas(1,"",null,1,1,1,1,"","");
    for(int i = 0; i < numerodefilas; i++){
                tblProductos.setValueAt("0.0", i, 4);
                }
    for(int i = 0; i < numerodefilas; i++) {
    int cantidad=Integer.parseInt(tblProductos.getValueAt(i, 0).toString());
    float preciounitario=Float.parseFloat(tblProductos.getValueAt(i, 3).toString());
    float descuento=cantidad*Float.parseFloat(tblProductos.getValueAt(i, 4).toString());
    descuentototal=descuentototal+descuento;
    float total=cantidad*preciounitario-descuento;
    BigDecimal db179= new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    double iva179=db179.doubleValue();
    tblProductos.setValueAt(iva179, i, 5);
    totalsum=totalsum+total;
    //Sacar el costo de cada producto
        String codigo = tblProductos.getValueAt(i, 1).toString();
        producto.consultar4(codigo);
        //Ver que cantidad va en base 0 y base 12
        String comparar1="12";
        if(comparar1.equals(producto.iva)){
            base12=base12+total;
        }else{
        base0=base0+total;
        }
        //costob=0;  
    }
    BigDecimal db5= new BigDecimal(descuentototal).setScale(2, RoundingMode.HALF_UP);
    double desc11=db5.doubleValue();
    txttotaldescuento.setText(""+desc11);
    double propina = Double.parseDouble(txtpropina.getText());
//Prueba de llena de datos
//Base 0
BigDecimal db2= new BigDecimal(base0).setScale(2, RoundingMode.HALF_UP);
    double iva1=db2.doubleValue();
    txtbase0.setText(""+iva1);
    //Base 12
    double auxb121=base12/1.12;
    double auxb12=auxb121*12/100;
    BigDecimal db12= new BigDecimal(auxb121).setScale(2, RoundingMode.HALF_UP);
    double iva12=db12.doubleValue();
    txtbase12.setText(""+iva12);
    BigDecimal db121= new BigDecimal(auxb12).setScale(2, RoundingMode.HALF_UP);
    double iva121=db121.doubleValue();
    txtiva12.setText(""+iva121);
//Subtotal
double subtotalsinimpuesto1=base0+auxb121;
BigDecimal db4= new BigDecimal(subtotalsinimpuesto1).setScale(2, RoundingMode.HALF_UP);
    double sb=db4.doubleValue();
txtsubtotalsinimpuestos.setText(""+sb);
//Valor final
float subtotalsinimpuesto=totalsum;
double valortotal=subtotalsinimpuesto+propina;
    BigDecimal db= new BigDecimal(valortotal).setScale(2, RoundingMode.HALF_UP);
    double val2=db.doubleValue();
    txtvalortotal.setText(""+val2);
            }else{ 
                Promocion pro=new Promocion(1,jComboBoxprom.getSelectedItem().toString(),"");
                pro.consultarnombre();
                float auxdesct=Float.parseFloat(pro.porcentaje);
                int numerodefilas=tblProductos.getRowCount();
                for(int i = 0; i < numerodefilas; i++){
                    float auxprom=(Float.parseFloat(tblProductos.getValueAt(i, 3).toString())*auxdesct)/100;
                    BigDecimal dbx= new BigDecimal(auxprom).setScale(2, RoundingMode.HALF_UP);
                    double valx=dbx.doubleValue();
                    tblProductos.setValueAt(""+valx, i, 4);
                }
                //Total del producto
    float totalsum=0;
    float descuentototal=0;
    float base0=0;
    float base12=0;
    Cosas producto = new Cosas(1,"",null,1,1,1,1,"","");
    for(int i = 0; i < numerodefilas; i++) {
    int cantidad=Integer.parseInt(tblProductos.getValueAt(i, 0).toString());
    float preciounitario=Float.parseFloat(tblProductos.getValueAt(i, 3).toString());
    float descuento=cantidad*Float.parseFloat(tblProductos.getValueAt(i, 4).toString());
    descuentototal=descuentototal+descuento;
    float total=cantidad*preciounitario-descuento;
     BigDecimal db174= new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
    double iva174=db174.doubleValue();
    tblProductos.setValueAt(iva174, i, 5);
    totalsum=totalsum+total;
    //Sacar el costo de cada producto
        String codigo = tblProductos.getValueAt(i, 1).toString();
        producto.consultar4(codigo);
        //Ver que cantidad va en base 0 y base 12
        String comparar1="12";
        if(comparar1.equals(producto.iva)){
            base12=base12+total;
        }else{
        base0=base0+total;
        } 
    }
    BigDecimal db5= new BigDecimal(descuentototal).setScale(2, RoundingMode.HALF_UP);
    double desc11=db5.doubleValue();
    txttotaldescuento.setText(""+desc11);
    double propina = Double.parseDouble(txtpropina.getText());
//Prueba de llena de datos
//Base 0
BigDecimal db2= new BigDecimal(base0).setScale(2, RoundingMode.HALF_UP);
    double iva1=db2.doubleValue();
    txtbase0.setText(""+iva1);
    //Base 12
    double auxb121=base12/1.12;
    double auxb12=auxb121*12/100;
    BigDecimal db12= new BigDecimal(auxb121).setScale(2, RoundingMode.HALF_UP);
    double iva12=db12.doubleValue();
    txtbase12.setText(""+iva12);
    BigDecimal db121= new BigDecimal(auxb12).setScale(2, RoundingMode.HALF_UP);
    double iva121=db121.doubleValue();
    txtiva12.setText(""+iva121);
//Subtotal
double subtotalsinimpuesto1=base0+auxb121;
BigDecimal db4= new BigDecimal(subtotalsinimpuesto1).setScale(2, RoundingMode.HALF_UP);
    double sb=db4.doubleValue();
txtsubtotalsinimpuestos.setText(""+sb);
//Valor final
float subtotalsinimpuesto=totalsum;
double valortotal=subtotalsinimpuesto+propina;
    BigDecimal db= new BigDecimal(valortotal).setScale(2, RoundingMode.HALF_UP);
    double val2=db.doubleValue();
    txtvalortotal.setText(""+val2);
            }
        } 
    }
  public void tomaDatos() throws SAXException, IOException, XPathExpressionException, ParserConfigurationException, Exception{
        //Obtener todos los datos necesarios
        //Datos del comprador
        String ruc=txtruc.getText();
        String razonsocial=txtnombres.getText();
        String correo=txtcorreoelectronico.getText();
        String telefono=txttelefono.getText();
        String direccion=txtdireccion.getText();
        //Datos de la factura
        String ambiente="PRODUCCION";
        if(ambiente.equals(jComboBox2.getSelectedItem().toString())){
        ambiente="2";
        }else{
        ambiente="1";
        }
        String numeroestablecimiento=""+jComboBoxNEstablecimiento.getSelectedItem();
        String numerofacturero=""+jComboBoxNFacturero.getSelectedItem();
        String numerofactura=txtnumerodefactura.getText();
        String formapago=jComboBox3.getSelectedItem().toString();
        String plazo=txtplazo.getText();
        //datos generales de los valores finales de la factura
        String vector1[]=new String[5];
        vector1[0]=ruc;
        vector1[1]=razonsocial;
        vector1[2]=correo;
        vector1[3]=telefono;
        vector1[4]=direccion;
        //datos del producto
        int numerodefilas=tblProductos.getRowCount();
        Facturar crearxml=new Facturar();
        crearxml.cantidadproductos(numerodefilas);
        String matriz[][]=new String[numerodefilas][7];
        String matrizp[][]=new String[numerodefilas][10];
        
        for(int i = 0; i < numerodefilas; i++) {
         for(int j = 0; j < 6; j++) {
          matriz[i][j]=tblProductos.getValueAt(i, j).toString();
          
        } 
        }
        Cosas producto = new Cosas(1,"",null,1,1,1,1,"","");
        for(int i = 0; i < numerodefilas; i++) {
            String codigo = tblProductos.getValueAt(i, 1).toString();
        producto.consultar4(codigo);
          matriz[i][6]=producto.iva;
        }
        
        //Datos de la factura
        String vector2[]=new String[6];
        vector2[0]=ambiente;
        vector2[1]=numeroestablecimiento;
        vector2[2]=numerofacturero;
        vector2[3]=numerofactura;
        vector2[4]=formapago;
        vector2[5]=plazo;
        //Datos finales
        String vector3[]=new String[7];
        vector3[0]=txtsubtotalsinimpuestos.getText();
        vector3[1]=txttotaldescuento.getText();
        vector3[2]=txtpropina.getText();
        vector3[3]=txtvalortotal.getText();
        vector3[4]=txtbase0.getText();
        vector3[5]=txtbase12.getText();
        vector3[6]=txtiva12.getText();
        crearxml.generarxml(vector1, matriz,vector2,vector3,matrizp); 
        vectorcliente=vector1;
        //claveaccesoaux2=crearxml.claveaccesoaux;
        //emitirventa1();
        if (crearxml.controladorn==1){
        claveaccesoaux2=crearxml.claveaccesoaux;
        emitirventa1();
        numerofacturas();
        }else{
        
        }
  }
  public void setdato(int idusu, String dato){
    this.dato=dato;
    this.idusu=idusu;
    txtusuario.setText(dato);
    this.dato=dato;
    this.idusu=idusu;
    txtusuario.setText(dato);
    if(idusu>1){
    jComboBoxInventario.setEnabled(false);
    }
    
  }
public void limpiar(){
           txtruc.setText("");
           txtnombres.setText("");
           txtcorreoelectronico.setText("");
           txttelefono.setText("");
           txtdireccion.setText("");
           DefaultTableModel modeloTabla= (DefaultTableModel) tblProductos.getModel();
           modeloTabla.setRowCount(0);
           txtbase0.setText("");
           txtbase12.setText("");
           txtsubtotalsinimpuestos.setText("");
           txtiva12.setText("");
           txtvalortotal.setText("");
           txtpropina.setText("0");
           txttotaldescuento.setText("");
}  
public void limpiarDatosFinales(){
           txtbase0.setText("");
           txtbase12.setText("");
           txtsubtotalsinimpuestos.setText("");
           txtiva12.setText("");
           txtvalortotal.setText("");
           txtcodigoproducto.setText("");
           txttotaldescuento.setText("");
}
public void numerofacturas(){
        
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT detallesfactura.numerofactura FROM detallesfactura WHERE numeroestablecimiento="+jComboBoxNEstablecimiento.getSelectedItem()+" and NUMEROFACTURERO="+jComboBoxNFacturero.getSelectedItem());
        rs=ps.executeQuery();
        while (rs.next()){
        txtnumerodefactura.setText(rs.getString("numerofactura"));
        }
        con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    public void emitirventa1() throws SAXException, IOException, XPathExpressionException, ParserConfigurationException{
        
        int verificador = verificarDatosEstenLlenosComprador();
        int verificador1 = verificarDatosEstenLlenosProducto();
        if (verificador==0&&verificador1==0){
            String ruc=txtruc.getText();
            String nombres=txtnombres.getText();
            String numerofactura=""+jComboBoxNEstablecimiento.getSelectedItem()+jComboBoxNFacturero.getSelectedItem()+txtnumerodefactura.getText();
            //Porque tan solo es una venta
            String monto=txtvalortotal.getText();
            //Obtener la fecha
            LocalDate fecha=LocalDate.now();
            String vendedor=dato;
            String sinimpuesto = txtsubtotalsinimpuestos.getText();
            String propina=txtpropina.getText();
            String impuesto;
            String comparar1="IVA 12%";
            if(comparar1.equals(jComboBoxprom.getSelectedItem().toString())){
                impuesto=txtiva12.getText();
            }
            else{
                impuesto=""+0;
            }
            //Costo y Ganancia
            String cost=""+costo;
            float ganancia=Float.parseFloat(monto)-costo-Float.parseFloat(impuesto);
            String gananci=""+ganancia;
            String fech=""+fecha;
            Balance balance = new Balance(1,""+claveaccesoaux2,nombres,ruc,monto,fech,vendedor,sinimpuesto,impuesto,propina,cost,gananci);
            balance.registrar();
            balance.consultar2();
            int nv=balance.numeroventa;
            numeroventa1=nv;
            costo=0;  
            //Modificar valor de articulos en el inventario
            String efactsmiv="MODIFICAR";
        if(efactsmiv.equals(jComboBoxInventario.getSelectedItem().toString())){
        modificacioninventario();
        }else{
        
        }  
            //Datos del comprador
            //Datos del comprador
            String vector1[]=new String[5];
        String ruc1=txtruc.getText();
        String razonsocial=txtnombres.getText();
        String correo=txtcorreoelectronico.getText();
        String telefono=txttelefono.getText();
        String direccion=txtdireccion.getText();
        vector1[0]=ruc1;
        vector1[1]=razonsocial;
        vector1[2]=correo;
        vector1[3]=telefono;
        vector1[4]=direccion;
        //datos del producto
        int numerodefilas=tblProductos.getRowCount();
        Facturar crearxml=new Facturar();
        crearxml.cantidadproductos(numerodefilas);
        String matriz[][]=new String[numerodefilas][7];
        for(int i = 0; i < numerodefilas; i++) {
         for(int j = 0; j < 6; j++) {
          matriz[i][j]=tblProductos.getValueAt(i, j).toString();
        } 
        }
        for(int i = 0; i < numerodefilas; i++) {
          matriz[i][6]=jComboBoxprom.getSelectedItem().toString();
        }
        //Datos finales
        String vector3[]=new String[6];
        vector3[0]=txtbase0.getText();
        vector3[1]=txtbase12.getText();
        vector3[2]=txtiva12.getText();
        vector3[3]=txttotaldescuento.getText();
        vector3[4]=txtsubtotalsinimpuestos.getText();
        vector3[5]=txtvalortotal.getText();
            //Imprimir recibo
            String nfactura=claveaccesoaux2;
            print pr= new print();
            pr.cantidadproductos(numerodefilas);
            String nimpresiones1="1";
            String nimpresiones2="2";
        if(nimpresiones1.equals(jComboBoxImprimir.getSelectedItem().toString())){
        pr.imprimir(nfactura,vector1,matriz,vector3,""+nv);
        }else{
          if(nimpresiones2.equals(jComboBoxImprimir.getSelectedItem().toString())){
        pr.imprimir(nfactura,vector1,matriz,vector3,""+nv);
        pr.imprimir(nfactura,vector1,matriz,vector3,""+nv);
        }else{
        }  
        } 
            //Limpear Datos
            limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Datos llenados Incorrectamente. Por favor, llenelos nuevamente");
        }
        
        
    }
    public void emitirventa() throws SAXException, IOException, XPathExpressionException, ParserConfigurationException{
        
        int verificador = verificarDatosEstenLlenosComprador();
        int verificador1 = verificarDatosEstenLlenosProducto();
        if (verificador==0&&verificador1==0){
            String ruc=txtruc.getText();
            String nombres=txtnombres.getText();
            String numerofactura=""+jComboBoxNEstablecimiento.getSelectedItem()+jComboBoxNFacturero.getSelectedItem()+txtnumerodefactura.getText();
            //Porque tan solo es una venta
            numerofactura="";
            String monto=txtvalortotal.getText();
            //Obtener la fecha
            LocalDate fecha=LocalDate.now();
            String vendedor=dato;
            String sinimpuesto = txtsubtotalsinimpuestos.getText();
            String propina=txtpropina.getText();
            String impuesto;
            String comparar1="IVA 12%";
            if(comparar1.equals(jComboBoxprom.getSelectedItem().toString())){
                impuesto=txtiva12.getText();
            }
            else{
                impuesto=""+0;
            }
            //Costo y Ganancia
            String cost=""+costo;
            float ganancia=Float.parseFloat(monto)-costo-Float.parseFloat(impuesto);
            String gananci=""+ganancia;
            String fech=""+fecha;
            Balance balance = new Balance(1,numerofactura,nombres,ruc,monto,fech,vendedor,sinimpuesto,impuesto,propina,cost,gananci);
            balance.registrar();
            balance.consultar2();
            int nv=balance.numeroventa;
            numeroventa1=nv;
            costo=0;  
            //Modificar valor de articulos en el inventario
            modificacioninventario();
            //Datos del comprador
            //Datos del comprador
            String vector1[]=new String[5];
        String ruc1=txtruc.getText();
        String razonsocial=txtnombres.getText();
        String correo=txtcorreoelectronico.getText();
        String telefono=txttelefono.getText();
        String direccion=txtdireccion.getText();
        vector1[0]=ruc1;
        vector1[1]=razonsocial;
        vector1[2]=correo;
        vector1[3]=telefono;
        vector1[4]=direccion;
        //datos del producto
        int numerodefilas=tblProductos.getRowCount();
        Facturar crearxml=new Facturar();
        crearxml.cantidadproductos(numerodefilas);
        String matriz[][]=new String[numerodefilas][7];
        for(int i = 0; i < numerodefilas; i++) {
         for(int j = 0; j < 6; j++) {
          matriz[i][j]=tblProductos.getValueAt(i, j).toString();
        } 
        }
        for(int i = 0; i < numerodefilas; i++) {
          matriz[i][6]=jComboBoxprom.getSelectedItem().toString();
        }
        //Datos finales
        String vector3[]=new String[6];
        vector3[0]=txtbase0.getText();
        vector3[1]=txtbase12.getText();
        vector3[2]=txtiva12.getText();
        vector3[3]=txttotaldescuento.getText();
        vector3[4]=txtsubtotalsinimpuestos.getText();
        vector3[5]=txtvalortotal.getText();
            //Imprimir recibo
            String nfactura="SN";
            print pr= new print();
            pr.cantidadproductos(numerodefilas);
            String nimpresiones1="1";
            String nimpresiones2="2";
        if(nimpresiones1.equals(jComboBoxImprimir.getSelectedItem().toString())){
        pr.imprimir(nfactura,vector1,matriz,vector3,""+nv);
        }else{
          if(nimpresiones2.equals(jComboBoxImprimir.getSelectedItem().toString())){
        pr.imprimir(nfactura,vector1,matriz,vector3,""+nv);
        pr.imprimir(nfactura,vector1,matriz,vector3,""+nv);
        }else{
        }  
        }   
            limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Datos llenados Incorrectamente. Por favor, llenelos nuevamente");
        }
        
        
    }
    public void numeroEstablecimiento(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT DISTINCT(detallesfactura.numeroestablecimiento) FROM detallesfactura");
        rs=ps.executeQuery();
        while (rs.next()){
        jComboBoxNEstablecimiento.addItem(rs.getString("numeroestablecimiento"));
        }
        con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    public void numeroFacturero(){
    try{
        jComboBoxNFacturero.removeAllItems();
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT detallesfactura.numerofacturero FROM detallesfactura WHERE numeroestablecimiento="+jComboBoxNEstablecimiento.getSelectedItem());
        rs=ps.executeQuery();
        while (rs.next()){
        jComboBoxNFacturero.addItem(rs.getString("numerofacturero"));
        }
        con.close();
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    public void promocion(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * FROM promocion");
        rs=ps.executeQuery();
        while (rs.next()){
        jComboBoxprom.addItem(rs.getString("nombre"));
        }
        con.close();
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtruc = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        txtcorreoelectronico = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txtcodigoproducto = new javax.swing.JTextField();
        BotonCalcular = new javax.swing.JButton();
        BotonEliminarProducto = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txttotaldescuento = new javax.swing.JTextField();
        txtpropina = new javax.swing.JTextField();
        txtiva12 = new javax.swing.JTextField();
        txtvalortotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtsubtotalsinimpuestos = new javax.swing.JTextField();
        txtbase0 = new javax.swing.JTextField();
        txtbase12 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        botonEmitirFactura = new javax.swing.JButton();
        botonGenerarNuevaFactura = new javax.swing.JButton();
        BotonEmitirVenta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnumerodefactura = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxNEstablecimiento = new javax.swing.JComboBox<>();
        jComboBoxNFacturero = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxprom = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBoxImprimir = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxInventario = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        txtplazo = new javax.swing.JTextField();
        txtunidadtiempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1356, 780));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("DATOS COMPRADOR");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC O NUMERO DE CEDULA", "CONSUMIDOR FINAL" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("RUC/CEDULA");

        jLabel4.setText("NOMBRES");

        jLabel5.setText("CORREO ELECTRONICO");

        jLabel6.setText("TELEFONO");

        jLabel7.setText("DIRECCION");

        txtruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtrucKeyPressed(evt);
            }
        });

        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N
        jLabel19.setText("jLabel19");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnombres)
                                    .addComponent(txtcorreoelectronico)
                                    .addComponent(txttelefono)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(txtruc, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcorreoelectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("DATOS PRODUCTOS");

        tblProductos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Codigo", "Descripcion", "Precio Unitario $", "Descuento Uni $", "Total $"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setGridColor(new java.awt.Color(255, 255, 255));
        tblProductos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblProductosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblProductosMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductosMousePressed(evt);
            }
        });
        tblProductos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblProductosInputMethodTextChanged(evt);
            }
        });
        tblProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProductosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblProductosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jButton3.setText("AÑADIR +");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtcodigoproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoproductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoproductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoproductoKeyTyped(evt);
            }
        });

        BotonCalcular.setText("CALCULAR =");
        BotonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCalcularActionPerformed(evt);
            }
        });

        BotonEliminarProducto.setText("ELIMINAR");
        BotonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarProductoActionPerformed(evt);
            }
        });

        txtusuario.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtcodigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(BotonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(BotonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(BotonCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtcodigoproducto))
                .addGap(13, 13, 13))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("BASE 0%");

        jLabel12.setText("TOTAL DESCUENTO");

        jLabel13.setText("PROPINA");

        jLabel14.setText("BASE 12%");

        jLabel15.setText("IVA 12%");

        jLabel16.setText("VALOR TOTAL");

        txttotaldescuento.setEditable(false);
        txttotaldescuento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtpropina.setEditable(false);
        txtpropina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpropinaKeyReleased(evt);
            }
        });

        txtiva12.setEditable(false);
        txtiva12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtvalortotal.setEditable(false);
        txtvalortotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel18.setText("SUBTOTAL SIN IMPUESTOS");

        txtsubtotalsinimpuestos.setEditable(false);
        txtsubtotalsinimpuestos.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N

        txtbase0.setEditable(false);
        txtbase0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtbase12.setEditable(false);
        txtbase12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttotaldescuento)
                    .addComponent(txtpropina)
                    .addComponent(txtiva12)
                    .addComponent(txtvalortotal)
                    .addComponent(txtsubtotalsinimpuestos)
                    .addComponent(txtbase0)
                    .addComponent(txtbase12, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(txtsubtotalsinimpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtbase0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtbase12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttotaldescuento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtpropina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtiva12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel16))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtvalortotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        botonEmitirFactura.setText("EMITIR FACTURA");
        botonEmitirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmitirFacturaActionPerformed(evt);
            }
        });

        botonGenerarNuevaFactura.setText("GENERAR NUEVA FACTURA");
        botonGenerarNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarNuevaFacturaActionPerformed(evt);
            }
        });

        BotonEmitirVenta.setText("EMITIR VENTA");
        BotonEmitirVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEmitirVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(BotonEmitirVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEmitirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(botonGenerarNuevaFactura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonEmitirFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(BotonEmitirVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonGenerarNuevaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PRODUCCION", "PRUEBAS" }));

        jLabel9.setText("NUMERO DE ESTABLECIMIENTO:");

        jLabel10.setText("NUMERO DE FACTURERO:");

        txtnumerodefactura.setEditable(false);

        jLabel8.setText("NUMERO DE FACTURA:");

        jComboBoxNEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNEstablecimientoActionPerformed(evt);
            }
        });

        jComboBoxNFacturero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNFactureroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnumerodefactura)
                    .addComponent(jComboBoxNEstablecimiento, 0, 175, Short.MAX_VALUE)
                    .addComponent(jComboBoxNFacturero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxNEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNFacturero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumerodefactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("DESCUENTOS");

        jComboBoxprom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        jComboBoxprom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxpromActionPerformed(evt);
            }
        });
        jComboBoxprom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxpromKeyPressed(evt);
            }
        });

        jLabel20.setText("IMPRIMIR");

        jComboBoxImprimir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "0", "2" }));

        jLabel22.setText("INVENTARIO");

        jComboBoxInventario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MODIFICAR", "NO MODIFICAR" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxprom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxImprimir, 0, 87, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxInventario, 0, 1, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxprom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setText("FORMAS DE PAGO");

        jLabel23.setText("PLAZO");

        jLabel24.setText("UNIDAD DE TIEMPO");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OTROS CON UTILIZACION DEL SISTEMA FINANCIERO", "SIN UTILIZACION DEL SISTEMA FINANCIERO", "COMPENSACION DE DEUDAS", "TARJETA DE DEBITO", "DINERO ELECTRONICO", "TARJETA PREPAGO", "TARJETA DE CREDITO", "ENDOSO DE TITULOS" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtplazo)
                    .addComponent(txtunidadtiempo)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtunidadtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtplazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String comparar="CONSUMIDOR FINAL";
        if(comparar.equals(jComboBox1.getSelectedItem().toString())){
           txtruc.setText("9999999999999");
           txtnombres.setText("CONSUMIDOR FINAL");
           txtcorreoelectronico.setText("NO APLICA");
           txttelefono.setText("NO APLICA");
           txtdireccion.setText("NO APLICA");  
           txtruc.setEnabled(false);
           txtnombres.setEnabled(false);
           txtcorreoelectronico.setEnabled(false);
           txttelefono.setEnabled(false);
           txtdireccion.setEnabled(false);
          }else{      
         txtruc.setEnabled(true);
         txtnombres.setEnabled(true);
           txtcorreoelectronico.setEnabled(true);
           txttelefono.setEnabled(true);
           txtdireccion.setEnabled(true);
           txtruc.setText("");
           txtnombres.setText("");
           txtcorreoelectronico.setText("");
           txttelefono.setText("");
           txtdireccion.setText("");
          }  
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtrucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtrucKeyPressed
        
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            int longitud2= txtruc.getText().length();
            if(longitud2==0){
            JOptionPane.showMessageDialog(null, "El campo RUC/CEDULA esta vacio");
            }else{
                int longitud = txtruc.getText().length();
                if (longitud==13 || longitud==10){
                busquedaClientes();
                }else{
                JOptionPane.showMessageDialog(null, "El campo RUC/CEDULA es incorrecto");
                }
            
            }
        
        }
        
    }//GEN-LAST:event_txtrucKeyPressed

    private void botonGenerarNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarNuevaFacturaActionPerformed
           limpiar();
        
    }//GEN-LAST:event_botonGenerarNuevaFacturaActionPerformed

    private void jComboBoxpromKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxpromKeyPressed
        
    }//GEN-LAST:event_jComboBoxpromKeyPressed

    private void jComboBoxpromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxpromActionPerformed
        
        if(auxi>0){
        limpiarDatosFinales();
        int verificador = verificarDatosEstenLlenosProducto();
        if (verificador==0){
            calculovalores();
        }else{
        JOptionPane.showMessageDialog(null, "Datos del Producto Incorrectos. Por favor, llenelos nuevamente");
        }
        }else{
            
        }
        auxi=auxi+1; 
    }//GEN-LAST:event_jComboBoxpromActionPerformed

    private void botonEmitirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmitirFacturaActionPerformed
        
        int verificador = verificarDatosEstenLlenosComprador();
        int verificador1 = verificarDatosEstenLlenosProducto();
        try {
            if (verificador==0&&verificador1==0){
            tomaDatos();
            }else{
            JOptionPane.showMessageDialog(null, "Datos llenados Incorrectamente. Por favor, llenelos nuevamente");
            }
            
        } catch (SAXException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (Exception ex) {
                Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_botonEmitirFacturaActionPerformed

    private void tblProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyPressed
        
    }//GEN-LAST:event_tblProductosKeyPressed

    private void tblProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseEntered
      
    }//GEN-LAST:event_tblProductosMouseEntered

    private void tblProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblProductosKeyTyped

    private void tblProductosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblProductosAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblProductosAncestorAdded

    private void tblProductosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblProductosInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblProductosInputMethodTextChanged

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked

    }//GEN-LAST:event_tblProductosMouseClicked

    private void tblProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblProductosMousePressed

    private void tblProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyReleased
        
    }//GEN-LAST:event_tblProductosKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       AñadirProductoenFacturacion pro;
        pro = new AñadirProductoenFacturacion();
        pro.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtpropinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpropinaKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        int verificador = verificarDatosEstenLlenosProducto();
        if (verificador==0){
            calculovalores();
        }else{
        JOptionPane.showMessageDialog(null, "Datos del Producto Incorrectos. Por favor, llenelos nuevamente");
        }
        }
    }//GEN-LAST:event_txtpropinaKeyReleased

    private void txtcodigoproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoproductoKeyTyped
        // Accion de buscar un producto
        
    }//GEN-LAST:event_txtcodigoproductoKeyTyped

    private void txtcodigoproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoproductoKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            // Accion de buscar un producto
        String codigo = txtcodigoproducto.getText();
        Cosas producto = new Cosas(1,codigo,null,1,1,1,1,"","");
        producto.consultar3();
        if(producto.Descripcion==null){
            JOptionPane.showMessageDialog(null, "Este producto no esta registrado");
            txtcodigoproducto.setText("");
        }else{
            
            int cantidad=1;
            //String codigo1=producto.codigo;
            String descripcion=producto.Descripcion;
            Float preciounitario=producto.valorFinal;
            float ax1=producto.valorFinal;
            if(preciounitario<=0){
                JOptionPane.showMessageDialog(null, "No se puede añadir este producto");
            }else{
                 //Calculo del descuento
            float aux2=Float.parseFloat(producto.descuento);
            if(aux2<0){
                aux2=0;
            }
            Float aux3=ax1*aux2/100;
            BigDecimal db= new BigDecimal(aux3).setScale(2, RoundingMode.HALF_UP);
            double val2=db.doubleValue();
            float valortotal45=ax1-aux3;
            BigDecimal db7= new BigDecimal(valortotal45).setScale(2, RoundingMode.HALF_UP);
            double val7=db7.doubleValue();
            DefaultTableModel modeloTabla= (DefaultTableModel) Facturacion.tblProductos.getModel();
        modeloTabla.getRowCount();
        modeloTabla.setRowCount(modeloTabla.getRowCount());
        Object[]vec= new Object[6];
        vec[0]=cantidad;
        vec[1]=codigo;
        vec[2]=descripcion;
        vec[3]=producto.valorFinal;
        vec[4]=val2;
        vec[5]=val7;
        modeloTabla.addRow(vec);
            }
        txtcodigoproducto.setText("");
        }
        
        }
        
    }//GEN-LAST:event_txtcodigoproductoKeyPressed

    private void txtcodigoproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoproductoKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcodigoproductoKeyReleased

    private void BotonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCalcularActionPerformed
        // TODO add your handling code here:
        calculovalores1();
    }//GEN-LAST:event_BotonCalcularActionPerformed

    private void BotonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarProductoActionPerformed
        // TODO add your handling code here:
        int fsel;
        try{
        fsel= tblProductos.getSelectedRow();
        if(fsel==-1){
        JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a Eliminar");
        }else{
            DefaultTableModel m = (DefaultTableModel)tblProductos.getModel();
            m.removeRow(fsel);
            
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se elimino el producto ");
        }
       
        
    }//GEN-LAST:event_BotonEliminarProductoActionPerformed

    private void BotonEmitirVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEmitirVentaActionPerformed
            try {
                // TODO add your handling code here:
                emitirventa();
            } catch (SAXException ex) {
                Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (XPathExpressionException ex) {
                Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_BotonEmitirVentaActionPerformed

    private void jComboBoxNEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNEstablecimientoActionPerformed
        // TODO add your handling code here:
        numeroFacturero();
        numerofacturas();
    }//GEN-LAST:event_jComboBoxNEstablecimientoActionPerformed

    private void jComboBoxNFactureroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNFactureroActionPerformed
        // TODO add your handling code here:
        numerofacturas();
    }//GEN-LAST:event_jComboBoxNFactureroActionPerformed



    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCalcular;
    private javax.swing.JButton BotonEliminarProducto;
    private javax.swing.JButton BotonEmitirVenta;
    private javax.swing.JButton botonEmitirFactura;
    private javax.swing.JButton botonGenerarNuevaFactura;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBoxImprimir;
    private javax.swing.JComboBox<String> jComboBoxInventario;
    private javax.swing.JComboBox<String> jComboBoxNEstablecimiento;
    private javax.swing.JComboBox<String> jComboBoxNFacturero;
    private javax.swing.JComboBox<String> jComboBoxprom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtbase0;
    private javax.swing.JTextField txtbase12;
    private javax.swing.JTextField txtcodigoproducto;
    private javax.swing.JTextField txtcorreoelectronico;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtiva12;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txtnumerodefactura;
    private javax.swing.JTextField txtplazo;
    private javax.swing.JTextField txtpropina;
    private javax.swing.JTextField txtruc;
    private javax.swing.JTextField txtsubtotalsinimpuestos;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttotaldescuento;
    private javax.swing.JTextField txtunidadtiempo;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JTextField txtvalortotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        AñadirProductoenFacturacion pro = new AñadirProductoenFacturacion();
        pro.setVisible(true);
        
    }
}
