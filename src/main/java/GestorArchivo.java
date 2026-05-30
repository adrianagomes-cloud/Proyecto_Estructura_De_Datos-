import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de la lectura y procesamiento de archivos externos (formato CSV).
 * Proporciona métodos para poblar tanto el diccionario de neurotransmisores como 
 * la topología del grafo neuronal.
 */
public class GestorArchivo {
/**
     * Lee un archivo CSV que contiene la información de los neurotransmisores y los carga 
     * en el DiccionarioHash proporcionado.
     * @param rutaArchivo Ruta del archivo CSV fuente.
     * @param diccionario Instancia del DiccionarioHash donde se almacenarán los objetos.
     * @return true si la carga fue exitosa, false si ocurrió algún error de lectura o formato.
     */
    
    public static boolean cargarNeurotransmisores(String rutaArchivo, DiccionarioHash diccionario) {
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine(); 

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                if (datos.length >= 5) {
                    String id = datos[0].trim();
                    String nombre = datos[1].trim();
                    String efecto = datos[2].trim();
                    double velocidad = Double.parseDouble(datos[3].trim());
                    String descripcion = datos[4].trim();
                    
                 diccionario.insertar(id, new Neurotransmisor(id, nombre, efecto, velocidad, descripcion));
                }
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error al cargar neurotransmisores: " + e.getMessage());
            return false;
        }
    }

    /**
     * Carga la configuración de la red neuronal desde un archivo CSV.
     * Este método asocia las conexiones entre neuronas utilizando los neurotransmisores 
     * previamente almacenados en el DiccionarioHash.
     * @param rutaArchivo Ruta del archivo CSV con la topología de la red.
     * @param grafo Instancia del grafo neuronal a configurar.
     * @param diccionarioNT Diccionario que contiene los neurotransmisores necesarios para la conexión.
     * @return true si la red se cargó y conectó exitosamente, false en caso de error.
     */
    
    
    public static boolean cargarRedNeuronal(String rutaArchivo, GrafoNeuronal grafo, DiccionarioHash diccionarioNT) {
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine(); // Salta encabezado

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                
                // Aseguramos que existan al menos las 5 columnas
                if (datos.length >= 5) {
                    String origen = datos[0].trim();
                    String destino = datos[1].trim();
                    double distancia = Double.parseDouble(datos[2].trim());
                    String idNT = datos[3].trim();
                    double k = Double.parseDouble(datos[4].trim()); // Coeficiente k

                    // Buscamos el neurotransmisor en el Diccionario
                    Neurotransmisor nt = diccionarioNT.buscar(idNT);

                    //5 parámetros (idOrigen, idDestino, distancia, nt, k)
                    grafo.conectarNeuronas(origen, destino, distancia, nt, k);
                }
            }
            System.out.println("¡Red neuronal cargada exitosamente!");
            return true;
        } catch (Exception e) {
            System.err.println("Error al cargar la red neuronal: " + e.getMessage());
            return false;
        }
    }
}