
package InterfazGrafica;

import BasedeDatos.ConexionMySQL;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuPrincipal extends javax.swing.JFrame {
    private String dato;
    private int idusu;
    public MenuPrincipal() {
        initComponents();
        Color c1= new Color(0xCDCDC0); 
        Color c2= new Color(0x336b87); 
        Color c3= new Color(0xBBC3C6); 
        administrador.setBackground(c3);
        usuarios.setBackground(c3);
        productos.setBackground(c3);
        balance.setBackground(c3);
        facturacion.setBackground(c3);
        jButton1.setBackground(c3);
        PanelUsuariosProductos.setBackground(c2);
        jPanel1.setBackground(c2);
        Paneladministracion.setBackground(c2);
        this.getContentPane().setBackground(c1);
        this.setExtendedState(6);
        
        cargarTabla(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusuario = new javax.swing.JTextField();
        PanelUsuariosProductos = new javax.swing.JPanel();
        facturacion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabladecontrolprincipal = new javax.swing.JTable();
        Paneladministracion = new javax.swing.JPanel();
        administrador = new javax.swing.JButton();
        balance = new javax.swing.JButton();
        productos = new javax.swing.JButton();
        usuarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        txtusuario.setEditable(false);

        PanelUsuariosProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        facturacion.setText("Facturacion");
        facturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelUsuariosProductosLayout = new javax.swing.GroupLayout(PanelUsuariosProductos);
        PanelUsuariosProductos.setLayout(PanelUsuariosProductosLayout);
        PanelUsuariosProductosLayout.setHorizontalGroup(
            PanelUsuariosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosProductosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(facturacion)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        PanelUsuariosProductosLayout.setVerticalGroup(
            PanelUsuariosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuariosProductosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Tabladecontrolprincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero Venta", "Numero Factura", "RUC/CEDULA", "Monto", "Fecha", "Usuario"
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
        jScrollPane1.setViewportView(Tabladecontrolprincipal);

        Paneladministracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        administrador.setText("Administrador");
        administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administradorActionPerformed(evt);
            }
        });

        balance.setText("Balance");
        balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceActionPerformed(evt);
            }
        });

        productos.setText("Productos");
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });

        usuarios.setText("Clientes");
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaneladministracionLayout = new javax.swing.GroupLayout(Paneladministracion);
        Paneladministracion.setLayout(PaneladministracionLayout);
        PaneladministracionLayout.setHorizontalGroup(
            PaneladministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneladministracionLayout.createSequentialGroup()
                .addGroup(PaneladministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PaneladministracionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(administrador, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PaneladministracionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PaneladministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productos, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        PaneladministracionLayout.setVerticalGroup(
            PaneladministracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneladministracionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(administrador)
                .addGap(18, 18, 18)
                .addComponent(usuarios)
                .addGap(18, 18, 18)
                .addComponent(productos)
                .addGap(18, 18, 18)
                .addComponent(balance)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Paneladministracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelUsuariosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(Paneladministracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(PanelUsuariosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void facturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturacionActionPerformed

        Facturacion factu= new Facturacion();
        factu.setVisible(true);
        factu.setdato(idusu, dato);
    }//GEN-LAST:event_facturacionActionPerformed

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        InterfazUsuarios usu = new InterfazUsuarios();
        usu.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_usuariosActionPerformed

    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
        InterfazProductos pro = new InterfazProductos();
        pro.setVisible(true);
    }//GEN-LAST:event_productosActionPerformed

    private void balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceActionPerformed
        // TODO add your handling code here:
        InterfazBalance balance= new InterfazBalance();
        balance.setVisible(true);
        balance.setdato(idusu, dato);
    }//GEN-LAST:event_balanceActionPerformed

    private void administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administradorActionPerformed
        InterfazAdministrador admi = new InterfazAdministrador();
        admi.setVisible(true);
    }//GEN-LAST:event_administradorActionPerformed

    public void setdato(int idusu, String dato){
    this.dato=dato;
    this.idusu=idusu;
    txtusuario.setText(dato);
    if(idusu>1){
    administrador.setEnabled(false);
    productos.setEnabled(false);
    }
    cargarTabla();
    }

    private void cargarTabla(){
        //Obtener la fecha
    LocalDate fecha=LocalDate.now();
    int año=fecha.getYear();
    int mes =fecha.getMonthValue();
    int dia=fecha.getDayOfMonth();
    String aux=""+año+"-"+mes+"-"+dia;
    DefaultTableModel modeloTabla= (DefaultTableModel) Tabladecontrolprincipal.getModel();
    modeloTabla.setRowCount(0);
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
    Connection con =  ConexionMySQL.getConexion();
    System.out.println(idusu);
    if(idusu==1){
    ps = con.prepareStatement("SELECT numeroventa,numerofactura,ruc,monto,fecha,vendedor FROM balance where fecha='"+aux+"%'");
    }else{
    ps = con.prepareStatement("SELECT numeroventa,numerofactura,ruc,monto,fecha,vendedor FROM balance where fecha='"+aux+"%' and vendedor='"+dato+"'");
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
   con.close();
    }catch(SQLException e){
    JOptionPane.showMessageDialog(null,e);
    }
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelUsuariosProductos;
    private javax.swing.JPanel Paneladministracion;
    private javax.swing.JTable Tabladecontrolprincipal;
    private javax.swing.JButton administrador;
    private javax.swing.JButton balance;
    private javax.swing.JButton facturacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton productos;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JButton usuarios;
    // End of variables declaration//GEN-END:variables
}
