package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 
public class Mesa {

    private int idMesa;
    private int estadoMesa;
    private int capacidad;

    public Mesa(int idMesa, int estadoMesa, int capacidad) {
        this.idMesa = idMesa;
        this.estadoMesa = estadoMesa;
        this.capacidad = capacidad;
    }

    public Mesa(int estadoMesa, int capacidad) {
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

    public int getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(int estadoMesa) {
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
