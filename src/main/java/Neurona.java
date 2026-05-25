/**
 * Representa una neurona (nodo) dentro del grafo de la red cerebral.
 */
public class Neurona {
    private String id; 
    private NodoSinapsis primerSinapsis; // Puntero al inicio de su lista de adyacencia manual

    // Constructor
    public Neurona(String id) {
        this.id = id;
        this.primerSinapsis = null;
    }

    /**
     * Agrega una nueva sinapsis saliente desde esta neurona a una neurona destino.
     */
    public void agregarSinapsis(Neurona destino, double distancia, Neurotransmisor nt, double k) {
        // CORRECCIÓN AQUÍ: Pasamos 'this' como origen y 'destino' como destino
        Sinapsis nuevaSinapsis = new Sinapsis(this, destino, distancia, nt, k);
        
        NodoSinapsis nuevoNodo = new NodoSinapsis(nuevaSinapsis);
        
        // Insertamos al inicio de la lista enlazada
        nuevoNodo.setSiguiente(primerSinapsis);
        primerSinapsis = nuevoNodo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public NodoSinapsis getPrimerSinapsis() { return primerSinapsis; }
}