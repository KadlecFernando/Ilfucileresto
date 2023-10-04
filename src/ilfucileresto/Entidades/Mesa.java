package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 
public class Mesa {

    private int idMesa;
    private boolean estadoMesa;
    private int capacidad;

    public Mesa(int idMesa, boolean estadoMesa, int capacidad) {
        this.idMesa = idMesa;
        this.estadoMesa = estadoMesa;
        this.capacidad = capacidad;
    }

    public Mesa(boolean estadoMesa, int capacidad) {
        this.estadoMesa = estadoMesa;
        this.capacidad = capacidad;
    }

    public Mesa() {
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return  idMesa + ", " + estadoMesa + ", " + capacidad;
    }
    
    

}
