package com.alura.literatura.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;
    private String fechaNasimiento;
    private String fechaMuerte;
    @ManyToOne
    private Libro libro;

    public Autor(){}
    public Autor(AutorDatos autorDatos) {
        this.nombre = autorDatos.nombre();
        this.fechaNasimiento = autorDatos.fechaNasimiento();
        this.fechaMuerte = autorDatos.fechaMuerte();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNasimiento() {
        return fechaNasimiento;
    }

    public void setFechaNasimiento(String fechaNasimiento) {
        this.fechaNasimiento = fechaNasimiento;
    }

    public String getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(String fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", fechaNasimiento='" + fechaNasimiento + '\'' +
                ", fechaMuerte='" + fechaMuerte + '\'' ;
    }
}
