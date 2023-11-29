
package VISTA;


public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new javax.swing.JPanel();
        IMAGEN_FONO = new javax.swing.JLabel();
        myPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuCatalogo = new javax.swing.JMenu();
        itemMostrarTodos = new javax.swing.JMenuItem();
        itemAgregar = new javax.swing.JMenuItem();
        itemActualizar = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        jmenuSalir = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setResizable(false);

        IMAGEN_FONO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IMAGEN_FONO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Fondo_hoyts.jpeg"))); // NOI18N
        IMAGEN_FONO.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IMAGEN_FONO, javax.swing.GroupLayout.PREFERRED_SIZE, 777, Short.MAX_VALUE)
            .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IMAGEN_FONO, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jmenuCatalogo.setText("Catalogo");

        itemMostrarTodos.setText("Ver Catologo Peliculas");
        itemMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMostrarTodosActionPerformed(evt);
            }
        });
        jmenuCatalogo.add(itemMostrarTodos);

        itemAgregar.setText("Agregar Pelicula");
        itemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarActionPerformed(evt);
            }
        });
        jmenuCatalogo.add(itemAgregar);

        itemActualizar.setText("Modificar Pelicula");
        itemActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActualizarActionPerformed(evt);
            }
        });
        jmenuCatalogo.add(itemActualizar);

        itemEliminar.setText("Eliminar Peliculas");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        jmenuCatalogo.add(itemEliminar);

        jMenuBar1.add(jmenuCatalogo);

        jmenuSalir.setText("Salir");

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        jmenuSalir.add(itemSalir);

        jMenuBar1.add(jmenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarActionPerformed
        if (ip == null || ip.isClosed()) 
        {
          ip = new IngresarPelicula();
          myPanel2.add(ip);
          ip.show();
        }else
        {
            ip.show();
        }
        
        
    }//GEN-LAST:event_itemAgregarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        this.dispose();
       
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMostrarTodosActionPerformed
        if (mt == null || mt.isClosed()) 
        {
            mt = new MostrarTodos();
            myPanel2.add(mt);
            mt.show();
        }else
        {
            mt.show();
        }
    }//GEN-LAST:event_itemMostrarTodosActionPerformed

    private void itemActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActualizarActionPerformed
        if (mp == null || mp.isClosed()) 
        {
            mp = new ModificarPelicula();
            myPanel2.add(mp);
            mp.show();
        }else
        {
            mp.show();
        }
    }//GEN-LAST:event_itemActualizarActionPerformed

    private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
        if (ep == null || ep.isClosed()) 
        {
            ep = new EliminarPelicula();
            myPanel2.add(ep);
            ep.show();
        }else
        {
           ep.show();
        }
    }//GEN-LAST:event_itemEliminarActionPerformed

  
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // agregar variables
    EliminarPelicula ep;
    ModificarPelicula mp;
    IngresarPelicula ip;
    MostrarTodos mt;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMAGEN_FONO;
    private javax.swing.JMenuItem itemActualizar;
    private javax.swing.JMenuItem itemAgregar;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemMostrarTodos;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmenuCatalogo;
    private javax.swing.JMenu jmenuSalir;
    private javax.swing.JPanel myPanel1;
    private javax.swing.JPanel myPanel2;
    // End of variables declaration//GEN-END:variables
}
