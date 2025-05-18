package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
import javax.swing.table.DefaultTableModel;

public class ventanaPrincipal extends javax.swing.JFrame {

    public ventanaPrincipal() {
        initComponents();
        // ====== ESTILO PROFESIONAL PARA JTable ======

// 1. Fuente general
        tablaVehiculosABB.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));

// 2. Altura de filas y color de rejilla
        tablaVehiculosABB.setRowHeight(28);
        tablaVehiculosABB.setGridColor(new java.awt.Color(176, 185, 197)); // Gris suave

// 3. Estilo del encabezado
        javax.swing.table.JTableHeader header = tablaVehiculosABB.getTableHeader();
        header.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 15));
        header.setBackground(new java.awt.Color(115, 137, 166)); // Azul gris oscuro
        header.setForeground(java.awt.Color.WHITE);

// 4. Estilo de filas alternas y selección
        tablaVehiculosABB.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(new java.awt.Color(91, 108, 143)); // Selección azul gris
                    c.setForeground(java.awt.Color.WHITE);
                } else {
                    if (row % 2 == 0) {
                        c.setBackground(java.awt.Color.WHITE); // Fila par
                    } else {
                        c.setBackground(new java.awt.Color(232, 237, 243)); // Fila impar gris claro
                    }
                    c.setForeground(java.awt.Color.BLACK);
                }

                return c;
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cargarVehiculosABB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculosABB = new javax.swing.JTable();
        btnInOrden = new javax.swing.JButton();
        btnPreOrden = new javax.swing.JButton();
        btnPostOrden = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 177, 198));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargarVehiculosABB.setBackground(new java.awt.Color(91, 108, 143));
        cargarVehiculosABB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cargarVehiculosABB.setText("CARGAR DATOS");
        cargarVehiculosABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarVehiculosABBActionPerformed(evt);
            }
        });
        jPanel1.add(cargarVehiculosABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, 130, -1));

        tablaVehiculosABB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaVehiculosABB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PLACA", "DPI", "PROPIETARIO", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"
            }
        ));
        tablaVehiculosABB.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaVehiculosABB.setGridColor(new java.awt.Color(176, 185, 197));
        tablaVehiculosABB.setRowHeight(28);
        jScrollPane1.setViewportView(tablaVehiculosABB);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 810, 300));

        btnInOrden.setBackground(new java.awt.Color(91, 108, 143));
        btnInOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInOrden.setText("IN-ORDEN");
        btnInOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnInOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 130, -1));

        btnPreOrden.setBackground(new java.awt.Color(91, 108, 143));
        btnPreOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreOrden.setText("PRE-ORDEN");
        btnPreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPreOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 110, 130, -1));

        btnPostOrden.setBackground(new java.awt.Color(91, 108, 143));
        btnPostOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPostOrden.setText("POST-ORDEN");
        btnPostOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPostOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 130, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ArbolBinario arbolito = new ArbolBinario();
    GestorArchivos gestor = new GestorArchivos();

    private void llenarTablaDesdeABB(NodoArbol nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaDesdeABB(nodo.HijoIzquierdo, modelo); // InOrden (ordenado)

            Vehiculos v = nodo.vehiculo;
            Object[] fila = {
                v.getPlaca(),
                v.getDpi(),
                v.getNombrePropietario(),
                v.getMarca(),
                v.getModelo(),
                v.getAnio(),
                v.getCantidadMultas(),
                v.getCantidadTraspasos()
            };
            modelo.addRow(fila);

            llenarTablaDesdeABB(nodo.HijoDerecho, modelo);
            /*
                    IR A LA IZQUIERDA
                    → PROCESAR EL NODO (mostrar en la tabla)
                        → IR A LA DERECHA

             */
        }
    }

    private void agregarFila(Vehiculos v, DefaultTableModel modelo) {
        Object[] fila = {
            v.getPlaca(),
            v.getDpi(),
            v.getNombrePropietario(),
            v.getMarca(),
            v.getModelo(),
            v.getAnio(),
            v.getCantidadMultas(),
            v.getCantidadTraspasos()
        };
        modelo.addRow(fila);
    }


    private void cargarVehiculosABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarVehiculosABBActionPerformed
        gestor.cargarVehiculosDesdeArchivo(arbolito);
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0);
        llenarTablaDesdeABB(arbolito.raiz, modelo);
    }//GEN-LAST:event_cargarVehiculosABBActionPerformed

    //ORDENAMIENTO IN-ORDEN ABB
    private void btnInOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrdenActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0); // limpiar tabla
        llenarTablaInOrden(arbolito.raiz, modelo);
    }//GEN-LAST:event_btnInOrdenActionPerformed

    //ORDENAMIENTO PRE-ORDEN ABB
    private void btnPreOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreOrdenActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0);
        llenarTablaPreOrden(arbolito.raiz, modelo);
    }//GEN-LAST:event_btnPreOrdenActionPerformed

    private void btnPostOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostOrdenActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0);
        llenarTablaPostOrden(arbolito.raiz, modelo);
    }//GEN-LAST:event_btnPostOrdenActionPerformed
   
    private void llenarTablaInOrden(NodoArbol nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaInOrden(nodo.HijoIzquierdo, modelo);
            agregarFila(nodo.vehiculo, modelo);
            llenarTablaInOrden(nodo.HijoDerecho, modelo);
        }
    }

    private void llenarTablaPreOrden(NodoArbol nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            agregarFila(nodo.vehiculo, modelo);
            llenarTablaPreOrden(nodo.HijoIzquierdo, modelo);
            llenarTablaPreOrden(nodo.HijoDerecho, modelo);
        }
    }

    private void llenarTablaPostOrden(NodoArbol nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaPostOrden(nodo.HijoIzquierdo, modelo);
            llenarTablaPostOrden(nodo.HijoDerecho, modelo);
            agregarFila(nodo.vehiculo, modelo);
        }
    }

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
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInOrden;
    private javax.swing.JButton btnPostOrden;
    private javax.swing.JButton btnPreOrden;
    private javax.swing.JButton cargarVehiculosABB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVehiculosABB;
    // End of variables declaration//GEN-END:variables
}
