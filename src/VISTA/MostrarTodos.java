
package VISTA;

import CONTROLAR.Metodos;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MostrarTodos extends javax.swing.JInternalFrame {

  
    public MostrarTodos() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablePelicula = new javax.swing.JTable();
        boxGenero = new javax.swing.JComboBox<>();
        btnFiltrarGenero = new javax.swing.JButton();
        txtAnio1 = new javax.swing.JTextField();
        txtAnio2 = new javax.swing.JTextField();
        btnFiltrarFecha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLimpiarFiltro = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CATALOGO DE PELICULAS");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jtablePelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtablePelicula);

        boxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GENERO", "ACCION", "ADULTO", "ANIMACION", "AVENTURA", "COMEDIA", "DOCUMENTAL", "DRAMA", "FAMILIAR", "HENTAI ", "INFANTIL", "PARANORMAL", "ROMANCE", "TERROR", " ", " " }));

        btnFiltrarGenero.setText("FILTRAR");
        btnFiltrarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarGeneroActionPerformed(evt);
            }
        });

        txtAnio1.setText("DESDE");
        txtAnio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAnio1MouseClicked(evt);
            }
        });

        txtAnio2.setText("HASTA");
        txtAnio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAnio2MouseClicked(evt);
            }
        });

        btnFiltrarFecha.setText("POR FECHA");
        btnFiltrarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarFechaActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese rango de años");

        btnLimpiarFiltro.setText("LIMPIAR FILTRO");
        btnLimpiarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                                .addComponent(txtAnio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAnio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addComponent(jLabel1)))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnFiltrarGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnFiltrarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                            .addGroup(myPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiarFiltro)
                                    .addComponent(boxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15))))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnLimpiarFiltro)
                .addGap(18, 18, 18)
                .addComponent(boxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrarGenero)
                .addGap(27, 27, 27)
                .addComponent(btnFiltrarFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltroActionPerformed
        m = new Metodos();
        DefaultTableModel modelo = m.MostrarTodos();
        boxGenero.setSelectedIndex(0);
        jtablePelicula.setModel(modelo);
        txtAnio1.setText("DESDE");
        txtAnio2.setText("HASTA");
    }//GEN-LAST:event_btnLimpiarFiltroActionPerformed

    private void btnFiltrarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarGeneroActionPerformed
        String g = boxGenero.getSelectedItem().toString();
        m = new Metodos();
        if (g.trim().equals("GENERO")) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una opccion en Genero antes de presionar el boton");
        }else
        {
            DefaultTableModel modelo = m.filtrarGenero(g);
            jtablePelicula.setModel(modelo);
        }
    }//GEN-LAST:event_btnFiltrarGeneroActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        m = new Metodos();
        DefaultTableModel modelo = m.MostrarTodos();
        //modelo.fireTableDataChanged();//este metodo funciona solo para actualizar la tabla en tiempo real, o eso se supone
        jtablePelicula.setModel(modelo);
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnFiltrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarFechaActionPerformed
        String anio1 = txtAnio1.getText();
        String anio2 = txtAnio2.getText();
        m = new Metodos();
        int validar = m.validarCamposFiltrar(anio1, anio2);
        if (validar==1) 
        {
            int aa1 = Integer.parseInt(anio1);
            int aa2 = Integer.parseInt(anio2);
            DefaultTableModel modelo = m.filtrarPorFecha(aa1, aa2);
            jtablePelicula.setModel(modelo);
        }
    }//GEN-LAST:event_btnFiltrarFechaActionPerformed

    private void txtAnio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnio1MouseClicked
        txtAnio1.setText("");
    }//GEN-LAST:event_txtAnio1MouseClicked

    private void txtAnio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnio2MouseClicked
       txtAnio2.setText("");
    }//GEN-LAST:event_txtAnio2MouseClicked


    //Variables
    Metodos m;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxGenero;
    private javax.swing.JButton btnFiltrarFecha;
    private javax.swing.JButton btnFiltrarGenero;
    private javax.swing.JButton btnLimpiarFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtablePelicula;
    private javax.swing.JPanel myPanel1;
    private javax.swing.JTextField txtAnio1;
    private javax.swing.JTextField txtAnio2;
    // End of variables declaration//GEN-END:variables
}
