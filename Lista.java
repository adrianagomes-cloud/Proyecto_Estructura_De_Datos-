/**
 * Estructura de datos: Lista Enlazada Simple propia.
 * No utiliza java.util.* ni diccionarios.
 */
public class Lista<T> {

    // Clase interna del nodo
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> cabeza;
    private int tamano;

    public Lista() {
        this.cabeza = null;
        this.tamano = 0;
    }

    // Agregar elemento al final
    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
    }

    /**
     * Elimina un elemento buscando su igualdad.
     * Funciona recorriendo la lista y enlazando el anterior con el siguiente.
     */
    public void eliminar(T elemento) {
        if (cabeza == null) return;

        // Si el elemento a eliminar es la cabeza
        if (cabeza.dato.equals(elemento)) {
            cabeza = cabeza.siguiente;
            tamano--;
            return;
        }

        // Buscar el elemento en la lista
        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(elemento)) {
            actual = actual.siguiente;
        }

        // Si se encontró, saltar el nodo para eliminarlo
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
        }
    }

    // Obtener elemento por índice
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamano) {
            return null; // O manejar el error según tu necesidad
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public int getTamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }
}