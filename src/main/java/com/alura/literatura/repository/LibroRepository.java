package com.alura.literatura.repository;

import com.alura.literatura.modelo.Autor;
import com.alura.literatura.modelo.Lenguaje;
import com.alura.literatura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface LibroRepository extends JpaRepository<Libro,Long> {

    Optional<Libro> findByTituloContainsIgnoreCase(String nombreLibro);

    List<Libro> findByLenguaje(Lenguaje lenguaje);
@Query("SELECT a FROM Libro l JOIN l.autores a WHERE a.fechaMuerte>=:anio AND a.fechaNasimiento<=:anio")
    List<Autor> autoresVivosEnDeterminadoAnio(int anio);
}
