package com.jdmg.proyectofinalprogra3josh;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
                new String[]{"DEPARTAMENTO", "PLACA", "DPI ANTERIOR", "NOMBRE ANTERIOR", "FECHA", "DPI NUEVO", "NOMBRE NUEVO"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Desactiva edición
            }
        };

// Asignar modelo a tabla
        tablaTraspasos.setModel(modeloNoEditableMultas);
        btnEncriptarTraspasos.setVisible(true);
        btnDesencriptarTraspasos.setVisible(false);

    }
    Cronometro cronometro = new Cronometro();

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
        btnInsertarTraspaso = new javax.swing.JButton();
        btnModificarTraspaso = new javax.swing.JButton();
        btnEliminarMulta = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnbuscarListaDoble = new javax.swing.JButton();
        jtextFieldPlaca = new javax.swing.JTextField();
        btnEncriptarTraspasos = new javax.swing.JButton();
        btnDesencriptarTraspasos = new javax.swing.JButton();
        btnExportarTraspasos = new javax.swing.JButton();
        btnImportarTraspasos = new javax.swing.JButton();
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
                "DEPARTAMENTO", "PLACA", "DPI ANTERIOR", "NOMBRE ANTERIOR", "FECHA", "DPI NUEVO", "NOMBRE NUEVO"
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

        btnInsertarTraspaso.setBackground(new java.awt.Color(153, 204, 0));
        btnInsertarTraspaso.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnInsertarTraspaso.setForeground(new java.awt.Color(0, 51, 51));
        btnInsertarTraspaso.setText("INSERTAR");
        btnInsertarTraspaso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertarTraspaso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarTraspaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarTraspasoActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarTraspaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 580, 120, 30));

        btnModificarTraspaso.setBackground(new java.awt.Color(153, 204, 0));
        btnModificarTraspaso.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnModificarTraspaso.setForeground(new java.awt.Color(0, 51, 51));
        btnModificarTraspaso.setText("MODIFICAR");
        btnModificarTraspaso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarTraspaso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarTraspaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTraspasoActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarTraspaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, 110, 30));

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

        btnEncriptarTraspasos.setBackground(new java.awt.Color(51, 51, 51));
        btnEncriptarTraspasos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnEncriptarTraspasos.setForeground(new java.awt.Color(255, 51, 51));
        btnEncriptarTraspasos.setText("ENCRIPTAR");
        btnEncriptarTraspasos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEncriptarTraspasos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEncriptarTraspasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncriptarTraspasosActionPerformed(evt);
            }
        });
        jPanel1.add(btnEncriptarTraspasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 30));

        btnDesencriptarTraspasos.setBackground(new java.awt.Color(51, 153, 0));
        btnDesencriptarTraspasos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnDesencriptarTraspasos.setForeground(new java.awt.Color(0, 0, 0));
        btnDesencriptarTraspasos.setText("DESENCRIPTAR");
        btnDesencriptarTraspasos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesencriptarTraspasos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesencriptarTraspasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesencriptarTraspasosActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesencriptarTraspasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, 30));

        btnExportarTraspasos.setBackground(new java.awt.Color(44, 48, 57));
        btnExportarTraspasos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnExportarTraspasos.setForeground(new java.awt.Color(255, 255, 51));
        btnExportarTraspasos.setText("EXPORTAR .TXT");
        btnExportarTraspasos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportarTraspasos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportarTraspasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarTraspasosActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportarTraspasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 120, 30));

        btnImportarTraspasos.setBackground(new java.awt.Color(0, 51, 51));
        btnImportarTraspasos.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        btnImportarTraspasos.setForeground(new java.awt.Color(204, 255, 153));
        btnImportarTraspasos.setText("IMPORTAR .TXT");
        btnImportarTraspasos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImportarTraspasos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportarTraspasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarTraspasosActionPerformed(evt);
            }
        });
        jPanel1.add(btnImportarTraspasos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 130, 30));

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
        DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
        listaTraspasos.llenarTablaInicioFin(modelo);
        JOptionPane.showMessageDialog(this, "Lista mostrada de INICIO a FIN.");
    }//GEN-LAST:event_btnInicioFinActionPerformed

    private void btnFinInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinInicioActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
        listaTraspasos.llenarTablaFinInicio(modelo);
        JOptionPane.showMessageDialog(this, "Lista mostrada de FIN a INICIO.");
    }//GEN-LAST:event_btnFinInicioActionPerformed

    private void btnInsertarTraspasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarTraspasoActionPerformed
        FormularioInsertarTraspaso formTraspaso = new FormularioInsertarTraspaso(
                this, true, listaTraspasos, tablaTraspasos, arbolABB, arbolAVL);
        formTraspaso.setLocationRelativeTo(this);
        formTraspaso.setVisible(true);
    }//GEN-LAST:event_btnInsertarTraspasoActionPerformed

    private void btnModificarTraspasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTraspasoActionPerformed
        int fila = tablaTraspasos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        // Obtener placa y fecha desde la tabla
        String placa = tablaTraspasos.getValueAt(fila, 1).toString();
        String fecha = tablaTraspasos.getValueAt(fila, 4).toString(); // 🛑 columna 4 es FECHA

        NodoCircularTraspaso actual = listaTraspasos.getInicio();

        if (actual == null) {
            JOptionPane.showMessageDialog(this, "La lista de traspasos está vacía.");
            return;
        }

        NodoCircularTraspaso inicio = actual;

        do {
            Traspaso t = actual.getTraspaso();
            if (t.getPlaca().equalsIgnoreCase(placa) && t.getFecha().equals(fecha)) {

                FormularioModificarTraspaso form = new FormularioModificarTraspaso(
                        this, true, t, tablaTraspasos, fila, arbolABB, arbolAVL
                );
                form.setLocationRelativeTo(this);
                form.setVisible(true);
                return;
            }
            actual = actual.getSiguiente();
        } while (actual != null && actual != inicio);

        JOptionPane.showMessageDialog(this, "No se encontró el traspaso en la lista.");
    }//GEN-LAST:event_btnModificarTraspasoActionPerformed

    private void btnEliminarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMultaActionPerformed
        int fila = tablaTraspasos.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar este traspaso?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String placa = tablaTraspasos.getValueAt(fila, 1).toString();
            String fecha = tablaTraspasos.getValueAt(fila, 4).toString();

            NodoCircularTraspaso actual = listaTraspasos.getInicio();
            if (actual == null) {
                JOptionPane.showMessageDialog(this, "La lista de traspasos está vacía.");
                return;
            }

            boolean encontrado = false;
            do {
                Traspaso t = actual.traspaso;
                if (t.getPlaca().equalsIgnoreCase(placa) && t.getFecha().equals(fecha)) {
                    listaTraspasos.eliminarNodo(actual);
                    // Buscar la placa en ABB y AVL
                    NodoArbol nodoABB = arbolABB.BuscarVehiculoABB(placa);
                    NodoArbolAVL nodoAVL = arbolAVL.BuscarVehiculoAVL(placa);

                    // Actualizar cantidad de traspasos en ABB y AVL (restar 1)
                    if (nodoABB != null && nodoABB.vehiculo.getCantidadTraspasos() > 0) {
                        nodoABB.vehiculo.setCantidadTraspasos(nodoABB.vehiculo.getCantidadTraspasos() - 1);
                    }
                    if (nodoAVL != null && nodoAVL.vehiculo.getCantidadTraspasos() > 0) {
                        nodoAVL.vehiculo.setCantidadTraspasos(nodoAVL.vehiculo.getCantidadTraspasos() - 1);
                    }
                    // Eliminar fila en la tabla
                    DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
                    modelo.removeRow(fila);

                    JOptionPane.showMessageDialog(this, "✅ Traspaso eliminado correctamente.");
                    encontrado = true;
                    break;
                }
                actual = actual.siguiente;
            } while (actual != listaTraspasos.getInicio());

            if (!encontrado) {
                JOptionPane.showMessageDialog(this, "No se encontró el traspaso en la lista.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar traspaso: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarMultaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTraspasosEnTablaDesdeLista();
    }//GEN-LAST:event_btnActualizarActionPerformed

    public void cargarTraspasosEnTablaDesdeLista() {
        DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        cronometro.iniciar();

        NodoCircularTraspaso actual = listaTraspasos.getInicio();
        if (actual != null) {
            NodoCircularTraspaso primero = actual;
            do {
                Traspaso t = actual.traspaso;
                modelo.addRow(new Object[]{
                    t.getDepartamento(),
                    t.getPlaca(),
                    t.getDpiAnterior(),
                    t.getNombreAnterior(),
                    t.getFecha(),
                    t.getDpiNuevo(),
                    t.getNombreNuevo()
                });
                actual = actual.siguiente;
            } while (actual != primero);
        }

        tablaTraspasos.setRowSorter(null); // Quitar filtro
        JOptionPane.showMessageDialog(null, cronometro.detenerComoTexto(), null, JOptionPane.INFORMATION_MESSAGE);
    }


    private void btnbuscarListaDobleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarListaDobleActionPerformed
        String placaBuscada = jtextFieldPlaca.getText().trim().toUpperCase();
        if (placaBuscada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una placa en el campo de texto.");
            return;
        }

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablaTraspasos.getModel());
        tablaTraspasos.setRowSorter(sorter);

        RowFilter<TableModel, Object> filtro = RowFilter.regexFilter("(?i)^" + placaBuscada + "$", 1); // Coincidencia exacta, columna 1 = placa
        sorter.setRowFilter(filtro);
    }//GEN-LAST:event_btnbuscarListaDobleActionPerformed

    private void btnEncriptarTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncriptarTraspasosActionPerformed
        listaTraspasos.encryptTraspasos();
        DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
        modelo.setRowCount(0);
        cargarTraspasosEnTablaDesdeLista();
        btnEncriptarTraspasos.setVisible(false);
        btnDesencriptarTraspasos.setVisible(true);
    }//GEN-LAST:event_btnEncriptarTraspasosActionPerformed

    private void btnDesencriptarTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesencriptarTraspasosActionPerformed
        listaTraspasos.decryptTraspasos();
        DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
        modelo.setRowCount(0);
        cargarTraspasosEnTablaDesdeLista();
        btnEncriptarTraspasos.setVisible(true);
        btnDesencriptarTraspasos.setVisible(false);

    }//GEN-LAST:event_btnDesencriptarTraspasosActionPerformed

    private void btnExportarTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarTraspasosActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar Traspasos en .txt");

        int opcion = chooser.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();

            try {
                listaTraspasos.exportarTraspasos(archivo.getAbsolutePath()); // listaTraspasos es tu ListaCircularTraspasos
                JOptionPane.showMessageDialog(this, "✅ Traspasos exportados con éxito.");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al exportar traspasos.");
            }
        }
    }//GEN-LAST:event_btnExportarTraspasosActionPerformed

    private void btnImportarTraspasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarTraspasosActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecciona los traspasos encriptados");

        int opcion = chooser.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();

            try {
                listaTraspasos = new ListaCircularTraspasos();
                listaTraspasos.importarTraspasosDesdeArchivo(archivo, listaTraspasos);
                DefaultTableModel modelo = (DefaultTableModel) tablaTraspasos.getModel();
                modelo.setRowCount(0);
                cargarTraspasosEnTablaDesdeLista();
                JOptionPane.showMessageDialog(this, "✅ Traspasos encriptados importados.");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al importar traspasos.");
            }
        }
    }//GEN-LAST:event_btnImportarTraspasosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDesencriptarTraspasos;
    private javax.swing.JButton btnEliminarMulta;
    private javax.swing.JButton btnEncriptarTraspasos;
    private javax.swing.JButton btnExportarTraspasos;
    private javax.swing.JButton btnFinInicio;
    private javax.swing.JButton btnImportarTraspasos;
    private javax.swing.JButton btnInicioFin;
    private javax.swing.JButton btnInsertarTraspaso;
    private javax.swing.JButton btnModificarTraspaso;
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
