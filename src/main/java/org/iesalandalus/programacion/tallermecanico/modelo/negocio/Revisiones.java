package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {

    private final List<Revision> coleccionRevisiones;

    public Revisiones(){
        coleccionRevisiones = new ArrayList<>();
    }

    public List<Revision> get(){
        return new ArrayList<>(coleccionRevisiones);
    }

    public List<Revision> get(Cliente cliente){
        List<Revision> resultado = new ArrayList<>();
        for (Revision coleccionRevisione : coleccionRevisiones) {
            if (coleccionRevisione.getCliente().equals(cliente)) {
                resultado.add(coleccionRevisione);
            }
        }
        return resultado;
    }

    public List<Revision> get(Vehiculo vehiculo){
        List<Revision> resultado = new ArrayList<>();
        for (Revision coleccionRevisione : coleccionRevisiones) {
            if (coleccionRevisione.getVehiculo().equals(vehiculo)) {
                resultado.add(coleccionRevisione);
            }
        }
        return resultado;
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No se puede insertar una revisión nula.");
        comprobarRevision(revision.getCliente(), revision.getVehiculo(), revision.getFechaInicio());
        coleccionRevisiones.add(revision);
    }

    private void comprobarRevision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision) throws  TallerMecanicoExcepcion{
        for (Revision revision : coleccionRevisiones) {
            if (!revision.estaCerrada()){
                if (revision.getCliente().equals(cliente)){
                    throw new TallerMecanicoExcepcion("El cliente tiene otra revisión en curso.");
                }
                if (revision.getVehiculo().equals(vehiculo)){
                    throw new TallerMecanicoExcepcion("El vehículo está actualmente en revisión.");
                }
            } else if (!fechaRevision.isAfter(revision.getFechaFin())){
                if (revision.getCliente().equals(cliente)){
                    throw new TallerMecanicoExcepcion("El cliente tiene una revisión posterior.");
                }
                if (revision.getVehiculo().equals(vehiculo)){
                    throw new TallerMecanicoExcepcion("El vehículo tiene una revisión posterior.");
                }
            }
        }
    }

    private Revision getRevision(Revision revision) throws TallerMecanicoExcepcion{
        int numero = 0;
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        if (!coleccionRevisiones.contains(revision)){
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        for (int i = 0; i < coleccionRevisiones.size(); i++){
            if (coleccionRevisiones.get(i).equals(revision)){
                numero = i;
            }
        }
        return coleccionRevisiones.get(numero);
    }

    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        getRevision(revision).anadirHoras(horas);
        return getRevision(revision);
    }

    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
        getRevision(revision).anadirPrecioMaterial(precioMaterial);
        return getRevision(revision);
    }

    public Revision cerrar(Revision revision, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        getRevision(revision).cerrar(fechaFin);
        return getRevision(revision);
    }

    public Revision buscar(Revision revision){
        Objects.requireNonNull(revision, "No se puede buscar una revisión nula.");
        int indice = coleccionRevisiones.indexOf(revision);
        return (coleccionRevisiones.contains(revision) ? coleccionRevisiones.get(indice) : null);
    }

    public void borrar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No se puede borrar una revisión nula.");
        if (!coleccionRevisiones.contains(revision)){
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        coleccionRevisiones.remove(revision);
    }


}
