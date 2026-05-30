/**
 * Clase encargada de ejecutar los análisis topológicos y matemáticos sobre el grafo.
 */
public class AnalizadorAlgoritmico {

    /**
     * Detecta qué neuronas son "inalcanzables" (zonas aisladas).
     * Utiliza un recorrido de búsqueda en anchura (BFS) adaptado de forma manual.
     */
    public Lista<Neurona> detectarZonasAisladas(GrafoNeuronal grafo, String idOrigen) {
        Lista<Neurona> todasLasNeuronas = grafo.getNeuronas();
        Lista<Neurona> visitadas = new Lista<>();
        
        Neurona nodoInicial = grafo.buscarNeurona(idOrigen);
        if (nodoInicial == null) {
            return todasLasNeuronas;
        }

        Lista<Neurona> cola = new Lista<>();
        cola.agregar(nodoInicial);
        visitadas.agregar(nodoInicial);

        int indiceCola = 0;
        while (indiceCola < cola.getTamano()) {
            Neurona actual = cola.obtener(indiceCola);
            indiceCola++;

            NodoSinapsis nodoSinapsisActual = actual.getPrimerSinapsis();
            while (nodoSinapsisActual != null) {
                // Ahora llamamos a .getDestino()
                Neurona vecina = nodoSinapsisActual.getSinapsis().getDestino();
                
                if (!listaContieneNeurona(visitadas, vecina)) {
                    visitadas.agregar(vecina);
                    cola.agregar(vecina);
                }
                nodoSinapsisActual = nodoSinapsisActual.getSiguiente();
            }
        }

        Lista<Neurona> aisladas = new Lista<>();
        for (int i = 0; i < todasLasNeuronas.getTamano(); i++) {
            Neurona n = todasLasNeuronas.obtener(i);
            if (!listaContieneNeurona(visitadas, n)) {
                aisladas.agregar(n);
            }
        }

        return aisladas;
    }

    /**
     * Aplica de forma global la simulación de fatiga cognitiva.
     */
    public void simularFatigaGlobal(GrafoNeuronal grafo) {
        Lista<Neurona> neuronas = grafo.getNeuronas();
        for (int i = 0; i < neuronas.getTamano(); i++) {
            Neurona neurona = neuronas.obtener(i);
            NodoSinapsis nodoSinapsis = neurona.getPrimerSinapsis();
            while (nodoSinapsis != null) {
                nodoSinapsis.getSinapsis().aplicarFatiga();
                nodoSinapsis = nodoSinapsis.getSiguiente();
            }
        }
    }

    private boolean listaContieneNeurona(Lista<Neurona> lista, Neurona neurona) {
        for (int i = 0; i < lista.getTamano(); i++) {
            if (lista.obtener(i).getId().equals(neurona.getId())) {
                return true;
            }
        }
        return false;
    }
}