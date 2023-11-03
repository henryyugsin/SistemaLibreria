
package InterfazGrafica;

import BasedeDatos.ConexionMySQL;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazBalance extends javax.swing.JFrame {
    private String dato;
    private int idusu;
    private int cont=0;
    private Date dti;
    private Date dtf;
    public InterfazBalance() {
        initComponents();
        promocion();
        Color c1= new Color(0xCDCDC0); 
        Color c2= new Color(0xCDCDC0); 
        Color c3= new Color(0xBBC3C6); 
        this.getContentPane().setBackground(c1);
        jPanel1.setBackground(c2);
    }
public void setdato(int idusu, String dato){
    this.dato=dato;
    this.idusu=idusu;
    txtusuario.setText(dato);
    if(idusu==1){   
        jComboBoxvendedor.setSelectedItem("TODOS");
        }else{
        jComboBoxvendedor.setEnabled(false);
        jComboBoxvendedor.setSelectedItem(dato);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnumerodeventas = new javax.swing.JTextField();
        txtvalortotalvendido = new javax.swing.JTextField();
        jDateInicio = new com.toedter.calendar.JDateChooser();
        jDateFinal = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxvendedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Numero de Ventas");

        jLabel2.setText("Valor Total Vendido $");

        jButton1.setText("CONSULTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Desde");

        jLabel7.setText("Hasta");

        jComboBoxvendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS" }));
        jComboBoxvendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxvendedorActionPerformed(evt);
            }
        });

        jLabel3.setText("VENDEDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxvendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumerodeventas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvalortotalvendido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumerodeventas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalortotalvendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36))
        );

        txtusuario.setEditable(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero Venta", "Numero Factura", "RUC/CEDULA", "MONTO", "FECHA", "USUARIO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void promocion(){
    try{
        Connection con =  ConexionMySQL.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * FROM usuarios");
        rs=ps.executeQuery();
        while (rs.next()){
        jComboBoxvendedor.addItem(rs.getString("usuario"));
        }
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e);
        }
    }
    public void consultar(){
     // TODO add your handling code here:
        Date dateinicio=jDateInicio.getDate();
        Date datefinal=jDateFinal.getDate();
        if(dateinicio!=null && datefinal!=null){
            long dinicio = dateinicio.getTime();
        java.sql.Date fechainicio= new java.sql.Date(dinicio);
        
        long dfinal = datefinal.getTime();
        java.sql.Date fechafinal= new java.sql.Date(dfinal);
       
        if(fechainicio.before(fechafinal) || fechainicio.equals(fechafinal)){
            //Consultar los datos relacionados con ese intervalo 
        float valortotalvendido=0;
        int numeroventas=0;
        float ganancia=0;
        float impuesto=0;
        float porcentajeganancia=0;
    PreparedStatement ps;
    ResultSet rs;
    try{
    Connection con =  ConexionMySQL.getConexion();
    if(idusu==1){
        String vende=jComboBoxvendedor.getSelectedItem().toString();
        if (vende.equals("TODOS")){
        ps = con.prepareStatement("SELECT monto,impuesto,costo,ganancia FROM balance where fecha>=? and fecha<=?");
        ps.setDate(1,fechainicio);
        ps.setDate(2,fechafinal);
        }else{
        ps = con.prepareStatement("SELECT monto,impuesto,costo,ganancia FROM balance where fecha>=? and fecha<=? and vendedor=?");
        ps.setDate(1,fechainicio);
        ps.setDate(2,fechafinal);
        ps.setString(3,vende);
        }
    }else{
    ps = con.prepareStatement("SELECT monto,impuesto,costo,ganancia FROM balance where fecha>=? and fecha<=? and vendedor=?");
    ps.setDate(1,fechainicio);
    ps.setDate(2,fechafinal);
    ps.setString(3,dato);
    }
   rs=ps.executeQuery();
   while(rs.next()){
   valortotalvendido=valortotalvendido+rs.getFloat("monto");
   ganancia=ganancia+rs.getFloat("ganancia");
   impuesto=impuesto+rs.getFloat("impuesto");
   //numero de ventas
   numeroventas=numeroventas+1;
   }
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
    }
    //Calculo del porcentaje de ganancia
    porcentajeganancia=(ganancia*100)/valortotalvendido;
    BigDecimal db1= new BigDecimal(valortotalvendido).setScale(2, RoundingMode.HALF_UP);
    double valortotalvendido1=db1.doubleValue();
    txtnumerodeventas.setText(""+numeroventas);
    txtvalortotalvendido.setText(""+valortotalvendido1);
cargarTabla();    
//Reiniciar los valores
    valortotalvendido=0;
    numeroventas=0;
        }else{
        JOptionPane.showMessageDialog(null, "Las fechas ingresadas son incorrectas");
        }
        }else{
        JOptionPane.showMessageDialog(null, "Las fechas no pueden estar vacias");
        }
    }
    private void cargarTabla(){
        //Obtener la fecha
    Date dateinicio=jDateInicio.getDate();
        Date datefinal=jDateFinal.getDate();
        long dinicio = dateinicio.getTime();
        java.sql.Date fechainicio= new java.sql.Date(dinicio);
        
        long dfinal = datefinal.getTime();
        java.sql.Date fechafinal= new java.sql.Date(dfinal);
        
    DefaultTableModel modeloTabla= (DefaultTableModel) jTable1.getModel();
    modeloTabla.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
    Connection con =  ConexionMySQL.getConexion();
    String vende=jComboBoxvendedor.getSelectedItem().toString();
        if (vende.equals("TODOS")){
        ps = con.prepareStatement("SELECT numeroventa,numerofactura,ruc,monto,fecha,vendedor FROM balance where fecha>=? and fecha<=?");
        ps.setDate(1,fechainicio);
        ps.setDate(2,fechafinal);
        }else{
        ps = con.prepareStatement("SELECT numeroventa,numerofactura,ruc,monto,fecha,vendedor FROM balance where fecha>=? and fecha<=? and vendedor=?");
        ps.setDate(1,fechainicio);
        ps.setDate(2,fechafinal);
        ps.setString(3,vende);
        }
    
    //ps = con.prepareStatement("SELECT numeroventa,numerofactura,ruc,monto,fecha,vendedor FROM balance where fecha='"+aux+"%'");
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
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       consultar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxvendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxvendedorActionPerformed
        // TODO add your handling code here:
        if (cont>0){
            consultar();
        }
        cont=1;
    }//GEN-LAST:event_jComboBoxvendedorActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int fila=jTable1.getSelectedRow();
            int nv=Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
            detallesventa dtvent= new detallesventa();
            dtvent.setVisible(true);
            dtvent.cargartabla(nv);
        
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazBalance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxvendedor;
    private com.toedter.calendar.JDateChooser jDateFinal;
    private com.toedter.calendar.JDateChooser jDateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtnumerodeventas;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JTextField txtvalortotalvendido;
    // End of variables declaration//GEN-END:variables
}
