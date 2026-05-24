import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de la lectura de archivos CSV 
 *
 */
public class GestorArchivo {

    /**
     * Lee el CSV de neurotransmisores y los almacena en el diccionario hash.
     * @param rutaArchivo Ruta del archivo CSV
     * @param diccionario Diccionario donde se guardarán los neurotransmisores.
     */
    public void cargarNeurotransmisores(String rutaArchivo, DiccionarioHash diccionario) {
        String linea;
        // Separador común en archivos CSV, puede cambiarse a ";" si tu archivo usa punto y coma
        String separador = ","; 

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Omitir la primera línea si contiene los encabezados del CSV
            String encabezado = br.readLine(); 

            while ((linea = br.readLine()) != null) {
                // Separar la línea por comas
                String[] datos = linea.split(separador);
                
                // Validación básica de estructura para evitar caídas si faltan columnas
                if (datos.length >= 4) {
                    String id = datos[0].trim();
                    String nombre = datos[1].trim();
                    String efecto = datos[2].trim();
                    double velocidad = Double.parseDouble(datos[3].trim());
                    
                    // La descripción opcional por si el CSV tiene menos columnas al final
                    String descripcion = (datos.length > 4) ? datos[4].trim() : "";

                    // Crear el objeto y guardarlo en tu tabla hash manual
                    Neurotransmisor nt = new Neurotransmisor(id, nombre, efecto, velocidad, descripcion);
                    diccionario.insertar(id, nt);
                }
            }
            System.out.println("¡Neurotransmisores cargados exitosamente!");
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de neurotransmisores: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato numérico en la velocidad: " + e.getMessage());
        }
    }

    /**
     * Lee el CSV de conexiones sinápticas y construye el grafo neuronal
     * @param rutaArchivo Ruta del archivo CSV de conexiones
     * @param grafo El grafo maestro donde se insertarán las neuronas y conexiones
     * @param diccionario El diccionario hash previamente cargado
     */
    public void cargarRedNeuronal(String rutaArchivo, GrafoNeuronal grafo, DiccionarioHash diccionario) {
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Omitir la línea de encabezados
            String encabezado = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);

                if (datos.length >= 4) {
                    String idOrigen = datos[0].trim();
                    String idDestino = datos[1].trim();
                    double distancia = Double.parseDouble(datos[2].trim());
                    String idNeurotransmisor = datos[3].trim();

                    // Buscar el objeto químico en tu tabla hash en O(1)
                    Neurotransmisor nt = diccionario.buscar(idNeurotransmisor);

                    if (nt == null) {
                        System.out.println("Advertencia: Neurotransmisor '" + idNeurotransmisor + "' no encontrado en el diccionario. Se usará una sinapsis básica.");
                    }

                    // Conectar las neuronas en el grafo
                    grafo.conectarNeuronas(idOrigen, idDestino, distancia, nt);
                }
            }
            System.out.println("¡Red neuronal cargada y estructurada exitosamente!");
         // esto luego se cambiara para que salga por la interfas grafica
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de la red neuronal: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato numérico en las distancias de sinapsis: " + e.getMessage());
        }
    }
}