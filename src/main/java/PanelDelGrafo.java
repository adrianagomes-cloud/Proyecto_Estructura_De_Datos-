/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author adria
 */
import javax.swing.JOptionPane;
public class PanelDelGrafo extends javax.swing.JPanel {
    private GrafoNeuronal grafoNeuronal;

    public PanelDelGrafo(GrafoNeuronal grafo) {
        this.grafoNeuronal = grafo;
        initComponents();
        cargarNeuronas();
    }

    private void cargarNeuronas() {
        if (grafoNeuronal == null) return;
        
        NeuronaOrigen.removeAllItems();
        NeuronaDestino.removeAllItems();
        
        Lista<Neurona> lista = grafoNeuronal.getNeuronas();
        for (int i = 0; i < lista.getTamano(); i++) {
            String id = lista.obtener(i).getId();
            NeuronaOrigen.addItem(id);
            NeuronaDestino.addItem(id);
        }
        NeuronaOrigen.setSelectedIndex(-1);
        NeuronaDestino.setSelectedIndex(-1);
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        NeuronaOrigen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        NeuronaDestino = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jButton6.setText("jButton6");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 0, 102));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 90, 30));

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Buscar");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 100, 70));

        NeuronaOrigen.addActionListener(this::NeuronaOrigenActionPerformed);
        jPanel1.add(NeuronaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 360, 40));

        jLabel2.setBackground(new java.awt.Color(204, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Neurona De Destino");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        NeuronaDestino.addActionListener(this::NeuronaDestinoActionPerformed);
        jPanel1.add(NeuronaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 360, 40));

        jButton4.setBackground(new java.awt.Color(153, 0, 153));
        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("limpiar ");
        jButton4.addActionListener(this::jButton4ActionPerformed);
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 70));

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText(" Agregar y Eliminar ");
        jButton7.addActionListener(this::jButton7ActionPerformed);
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 230, 40));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Neurona De origen");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 350));
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

        if (origen == null || destino == null) {
            JOptionPane.showMessageDialog(this, "Seleccione origen y destino.");
            return;
        }

        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(this, "Seleccione neuronas distintas.");
            return;
        }

        if (grafoNeuronal.resaltarRuta(origen, destino)) {
            JOptionPane.showMessageDialog(this, "Ruta resaltada.");
        } else {
            JOptionPane.showMessageDialog(this, "No existe camino.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    
    
    private void NeuronaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeuronaOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NeuronaOrigenActionPerformed

    private void NeuronaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeuronaDestinoActionPerformed
   
    }//GEN-LAST:event_NeuronaDestinoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if (grafoNeuronal != null) {
        grafoNeuronal.limpiarEstilosVisuales();
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> NeuronaDestino;
    private javax.swing.JComboBox<String> NeuronaOrigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
