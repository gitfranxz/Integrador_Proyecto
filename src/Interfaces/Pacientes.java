package Interfaces;

import Controlador.PacientesCTRL;
import Logica.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author macac
 */
public final class Pacientes extends javax.swing.JFrame {

    private final DefaultTableModel modelo;

    public Pacientes() {
        initComponents();

        ((AbstractDocument) txtDNI_Paciente.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int limit = 8; // Establece el límite de caracteres permitidos

            @Override
            public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length()) <= limit) {
                    super.insertString(fb, offset, str, attr);
                } else {
                    // Muestra el mensaje emergente de advertencia
                    JOptionPane.showMessageDialog(null, "Ha sobrepasado el número máximo de caracteres permitidos por campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int overLimit = (currentLength + str.length()) - limit;
                if (overLimit > 0) {
                    str = str.substring(0, str.length() - overLimit);
                    // Muestra el mensaje emergente de advertencia
                    JOptionPane.showMessageDialog(null, "Ha sobrepasado el número máximo de caracteres permitidos por campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                if (currentLength - length + str.length() <= limit) {
                    super.replace(fb, offset, length, str, attrs);
                }
            }
        });
        ((AbstractDocument) txtTelf_Paciente.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int limit = 9; // Establece el límite de caracteres permitidos

            @Override
            public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length()) <= limit) {
                    super.insertString(fb, offset, str, attr);
                } else {
                    // Muestra el mensaje emergente de advertencia
                    JOptionPane.showMessageDialog(null, "Ha sobrepasado el número máximo de caracteres permitidos por campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int overLimit = (currentLength + str.length()) - limit;
                if (overLimit > 0) {
                    str = str.substring(0, str.length() - overLimit);
                    // Muestra el mensaje emergente de advertencia
                    JOptionPane.showMessageDialog(null, "Ha sobrepasado el número máximo de caracteres permitidos por campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                if (currentLength - length + str.length() <= limit) {
                    super.replace(fb, offset, length, str, attrs);
                }
            }
        });
        ((AbstractDocument) txtContac_Emer_Paciente.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int limit = 9; // Establece el límite de caracteres permitidos

            @Override
            public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
                if ((fb.getDocument().getLength() + str.length()) <= limit) {
                    super.insertString(fb, offset, str, attr);
                } else {
                    // Muestra el mensaje emergente de advertencia
                    JOptionPane.showMessageDialog(null, "Ha sobrepasado el número máximo de caracteres permitidos por campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
                int currentLength = fb.getDocument().getLength();
                int overLimit = (currentLength + str.length()) - limit;
                if (overLimit > 0) {
                    str = str.substring(0, str.length() - overLimit);
                    // Muestra el mensaje emergente de advertencia
                    JOptionPane.showMessageDialog(null, "Ha sobrepasado el número máximo de caracteres permitidos por campo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                if (currentLength - length + str.length() <= limit) {
                    super.replace(fb, offset, length, str, attrs);
                }
            }
        });
        ((AbstractDocument) txtFecha_Nac_Paciente.getDocument()).setDocumentFilter(new DocumentFilter() {
    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
        StringBuilder sb = new StringBuilder(str);

        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (!Character.isDigit(ch)) {
                sb.deleteCharAt(i);
            }
        }

        if (sb.length() > 8) {
            sb.delete(8, sb.length());
        }

        if (sb.length() >= 5) {
            sb.insert(4, '-');
        }
        if (sb.length() >= 8) {
            sb.insert(7, '-');
        }

        super.insertString(fb, offset, sb.toString(), attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
        if (str == null) {
            super.replace(fb, offset, length, null, attrs);
            return;
        }

        StringBuilder sb = new StringBuilder(str);

        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (!Character.isDigit(ch)) {
                sb.deleteCharAt(i);
            }
        }

        if (sb.length() > 8) {
            sb.delete(8, sb.length());
        }

        if (sb.length() >= 5) {
            sb.insert(4, '-');
        }
        if (sb.length() >= 8) {
            sb.insert(7, '-');
        }

        super.replace(fb, offset, length, sb.toString(), attrs);
    }
});

        modelo = new DefaultTableModel(null, new String[]{"DNI", "NOMBRES", "APELLIDOS", "NACIMIENTO", "GENERO", "TELEFONO", "EMERGENCIA"}) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        tblPacientes.setModel(modelo);

        cargarDatosPacientes();

        tblPacientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int filaSeleccionada = tblPacientes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    mostrarDatosPaciente(filaSeleccionada);
                }
            }
        });

        txtBuscarPaciente.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent evt) {
                buscarPacientePorDNIParecido();
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent evt) {
                buscarPacientePorDNIParecido();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent evt) {
                buscarPacientePorDNIParecido();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDNI_Paciente = new javax.swing.JTextField();
        txtNombres_Paciente = new javax.swing.JTextField();
        txtApellidos_Paciente = new javax.swing.JTextField();
        txtFecha_Nac_Paciente = new javax.swing.JTextField();
        txtGenero_Paciente = new javax.swing.JTextField();
        txtTelf_Paciente = new javax.swing.JTextField();
        txtContac_Emer_Paciente = new javax.swing.JTextField();
        btnRegistrarPacientes = new javax.swing.JButton();
        btnEditarPacientes = new javax.swing.JButton();
        btnBorrarPacientes = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        btnBuscarPaciente = new javax.swing.JButton();
        txtBuscarPaciente = new javax.swing.JTextField();
        btnVolverPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setText("Genero:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Contacto de Emergencia:");

        btnRegistrarPacientes.setText("Registrar");
        btnRegistrarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPacientesActionPerformed(evt);
            }
        });

        btnEditarPacientes.setText("Editar");
        btnEditarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPacientesActionPerformed(evt);
            }
        });

        btnBorrarPacientes.setText("Borrar");
        btnBorrarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPacientesActionPerformed(evt);
            }
        });

        btnCancelar.setText("Limpiar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPacientes.setFillsViewportHeight(true);
        tblPacientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblPacientes);

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        txtBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPacienteActionPerformed(evt);
            }
        });

        btnVolverPrincipal.setText("Volver");
        btnVolverPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(33, 33, 33)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDNI_Paciente)
                                        .addComponent(txtNombres_Paciente)
                                        .addComponent(txtApellidos_Paciente)
                                        .addComponent(txtFecha_Nac_Paciente)
                                        .addComponent(txtTelf_Paciente)
                                        .addComponent(txtGenero_Paciente)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtContac_Emer_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistrarPacientes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEditarPacientes))
                                    .addComponent(txtBuscarPaciente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrarPacientes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarPaciente)
                                    .addComponent(btnCancelar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnVolverPrincipal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarPaciente)
                            .addComponent(txtBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarPacientes)
                            .addComponent(btnEditarPacientes)
                            .addComponent(btnBorrarPacientes)
                            .addComponent(btnCancelar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDNI_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombres_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidos_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFecha_Nac_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGenero_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelf_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtContac_Emer_Paciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addComponent(btnVolverPrincipal))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPacientesActionPerformed

        Conexion objConexion = new Conexion();

        try {
            PacientesCTRL oPacientes = recuperarDatosDeInterfaz();

            String strSentenciaInsert = "INSERT INTO pacientes (p_dni, p_nombres, p_apellidos, p_fecha_nacimiento, p_genero, p_telefono, p_emergencia_contacto) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaInsert);

            pstmt.setInt(1, oPacientes.getP_dni());
            pstmt.setString(2, oPacientes.getP_nombres());
            pstmt.setString(3, oPacientes.getP_apellidos());
            pstmt.setString(4, oPacientes.getP_fecha_nacimiento());
            pstmt.setString(5, oPacientes.getP_genero());
            pstmt.setInt(6, oPacientes.getP_telefono());
            pstmt.setInt(7, oPacientes.getP_emergencia_contacto());

            pstmt.executeUpdate();

            mostrarDatosPaciente(oPacientes);

            ResultSet resultado = objConexion.consultar("SELECT * FROM pacientes");

            while (resultado.next()) {
                System.out.println(resultado.getString("p_dni"));
                System.out.println(resultado.getString("p_nombres"));
                System.out.println(resultado.getString("p_apellidos"));
                System.out.println(resultado.getString("p_fecha_nacimiento"));
                System.out.println(resultado.getString("p_genero"));
                System.out.println(resultado.getString("p_telefono"));
                System.out.println(resultado.getString("p_emergencia_contacto"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarPacientesActionPerformed

    private void btnEditarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPacientesActionPerformed
        int filaSeleccionada = tblPacientes.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de hacer estos cambios?", "Confirmar cambios", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                PacientesCTRL paciente = recuperarDatosDeInterfaz();
                editarDatosPaciente(filaSeleccionada, paciente);
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
        }
    }//GEN-LAST:event_btnEditarPacientesActionPerformed
    private void editarDatosPaciente(int fila, PacientesCTRL paciente) {
        modelo.setValueAt(paciente.getP_dni(), fila, 0);
        modelo.setValueAt(paciente.getP_nombres(), fila, 1);
        modelo.setValueAt(paciente.getP_apellidos(), fila, 2);
        modelo.setValueAt(paciente.getP_fecha_nacimiento(), fila, 3);
        modelo.setValueAt(paciente.getP_genero(), fila, 4);
        modelo.setValueAt(paciente.getP_telefono(), fila, 5);
        modelo.setValueAt(paciente.getP_emergencia_contacto(), fila, 6);

        Conexion objConexion = new Conexion();
        try {
            String strSentenciaUpdate = "UPDATE pacientes SET p_nombres = ?, p_apellidos = ?, p_fecha_nacimiento = ?, p_genero = ?, p_telefono = ?, p_emergencia_contacto = ? WHERE p_dni = ?";
            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaUpdate);
            pstmt.setString(1, paciente.getP_nombres());
            pstmt.setString(2, paciente.getP_apellidos());
            pstmt.setString(3, paciente.getP_fecha_nacimiento());
            pstmt.setString(4, paciente.getP_genero());
            pstmt.setInt(5, paciente.getP_telefono());
            pstmt.setInt(6, paciente.getP_emergencia_contacto());
            pstmt.setInt(8, paciente.getP_dni());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL de actualización: " + e.getMessage());
        }
    }

    /*Masterpassword jdah237utp*/
    private void btnBorrarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPacientesActionPerformed
        int filaSeleccionada = tblPacientes.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String contraseniaMaestra = "jdah237utp";
            String contraseniaIngresada = JOptionPane.showInputDialog(this, "Ingrese la contraseña maestra:");
            if (contraseniaIngresada != null && contraseniaIngresada.equals(contraseniaMaestra)) {
                eliminarFilaSeleccionada(filaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(this, "Contraseña incorrecta. No se pudo eliminar la fila.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
    }//GEN-LAST:event_btnBorrarPacientesActionPerformed
    private void eliminarFilaSeleccionada(int fila) {
        int dni = Integer.parseInt((String) modelo.getValueAt(fila, 0));
        modelo.removeRow(fila);

        Conexion objConexion = new Conexion();

        limpiarCampos();

        try {
            String strSentenciaDelete = "DELETE FROM pacientes WHERE p_dni = ?";
            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaDelete);
            pstmt.setInt(1, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL de eliminación: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtDNI_Paciente.setText("");
        txtNombres_Paciente.setText("");
        txtApellidos_Paciente.setText("");
        txtFecha_Nac_Paciente.setText("");
        txtGenero_Paciente.setText("");
        txtTelf_Paciente.setText("");
        txtContac_Emer_Paciente.setText("");
        txtBuscarPaciente.setText("");
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPacienteActionPerformed

    }//GEN-LAST:event_txtBuscarPacienteActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed

    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void buscarPacientePorDNIParecido() {
        String dniBuscar = txtBuscarPaciente.getText();
        modelo.setRowCount(0); // Limpiar la tabla antes de agregar los resultados de la búsqueda

        Conexion objConexion = new Conexion();
        try {
            String strSentenciaSelect = "SELECT * FROM pacientes WHERE p_dni LIKE ?";
            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaSelect);
            pstmt.setString(1, dniBuscar + "%");
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                Object[] fila = {
                    resultado.getString("p_dni"),
                    resultado.getString("p_nombres"),
                    resultado.getString("p_apellidos"),
                    resultado.getString("p_fecha_nacimiento"),
                    resultado.getString("p_genero"),
                    resultado.getString("p_telefono"),
                    resultado.getString("p_emergencia_contacto"),
                };
                modelo.addRow(fila);
            }

            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No se encontraron resultados para el DNI especificado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL de búsqueda: " + e.getMessage());
        }
    }

    private void btnVolverPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverPrincipalActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverPrincipalActionPerformed

    public PacientesCTRL recuperarDatosDeInterfaz() {
        PacientesCTRL oPacientes = new PacientesCTRL();

        int DNI = (txtDNI_Paciente.getText().isEmpty()) ? 0 : Integer.parseInt(txtDNI_Paciente.getText());

        oPacientes.setP_dni(DNI);
        oPacientes.setP_nombres(txtNombres_Paciente.getText());
        oPacientes.setP_apellidos(txtApellidos_Paciente.getText());
        oPacientes.setP_fecha_nacimiento(txtFecha_Nac_Paciente.getText());
        oPacientes.setP_genero(txtGenero_Paciente.getText());
        int telefono = Integer.parseInt(txtTelf_Paciente.getText());
        oPacientes.setP_telefono(telefono);
        int emergenciaContacto = Integer.parseInt(txtContac_Emer_Paciente.getText());
        oPacientes.setP_emergencia_contacto(emergenciaContacto);

        return oPacientes;

    }

    public void mostrarDatosPaciente(PacientesCTRL paciente) {
        Object[] fila = {
            paciente.getP_dni(),
            paciente.getP_nombres(),
            paciente.getP_apellidos(),
            paciente.getP_fecha_nacimiento(),
            paciente.getP_genero(),
            paciente.getP_telefono(),
            paciente.getP_emergencia_contacto(),
        };
        modelo.addRow(fila);
    }

    public void mostrarDatosPaciente(int fila) {
        String dni = tblPacientes.getValueAt(fila, 0).toString();
        String nombres = tblPacientes.getValueAt(fila, 1).toString();
        String apellidos = tblPacientes.getValueAt(fila, 2).toString();
        String fechaNacimiento = tblPacientes.getValueAt(fila, 3).toString();
        String genero = tblPacientes.getValueAt(fila, 4).toString();
        String telefono = tblPacientes.getValueAt(fila, 5).toString();
        String emergenciaContacto = tblPacientes.getValueAt(fila, 6).toString();

        txtDNI_Paciente.setText(dni);
        txtNombres_Paciente.setText(nombres);
        txtApellidos_Paciente.setText(apellidos);
        txtFecha_Nac_Paciente.setText(fechaNacimiento);
        txtGenero_Paciente.setText(genero);
        txtTelf_Paciente.setText(telefono);
        txtContac_Emer_Paciente.setText(emergenciaContacto);
    }

    public void cargarDatosPacientes() {
        Conexion objConexion = new Conexion();

        try {
            ResultSet resultado = objConexion.consultar("SELECT * FROM pacientes");

            while (resultado.next()) {
                Object[] fila = {
                    resultado.getString("p_dni"),
                    resultado.getString("p_nombres"),
                    resultado.getString("p_apellidos"),
                    resultado.getString("p_fecha_nacimiento"),
                    resultado.getString("p_genero"),
                    resultado.getString("p_telefono"),
                    resultado.getString("p_emergencia_contacto"),
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos de los pacientes: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Pacientes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarPacientes;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarPacientes;
    private javax.swing.JButton btnRegistrarPacientes;
    private javax.swing.JButton btnVolverPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtApellidos_Paciente;
    private javax.swing.JTextField txtBuscarPaciente;
    private javax.swing.JTextField txtContac_Emer_Paciente;
    private javax.swing.JTextField txtDNI_Paciente;
    private javax.swing.JTextField txtFecha_Nac_Paciente;
    private javax.swing.JTextField txtGenero_Paciente;
    private javax.swing.JTextField txtNombres_Paciente;
    private javax.swing.JTextField txtTelf_Paciente;
    // End of variables declaration//GEN-END:variables
}
