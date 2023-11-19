package dominio;

public class Vehiculo {
    private String marca;
    private String modelo;
    private double precioBase;
    private double precioFinal;
    private int asientos;

    public Vehiculo(String marca, String modelo, int precioBase, int asientos) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.asientos = asientos;
        this.precioFinal = calcularPrecioFinal(this.asientos);
    }

    private double calcularPrecioFinal(int asientos) {
        if (asientos <= 5) {
            this.precioFinal = this.precioBase;
        } else if (asientos > 5) {
            int exceso = asientos - 5;
            for (int i = 0; i < exceso; i++) {
                this.precioFinal += this.precioBase * 0.1;
            }
        }
        return this.precioFinal;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getPrecioBase() {
        return this.precioBase;
    }

    public double getPrecio() {
        return this.precioFinal;
    }

    public int getAsientos() {
        return this.asientos;
    }
}
