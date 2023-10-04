package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

public class PedidoData {

     private Connection con = null;

    public PedidoData() {
        con = Conexion.getConnection();
    }

     public void guardarPedido(Pedido pedido) {
        try {
            String sql = "Insert into pedido(idMesa,idEmpleado,fechaHora,importe,estado,pago) values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getEmpleado().getIdEmpleado());
//            ps.setDate(3, Date.);
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
}
