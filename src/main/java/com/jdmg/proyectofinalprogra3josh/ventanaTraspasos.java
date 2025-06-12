package com.jdmg.proyectofinalprogra3josh;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jgald
 */
public class ventanaTraspasos extends javax.swing.JFrame {

    private ListaCircularTraspasos listaTraspasos;

    private ventanaPrincipal ventanaPrincipal;
    private ArbolBinario arbolABB;
    private ArbolBinarioAVL arbolAVL;
    private JTable tablaABB;
    private JTable tablaAVL;

    public ventanaTraspasos(
            ventanaPrincipal ventanaPrincipal,
            ArbolBinario arbolABB,
            ArbolBinarioAVL arbolAVL,
            JTable tablaABB,
            JTable tablaAVL,
            ListaCircularTraspasos listaTraspasos
    ) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        this.arbolABB = arbolABB;
        this.arbolAVL = arbolAVL;
        this.tablaABB = tablaABB;
        this.tablaAVL = tablaAVL;
        this.listaTraspasos = listaTraspasos;
        // 1. Fuente general
        tablaTraspasos.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));

// 2. Altura de filas y color de rejilla
        tablaTraspasos.setRowHeight(28);
        tablaTraspasos.setGridColor(new java.awt.Color(200, 200, 150)); // Amarillo suave

// 3. Estilo del encabezado
        javax.swing.table.JTableHeader headerMultas = tablaTraspasos.getTableHeader();
        headerMultas.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        headerMultas.setBackground(new java.awt.Color(255, 204, 102)); // Amarillo oscuro
        headerMultas.setForeground(java.awt.Color.BLACK); // Texto negro

// 4. Estilo de filas alternas y selección
        tablaTraspasos.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
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
        tablaTraspasos.getTableHeader().setReorderingAllowed(false);

// Selección única
        tablaTraspasos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

// Modelo no editable y con columnas para multas
        DefaultTableModel modeloNoEditableMultas = new DefaultTableModel(
                new Object[][]{},
                new String[]{"DEPARTAMENTO", "PLACA", "DPI ANTERIOR", "NOMBRE ANTERIOR", "FECHA", "NUEVO DPI", "NUEVO NOMBRE"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Desactiva edición
            }
        };

// Asignar modelo a tabla
        tablaTraspasos.setModel(modeloNoEditableMultas);

    }

    public void llenarTraspasos(ListaCircularTraspasos lista) {
        DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        NodoCircularTraspaso actual = lista.getInicio();
        if (actual == null) {
            return; // Lista vacía
        }

        NodoCircularTraspaso primero = actual;
        do {
            Traspaso t = actual.getTraspaso();
            modelo.addRow(new Object[]{
                t.getDepartamento(),
                t.getPlaca(),
                t.getDpiAnterior(),
                t.getNombreAnterior(),
                t.getFecha(),
                t.getDpiNuevo(),
                t.getNombreNuevo()
            });
            actual = actual.getSiguiente();
        } while (actual != primero);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTraspasos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnInicioFin = new javax.swing.JButton();
        btnFinInicio = new javax.swing.JButton();
        btnInsertarMulta = new javax.swing.JButton();
        btnModificarMulta = new javax.swing.JButton();
        btnEliminarMulta = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnbuscarListaDoble = new javax.swing.JButton();
        jtextFieldPlaca = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(1500, 870));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(153, 204, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TRASPASOS REGISTRADOS");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, -13, 650, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("S.I.R.V.E. v4.0");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        tablaTraspasos.setBackground(new java.awt.Color(0, 102, 102));
        tablaTraspasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DEPARTAMENTO", "PLACA", "DPI ANTERIOR", "NOMBRE ANTERIOR", "FECHA", "NUEVO DPI", "NUEVO NOMBRE"
            }
        ));
        jScrollPane1.setViewportView(tablaTraspasos);

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

        jtextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlaca.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 70, 180, 30));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jgald\\Downloads\\final.png")); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1500, 810));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false); 
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

    private void btnInicioFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioFinActionPerformed

    }//GEN-LAST:event_btnInicioFinActionPerformed

    private void btnFinInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinInicioActionPerformed

    }//GEN-LAST:event_btnFinInicioActionPerformed

    private void btnInsertarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarMultaActionPerformed

    }//GEN-LAST:event_btnInsertarMultaActionPerformed

    private void btnModificarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMultaActionPerformed

    }//GEN-LAST:event_btnModificarMultaActionPerformed

    private void btnEliminarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMultaActionPerformed

    }//GEN-LAST:event_btnEliminarMultaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnbuscarListaDobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarListaDobleActionPerformed

    }//GEN-LAST:event_btnbuscarListaDobleActionPerformed


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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtextFieldPlaca;
    private javax.swing.JTable tablaTraspasos;
    // End of variables declaration//GEN-END:variables
}
