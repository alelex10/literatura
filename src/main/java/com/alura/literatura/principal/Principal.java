package com.alura.literatura.principal;

import com.alura.literatura.modelo.*;
import com.alura.literatura.repository.LibroRepository;
import com.alura.literatura.servicios.ConsumirAPI;
import com.alura.literatura.servicios.ConversorDatos;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    final String URL_BASE ="http://gutendex.com/books/";
    ConsumirAPI consumoAPI =new ConsumirAPI();
    ConversorDatos conversor= new ConversorDatos();
    Scanner teclado = new Scanner(System.in);


    private LibroRepository repositorio;
    public Principal(LibroRepository repository) {
        this.repositorio=repository;
    }

    public void mostrar(){
//        List<Libro> libros=new ArrayList<>();
//
//        String json = consumoAPI.peticionHTTP(URL_BASE);
//        Datos datos= conversor.obtenerDatos(json, Datos.class);
//        datos.resultados().forEach(r->libros.add(new Libro(r)));
//
//        libros.forEach(System.out::println);
        int opcionElegida=1;
        while (opcionElegida != 0){
            System.out.println(menuPrinsipal());
            opcionElegida= Seleccionar.opcion();
            switch (opcionElegida){
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listaLibrosRegistrados();
                    break;
                case 3:
                    listaDeAutoresRegistrados();
                    break;
                case 4:
                    listaDeAutoresVivosEnDeterminadoAnio();
                    break;
                case 5:
                    listaDeLibrosPorIdioma();
                    break;
                case 0:
                    break;
            }

        }
    }



    private String menuPrinsipal(){
        return """
                
                =============================================
                1) buscar libro por titulo
                2) lista de libros registrados
                3) lista de autores registrados
                4) lista de autores vivos en determinado anio
                5) lista de libros por idioma
                0) salir
                =============================================
                selecione una de las opciones""";
    }

    public void buscarLibroPorTitulo(){
        System.out.println("Ingrese el titulo del libro que desea buscar");

        String tituloIngresado= teclado.nextLine();
        String resultadosAPI = consumoAPI
                .peticionHTTP(URL_BASE+"?search="+tituloIngresado.replace(" ","+"));

        Datos datosPorTitulo=conversor.obtenerDatos(resultadosAPI,Datos.class);
        //System.out.println(resultadosAPI);
        Optional<LibroDatos> libroEncontrado = datosPorTitulo.resultados().stream()
                .filter(libro -> libro.titulo().toUpperCase().contains(tituloIngresado.toUpperCase()))
                .findFirst();
        if (libroEncontrado.isPresent()){
            try {
                Libro libro=new Libro(libroEncontrado.get());
                System.out.println(libro);
                repositorio.save(libro);
            }catch (DataIntegrityViolationException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void listaLibrosRegistrados() {
        List<Libro> libros =repositorio.findAll();
        System.out.println("============== Libros Registrados ==============");
        libros.forEach(l-> System.out.println(l.getTitulo()));
    }

    private void listaDeAutoresRegistrados() {
        System.out.println("Ingrese el titulo del libro que desea buscar");

        List<Libro> libros =repositorio.findAll();
        System.out.println("============== Autores Registrados ==============");
        libros.forEach(l-> l.getAutores().forEach(a->
                System.out.printf(
                        "Autor: "+a.getNombre()+" fecha de nacimiento: "+a.getFechaNasimiento()+" fecha de muerte :"+a.getFechaMuerte()+"\n")));
    }
    private void listaDeAutoresVivosEnDeterminadoAnio() {
        System.out.println("ingrese el anio en el que el autor vivio, del libro que busca");
        int anio=Seleccionar.anio();
        List<Autor>autoresVivos=repositorio.autoresVivosEnDeterminadoAnio(anio);
        System.out.printf("============== Autores vivos en anio: %d ==============%n",anio);
        autoresVivos.forEach(autor ->
                System.out.println("Autor: "+autor.getNombre()));
    }
    private void listaDeLibrosPorIdioma() {
        try {
            System.out.println("Escriba el lenguaje que del libro que desea buscar");
            var lenguaje=teclado.nextLine();
            Lenguaje lenguje= Lenguaje.fromEspaniol(lenguaje);
            List<Libro> librosPorLenguaje=repositorio.findByLenguaje(lenguje);
            int cantLibros=librosPorLenguaje.size();
            System.out.printf("============== Libros por idioma | cantidad: %d ==============\n\n",cantLibros);
            librosPorLenguaje.forEach(l->
                    System.out.println("Libro: "+l.getTitulo()+"Idioma :"+l.getLenguaje()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
