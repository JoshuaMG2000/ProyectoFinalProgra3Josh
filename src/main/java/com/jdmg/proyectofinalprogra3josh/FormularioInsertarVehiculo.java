package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgald
 */
public class FormularioInsertarVehiculo extends javax.swing.JDialog {

    private ArbolBinario arbolABB = null;
    private ArbolBinarioAVL arbolAVL = null;
    private JTable tabla;
    private Cronometro cronometro;

    //CONSTRUCTOR 1 PARA ARBOL ABB
    public FormularioInsertarVehiculo(java.awt.Frame parent, boolean modal,
            ArbolBinario arbolABB,
            JTable tabla,
            Cronometro cronometro) {
        super(parent, modal);
        initComponents();
        this.arbolABB = arbolABB;
        this.tabla = tabla;
        this.cronometro = cronometro;
    }

    //CONSTRUCTOR 2 PARA ARBOL AVL
    public FormularioInsertarVehiculo(java.awt.Frame parent, boolean modal,
            ArbolBinarioAVL arbolAVL,
            JTable tabla,
            Cronometro cronometro) {
        super(parent, modal);
        initComponents();
        this.arbolAVL = arbolAVL;
        this.tabla = tabla;
        this.cronometro = cronometro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtDpi = new javax.swing.JTextField();
        txtTraspasos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtMultas = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DPI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PLACA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 30));

        txtDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 237, 30));

        txtPlaca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 237, 30));

        txtDpi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtDpi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 237, 30));

        txtTraspasos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtTraspasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 237, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PROPIETARIO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("MARCA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("MODELO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("INGRESE LOS DATOS DEL VEHÍCULO A INSERTAR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 370, 30));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 237, 30));

        txtMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 237, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("AÑO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("NO. DE MULTAS:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("NO. DE TRASPASOS:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        txtModelo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 237, 30));

        txtAnio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 237, 30));

        txtMultas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(txtMultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 237, 30));

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 500, 110, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("DEPARTAMENTO:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 46, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String departamento = txtDepartamento.getText().trim();
            String placa = txtPlaca.getText().trim().toUpperCase();

            if (departamento.isEmpty() || placa.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Departamento y Placa son obligatorios.");
                return;
            }

            // Verificar placa duplicada en ABB o AVL
            boolean existe = false;
            if (arbolABB != null && arbolABB.BuscarVehiculoABB(placa) != null) {
                existe = true;
            }
            if (arbolAVL != null && arbolAVL.BuscarVehiculoAVL(placa) != null) {
                existe = true;
            }

            if (existe) {
                JOptionPane.showMessageDialog(this, "Ya existe un vehículo con esa placa.");
                return;
            }

            // Obtener el resto de datos
            String dpi = txtDpi.getText().trim();
            String nombre = txtNombre.getText().trim();
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            int anio = Integer.parseInt(txtAnio.getText().trim());
            int multas = Integer.parseInt(txtMultas.getText().trim());
            int traspasos = Integer.parseInt(txtTraspasos.getText().trim());

            Vehiculos nuevo = new Vehiculos(
                    departamento, placa, dpi, nombre, marca, modelo, anio, multas, traspasos
            );

            cronometro.iniciar();
            boolean insertado = false;

            if (arbolABB != null) {
                insertado = arbolABB.insertarVehiculo(nuevo);
            } else if (arbolAVL != null) {
                insertado = arbolAVL.insertarVehiculo(nuevo);
            }

            if (insertado) {
                DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
                modeloTabla.addRow(new Object[]{
                    nuevo.getDepartamento(),
                    nuevo.getPlaca(),
                    nuevo.getDpi(),
                    nuevo.getNombrePropietario(),
                    nuevo.getMarca(),
                    nuevo.getModelo(),
                    nuevo.getAnio(),
                    nuevo.getCantidadMultas(),
                    nuevo.getCantidadTraspasos()
                });

                JOptionPane.showMessageDialog(this, "Vehículo insertado correctamente.\n" + cronometro.detenerComoTexto());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el vehículo.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en campos numéricos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDpi;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMultas;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTraspasos;
    // End of variables declaration//GEN-END:variables
}
