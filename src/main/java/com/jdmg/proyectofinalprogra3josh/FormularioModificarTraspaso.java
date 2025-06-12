package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgald
 */
public class FormularioModificarTraspaso extends javax.swing.JDialog {

    private Traspaso traspaso;
    private JTable tablaTraspasos;
    private int filaSeleccionada;
    private ArbolBinario arbolABB;
    private ArbolBinarioAVL arbolAVL;

    public FormularioModificarTraspaso(java.awt.Frame parent, boolean modal,
            Traspaso traspaso, JTable tablaTraspasos,
            int filaSeleccionada, ArbolBinario arbolABB, ArbolBinarioAVL arbolAVL) {
        super(parent, modal);
        initComponents();
        this.traspaso = traspaso;
        this.tablaTraspasos = tablaTraspasos;
        this.filaSeleccionada = filaSeleccionada;
        this.arbolABB = arbolABB;
        this.arbolAVL = arbolAVL;
        cargarDatos();
    }

    private void cargarDatos() {
        txtDepartamento.setText(traspaso.getDepartamento());
        txtPlaca.setText(traspaso.getPlaca());
        txtPlaca.setEnabled(false); // No editable
        txtDpiAnterior.setText(traspaso.getDpiAnterior());
        txtNombreAnterior.setText(traspaso.getNombreAnterior());
        txtFecha.setText(traspaso.getFecha());
        txtNuevoDpi.setText(traspaso.getDpiNuevo());
        txtNuevoNombre.setText(traspaso.getNombreNuevo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtDpiAnterior = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreAnterior = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNuevoDpi = new javax.swing.JTextField();
        txtNuevoNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
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

        txtDpiAnterior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDpiAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 237, 30));

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
        jLabel1.setText("INGRESE LOS DATOS A MODIFICAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 280, 30));

        txtNombreAnterior.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtNombreAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 237, 30));

        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 237, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 102, 102));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 0));
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

        txtNuevoDpi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtNuevoDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 237, 30));

        txtNuevoNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtNuevoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 237, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("NOMBRE ANTERIOR:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // Obtener datos del formulario
            String nuevoDepartamento = txtDepartamento.getText().trim();
            String nuevaFecha = txtFecha.getText().trim();
            String nuevoDpiAnterior = txtDpiAnterior.getText().trim();
            String nuevoNombreAnterior = txtNombreAnterior.getText().trim();
            String nuevoDpiNuevo = txtNuevoDpi.getText().trim();
            String nuevoNombreNuevo = txtNuevoNombre.getText().trim();

            if (nuevoDepartamento.isEmpty() || nuevaFecha.isEmpty()
                    || nuevoDpiAnterior.isEmpty() || nuevoNombreAnterior.isEmpty()
                    || nuevoDpiNuevo.isEmpty() || nuevoNombreNuevo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben estar completos.");
                return;
            }

            // Actualizar objeto Traspaso
            traspaso.setDepartamento(nuevoDepartamento);
            traspaso.setFecha(nuevaFecha);
            traspaso.setDpiAnterior(nuevoDpiAnterior);
            traspaso.setNombreAnterior(nuevoNombreAnterior);
            traspaso.setDpiNuevo(nuevoDpiNuevo);
            traspaso.setNombreNuevo(nuevoNombreNuevo);

            // Actualizar fila en tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
            modelo.setValueAt(nuevoDepartamento, filaSeleccionada, 0);
            modelo.setValueAt(traspaso.getPlaca(), filaSeleccionada, 1);
            modelo.setValueAt(nuevoDpiAnterior, filaSeleccionada, 2);
            modelo.setValueAt(nuevoNombreAnterior, filaSeleccionada, 3);
            modelo.setValueAt(nuevaFecha, filaSeleccionada, 4);
            modelo.setValueAt(nuevoDpiNuevo, filaSeleccionada, 5);
            modelo.setValueAt(nuevoNombreNuevo, filaSeleccionada, 6);

            // Buscar placa en ABB y AVL y actualizar propietario, DPI y departamento
            String placa = traspaso.getPlaca();

            NodoArbol nodoABB = arbolABB.BuscarVehiculoABB(placa);
            if (nodoABB != null) {
                nodoABB.vehiculo.setDpi(nuevoDpiAnterior);
                nodoABB.vehiculo.setNombrePropietario(nuevoNombreAnterior);
                nodoABB.vehiculo.setDepartamento(nuevoDepartamento);
            }

            NodoArbolAVL nodoAVL = arbolAVL.BuscarVehiculoAVL(placa);
            if (nodoAVL != null) {
                nodoAVL.vehiculo.setDpi(nuevoDpiAnterior);
                nodoAVL.vehiculo.setNombrePropietario(nuevoNombreAnterior);
                nodoAVL.vehiculo.setDepartamento(nuevoDepartamento);
            }

            // Resaltar fila
            tablaTraspasos.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
            tablaTraspasos.scrollRectToVisible(tablaTraspasos.getCellRect(filaSeleccionada, 0, true));

            JOptionPane.showMessageDialog(this, "✅ Traspaso modificado correctamente.");
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar el traspaso: " + e.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreAnterior;
    private javax.swing.JTextField txtNuevoDpi;
    private javax.swing.JTextField txtNuevoNombre;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
