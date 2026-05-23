/**
 * Clase nodo para construir la lista enlazada manual de las sinapsis de una neurona.
 */
public class NodoSinapsis {
    private Sinapsis sinapsis;
    private NodoSinapsis siguiente;

    public NodoSinapsis(Sinapsis sinapsis) {
        this.sinapsis = sinapsis;
        this.siguiente = null;
    }

    public Sinapsis getSinapsis() { return sinapsis; }
    public NodoSinapsis getSiguiente() { return siguiente; }
    public void setSiguiente(NodoSinapsis siguiente) { this.siguiente = siguiente; }
}