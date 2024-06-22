# literatura
 
 ![GRÁFICA](https://img.freepik.com/foto-gratis/abundante-coleccion-libros-antiguos-estantes-madera-generados-ia_188544-29660.jpg?w=1380&t=st=1719036812~exp=1719037412~hmac=e6741c814116b52df5df22730c4d683066e63c1c10e3f8d4b114d21d02e026ce)
 
# Literalura - Challenge Backend Alura

La aplicación te permite escoger entre alguna variedad de opciones en las cuales podras recurrir a la API de [Gutendex](https://gutendex.com/) para poder agregar un libro a tu base de datos y luego verificar los libros ingresados segun autor, idioma, entre otras opciones.

## Requisitos 

Para este proyecto se utilizaron las siguientes tecnologías:
- **Java JDK:** versión 17 o superior
- **Maven:** versión 4 o superior, para la gestión de dependencias y construcción del proyecto.
- **Spring Boot:** versión 3.3.0
- **PostgreSQL:** versión 14.12 o superior, como base de datos relacional.
- **IDE:** IntelliJ IDEA, para el desarrollo integrado del proyecto.

## Características 

- **Buscar Libro:** Permite buscar libros utilizando la API de Gutendex y guarda el primer resultado encontrado en la base de datos.
- **Listar Libros:** Permite imprimir por consola todos los libros guardados en la base de datos.
- **Listar Autores:** Imprime por consola todos los autores guardados en la base de datos.
- **Listar Autores por Año:** Imprime por consola los autores vivos en el año especificado.
- **Listar Libros por Idioma:** Filtra los libros según el idioma especificado y los muestra por consola.

## Dependencias
- **Spring Data JPA:** para la integración con la capa de persistencia.
- **Postgres Driver:** para la conexión con la base de datos PostgreSQL.
- **Jackson:** para el manejo de JSON.
