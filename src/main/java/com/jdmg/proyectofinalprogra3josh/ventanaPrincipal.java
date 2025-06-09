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
        jLabel5 = new javax.swing.JLabel();
        btnInsertarAVL = new javax.swing.JButton();
        btnEliminarVehiculoAVL = new javax.swing.JButton();
        btnbuscarAVL = new javax.swing.JButton();
        jtextFieldPlacaAVL = new javax.swing.JTextField();
        btnVerArbolABB = new javax.swing.JButton();
        btnPreOrdenAVL = new javax.swing.JButton();
        btnInOrdenAVL = new javax.swing.JButton();
        btnPostOrdenAVL = new javax.swing.JButton();
        btnModificarABB = new javax.swing.JButton();
        btnModificarAVL = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cargarDatos = new javax.swing.JMenuItem();
        VerMultas = new javax.swing.JMenuItem();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1430, 240));

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
        jPanel1.add(btnInOrdenABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 110, 30));

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
        jPanel1.add(btnPreOrdenABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 110, 30));

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
        jPanel1.add(btnPostOrdenABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 110, 30));

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
        jPanel1.add(btnbuscarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, 150, 30));

        jtextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlaca.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 70, 180, 30));

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
        jPanel1.add(btnEliminarVehiculoABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 340, 110, 30));

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
        jPanel1.add(btnInsertarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 340, 110, 30));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 1430, 240));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATOS EN (AVL)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 490, -1));

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
        jPanel1.add(btnInsertarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 680, 120, 30));

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
        jPanel1.add(btnEliminarVehiculoAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 680, 110, 30));

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
        jPanel1.add(btnbuscarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 410, 150, 30));

        jtextFieldPlacaAVL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtextFieldPlacaAVL.setText("Ingrese No. Placa");
        jPanel1.add(jtextFieldPlacaAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 410, 170, 30));

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
        jPanel1.add(btnVerArbolABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 100, 30));

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
        jPanel1.add(btnPreOrdenAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, 110, 30));

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
        jPanel1.add(btnInOrdenAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 680, 110, 30));

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
        jPanel1.add(btnPostOrdenAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 680, 110, 30));

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
        jPanel1.add(btnModificarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 340, 110, 30));

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
        jPanel1.add(btnModificarAVL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 680, 120, 30));

        jLabel6.setBackground(new java.awt.Color(153, 204, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 204));
        jLabel6.setText("DATOS EN (ABB)");
        jLabel6.setToolTipText("");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 490, -1));

        fondo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\jgald\\Downloads\\final.png")); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1880, 800));

        jLabel8.setBackground(new java.awt.Color(153, 204, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("VEHICULOS REGISTRADOS POR DEPARTAMENTO");
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 1340, 50));

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

        VerMultas.setText("VER MULTAS");
        VerMultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerMultasActionPerformed(evt);
            }
        });
        jMenu1.add(VerMultas);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ArbolBinario arbolito = new ArbolBinario();
    ArbolBinarioAVL arbolitoAVL = new ArbolBinarioAVL();
    ListaDobleMultas listaMultas = new ListaDobleMultas();
    GestorArchivos gestor = new GestorArchivos();
    Cronometro cronometro = new Cronometro();

    public void llenarTablaDesdeABB(NodoArbol nodo, DefaultTableModel modelo) {
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

    public void llenarTablaDesdeAVL(NodoArbolAVL nodo, DefaultTableModel modelo) {
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
            String placaBuscada = jtextFieldPlaca.getText().trim().toUpperCase();

            if (placaBuscada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese una placa para buscar.");
                return;
            }

            NodoArbol resultado = arbolito.BuscarVehiculoABB(placaBuscada);

            if (resultado != null) {
                Vehiculos v = resultado.vehiculo;

                // 1. Mostrar datos con formato bonito
                StringBuilder info = new StringBuilder("✅ VEHÍCULO ENCONTRADO\n\n");
                info.append("🗂 Departamento: ").append(v.getDepartamento()).append("\n");
                info.append("🚗 Placa: ").append(v.getPlaca()).append("\n");
                info.append("🆔 DPI: ").append(v.getDpi()).append("\n");
                info.append("👤 Propietario: ").append(v.getNombrePropietario()).append("\n");
                info.append("🔧 Marca: ").append(v.getMarca()).append("\n");
                info.append("📦 Modelo: ").append(v.getModelo()).append("\n");
                info.append("📅 Año: ").append(v.getAnio()).append("\n");
                info.append("🚓 Multas: ").append(v.getCantidadMultas()).append("\n");
                info.append("🔁 Traspasos: ").append(v.getCantidadTraspasos()).append("\n");
                info.append("\n⏱ ").append(cronometro.detenerComoTexto());

                JOptionPane.showMessageDialog(this, info.toString(), "Resultado de búsqueda", JOptionPane.INFORMATION_MESSAGE);

                // 2. Resaltar la fila en el JTable
                DefaultTableModel modelo = (DefaultTableModel) tablaVehiculosABB.getModel();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String placaFila = modelo.getValueAt(i, 1).toString(); // Columna 1 = PLACA
                    if (placaFila.equalsIgnoreCase(placaBuscada)) {
                        tablaVehiculosABB.setRowSelectionInterval(i, i); // Seleccionar fila
                        tablaVehiculosABB.scrollRectToVisible(tablaVehiculosABB.getCellRect(i, 0, true)); // Hacer visible
                        break;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this,
                        "🚫 Vehículo no encontrado con placa: " + placaBuscada + "\n" + cronometro.detenerComoTexto(),
                        "No encontrado", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.\n" + cronometro.detenerComoTexto());
        }
    }//GEN-LAST:event_btnbuscarABBActionPerformed

    private void btnEliminarVehiculoABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVehiculoABBActionPerformed
        int filaSeleccionada = tablaVehiculosABB.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
            return;
        }

        String placa = tablaVehiculosABB.getValueAt(filaSeleccionada, 1).toString();
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

        String placa = tablaVehiculosAVL.getValueAt(filaSeleccionada, 1).toString();
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

        NodoArbolAVL nodo = arbolitoAVL.BuscarVehiculoAVL(placa);

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
            gestor.cargarTodoDesdeCarpeta(ruta, arbolito, arbolitoAVL, listaMultas);

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

    private void btnModificarABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarABBActionPerformed
        int filaSeleccionada = tablaVehiculosABB.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        String placa = tablaVehiculosABB.getValueAt(filaSeleccionada, 1).toString(); // columna 1 = PLACA
        NodoArbol nodo = arbolito.BuscarVehiculoABB(placa);

        if (nodo != null) {
            Vehiculos vehiculo = nodo.vehiculo;
            FormularioModificarVehiculo dialog = new FormularioModificarVehiculo(this, true, vehiculo, tablaVehiculosABB, filaSeleccionada);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo.");
        }
    }//GEN-LAST:event_btnModificarABBActionPerformed

    private void btnModificarAVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAVLActionPerformed
        int filaSeleccionada = tablaVehiculosAVL.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.");
            return;
        }

        String placa = tablaVehiculosAVL.getValueAt(filaSeleccionada, 1).toString(); // columna 1 = PLACA
        NodoArbolAVL nodo = arbolitoAVL.BuscarVehiculoAVL(placa);

        if (nodo != null) {
            Vehiculos vehiculo = nodo.vehiculo;
            FormularioModificarVehiculo dialog = new FormularioModificarVehiculo(this, true, vehiculo, tablaVehiculosAVL, filaSeleccionada);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el vehículo.");
        }


    }//GEN-LAST:event_btnModificarAVLActionPerformed

    private void VerMultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerMultasActionPerformed
        ventanaMultas vm = new ventanaMultas(this, arbolito, arbolitoAVL, tablaVehiculosABB, tablaVehiculosAVL);
        vm.llenarMultas(listaMultas); // Aquí se pasa la lista cargada
        vm.setLocationRelativeTo(this);
        vm.setVisible(true);
        this.setVisible(false); // Oculta ventana principal temporalmente
    }//GEN-LAST:event_VerMultasActionPerformed
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
    private javax.swing.JMenuItem VerMultas;
    private javax.swing.JButton btnEliminarVehiculoABB;
    private javax.swing.JButton btnEliminarVehiculoAVL;
    private javax.swing.JButton btnInOrdenABB;
    private javax.swing.JButton btnInOrdenAVL;
    private javax.swing.JButton btnInsertarABB;
    private javax.swing.JButton btnInsertarAVL;
    private javax.swing.JButton btnModificarABB;
    private javax.swing.JButton btnModificarAVL;
    private javax.swing.JButton btnPostOrdenABB;
    private javax.swing.JButton btnPostOrdenAVL;
    private javax.swing.JButton btnPreOrdenABB;
    private javax.swing.JButton btnPreOrdenAVL;
    private javax.swing.JButton btnVerArbolABB;
    private javax.swing.JButton btnbuscarABB;
    private javax.swing.JButton btnbuscarAVL;
    private javax.swing.JMenuItem cargarDatos;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtextFieldPlaca;
    private javax.swing.JTextField jtextFieldPlacaAVL;
    private javax.swing.JTable tablaVehiculosABB;
    private javax.swing.JTable tablaVehiculosAVL;
    // End of variables declaration//GEN-END:variables
}
