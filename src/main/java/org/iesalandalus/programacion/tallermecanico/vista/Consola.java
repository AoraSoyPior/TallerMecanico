package org.iesalandalus.programacion.tallermecanico.vista;


import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Vehiculos;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Consola {

    private static final String CADENA_FORMATO_FECHA = "dd/MM/yyyy";

    private Consola(){}

    public static void mostrarCabecera(String mensaje){
        for (int i = 0; i < mensaje.length(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void mostrarMenu(){
        String mensaje = "Esta es la aplicación para administrar los datos del taller mecánico";
        System.out.println(mensaje);
        mostrarCabecera(mensaje);
        for (Opcion opcion : Opcion.values()){
            System.out.println(opcion.toString());
        }
    }

    public static Opcion elegirOpcion(){
        int opcion;
        do {
            opcion = leerEntero("Introduce el número de opción: ");
        }while (!Opcion.esValida(opcion));
        return Opcion.get(opcion);
    }

    private static float leerReal(String mensaje){
        System.out.print(mensaje);
        return Entrada.real();
    }

    private static int leerEntero(String mensaje){
        System.out.print(mensaje);
        return Entrada.entero();
    }

    private static String leerCadena(String mensaje){
        System.out.print(mensaje);
        return Entrada.cadena();
    }

    private static LocalDate leerFecha(String mensaje){
        LocalDate fecha;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(CADENA_FORMATO_FECHA);
        String entrada;
        do {
            System.out.print(mensaje);
            entrada = Entrada.cadena();
            fecha = LocalDate.parse(entrada, formatoFecha);
            System.out.println();
        }while (entrada.matches(CADENA_FORMATO_FECHA));
        return fecha;
    }

    public static Cliente leerCliente(){
        return new Cliente(leerNuevoNombre(), leerClienteDni(), leerNuevoTelefono());
    }

    public static String leerClienteDni(){
        return leerCadena("Introduce el dni del cliente: ");
    }

    public static String leerNuevoNombre(){
        return leerCadena("Introduce el nombre: ");
    }

    public static String leerNuevoTelefono(){
        return leerCadena("Introduce el teléfono: ");
    }

    public static Vehiculo leerVehiculo(){
        return new Vehiculo(leerCadena("Introduce la marca del vehículo: "), leerCadena("Introduce el modelo del vehículo: "), leerCadena("Introduce la matrícula del vehículo: "));
    }

    public static Vehiculo leerVehiculoMatricula(){
        String matricula;
        System.out.print("Introduce la matrícula del vehículo");
        matricula = Entrada.cadena();
        return new Vehiculo("Seat", "Panda", matricula);
    }

    public static Revision leerRevisiones(){
        return new Revision(leerCliente(), leerVehiculo(), leerFecha("Introduce la fecha inicio:"));
    }

    public static int leerHoras(){
        System.out.print("Introduce el numero de horas: ");
        return Entrada.entero();
    }

    public static float leerPrecioMaterial(){
        System.out.print("Introduce el precio del material: ");
        return Entrada.real();
    }

    public static LocalDate leerFechaCierre(){
        return leerFecha("Introduce la fecha de cierre: ");
    }
}
