
package InterfazGrafica;

import BasedeDatos.ConexionMySQL;
import bimax3.pkg0.Cosas;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InterfazProductos extends javax.swing.JFrame {

    public InterfazProductos() {
        initComponents();
        limpiar();
        cargarTabla();
        txtid.setEnabled(false);
        //txtvalorfinal.setEditable(false);
        Color c1= new Color(0xCDCDC0); 
        Color c2= new Color(0x336b87); 
        Color c3= new Color(0xBBC3C6);
        this.getContentPane().setBackground(c1);
        jPanel2.setBackground(c3);
        jPanel1.setBackground(c3);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        txtcosto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtvalorganancia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtvalorfinal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUnidadesDisponibles = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtiva = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Añadir = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblservicios = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("ID");

        jLabel2.setText("CODIGO");

        jLabel3.setText("DESCRIPCION");

        jLabel4.setText("COSTO $");

        txtcosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcostoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcostoKeyReleased(evt);
            }
        });

        jLabel5.setText("VALOR GANANCIA $");

        txtvalorganancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtvalorgananciaKeyPressed(evt);
            }
        });

        jLabel6.setText("VALOR FINAL $");

        jLabel7.setText("Unidades ");

        jLabel8.setText("IVA %");

        jLabel9.setText("DESCUENTO %");

        txtdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUnidadesDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(txtid)
                    .addComponent(txtcodigo)
                    .addComponent(txtdescripcion)
                    .addComponent(txtcosto)
                    .addComponent(txtvalorganancia)
                    .addComponent(txtiva)
                    .addComponent(txtvalorfinal))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUnidadesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5))
                    .addComponent(txtvalorganancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtvalorfinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));

        Añadir.setText("Añadir");
        Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Añadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(eliminar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(buscar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Añadir)
                    .addComponent(buscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar)
                    .addComponent(eliminar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tblservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "Cantidad Unidades", "COSTO", "VALOR GANANCIA", "IVA", "DESCUENTO", "VALOR FINAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblservicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblserviciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblservicios);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblserviciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblserviciosMouseClicked
        int fila=tblservicios.getSelectedRow();
        String codigo=tblservicios.getValueAt(fila, 1).toString();
        Cosas producto = new Cosas(1,codigo,null,1,1,1,1,"","");
        producto.consultar();
        txtid.setText(""+producto.id);
        txtcodigo.setText(""+producto.codigo);
        txtdescripcion.setText(producto.Descripcion);
        txtcosto.setText(""+producto.costo);
        txtvalorganancia.setText(""+producto.valorGanancia);
        txtvalorfinal.setText(""+producto.valorFinal);
        txtUnidadesDisponibles.setText(""+producto.cantidadunidades);
        txtiva.setText(""+producto.iva);
        txtdescuento.setText(""+producto.descuento);
    }//GEN-LAST:event_tblserviciosMouseClicked

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        String codigo = txtcodigo.getText();
        String descripcion = txtdescripcion.getText();
        float costo = Float.parseFloat(txtcosto.getText());
        float valorganancia = Float.parseFloat(txtvalorganancia.getText());
        float valorfinal = Float.parseFloat(txtvalorfinal.getText());
        int cantidadunidades = Integer.parseInt(txtUnidadesDisponibles.getText());
        String iva=txtiva.getText();
        String descuento=txtdescuento.getText();
        Cosas producto = new Cosas(1,codigo,descripcion,costo,valorganancia,valorfinal,cantidadunidades,iva,descuento);
        producto.registrar();
        limpiar();
        cargarTabla();
    }//GEN-LAST:event_AñadirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String codigo = txtcodigo.getText();
        Cosas producto = new Cosas(1,codigo,null,1,1,1,1,"","");
        producto.consultar();
        txtid.setText(""+producto.id);
        txtcodigo.setText(""+producto.codigo);
        txtdescripcion.setText(producto.Descripcion);
        txtcosto.setText(""+producto.costo);
        txtvalorganancia.setText(""+producto.valorGanancia);
        txtvalorfinal.setText(""+producto.valorFinal);
        txtUnidadesDisponibles.setText(""+producto.cantidadunidades);
        txtiva.setText(""+producto.iva);
        txtdescuento.setText(""+producto.descuento);
    }//GEN-LAST:event_buscarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

        String descripcion = txtdescripcion.getText();
        float costo = Float.parseFloat(txtcosto.getText());
        int fila=tblservicios.getSelectedRow();
        String codigo=tblservicios.getValueAt(fila, 1).toString();
        float valorganancia = Float.parseFloat(txtvalorganancia.getText());
        float valorfinal = Float.parseFloat(txtvalorfinal.getText());
        int cantidadunidades = Integer.parseInt(txtUnidadesDisponibles.getText());
        String iva=txtiva.getText();
        String descuento=txtdescuento.getText();
        Cosas producto = new Cosas(1,codigo,descripcion,costo,valorganancia,valorfinal,cantidadunidades,iva,descuento);
        producto.modificar();
        limpiar();
        cargarTabla();
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int fila=tblservicios.getSelectedRow();
        String codigo=tblservicios.getValueAt(fila, 1).toString();
        Cosas producto = new Cosas(1,codigo,null,1,1,1,1,"","");
        producto.eliminar();
        limpiar();
        cargarTabla();
    }//GEN-LAST:event_eliminarActionPerformed

    private void txtcostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcostoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
        String costo = txtcosto.getText();
        String valorganancia = txtvalorganancia.getText();
        if (costo.length()>0 && valorganancia.length()>0){
            //calcularvalorfinal();
        }else{
      
        }
        }
    }//GEN-LAST:event_txtcostoKeyPressed

    private void txtvalorgananciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorgananciaKeyPressed
        // TODO add your handling code here:
        /*String costo = txtcosto.getText();
        String valorganancia = txtvalorganancia.getText();
        if (costo.length()>0 && valorganancia.length()>0){
            calcularvalorfinal();
        }else{
      
        }*/
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            String costo = txtcosto.getText();
        String valorganancia = txtvalorganancia.getText();
        if (costo.length()>0 && valorganancia.length()>0){
            //calcularvalorfinal();
        }else{
      
        }
        }
        
    }//GEN-LAST:event_txtvalorgananciaKeyPressed

    private void txtdescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyPressed
        // TODO add your handling code here:
        //calcularvalorfinal();
    }//GEN-LAST:event_txtdescuentoKeyPressed

    private void txtcostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcostoKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcostoKeyReleased
private void calcularvalorfinal(){
        float costo = Float.parseFloat(txtcosto.getText());
        float valorganancia = Float.parseFloat(txtvalorganancia.getText());
        float descuento = Float.parseFloat(txtdescuento.getText());
        if(descuento<0){
        descuento=0;
        }
        float valorfinal;
        if (costo>0 && valorganancia>=0){
        float caux2=(costo+valorganancia)*descuento/100;
        BigDecimal db1= new BigDecimal(caux2).setScale(2, RoundingMode.HALF_UP);
        double val3=db1.doubleValue();
        float val4 = Float.parseFloat(""+val3);
        valorfinal=costo+valorganancia-val4;
        BigDecimal db= new BigDecimal(valorfinal).setScale(2, RoundingMode.HALF_UP);
        double val2=db.doubleValue();
        txtvalorfinal.setText(""+val2);
        }else{
            JOptionPane.showMessageDialog(null, "El campo Costo o Ganancia estan vacios");
        }
        
}
    private void cargarTabla(){
    DefaultTableModel modeloTabla= (DefaultTableModel) tblservicios.getModel();
    modeloTabla.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
    Connection con =  ConexionMySQL.getConexion();
    ps = con.prepareStatement("""
                              SELECT * 
                              FROM productos;""");
   rs=ps.executeQuery();
   rsmd=(ResultSetMetaData) rs.getMetaData();
   columnas=rsmd.getColumnCount();
   while(rs.next()){
   Object[] fila = new Object[columnas];
   for (int indice=0;indice<columnas;indice++){
   fila[indice]=rs.getObject(indice+1);
   }
   modeloTabla.addRow(fila);
   }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
    }
    }
private void limpiar(){
    txtid.setText("");
    txtcodigo.setText("");
    txtdescripcion.setText("");
    txtcosto.setText("");
    txtvalorganancia.setText("");
    txtvalorfinal.setText("");
    txtUnidadesDisponibles.setText("");
    txtiva.setText("");
    txtdescuento.setText("");
}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadir;
    private javax.swing.JButton buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tblservicios;
    private javax.swing.JTextField txtUnidadesDisponibles;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcosto;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtvalorfinal;
    private javax.swing.JTextField txtvalorganancia;
    // End of variables declaration//GEN-END:variables
}
