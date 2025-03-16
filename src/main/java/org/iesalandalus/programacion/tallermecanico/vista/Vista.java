package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.controlador.Controlador;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.util.Objects;

import static org.iesalandalus.programacion.tallermecanico.vista.Opcion.*;

public class Vista {

    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        Objects.requireNonNull(controlador, "El controlador no puede ser nulo.");
        this.controlador = controlador;
    }

    public void comenzar() {
        Opcion opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutar(opcion);
        }while (opcion != SALIR);
    }

    public void terminar(){
        System.out.println("Se va a cerrar el programa");
    }

    private void ejecutar(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_CLIENTE -> insertarCliente();
            case BUSCAR_CLIENTE -> buscarCliente();
            case BORRAR_CLIENTES -> borrarCliente();
            case LISTAR_CLIENTES -> listarClientes();
            case MODIFICAR_CLIENTE -> modificarCliente();
            case INSERTAR_VEHICULO -> insertarVehiculo();
            case BUSCAR_VEHICULO -> buscarVehiculo();
            case BORRAR_VEHICULO -> borrarVehiculo();
            case LISTAR_VEHICULOS -> listarVehiculos();
            case INSERTAR_REVISION -> insertarRevision();
            case BUSCAR_REVISION -> buscarRevision();
            case BORRAR_REVISION -> borrarRevision();
            case LISTAR_REVISIONES -> listarRevisiones();
            case LISTAR_REVISIONES_CLIENTE -> listarRevisionesCliente();
            case LISTAR_REVISIONES_VEHICULO -> listarRevisionesVehiculo();
            case ANADIR_HORAS_REVISION -> anadirHoras();
            case ANADIR_PRECIO_MATERIAL_REVISION -> anadirPrecioMaterial();
            case CERRAR_REVISION -> cerrarRevision();
            case SALIR -> salir();
        }
    }

    private void insertarCliente(){
        Consola.mostrarCabecera(INSERTAR_CLIENTE.toString());
        System.out.println(INSERTAR_CLIENTE);
        try{
            controlador.insertar(Consola.leerCliente());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void buscarCliente(){
        Consola.mostrarCabecera(BUSCAR_CLIENTE.toString());
        System.out.println(BUSCAR_CLIENTE);
        controlador.buscar(Consola.leerCliente());
    }

    private void borrarCliente(){
        Consola.mostrarCabecera(BORRAR_CLIENTES.toString());
        System.out.println(BORRAR_CLIENTES);
        try{
            controlador.borrar(Consola.leerCliente());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void listarClientes(){
        Consola.mostrarCabecera(LISTAR_CLIENTES.toString());
        System.out.println(LISTAR_CLIENTES);
        controlador.getClientes();
    }

    private void modificarCliente(){
        Consola.mostrarCabecera(MODIFICAR_CLIENTE.toString());
        System.out.println(MODIFICAR_CLIENTE);
        try{
            controlador.modificar(Consola.leerCliente(), Consola.leerNuevoNombre(), Consola.leerNuevoTelefono());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void insertarVehiculo(){
        Consola.mostrarCabecera(INSERTAR_VEHICULO.toString());
        System.out.println(INSERTAR_VEHICULO);
        try{
            controlador.insertar(Consola.leerVehiculo());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void buscarVehiculo(){
        Consola.mostrarCabecera(BUSCAR_VEHICULO.toString());
        System.out.println(BUSCAR_VEHICULO);
        controlador.buscar(Consola.leerVehiculo());
    }

    private void borrarVehiculo(){
        Consola.mostrarCabecera(BORRAR_VEHICULO.toString());
        System.out.println(BORRAR_VEHICULO);
        try{
            controlador.borrar(Consola.leerVehiculo());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void listarVehiculos(){
        Consola.mostrarCabecera(LISTAR_VEHICULOS.toString());
        System.out.println(LISTAR_VEHICULOS);
        controlador.getVehiculos();
    }

    private void insertarRevision(){
        Consola.mostrarCabecera(INSERTAR_REVISION.toString());
        System.out.println(INSERTAR_REVISION);
        try{
            controlador.insertar(Consola.leerRevision());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void buscarRevision(){
        Consola.mostrarCabecera(BUSCAR_REVISION.toString());
        System.out.println(BUSCAR_REVISION);
        controlador.buscar(Consola.leerRevision());
    }

    private void borrarRevision(){
        Consola.mostrarCabecera(BORRAR_REVISION.toString());
        System.out.println(BORRAR_REVISION);
        try{
            controlador.borrar(Consola.leerRevision());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void listarRevisiones(){
        Consola.mostrarCabecera(LISTAR_REVISIONES.toString());
        System.out.println(LISTAR_REVISIONES);
        controlador.getRevisiones();
    }

    private void listarRevisionesCliente(){
        Consola.mostrarCabecera(LISTAR_REVISIONES_CLIENTE.toString());
        System.out.println(LISTAR_REVISIONES_CLIENTE);
        controlador.getRevisiones(Consola.leerCliente());
    }

    private void listarRevisionesVehiculo(){
        Consola.mostrarCabecera(LISTAR_REVISIONES_VEHICULO.toString());
        System.out.println(LISTAR_REVISIONES_VEHICULO);
        controlador.getRevisiones(Consola.leerVehiculo());
    }

    private void anadirPrecioMaterial(){
        Consola.mostrarCabecera(ANADIR_PRECIO_MATERIAL_REVISION.toString());
        System.out.println(ANADIR_PRECIO_MATERIAL_REVISION);
        try{
            controlador.anadirPrecioMaterial(Consola.leerRevision(), Consola.leerPrecioMaterial());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void anadirHoras(){
        Consola.mostrarCabecera(ANADIR_HORAS_REVISION.toString());
        System.out.println(ANADIR_HORAS_REVISION);
        try{
            controlador.anadirHoras(Consola.leerRevision(), Consola.leerHoras());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void cerrarRevision(){
        Consola.mostrarCabecera(CERRAR_REVISION.toString());
        System.out.println(CERRAR_REVISION);
        try{
            controlador.cerrar(Consola.leerRevision(), Consola.leerFechaCierre());
        }catch (TallerMecanicoExcepcion e){
            System.out.println(e.getMessage());
        }
    }

    private void salir(){
        controlador.terminar();
    }
}
