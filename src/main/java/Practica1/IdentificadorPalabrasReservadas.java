package Practica1;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class IdentificadorPalabrasReservadas {
    public static void main (String[] args) {

        Map<String, Integer> tokens = new HashMap<>();
        tokens.put("abstract", 1);
        tokens.put("boolean", 2);
        tokens.put("break", 3);
        tokens.put("byte", 4);
        tokens.put("byvalue", 5);
        tokens.put("case", 6);
        tokens.put("cast", 7);
        tokens.put("catch", 8);
        tokens.put("char", 9);
        tokens.put("class", 10);
        tokens.put("const", 11);
        tokens.put("continue", 12);
        tokens.put("default", 13);
        tokens.put("do", 14);
        tokens.put("double", 15);
        tokens.put("else", 16);
        tokens.put("extends", 17);
        tokens.put("final", 18);
        tokens.put("finally", 19);
        tokens.put("float", 20);
        tokens.put("for", 21);
        tokens.put("future", 22);
        tokens.put("generic", 23);
        tokens.put("goto", 24);
        tokens.put("if", 25);
        tokens.put("implements", 26);
        tokens.put("import", 27);
        tokens.put("inner", 28);
        tokens.put("instanceof", 29);
        tokens.put("int", 30);
        tokens.put("interface", 31);
        tokens.put("long", 32);
        tokens.put("native", 33);
        tokens.put("new", 34);
        tokens.put("null", 35);
        tokens.put("operator", 36);
        tokens.put("outer", 37);
        tokens.put("package", 38);
        tokens.put("private", 39);
        tokens.put("protected", 40);
        tokens.put("public", 41);
        tokens.put("rest", 42);
        tokens.put("return", 43);
        tokens.put("short", 44);
        tokens.put("static", 45);
        tokens.put("super", 46);
        tokens.put("switch", 47);
        tokens.put("synchronized", 48);
        tokens.put("this", 49);
        tokens.put("threadsafe", 50);
        tokens.put("throw", 51);
        tokens.put("transient", 52);
        tokens.put("try", 53);
        tokens.put("var", 54);
        tokens.put("void", 55);
        tokens.put("while", 56);

        String palabra;
        do {
            palabra = JOptionPane.showInputDialog("Ingrese la palabra a buscar o pulse 0 para salir: ");
            if (!palabra.equals("0")) {
                Integer numero = tokens.get(palabra.toLowerCase());
                if (numero != null) {
                    JOptionPane.showMessageDialog(null, "El identificador de " + palabra + " es: " + numero);
                } else {
                    JOptionPane.showMessageDialog(null, "Palabra no encontrada");
                }
            }
        } while (!palabra.equals("0"));
    }
}

