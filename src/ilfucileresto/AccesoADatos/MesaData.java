package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MesaData {

    private Connection con = null;

    public MesaData() {
        con = Conexion.getConnection();
    }

    public void guardarMesa(Mesa mesa) {
        try {
            String sql = "Insert into mesa(estadoMesa,capacidad) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, mesa.isEstadoMesa());
            ps.setInt(2, mesa.getCapacidad());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mesa.setIdMesa(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mesa añadida con exito ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa " + ex.getMessage());
        }
    }
    
    public Mesa buscarMesa(int id) {

        Mesa mesa = null;
        String sql = "SELECT idMesa,estadoMesa,capacidad FROM mesa WHERE idMesa = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mesa = new Mesa();
                mesa.setIdMesa(id);
                mesa.setEstadoMesa(rs.getBoolean("estadoMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la mesa.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa " + ex.getMessage());
        }
        return mesa;
    }
    
    public void modificarMesa(Mesa mesa) {
        String sql = "UPDATE mesa SET estadoMesa=?, capacidad=? WHERE idMesa = ?";
        PreparedStatement ps = null;
        int exito = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, mesa.isEstadoMesa());
            ps.setInt(2, mesa.getCapacidad());
            ps.setInt(3, mesa.getIdMesa());
            exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }
        } catch (SQLException ex) {
            if (exito == 0) {
                JOptionPane.showMessageDialog(null, "La mesa no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa " + ex.getMessage());
            }
        }
    }
    
     public List<Mesa> listarMesas() {
        List<Mesa> mesas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mesa";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setEstadoMesa(rs.getBoolean("estadoMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesas.add(mesa);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa." + ex.getMessage());
        }
        return mesas;
    }
}
