package com.jdmg.proyectofinalprogra3josh;

/**
 *
 * @author jgald
 */
import java.io.File;
import javax.swing.JFileChooser;
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
                new String[]{"DEPARTAMENTO", "PLACA", "DPI", "PROPIETARIO", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"}
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
                new String[]{"DEPARTAMENTO", "PLACA", "DPI", "PROPIETARIO", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"}
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
        btnInOrdenABB = new javax.swing.JButton();
        btnPreOrdenABB = new javax.swing.JButton();
        btnPostOrdenABB = new javax.swing.JButton();
        btnbuscarABB = new javax.swing.JButton();
        jtextFieldPlaca = new javax.swing.JTextField();
        btnEliminarVehiculoABB = new javax.swing.JButton();
        btnInsertarABB = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVehiculosAVL = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnInsertarAVL = new javax.swing.JButton();
        btnEliminarVehiculoAVL = new javax.swing.JButton();
        btnbuscarAVL = new javax.swing.JButton();
        jtextFieldPlacaAVL = new javax.swing.JTextField();
        btnVerArbolABB = new javax.swing.JButton();
        btnPreOrdenAVL = new javax.swing.JButton();
        btnInOrdenAVL = new javax.swing.JButton();
        btnPostOrdenAVL = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cargarDatos = new javax.swing.JMenuItem();
        modificarVehiculo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVehiculosABB.setBackground(new java.awt.Color(0, 102, 102));
        tablaVehiculosABB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DEPARTAMENTO", "PLACA", "DPI", "PROPIETARIO", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"
            }
        ));
        jScrollPane1.setViewportView(tablaVehiculosABB);
        if (tablaVehiculosABB.getColumnModel().getColumnCount() > 0) {
            tablaVehiculosABB.getColumnModel().getColumn(1).setPreferredWidth(70);
            tablaVehiculosABB.getColumnModel().getColumn(2).setPreferredWidth(110);
            tablaVehiculosABB.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablaVehiculosABB.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(6).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(7).setPreferredWidth(50);
            tablaVehiculosABB.getColumnModel().getColumn(8).setPreferredWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1430, 210));

        btnInOrdenABB.setBackground(new java.awt.Color(44, 48, 57));
        btnInOrdenABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnInOrdenABB.setForeground(new java.awt.Color(255, 255, 51));
        btnInOrdenABB.setText("IN-ORDEN");
        btnInOrdenABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInOrdenABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInOrdenABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnInOrdenABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 110, 30));

        btnPreOrdenABB.setBackground(new java.awt.Color(44, 48, 57));
        btnPreOrdenABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPreOrdenABB.setForeground(new java.awt.Color(255, 255, 51));
        btnPreOrdenABB.setText("PRE-ORDEN");
        btnPreOrdenABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPreOrdenABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPreOrdenABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnPreOrdenABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, 30));

        btnPostOrdenABB.setBackground(new java.awt.Color(44, 48, 57));
        btnPostOrdenABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPostOrdenABB.setForeground(new java.awt.Color(255, 255, 51));
        btnPostOrdenABB.setText("POST-ORDEN");
        btnPostOrdenABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPostOrdenABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPostOrdenABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostOrdenABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnPostOrdenABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 110, 30));

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
        jPanel1.add(btnbuscarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 150, 30));

        jtextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlaca.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 20, 180, 30));

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
        jPanel1.add(btnEliminarVehiculoABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 260, 110, 30));

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
        jPanel1.add(btnInsertarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 260, 110, 30));

        tablaVehiculosAVL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DEPARTAMENTO", "PLACA", "DPI", "PROPIETARIO", "MARCA", "MODELO", "AÑO", "MULTAS", "TRASPASOS"
            }
        ));
        jScrollPane2.setViewportView(tablaVehiculosAVL);
        if (tablaVehiculosAVL.getColumnModel().getColumnCount() > 0) {
            tablaVehiculosAVL.getColumnModel().getColumn(1).setPreferredWidth(70);
            tablaVehiculosAVL.getColumnModel().getColumn(2).setPreferredWidth(110);
            tablaVehiculosAVL.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablaVehiculosAVL.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(6).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(7).setPreferredWidth(50);
            tablaVehiculosAVL.getColumnModel().getColumn(8).setPreferredWidth(70);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 1430, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("S.I.R.V.E. v3.0");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("DATOS DE VEHICULOS (ABB)");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 490, -1));

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
        jPanel1.add(btnInsertarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 610, 120, 30));

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
        jPanel1.add(btnEliminarVehiculoAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 610, 110, 30));

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
        jPanel1.add(btnbuscarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 360, 150, 30));

        jtextFieldPlacaAVL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlacaAVL.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlacaAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 360, 170, 30));

        btnVerArbolABB.setBackground(new java.awt.Color(44, 48, 57));
        btnVerArbolABB.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnVerArbolABB.setForeground(new java.awt.Color(255, 255, 51));
        btnVerArbolABB.setText("VER ARBOLITO");
        btnVerArbolABB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerArbolABB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerArbolABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerArbolABBActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerArbolABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 150, 30));

        btnPreOrdenAVL.setBackground(new java.awt.Color(44, 48, 57));
        btnPreOrdenAVL.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPreOrdenAVL.setForeground(new java.awt.Color(255, 255, 51));
        btnPreOrdenAVL.setText("PRE-ORDEN");
        btnPreOrdenAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPreOrdenAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPreOrdenAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrdenAVLActionPerformed(evt);
            }
        });
        jPanel1.add(btnPreOrdenAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 110, 30));

        btnInOrdenAVL.setBackground(new java.awt.Color(44, 48, 57));
        btnInOrdenAVL.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnInOrdenAVL.setForeground(new java.awt.Color(255, 255, 51));
        btnInOrdenAVL.setText("IN-ORDEN");
        btnInOrdenAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInOrdenAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInOrdenAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrdenAVLActionPerformed(evt);
            }
        });
        jPanel1.add(btnInOrdenAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, 110, 30));

        btnPostOrdenAVL.setBackground(new java.awt.Color(44, 48, 57));
        btnPostOrdenAVL.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPostOrdenAVL.setForeground(new java.awt.Color(255, 255, 51));
        btnPostOrdenAVL.setText("POST-ORDEN");
        btnPostOrdenAVL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPostOrdenAVL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPostOrdenAVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostOrdenAVLActionPerformed(evt);
            }
        });
        jPanel1.add(btnPostOrdenAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 110, 30));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jgald\\Downloads\\final.png")); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1880, 870));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setBackground(new java.awt.Color(51, 255, 255));
        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
        jMenu1.setText("DATOS");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cargarDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cargarDatos.setText("CARGAR  CARPETA");
        cargarDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosActionPerformed(evt);
            }
        });
        jMenu1.add(cargarDatos);

        modificarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        modificarVehiculo.setText("MODIFICAR VEHICULO");
        modificarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarVehiculoActionPerformed(evt);
            }
        });
        jMenu1.add(modificarVehiculo);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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
                v.getDepartamento(),
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
                v.getDepartamento(),
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


    private void btnPreOrdenABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreOrdenABBActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0);
        llenarTablaPreOrdenABB(arbolito.raiz, modelo);
    }//GEN-LAST:event_btnPreOrdenABBActionPerformed

    private void btnPostOrdenABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostOrdenABBActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0);
        llenarTablaPostOrdenABB(arbolito.raiz, modelo);
    }//GEN-LAST:event_btnPostOrdenABBActionPerformed


    private void btnInOrdenABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrdenABBActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
        modelo.setRowCount(0); // limpiar tabla
        llenarTablaInOrdenABB(arbolito.raiz, modelo);
    }//GEN-LAST:event_btnInOrdenABBActionPerformed

    private void llenarTablaInOrdenABB(NodoArbol nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaInOrdenABB(nodo.HijoIzquierdo, modelo);
            agregarFilaABB(nodo.vehiculo, modelo);
            llenarTablaInOrdenABB(nodo.HijoDerecho, modelo);
        }
    }

    private void llenarTablaPreOrdenABB(NodoArbol nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            agregarFilaABB(nodo.vehiculo, modelo);
            llenarTablaPreOrdenABB(nodo.HijoIzquierdo, modelo);
            llenarTablaPreOrdenABB(nodo.HijoDerecho, modelo);
        }
    }

    private void llenarTablaPostOrdenABB(NodoArbol nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaPostOrdenABB(nodo.HijoIzquierdo, modelo);
            llenarTablaPostOrdenABB(nodo.HijoDerecho, modelo);
            agregarFilaABB(nodo.vehiculo, modelo);
        }
    }

    private void agregarFilaABB(Vehiculos v, DefaultTableModel modelo) {
        Object[] fila = {
            v.getDepartamento(),
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


    private void btnInsertarABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarABBActionPerformed
        FormularioInsertarVehiculo dialogo = new FormularioInsertarVehiculo(
                this, true, arbolito, tablaVehiculosABB, cronometro
        );
        dialogo.setLocationRelativeTo(this); // centrar
        dialogo.setVisible(true);            // mostrar formulario

        /*try {
            // 1. Solicitar departamento
            String departamento = JOptionPane.showInputDialog("Ingrese el departamento:");
            if (departamento == null || departamento.trim().isEmpty()) {
                return;
            }
            departamento = departamento.trim();

            // 2. Solicitar placa
            String placa = JOptionPane.showInputDialog("Ingrese la placa:");
            if (placa == null || placa.trim().isEmpty()) {
                return;
            }
            placa = placa.toUpperCase();

            // 3. Verificar duplicado
            if (arbolito.BuscarVehiculo(placa) != null) {
                JOptionPane.showMessageDialog(this,
                        "Ya existe un vehículo con la placa " + placa + ".");
                return;
            }

            // 4. Resto de datos
            String dpi = JOptionPane.showInputDialog("Ingrese el DPI del propietario:");
            String nombre = JOptionPane.showInputDialog("Ingrese el Nombre del propietario:");
            String marca = JOptionPane.showInputDialog("Ingrese la marca:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año:"));
            int multas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de multas:"));
            int traspasos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de traspasos:"));

            // 5. Crear objeto y medir tiempo
            cronometro.iniciar();
            Vehiculos nuevo = new Vehiculos(
                    departamento,
                    placa,
                    dpi,
                    nombre,
                    marca,
                    modelo,
                    anio,
                    multas,
                    traspasos
            );

            // 6. Insertar en ABB
            if (arbolito.insertarVehiculo(nuevo)) {
                // 7. Agregar fila incluyendo Departamento al inicio
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaVehiculosABB.getModel();
                Object[] fila = {
                    nuevo.getDepartamento(),
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

                JOptionPane.showMessageDialog(this,
                        "Vehículo insertado con éxito.\n" + cronometro.detenerComoTexto());
            } else {
                JOptionPane.showMessageDialog(this,
                        "No se pudo insertar el vehículo (duplicado).\n" + cronometro.detenerComoTexto());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Error en datos numéricos: " + e.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Ocurrió un error inesperado: " + ex.getMessage());
        }*/
    }//GEN-LAST:event_btnInsertarABBActionPerformed


    private void btnInsertarAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarAVLActionPerformed
        FormularioInsertarVehiculo dialogo = new FormularioInsertarVehiculo(
                this, true, arbolitoAVL, tablaVehiculosAVL, cronometro
        );
        dialogo.setLocationRelativeTo(this); // centrar
        dialogo.setVisible(true);

    }//GEN-LAST:event_btnInsertarAVLActionPerformed

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

    private void btnVerArbolABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerArbolABBActionPerformed
        arbolito.exportarABBComoImagen(arbolito);
    }//GEN-LAST:event_btnVerArbolABBActionPerformed

    private void cargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarDatosActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Selecciona la carpeta principal (SIRVE_Datos_Vehiculos DataSet)");

        int seleccion = chooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = chooser.getSelectedFile();
            String ruta = carpetaSeleccionada.getAbsolutePath();

            // Llama al gestor para cargar todo
            gestor.cargarTodoDesdeCarpeta(ruta, arbolito, arbolitoAVL);

            // Refrescar tabla ABB
            DefaultTableModel modeloABB = (DefaultTableModel) tablaVehiculosABB.getModel();
            modeloABB.setRowCount(0);
            llenarTablaDesdeABB(arbolito.raiz, modeloABB);

            // Refrescar tabla AVL
            DefaultTableModel modeloAVL = (DefaultTableModel) tablaVehiculosAVL.getModel();
            modeloAVL.setRowCount(0);
            llenarTablaDesdeAVL(arbolitoAVL.getRaiz(), modeloAVL);
        }
    }//GEN-LAST:event_cargarDatosActionPerformed

    private void btnPreOrdenAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreOrdenAVLActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosAVL.getModel();
        modelo.setRowCount(0);
        llenarTablaPreOrdenAVL(arbolitoAVL.getRaiz(), modelo);
    }//GEN-LAST:event_btnPreOrdenAVLActionPerformed

    private void btnInOrdenAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrdenAVLActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosAVL.getModel();
        modelo.setRowCount(0);
        llenarTablaInOrdenAVL(arbolitoAVL.getRaiz(), modelo);
    }//GEN-LAST:event_btnInOrdenAVLActionPerformed

    private void btnPostOrdenAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostOrdenAVLActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosAVL.getModel();
        modelo.setRowCount(0);
        llenarTablaPostOrdenAVL(arbolitoAVL.getRaiz(), modelo);
    }//GEN-LAST:event_btnPostOrdenAVLActionPerformed

    private void modificarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarVehiculoActionPerformed
        int fila = tablaVehiculosABB.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        // Confirmación
        int opcion = JOptionPane.showConfirmDialog(this,
                "Se va a modificar el vehículo y se actualizará en ABB y AVL.\n¿Desea continuar?",
                "Confirmación de modificación",
                JOptionPane.YES_NO_OPTION);
        if (opcion != JOptionPane.YES_OPTION) {
            return;
        }

        // Obtener placa desde la tabla ABB (columna 1)
        String placa = tablaVehiculosABB.getValueAt(fila, 1).toString();
        NodoArbol nodoABB = arbolito.BuscarVehiculo(placa);
        if (nodoABB == null) {
            JOptionPane.showMessageDialog(this, "Vehículo no encontrado");
            return;
        }

        // Mostrar formulario
        FormularioModificarVehiculo form = new FormularioModificarVehiculo(this, true, nodoABB.vehiculo, tablaVehiculosABB, fila);
        form.setLocationRelativeTo(this);
        form.setVisible(true);

        // 🔄 Luego de cerrar el formulario, actualizar también la tabla AVL
        NodoArbolAVL nodoAVL = arbolitoAVL.buscar(placa);
        if (nodoAVL != null) {
            Vehiculos v = nodoAVL.vehiculo;

            // Buscar fila en tabla AVL que coincida con la placa
            for (int i = 0; i < tablaVehiculosAVL.getRowCount(); i++) {
                String placaAVL = tablaVehiculosAVL.getValueAt(i, 1).toString();
                if (placaAVL.equalsIgnoreCase(placa)) {
                    DefaultTableModel modeloAVL = (DefaultTableModel) tablaVehiculosAVL.getModel();
                    modeloAVL.setValueAt(v.getDepartamento(), i, 0);
                    modeloAVL.setValueAt(v.getPlaca(), i, 1);
                    modeloAVL.setValueAt(v.getDpi(), i, 2);
                    modeloAVL.setValueAt(v.getNombrePropietario(), i, 3);
                    modeloAVL.setValueAt(v.getMarca(), i, 4);
                    modeloAVL.setValueAt(v.getModelo(), i, 5);
                    modeloAVL.setValueAt(v.getAnio(), i, 6);
                    modeloAVL.setValueAt(v.getCantidadMultas(), i, 7);
                    modeloAVL.setValueAt(v.getCantidadTraspasos(), i, 8);
                    break;
                }
            }
        }
    }//GEN-LAST:event_modificarVehiculoActionPerformed
    private void llenarTablaInOrdenAVL(NodoArbolAVL nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaInOrdenAVL(nodo.izquierdo, modelo);
            agregarFilaAVL(nodo.vehiculo, modelo);
            llenarTablaInOrdenAVL(nodo.derecho, modelo);
        }
    }

    private void llenarTablaPreOrdenAVL(NodoArbolAVL nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            agregarFilaAVL(nodo.vehiculo, modelo);
            llenarTablaPreOrdenAVL(nodo.izquierdo, modelo);
            llenarTablaPreOrdenAVL(nodo.derecho, modelo);
        }
    }

    private void llenarTablaPostOrdenAVL(NodoArbolAVL nodo, DefaultTableModel modelo) {
        if (nodo != null) {
            llenarTablaPostOrdenAVL(nodo.izquierdo, modelo);
            llenarTablaPostOrdenAVL(nodo.derecho, modelo);
            agregarFilaAVL(nodo.vehiculo, modelo);
        }
    }

    private void agregarFilaAVL(Vehiculos v, DefaultTableModel modelo) {
        Object[] fila = {
            v.getDepartamento(),
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
    private javax.swing.JButton btnInOrdenABB;
    private javax.swing.JButton btnInOrdenAVL;
    private javax.swing.JButton btnInsertarABB;
    private javax.swing.JButton btnInsertarAVL;
    private javax.swing.JButton btnPostOrdenABB;
    private javax.swing.JButton btnPostOrdenAVL;
    private javax.swing.JButton btnPreOrdenABB;
    private javax.swing.JButton btnPreOrdenAVL;
    private javax.swing.JButton btnVerArbolABB;
    private javax.swing.JButton btnbuscarABB;
    private javax.swing.JButton btnbuscarAVL;
    private javax.swing.JMenuItem cargarDatos;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtextFieldPlaca;
    private javax.swing.JTextField jtextFieldPlacaAVL;
    private javax.swing.JMenuItem modificarVehiculo;
    private javax.swing.JTable tablaVehiculosABB;
    private javax.swing.JTable tablaVehiculosAVL;
    // End of variables declaration//GEN-END:variables
}
