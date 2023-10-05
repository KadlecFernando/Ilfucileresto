package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

public class Empleado {

    private int idEmpleado;
    private String apellido, nombre, DNI, puesto, user, password;
    private boolean estado;

    public Empleado(int idEmpleado, String apellido, String nombre, String DNI, String puesto, String user, String password, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.puesto = puesto;
        this.user = user;
        this.password = password;
        this.estado = estado;
    }

    public Empleado(String apellido, String nombre, String DNI, String puesto, String user, String password, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.puesto = puesto;
        this.user = user;
        this.password = password;
        this.estado = estado;

    }

    public Empleado(int idEmpleado, String apellido, String nombre, String DNI, String puesto, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.puesto = puesto;
        this.estado = estado;
    }

    
    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    } 

    @Override
    public String toString() {
        return idEmpleado + " - " + apellido + " " + nombre + " - " + DNI;
    }
}
