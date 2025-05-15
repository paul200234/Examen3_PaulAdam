package ejercicio1;

public class Maqueta extends Figura {
    public Maqueta(String nombre, int anioLanzamiento, double precioBase, Estado estado) throws Exception {
        super(nombre, anioLanzamiento, precioBase, estado);
    }

    public int getTipo(){
        return 0;
    }

    @Override
    protected double getPrecioReal() throws Exception {
        return 0;
    }
}
