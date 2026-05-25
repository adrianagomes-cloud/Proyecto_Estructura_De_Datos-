/**
 * Estructura de datos propia: Lista Enlazada Simple Genérica.
 * Reemplaza el uso de ArrayList o LinkedList de java.util.
 */
public class Lista<T> {

    int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Clase interna que representa cada nodo contenedor de la lista
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

    /**
     * Agrega un elemento al final de la lista.
     */
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
     * Obtiene el elemento en un índice específico
     */
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
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