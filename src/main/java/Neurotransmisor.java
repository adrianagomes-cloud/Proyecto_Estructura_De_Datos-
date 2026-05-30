/**
 * Clase modelo que representa un Neurotransmisor.
 * Contiene las propiedades biológicas y los parámetros de transmisión que influyen
 * en la velocidad de la comunicación sináptica dentro del grafo.
 */
    public class Neurotransmisor {
    private String id;          // Identificador único
    private String nombre;      // Nombre común del neurotransmisor
    private String efecto;      // Efecto principal (excitatorio/inhibitorio)
    private double velocidad;   // Factor de velocidad de transmisión (utilizado en el cálculo de W)
    private String descripcion; // Información detallada

    /**
     * Constructor para inicializar un nuevo neurotransmisor.
     * @param id Identificador único.
     * @param nombre Nombre del neurotransmisor.
     * @param efecto Efecto biológico.
     * @param velocidad Factor que determina qué tan rápido viaja la señal.
     * @param descripcion Breve explicación del neurotransmisor.
     */
    public Neurotransmisor(String id, String nombre, String efecto, double velocidad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.velocidad = velocidad;
        this.descripcion = descripcion;
    }

    /** @return El identificador único del neurotransmisor. */
    public String getId() { return id; }

    /** @return El nombre del neurotransmisor. */
    public String getNombre() { return nombre; }

    /** @return El efecto (excitatorio o inhibitorio). */
    public String getEfecto() { return efecto; }

    /** @return La velocidad de transmisión (usada para calcular el peso de la sinapsis). */
    public double getVelocidad() { return velocidad; }

    /** @return La descripción detallada del neurotransmisor. */
    public String getDescripcion() { return descripcion; }
}