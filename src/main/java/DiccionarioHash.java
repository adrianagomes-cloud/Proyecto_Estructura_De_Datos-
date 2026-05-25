/**
 * Estructura de datos propia: Tabla de Dispersión (Hash Table).
 * Almacena los neurotransmisores indexados por su ID en O(1).
 */
public class DiccionarioHash {
    
    // Clase interna para guardar el par Clave-Valor
    private static class EntradaHash {
        String clave; // ID del Neurotransmisor 
        Neurotransmisor valor;

        EntradaHash(String clave, Neurotransmisor valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private Lista<EntradaHash>[] tabla;
    private final int CAPACIDAD = 31; // Tamaño

    @SuppressWarnings("unchecked")
    public DiccionarioHash() {
        // Inicializamos el arreglo de listas enlazadas
        tabla = new Lista[CAPACIDAD];
        for (int i = 0; i < CAPACIDAD; i++) {
            tabla[i] = new Lista<>();
        }
    }

    /**
     * Función de dispersión
     */
    private int calcularIndiceHash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash = (hash * 31) + clave.charAt(i);
        }
        int indice = hash % CAPACIDAD;
        return (indice < 0) ? -indice : indice; // Asegurar índice positivo
    }

    /**
     * Inserta o actualiza un neurotransmisor en la tabla.
     */
     public void insertar(String clave, Neurotransmisor valor){
        int indice = calcularIndiceHash(clave);
        Lista<EntradaHash> listaCubeta = tabla[indice];

        // Verificamos si la clave ya existe
        for (int i = 0; i < listaCubeta.getTamano(); i++) {
            EntradaHash entrada = listaCubeta.obtener(i);
            if (entrada.clave.equals(clave)) {
                entrada.valor = valor;
                return;
            }
        }

        // Si no existe
        listaCubeta.agregar(new EntradaHash(clave, valor));
    }

    /**
     * Busca y retorna un neurotransmisor por su ID
     */
    public Neurotransmisor buscar(String clave) {
        int indice = calcularIndiceHash(clave);
        Lista<EntradaHash> listaCubeta = tabla[indice];

        for (int i = 0; i < listaCubeta.getTamano(); i++) {
            EntradaHash entrada = listaCubeta.obtener(i);
            if (entrada.clave.equals(clave)) {
                return entrada.valor;
            }
        }
        return null; // Si no lo encuentra
    }
}