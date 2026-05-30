/**
 * Clase principal que gestiona la estructura de datos del grafo.
 * Actúa como puente entre la lógica del sistema (neuronas y sinapsis) 
 * y la representación visual utilizando la librería GraphStream.
 */


import java.awt.Component;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.Edge;
import org.graphstream.algorithm.Dijkstra;

//grafo cargado 
public class GrafoNeuronal {
    
    private Lista<Neurona> neuronas;
    private Lista<Sinapsis> sinapsis;
    private SingleGraph grafo;
/**
 * Constructor que inicializa las listas enlazadas para la gestión lógica.
*/
    public GrafoNeuronal() {
        this.neuronas = new Lista<>();
        this.sinapsis = new Lista<>(); 
    }
/**
* Registra una nueva neurona en la estructura lógica.
* @param id Identificador único de la neurona.
*/
    public void agregarNeurona(String id) {
        if (buscarNeurona(id) == null) {
            neuronas.agregar(new Neurona(id));
        }
    }
/**
     * Busca una neurona por su ID dentro de la lista lógica.
     * @param id El identificador a buscar.
     * @return El objeto Neurona si existe, null en caso contrario.
     */
    
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
     * Crea una conexión (sinapsis) entre dos neuronas, registrándola lógica y visualmente.
     * Aplica estilos de color basados en la distancia (bajo, medio, alto).
     */
  public void conectarNeuronas(String idOrigen, String idDestino, double distancia, Neurotransmisor nt, double k) {
    // Asegurar que ambas neuronas existan en la estructura lógica
    agregarNeurona(idOrigen);
    agregarNeurona(idDestino);

    Neurona origen = buscarNeurona(idOrigen);
    Neurona destino = buscarNeurona(idDestino);

    if (origen != null && destino != null) {
        // Crear y registrar la sinapsis en la lista lógica
        origen.agregarSinapsis(destino, distancia, nt, k);
        Sinapsis nuevaSinapsis = new Sinapsis(origen, destino, distancia, nt, k);
        origen.agregarSinapsis(destino, distancia, nt, k);
        this.sinapsis.agregar(nuevaSinapsis);

        //  Registro visual (GraphStream)
        if (this.grafo != null) {
            String edgeId = idOrigen + "->" + idDestino;
            
            // Verificamos si la arista ya existe para evitar errores
            if (this.grafo.getEdge(edgeId) == null) {
                Edge arista = this.grafo.addEdge(edgeId, idOrigen, idDestino, true);
                
                // Asignamos atributos visuales
                arista.setAttribute("distancia", distancia);
                arista.setAttribute("ui.label", String.format("%.2f", distancia));
                
                // Aplicar estilo de color según distancia
                if (distancia < 0.3) arista.setAttribute("ui.class", "bajo");
                else if (distancia < 0.7) arista.setAttribute("ui.class", "medio");
                else arista.setAttribute("ui.class", "alto");
            }
            
            // Forzar el refresco visual
            this.grafo.setAttribute("ui.refresh");
        }
    }
    }

    public Lista<Neurona> getNeuronas() {
        return neuronas;
    }
    
     /**
     * Incrementa el factor de fatiga (k) de todas las sinapsis y actualiza
     * el peso dinámico (W) en el grafo visual para recalcular rutas.
     */
    public void simularFatigaGlobal() {
  
        for (int i = 0; i < this.sinapsis.getTamano(); i++) {
            Sinapsis s = this.sinapsis.obtener(i);
            s.aplicarFatiga(); // Incrementa k
            
            double nuevoPeso = s.getPesoW(); // Calcula W = d / (v * k)
            
            if (this.grafo != null) {
                String edgeId = s.getOrigen().getId() + "->" + s.getDestino().getId();
                Edge e = this.grafo.getEdge(edgeId);
                if (e != null) {
                    e.setAttribute("distancia", nuevoPeso); // Dijkstra lee este valor
                    e.setAttribute("ui.label", String.format("%.2f", nuevoPeso));
                }
            }
        }
        if (this.grafo != null) this.grafo.setAttribute("ui.refresh");
    }
    
    /**
     * Restaura el coeficiente k de todas las sinapsis a su valor base (1.0).
     */
    public void resetearFatiga() {
    for (int i = 0; i < this.sinapsis.getTamano(); i++) {
        Sinapsis s = this.sinapsis.obtener(i);
        s.setK(1.0); // Asumiendo que el valor inicial de k es 1.0
        
        // Actualizar el peso en el grafo visual
        if (this.grafo != null) {
            String edgeId = s.getOrigen().getId() + "->" + s.getDestino().getId();
            Edge e = this.grafo.getEdge(edgeId);
            if (e != null) {
                double pesoOriginal = s.getPesoW(); 
                e.setAttribute("distancia", pesoOriginal);
                e.setAttribute("ui.label", String.format("%.2f", pesoOriginal));
            }
        }
    }
    if (this.grafo != null) this.grafo.setAttribute("ui.refresh");
    
    
    }
    
    /**
     * Analiza el grafo en busca de nodos sin conexiones entrantes ni salientes.
     * @return Un reporte clínico con el estado de aislamiento de las neuronas.
     */
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

        // Verificar conexiones
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

        // Lógica de marcado visual
        if (this.grafo != null) {
            Node n = this.grafo.getNode(idActual);
            if (n != null) {
                if (!tieneConexiones) {
                    n.setAttribute("ui.class", "aislada"); // Aplicar color azul fuerte
                } else {
                    // Si ya no está aislada, quitamos la clase (por si acaso cambió)
                    if ("aislada".equals(n.getAttribute("ui.class"))) {
                        n.removeAttribute("ui.class");
                    }
                }
            }
        }

        if (!tieneConexiones) {
            contadorAisladas++;
            reporte.append(" Neurona Aislada: [ ").append(idActual).append(" ]\n");
        }
    }
    
    if (this.grafo != null) this.grafo.setAttribute("ui.refresh");
    
    return contadorAisladas == 0 ? " Salud cerebral óptima." : reporte.toString();
    }
    
    /**
     * Elimina físicamente del grafo todas las neuronas que no presentan conexiones.
     */
    public void eliminarZonasAisladas() {
    //Identificar neuronas sin conexiones
    Lista<Neurona> aEliminar = new Lista<>();
    for (int i = 0; i < neuronas.getTamano(); i++) {
        Neurona n = neuronas.obtener(i);
        boolean tieneConexion = false;
        
        for (int j = 0; j < sinapsis.getTamano(); j++) {
            Sinapsis s = sinapsis.obtener(j);
            if (s.getOrigen() == n || s.getDestino() == n) {
                tieneConexion = true;
                break;
            }
        }
        
        if (!tieneConexion) {
            aEliminar.agregar(n);
        }
    }

    // Eliminar las neuronas encontradas
    for (int i = 0; i < aEliminar.getTamano(); i++) {
        eliminarNeurona(aEliminar.obtener(i).getId());
    }
    
    // Refrescar visualización
    if (this.grafo != null) {
        this.grafo.setAttribute("ui.refresh");
    }
     }
    
    /**
     * Inicializa el componente visual de GraphStream y aplica los estilos CSS.
     */
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
   // donde aparecera el grafo 
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
     /**
     * Define la hoja de estilos (CSS) para la representación gráfica de nodos y aristas.
     */
     
public void Estilo() {
    //colores del grafo 
    String estiloGrafo =
            "node { fill-color: purple; size: 60px; stroke-mode: plain; stroke-color: black; stroke-width: 2px; text-size: 16px; text-color: white; }" +
            "edge { size: 2px; text-size: 20px; text-background-mode: rounded-box; }" +
            // Nuevas clases para colores de aristas
            "edge.bajo { fill-color: skyblue; }" +    // distancia baja
            "edge.medio { fill-color: green; }" + // distancia media
            "edge.alto { fill-color: #FF007F; }"+     // distancia alta
            "node.ruta { fill-color: skyblue; size: 80px; stroke-width: 4px; }"+
            "edge.ruta { fill-color: #FF007F; size: 5px; }"+
             "node.aislada { fill-color: #00008B; stroke-color: white; }"+
            "edge.fatigada { fill-color: pink; size: 3px; }";
    
    if (this.grafo != null) {
        this.grafo.setAttribute("ui.stylesheet", estiloGrafo);
        
    }
}
     /**
     * Calcula y resalta la ruta más corta entre dos neuronas usando el algoritmo de Dijkstra.
     * @param idOrigen ID de inicio.
     * @param idDestino ID de fin.
     * @return El peso total del camino encontrado o -1.0 si no existe ruta.
     */
   public double resaltarRuta(String idOrigen, String idDestino) {
        limpiarEstilosVisuales();
        Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "distancia");
        dijkstra.init(grafo);
        dijkstra.setSource(grafo.getNode(idOrigen));
        dijkstra.compute();

        org.graphstream.graph.Path path = dijkstra.getPath(grafo.getNode(idDestino));
        if (path != null) {
            for (Node n : path.getNodeSet()) n.setAttribute("ui.class", "ruta");
            for (Edge e : path.getEdgeSet()) e.setAttribute("ui.class", "ruta");
            grafo.setAttribute("ui.refresh");
            return path.getPathWeight("distancia"); // Retorna el costo total
        }
        return -1.0;
   }


   
   /**
     * Limpia los estilos de resaltado (ruta) y restaura los colores originales
     * basados en la distancia de cada sinapsis.
     */
   public void limpiarEstilosVisuales() {
    if (this.grafo == null) return;

    // Limpiar nodos quitar la clase de la ruta
    for (Node n : grafo) {
        if ("ruta".equals(n.getAttribute("ui.class"))) {
            n.removeAttribute("ui.class");
        }
    }

    // RE-ESTABLECER los colores originales en todas las aristas
    grafo.edges().forEach(e -> {
        // Obtenemos la distancia guardada originalmente al crear la arista
        Object distObj = e.getAttribute("distancia");
        
        if (distObj instanceof Double) {
            double dist = (Double) distObj;
            
            // Reasignamos la clase según la lógica de colores que definiste
            if (dist < 0.3) e.setAttribute("ui.class", "bajo");
            else if (dist < 0.7) e.setAttribute("ui.class", "medio");
            else e.setAttribute("ui.class", "alto");
        }
    });

   
    // Esto es lo que hace que los cambios se vean en pantalla inmediatamente
    this.grafo.setAttribute("ui.refresh");
}
   
   
   
    /**
     * Agrega una neurona tanto a la lista lógica como al grafo visual.
     */
    public void agregarNeuronaManual(String id) {
    if (buscarNeurona(id) == null) {
        // Agregar a la lista lógica
        neuronas.agregar(new Neurona(id));
        
        //  Crear el nodo visual solo si el grafo existe
        if (this.grafo != null) {
            Node n = this.grafo.addNode(id);
            n.setAttribute("ui.label", id);
            this.grafo.setAttribute("ui.refresh"); // IMPORTANTE
        }
    }
 }
    
    
     /**
     * Elimina una neurona de la estructura lógica y visual, junto con todas sus sinapsis.
     */
   public void eliminarNeurona(String id) {
    Neurona n = buscarNeurona(id);
    if (n == null) return;

    // Eliminar todas las sinapsis relacionadas (de la lista lógica)
    int i = 0;
    while (i < sinapsis.getTamano()) {
        Sinapsis s = sinapsis.obtener(i);
        if (s.getOrigen().getId().equals(id) || s.getDestino().getId().equals(id)) {
            sinapsis.eliminar(s);
        } else {
            i++;
        }
    }

    // Eliminar de la lista de neuronas
    neuronas.eliminar(n);

    // Eliminar visualmente del grafo (GraphStream)
    if (this.grafo != null) {
        if (this.grafo.getNode(id) != null) {
            this.grafo.removeNode(id);
        }
        this.grafo.setAttribute("ui.refresh");
    }
    }
}
    
    
