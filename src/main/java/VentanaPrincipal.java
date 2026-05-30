/**
 * Clase principal de la interfaz gráfica (JFrame).
 * Gestiona el ciclo de vida de la aplicación, la carga de datos desde archivos (CSV)
 * y sirve como panel de control central para invocar las operaciones sobre la red neuronal.
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    // Atributos del sistema
    private DiccionarioHash diccionarioHash; // Estructura de almacenamiento de neurotransmisores
    private GrafoNeuronal grafo;             // Estructura de datos del grafo (Red Neuronal)
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    /**
     * Inicializa la ventana, configura el entorno visual y muestra las instrucciones
     * iniciales en el área de resultados.
     */
    public VentanaPrincipal() {
        super("Simulador de conectividad Neuronal");
        this.grafo = new GrafoNeuronal();
        initComponents();
        
        txtResultados.setText("Bienvenidos al proyecto de Adriana Gomes\n\n" +
                          "INSTRUCCIONES:\n" +
                          "1. Primero, carga el archivo del Diccionario.\n" +
                          "2. Después, carga el archivo de la Red Neuronal.");
        
        
        
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
    
    public void escribirResultado(String texto) {
    this.txtResultados.append(texto);
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
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CalcularRutaOptima = new javax.swing.JButton();
        CargarDiccionario = new javax.swing.JButton();
        CargaRedNeuronal = new javax.swing.JButton();
        SimularFatigaGlobal = new javax.swing.JButton();
        EliminarZonasAisladas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();
        DetectarZonasAisladas1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

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

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SynapseLogic");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 220, 30));

        CalcularRutaOptima.setBackground(new java.awt.Color(255, 255, 255));
        CalcularRutaOptima.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 17)); // NOI18N
        CalcularRutaOptima.setForeground(new java.awt.Color(0, 0, 0));
        CalcularRutaOptima.setText("<html><center>Calcular <br></center> Ruta Optima</html>");
        CalcularRutaOptima.setToolTipText("");
        CalcularRutaOptima.addActionListener(this::CalcularRutaOptimaActionPerformed);
        jPanel1.add(CalcularRutaOptima, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, 60));

        CargarDiccionario.setBackground(new java.awt.Color(153, 0, 51));
        CargarDiccionario.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        CargarDiccionario.setForeground(new java.awt.Color(255, 255, 255));
        CargarDiccionario.setText("<html><center>Cargar<br>Diccionario</center></html>");
        CargarDiccionario.setActionCommand("Cargarneurotransmisores");
        CargarDiccionario.addActionListener(this::CargarDiccionarioActionPerformed);
        jPanel1.add(CargarDiccionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 140, 60));

        CargaRedNeuronal.setBackground(new java.awt.Color(0, 102, 102));
        CargaRedNeuronal.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        CargaRedNeuronal.setForeground(new java.awt.Color(255, 255, 255));
        CargaRedNeuronal.setText("<html><center>Cargar Red<br></center>Neuronal</html>");
        CargaRedNeuronal.setActionCommand("Cargar Red Neuronal");
        CargaRedNeuronal.addActionListener(this::CargaRedNeuronalActionPerformed);
        jPanel1.add(CargaRedNeuronal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 140, 60));

        SimularFatigaGlobal.setBackground(new java.awt.Color(255, 255, 255));
        SimularFatigaGlobal.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        SimularFatigaGlobal.setForeground(new java.awt.Color(0, 0, 0));
        SimularFatigaGlobal.setText("<html><center>Simular<br>Fatiga Global</center></html>");
        SimularFatigaGlobal.addActionListener(this::SimularFatigaGlobalActionPerformed);
        jPanel1.add(SimularFatigaGlobal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 60));

        EliminarZonasAisladas.setBackground(new java.awt.Color(255, 255, 255));
        EliminarZonasAisladas.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        EliminarZonasAisladas.setForeground(new java.awt.Color(0, 0, 0));
        EliminarZonasAisladas.setText("<html><center>Eliminar<br>Zona Aislada</center></html>");
        EliminarZonasAisladas.addActionListener(this::EliminarZonasAisladasActionPerformed);
        jPanel1.add(EliminarZonasAisladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 140, 60));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Simulador de Conectividad Neuronal");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        txtResultados.setEditable(false);
        txtResultados.setColumns(20);
        txtResultados.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        txtResultados.setRows(5);
        jScrollPane1.setViewportView(txtResultados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 550, 150));

        DetectarZonasAisladas1.setBackground(new java.awt.Color(255, 255, 255));
        DetectarZonasAisladas1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        DetectarZonasAisladas1.setForeground(new java.awt.Color(0, 0, 0));
        DetectarZonasAisladas1.setText("<html><center>Detectar<br>Zonas Aisladas</center></html>");
        DetectarZonasAisladas1.addActionListener(this::DetectarZonasAisladas1ActionPerformed);
        jPanel1.add(DetectarZonasAisladas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 140, 60));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("borrar fatiga ");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DetectarZonasAisladas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetectarZonasAisladas1ActionPerformed
        if (this.grafo == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe cargar una Red Neuronal primero.");
            return;
        }
        String reporte = this.grafo.obtenerZonasAisladas();
        txtResultados.setText("--- ANÁLISIS DE CONECTIVIDAD ---\n\n" + reporte);
    }//GEN-LAST:event_DetectarZonasAisladas1ActionPerformed

    private void EliminarZonasAisladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarZonasAisladasActionPerformed
        if (this.grafo == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe cargar una Red Neuronal primero.");
            return;
        }

        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this,
            "¿Eliminar todas las neuronas sin conexiones?", "Confirmar",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            this.grafo.eliminarZonasAisladas();
            txtResultados.setText("--- LIMPIEZA DE RED ---\n\nZonas aisladas eliminadas con éxito.");
        }
    }//GEN-LAST:event_EliminarZonasAisladasActionPerformed
     /**
     * Ejecuta la simulación de fatiga en todas las conexiones del grafo.
     */
    private void SimularFatigaGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimularFatigaGlobalActionPerformed

    //  Validación de seguridad
    if (this.grafo == null) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Error: Primero debe cargar la Red Neuronal.",
            "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        //Ejecución de la lógica de fatiga
        this.grafo.simularFatigaGlobal();

        //  Notificación visual al usuario
        txtResultados.append("\n[SISTEMA]: Fatiga global aplicada. La resistencia sináptica ha aumentado.");
        
        javax.swing.JOptionPane.showMessageDialog(this,
            "SIMULACIÓN DE FATIGA GLOBAL\n\n" +
            "Se ha aplicado un incremento en la resistencia sináptica.\n" +
            "Las rutas ahora presentarán mayor costo en el cálculo óptimo.",
            "Simulación Activa", javax.swing.JOptionPane.WARNING_MESSAGE);

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Ocurrió un error al procesar el deterioro de la red: " + e.getMessage(),
            "Error del Sistema", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_SimularFatigaGlobalActionPerformed

     /**
     * Carga la estructura de la red neuronal desde un archivo CSV.
     * Requiere que el diccionario esté previamente inicializado.
     */
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

     /**
     * Carga el diccionario de neurotransmisores desde un archivo CSV.
     * Este es el primer paso obligatorio para validar las conexiones de la red.
     */
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

     /**
     * Invocado por el usuario para calcular la ruta óptima entre dos neuronas.
     * Abre un JDialog conteniendo el panel de búsqueda (PanelDelGrafo).
     */
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

        
        PanelDelGrafo panelBusqueda = new PanelDelGrafo(this.grafo);

        cuadroFlotante.add(panelBusqueda);
        cuadroFlotante.pack();
       int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int y = (screenHeight - cuadroFlotante.getHeight()) / 2;
        
        // Establecemos x = 80  para que se centre al borde izquierdo y y calculado para centrar
        cuadroFlotante.setLocation(80, y);
        cuadroFlotante.setResizable(false);
        cuadroFlotante.setVisible(true);
        
        
        
    }//GEN-LAST:event_CalcularRutaOptimaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (this.grafo == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe cargar una Red Neuronal primero.");
        return;
    }
    
    // Ejecutar el reset
    this.grafo.resetearFatiga();
    
    // Feedback al usuario
    txtResultados.append("\n[SISTEMA]: Fatiga borrada. Los pesos sinápticos han sido restaurados.");
    javax.swing.JOptionPane.showMessageDialog(this, "La fatiga ha sido eliminada y los pesos restaurados.");
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    
    
    
    
    
    
   
    
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
    private javax.swing.JButton DetectarZonasAisladas1;
    private javax.swing.JButton EliminarZonasAisladas;
    private javax.swing.JButton SimularFatigaGlobal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
