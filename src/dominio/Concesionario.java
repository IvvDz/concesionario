package dominio;

import java.util.ArrayList;

public class Concesionario {
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public static String obtenerPrecioTotalVehiculos() {
        double total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.getPrecio();
        }
        return "El precio total de todos los vehículos es " + total + " €.";
    }

    public static String obtenerVehiculos() {
        StringBuilder resultado = new StringBuilder("Vehículos: ");

        int numVehiculos = vehiculos.size();
        for (int i = 0; i < numVehiculos; i++) {
            Vehiculo v = vehiculos.get(i);
            resultado.append(v.toString());

            if (i < numVehiculos - 2) {
                resultado.append(", ");
            } else if (i == numVehiculos - 2) {
                resultado.append(" y ");
            }
        }

        return resultado.toString();
    }

    public static Coche crearCoche(String marca, String modelo, int precioBase, int asientos) {
        return new Coche(marca, modelo, precioBase, asientos);
    }

    public static Furgoneta crearFurgoneta(String marca, String modelo, int precioBase, int capacidad, int asientos) {
        return new Furgoneta(marca, modelo, precioBase, capacidad, asientos);
    }
}
