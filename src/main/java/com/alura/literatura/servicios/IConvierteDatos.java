package com.alura.literatura.servicios;

public interface IConvierteDatos {
    
    <T> T obtenerDatos(String json, Class<T> clase);
}
