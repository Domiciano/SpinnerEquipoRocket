package co.edu.icesi.spinnerequiporocket;

public class Doctor {

    private String cedula;
    private String contrasena;
    private String correo;
    private String firma;
    private String foto;
    private String id;
    private String idV;
    private String nombre;

    public Doctor(String cedula, String contrasena, String correo, String firma, String foto, String id, String idV, String nombre) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.correo = correo;
        this.firma = firma;
        this.foto = foto;
        this.id = id;
        this.idV = idV;
        this.nombre = nombre;
    }

    public Doctor() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdV() {
        return idV;
    }

    public void setIdV(String idV) {
        this.idV = idV;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
