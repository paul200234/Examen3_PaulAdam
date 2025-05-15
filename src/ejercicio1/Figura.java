package ejercicio1;

public abstract class Figura {
    protected String nombre;
    protected int anioLanzamiento;
    protected double precioBase;
    protected Estado estado;

    public Figura() throws Exception {
        this(null, 0, 0.0, null);
    }

    public Figura(String nombre, int anioLanzamiento, double precioBase, Estado estado) throws Exception {
        this.nombre = nombre;
        setAnioLanzamiento(anioLanzamiento);
        setPrecioBase(precioBase);
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) throws Exception {
        this.anioLanzamiento = Utils.positivo(anioLanzamiento) ;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) throws Exception {
        this.precioBase = Utils.positivo(precioBase);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    protected abstract double getPrecioReal() throws Exception;
    //si pongo aqui el código deja de ser abstracto el metodo pero ahorraria codigo

    protected abstract int getTipo();

    @Override
    public String toString() {
        return "Figura{" +
                "nombre='" + nombre + '\'' +
                ", anioLanzamiento=" + anioLanzamiento +
                ", precioBase=" + precioBase +
                ", estado=" + estado +
                '}';
    }
}
