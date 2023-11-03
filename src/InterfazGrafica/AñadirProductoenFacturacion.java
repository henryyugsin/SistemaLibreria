
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

public class AñadirProductoenFacturacion extends javax.swing.JFrame {

public int cantidad;
public String codigo;
public String descripcion;
public float preciounitario;
public float descuento;
    public AñadirProductoenFacturacion() {
        initComponents();
        txtcantidad.setText("1");
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
        txtcantidad = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        txtpreciounitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblservicios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Añadir = new javax.swing.JButton();
        buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("CANTIDAD");

        jLabel2.setText("CODIGO");

        jLabel3.setText("DESCRIPCION");

        jLabel4.setText("PRECIO UNITARIO $");

        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoKeyReleased(evt);
            }
        });

        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyReleased(evt);
            }
        });

        jLabel5.setText("DESCUENTO $");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpreciounitario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdescuento))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtpreciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tblservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCION", "PRECIO UNITARIO $"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        if (tblservicios.getColumnModel().getColumnCount() > 0) {
            tblservicios.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblservicios.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblservicios.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblservicios.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Añadir)
                .addGap(28, 28, 28)
                .addComponent(buscar)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblserviciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblserviciosMouseClicked
        int fila=tblservicios.getSelectedRow();
        String codigo2=tblservicios.getValueAt(fila, 1).toString();
        Cosas producto = new Cosas(1,codigo2,null,1,1,1,1,"","");
        producto.consultar3();
        txtcodigo.setText(""+codigo2);
        txtdescripcion.setText(producto.Descripcion);
        float ax1=producto.valorFinal;
        //BigDecimal db1= new BigDecimal(ax1).setScale(2, RoundingMode.HALF_UP);
        //double val3=db1.doubleValue();
        txtpreciounitario.setText(""+producto.valorFinal);
        float aux2=Float.parseFloat(producto.descuento);
        Float aux3=ax1*aux2/100;
        BigDecimal db= new BigDecimal(aux3).setScale(2, RoundingMode.HALF_UP);
        double val2=db.doubleValue();
        if(val2<0){
            txtdescuento.setText("0.0");
        }else{
        txtdescuento.setText(""+val2);
        }
        
        
    }//GEN-LAST:event_tblserviciosMouseClicked

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        cantidad=Integer.parseInt(txtcantidad.getText());
        codigo=txtcodigo.getText();
        descripcion=txtdescripcion.getText();
        preciounitario=Float.parseFloat(txtpreciounitario.getText());
        descuento=Float.parseFloat(txtdescuento.getText());
        if(preciounitario<=0){
            JOptionPane.showMessageDialog(null,"El precio unitario no puede ser 0");
        }else{
            double total=cantidad*preciounitario-descuento;
        BigDecimal db= new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        double val2=db.doubleValue();
        DefaultTableModel modeloTabla= (DefaultTableModel) Facturacion.tblProductos.getModel();
        modeloTabla.getRowCount();
        modeloTabla.setRowCount(modeloTabla.getRowCount());
        Object[]vec= new Object[6];
        vec[0]=cantidad;
        vec[1]=codigo;
        vec[2]=descripcion;
        vec[3]=preciounitario;
        vec[4]=descuento;
        vec[5]=val2;
        modeloTabla.addRow(vec);
        this.setVisible(false);   
        }
        
    }//GEN-LAST:event_AñadirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String codigo = txtcodigo.getText();
        Cosas producto = new Cosas(1,codigo,null,1,1,1,1,"","");
        producto.consultar();
        txtcantidad.setText("1");
        txtcodigo.setText(""+producto.codigo);
        txtdescripcion.setText(producto.Descripcion);
        txtpreciounitario.setText(""+producto.valorFinal);
        txtdescuento.setText("0");
    }//GEN-LAST:event_buscarActionPerformed

    private void txtcodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyReleased
    
    }//GEN-LAST:event_txtcodigoKeyReleased

    private void txtdescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyReleased
     
    }//GEN-LAST:event_txtdescripcionKeyReleased

    private void txtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyPressed
        // TODO add your handling code here:
    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
    String aux=""+txtcodigo.getText();
    DefaultTableModel modeloTabla= (DefaultTableModel) tblservicios.getModel();
    modeloTabla.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
    Connection con =  ConexionMySQL.getConexion();
    ps = con.prepareStatement("SELECT productos.id, productos.codigo, productos.descripcion, productos.valorfinal FROM productos WHERE codigo Like'%"+aux+"%'");
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
    }//GEN-LAST:event_txtcodigoKeyPressed

    private void txtdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyPressed
        // TODO add your handling code here:
    if (evt.getKeyCode()==KeyEvent.VK_ENTER){
    String aux=""+txtdescripcion.getText();
    DefaultTableModel modeloTabla= (DefaultTableModel) tblservicios.getModel();
    modeloTabla.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
    Connection con =  ConexionMySQL.getConexion();
    ps = con.prepareStatement("SELECT productos.id, productos.codigo, productos.descripcion, productos.valorfinal FROM productos WHERE descripcion Like'%"+aux+"%'");
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
    }//GEN-LAST:event_txtdescripcionKeyPressed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirProductoenFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadir;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblservicios;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtpreciounitario;
    // End of variables declaration//GEN-END:variables
}
