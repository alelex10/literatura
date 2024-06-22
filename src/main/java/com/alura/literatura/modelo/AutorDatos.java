package com.alura.literatura.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AutorDatos(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaNasimiento,
        @JsonAlias("death_year") String fechaMuerte
) {
}
