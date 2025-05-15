package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1Main {
    public static List<Figura> figuras= new ArrayList<>();
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        int opcion=0;
        
        while (opcion!=5){
            System.out.println("--------MENU--------");
            System.out.println("1.Añadir figuras");
            System.out.println("2.Añadir nuevo accesorio");
            System.out.println("3.Mostrar listado");
            System.out.println("4.Mostrar Funko POPs edicion Limitada");
            System.out.println("5.Salir");
            System.out.print("Introduzca su seleccion: ");
            opcion = in.nextInt();
            
            switch (opcion){
                case 1-> aniadirFigura();
                case 2-> aniadirAccesorio();
                case 3-> mostrarListado();
                case 4-> mostrarLimitada();
                case 5-> mensajeSalir();
                default -> System.err.println("Opcion no valida");
                
            }
        }
        
        
    }

    private static void aniadirFigura() throws Exception {
        int opcion=9;
        while (opcion!=4) {
            System.out.println("Que tipo de figura deseas añadir?");
            System.out.println("1.Figura de acción");
            System.out.println("2.Estatua");
            System.out.println("3.Funko POP");
            System.out.println("4.Volver");
            System.out.print("Introduzca la opción: ");

            opcion = in.nextInt();
            switch (opcion) {
                case 1 -> aniadirFiguraAccion();
                case 2 -> aniadirEstatua();
                case 3 -> aniadirFunko();
                case 4 -> mensajeSalir();
            }
        }

    }

    private static void aniadirFunko() throws Exception {
        Maqueta maqueta = crearMaqueta();
        System.out.println("El funko es edicion limitada?");
        System.out.println("1-Si");
        System.out.println("2-No");
        int i = in.nextInt();
        boolean limitada = i==1;


        figuras.add(new Funko(
                maqueta.getNombre(),
                maqueta.getAnioLanzamiento(),
                maqueta.getPrecioBase(),
                maqueta.getEstado(),
                limitada
                        ));
    }



    private static void aniadirEstatua() throws Exception {
        Maqueta maqueta = crearMaqueta();
        System.out.println("Introduce el nombre de la franquicia");
        String franquicia = in.next();
        figuras.add(new Estatuas(
                maqueta.getNombre(),
                maqueta.getAnioLanzamiento(),
                maqueta.getPrecioBase(),
                maqueta.getEstado(),
                franquicia));

    }

    private static void aniadirFiguraAccion() throws Exception {
        Maqueta maqueta = crearMaqueta();
        figuras.add(new FiguraAccion(
                maqueta.getNombre(),
                maqueta.getAnioLanzamiento(),
                maqueta.getPrecioBase(),
                maqueta.getEstado()));
    }

    private static void aniadirAccesorio() {
        System.out.println("Introduce el nombre");
        String nombre = in.next();
        System.out.println("Introduce el tipo de material");
        String material = in.next();
        System.out.println("Introduce una descripcion");
        String descripcion = in.next();
        Accesorio accesorio = new Accesorio(nombre,material,descripcion);
        String nombreFigura="0";
        do {
        System.out.println("Introduce el nombre de la Figura de accion o introduce 0 para mostrar la lista de figuras");
        nombreFigura = in.next();
        if (nombreFigura.equals("0")){
            for (Figura figura1 : figuras) {
                if (figura1.getTipo()==1) System.out.println(figura1.getNombre());

            }}
        }while (nombreFigura.equals("0"));

            boolean exists= false;
            int index=0;
            for (Figura figura1 : figuras) {
                if (figura1.getTipo()==1&&figura1.getNombre().equals(nombreFigura)) {
                    exists=true;
                    index=figuras.indexOf(figura1);
                }
            }
            if (exists) {
                FiguraAccion figuraAccion = figuras.get(index) instanceof FiguraAccion ? ((FiguraAccion) figuras.get(index)) : null;
                assert figuraAccion != null;
                figuraAccion.addAccesorio(accesorio);
            }


    }

    private static void mostrarListado() {
        figuras.forEach(figura ->
                {
                    try {
                        System.out.println("Nombre: "+figura.getNombre()
                        +"\nPrecio base: "+figura.getPrecioBase()
                        +"\nPrecio real: "+ figura.getPrecioReal());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                }
        );
    }

    private static void mostrarLimitada() {
        int contador=1;
        for (Figura figura : figuras) {
            Funko funko = figura instanceof Funko ? ((Funko) figura) : null;
            assert funko != null;
            System.out.print(contador);
            contador++;
            funko.mostrarLimitado();
        }
    }

    private static void mensajeSalir() {
        System.out.println("Saliendo...");
        
    }
    private static Maqueta crearMaqueta() throws Exception {
        System.out.println("Introduce el nombre de la figura");
        String nombre = in.next();
        System.out.println("Introduce su año de lanzamiento.");
        int anioLanzamiento = in.nextInt();
        System.out.println("Introduce su precio Base");
        double precioBase= in.nextDouble();
        System.out.println("Selecciona un estado:");

        System.out.println("1. Conserva el embalaje original.");
        System.out.println("2. Se encuentra precintado.");
        System.out.println("3.Se encuentra sin embalaje.");

        Estado estado;
        int opcion = in.nextInt();
        switch (opcion){
            case 1->estado=Estado.EMBALAJE_ORIGINAL;
            case 2->estado=Estado.PRECINTADA;
            default->estado=Estado.SIN_EMBALAJE;
        }
        return new Maqueta(nombre,anioLanzamiento,precioBase,estado);
    }
}
