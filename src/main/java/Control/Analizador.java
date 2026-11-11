package Control;

import java.util.ArrayList;
import java.util.List;

public class Analizador {
    private final Validador val = new Validador();
    private ControlPilas pilas = new ControlPilas();

    public List<Token> analizar (String lineaCodigo){
        int i = 0;
        int longitud = lineaCodigo.length();
        String palabra;
        List<Token> tokens = new ArrayList<>();
        pilas = new ControlPilas();

        while (i < longitud) {
            char c = lineaCodigo.charAt(i);

            if (Character.isLetter(c) || c == '_'){
                int inicio = i;

                while (i < longitud && (Character.isLetterOrDigit(lineaCodigo.charAt(i)) || lineaCodigo.charAt(i)=='_')){
                    i++;
                }

                palabra = lineaCodigo.substring(inicio, i);

                if (val.esReservada(palabra)){
                    tokens.add(new Token (palabra, "Palabra Reservada"));
                    pilas.pilaReservadas.push(palabra);
                } else if (val.esIdentificador(palabra)){
                    tokens.add(new Token(palabra, "Identificador"));
                    pilas.pilaIdentificadores.push(palabra);
                } else {
                    tokens.add(new Token(palabra, "Error Lexico"));
                }
            }

            else if (Character.isDigit(c)){
                int inicio = i;

                while (i < longitud && (Character.isDigit(lineaCodigo.charAt(i)) || lineaCodigo.charAt(i) == '.' ||
                        lineaCodigo.charAt(i) == 'f' || lineaCodigo.charAt(i) == 'F' ||
                        lineaCodigo.charAt(i) == 'd' || lineaCodigo.charAt(i) == 'D' ||
                        lineaCodigo.charAt(i) == 'e' || lineaCodigo.charAt(i) == 'E')) {

                    i++;
                }

                palabra = lineaCodigo.substring(inicio, i);

                if (val.esInt(palabra) || val.esLong(palabra) || val.esFloat(palabra) || val.esDouble(palabra)){
                    tokens.add(new Token (palabra, "Literal"));
                    pilas.pilaLiterales.push(palabra);
                } else {
                    tokens.add(new Token(palabra, "Error Lexico"));
                }
            }

            else if (c == '"' || c == '\''){
                int inicio = i;
                i ++;

                while (i < longitud && lineaCodigo.charAt(i) != c){
                    i++;
                }

                if (i < longitud) {
                    i++;
                }
                palabra = lineaCodigo.substring(inicio, i);

                if (val.esString(palabra)){
                    tokens.add(new Token (palabra, "Literal String"));
                    pilas.pilaLiterales.push(palabra);
                } else if (val.esChar(palabra)){
                    tokens.add(new Token(palabra, "Literal Char"));
                    pilas.pilaLiterales.push(palabra);
                } else {
                    tokens.add(new Token(palabra, "Error Lexico"));
                }
            }

            else if (c == '/' && i + 1 < longitud && lineaCodigo.charAt(i + 1) == '/') {
                int inicio = i;
                while (i < longitud && lineaCodigo.charAt(i) != '\n') {
                    i++;
                }
                palabra = lineaCodigo.substring(inicio, i);
                tokens.add(new Token(palabra, "Comentario"));
                pilas.pilaComentarios.push(palabra);
            }

            else if (val.esDelimitador(c)){
                tokens.add(new Token(String.valueOf(c), "Delimitador"));
                pilas.pilaDelimitadores.push(String.valueOf(c));
                i++;
            }

            else if (val.esOperador(String.valueOf(c))) {
                String operador = String.valueOf(c);
                if (i + 1 < longitud && val.esOperador(operador + lineaCodigo.charAt(i + 1))) {
                    operador += lineaCodigo.charAt(i + 1);
                    i++;
                    if (i + 1 < longitud && val.esOperador(operador + lineaCodigo.charAt(i + 1))) {
                        operador += lineaCodigo.charAt(i + 1);
                        i++;
                    }
                }
                tokens.add(new Token(operador, "Operador"));
                pilas.pilaOperadores.push(operador);
                i++;
            }
            else {
                i++;
            }
        }

        return tokens;
    }

    public ControlPilas getPilas(){
        return this.pilas;
    }
}
