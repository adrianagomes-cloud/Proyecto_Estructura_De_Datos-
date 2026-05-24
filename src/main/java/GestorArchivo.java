import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de la lectura de archivos CSV para el control clínico neuronal.
 */
public class GestorArchivo {

    /**
     * Lee el CSV de neurotransmisores y los almacena en el diccionario hash.
     * @param rutaArchivo Ruta del archivo CSV
     * @param diccionario Diccionario donde se guardarán los neurotransmisores.
     * @return boolean true si la carga fue exitosa, false en caso de error.
     */
    public static boolean cargarNeurotransmisores(String rutaArchivo, DiccionarioHash diccionario) {
        String linea;
        String separador = ","; 

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Omitir la primera línea si contiene los encabezados del CSV
            String encabezado = br.readLine(); 

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                
                // Validación básica de estructura 
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
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de neurotransmisores: " + e.getMessage());
            return false;
        } catch (NumberFormatException e) {
            System.err.println("Error de formato numérico en la velocidad: " + e.getMessage());
            return false;
        }
    }

    /**
     * Lee el CSV de conexiones sinápticas y construye el grafo neuronal de forma estática.
     * @param rutaArchivo Ruta del archivo CSV de conexiones
     * @param grafo El grafo maestro donde se insertarán las neuronas y conexiones
     * @param diccionarioNT El diccionario hash previamente cargado para validar la química
     * @return boolean true si la carga fue exitosa, false en caso de error.
     */
    public static boolean cargarRedNeuronal(String rutaArchivo, GrafoNeuronal grafo, DiccionarioHash diccionarioNT) {
        String linea;
        String separador = ","; 

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Omitir la primera línea si contiene los encabezados del CSV
            String encabezado = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);

                // Validación básica de que vengan las columnas necesarias
                if (datos.length >= 4) {
                    String origen = datos[0].trim();
                    String destino = datos[1].trim();
                    double distancia = Double.parseDouble(datos[2].trim());
                    String idNeurotransmisor = datos[3].trim();

                    // Buscamos el neurotransmisor en el Diccionario Hash cargado previamente
                    Neurotransmisor nt = diccionarioNT.buscar(idNeurotransmisor);

                    // Conectamos las neuronas utilizando tu lógica estructurada del grafo
                    if (nt != null) {
                        grafo.conectarNeuronas(origen, destino, distancia, nt);
                    } else {
                        System.out.println("Advertencia: Neurotransmisor " + idNeurotransmisor + " no encontrado en el diccionario.");
                        // Opcional: conectar con null o neurotransmisor básico si tu lógica lo permite
                        grafo.conectarNeuronas(origen, destino, distancia, null);
                    }
                }
            }
            System.out.println("¡Red neuronal cargada y estructurada exitosamente!");
            return true; // Carga exitosa
            
        } catch (Exception e) {
            System.out.println("Error al cargar la red neuronal: " + e.getMessage());
            return false; // Hubo un fallo en la lectura
        }
    }
}