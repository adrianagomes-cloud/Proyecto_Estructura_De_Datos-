/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author adria
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    // Atributos del sistema
    private DiccionarioHash diccionarioHash;
    private GrafoNeuronal grafo;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    /**
     * Creates new form NewJFrame
     */
    public VentanaPrincipal() {
        super("Simulador de conectividad Neuronal");
        initComponents();
         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    // Centramos verticalmente 
    int x = 0; 
    int y = (screenSize.height - this.getHeight()) / 2;
    
    this.setLocation(x, y);

    }
public void cambiarPanel(javax.swing.JPanel nuevoPanel) {
    jPanel1.removeAll();
    // Forzamos el layout para garantizar la posición a la izquierda
    jPanel1.setLayout(new java.awt.BorderLayout()); 
    jPanel1.add(nuevoPanel, java.awt.BorderLayout.WEST);
    jPanel1.revalidate();
    jPanel1.repaint();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CalcularRutaOptima = new javax.swing.JButton();
        CargarDiccionario = new javax.swing.JButton();
        CargaRedNeuronal = new javax.swing.JButton();
        SimularFatigaGlobal = new javax.swing.JButton();
        DetectarZonasAisladas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SynapseLogic: Simulador de Conectividad Neuronal");

        jButton1.setText("jButton1");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SynapseLogic");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 220, 30));

        CalcularRutaOptima.setBackground(new java.awt.Color(255, 255, 255));
        CalcularRutaOptima.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 17)); // NOI18N
        CalcularRutaOptima.setForeground(new java.awt.Color(0, 0, 0));
        CalcularRutaOptima.setText("<html><center>Calcular <br></center> Ruta Optima</html>");
        CalcularRutaOptima.setToolTipText("");
        CalcularRutaOptima.addActionListener(this::CalcularRutaOptimaActionPerformed);
        jPanel1.add(CalcularRutaOptima, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 140, 60));

        CargarDiccionario.setBackground(new java.awt.Color(255, 255, 255));
        CargarDiccionario.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        CargarDiccionario.setForeground(new java.awt.Color(0, 0, 0));
        CargarDiccionario.setText("<html><center>Cargar<br>Diccionario</center></html>");
        CargarDiccionario.setActionCommand("Cargarneurotransmisores");
        CargarDiccionario.addActionListener(this::CargarDiccionarioActionPerformed);
        jPanel1.add(CargarDiccionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 140, 60));

        CargaRedNeuronal.setBackground(new java.awt.Color(255, 255, 255));
        CargaRedNeuronal.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        CargaRedNeuronal.setForeground(new java.awt.Color(0, 0, 0));
        CargaRedNeuronal.setText("<html><center>Cargar Red<br></center>Neuronal</html>");
        CargaRedNeuronal.setActionCommand("Cargar Red Neuronal");
        CargaRedNeuronal.addActionListener(this::CargaRedNeuronalActionPerformed);
        jPanel1.add(CargaRedNeuronal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 140, 60));

        SimularFatigaGlobal.setBackground(new java.awt.Color(255, 255, 255));
        SimularFatigaGlobal.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        SimularFatigaGlobal.setForeground(new java.awt.Color(0, 0, 0));
        SimularFatigaGlobal.setText("<html><center>Simular<br>Fatiga Global</center></html>");
        SimularFatigaGlobal.addActionListener(this::SimularFatigaGlobalActionPerformed);
        jPanel1.add(SimularFatigaGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 60));

        DetectarZonasAisladas.setBackground(new java.awt.Color(255, 255, 255));
        DetectarZonasAisladas.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        DetectarZonasAisladas.setForeground(new java.awt.Color(0, 0, 0));
        DetectarZonasAisladas.setText("<html><center>Detectar<br>Zonas Aisladas</center></html>");
        DetectarZonasAisladas.addActionListener(this::DetectarZonasAisladasActionPerformed);
        jPanel1.add(DetectarZonasAisladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, 60));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Simulador de Conectividad Neuronal");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, -1, -1));

        txtResultados.setEditable(false);
        txtResultados.setColumns(20);
        txtResultados.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        txtResultados.setRows(5);
        jScrollPane1.setViewportView(txtResultados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 550, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Boton de Cargar Neurotransmisores 
    private void CargarDiccionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarDiccionarioActionPerformed
    //  seleccionar el archivo CSV
    javax.swing.JFileChooser selectorArchivo = new javax.swing.JFileChooser();
    selectorArchivo.setDialogTitle("Seleccionar CSV de Neurotransmisores");
    javax.swing.filechooser.FileNameExtensionFilter filtro = new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
    selectorArchivo.setFileFilter(filtro);

    int resultado = selectorArchivo.showOpenDialog(this);
    
    if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File archivoSeleccionado = selectorArchivo.getSelectedFile();
        
        try {
            // Permitir el vaciado y recarga completa al subir un nuevo diccionario
            this.diccionarioHash = new DiccionarioHash(); 
            
            // Invocamos al Gestor de Archivos para procesar y cargar los neurotransmisores
            boolean exito = GestorArchivo.cargarNeurotransmisores(archivoSeleccionado.getAbsolutePath(), this.diccionarioHash);
            
            if (exito) {
                // Limpiamos la consola 
                txtResultados.setText(""); 
                txtResultados.append(" CONTROL DE NEUROTRANSMISORES \n");
                txtResultados.append(" Diccionario Hash cargado e inicializado con éxito.\n");
               
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Error: La estructura interna no es válida.", 
                    "Error de Validación", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "No se pudo leer el archivo de neurotransmisores: " + e.getMessage(), 
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_CargarDiccionarioActionPerformed

    
    
    
    // Boton de Buscar Ruta Optima
    private void CalcularRutaOptimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularRutaOptimaActionPerformed
  // Verificación de seguridad
    if (this.grafo == null) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error: Primero debe cargar la Red Neuronal.", 
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    javax.swing.JFrame topFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
    javax.swing.JDialog cuadroFlotante = new javax.swing.JDialog(topFrame, "Selección de Ruta Óptima", true);
    
    // 
    PanelDelGrafo panelBusqueda = new PanelDelGrafo(this.grafo);
    
    cuadroFlotante.add(panelBusqueda);
    cuadroFlotante.pack();
    cuadroFlotante.setLocationRelativeTo(topFrame);
    cuadroFlotante.setResizable(false);
    cuadroFlotante.setVisible(true);
    }//GEN-LAST:event_CalcularRutaOptimaActionPerformed

    
    
    
    
    // Simular Fatiga Global
    private void SimularFatigaGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimularFatigaGlobalActionPerformed
        // podemos fatigar un cerebro sin datos cargados
    if (this.grafo == null || this.grafo.getNeuronas().estaVacia()) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error: No se puede simular fatiga porque la Red Neuronal no ha sido cargada.", 
            "Falta de Datos", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        // Invocamos la lógica matemática
        this.grafo.simularFatigaGlobal();
        
        //  Notificación
        javax.swing.JOptionPane.showMessageDialog(this, 
            "SIMULACIÓN DE TRAUMA COGNITIVO\n\n" +
            "Fatiga inducida globalmente con éxito.\n" +
            " Impacto: El factor de conexión (k) se multiplicó por 1.2 de forma general.\n\n" +
            "A partir de este momento, las sinapsis presentarán mayor resistencia,\n" +
            "afectando los tiempos del camino óptimo en el cálculo de rutas.", 
            "Simulación Activa", javax.swing.JOptionPane.WARNING_MESSAGE);
            
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Ocurrió un error al procesar el deterioro de la red: " + e.getMessage(), 
            "Error del Simulador", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_SimularFatigaGlobalActionPerformed
//Cargar Red Neuronal
    private void CargaRedNeuronalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaRedNeuronalActionPerformed
  if (this.diccionarioHash == null) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error: Primero debe cargar el Diccionario de Neurotransmisores\npara poder validar las conexiones químicas de la red.", 
            "Orden Requerido", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    javax.swing.JFileChooser selectorArchivo = new javax.swing.JFileChooser();
    selectorArchivo.setDialogTitle("Seleccionar CSV de Red Neuronal (Sinapsis)");
    javax.swing.filechooser.FileNameExtensionFilter filtro = new javax.swing.filechooser.FileNameExtensionFilter("Archivos CSV", "csv");
    selectorArchivo.setFileFilter(filtro);
    
    int resultado = selectorArchivo.showOpenDialog(this);
    
    if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File archivoSeleccionado = selectorArchivo.getSelectedFile();
        
        try {
            this.grafo = new GrafoNeuronal(); 
            boolean exito = GestorArchivo.cargarRedNeuronal(archivoSeleccionado.getAbsolutePath(), this.grafo, this.diccionarioHash);
            
            if (exito) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "MAPA SINÁPTICO CEREBRAL\n\n" +
                    "Red Neuronal cargada con éxito en la estructura de Grafo.", 
                    "Carga Exitosa", javax.swing.JOptionPane.INFORMATION_MESSAGE);
               
                // LLAMADA A LA VISUALIZACIÓN
                // Usamos invokeLater para asegurar que Swing dibuje la ventana correctamente
                java.awt.EventQueue.invokeLater(() -> {
                    this.grafo.visualizarGrafo();
                });
                
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Error: El archivo de la red neuronal no pudo ser procesado.", 
                    "Error de Validación", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "No se pudo leer el archivo de la red neuronal: " + e.getMessage(), 
                "Error del Sistema", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_CargaRedNeuronalActionPerformed

    
    
    private void DetectarZonasAisladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetectarZonasAisladasActionPerformed
                                                       
    //  Verificación de seguridad
    if (this.grafo == null) {
        txtResultados.setText(" Error: El sistema no detecta una red neuronal cargada. Por favor, cargue la red primero.");
        return;
    }

    //  Ejecutar el análisis clínico
    // Estamos llamando directamente al método que corregimos en GrafoNeuronal.java
    String reporte = this.grafo.obtenerZonasAisladas();

    //  Mostrar el reporte en tu área de texto
    txtResultados.setText(reporte);
    }//GEN-LAST:event_DetectarZonasAisladasActionPerformed

   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalcularRutaOptima;
    private javax.swing.JButton CargaRedNeuronal;
    private javax.swing.JButton CargarDiccionario;
    private javax.swing.JButton DetectarZonasAisladas;
    private javax.swing.JButton SimularFatigaGlobal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtResultados;
    // End of variables declaration//GEN-END:variables
}
