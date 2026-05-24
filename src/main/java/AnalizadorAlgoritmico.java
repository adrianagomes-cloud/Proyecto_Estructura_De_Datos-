/**
 * Clase encargada de ejecutar los análisis topológicos y matemáticos sobre el grafo
 * Implementa algoritmos de recorrido sin utilizar librerías de java.util
 */
public class AnalizadorAlgoritmico {

    /**
     * Detecta qué neuronas son "inalcanzables" (zonas aisladas) 
     * Utiliza un recorrido de búsqueda en anchura (BFS) adaptado de forma manual
     * * @param grafo El grafo con la red neuronal completa.
     * @param idOrigen El ID de la neurona desde donde se inicia el estímulo
     * @return Una Lista de neuronas que quedaron aisladas y no recibieron el estímulo
     */
    public Lista<Neurona> detectarZonasAisladas(GrafoNeuronal grafo, String idOrigen) {
        Lista<Neurona> todasLasNeuronas = grafo.getNeuronas();
        Lista<Neurona> visitadas = new Lista<>();
        
        Neurona nodoInicial = grafo.buscarNeurona(idOrigen);
        if (nodoInicial == null) {
            // Si la neurona origen no existe, toda la red está técnicamente aislada
            return todasLasNeuronas;
        }

        // Simulamos una Cola (Queue) usando nuestra Lista propia 
        Lista<Neurona> cola = new Lista<>();
        cola.agregar(nodoInicial);
        visitadas.agregar(nodoInicial);

        int indiceCola = 0;
        while (indiceCola < cola.getTamano()) {
            Neurona actual = cola.obtener(indiceCola);
            indiceCola++;

            // Recorremos las sinapsis salientes de la neurona usando los nodos enlazados manuales
            NodoSinapsis nodoSinapsisActual = actual.getPrimerSinapsis();
            while (nodoSinapsisActual != null) {
                Neurona vecina = nodoSinapsisActual.getSinapsis().getNeuronaDestino();
                
                // Verificar manualmente si ya fue visitada
                if (!listaContieneNeurona(visitadas, vecina)) {
                    visitadas.agregar(vecina);
                    cola.agregar(vecina);
                }
                nodoSinapsisActual = nodoSinapsisActual.getSiguiente();
            }
        }

        // Identificar las Zonas Aisladas 
        // Aquellas neuronas que están en el grafo pero NUNCA fueron visitadas
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
     * Aplica de forma global la simulación de fatiga cognitiva a todas las conexiones.
     * Multiplica el coeficiente k de cada sinapsis por 1.2, alterando el peso W de forma dinámica.
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

    /**
     * Método auxiliar manual para verificar si una lista contiene a una neurona específica.
     * 
     */
    private boolean listaContieneNeurona(Lista<Neurona> lista, Neurona neurona) {
        for (int i = 0; i < lista.getTamano(); i++) {
            if (lista.obtener(i).getId().equals(neurona.getId())) {
                return true;
            }
        }
        return false;
    }
}