package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ventanaMultas extends javax.swing.JFrame {

    public ventanaMultas() {
        initComponents();
    }

    private ventanaPrincipal principal;
    private ArbolBinario arbolABB;
    private ArbolBinarioAVL arbolAVL;
    private JTable tablaABB;
    private JTable tablaAVL;

    public ventanaMultas(ventanaPrincipal principal, ArbolBinario arbolABB, ArbolBinarioAVL arbolAVL, JTable tablaABB, JTable tablaAVL) {
        initComponents();
        this.principal = principal;
        this.arbolABB = arbolABB;
        this.arbolAVL = arbolAVL;
        this.tablaABB = tablaABB;
        this.tablaAVL = tablaAVL;

        // 1. Fuente general
        tablaMultas.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));

// 2. Altura de filas y color de rejilla
        tablaMultas.setRowHeight(28);
        tablaMultas.setGridColor(new java.awt.Color(200, 200, 150)); // Amarillo suave

// 3. Estilo del encabezado
        javax.swing.table.JTableHeader headerMultas = tablaMultas.getTableHeader();
        headerMultas.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        headerMultas.setBackground(new java.awt.Color(255, 204, 102)); // Amarillo oscuro
        headerMultas.setForeground(java.awt.Color.BLACK); // Texto negro

// 4. Estilo de filas alternas y selección
        tablaMultas.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(new java.awt.Color(255, 215, 0)); // Amarillo oro para selección
                    c.setForeground(java.awt.Color.BLACK); // Texto negro
                } else {
                    if (row % 2 == 0) {
                        c.setBackground(new java.awt.Color(255, 255, 204)); // Fila par - amarillo claro
                    } else {
                        c.setBackground(new java.awt.Color(255, 245, 160)); // Fila impar - tono más fuerte
                    }
                    c.setForeground(java.awt.Color.BLACK);
                }

                return c;
            }
        });

// Desactiva movimiento de columnas
        tablaMultas.getTableHeader().setReorderingAllowed(false);

// Selección única
        tablaMultas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

// Modelo no editable y con columnas para multas
        DefaultTableModel modeloNoEditableMultas = new DefaultTableModel(
                new Object[][]{},
                new String[]{"DEPARTAMENTO", "PLACA", "FECHA", "DESCRIPCIÓN", "MONTO"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 🔒 Desactiva edición
            }
        };

// Asignar modelo a tabla
        tablaMultas.setModel(modeloNoEditableMultas);
    }

    public void llenarMultas(ListaDobleMultas lista) {
        DefaultTableModel modelo = (DefaultTableModel) tablaMultas.getModel();
        modelo.setRowCount(0); // Limpiar

        NodoDobleMulta actual = lista.getInicio();
        while (actual != null) {
            Multa m = actual.multa;
            modelo.addRow(new Object[]{
                m.getDepartamento(),
                m.getPlaca(),
                m.getFecha(),
                m.getDescripcion(),
                m.getMonto()
            });
            actual = actual.siguiente;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMultas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnInsertarMulta = new javax.swing.JButton();
        btnModificarMulta = new javax.swing.JButton();
        btnEliminarMulta = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMultas.setBackground(new java.awt.Color(0, 102, 102));
        tablaMultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DEPARTAMENTO", "PLACA", "FECHA", "DESCRIPCION", "MONTO"
            }
        ));
        jScrollPane1.setViewportView(tablaMultas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1350, 510));

        btnVolver.setBackground(new java.awt.Color(255, 0, 102));
        btnVolver.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("VOLVER");
        btnVolver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 110, 30));

        btnInsertarMulta.setBackground(new java.awt.Color(153, 204, 0));
        btnInsertarMulta.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnInsertarMulta.setForeground(new java.awt.Color(0, 51, 51));
        btnInsertarMulta.setText("INSERTAR");
        btnInsertarMulta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertarMulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarMultaActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 570, 120, 30));

        btnModificarMulta.setBackground(new java.awt.Color(153, 204, 0));
        btnModificarMulta.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnModificarMulta.setForeground(new java.awt.Color(0, 51, 51));
        btnModificarMulta.setText("MODIFICAR");
        btnModificarMulta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarMulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMultaActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 570, 110, 30));

        btnEliminarMulta.setBackground(new java.awt.Color(153, 204, 0));
        btnEliminarMulta.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnEliminarMulta.setForeground(new java.awt.Color(0, 51, 51));
        btnEliminarMulta.setText("ELIMINAR");
        btnEliminarMulta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarMulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMultaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 570, 110, 30));

        jLabel8.setBackground(new java.awt.Color(153, 204, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MULTAS REGISTRADAS");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 580, -1));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jgald\\Downloads\\final.png")); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1500, 810));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("S.I.R.V.E. v4.0");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
// Refrescar tabla ABB
        DefaultTableModel modeloABB = (DefaultTableModel) tablaABB.getModel();
        modeloABB.setRowCount(0);
        principal.llenarTablaDesdeABB(arbolABB.getRaiz(), modeloABB);

        // Refrescar tabla AVL
        DefaultTableModel modeloAVL = (DefaultTableModel) tablaAVL.getModel();
        modeloAVL.setRowCount(0);
        principal.llenarTablaDesdeAVL(arbolAVL.getRaiz(), modeloAVL);

        // Mostrar ventana principal
        principal.setVisible(true);
        // Ocultar esta ventana
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnInsertarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarMultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertarMultaActionPerformed

    private void btnModificarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarMultaActionPerformed

    private void btnEliminarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventanaMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaMultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaMultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarMulta;
    private javax.swing.JButton btnInsertarMulta;
    private javax.swing.JButton btnModificarMulta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMultas;
    // End of variables declaration//GEN-END:variables
}
