/**
 * Estructura de datos: Grafo Dirigido para la Red Cerebral.
 */
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class GrafoNeuronal {
    
    private Lista<Neurona> neuronas;
    private Lista<Sinapsis> sinapsis;
    
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
    Graph graph = new SingleGraph("Red Neuronal");

    // 1. Agregar nodos
    for (int i = 0; i < neuronas.getTamano(); i++) {
        Neurona n = neuronas.obtener(i);
        if (n != null && graph.getNode(n.getId()) == null) {
            Node node = graph.addNode(n.getId());
            node.setAttribute("ui.label", n.getId());
        }
    }

    // 2. Agregar aristas con validación de existencia
    for (int i = 0; i < sinapsis.getTamano(); i++) {
        Sinapsis s = sinapsis.obtener(i);
        if (s != null && s.getOrigen() != null && s.getDestino() != null) {
            String edgeId = s.getOrigen().getId() + "->" + s.getDestino().getId();
            
            // Verificamos si la arista ya existe para evitar errores
            if (graph.getEdge(edgeId) == null) {
                graph.addEdge(edgeId, s.getOrigen().getId(), s.getDestino().getId(), true);
            }
        }
    }

    // 3. Estilo visual
    graph.setAttribute("ui.stylesheet", 
        "node { fill-color: #20b2aa; size: 20px; text-size: 15; text-offset: 5, 5; } " +
        "edge { fill-color: #696969; size: 2px; arrow-shape: arrow; }");
    
    graph.display();
}
    }

    
    
    
