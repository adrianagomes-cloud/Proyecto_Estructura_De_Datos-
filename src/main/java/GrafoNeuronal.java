/**
 * Estructura de datos propia: Grafo Dirigido para la Red Cerebral.
 * Utiliza la clase Lista hecha desde cero para almacenar los nodos (Neuronas).
 */
public class GrafoNeuronal {
    
    // Lista propia con todas las neuronas que pertenecen al cerebro
    private Lista<Neurona> neuronas;
    private Lista<Sinapsis> sinapsis;
    
    // Constructor
    public GrafoNeuronal() {
        this.neuronas = new Lista<>();
        this.sinapsis = new Lista<>(); 
    }

    /**
     * Agrega una neurona al grafo si no existe previamente.
     */
    public void agregarNeurona(String id) {
        if (buscarNeurona(id) == null) {
            neuronas.agregar(new Neurona(id));
        }
    }

    /**
     * Busca una neurona en la lista por su ID único.
     * Retorna el objeto Neurona si lo encuentra, o null si no existe.
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
     * Conecta una neurona origen con una destino usando un neurotransmisor específico.
     */
    public void conectarNeuronas(String idOrigen, String idDestino, double distancia, Neurotransmisor nt) {
        // Asegurar que ambas neuronas existan
        agregarNeurona(idOrigen);
        agregarNeurona(idDestino);

        Neurona origen = buscarNeurona(idOrigen);
        Neurona destino = buscarNeurona(idDestino);

        
        // El coeficiente de eficiencia inicial 'k' es siempre 1.0
        origen.agregarSinapsis(destino, distancia, nt, 1.0);
        }

    /**
     * Permite acceder a la lista completa de neuronas
     */
    public Lista<Neurona> getNeuronas() {
        return neuronas;
    }

    /**
     * Simula el deterioro cognitivo o fatiga general multiplicando k por 1.2 [cite: 13, 18, 27]
     */
    public void simularFatigaGlobal() {
        // Validación
        if (this.sinapsis == null || this.sinapsis.estaVacia()) {
            return;
        }
        
        // Recorremos la lista usando un ciclo for 
        for (int i = 0; i < this.sinapsis.getTamano(); i++) {
            // Obtenemos la sinapsis directamente en la posición i
            Sinapsis s = this.sinapsis.obtener(i);
            
            if (s != null) {
                //  Multiplicamos el factor k por 1.2 
                double nuevoK = s.getK() * 1.2; 
                s.setK(nuevoK);
            }
        }
    }
}
