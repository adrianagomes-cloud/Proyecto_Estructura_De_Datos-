/**
 * Estructura de datos propia: Grafo Dirigido para la Red Cerebral.
 * Utiliza la clase Lista hecha desde cero para almacenar los nodos (Neuronas).
 */
public class GrafoNeuronal {
    
    // Lista propia con todas las neuronas que pertenecen al cerebro
    private Lista<Neurona> neuronas;

    // Constructor
    public GrafoNeuronal() {
        this.neuronas = new Lista<>();
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
     *
     */
    public void conectarNeuronas(String idOrigen, String idDestino, double distancia, Neurotransmisor nt) {
        // Asegurar que ambas neuronas existan
        agregarNeurona(idOrigen);
        agregarNeurona(idDestino);

        Neurona origen = buscarNeurona(idOrigen);
        Neurona destino = buscarNeurona(idDestino);

        // Agrega la sinapsis en la lista de adyacencia manual interna de la neurona origen
        // El coeficiente de eficiencia inicial 'k' es siempre 1.0
        origen.agregarSinapsis(destino, distancia, nt, 1.0);
    }

    /**
     * Permite acceder a la lista completa de neuronas
     */
    public Lista<Neurona> getNeuronas() {
        return neuronas;
    }
}