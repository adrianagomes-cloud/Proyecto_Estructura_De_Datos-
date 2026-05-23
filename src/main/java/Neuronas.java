
public class Neuronas {
    private String id;
    private String nombre;
    private String efecto;
    private double velocidad;
    private String descripcion;

    // Constructor
    public Neuronas(String id, String nombre, String efecto, double velocidad, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.efecto = efecto;
        this.velocidad = velocidad;
        this.descripcion = descripcion;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEfecto() { return efecto; }
    public double getVelocidad() { return velocidad; }
    public String getDescripcion() { return descripcion; }
}