package Control;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
    private static final Set<String> RESERVADAS = Set.of(
            "abstract", "boolean", "break", "byte", "byvalue", "case", "cast",
            "catch", "char", "class", "const", "continue", "default", "do",
            "double", "else", "extends", "final", "finally", "float", "for",
            "future", "generic", "goto", "if", "implements", "import", "inner",
            "instanceof", "int", "interface", "long", "native", "new", "null",
            "operator", "outer", "package", "private", "protected", "public",
            "rest", "return", "short", "static", "super", "switch",
            "synchronized", "this", "threadsafe", "throw", "transient", "try",
            "var", "void", "while", "true", "false"
    );

    public static final Set<Character> DELIMITADORES = Set.of(
            '{', '}', '[', ']', '(', ')', ';', ',', '.'
    );

    public static final Set<String> OPERADORES = Set.of(
            "+", "-", "*", "/", "%",

            "=", "+=", "-=", "*=", "/=", "%=",

            "==", "!=", ">", "<", ">=", "<=",

            "&&", "||", "!",

            "++", "--",

            "?", ":",

            "&", "|", "^", "~", "<<", ">>", ">>>",
            "<<=", ">>=", ">>>=", "&=", "|=", "^="
    );


    public boolean esReservada(String palabra) {
        // regresa si la palabra ingresada esta en la lista de reszervadas
        return palabra != null && RESERVADAS.contains(palabra.toLowerCase());
    }

    public boolean esIdentificador(String cadena){
        //expresion regular
        Pattern patronId = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");

        //comparador
        Matcher comparador = patronId.matcher(cadena);

        //si la cadena coincide con la expresion regresamos true
        return comparador.matches();
    }

    public boolean esBoolean (String cadena){
        Pattern patronBoolean = Pattern.compile("(true|false)");

        Matcher comparador = patronBoolean.matcher(cadena);

        return comparador.matches();
    }

    public boolean esString (String cadena){
        Pattern patronCadena = Pattern.compile("^\"[^\"]*\"$");

        Matcher comparador = patronCadena.matcher(cadena);

        return comparador.matches();
    }

    public boolean esChar(String cadena){
        Pattern patronChar = Pattern.compile("^'[^']'$");

        Matcher comparador = patronChar.matcher(cadena);

        return comparador.matches();
    }

    public boolean esInt(String cadena){
        Pattern patronCadena = Pattern.compile("[+-]?[0-9]+");

        Matcher comparador = patronCadena.matcher(cadena);

        if (!comparador.matches()) {
            return false;
        }
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean esFloat (String cadena){
        Pattern patronFloat= Pattern.compile("-?[0-9]+\\.[0-9]+[fF]");

        Matcher mat = patronFloat.matcher(cadena);

        if(!mat.matches()) return false;

        try{
            String FloatSinF = cadena.substring(0, cadena.length() - 1);
            float valor = Float.parseFloat(FloatSinF);

            return Float.isFinite(valor);
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean esDouble (String cadena){
        Pattern patronDouble = Pattern.compile("-?[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?[dD]?");

        Matcher mat = patronDouble.matcher(cadena);

        if (!mat.matches()) return false;

        try {
            String sinD = cadena.replaceAll("[dD]$", "");
            double valor = Double.parseDouble(sinD);

            return !Double.isInfinite(valor);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean esLong(String cadena){
        Pattern patronCadena = Pattern.compile("[+-]?[0-9]+");

        Matcher comparador = patronCadena.matcher(cadena);

        if (!comparador.matches()) {
            return false;
        }

        try {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean esComentario (String cadena){
        Pattern patronComentario = Pattern.compile("^//.*$");

        Matcher comparador = patronComentario.matcher(cadena);

        return comparador.matches();
    }

    public boolean esDelimitador (char caracter){
        return DELIMITADORES.contains(caracter);
    }

    public boolean esOperador (String cadena){
        return OPERADORES.contains(cadena);
    }
}
