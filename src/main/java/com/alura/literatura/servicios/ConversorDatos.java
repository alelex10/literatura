package com.alura.literatura.servicios;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDatos implements IConvierteDatos {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return mapper.readValue(json,clase);

        } catch (Exception e) {
            System.out.println("no se encontro el libro en la api");
            throw new RuntimeException(e);
        }
    }
}
