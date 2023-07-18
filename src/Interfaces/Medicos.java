/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Controlador.MedicoCTRL;
import Logica.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macac
 */
public final class Medicos extends javax.swing.JFrame {

    private final DefaultTableModel modelo;

    public Medicos() {
        initComponents();

        modelo = new DefaultTableModel(null, new String[]{"DNI", "NOMBRE", "APELLIDO", "ESPECIALIDAD", "COMENTARIO"}) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        tblMedicos.setModel(modelo);

        cargarDatosMedicos();

        tblMedicos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int filaSeleccionada = tblMedicos.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    mostrarDatosMedico(filaSeleccionada);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarMedico = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDniMedico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreMedico = new javax.swing.JTextField();
        txtApellidoMedico = new javax.swing.JTextField();
        cmbEspecialidadMedico = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentarioMedico = new javax.swing.JTextArea();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMedicos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Creacion de Doctor");

        btnBuscarMedico.setText("Buscar");
        btnBuscarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMedicoActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Especialidad:");

        cmbEspecialidadMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina General", "Pediatria", "Obstetricia", "Radiologia", "Cardiologia", "Neumologia", "Terapia Fisica", "Psicologia", "Urologia" }));
        cmbEspecialidadMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEspecialidadMedicoActionPerformed(evt);
            }
        });

        jLabel7.setText("Comentarios del Administrador:");

        txtComentarioMedico.setColumns(20);
        txtComentarioMedico.setRows(5);
        jScrollPane2.setViewportView(txtComentarioMedico);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(109, 109, 109))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnRegistrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEditar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnBuscarMedico))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLimpiar)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbEspecialidadMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApellidoMedico))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(34, 34, 34)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVolver))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar)
                            .addComponent(btnBuscarMedico))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbEspecialidadMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(btnVolver)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEspecialidadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEspecialidadMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEspecialidadMedicoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        Conexion objConexion = new Conexion();

        try {
            MedicoCTRL medico = recuperarDatosDeInterfaz();

            // Verificar si el DNI ya existe
            if (verificarDniExistente(medico.getDni_doctor())) {
                JOptionPane.showMessageDialog(this, "El DNI ya está registrado.");
                return; // Salir del método sin realizar el registro
            }

            String strSentenciaInsert = "INSERT INTO doctor (dni_doctor, nombre_doc, apellido_doc, especialidad, comentario) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaInsert);

            // Rellenar el campo dni_doctor con ceros a la izquierda
            String dni = String.format("%09d", medico.getDni_doctor());
            pstmt.setString(1, dni);
            pstmt.setString(2, medico.getNombre_doc());
            pstmt.setString(3, medico.getApellido_doc());
            pstmt.setString(4, medico.getEspecialidad());
            pstmt.setString(5, medico.getComentario());

            pstmt.executeUpdate();

            mostrarDatosMedico(medico);

            ResultSet resultado = objConexion.consultar("SELECT * FROM doctor");

            while (resultado.next()) {
                System.out.println(resultado.getString("dni_doctor"));
                System.out.println(resultado.getString("nombre_doc"));
                System.out.println(resultado.getString("apellido_doc"));
                System.out.println(resultado.getString("especialidad"));
                System.out.println(resultado.getString("comentario"));
            }

            // Limpiar los campos después de registrar
            limpiarCampos();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblMedicos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Estás seguro de hacer estos cambios?", "Confirmar cambios", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                MedicoCTRL medico = recuperarDatosDeInterfaz();
                editarDatosMedico(filaSeleccionada, medico);
                limpiarCampos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tblMedicos.getSelectedRow();
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
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMedicoActionPerformed
        // TODO add your handling code here:
        // Obtener el texto ingresado en el campo de búsqueda
        String textoBusqueda = JOptionPane.showInputDialog(this, "Ingrese el DNI a buscar:");

        if (textoBusqueda != null && !textoBusqueda.isEmpty()) {
            buscarMedico(textoBusqueda);
        }
    }//GEN-LAST:event_btnBuscarMedicoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void editarDatosMedico(int fila, MedicoCTRL medico) {
        modelo.setValueAt(medico.getDni_doctor(), fila, 0);
        modelo.setValueAt(medico.getNombre_doc(), fila, 1);
        modelo.setValueAt(medico.getApellido_doc(), fila, 2);
        modelo.setValueAt(medico.getEspecialidad(), fila, 3);
        modelo.setValueAt(medico.getComentario(), fila, 4);

        Conexion objConexion = new Conexion();
        try {
            String strSentenciaUpdate = "UPDATE doctor SET nombre_doc = ?, apellido_doc = ?, especialidad = ?, comentario = ? WHERE dni_doctor = ?";
            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaUpdate);
            pstmt.setString(1, medico.getNombre_doc());
            pstmt.setString(2, medico.getApellido_doc());
            pstmt.setString(3, medico.getEspecialidad());
            pstmt.setString(4, medico.getComentario());
            pstmt.setInt(5, medico.getDni_doctor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL de actualización: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    private void eliminarFilaSeleccionada(int fila) {
        String dniString = (String) modelo.getValueAt(fila, 0); // Obtener el valor como String
        int dni = Integer.parseInt(dniString); // Convertir a int

        modelo.removeRow(fila);

        Conexion objConexion = new Conexion();

        limpiarCampos();

        try {
            String strSentenciaDelete = "DELETE FROM doctor WHERE dni_doctor = ?";
            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaDelete);
            pstmt.setInt(1, dni);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL de eliminación: " + e.getMessage());
        }
    }

    public MedicoCTRL recuperarDatosDeInterfaz() {
        MedicoCTRL medico = new MedicoCTRL();

        int dni = (txtDniMedico.getText().isEmpty()) ? 0 : Integer.parseInt(txtDniMedico.getText());

        medico.setDni_doctor(dni);
        medico.setNombre_doc(txtNombreMedico.getText());
        medico.setApellido_doc(txtApellidoMedico.getText());
        medico.setEspecialidad(cmbEspecialidadMedico.getSelectedItem().toString());
        medico.setComentario(txtComentarioMedico.getText());

        return medico;
    }

    public void mostrarDatosMedico(MedicoCTRL medico) {
        Object[] fila = {
            medico.getDni_doctor(),
            medico.getNombre_doc(),
            medico.getApellido_doc(),
            medico.getEspecialidad(),
            medico.getComentario()
        };
        modelo.addRow(fila);
    }

    public void mostrarDatosMedico(int fila) {
        String dni = tblMedicos.getValueAt(fila, 0).toString();
        String nombre = tblMedicos.getValueAt(fila, 1).toString();
        String apellido = tblMedicos.getValueAt(fila, 2).toString();
        String especialidad = tblMedicos.getValueAt(fila, 3).toString();
        String comentario = tblMedicos.getValueAt(fila, 4).toString();

        txtDniMedico.setText(dni);
        txtNombreMedico.setText(nombre);
        txtApellidoMedico.setText(apellido);
        cmbEspecialidadMedico.setSelectedItem(especialidad);
        txtComentarioMedico.setText(comentario);
    }

    public void cargarDatosMedicos() {
        Conexion objConexion = new Conexion();

        try {
            ResultSet resultado = objConexion.consultar("SELECT * FROM doctor");

            while (resultado.next()) {
                Object[] fila = {
                    resultado.getString("dni_doctor"),
                    resultado.getString("nombre_doc"),
                    resultado.getString("apellido_doc"),
                    resultado.getString("especialidad"),
                    resultado.getString("comentario")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los datos de los médicos: " + e.getMessage());
        }
    }

    private void buscarMedico(String dniBusqueda) {
        Conexion objConexion = new Conexion();

        try {
            String strSentenciaSelect = "SELECT * FROM doctor WHERE dni_doctor LIKE ?";
            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaSelect);
            pstmt.setString(1, "%" + dniBusqueda + "%");

            ResultSet resultado = pstmt.executeQuery();

            // Limpiar la tabla antes de mostrar los resultados
            limpiarTabla();

            while (resultado.next()) {
                Object[] fila = {
                    resultado.getString("dni_doctor"),
                    resultado.getString("nombre_doc"),
                    resultado.getString("apellido_doc"),
                    resultado.getString("especialidad"),
                    resultado.getString("comentario")
                };
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL de búsqueda: " + e.getMessage());
        }
    }

    private void limpiarTabla() {
        modelo.setRowCount(0);
    }

    private void limpiarCampos() {
        txtDniMedico.setText("");
        txtNombreMedico.setText("");
        txtApellidoMedico.setText("");
        cmbEspecialidadMedico.setSelectedIndex(0);
        txtComentarioMedico.setText("");
    }

    private boolean verificarDniExistente(int dni) {
        Conexion objConexion = new Conexion();
        try {
            String strSentenciaSelect = "SELECT COUNT(*) AS count FROM doctor WHERE dni_doctor = ?";
            PreparedStatement pstmt = objConexion.getConexion().prepareStatement(strSentenciaSelect);
            pstmt.setInt(1, dni);

            ResultSet resultado = pstmt.executeQuery();
            if (resultado.next()) {
                int count = resultado.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL de verificación: " + e.getMessage());
        }
        return false;
    }

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
            java.util.logging.Logger.getLogger(Medicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Medicos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMedico;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbEspecialidadMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMedicos;
    private javax.swing.JTextField txtApellidoMedico;
    private javax.swing.JTextArea txtComentarioMedico;
    private javax.swing.JTextField txtDniMedico;
    private javax.swing.JTextField txtNombreMedico;
    // End of variables declaration//GEN-END:variables
}
