package com.alura.literatura.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;

import java.util.List;
//para ignorar infomacion que no nesesite mapear
@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDatos(
        @JsonAlias("title") String titulo,
        @JsonAlias("languages") List<String> lenguajes,
        @JsonAlias("copyright") String copyright,
        @JsonAlias("download_count") Integer cantidadDescargas,
        @JsonAlias("authors") List<AutorDatos> autores
) {
}
