package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 
public class Producto {

    private int idProducto;
    private String descripcion;
    private double precioUnitario;
    private boolean estado;

    public Producto(int idProducto, String descripcion, double precioUnitario) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.estado = true;
    }

    public Producto(String descripcion, double precioUnitario) {
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.estado = true;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String disponible;
        if(estado){
            disponible="Disponible";
        }else{
            disponible="No disponible";
        }
        return idProducto + ", " + descripcion + " $" + precioUnitario + "- " + disponible;
    }
    
    

   
    
}
