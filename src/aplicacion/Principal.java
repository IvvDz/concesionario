package aplicacion;
import interfaz_usuario.*;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    static Interfaz interfaz = new Interfaz();

    public static void main(String[] args) {
        String entrada = obtenerEntrada();
        if (entrada.split(" ")[0].equalsIgnoreCase("salir")) {
            interfaz.guardar();
        } else {
            interfaz.ejecutar(entrada);
            main(args);
        }
    }

    public static String obtenerEntrada() {
        String entrada = null;
        /*while(sc.hasNextLine()){*/
        System.out.println("¿Qué desea hacer?");
        entrada = sc.nextLine();
        // };
        return entrada;
    }
}
