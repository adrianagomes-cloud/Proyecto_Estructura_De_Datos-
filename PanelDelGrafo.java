/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author adria
 */
import java.awt.Frame;
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
        BuscarRutaMasOptima = new javax.swing.JButton();
        NeuronaOrigen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        NeuronaDestino = new javax.swing.JComboBox<>();
        LimpiarNeurona = new javax.swing.JButton();
        AgregarOeliminar = new javax.swing.JButton();
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

        BuscarRutaMasOptima.setBackground(new java.awt.Color(0, 153, 0));
        BuscarRutaMasOptima.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        BuscarRutaMasOptima.setForeground(new java.awt.Color(255, 255, 255));
        BuscarRutaMasOptima.setText("Buscar");
        BuscarRutaMasOptima.addActionListener(this::BuscarRutaMasOptimaActionPerformed);
        jPanel1.add(BuscarRutaMasOptima, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 100, 70));

        NeuronaOrigen.addActionListener(this::NeuronaOrigenActionPerformed);
        jPanel1.add(NeuronaOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 360, 40));

        jLabel2.setBackground(new java.awt.Color(204, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Neurona De Destino");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        NeuronaDestino.addActionListener(this::NeuronaDestinoActionPerformed);
        jPanel1.add(NeuronaDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 360, 40));

        LimpiarNeurona.setBackground(new java.awt.Color(153, 0, 153));
        LimpiarNeurona.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        LimpiarNeurona.setForeground(new java.awt.Color(255, 255, 255));
        LimpiarNeurona.setText("limpiar ");
        LimpiarNeurona.addActionListener(this::LimpiarNeuronaActionPerformed);
        jPanel1.add(LimpiarNeurona, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 70));

        AgregarOeliminar.setBackground(new java.awt.Color(0, 153, 153));
        AgregarOeliminar.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        AgregarOeliminar.setForeground(new java.awt.Color(255, 255, 255));
        AgregarOeliminar.setText(" Agregar y Eliminar ");
        AgregarOeliminar.addActionListener(this::AgregarOeliminarActionPerformed);
        jPanel1.add(AgregarOeliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 230, 40));

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

    
    
    
    
    
    private void BuscarRutaMasOptimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarRutaMasOptimaActionPerformed
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
    }//GEN-LAST:event_BuscarRutaMasOptimaActionPerformed

    
    
    
    
    
    private void NeuronaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeuronaOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NeuronaOrigenActionPerformed

    private void NeuronaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeuronaDestinoActionPerformed
   
    }//GEN-LAST:event_NeuronaDestinoActionPerformed

    
    
    private void LimpiarNeuronaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarNeuronaActionPerformed
    if (grafoNeuronal != null) {
        grafoNeuronal.limpiarEstilosVisuales();
    }
    }//GEN-LAST:event_LimpiarNeuronaActionPerformed

    
    
    
    private void AgregarOeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarOeliminarActionPerformed
   if (this.grafoNeuronal == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error: El grafo no está inicializado.");
        return;
    }

    java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
    java.awt.Frame padre = (window instanceof java.awt.Frame) ? (java.awt.Frame) window : null;

    AgregaryEliminar ventanaGestion = new AgregaryEliminar(padre, true, this.grafoNeuronal);

    int y = (java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - ventanaGestion.getHeight()) / 2;
    ventanaGestion.setLocation(0, y);

    ventanaGestion.setVisible(true);
    
    // --- ESTA ES LA PARTE QUE ASEGURA EL REFRESCO ---
    this.cargarNeuronas(); // Actualiza los JComboBox
    
    // Si tienes acceso al objeto grafo dentro de GrafoNeuronal, 
    // fuerza un refresco visual si el componente existe
    // grafoNeuronal.visualizarGrafo(); // Descomenta solo si esto no abre una ventana nueva cada vez
    this.repaint(); 
    this.revalidate();
    }//GEN-LAST:event_AgregarOeliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarOeliminar;
    private javax.swing.JButton BuscarRutaMasOptima;
    private javax.swing.JButton LimpiarNeurona;
    private javax.swing.JComboBox<String> NeuronaDestino;
    private javax.swing.JComboBox<String> NeuronaOrigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
