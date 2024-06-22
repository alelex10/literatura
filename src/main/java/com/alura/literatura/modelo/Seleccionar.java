package com.alura.literatura.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface Seleccionar {
    Scanner teclado = new Scanner(System.in);
    static int opcion(){
        ArrayList<Integer> opcionesValidas=new ArrayList<>(Arrays.asList(1,2,3,4,5,0));
        int opcionSeleccionada=-1;
        try {
            opcionSeleccionada=teclado.nextInt();
            while(!opcionesValidas.contains(opcionSeleccionada)){
                teclado.nextLine();
                System.out.println("seleccione una opcion valida");
                opcionSeleccionada=teclado.nextInt();
            }
            return opcionSeleccionada;
        }catch (InputMismatchException e){
            //la excepcion ocurre en la linea 17 y no avanza a la linea 18 por lo que
            teclado.next();//la excepcion se queda en el buffer
            System.out.println("ingrese un numero valido");
            return Seleccionar.opcion();
        }
    }
    static int anio(){
        int opcionSeleccionada=-1;
        try {
            opcionSeleccionada=teclado.nextInt();
            while(opcionSeleccionada<0 || opcionSeleccionada>2024){
                teclado.nextLine();
                System.out.println("seleccione una anio valido");
                opcionSeleccionada=teclado.nextInt();
            }
            return opcionSeleccionada;
        }catch (InputMismatchException e){
            teclado.next();
            System.out.println("ingrese un numero valido");
            return Seleccionar.opcion();
        }
    }
}
