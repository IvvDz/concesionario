public class VehiculoTurismo extends Vehiculo {
    private int numeroPlazas;

    public VehiculoTurismo(String marca, String modelo, double precioBase, int numeroPlazas) {
        super(marca, modelo, precioBase);
        this.numeroPlazas = numeroPlazas;
    }

    @Override
    public double calcularPrecioFinal() {
        if (numeroPlazas <= 5) {
            return precioBase;
        } else {
            return precioBase + 0.1 * (numeroPlazas - 5) * precioBase;
        }
    }
}