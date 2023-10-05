
package ilfucileresto;

import ilfucileresto.AccesoADatos.EmpleadoData;
import ilfucileresto.AccesoADatos.MesaData;
import ilfucileresto.AccesoADatos.PedidoData;
import ilfucileresto.AccesoADatos.ProductoData;
import ilfucileresto.Entidades.Empleado;
import ilfucileresto.Entidades.Mesa;
import ilfucileresto.Entidades.Pedido;
import ilfucileresto.Entidades.Producto;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

public class Ilfucileresto {


    public static void main(String[] args) {
        //Mesa mesa = new Mesa(1,4);
        //MesaData mD = new MesaData();
        //mD.guardarMesa(mesa);
        
        //Producto producto = new Producto(1,"Ravioles",2800,10,true);
        //Producto producto = new Producto(2,"Ñoquis",2000,17,true);
        
        ProductoData pD = new ProductoData();
        //pD.guardarProducto(producto);
        //pD.modificarProducto(producto);
        //Producto prod = pD.buscarProducto(1);
        //List <Producto> productos = pD.listarProductos();
        //for (Producto prod : productos) {
            //System.out.println(prod);
        //}

        
        //Empleado emp = new Empleado(1,"Perez","Juan","40512658","MESERO",true);
        //EmpleadoData eD = new EmpleadoData();
        //eD.guardarEmpleado(emp);
        
        //Pedido pedido = new Pedido(mesa,emp,LocalDateTime.now(),2500,1,true);
        //PedidoData peData = new PedidoData();
        //peData.guardarPedido(pedido);
    }
    
}
