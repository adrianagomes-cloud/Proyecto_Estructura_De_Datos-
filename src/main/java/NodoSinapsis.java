/**
 * Clase nodo para construir la lista enlazada manual de las sinapsis de una neurona.
 */
public class NodoSinapsis {
    private Sinapsis sinapsis;      // Objeto sinapsis almacenado en este nodo
    private NodoSinapsis siguiente; // Referencia al siguiente nodo en la lista
    
     /**
     * Constructor que inicializa el nodo con una sinapsis.
     * @param sinapsis El objeto Sinapsis que se desea encapsular.
     */
    public NodoSinapsis(Sinapsis sinapsis) {
        this.sinapsis = sinapsis;
        this.siguiente = null;
    }

    /** @return La sinapsis almacenada en este nodo. */
    public Sinapsis getSinapsis() { return sinapsis; }

    /** @return El siguiente nodo en la lista, o null si es el último. */
    public NodoSinapsis getSiguiente() { return siguiente; }

    /**
     * Establece la referencia al siguiente nodo de la lista.
     * @param siguiente El nodo que sucederá al actual.
     */
    public void setSiguiente(NodoSinapsis siguiente) { this.siguiente = siguiente; }
}