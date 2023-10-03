package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoData {

    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConnection();
    }

    public void guardarProducto(Producto producto) {
        try {
            String sql = "Insert into producto(descripcion,precioUnitario,estado) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getDescripcion());
            ps.setDouble(2, producto.getPrecioUnitario());
            ps.setBoolean(3, producto.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "producto añadido con exito ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto " + ex.getMessage());
        }

    }
    
     public Producto buscarProducto(int id) {

        Producto producto = null;
        String sql = "SELECT descripcion,precioUnitario FROM producto WHERE idProducto = ? AND estado=1";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id);
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto " + ex.getMessage());
        }
        return producto;
    }
    
     public void modificarProducto(Producto producto) {

        String sql = "UPDATE producto SET descripcion=?, precioUnitario=?, estado=? WHERE idProducto = ?";
        PreparedStatement ps = null;
        int exito = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setDouble(2, producto.getPrecioUnitario());
            ps.setBoolean(3, producto.isEstado());
            ps.setInt(4, producto.getIdProducto());

            exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }
        } catch (SQLException ex) {
            if (exito == 0) {
                JOptionPane.showMessageDialog(null, "El producto no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto " + ex.getMessage());
            }
        }
    }
    
     public List<Producto> listarProductos() {

        List<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM producto WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioUnitario(rs.getDouble("precioUnitario"));
                producto.setEstado(rs.getBoolean("estado"));
                
                productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto." + ex.getMessage());
        }
        return productos;
    }
}
