package ejercicio1;

public class Utils {
    public static int positivo(int num) throws Exception {
        if (num > 0){
        return num;}else{
            throw new Exception("Tiene que ser un numero valido");
        }
    }

    public static double positivo(double num) throws Exception {
        if (num > 0){
            return num;}else{
            throw new Exception("Tiene que ser un numero valido");
        }
    }
}
