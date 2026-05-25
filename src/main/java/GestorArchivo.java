import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de la lectura de archivos CSV.
 */
public class GestorArchivo {

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
     * Carga la red neuronal pasando los 5 parámetros requeridos.
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

                    // LLAMADA EXACTA: 5 parámetros (idOrigen, idDestino, distancia, nt, k)
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