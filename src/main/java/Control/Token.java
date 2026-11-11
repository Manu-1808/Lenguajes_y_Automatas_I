package Control;

public class Token {
    private String palabra;
    private String tipo;

    public Token (String palabra, String tipo){
        this.palabra = palabra;
        this.tipo = tipo;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getTipo() {
        return tipo;
    }
}
