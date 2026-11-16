package Control;

import java.util.HashMap;
import java.util.Map;

public class Numero_token {
    private static final Map<Integer, String> tabla = new HashMap<>();

    static {
        // reservadas
        tabla.put(1, "abstract");
        tabla.put(2, "boolean");
        tabla.put(3, "break");
        tabla.put(4, "byte");
        tabla.put(5, "byvalue");
        tabla.put(6, "case");
        tabla.put(7, "cast");
        tabla.put(8, "catch");
        tabla.put(9, "char");
        tabla.put(10, "class");
        tabla.put(11, "const");
        tabla.put(12, "continue");
        tabla.put(13, "default");
        tabla.put(14, "do");
        tabla.put(15, "double");
        tabla.put(16, "else");
        tabla.put(17, "extends");
        tabla.put(18, "final");
        tabla.put(19, "finally");
        tabla.put(20, "float");
        tabla.put(21, "for");
        tabla.put(22, "future");
        tabla.put(23, "generic");
        tabla.put(24, "goto");
        tabla.put(25, "if");
        tabla.put(26, "implements");
        tabla.put(27, "import");
        tabla.put(28, "inner");
        tabla.put(29, "instanceof");
        tabla.put(30, "int");
        tabla.put(31, "interface");
        tabla.put(32, "long");
        tabla.put(33, "native");
        tabla.put(34, "new");
        tabla.put(35, "null");
        tabla.put(36, "operator");
        tabla.put(37, "outer");
        tabla.put(38, "package");
        tabla.put(39, "private");
        tabla.put(40, "protected");
        tabla.put(41, "public");
        tabla.put(42, "rest");
        tabla.put(43, "return");
        tabla.put(44, "short");
        tabla.put(45, "static");
        tabla.put(46, "super");
        tabla.put(47, "switch");
        tabla.put(48, "synchronized");
        tabla.put(49, "this");
        tabla.put(50, "threadsafe");
        tabla.put(51, "throw");
        tabla.put(52, "transient");
        tabla.put(53, "try");
        tabla.put(54, "var");
        tabla.put(55, "void");
        tabla.put(56, "while");

        // id
        tabla.put(57, "id");

        // literales
        tabla.put(58, "int (numero entero)");
        tabla.put(59, "long (numero entero largo)");
        tabla.put(60, "double (numero real)");
        tabla.put(61, "float (numero real flotante)");
        tabla.put(62, "boolean (valor booleano)");
        tabla.put(63, "char (caracter)");
        tabla.put(64, "cadenas (string)");

        // operadores
        tabla.put(65, "++");
        tabla.put(66, "--");
        tabla.put(67, "!");
        tabla.put(68, "*");
        tabla.put(69, "/");
        tabla.put(70, "%");
        tabla.put(71, "+");
        tabla.put(72, "-");
        tabla.put(73, "<");
        tabla.put(74, ">");
        tabla.put(75, "<=");
        tabla.put(76, ">=");
        tabla.put(77, "==");
        tabla.put(78, "!=");
        tabla.put(79, "&&");
        tabla.put(80, "||");
        tabla.put(81, "?");
        tabla.put(82, "=");

        // delimitador
        tabla.put(83, "(");
        tabla.put(84, ")");
        tabla.put(85, "{");
        tabla.put(86, "}");
        tabla.put(87, "[");
        tabla.put(88, "]");
        tabla.put(89, ";");
        tabla.put(90, ",");
        tabla.put(91, ".");

        // comentarios
        tabla.put(92, "//");
        tabla.put(93, "/*");
        tabla.put(94, "/**");
    }

    public static int obtenerID(String lexema){
        for (Map.Entry<Integer, String> entry : tabla.entrySet()){
            if(entry.getValue().equals(lexema)){
                return entry.getKey();
            }
        }
        return -1;
    }
}
