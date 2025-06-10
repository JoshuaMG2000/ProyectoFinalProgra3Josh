package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgald
 */
public class FormularioModificarMulta extends javax.swing.JDialog {

    private Multa multa;
    private JTable tablaMultas;
    private int filaSeleccionada;

    public FormularioModificarMulta(java.awt.Frame parent, boolean modal, Multa multa, JTable tablaMultas, int filaSeleccionada) {
        super(parent, modal);
        initComponents();
        this.multa = multa;
        this.tablaMultas = tablaMultas;
        this.filaSeleccionada = filaSeleccionada;
        cargarDatos();
    }

    private void cargarDatos() {
        txtDepartamento.setText(multa.getDepartamento());
        txtPlaca.setText(multa.getPlaca());
        txtPlaca.setEnabled(false); // No editable
        txtFecha.setText(multa.getFecha());
        txtDescripcion.setText(multa.getDescripcion());
        txtMonto.setText(String.valueOf(multa.getMonto()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("FECHA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PLACA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 30));

        txtDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 237, 30));

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 237, 30));

        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 237, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DESCRIPCION:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("MONTO:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INGRESE LOS DATOS A MODIFICAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, 30));

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 237, 30));

        txtMonto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 237, 30));

        btnGuardar.setBackground(new java.awt.Color(102, 102, 102));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 51));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 110, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("DEPARTAMENTO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 46, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // Validaciones
            String nuevoDepartamento = txtDepartamento.getText().trim();
            String nuevaFecha = txtFecha.getText().trim();
            String nuevaDescripcion = txtDescripcion.getText().trim();
            double nuevoMonto = Double.parseDouble(txtMonto.getText().trim());

            if (nuevoDepartamento.isEmpty() || nuevaFecha.isEmpty() || nuevaDescripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.");
                return;
            }

            // Actualizar objeto multa
            multa.setDepartamento(nuevoDepartamento);
            multa.setFecha(nuevaFecha);
            multa.setDescripcion(nuevaDescripcion);
            multa.setMonto(nuevoMonto);

            // Actualizar fila en el JTable
            DefaultTableModel modelo = (DefaultTableModel) tablaMultas.getModel();
            modelo.setValueAt(nuevoDepartamento, filaSeleccionada, 0);
            modelo.setValueAt(multa.getPlaca(), filaSeleccionada, 1);
            modelo.setValueAt(nuevaFecha, filaSeleccionada, 2);
            modelo.setValueAt(nuevaDescripcion, filaSeleccionada, 3);
            modelo.setValueAt(nuevoMonto, filaSeleccionada, 4);

            // ✅ Resaltar visualmente la fila modificada
            tablaMultas.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
            tablaMultas.scrollRectToVisible(tablaMultas.getCellRect(filaSeleccionada, 0, true));

            JOptionPane.showMessageDialog(this, "✅ Multa modificada correctamente.");
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo MONTO debe ser un número válido.");
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
