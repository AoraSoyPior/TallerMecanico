package org.iesalandalus.programacion.tallermecanico.vista;

import java.util.TreeMap;

public enum Opcion {
    INSERTAR_CLIENTE(10, "Insertar cliente"),
    BUSCAR_CLIENTE(11, "Buscar cliente"),
    BORRAR_CLIENTES(12, "Borrar clientes"),
    LISTAR_CLIENTES(13, "Listar clientes"),
    MODIFICAR_CLIENTE(14, "Modificar cliente"),
    INSERTAR_VEHICULO(21, "Insertar vehículo"),
    BUSCAR_VEHICULO(22, "Buscar vehículo"),
    BORRAR_VEHICULO(23, "Borrar vehículo"),
    LISTAR_VEHICULOS(24, "Listar_vehículos"),
    INSERTAR_REVISION(31, "Insertar revisión"),
    BUSCAR_REVISION(32, "Buscar revisión"),
    BORRAR_REVISION(33, "Borrar revisión"),
    LISTAR_REVISIONES(34, "Listar revisiones"),
    LISTAR_REVISIONES_CLIENTE(35, "Listar revisiones de un cliente"),
    LISTAR_REVISIONES_VEHICULO(36, "Listar revisiones de un vehículo"),
    ANADIR_HORAS_REVISION(37, "Añadir horas a una revisión"),
    ANADIR_PRECIO_MATERIAL_REVISION(38, "Añadir precio material a una revisión"),
    CERRAR_REVISION(39, "Cerrar revisión"),
    SALIR(0, "Salir");

    private int numeroOpcion;
    private String mensaje;
    private static TreeMap<Integer, Opcion> opciones = new TreeMap<>();

    private Opcion(int numeroOpcion, String mensaje){
        this.numeroOpcion = numeroOpcion;
        this.mensaje = mensaje;
    }

    public static boolean esValida(int numeroOpcion){
        return (opciones.containsKey(numeroOpcion));
    }

    public static Opcion get(int numeroOpcion){
        if (!esValida(numeroOpcion)){
            throw new IllegalArgumentException("El número no está entre las opciones.");
        }
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {
        return String.format("%s - %s", numeroOpcion, mensaje);
    }
}
