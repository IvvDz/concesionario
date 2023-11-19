package interfaz_usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import dominio.*;

public class Interfaz {
    public Interfaz(){
        ObjectInputStream obj;
        File file = new File("vehiculos.txt");
        try{
            obj = new ObjectInputStream(new FileInputStream(file));
            try{
                Concesionario.vehiculos = (ArrayList<Vehiculo>)obj.readObject();
            } catch(Exception e){
                System.out.println(e);
            }
            obj.close();
            System.out.println("Leído.");
        } catch(Exception e){
            System.out.println("No leído.");
            Concesionario.vehiculos = new ArrayList<Vehiculo>();
        }
    }

    public void ejecutar(String entrada){
        String[] split = entrada.split(" ");
        if(split[0].equalsIgnoreCase("precio")){
           System.out.println(Concesionario.obtenerPrecioTotalVehiculos());
        }
        else if(split[0].equalsIgnoreCase("agregar")){
            if(split[1].equalsIgnoreCase("coche")){
                String marca = split[2];
                String modelo = split[3];
                int base = Integer.parseInt(split[4]);
                int asientos = Integer.parseInt(split[5]);
                Coche c = Concesionario.crearCoche(marca, modelo, base, asientos);
                Concesionario.vehiculos.add(c);
                System.out.println("Coche agregado.");
            }
            if(split[1].equalsIgnoreCase("furgo") || split[1].equalsIgnoreCase("furgoneta")){
                String marca = split[2];
                String modelo = split[3];
                int base = Integer.parseInt(split[4]);
                int capacidad = Integer.parseInt(split[5]);
                int asientos = Integer.parseInt(split[6]);
                Furgoneta v = Concesionario.crearFurgoneta(marca, modelo, base, capacidad, asientos);
                Concesionario.vehiculos.add(v);
                System.out.println("Furgoneta agregada.");
            }
        }
        else if(split[0].equalsIgnoreCase("mostrar")){
            System.out.println(Concesionario.obtenerVehiculos());
        }
    }

    public void guardar(){
        ObjectOutputStream obj;
        File file = new File("vehiculos.txt");
        try{
            obj = new ObjectOutputStream(new FileOutputStream(file));
            obj.writeObject(Concesionario.vehiculos);
            obj.close();
            System.out.println("Guardado.");
        } catch(Exception e){
            System.out.println("Error al guardar.");
            System.out.println(e);
        }
    }
}
