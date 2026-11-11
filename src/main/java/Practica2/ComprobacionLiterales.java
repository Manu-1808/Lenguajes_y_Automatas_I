package Practica2;

import Control.Validador;

import javax.swing.*;

public class ComprobacionLiterales {
    public static void main (String[] args){
        Validador validarLiteral = new Validador();

        int opcion;
        String cadena;
        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion de literal a validar: \n" +
                    "1. Identificador (ID)\n" +
                    "2. Int\n" +
                    "3. Long\n" +
                    "4. Float\n" +
                    "5. Double\n" +
                    "6. Char\n" +
                    "7. String\n" +
                    "8. Boolean\n" +
                    "0. Salir\n"));
            switch (opcion){
                case 1:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esIdentificador(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un identificador (ID)",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un identificador (ID)",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esInt(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un Int",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un Int",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esLong(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un Long",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un Long)",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 4:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esFloat(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un Float",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un Float",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 5:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esDouble(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un Double",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un Double",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 6:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esChar(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un Char",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un Char",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 7:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esString(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un String",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un String)",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 8:
                    cadena = JOptionPane.showInputDialog("Ingrese la cadena a validar");
                    if (validarLiteral.esBoolean(cadena)){
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' SI es un Boolean",
                                "Validación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El literal '"+ cadena + "' NO es un Boolean",
                                "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        } while (opcion != 0);
    }
}
