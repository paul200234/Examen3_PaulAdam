package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class FiguraAccion extends Figura{

    private List<Accesorio> accesorios = new ArrayList<>();

    public FiguraAccion(String nombre, int anioLanzamiento, double precioBase, Estado estado) throws Exception {
        super(nombre, anioLanzamiento, precioBase, estado);

    }

    public int getTipo(){
        return 1;
    }

    public List<Accesorio> getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(List<Accesorio> accesorios) {
        this.accesorios = accesorios;
    }

    public void addAccesorio(Accesorio accesorio){
        this.accesorios.add(accesorio);
    }

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
