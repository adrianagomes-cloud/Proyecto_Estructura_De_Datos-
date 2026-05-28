/**
 * Estructura de datos: Grafo Dirigido para la Red Cerebral.
 */
import java.awt.Component;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Edge;
import org.graphstream.algorithm.Dijkstra;

public class GrafoNeuronal {
    
    private Lista<Neurona> neuronas;
    private Lista<Sinapsis> sinapsis;
    private SingleGraph grafo;
    
    public GrafoNeuronal() {
        this.neuronas = new Lista<>();
        this.sinapsis = new Lista<>(); 
    }

    public void agregarNeurona(String id) {
        if (buscarNeurona(id) == null) {
            neuronas.agregar(new Neurona(id));
        }
    }

    public Neurona buscarNeurona(String id) {
        for (int i = 0; i < neuronas.getTamano(); i++) {
            Neurona n = neuronas.obtener(i);
            if (n.getId().equals(id)) {
                return n;
            }
        }
        return null;
    }

    /**
     * MÉTODO CORREGIDO: Recibe los 5 parámetros que envía el GestorArchivo.
     */
    public void conectarNeuronas(String idOrigen, String idDestino, double distancia, Neurotransmisor nt, double k) {
        agregarNeurona(idOrigen);
        agregarNeurona(idDestino);

        Neurona origen = buscarNeurona(idOrigen);
        Neurona destino = buscarNeurona(idDestino);

        if (origen != null && destino != null) {
            // Se crea la sinapsis con el coeficiente k recibido del CSV
            Sinapsis nuevaSinapsis = new Sinapsis(origen, destino, distancia, nt, k);
            
            // Registro local y global
            origen.agregarSinapsis(destino, distancia, nt, k);
            this.sinapsis.agregar(nuevaSinapsis);
        }
    }

    public Lista<Neurona> getNeuronas() {
        return neuronas;
    }

    public void simularFatigaGlobal() {
        if (this.sinapsis == null) return;
        for (int i = 0; i < this.sinapsis.getTamano(); i++) {
            Sinapsis s = this.sinapsis.obtener(i);
            if (s != null) s.aplicarFatiga();
        }
    }

    public String obtenerZonasAisladas() {
        if (this.neuronas == null || this.neuronas.getTamano() == 0) {
            return "El cerebro no tiene neuronas registradas.";
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("REPORTE CLÍNICO: ZONAS AISLADAS \n\n");
        int contadorAisladas = 0;

        for (int i = 0; i < this.neuronas.getTamano(); i++) {
            Neurona neuronaActual = this.neuronas.obtener(i);
            String idActual = neuronaActual.getId();
            boolean tieneConexiones = false;

            if (this.sinapsis != null) {
                for (int j = 0; j < this.sinapsis.getTamano(); j++) {
                    Sinapsis s = this.sinapsis.obtener(j);
                    if ((s.getDestino() != null && s.getDestino().getId().equals(idActual)) || 
                        (s.getOrigen() != null && s.getOrigen().getId().equals(idActual))) {
                        tieneConexiones = true;
                        break; 
                    }
                }
            }

            if (!tieneConexiones) {
                contadorAisladas++;
                reporte.append("? Neurona Aislada: [ ").append(idActual).append(" ]\n");
            }
        }
        
        return contadorAisladas == 0 ? " Salud cerebral óptima." : reporte.toString();
    }
   public void visualizarGrafo() {
    System.setProperty("org.graphstream.ui", "swing");
    this.grafo = new SingleGraph("Red Neuronal");
    

    //  Agregar nodos 
    for (int i = 0; i < neuronas.getTamano(); i++) {
        Neurona n = neuronas.obtener(i);
        if (n != null && grafo.getNode(n.getId()) == null) {
            Node node = grafo.addNode(n.getId());
            node.setAttribute("ui.label", n.getId());
        }
    }

    //  Recorrer las sinapsis para agregar aristas y asignar colores
    for (int i = 0; i < sinapsis.getTamano(); i++) {
        Sinapsis s = sinapsis.obtener(i);
        if (s != null && s.getOrigen() != null && s.getDestino() != null) {
            
            String edgeId = s.getOrigen().getId() + "->" + s.getDestino().getId();
            
            // Verificamos si la arista ya existe 
            if (grafo.getEdge(edgeId) == null) {
                Edge arista = grafo.addEdge(edgeId, s.getOrigen().getId(), s.getDestino().getId(), true);
                arista.setAttribute("ui.label", String.format("%.2f", s.getDistancia()));
                
                arista.setAttribute("distancia", s.getDistancia());

                // Aplicar color según el coeficiente k
                double distancia = s.getDistancia(); 
            
            // Ajusta estos umbrales según el rango de distancias de tu CSV
            if (distancia < 0.3) {
                arista.setAttribute("ui.class", "bajo");
            } else if (distancia < 0.7) {
                arista.setAttribute("ui.class", "medio");
            } else {
                arista.setAttribute("ui.class", "alto");
            }
            
         
        }
            
    }  
}Estilo();
    
    org.graphstream.ui.view.Viewer viewer = grafo.display();
    viewer.setCloseFramePolicy(org.graphstream.ui.view.Viewer.CloseFramePolicy.HIDE_ONLY);

    javax.swing.SwingUtilities.invokeLater(() -> {
        java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor((Component) viewer.getDefaultView());
        if (window != null) {
            java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            int x = screenSize.width - window.getWidth() - 20; 
            int y = (screenSize.height - window.getHeight()) / 2;
            window.setLocation(x, y);
        }
    });
}

public void Estilo() {
    
    String estiloGrafo =
            "node { fill-color: purple; size: 60px; stroke-mode: plain; stroke-color: black; stroke-width: 2px; text-size: 16px; text-color: white; }" +
            "edge { size: 2px; text-size: 20px; text-background-mode: rounded-box; }" +
            // Nuevas clases para colores de aristas
            "edge.bajo { fill-color: skyblue; }" +    // distancia baja
            "edge.medio { fill-color: green; }" + // distancia media
            "edge.alto { fill-color: #FF007F; }"+     // distancia alta
            "node.ruta { fill-color: skyblue; size: 80px; stroke-width: 4px; }"+
            "edge.ruta { fill-color: #FF007F; size: 5px; }";
    
    if (this.grafo != null) {
        this.grafo.setAttribute("ui.stylesheet", estiloGrafo);
        
    }
}
   public boolean resaltarRuta(String idOrigen, String idDestino) {
   limpiarEstilosVisuales();
    
    Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "distancia");
    dijkstra.init(grafo);
    dijkstra.setSource(grafo.getNode(idOrigen));
    dijkstra.compute();

    org.graphstream.graph.Path path = dijkstra.getPath(grafo.getNode(idDestino));

    if (path != null) {
        for (Node n : path.getNodeSet()) {
            n.setAttribute("ui.class", "ruta");
        }
        for (Edge e : path.getEdgeSet()) {
            e.setAttribute("ui.class", "ruta");
        }
        
        grafo.setAttribute("ui.stylesheet", grafo.getAttribute("ui.stylesheet"));
        
        return true;
    }
    return false;
}
   
    public void limpiarEstilosVisuales() {
    if (this.grafo == null) return;

    // Limpiar nodos: Iteración directa
    for (Node n : grafo) {
        if ("ruta".equals(n.getAttribute("ui.class"))) {
            n.removeAttribute("ui.class");
        }
    }

    // Limpiar aristas: Usando .edges()
    grafo.edges().forEach(e -> {
        if ("ruta".equals(e.getAttribute("ui.class"))) {
            e.removeAttribute("ui.class");
            
            // Restaurar color original según distancia
            Object distObj = e.getAttribute("distancia");
            if (distObj instanceof Double) {
                double dist = (Double) distObj;
                if (dist < 0.3) e.setAttribute("ui.class", "bajo");
                else if (dist < 0.7) e.setAttribute("ui.class", "medio");
                else e.setAttribute("ui.class", "alto");
            }
        }
    });
    
}

} 

    
    
    
