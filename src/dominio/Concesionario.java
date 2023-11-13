import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private List<Vehiculo> catalogo = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        catalogo.add(vehiculo);
    }

    public void mostrarCatalogo() {
        for (Vehiculo vehiculo : catalogo) {
            System.out.println(vehiculo.marca + " " + vehiculo.modelo + " - Precio: " + vehiculo.calcularPrecioFinal() + " euros");
        }
    }

    public double obtenerPrecioTotal() {
        double precioTotal = 0;
        for (Vehiculo vehiculo : catalogo) {
            precioTotal += vehiculo.calcularPrecioFinal();
        }
        return precioTotal;
    }

    public static void main(String[] args) {
        VehiculoTurismo turismo1 = new VehiculoTurismo("MarcaTurismo", "ModeloTurismo", 10000, 5);
        VehiculoTurismo turismo2 = new VehiculoTurismo("MarcaTurismo", "ModeloTurismo", 10000, 7);
        Furgoneta furgoneta1 = new Furgoneta("MarcaFurgoneta", "ModeloFurgoneta", 20000, 8);

        Concesionario concesionario = new Concesionario();
        concesionario.agregarVehiculo(turismo1);
        concesionario.agregarVehiculo(turismo2);
        concesionario.agregarVehiculo(furgoneta1);

        concesionario.mostrarCatalogo();
        System.out.println("Precio total: " + concesionario.obtenerPrecioTotal() + " euros");
    }
}