package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Pedido;
import ilfucileresto.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DetallePedidoData {

    private Connection con = null;
    private PedidoData peD = new PedidoData();
    private ProductoData prD = new ProductoData();

    public DetallePedidoData() {
        con = Conexion.getConnection();
    }

    public void agregarDetallePedido(Pedido pedido, Producto producto, int cant) {
        String sql = "Insert into detallePedido values(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ps.setInt(2, producto.getIdProducto());
            ps.setInt(3, cant);
            int fila=ps.executeUpdate();
            if(fila>0){
                JOptionPane.showMessageDialog(null, "El detallePedido se agrego con exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }

    public void eliminarDetallePedido(int idProducto, int idPedido) {
        String sql = "Delete from detallePedido where idProducto=? AND idPedido=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idPedido);
            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado del pedido");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }

    public void actualizarDetallePedido(int idProducto, int idPedido, int cantidad) {
        String sql = "Update detallePedido set cantidad=? where idProducto=? AND idPedido=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, idProducto);
            ps.setInt(3, idPedido);
            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado del pedido");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }
//    SELECT p.nombreProducto,d.cantidad,p.precioUnitario, p.precioUnitario*d.cantidad as subtotal 
//    FROM `producto` p join detallepedido d on p.idProducto=d.idProducto WHERE d.idProducto=2
//    and d.idPedido=2 

    public double calcularSubtotal(int idProducto, int cantidad) {
        double subtotal = 0;
        String sql = "Select precioUnitario from producto where idProducto=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subtotal = rs.getDouble("precioUnitario");
                subtotal *= cantidad;
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
        return subtotal;
    }

    public double calcularTotal(int idPedido) {
        String sql = "SELECT sum(p.precioUnitario*d.cantidad) as total FROM `producto` p "
                + " join detallepedido d on p.idProducto=d.idProducto WHERE d.idPedido=?";
        PreparedStatement ps = null;
        double total = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
        return total;
    }
}
