package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgald
 */
public class FormularioInsertarTraspaso extends javax.swing.JDialog {

    private ListaCircularTraspasos listaTraspasos;
    private JTable tablaTraspasos;
    public ArbolBinario arbolABB;
    private ArbolBinarioAVL arbolAVL;

    public FormularioInsertarTraspaso(java.awt.Frame parent, boolean modal,
            ListaCircularTraspasos listaTraspasos, JTable tablaTraspasos,
            ArbolBinario arbolABB, ArbolBinarioAVL arbolAVL) {
        super(parent, modal);
        initComponents();
        this.listaTraspasos = listaTraspasos;
        this.tablaTraspasos = tablaTraspasos;
        this.arbolABB = arbolABB;
        this.arbolAVL = arbolAVL;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtDpiNuevo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreNuevo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDpiAnterior = new javax.swing.JTextField();
        txtNombreAnterior = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 330));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DPI NUEVO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PLACA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 30));

        txtDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 237, 30));

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 237, 30));

        txtDpiNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDpiNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 237, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NOMBRE NUEVO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("FECHA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INGRESE LOS DATOS DEL NUEVO TRASPASO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 350, 30));

        txtNombreNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtNombreNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 237, 30));

        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 237, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 204, 102));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 110, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("DEPARTAMENTO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 46, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("DPI ANTERIOR:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 30));

        txtDpiAnterior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDpiAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 237, 30));

        txtNombreAnterior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtNombreAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 237, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("NOMBRE ANTERIOR:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String departamento = txtDepartamento.getText().trim();
            String placa = txtPlaca.getText().trim().toUpperCase();
            String dpiNuevo = txtDpiNuevo.getText().trim();
            String nombreNuevo = txtNombreNuevo.getText().trim();
            String fecha = txtFecha.getText().trim();
            String dpiAnterior = txtDpiAnterior.getText().trim();
            String nombreAnterior = txtNombreAnterior.getText().trim();
            if (departamento.isEmpty() || placa.isEmpty() || dpiAnterior.isEmpty()
                    || nombreAnterior.isEmpty() || fecha.isEmpty()
                    || dpiNuevo.isEmpty() || nombreNuevo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
                return;
            }

            // Buscar vehículo en ABB y AVL
            NodoArbol nodoABB = arbolABB.BuscarVehiculoABB(placa);
            NodoArbolAVL nodoAVL = arbolAVL.BuscarVehiculoAVL(placa);

            if (nodoABB == null && nodoAVL == null) {
                JOptionPane.showMessageDialog(this,
                        "❌ La placa ingresada no existe en los registros.\n"
                        + "Por favor registre el vehículo en la ventana principal primero.",
                        "Placa no registrada", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Crear y agregar traspaso a la lista
            Traspaso nuevoTraspaso = new Traspaso(departamento, placa, dpiAnterior, nombreAnterior, fecha, dpiNuevo, nombreNuevo);
            listaTraspasos.insertarAlFinal(nuevoTraspaso); // ListaCircular

            // Actualizar los datos del vehículo (nombre y DPI) y contar traspasos, 
            //Por que el .txt está malo, tiene alrevés en base a las fechas los traspasos.
            if (nodoABB != null) {
                nodoABB.vehiculo.setDepartamento(departamento);
                nodoABB.vehiculo.setDpi(dpiNuevo);
                nodoABB.vehiculo.setNombrePropietario(nombreNuevo);
                nodoABB.vehiculo.setCantidadTraspasos(nodoABB.vehiculo.getCantidadTraspasos() + 1);
            }
            if (nodoAVL != null) {
                nodoAVL.vehiculo.setDepartamento(departamento);
                nodoAVL.vehiculo.setDpi(dpiNuevo);
                nodoAVL.vehiculo.setNombrePropietario(nombreNuevo);
                nodoAVL.vehiculo.setCantidadTraspasos(nodoAVL.vehiculo.getCantidadTraspasos() + 1);
            }

            // Refrescar la tabla de traspasos
            DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
            modelo.addRow(new Object[]{
                nuevoTraspaso.getDepartamento(),
                nuevoTraspaso.getPlaca(),
                nuevoTraspaso.getDpiAnterior(),
                nuevoTraspaso.getNombreAnterior(),
                nuevoTraspaso.getFecha(),
                nuevoTraspaso.getDpiNuevo(),
                nuevoTraspaso.getNombreNuevo()
            });

            JOptionPane.showMessageDialog(this, "✅ Traspaso registrado correctamente.");
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el traspaso: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDpiAnterior;
    private javax.swing.JTextField txtDpiNuevo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreAnterior;
    private javax.swing.JTextField txtNombreNuevo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
