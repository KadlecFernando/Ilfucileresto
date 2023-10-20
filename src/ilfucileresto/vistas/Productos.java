/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilfucileresto.vistas;

import ilfucileresto.AccesoADatos.ProductoData;
import ilfucileresto.Entidades.Producto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mrubio
 */
public class Productos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private ProductoData pD = new ProductoData();

    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        cargarColumna();
        mostrarDatosTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCargaDatos = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioUnitario = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        rbEstado = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1145, 690));

        pnCargaDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ilfucileresto/Imagenes/agregar-producto.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ilfucileresto/Imagenes/editar-codigo.png"))); // NOI18N
        btnModificarProducto.setText("Modificar");
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ilfucileresto/Imagenes/eliminar-producto.png"))); // NOI18N
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        rbEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstadoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descripción:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Precio Unit.:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Estado:");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCargaDatosLayout = new javax.swing.GroupLayout(pnCargaDatos);
        pnCargaDatos.setLayout(pnCargaDatosLayout);
        pnCargaDatosLayout.setHorizontalGroup(
            pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCargaDatosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCargaDatosLayout.createSequentialGroup()
                        .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnCargaDatosLayout.createSequentialGroup()
                        .addComponent(btnAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarProducto)))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCargaDatosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(62, 62, 62))
            .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnCargaDatosLayout.createSequentialGroup()
                    .addContainerGap(155, Short.MAX_VALUE)
                    .addComponent(rbEstado)
                    .addGap(289, 289, 289)))
        );
        pnCargaDatosLayout.setVerticalGroup(
            pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCargaDatosLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnModificarProducto)
                    .addComponent(btnEliminarProducto))
                .addGap(41, 41, 41)
                .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(31, 31, 31))
            .addGroup(pnCargaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnCargaDatosLayout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(rbEstado)
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        jPanel1.setBackground(new java.awt.Color(102, 32, 6));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Menú");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(490, 490, 490))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));

        tbMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbMenu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pnCargaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(pnCargaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 121, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEstadoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        btnModificarProducto.setEnabled(false);
        btnEliminarProducto.setEnabled(false);


    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (btnAgregarProducto.isEnabled() && !btnEliminarProducto.isEnabled()) {
            Producto producto = new Producto();
            producto.setNombreProducto(txtNombreProducto.getText());
            producto.setPrecioUnitario(Double.valueOf(txtPrecioUnitario.getText()));
            producto.setStock(Integer.valueOf(txtStock.getText()));
            producto.setEstado(rbEstado.isSelected());
            pD.guardarProducto(producto);
            btnModificarProducto.setEnabled(true);
            btnEliminarProducto.setEnabled(true);
            txtNombreProducto.setText("");
            txtPrecioUnitario.setText("");
            txtStock.setText("");
            rbEstado.setSelected(false);
            mostrarDatosTabla();
        } else if (btnModificarProducto.isEnabled() && !btnEliminarProducto.isEnabled()) {
            Producto producto = new Producto();
            producto.setIdProducto((Integer) modelo.getValueAt(tbMenu.getSelectedRow(), 0));
            producto.setNombreProducto(txtNombreProducto.getText());
            producto.setPrecioUnitario(Double.valueOf(txtPrecioUnitario.getText()));
            producto.setStock(Integer.valueOf(txtStock.getText()));
            producto.setEstado(rbEstado.isSelected());
            pD.modificarProducto(producto);
            btnAgregarProducto.setEnabled(true);
            btnEliminarProducto.setEnabled(true);
            txtNombreProducto.setText("");
            txtPrecioUnitario.setText("");
            txtStock.setText("");
            rbEstado.setSelected(false);
            mostrarDatosTabla();

        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        if (tbMenu.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
            return;
        }
        btnAgregarProducto.setEnabled(false);
        btnEliminarProducto.setEnabled(false);
        Integer id = (Integer) modelo.getValueAt(tbMenu.getSelectedRow(), 0);
        Producto producto = pD.buscarProducto(id);
        txtNombreProducto.setText(producto.getNombreProducto());
        txtPrecioUnitario.setText(producto.getPrecioUnitario() + "");
        txtStock.setText(producto.getStock() + "");
        rbEstado.setSelected(producto.isEstado());
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnModificarProducto.setEnabled(true);
        btnEliminarProducto.setEnabled(true);
        btnAgregarProducto.setEnabled(true);
        txtNombreProducto.setText("");
        txtPrecioUnitario.setText("");
        txtStock.setText("");
        rbEstado.setSelected(false);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if (tbMenu.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
            return;
        }
        btnAgregarProducto.setEnabled(false);
        btnModificarProducto.setEnabled(false);
        Integer id = (Integer) modelo.getValueAt(tbMenu.getSelectedRow(), 0);
        Producto producto = pD.buscarProducto(id);
        txtNombreProducto.setText(producto.getNombreProducto());
        txtPrecioUnitario.setText(producto.getPrecioUnitario() + "");
        txtStock.setText(producto.getStock() + "");
        rbEstado.setSelected(producto.isEstado());
        
        
    }//GEN-LAST:event_btnEliminarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnCargaDatos;
    private javax.swing.JRadioButton rbEstado;
    private javax.swing.JTable tbMenu;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    public void cargarColumna() {

        modelo.addColumn("Codigo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("PrecioUnitario");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");

        tbMenu.setModel(modelo);

    }

    private void mostrarDatosTabla() {
        String estado;
        List<Producto> productos = pD.listarProductos();
        modelo.setRowCount(0);
        for (Producto producto : productos) {
            if (producto.isEstado()) {
                estado = "Disponible";
            } else {
                estado = "No Disponible";
            }

            modelo.addRow(new Object[]{producto.getIdProducto(), producto.getNombreProducto(), producto.getPrecioUnitario(), producto.getStock(), estado});

        }

    }

}
