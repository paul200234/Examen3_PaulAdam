package ejercicio1;

public class Accesorio {
    private String nombre;
    private String Material;
    private String Descripcion;

    public Accesorio(String nombre, String material, String descripcion) {
        setNombre(nombre);
        setMaterial(material);
        setDescripcion(descripcion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Accesorio{" +
                "nombre='" + nombre + '\n' +
                ", Material='" + Material + '\n' +
                ", Descripcion='" + Descripcion + '\n' +
                '}';
    }
}
