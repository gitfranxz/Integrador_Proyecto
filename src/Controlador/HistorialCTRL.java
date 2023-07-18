package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistorialCTRL {

    private int id_historial;
    private int id_paciente;
    private String numero_historial;
    private String antecedentes_medicos;
    private String historial_enfermedades;
    private String notas_visitas;
    private String plan_tratamiento_actual;

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNumero_historial() {
        return numero_historial;
    }

    public void setNumero_historial(String numero_historial) {
        this.numero_historial = numero_historial;
    }

    public String getAntecedentes_medicos() {
        return antecedentes_medicos;
    }

    public void setAntecedentes_medicos(String antecedentes_medicos) {
        this.antecedentes_medicos = antecedentes_medicos;
    }

    public String getHistorial_enfermedades() {
        return historial_enfermedades;
    }

    public void setHistorial_enfermedades(String historial_enfermedades) {
        this.historial_enfermedades = historial_enfermedades;
    }

    public String getNotas_visitas() {
        return notas_visitas;
    }

    public void setNotas_visitas(String notas_visitas) {
        this.notas_visitas = notas_visitas;
    }

    public String getPlan_tratamiento_actual() {
        return plan_tratamiento_actual;
    }

    public void setPlan_tratamiento_actual(String plan_tratamiento_actual) {
        this.plan_tratamiento_actual = plan_tratamiento_actual;
    }

    public HistorialCTRL obtenerHistorialPaciente(int idPaciente) {
        HistorialCTRL historialPaciente = null;

        // Realizar la búsqueda del historial del paciente en la base de datos
        String query = "SELECT * FROM historial WHERE id_paciente = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinico", "root", "");
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPaciente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Si se encuentra el historial, cargar los datos en un objeto HistorialCTRL
                    historialPaciente = new HistorialCTRL();
                    historialPaciente.setId_historial(rs.getInt("id_historial"));
                    historialPaciente.setId_paciente(rs.getInt("id_paciente"));
                    historialPaciente.setNumero_historial(rs.getString("numero_historial"));
                    historialPaciente.setAntecedentes_medicos(rs.getString("antecedentes_medicos"));
                    historialPaciente.setHistorial_enfermedades(rs.getString("historial_enfermedades"));
                    historialPaciente.setNotas_visitas(rs.getString("notas_visitas"));
                    historialPaciente.setPlan_tratamiento_actual(rs.getString("plan_tratamiento_actual"));
                }
            }
        } catch (SQLException ex) {
            // Manejo de excepciones y mensajes de error
        }

        return historialPaciente;
    }

    public boolean registrarHistorial(HistorialCTRL historial) {
        // Conexión a la base de datos y operación de inserción
        String query = "INSERT INTO historial (id_paciente, numero_historial, antecedentes_medicos, historial_enfermedades, notas_visitas, plan_tratamiento_actual) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinico", "root", "");
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, historial.getId_paciente());
            stmt.setString(2, historial.getNumero_historial());
            stmt.setString(3, historial.getAntecedentes_medicos());
            stmt.setString(4, historial.getHistorial_enfermedades());
            stmt.setString(5, historial.getNotas_visitas());
            stmt.setString(6, historial.getPlan_tratamiento_actual());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true si se registró correctamente
        } catch (SQLException ex) {
            // Manejo de excepciones y mensajes de error

        }

        return false; // Retorna false si ocurrió un error
    }
    
     public boolean actualizarHistorial(HistorialCTRL historial) {
        // Conexión a la base de datos y operación de actualización
        String query = "UPDATE historial SET numero_historial = ?, antecedentes_medicos = ?, historial_enfermedades = ?, notas_visitas = ?, plan_tratamiento_actual = ? WHERE id_paciente = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/policlinico", "root", "");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, historial.getNumero_historial());
            stmt.setString(2, historial.getAntecedentes_medicos());
            stmt.setString(3, historial.getHistorial_enfermedades());
            stmt.setString(4, historial.getNotas_visitas());
            stmt.setString(5, historial.getPlan_tratamiento_actual());
            stmt.setInt(6, historial.getId_paciente());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Retorna true si se actualizó correctamente
        } catch (SQLException ex) {
            // Manejo de excepciones y mensajes de error

        }

        return false; // Retorna false si ocurrió un error
    }
}
