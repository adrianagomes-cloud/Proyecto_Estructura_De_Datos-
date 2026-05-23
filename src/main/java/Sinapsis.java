/**
 * Representa una conexión sináptica dirigida hacia una neurona destino.
 */
public class Sinapsis {
    private Neurona neuronaDestino;
    private double distancia;                 // d (del archivo CSV)
    private Neurotransmisor neurotransmisor;  // Objeto neurotransmisor asociado
    private double k;                         // Coeficiente de eficiencia (inicialmente 1.0)

    // Constructor
    public Sinapsis(Neurona neuronaDestino, double distancia, Neurotransmisor neurotransmisor, double k) {
        this.neuronaDestino = neuronaDestino;
        this.distancia = distancia;
        this.neurotransmisor = neurotransmisor;
        this.k = k;
    }

    /**
     * Calcula el peso dinámico W de la arista considerando la fatiga y la velocidad química.
     * Fórmula: W = d / (v * k)
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

    // Getters y Setters
    public Neurona getNeuronaDestino() { return neuronaDestino; }
    public double getDistancia() { return distancia; }
    public Neurotransmisor getNeurotransmisor() { return neurotransmisor; }
    public double getK() { return k; }
    public void setK(double k) { this.k = k; }
}