package com.alura.literatura.modelo;

public enum Lenguaje {
    INGLES("en","Ingles"),
    ESPANIOL("es","Español"),
    FRANCES("fr","Frances"),
    TAGALO("tl","Tagalo"),
    PORTUGUEZ("pt", "Portuguez");
//se da a entender que lenguajes podira ser cualquiera de las constantes
    private String lenguaje;

    private String idiomaPais;

    Lenguaje(String lenguaje, String categoriaEspaniol){
        this.lenguaje=lenguaje;
        this.idiomaPais =categoriaEspaniol;
    }

    public static Lenguaje fromArrayString(String text){
        //recorro las contantes del enum
        for (Lenguaje leng : Lenguaje.values()) {
            if (leng.lenguaje.equalsIgnoreCase(text)){
                return leng;
            }
        }
        throw new IllegalArgumentException("ningun lenguaje fuen encontrado:"+text);
    }
        public static Lenguaje fromEspaniol(String text){
            //recorro las contantes del enum
            for (Lenguaje leng : Lenguaje.values()) {
                if (leng.idiomaPais.equalsIgnoreCase(text)){
                    return leng;
                }
            }
            throw new IllegalArgumentException("ningun lenguaje fuen encontrado:"+text);
        }

}
