package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ventanaMultas extends javax.swing.JFrame {

    private ListaDobleMultas listaMultas;

    private ventanaPrincipal ventanaPrincipal;
    private ArbolBinario arbolABB;
    private ArbolBinarioAVL arbolAVL;
    private JTable tablaABB;
    private JTable tablaAVL;

    public ventanaMultas(ventanaPrincipal ventanaPrincipal,
            ArbolBinario arbolABB,
            ArbolBinarioAVL arbolAVL,
            JTable tablaABB,
            JTable tablaAVL,
            ListaDobleMultas listaMultas) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        this.arbolABB = arbolABB;
        this.arbolAVL = arbolAVL;
        this.tablaABB = tablaABB;
        this.tablaAVL = tablaAVL;
        this.listaMultas = listaMultas; 

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
                return false; // Desactiva edición
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
    Cronometro cronometro = new Cronometro();

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
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtextFieldPlaca = new javax.swing.JTextField();
        btnbuscarListaDoble = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnInicioFin = new javax.swing.JButton();
        btnFinInicio = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1350, 480));

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
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 110, 30));

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
        jPanel1.add(btnInsertarMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 580, 120, 30));

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
        jPanel1.add(btnModificarMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, 110, 30));

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
        jPanel1.add(btnEliminarMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 580, 110, 30));

        jLabel8.setBackground(new java.awt.Color(153, 204, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MULTAS REGISTRADAS");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -13, 580, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("S.I.R.V.E. v4.0");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jButton1.setText("PARA PRUEBAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, -1, 40));

        jtextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlaca.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 70, 180, 30));

        btnbuscarListaDoble.setBackground(new java.awt.Color(44, 48, 57));
        btnbuscarListaDoble.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnbuscarListaDoble.setForeground(new java.awt.Color(255, 255, 51));
        btnbuscarListaDoble.setText("BUSCAR POR PLACA:");
        btnbuscarListaDoble.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscarListaDoble.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscarListaDoble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarListaDobleActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscarListaDoble, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 70, 140, 30));

        btnActualizar.setBackground(new java.awt.Color(51, 255, 204));
        btnActualizar.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(0, 51, 51));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 580, 110, 30));

        btnInicioFin.setBackground(new java.awt.Color(0, 102, 255));
        btnInicioFin.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnInicioFin.setForeground(new java.awt.Color(204, 255, 255));
        btnInicioFin.setText("VER INICIO - FIN");
        btnInicioFin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInicioFin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicioFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioFinActionPerformed(evt);
            }
        });
        jPanel1.add(btnInicioFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 140, 30));

        btnFinInicio.setBackground(new java.awt.Color(153, 0, 204));
        btnFinInicio.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnFinInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnFinInicio.setText("VER FIN - INICIO");
        btnFinInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFinInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinInicioActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 580, 140, 30));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jgald\\Downloads\\final.png")); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1500, 810));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false); // Oculta la ventana de multas
        ventanaPrincipal.setVisible(true); // Muestra la ventana principal
        //Refrescar tabla ABB
        DefaultTableModel modeloABB = (DefaultTableModel) tablaABB.getModel();
        modeloABB.setRowCount(0);
        ventanaPrincipal.llenarTablaDesdeABB(arbolABB.getRaiz(), modeloABB);

        //Refrescar tabla AVL
        DefaultTableModel modeloAVL = (DefaultTableModel) tablaAVL.getModel();
        modeloAVL.setRowCount(0);
        ventanaPrincipal.llenarTablaDesdeAVL(arbolAVL.getRaiz(), modeloAVL);

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnInsertarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarMultaActionPerformed
        FormularioInsertarMulta formMulta = new FormularioInsertarMulta(
                this, true, listaMultas, tablaMultas, arbolABB, arbolAVL);
        formMulta.setLocationRelativeTo(this);
        formMulta.setVisible(true);
    }//GEN-LAST:event_btnInsertarMultaActionPerformed

    private void btnModificarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMultaActionPerformed
        int fila = tablaMultas.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        // Obtener placa y fecha de la fila 
        String placa = tablaMultas.getValueAt(fila, 1).toString();
        String fecha = tablaMultas.getValueAt(fila, 2).toString();

        // Buscar la multa correspondiente en la lista doble
        NodoDobleMulta actual = listaMultas.getInicio(); 
        while (actual != null) {
            Multa m = actual.multa;
            if (m.getPlaca().equalsIgnoreCase(placa) && m.getFecha().equals(fecha)) {
                // Abrir el formulario de modificación
                FormularioModificarMulta form = new FormularioModificarMulta(this, true, m, tablaMultas, fila);
                form.setLocationRelativeTo(this);
                form.setVisible(true);
                return; // Ya se encontró y mostró el formulario
            }
            actual = actual.siguiente;
        }

        // Si no encontró la multa
        JOptionPane.showMessageDialog(this, "No se encontró la multa en la lista.");
    }//GEN-LAST:event_btnModificarMultaActionPerformed

    private void btnEliminarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMultaActionPerformed
        int fila = tablaMultas.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar esta multa?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String placa = tablaMultas.getValueAt(fila, 1).toString().toUpperCase();
            String fecha = tablaMultas.getValueAt(fila, 2).toString();

            // Buscar multa en la lista doble
            NodoDobleMulta actual = listaMultas.getInicio();
            while (actual != null) {
                Multa m = actual.multa;
                if (m.getPlaca().equalsIgnoreCase(placa) && m.getFecha().equals(fecha)) {
                    // Encontrado: eliminar multa de la lista doble
                    listaMultas.eliminarNodo(actual);

                    // Buscar la placa en ABB y AVL
                    NodoArbol nodoABB = arbolABB.BuscarVehiculoABB(placa);
                    NodoArbolAVL nodoAVL = arbolAVL.BuscarVehiculoAVL(placa);

                    // Actualizar cantidad de multas en ABB y AVL (restar 1)
                    if (nodoABB != null && nodoABB.vehiculo.getCantidadMultas() > 0) {
                        nodoABB.vehiculo.setCantidadMultas(nodoABB.vehiculo.getCantidadMultas() - 1);
                    }
                    if (nodoAVL != null && nodoAVL.vehiculo.getCantidadMultas() > 0) {
                        nodoAVL.vehiculo.setCantidadMultas(nodoAVL.vehiculo.getCantidadMultas() - 1);
                    }

                    // Actualizar tabla multas: eliminar fila
                    DefaultTableModel modelo = (DefaultTableModel) tablaMultas.getModel();
                    modelo.removeRow(fila);

                    JOptionPane.showMessageDialog(this, "✅ Multa eliminada correctamente.");
                    return;
                }
                actual = actual.siguiente;
            }

            JOptionPane.showMessageDialog(this, "No se encontró la multa en la lista.");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar multa: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnEliminarMultaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimirListaMultasEnConsola();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnbuscarListaDobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarListaDobleActionPerformed
        String placaBuscada = jtextFieldPlaca.getText().trim().toUpperCase();

        if (placaBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una placa en el campo de texto.");
            return;
        }

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablaMultas.getModel());
        tablaMultas.setRowSorter(sorter);

        RowFilter<TableModel, Object> filtro = RowFilter.regexFilter("(?i)^" + placaBuscada + "$", 1); // Coincidencia exacta, columna 1 = placa
        sorter.setRowFilter(filtro);
    }//GEN-LAST:event_btnbuscarListaDobleActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarMultasEnTablaDesdeLista();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnInicioFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioFinActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaMultas.getModel();
        listaMultas.llenarTablaInicioFin(modelo);
        JOptionPane.showMessageDialog(this, "Lista mostrada de INICIO a FIN.");
    }//GEN-LAST:event_btnInicioFinActionPerformed

    private void btnFinInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinInicioActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaMultas.getModel();
        listaMultas.llenarTablaFinInicio(modelo);
        JOptionPane.showMessageDialog(this, "Lista mostrada de FIN a INICIO.");
    }//GEN-LAST:event_btnFinInicioActionPerformed
    public void imprimirListaMultasEnConsola() {
        if (listaMultas == null || listaMultas.getInicio() == null) {
            System.out.println("La lista de multas está vacía.");
            return;
        }

        NodoDobleMulta actual = listaMultas.getInicio();
        System.out.println("Contenido de la lista doble de multas:");
        while (actual != null) {
            Multa multa = actual.multa;
            System.out.println("Departamento: " + multa.getDepartamento()
                    + ", Placa: " + multa.getPlaca()
                    + ", Fecha: " + multa.getFecha()
                    + ", Descripción: " + multa.getDescripcion()
                    + ", Monto: " + multa.getMonto());
            actual = actual.siguiente;
        }
    }

    public void cargarMultasEnTablaDesdeLista() {
        DefaultTableModel modelo = (DefaultTableModel) tablaMultas.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        cronometro.iniciar();
        NodoDobleMulta actual = listaMultas.getInicio();
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

        tablaMultas.setRowSorter(null); // Quitar filtro
        JOptionPane.showMessageDialog(null, cronometro.detenerComoTexto(), null, JOptionPane.INFORMATION_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminarMulta;
    private javax.swing.JButton btnFinInicio;
    private javax.swing.JButton btnInicioFin;
    private javax.swing.JButton btnInsertarMulta;
    private javax.swing.JButton btnModificarMulta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnbuscarListaDoble;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtextFieldPlaca;
    private javax.swing.JTable tablaMultas;
    // End of variables declaration//GEN-END:variables
}
