package Controlador;

public class MedicoCTRL {

    int dni_doctor;
    String nombre_doc;
    String apellido_doc;
    String especialidad;
    String comentario;

    public int getDni_doctor() {
        return dni_doctor;
    }

    public void setDni_doctor(int dni_doctor) {
        this.dni_doctor = dni_doctor;
    }

    public String getNombre_doc() {
        return nombre_doc;
    }

    public void setNombre_doc(String nombre_doc) {
        this.nombre_doc = nombre_doc;
    }

    public String getApellido_doc() {
        return apellido_doc;
    }

    public void setApellido_doc(String apellido_doc) {
        this.apellido_doc = apellido_doc;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
   
}
