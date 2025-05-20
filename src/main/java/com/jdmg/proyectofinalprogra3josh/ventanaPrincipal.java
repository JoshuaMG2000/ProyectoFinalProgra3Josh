package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ventanaPrincipal extends javax.swing.JFrame {

    public ventanaPrincipal() {
        initComponents();
        // ====== ESTILO PROFESIONAL PARA JTable ======

// 1. Fuente general
        tablaVehiculosABB.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));

// 2. Altura de filas y color de rejilla
        tablaVehiculosABB.setRowHeight(28);
        tablaVehiculosABB.setGridColor(new java.awt.Color(176, 185, 197)); // Gris suave

// 3. Estilo del encabezado
        javax.swing.table.JTableHeader header = tablaVehiculosABB.getTableHeader();
        header.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
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
        tablaVehiculosABB.getTableHeader().setReorderingAllowed(false); //no poder menear las columnas de posicion
        tablaVehiculosABB.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel modeloNoEditable = new DefaultTableModel(
                new Object[][]{},
                new String[]{"PLACA", "DPI", "PROPIETARIO", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 🔒 Desactiva edición
            }
        };

        tablaVehiculosABB.setModel(modeloNoEditable);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculosABB = new javax.swing.JTable();
        cargarVehiculosABB = new javax.swing.JButton();
        btnInOrden = new javax.swing.JButton();
        btnPreOrden = new javax.swing.JButton();
        btnPostOrden = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnbuscarABB = new javax.swing.JButton();
        jtextFieldPlaca = new javax.swing.JTextField();
        btnEliminarVehiculoABB = new javax.swing.JButton();
        btnModificarABB = new javax.swing.JButton();
        btnInsertarABB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 177, 198));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jScrollPane1.setViewportView(tablaVehiculosABB);
        if (tablaVehiculosABB.getColumnModel().getColumnCount() > 0) {
            tablaVehiculosABB.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaVehiculosABB.getColumnModel().getColumn(1).setPreferredWidth(110);
            tablaVehiculosABB.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablaVehiculosABB.getColumnModel().getColumn(3).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(6).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(7).setPreferredWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 900, 180));

        cargarVehiculosABB.setBackground(new java.awt.Color(91, 108, 143));
        cargarVehiculosABB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cargarVehiculosABB.setForeground(new java.awt.Color(255, 255, 255));
        cargarVehiculosABB.setText("CARGAR DATOS");
        cargarVehiculosABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarVehiculosABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarVehiculosABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarVehiculosABBActionPerformed(evt);
            }
        });
        jPanel1.add(cargarVehiculosABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 130, -1));

        btnInOrden.setBackground(new java.awt.Color(211, 216, 222));
        btnInOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInOrden.setForeground(new java.awt.Color(0, 0, 0));
        btnInOrden.setText("IN-ORDEN");
        btnInOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnInOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 110, -1));

        btnPreOrden.setBackground(new java.awt.Color(211, 216, 222));
        btnPreOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreOrden.setForeground(new java.awt.Color(0, 0, 0));
        btnPreOrden.setText("PRE-ORDEN");
        btnPreOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPreOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPreOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, -1));

        btnPostOrden.setBackground(new java.awt.Color(211, 216, 222));
        btnPostOrden.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPostOrden.setForeground(new java.awt.Color(0, 0, 0));
        btnPostOrden.setText("POST-ORDEN");
        btnPostOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPostOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPostOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPostOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 110, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("-------------------------- ORDENAMIENTOS  -----------------------");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 350, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DATOS DE VEHICULOS (ABB)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        btnbuscarABB.setBackground(new java.awt.Color(91, 108, 143));
        btnbuscarABB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbuscarABB.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscarABB.setText("BUSCAR POR PLACA:");
        btnbuscarABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscarABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscarABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 160, -1));

        jtextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(jtextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 130, -1));

        btnEliminarVehiculoABB.setBackground(new java.awt.Color(208, 108, 143));
        btnEliminarVehiculoABB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarVehiculoABB.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarVehiculoABB.setText("ELIMINAR");
        btnEliminarVehiculoABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarVehiculoABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarVehiculoABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVehiculoABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarVehiculoABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 320, 90, -1));

        btnModificarABB.setBackground(new java.awt.Color(115, 108, 201));
        btnModificarABB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificarABB.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarABB.setText("MODIFICAR");
        btnModificarABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 110, -1));

        btnInsertarABB.setBackground(new java.awt.Color(115, 108, 201));
        btnInsertarABB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsertarABB.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertarABB.setText("INSERTAR");
        btnInsertarABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertarABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 110, -1));

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


    private void btnInOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrdenActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0); // limpiar tabla
        llenarTablaInOrden(arbolito.raiz, modelo);
    }//GEN-LAST:event_btnInOrdenActionPerformed

    private void btnbuscarABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarABBActionPerformed
        Cronometro cronometro = new Cronometro();
        cronometro.iniciar();

        if (!arbolito.EstaVacio()) {
            String placaBuscada = jtextFieldPlaca.getText().trim().toUpperCase(); // Limpia y estandariza

            if (placaBuscada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una placa para buscar.");
                return;
            }

            NodoArbol resultado = arbolito.BuscarVehiculo(placaBuscada);

            if (resultado != null) {
                JOptionPane.showMessageDialog(this,
                        "Vehículo encontrado:\n" + resultado.vehiculo.toString()+ "\n" + cronometro.detenerComoTexto(),
                        "Resultado de búsqueda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Vehículo no encontrado con placa: " + placaBuscada+ "\n" + cronometro.detenerComoTexto(),
                        "No encontrado", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El árbol está vacío." + "\n" + cronometro.detenerComoTexto());
        }
    }//GEN-LAST:event_btnbuscarABBActionPerformed

    private void btnEliminarVehiculoABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVehiculoABBActionPerformed
        int filaSeleccionada = tablaVehiculosABB.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
            return;
        }

        String placa = tablaVehiculosABB.getValueAt(filaSeleccionada, 0).toString();

        Vehiculos eliminado = arbolito.EliminarVehiculo(placa);

        if (eliminado != null) {
            // Eliminar de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
            modelo.removeRow(filaSeleccionada);

            JOptionPane.showMessageDialog(this, "Vehículo eliminado:\n" + eliminado.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo en el ABB.");
        }
    }//GEN-LAST:event_btnEliminarVehiculoABBActionPerformed

    private void btnModificarABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarABBActionPerformed
        int filaSeleccionada = tablaVehiculosABB.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        String placa = tablaVehiculosABB.getValueAt(filaSeleccionada, 0).toString();

        boolean modificado = arbolito.modificarDatosVehiculo(placa);

        if (modificado) {
            // Refrescar la fila directamente (o la tabla entera si prefieres)
            NodoArbol nodo = arbolito.BuscarVehiculo(placa);
            Vehiculos v = nodo.vehiculo;

            DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
            modelo.setValueAt(v.getDpi(), filaSeleccionada, 1);
            modelo.setValueAt(v.getNombrePropietario(), filaSeleccionada, 2);
            modelo.setValueAt(v.getMarca(), filaSeleccionada, 3);
            modelo.setValueAt(v.getModelo(), filaSeleccionada, 4);
            modelo.setValueAt(v.getAnio(), filaSeleccionada, 5);
            modelo.setValueAt(v.getCantidadMultas(), filaSeleccionada, 6);
            modelo.setValueAt(v.getCantidadTraspasos(), filaSeleccionada, 7);

            JOptionPane.showMessageDialog(this, "Vehículo modificado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo para modificar.");
        }
    }//GEN-LAST:event_btnModificarABBActionPerformed

    private void btnInsertarABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarABBActionPerformed
        try {
            String placa = JOptionPane.showInputDialog("Ingrese la placa:");
            if (placa == null || placa.trim().isEmpty()) {
                return;
            }

            if (arbolito.BuscarVehiculo(placa) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un vehículo con esa placa.");
                return;
            }

            String dpi = JOptionPane.showInputDialog("Ingrese el DPI del propietario:");
            String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del propietario:");
            String marca = JOptionPane.showInputDialog("Ingrese la marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año:"));
            int multas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de multas:"));
            int traspasos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de traspasos:"));

            Vehiculos nuevo = new Vehiculos(placa.toUpperCase(), dpi, nombre, marca, modelo, anio, multas, traspasos);

            if (arbolito.insertarVehiculo(nuevo)) {
                // Insertar al final del JTable
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaVehiculosABB.getModel();
                Object[] fila = {
                    nuevo.getPlaca(), nuevo.getDpi(), nuevo.getNombrePropietario(),
                    nuevo.getMarca(), nuevo.getModelo(), nuevo.getAnio(),
                    nuevo.getCantidadMultas(), nuevo.getCantidadTraspasos()
                };
                modeloTabla.addRow(fila);

                JOptionPane.showMessageDialog(this, "Vehículo insertado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el vehículo.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en datos numéricos: " + e.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnInsertarABBActionPerformed

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
    private javax.swing.JButton btnEliminarVehiculoABB;
    private javax.swing.JButton btnInOrden;
    private javax.swing.JButton btnInsertarABB;
    private javax.swing.JButton btnModificarABB;
    private javax.swing.JButton btnPostOrden;
    private javax.swing.JButton btnPreOrden;
    private javax.swing.JButton btnbuscarABB;
    private javax.swing.JButton cargarVehiculosABB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtextFieldPlaca;
    private javax.swing.JTable tablaVehiculosABB;
    // End of variables declaration//GEN-END:variables
}
