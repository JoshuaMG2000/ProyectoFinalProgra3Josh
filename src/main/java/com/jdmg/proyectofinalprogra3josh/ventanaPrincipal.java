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

        // ====== ESTILO PROFESIONAL PARA tablaVehiculosAVL ======
// 1. Fuente general
        tablaVehiculosAVL.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));

// 2. Altura de filas y color de rejilla
        tablaVehiculosAVL.setRowHeight(28);
        tablaVehiculosAVL.setGridColor(new java.awt.Color(120, 130, 150)); // Gris más oscuro

// 3. Estilo del encabezado
        javax.swing.table.JTableHeader headerAVL = tablaVehiculosAVL.getTableHeader();
        headerAVL.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        headerAVL.setBackground(new java.awt.Color(65, 80, 110)); // Azul gris más oscuro
        headerAVL.setForeground(java.awt.Color.WHITE);

// 4. Estilo de filas alternas y selección
        tablaVehiculosAVL.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    c.setBackground(new java.awt.Color(52, 66, 97)); // Selección azul más oscura
                    c.setForeground(java.awt.Color.WHITE);
                } else {
                    if (row % 2 == 0) {
                        c.setBackground(java.awt.Color.WHITE); // Fila par
                    } else {
                        c.setBackground(new java.awt.Color(210, 215, 225)); // Fila impar gris claro
                    }
                    c.setForeground(java.awt.Color.BLACK);
                }

                return c;
            }
        });
        tablaVehiculosAVL.getTableHeader().setReorderingAllowed(false); // no poder mover columnas
        tablaVehiculosAVL.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        DefaultTableModel modeloNoEditableAVL = new DefaultTableModel(
                new Object[][]{},
                new String[]{"PLACA", "DPI", "PROPIETARIO", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 🔒 Desactiva edición
            }
        };

        tablaVehiculosAVL.setModel(modeloNoEditableAVL);

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
        btnbuscarABB = new javax.swing.JButton();
        jtextFieldPlaca = new javax.swing.JTextField();
        btnEliminarVehiculoABB = new javax.swing.JButton();
        btnModificarABB = new javax.swing.JButton();
        btnInsertarABB = new javax.swing.JButton();
        cargarVehiculosAVL = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVehiculosAVL = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnInsertarAVL = new javax.swing.JButton();
        btnModificarAVL = new javax.swing.JButton();
        btnEliminarVehiculoAVL = new javax.swing.JButton();
        btnbuscarAVL = new javax.swing.JButton();
        jtextFieldPlacaAVL = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVehiculosABB.setBackground(new java.awt.Color(0, 102, 102));
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 940, 210));

        cargarVehiculosABB.setBackground(new java.awt.Color(44, 48, 57));
        cargarVehiculosABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        cargarVehiculosABB.setForeground(new java.awt.Color(255, 255, 51));
        cargarVehiculosABB.setText("CARGAR DATOS");
        cargarVehiculosABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarVehiculosABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarVehiculosABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarVehiculosABBActionPerformed(evt);
            }
        });
        jPanel1.add(cargarVehiculosABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, 30));

        btnInOrden.setBackground(new java.awt.Color(44, 48, 57));
        btnInOrden.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnInOrden.setForeground(new java.awt.Color(255, 255, 51));
        btnInOrden.setText("IN-ORDEN");
        btnInOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnInOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 110, 30));

        btnPreOrden.setBackground(new java.awt.Color(44, 48, 57));
        btnPreOrden.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPreOrden.setForeground(new java.awt.Color(255, 255, 51));
        btnPreOrden.setText("PRE-ORDEN");
        btnPreOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPreOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPreOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 110, 30));

        btnPostOrden.setBackground(new java.awt.Color(44, 48, 57));
        btnPostOrden.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPostOrden.setForeground(new java.awt.Color(255, 255, 51));
        btnPostOrden.setText("POST-ORDEN");
        btnPostOrden.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPostOrden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPostOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostOrdenActionPerformed(evt);
            }
        });
        jPanel1.add(btnPostOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 110, 30));

        btnbuscarABB.setBackground(new java.awt.Color(44, 48, 57));
        btnbuscarABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnbuscarABB.setForeground(new java.awt.Color(255, 255, 51));
        btnbuscarABB.setText("BUSCAR POR PLACA:");
        btnbuscarABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscarABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscarABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 150, 30));

        jtextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlaca.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 180, 30));

        btnEliminarVehiculoABB.setBackground(new java.awt.Color(44, 48, 57));
        btnEliminarVehiculoABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnEliminarVehiculoABB.setForeground(new java.awt.Color(255, 255, 51));
        btnEliminarVehiculoABB.setText("ELIMINAR");
        btnEliminarVehiculoABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarVehiculoABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarVehiculoABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVehiculoABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarVehiculoABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 110, 30));

        btnModificarABB.setBackground(new java.awt.Color(44, 48, 57));
        btnModificarABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnModificarABB.setForeground(new java.awt.Color(255, 255, 51));
        btnModificarABB.setText("MODIFICAR");
        btnModificarABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 110, 30));

        btnInsertarABB.setBackground(new java.awt.Color(44, 48, 57));
        btnInsertarABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnInsertarABB.setForeground(new java.awt.Color(255, 255, 51));
        btnInsertarABB.setText("INSERTAR");
        btnInsertarABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertarABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 110, 30));

        cargarVehiculosAVL.setBackground(new java.awt.Color(0, 51, 51));
        cargarVehiculosAVL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cargarVehiculosAVL.setForeground(new java.awt.Color(204, 204, 255));
        cargarVehiculosAVL.setText("CARGAR DATOS");
        cargarVehiculosAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cargarVehiculosAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarVehiculosAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarVehiculosAVLActionPerformed(evt);
            }
        });
        jPanel1.add(cargarVehiculosAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 110, 30));

        tablaVehiculosAVL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaVehiculosAVL);
        if (tablaVehiculosAVL.getColumnModel().getColumnCount() > 0) {
            tablaVehiculosAVL.getColumnModel().getColumn(0).setPreferredWidth(70);
            tablaVehiculosAVL.getColumnModel().getColumn(1).setPreferredWidth(110);
            tablaVehiculosAVL.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablaVehiculosAVL.getColumnModel().getColumn(3).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(6).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(7).setPreferredWidth(70);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 940, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("S.I.R.V.E. v2.0");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 630, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("DATOS DE VEHICULOS (ABB)");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 500, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATOS DE VEHICULOS (AVL)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 490, -1));

        btnInsertarAVL.setBackground(new java.awt.Color(0, 51, 51));
        btnInsertarAVL.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnInsertarAVL.setForeground(new java.awt.Color(204, 204, 255));
        btnInsertarAVL.setText("INSERTAR");
        btnInsertarAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertarAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarAVLActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 610, 110, 30));

        btnModificarAVL.setBackground(new java.awt.Color(0, 51, 51));
        btnModificarAVL.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnModificarAVL.setForeground(new java.awt.Color(204, 204, 255));
        btnModificarAVL.setText("MODIFICAR");
        btnModificarAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAVLActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 610, 110, 30));

        btnEliminarVehiculoAVL.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminarVehiculoAVL.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnEliminarVehiculoAVL.setForeground(new java.awt.Color(204, 204, 255));
        btnEliminarVehiculoAVL.setText("ELIMINAR");
        btnEliminarVehiculoAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarVehiculoAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarVehiculoAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVehiculoAVLActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarVehiculoAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 110, 30));

        btnbuscarAVL.setBackground(new java.awt.Color(0, 51, 51));
        btnbuscarAVL.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnbuscarAVL.setForeground(new java.awt.Color(204, 204, 255));
        btnbuscarAVL.setText("BUSCAR POR PLACA:");
        btnbuscarAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnbuscarAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscarAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarAVLActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 150, 30));

        jtextFieldPlacaAVL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlacaAVL.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlacaAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 170, 30));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jgald\\Downloads\\final.png")); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, -20, 1820, 870));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ArbolBinario arbolito = new ArbolBinario();
    ArbolBinarioAVL arbolitoAVL = new ArbolBinarioAVL();
    GestorArchivos gestor = new GestorArchivos();
    Cronometro cronometro = new Cronometro();

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

    private void llenarTablaDesdeAVL(NodoArbolAVL nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaDesdeAVL(nodo.izquierdo, modelo);

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

            llenarTablaDesdeAVL(nodo.derecho, modelo);
        }
    }


    private void cargarVehiculosABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarVehiculosABBActionPerformed

        gestor.cargarVehiculosDesdeArchivoABB(arbolito);
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0);
        cronometro.iniciar();
        llenarTablaDesdeABB(arbolito.raiz, modelo);
        JOptionPane.showMessageDialog(null, cronometro.detenerComoTexto(), "DATOS IMPORTADOS", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cargarVehiculosABBActionPerformed


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
                        "Vehículo encontrado:\n" + resultado.vehiculo.toString() + "\n" + cronometro.detenerComoTexto(),
                        "Resultado de búsqueda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Vehículo no encontrado con placa: " + placaBuscada + "\n" + cronometro.detenerComoTexto(),
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
        cronometro.iniciar();
        Vehiculos eliminado = arbolito.EliminarVehiculo(placa);

        if (eliminado != null) {
            // Eliminar de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
            modelo.removeRow(filaSeleccionada);

            JOptionPane.showMessageDialog(this, "Vehículo eliminado:\n" + eliminado.toString() + "\n" + cronometro.detenerComoTexto());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo en el ABB. \n" + cronometro.detenerComoTexto());
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
        cronometro.iniciar();
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

            JOptionPane.showMessageDialog(this, "Vehículo modificado con éxito.\n" + cronometro.detenerComoTexto());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo para modificar.\n" + cronometro.detenerComoTexto());
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
            cronometro.iniciar();
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

                JOptionPane.showMessageDialog(this, "Vehículo insertado con éxito." + "\n" + cronometro.detenerComoTexto());
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el vehículo." + "\n" + cronometro.detenerComoTexto());
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en datos numéricos: " + e.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnInsertarABBActionPerformed

    private void cargarVehiculosAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarVehiculosAVLActionPerformed
        gestor.cargarVehiculosDesdeArchivoAVL(arbolitoAVL);

        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosAVL.getModel();
        modelo.setRowCount(0);  // Limpiar tabla

        cronometro.iniciar();  // Iniciar cronómetro

        llenarTablaDesdeAVL(arbolitoAVL.getRaiz(), modelo);  // Llenar tabla con los datos del árbol

        JOptionPane.showMessageDialog(null,
                cronometro.detenerComoTexto(),
                "DATOS IMPORTADOS",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cargarVehiculosAVLActionPerformed

    private void btnInsertarAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarAVLActionPerformed
        try {
            String placa = JOptionPane.showInputDialog("Ingrese la placa:");
            if (placa == null || placa.trim().isEmpty()) {
                return;
            }

            placa = placa.toUpperCase();
            if (arbolitoAVL.buscar(placa) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un vehículo con esa placa.");
                return;
            }

            String dpi = JOptionPane.showInputDialog("Ingrese el DPI del propietario:");
            String propietario = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
            String marca = JOptionPane.showInputDialog("Ingrese la marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del vehículo:"));
            int multas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de multas:"));
            int traspasos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de traspasos:"));

            Vehiculos nuevo = new Vehiculos(placa, dpi, propietario, marca, modelo, anio, multas, traspasos);

            if (arbolitoAVL.insertarVehiculo(nuevo)) {
                // Insertar fila en la tabla
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaVehiculosAVL.getModel();
                Object[] fila = {
                    nuevo.getPlaca(),
                    nuevo.getDpi(),
                    nuevo.getNombrePropietario(),
                    nuevo.getMarca(),
                    nuevo.getModelo(),
                    nuevo.getAnio(),
                    nuevo.getCantidadMultas(),
                    nuevo.getCantidadTraspasos()
                };
                modeloTabla.addRow(fila);

                JOptionPane.showMessageDialog(this, "Vehículo insertado con éxito.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el vehículo (placa duplicada).");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en datos numéricos: " + e.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnInsertarAVLActionPerformed

    private void btnModificarAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAVLActionPerformed
        int filaSeleccionada = tablaVehiculosAVL.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        String placa = tablaVehiculosAVL.getValueAt(filaSeleccionada, 0).toString();

        boolean modificado = arbolitoAVL.modificarDatosVehiculo(placa);
        cronometro.iniciar();
        if (modificado) {
            NodoArbolAVL nodo = arbolitoAVL.buscar(placa);
            Vehiculos v = nodo.vehiculo;

            DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosAVL.getModel();
            modelo.setValueAt(v.getDpi(), filaSeleccionada, 1);
            modelo.setValueAt(v.getNombrePropietario(), filaSeleccionada, 2);
            modelo.setValueAt(v.getMarca(), filaSeleccionada, 3);
            modelo.setValueAt(v.getModelo(), filaSeleccionada, 4);
            modelo.setValueAt(v.getAnio(), filaSeleccionada, 5);
            modelo.setValueAt(v.getCantidadMultas(), filaSeleccionada, 6);
            modelo.setValueAt(v.getCantidadTraspasos(), filaSeleccionada, 7);

            JOptionPane.showMessageDialog(this, "Vehículo modificado con éxito.\n" + cronometro.detenerComoTexto());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo para modificar.\n" + cronometro.detenerComoTexto());
        }
    }//GEN-LAST:event_btnModificarAVLActionPerformed

    private void btnEliminarVehiculoAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVehiculoAVLActionPerformed
        int filaSeleccionada = tablaVehiculosAVL.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
            return;
        }

        String placa = tablaVehiculosAVL.getValueAt(filaSeleccionada, 0).toString();
        cronometro.iniciar();

        Vehiculos eliminado = arbolitoAVL.eliminarVehiculo(placa);

        if (eliminado != null) {
            DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosAVL.getModel();
            modelo.removeRow(filaSeleccionada);

            JOptionPane.showMessageDialog(this,
                    "Vehículo eliminado:\n" + eliminado.toString() + "\n" + cronometro.detenerComoTexto(),
                    "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se encontró el vehículo en el árbol AVL.\n" + cronometro.detenerComoTexto(),
                    "No encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarVehiculoAVLActionPerformed

    private void btnbuscarAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarAVLActionPerformed
        String placa = jtextFieldPlacaAVL.getText().trim().toUpperCase();

        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una placa a buscar.");
            return;
        }

        NodoArbolAVL nodo = arbolitoAVL.buscar(placa);

        if (nodo != null) {
            JOptionPane.showMessageDialog(this,
                    "Vehículo encontrado:\n\n" + nodo.vehiculo.toString(),
                    "Resultado AVL", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Vehículo con placa '" + placa + "' no fue encontrado en el árbol AVL.",
                    "No encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnbuscarAVLActionPerformed

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
    private javax.swing.JButton btnEliminarVehiculoAVL;
    private javax.swing.JButton btnInOrden;
    private javax.swing.JButton btnInsertarABB;
    private javax.swing.JButton btnInsertarAVL;
    private javax.swing.JButton btnModificarABB;
    private javax.swing.JButton btnModificarAVL;
    private javax.swing.JButton btnPostOrden;
    private javax.swing.JButton btnPreOrden;
    private javax.swing.JButton btnbuscarABB;
    private javax.swing.JButton btnbuscarAVL;
    private javax.swing.JButton cargarVehiculosABB;
    private javax.swing.JButton cargarVehiculosAVL;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtextFieldPlaca;
    private javax.swing.JTextField jtextFieldPlacaAVL;
    private javax.swing.JTable tablaVehiculosABB;
    private javax.swing.JTable tablaVehiculosAVL;
    // End of variables declaration//GEN-END:variables
}
