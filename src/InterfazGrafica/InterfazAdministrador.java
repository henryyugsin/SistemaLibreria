
package InterfazGrafica;

import BasedeDatos.ConexionMySQL;
import bimax3.pkg0.Administrador;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class InterfazAdministrador extends javax.swing.JFrame {
String ubicacionfirma;
    public InterfazAdministrador() {
        initComponents();
        this.setExtendedState(6);
        cargardatos();
        numeroEstablecimiento(); 
        numeroFacturero();
        numerofacturas();
        Color c1= new Color(0xCDCDC0); 
        Color c2= new Color(0x336b87); 
        Color c3= new Color(0xBBC3C6);
        this.getContentPane().setBackground(c1);
        jPanel2.setBackground(c3);
        jPanel1.setBackground(c3);
        jPanel4.setBackground(c3);
        jPanel3.setBackground(c3);
        jPanel1.setBackground(c3);
        jPanel5.setBackground(c3);
    }
    public void numerofacturas(){
        txtNumerodeFacturasEmitidas.setEnabled(false);
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT detallesfactura.numerofactura FROM detallesfactura WHERE numeroestablecimiento="+jComboBoxNEstablecimiento.getSelectedItem()+" and NUMEROFACTURERO="+jComboBoxNFacturero.getSelectedItem());
        rs=ps.executeQuery();
        while (rs.next()){
        txtNumerodeFacturasEmitidas.setText(rs.getString("numerofactura"));
        }
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        GUARDARDATOS = new javax.swing.JButton();
        txtActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtemail = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttipocontribuyente = new javax.swing.JTextField();
        txtcontabilidad = new javax.swing.JTextField();
        txtfirmaelectronica = new javax.swing.JTextField();
        textruc = new javax.swing.JTextField();
        textrazonsocial = new javax.swing.JTextField();
        firmaelectronica = new javax.swing.JButton();
        txtnombrecomercial = new javax.swing.JTextField();
        txtciudadmatriz = new javax.swing.JTextField();
        txtcontraseñafirmaelectronica = new javax.swing.JPasswordField();
        txtcontraseñacorreo = new javax.swing.JTextField();
        txtcarpetafactura = new javax.swing.JTextField();
        btncarpeta = new javax.swing.JButton();
        txtlogo = new javax.swing.JTextField();
        jButtonlogo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNumerodeFacturasEmitidas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxNEstablecimiento = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jcomboboxnfacturero = new javax.swing.JLabel();
        jComboBoxNFacturero = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnproducto = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setExtendedState(6);

        GUARDARDATOS.setText("GUARDAR ");
        GUARDARDATOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUARDARDATOSActionPerformed(evt);
            }
        });

        txtActualizar.setText("ACTUALIZAR");
        txtActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(GUARDARDATOS, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(txtActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GUARDARDATOS)
                    .addComponent(txtActualizar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setText("RUC");

        jLabel3.setText("RAZON SOCIAL");

        jLabel5.setText("CORREO ELECTRONICO");

        jLabel6.setText("TELEFONO");

        jLabel7.setText("DIRECCION MATRIZ");

        jLabel8.setText("TIPO CONTRIBUYENTE");

        jLabel9.setText("OBLIGADO CONTABILIDAD");

        jLabel10.setText("FIRMA ELECTRONICA");

        jLabel11.setText("CONTRASEÑA FIRMA ELECTRONICA");

        jLabel1.setText("NOMBRE COMERCIAL");

        jLabel13.setText("CIUDAD MATRIZ");

        jLabel14.setText("CONTRASEÑA CORREO");

        jLabel15.setText("CARPETA FACTURA");

        jLabel16.setText("LOGO EMPRESA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addGap(30, 30, 30)
                .addComponent(jLabel15)
                .addGap(21, 21, 21)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });

        txtfirmaelectronica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfirmaelectronicaActionPerformed(evt);
            }
        });

        textrazonsocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textrazonsocialActionPerformed(evt);
            }
        });

        firmaelectronica.setText("AÑADIR FIRMA");
        firmaelectronica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firmaelectronicaActionPerformed(evt);
            }
        });

        txtnombrecomercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombrecomercialActionPerformed(evt);
            }
        });

        txtcontraseñafirmaelectronica.setText("jPasswordField1");

        btncarpeta.setText("AÑADIR CARPETA");
        btncarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarpetaActionPerformed(evt);
            }
        });

        jButtonlogo.setText("AÑADIR LOGO");
        jButtonlogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonlogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtlogo)
                    .addComponent(txtcontraseñacorreo)
                    .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtcontraseñafirmaelectronica, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtciudadmatriz, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(txtnombrecomercial, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(textruc)
                    .addComponent(textrazonsocial)
                    .addComponent(txtemail)
                    .addComponent(txtdireccion)
                    .addComponent(txttipocontribuyente)
                    .addComponent(txtcontabilidad)
                    .addComponent(txtfirmaelectronica)
                    .addComponent(txtcarpetafactura))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firmaelectronica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncarpeta, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jButtonlogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textrazonsocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtciudadmatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txttipocontribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtcontabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfirmaelectronica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firmaelectronica))
                .addGap(22, 22, 22)
                .addComponent(txtcontraseñafirmaelectronica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtcontraseñacorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcarpetafactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncarpeta))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonlogo))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel4.setText("NUMERO DE FACTURAS EMITIDAS");

        jLabel12.setText("NUMERO DE ESTABLECIMIENTO");

        jComboBoxNEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNEstablecimientoActionPerformed(evt);
            }
        });

        jButton1.setText("AÑADIR ESTABLECIMIENTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcomboboxnfacturero.setText("NUMERO DE FACTURERO");

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
                .addGap(73, 73, 73)
                .addComponent(jComboBoxNEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jComboBoxNFacturero, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcomboboxnfacturero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addComponent(txtNumerodeFacturasEmitidas, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addGap(26, 26, 26)
                .addComponent(jComboBoxNEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jcomboboxnfacturero)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxNFacturero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumerodeFacturasEmitidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnproducto.setText("AÑADIR OFERTA A PRODUCTO");
        btnproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductoActionPerformed(evt);
            }
        });

        jButton2.setText("USUARIOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnproducto, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N
        jLabel17.setText("jLabel17");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GUARDARDATOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUARDARDATOSActionPerformed
        
        String ruc = textruc.getText();
        String razonsocial=textrazonsocial.getText();
        String nombrecomercial=txtnombrecomercial.getText();
        String correoelectronico = txtemail.getText();
        int telefono = Integer.parseInt(txttelefono.getText());
        String direccion = txtdireccion.getText();
        String ciudad = txtciudadmatriz.getText();
        String tipocontribuyente = txttipocontribuyente.getText();
        String contabilidad = txtcontabilidad.getText();
        String ubicacionfirma1=ubicacionfirma;
        String contraseñafirmaelectronica=txtcontraseñafirmaelectronica.getText();
        String contraseñacorreo=txtcontraseñacorreo.getText();
        String ubicacionfirma=txtcarpetafactura.getText();
        String ubicacionlogo=txtlogo.getText();
        Administrador admi = new Administrador(ruc,razonsocial,nombrecomercial,correoelectronico,telefono,direccion,ciudad,tipocontribuyente,contabilidad,ubicacionfirma1,contraseñafirmaelectronica,contraseñacorreo,ubicacionfirma,ubicacionlogo);
        admi.añadir();
        //cargar();
    }//GEN-LAST:event_GUARDARDATOSActionPerformed

    private void txtActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualizarActionPerformed
        String ruc = textruc.getText();
        String razonsocial=textrazonsocial.getText();
        String nombrecomercial=txtnombrecomercial.getText();
        String correoelectronico = txtemail.getText();
        int telefono = Integer.parseInt(txttelefono.getText());
        String direccion = txtdireccion.getText();
        String ciudad = txtciudadmatriz.getText();
        String tipocontribuyente = txttipocontribuyente.getText();
        String contabilidad = txtcontabilidad.getText();
        String ubicacionfirma1=txtfirmaelectronica.getText();
        String contraseñafirmaelectronica=txtcontraseñafirmaelectronica.getText();
        String contraseñacorreo=txtcontraseñacorreo.getText();
        String ubicacionfirma=txtcarpetafactura.getText();
        String ubicacionlogo=txtlogo.getText();
        Administrador admi = new Administrador(ruc,razonsocial,nombrecomercial,correoelectronico,telefono,direccion,ciudad,tipocontribuyente,contabilidad,ubicacionfirma1,contraseñafirmaelectronica,contraseñacorreo,ubicacionfirma,ubicacionlogo);
        admi.modificar();
        
    }//GEN-LAST:event_txtActualizarActionPerformed

    private void firmaelectronicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firmaelectronicaActionPerformed
        JFileChooser escoger = new JFileChooser();
        escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = escoger.showOpenDialog(null);
        if (estado ==JFileChooser.APPROVE_OPTION){
            File archivo = escoger.getSelectedFile();
            try {
                ubicacionfirma=archivo.getCanonicalPath();
                txtfirmaelectronica.setText(ubicacionfirma);
            } catch (IOException ex) {
                Logger.getLogger(InterfazAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_firmaelectronicaActionPerformed

    private void textrazonsocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textrazonsocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textrazonsocialActionPerformed

    private void txtfirmaelectronicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfirmaelectronicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfirmaelectronicaActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void btncarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarpetaActionPerformed
        // TODO add your handling code here:
        JFileChooser escoger = new JFileChooser();
        escoger.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int estado = escoger.showOpenDialog(null);
        if (estado ==JFileChooser.APPROVE_OPTION){
            File archivo = escoger.getSelectedFile();
            try {
                ubicacionfirma=archivo.getCanonicalPath();
                txtcarpetafactura.setText(ubicacionfirma);
            } catch (IOException ex) {
                Logger.getLogger(InterfazAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btncarpetaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AñadirEstablecimiento estab = new AñadirEstablecimiento();
        estab.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxNFactureroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNFactureroActionPerformed
        // TODO add your handling code here:
        numerofacturas();
    }//GEN-LAST:event_jComboBoxNFactureroActionPerformed

    private void jComboBoxNEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNEstablecimientoActionPerformed
        // TODO add your handling code here:
        numeroFacturero();
        numerofacturas();
    }//GEN-LAST:event_jComboBoxNEstablecimientoActionPerformed

    private void txtnombrecomercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombrecomercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrecomercialActionPerformed

    private void btnproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductoActionPerformed
        // TODO add your handling code here:
        AñadirPromocion pro= new AñadirPromocion();
        pro.setVisible(true);
    }//GEN-LAST:event_btnproductoActionPerformed

    private void jButtonlogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonlogoActionPerformed
        // TODO add your handling code here:
        JFileChooser escoger = new JFileChooser();
        escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = escoger.showOpenDialog(null);
        if (estado ==JFileChooser.APPROVE_OPTION){
            File archivo = escoger.getSelectedFile();
            try {
                ubicacionfirma=archivo.getCanonicalPath();
                txtlogo.setText(ubicacionfirma);
            } catch (IOException ex) {
                Logger.getLogger(InterfazAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonlogoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Usuarios usu1= new Usuarios();
        usu1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    public void cargardatos(){
    Administrador admi = new Administrador(null,null,null,null,1,null,null,null,null,null,null,null,null,null);
    admi.consultar();
    textruc.setText(""+admi.RUC);
    textrazonsocial.setText(admi.RazonSocial);
    txtnombrecomercial.setText(admi.NombreComercial);
    txtemail.setText(admi.CorreoElectronico);
    txttelefono.setText(""+admi.telefono);
    txtdireccion.setText(admi.Direccion);
    txtciudadmatriz.setText(admi.Ciudad);
    txttipocontribuyente.setText(admi.TipoContribuyente);
    txtcontabilidad.setText(admi.Contabilidad);
    txtfirmaelectronica.setText(admi.UbicacionFirma);
    txtcontraseñafirmaelectronica.setText(admi.ContraseñaFirmaElectronica);
    txtcontraseñacorreo.setText(admi.ContraseñaCorreo);
    txtcarpetafactura.setText(admi.UbicacionFactura);
    txtlogo.setText(admi.UbicacionLogo);
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
        }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GUARDARDATOS;
    private javax.swing.JButton btncarpeta;
    private javax.swing.JButton btnproducto;
    private javax.swing.JButton firmaelectronica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonlogo;
    private javax.swing.JComboBox<String> jComboBoxNEstablecimiento;
    private javax.swing.JComboBox<String> jComboBoxNFacturero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jcomboboxnfacturero;
    private javax.swing.JTextField textrazonsocial;
    private javax.swing.JTextField textruc;
    private javax.swing.JButton txtActualizar;
    private javax.swing.JTextField txtNumerodeFacturasEmitidas;
    private javax.swing.JTextField txtcarpetafactura;
    private javax.swing.JTextField txtciudadmatriz;
    private javax.swing.JTextField txtcontabilidad;
    private javax.swing.JTextField txtcontraseñacorreo;
    private javax.swing.JPasswordField txtcontraseñafirmaelectronica;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfirmaelectronica;
    private javax.swing.JTextField txtlogo;
    private javax.swing.JTextField txtnombrecomercial;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttipocontribuyente;
    // End of variables declaration//GEN-END:variables
}
