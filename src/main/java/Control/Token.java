package Control;

public class Token {
    private String palabra;
    private String tipo;
    private int numeroToken;

    public Token (String palabra, String tipo, int numeroToken){
        this.palabra = palabra;
        this.tipo = tipo;
        this.numeroToken = numeroToken;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumeroToken() {return numeroToken;}
}
