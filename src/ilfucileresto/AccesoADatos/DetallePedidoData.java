package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Pedido;
import ilfucileresto.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DetallePedidoData {

    private Connection con = null;
    private PedidoData peD = new PedidoData();
    private ProductoData prD = new ProductoData();

    public DetallePedidoData() {
        con = Conexion.getConnection();
    }

    public void agregarDetallePedido(Pedido pedido, Producto producto, int cant) {
        String sql = "INSERT INTO detallePedido VALUES(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ps.setInt(2, producto.getIdProducto());
            ps.setInt(3, cant);
            int fila=ps.executeUpdate();
            if(fila>0){
                JOptionPane.showMessageDialog(null, "El detalle del pedido se agregó con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }

    public void eliminarDetallePedido(Pedido pedido, Producto producto) {
        String sql = "DELETE FROM detallePedido WHERE idPedido=? AND idProducto=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ps.setInt(2, producto.getIdProducto());
            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado del pedido.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }

    public void actualizarDetallePedido(Pedido pedido, Producto producto, int cantidad) {
        String sql = "UPDATE detallePedido SET cantidad=? WHERE idPedido=? AND idProducto=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, pedido.getIdPedido());
            ps.setInt(3, producto.getIdProducto());
            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Producto eliminado del pedido.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }
//    SELECT p.nombreProducto,d.cantidad,p.precioUnitario, p.precioUnitario*d.cantidad as subtotal 
//    FROM `producto` p join detallepedido d on p.idProducto=d.idProducto WHERE d.idProducto=2
//    and d.idPedido=2 

    public double calcularSubtotal(Producto producto, int cantidad) {
        double subtotal = 0;
        String sql = "SELECT precioUnitario FROM producto WHERE idProducto=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subtotal = rs.getDouble("precioUnitario");
                subtotal *= cantidad;
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
        return subtotal;
    }

    public double calcularTotal(Pedido pedido) {
        String sql = "SELECT SUM(p.precioUnitario*d.cantidad) AS total"
                   + "  FROM `producto` p "
                   + "      JOIN detallepedido d ON p.idProducto=d.idProducto"
                   + " WHERE d.idPedido=?";
        PreparedStatement ps = null;
        double total = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
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
