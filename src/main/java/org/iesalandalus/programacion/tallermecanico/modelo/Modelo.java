package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Clientes;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Revisiones;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Vehiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Modelo {

    private Clientes clientes;
    private Vehiculos vehiculos;
    private Revisiones revisiones;

    public Modelo(){
        comenzar();
    }

    public void comenzar(){
        clientes = new Clientes();
        vehiculos = new Vehiculos();
        revisiones = new Revisiones();
    }

    public void terminar(){
        System.out.println("El modelo ha terminado.");
    }

    public void insertar(Cliente cliente) throws TallerMecanicoExcepcion {
        clientes.insertar(new Cliente(cliente));
    }

    public void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        vehiculos.insertar(vehiculo);
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        revisiones.insertar(new Revision(clientes.buscar(revision.getCliente()), vehiculos.buscar(revision.getVehiculo()), revision.getFechaInicio()));
    }

    public Cliente buscar(Cliente cliente){
        return (clientes.buscar(cliente) != null ? new Cliente(cliente) : null);
    }

    public Vehiculo buscar(Vehiculo vehiculo){
        return (vehiculos.buscar(vehiculo) != null ? vehiculo : null);
    }

    public Revision buscar(Revision revision){
        return (revisiones.buscar(revision) != null ? new Revision(revision) : null);
    }

    public Cliente modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion {
        return clientes.modificar(cliente, nombre, telefono);
    }

    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        return revisiones.anadirHoras(revision, horas);
    }

    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
        return revisiones.anadirPrecioMaterial(revision, precioMaterial);
    }

    public Revision cerrar(Revision revision, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        return revisiones.cerrar(revision, fechaFin);
    }

    public void borrar(Cliente cliente) throws TallerMecanicoExcepcion {
        List<Revision> revisionesCliente = revisiones.get(cliente);
        for (Revision revisionCliente : revisionesCliente){
            revisiones.borrar(revisionCliente);
        }
        clientes.borrar(cliente);
    }

    public void borrar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        List<Revision> revisionesVehiculo = revisiones.get(vehiculo);
        for (Revision revisionVehiculo : revisionesVehiculo){
            revisiones.borrar(revisionVehiculo);
        }
        vehiculos.borrar(vehiculo);
    }
    public void borrar(Revision revision) throws TallerMecanicoExcepcion {
        revisiones.borrar(revision);
    }

    public List<Cliente> getClientes(){
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes.get()){
            resultado.add(new Cliente(cliente));
        }
        return resultado;
    }

    public List<Vehiculo> getVehiculos(){
        return new ArrayList<>(vehiculos.get());
    }

    public List<Revision> getRevisiones(){
        List<Revision> resultado = new ArrayList<>();
        for (Revision revision : revisiones.get()){
            resultado.add(new Revision(revision));
        }
        return resultado;
    }

    public List<Revision> getRevisiones(Cliente cliente){
        List<Revision> resultado = new ArrayList<>();
        for (Revision revision : revisiones.get(cliente)){
            resultado.add(new Revision(revision));
        }
        return resultado;
    }

    public List<Revision> getRevisiones(Vehiculo vehiculo){
        List<Revision> resultado = new ArrayList<>();
        for (Revision revision : revisiones.get(vehiculo)){
            resultado.add(new Revision(revision));
        }
        return resultado;
    }
}
