/**
 * Representa una conexión sináptica dirigida entre una neurona origen y una destino.
 * Esta clase encapsula la lógica de transmisión, integrando factores físicos (distancia)
 * y químicos (neurotransmisor) para calcular el peso real de la conexión en el grafo.
 */

public class Sinapsis {
    private Neurona neuronaOrigen;
    private Neurona neuronaDestino;
    private double distancia;                 // d (del archivo CSV)
    private Neurotransmisor neurotransmisor;  // Objeto neurotransmisor asociado
    private double k;                         // Coeficiente de eficiencia (inicialmente 1.0)

   /**
     * Constructor para inicializar una nueva conexión sináptica.
     * @param origen Neurona que envía la señal.
     * @param destino Neurona que recibe la señal.
     * @param distancia Factor de distancia entre nodos.
     * @param neurotransmisor Objeto con la velocidad específica de transmisión.
     * @param k Coeficiente de fatiga inicial.
     */ 
    
    public Sinapsis(Neurona origen, Neurona destino, double distancia, Neurotransmisor neurotransmisor, double k) {
        this.neuronaOrigen = origen;
        this.neuronaDestino = destino;
        this.distancia = distancia;
        this.neurotransmisor = neurotransmisor;
        this.k = k;
    }

    /**
     * Calcula el peso dinámico (W) de la arista, que representa la resistencia 
     * o "costo" de la conexión para los algoritmos de búsqueda de ruta.
     * La fórmula aplicada es: W = d / (v * k).
     * @return El peso calculado como double.
     */
    public double getPesoW() {
        double v = (neurotransmisor != null) ? neurotransmisor.getVelocidad() : 1.0;
        return this.distancia / (v * this.k);
    }

    /**
     * Aplica la simulación de fatiga multiplicando el factor k por 1.2
     */
    public void aplicarFatiga() {
        this.k = this.k * 1.2;
    }

    //Getters y Setters

    public Neurona getOrigen() {
        return neuronaOrigen;
    }

    public Neurona getDestino() {
        return neuronaDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public Neurotransmisor getNeurotransmisor() {
        return neurotransmisor;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }
}