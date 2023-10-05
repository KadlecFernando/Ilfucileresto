package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Empleado;
import ilfucileresto.Entidades.Mesa;
import ilfucileresto.Entidades.Pedido;
import ilfucileresto.Entidades.pedido;
import ilfucileresto.Entidades.pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoData {

    private Connection con = null;
    private MesaData mesaData = new MesaData();
    private EmpleadoData empleadoData = new EmpleadoData();
    
    public PedidoData() {
        con = Conexion.getConnection();
        
    }

    public void guardarPedido(Pedido pedido) {
        try {
            String sql = "INSERT INTO pedido(idMesa,idEmpleado,fechaHora,importe,estado,pago) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getEmpleado().getIdEmpleado());
            java.sql.Timestamp fecha = java.sql.Timestamp.valueOf(pedido.getFechaHora());
            ps.setTimestamp(3, fecha);
            ps.setDouble(4, pedido.getImporte());
            ps.setInt(5, pedido.getEstado());
            ps.setBoolean(6, pedido.isPago());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedido.setIdPedido(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pedido añadido con exito ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido " + ex.getMessage());
        }
    }

    public Pedido buscarPedido(int id) {

        Pedido pedido = null;
        String sql = "SELECT idMesa,idEmpleado,fechaHora,importe,estado,pago FROM pedido WHERE idPedido = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(id);
                Mesa mesa = mesaData.buscarMesa(rs.getInt("idMesa"));
                Empleado empleado = empleadoData.buscarEmpleado(rs.getInt("idEmpleado"));
                pedido.setMesa(mesa);
                pedido.setEmpleado(empleado);
                Timestamp fecha = rs.getTimestamp("fechaHora");
                pedido.setFechaHora(fecha.toLocalDateTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getInt("estado"));
                pedido.setPago(rs.getBoolean("pago"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el pedido.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido " + ex.getMessage());
        }
        
        return pedido;
    }
    
    public void modificarPedido(Pedido pedido) {
        
        String sql = "UPDATE pedido SET idMesa=?, idEmpleado=?, fechaHora=?, importe=?, estado=?, pago=? WHERE idPedido = ?";
        PreparedStatement ps = null;
        int exito = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getEmpleado().getIdEmpleado());
            java.sql.Timestamp fecha = java.sql.Timestamp.valueOf(pedido.getFechaHora());
            ps.setTimestamp(3, fecha);
            ps.setDouble(4, pedido.getImporte());
            ps.setInt(5, pedido.getEstado());
            ps.setBoolean(6,pedido.isPago());
            ps.setInt(7,pedido.getIdPedido());

            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }
        } catch (SQLException ex) {
            if (exito == 0) {
                JOptionPane.showMessageDialog(null, "El pedido no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido " + ex.getMessage());
            }
        }
    }
    
    public List<Pedido> listarPedidosPorFecha(Date fecha) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT idPedido,importe FROM pedido WHERE DATE(fechaHora) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, (java.sql.Date) fecha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setImporte(rs.getDouble("importe"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return pedidos;
    }
    
    public List<Pedido> listarPedidosPorMesero(int idMesero) {
        //Ver parametro opcional para fecha...
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT idPedido,idMesa,fechaHora,importe,estado,pago FROM pedido WHERE idEmpleado = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.getMesa().setIdMesa(rs.getInt("idMesa"));
                Timestamp fecha = rs.getTimestamp("fechaHora");
                pedido.setFechaHora(fecha.toLocalDateTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getInt("estado"));
                pedido.setPago(rs.getBoolean("pago"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return pedidos;
    }
    
    
    
    


}
