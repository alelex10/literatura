package com.alura.literatura.modelo;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)//es para que no se repita el dato
    private String titulo;
    private String copyright;
    private Integer cantidadDescargas;
    @Enumerated(EnumType.STRING)
    private Lenguaje lenguaje;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@Transient
    private List<Autor> autores;

    public Libro(){}

    public Libro(LibroDatos libroDatos) {
        this.titulo = libroDatos.titulo();
        this.cantidadDescargas = libroDatos.cantidadDescargas();
        this.copyright = libroDatos.copyright();
        try {
            this.lenguaje = Lenguaje.fromArrayString(libroDatos.lenguajes().get(0));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        this.autores=libroDatos.autores().stream()
                .map(Autor::new)
                .collect(Collectors.toList());
        autores.forEach(autor -> autor.setLibro(this));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(Integer cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    public Long getId() {
        return id;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", lenguajes=" + lenguaje + '\'' +
                ", copyright='" + copyright + '\'' +
                ", cantidadDescargas=" + cantidadDescargas+ '\'' +
                ", autores=" + autores
                ;
    }
}
