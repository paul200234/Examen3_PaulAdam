package ejercicio1;

import java.time.LocalDate;

public class Funko extends Figura {
    private boolean limited;


    public Funko() throws Exception {
    }

    public Funko(String csv) throws Exception {
        String[] valores = csv.split("#");
        nombre= valores[0];
        anioLanzamiento= Integer.valueOf(valores[1]);
        limited = valores[2].equals("SI");
        estado = Estado.valueOf(valores[3]);
    }

    public Funko(String nombre, int anioLanzamiento, double precioBase, Estado estado, Boolean limited) throws Exception {
        super(nombre, anioLanzamiento, precioBase, estado);
        setLimited(limited);
    }

    public boolean isLimited() {
        return limited;
    }

    public void setLimited(boolean limited) {
        this.limited = limited;
    }
    public double getPrecioReal(){
        return getPrecioBase() + ((LocalDate.now().getYear() - getAnioLanzamiento())*10);
    }
    public void mostrarLimitado(){
        if (limited) System.out.println("nombre: "+nombre);
    }
    @Override
    public int getTipo(){
        return 2;
    }
    public String toCSV(){
        return String.join("#",
                nombre,
                String.valueOf(anioLanzamiento) ,
                limited? "SI":"NO",
                String.valueOf(precioBase),
                estado +"\n"
        );
    }
}
