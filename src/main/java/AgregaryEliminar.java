
import java.awt.Frame;
import javax.swing.JOptionPane;
//agregar y eliminar 
public class AgregaryEliminar extends javax.swing.JDialog {
    private GrafoNeuronal grafo;
   
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AgregaryEliminar.class.getName());

    /**
     * panel para agregar y eliminar Neuronas 
     */
    public AgregaryEliminar(java.awt.Frame parent, boolean modal, GrafoNeuronal grafo) {
        super(parent, modal);
        this.grafo = grafo;
        initComponents();
        
        this.setTitle("Agregar y Eliminar Neuronas");
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        
        // Cargar las neuronas existentes al iniciar la ventanas
        cargarCombos();
    }

    // Método para actualizar el JComboBox con las neuronas actuales del grafo
    private void cargarCombos() {
        jComboBoxDestino.removeAllItems();
        Lista<Neurona> lista = grafo.getNeuronas();
        for (int i = 0; i < lista.getTamano(); i++) {
            jComboBoxDestino.addItem(lista.obtener(i).getId());
        }
        
        // actualizamos el combo de eliminación 
        jComboBox3.removeAllItems();
        for (int i = 0; i < lista.getTamano(); i++) {
            jComboBox3.addItem(lista.obtener(i).getId());
        }
    }
    
     
     
     
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EliminarNeurona = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        AgregarNeurona = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxDestino = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver.setBackground(new java.awt.Color(204, 0, 102));
        Volver.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eliminar Neurona ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Se conectan con:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        EliminarNeurona.setBackground(new java.awt.Color(153, 0, 0));
        EliminarNeurona.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        EliminarNeurona.setText("Eliminar");
        EliminarNeurona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarNeuronaActionPerformed(evt);
            }
        });
        jPanel1.add(EliminarNeurona, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 100, 40));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agregar Neurona ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 40));

        AgregarNeurona.setBackground(new java.awt.Color(0, 153, 0));
        AgregarNeurona.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        AgregarNeurona.setText("Agregar");
        AgregarNeurona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarNeuronaActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarNeurona, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 100, 40));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, 50));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 180, 50));

        jPanel1.add(jComboBoxDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 180, 50));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Distancia ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed



//Agregar neurona 
    private void AgregarNeuronaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarNeuronaActionPerformed
String idNuevo = jTextField1.getText().trim();
    String destinoElegido = (String) jComboBoxDestino.getSelectedItem();
    String distStr = jTextField2.getText().trim();

    if (idNuevo.isEmpty() || destinoElegido == null) {
        JOptionPane.showMessageDialog(this, "Faltan datos.");
        return;
    }

    try {
        double distancia = Double.parseDouble(distStr);

                if (grafo.buscarNeurona(idNuevo) != null) {
            JOptionPane.showMessageDialog(this, "La neurona ya existe.");
            return;
        }

  
       
        grafo.agregarNeuronaManual(idNuevo); 
        
        // 3. Crear la sinapsis
        grafo.conectarNeuronas(idNuevo, destinoElegido, distancia, null, 1.0);
        JOptionPane.showMessageDialog(this, "Neurona " + idNuevo + " agregada.");
        
        jTextField1.setText("");
        jTextField2.setText("");
        cargarCombos(); 
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La distancia debe ser un número decimal.");
    }
    }//GEN-LAST:event_AgregarNeuronaActionPerformed

    
    
  //volver
    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
this.dispose();
    }//GEN-LAST:event_VolverActionPerformed
//eliminar Neurona 
    private void EliminarNeuronaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarNeuronaActionPerformed
       String idEliminar = (String) jComboBox3.getSelectedItem();
    
    if (idEliminar == null) {
        JOptionPane.showMessageDialog(this, "Selecciona una neurona para eliminar.");
        return;
    }

    // Confirmación de seguridad
    int confirmacion = JOptionPane.showConfirmDialog(this, 
            "¿Estás seguro de eliminar la neurona " + idEliminar + "? (Se borrarán sus sinapsis)", 
            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        //  Llamamos al método que crearemos en GrafoNeuronal
        grafo.eliminarNeurona(idEliminar);
        
        // Refrescamos la UI
        JOptionPane.showMessageDialog(this, "Neurona " + idEliminar + " eliminada.");
        cargarCombos(); 
    }
    }//GEN-LAST:event_EliminarNeuronaActionPerformed

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarNeurona;
    private javax.swing.JButton EliminarNeurona;
    private javax.swing.JButton Volver;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBoxDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
