/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author adria
 */
import javax.swing.JOptionPane;
public class PanelDeBusqueda extends javax.swing.JPanel {
private GrafoNeuronal grafoNeuronal;

    public PanelDeBusqueda(GrafoNeuronal grafo) {
        this.grafoNeuronal = grafo; // Asignamos el grafo recibido
        initComponents();           // Inicializamos los componentes de la interfaz
        cargarNeuronas();           // Llenamos los ComboBox
    }

    private void cargarNeuronas() {
        if (grafoNeuronal == null) return; // Protección por si acaso
        
        NeuronaOrigen.removeAllItems();
        NeuronaDestino.removeAllItems();
        
        Lista<Neurona> lista = grafoNeuronal.getNeuronas();
        for (int i = 0; i < lista.getTamano(); i++) {
            String id = lista.obtener(i).getId();
            NeuronaOrigen.addItem(id);
            NeuronaDestino.addItem(id);
        }
    }

   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        NeuronaOrigen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NeuronaDestino = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 0, 102));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        NeuronaOrigen.addActionListener(this::NeuronaOrigenActionPerformed);
        jPanel1.add(NeuronaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 340, 40));

        jLabel2.setBackground(new java.awt.Color(204, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Neurona De Destino");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Neurona De origen");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        NeuronaDestino.addActionListener(this::NeuronaDestinoActionPerformed);
        jPanel1.add(NeuronaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 340, 40));

        jButton3.setBackground(new java.awt.Color(153, 0, 153));
        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton3.setText("limpiar ");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 300));
    }// </editor-fold>//GEN-END:initComponents
// cerrar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        // Obtenemos la ventana contenedora (la ventana principal o JDialog)
        java.awt.Window win = javax.swing.SwingUtilities.getWindowAncestor(this);
        
        if (win != null) {
            win.dispose(); // Cierra la ventana
        } else {
            // Si por alguna razón no encuentra el ancestro, forzamos la salida
            System.out.println("No se encontró ventana padre, cerrando proceso...");
            System.exit(0);
        }
    } catch (Exception e) {
        e.printStackTrace(); // Esto te dirá en la consola si hay un error oculto
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     String origen = (String) NeuronaOrigen.getSelectedItem();
    String destino = (String) NeuronaDestino.getSelectedItem();

    if (origen == null || destino == null) return;

    if (origen.equals(destino)) {
        JOptionPane.showMessageDialog(this, "Seleccione neuronas distintas.");
        return;
    }

    // Llamada a la lógica en GrafoNeuronal
    boolean exito = grafoNeuronal.resaltarRuta(origen, destino);
    
    if (exito) {
        JOptionPane.showMessageDialog(this, "Ruta calculada y resaltada en el grafo.");
    } else {
        JOptionPane.showMessageDialog(this, "No existe un camino entre estas neuronas.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    
    
    private void NeuronaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeuronaOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NeuronaOrigenActionPerformed

    private void NeuronaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeuronaDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NeuronaDestinoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      if (grafoNeuronal != null) {
        grafoNeuronal.limpiarEstilosVisuales();
    }
    
    // 2. Opcional: resetear los ComboBox a su estado inicial
    if (NeuronaOrigen.getItemCount() > 0) NeuronaOrigen.setSelectedIndex(0);
    if (NeuronaDestino.getItemCount() > 0) NeuronaDestino.setSelectedIndex(0);
   
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> NeuronaDestino;
    private javax.swing.JComboBox<String> NeuronaOrigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
