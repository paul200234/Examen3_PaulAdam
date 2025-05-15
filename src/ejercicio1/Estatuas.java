package ejercicio1;

public class Estatuas extends Figura {
    private String Franquicia;


    public Estatuas(String nombre, int anioLanzamiento, double precioBase, Estado estado, String franquicia) throws Exception {
        super(nombre, anioLanzamiento, precioBase, estado);
        setFranquicia(franquicia);
    }

    public String getFranquicia() {
        return Franquicia;
    }

    public void setFranquicia(String franquicia) {
        Franquicia = franquicia;
    }

    public int getTipo(){
        return 3;
    }

@Override
    protected double getPrecioReal() throws Exception {
        switch (estado){
            case PRECINTADA -> {
                return precioBase*2;
            }
            case SIN_EMBALAJE -> {
                return precioBase;
            }
            case EMBALAJE_ORIGINAL -> {
                return precioBase/2;
            }
            default -> {
                throw new Exception("Falta estado");
            }
        }
    }
}
