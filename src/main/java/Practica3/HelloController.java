package Practica3;

import Control.Analizador;
import Control.ControlPilas;
import Control.Token;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class HelloController {

    public Button btnAnalizar;
    @FXML
    private TextField txtEntrada;
    @FXML
    private TableView<Token> tablaTokens;
    @FXML
    private TableColumn<Token, String> columnaLexema;
    @FXML
    private TableColumn<Token, String> columnaTipo;
    @FXML
    private Label lblTotalTokens;
    @FXML
    private ListView<String> listaReservadas;
    @FXML
    private ListView<String> listaIdentificadores;
    @FXML
    private ListView<String> listaLiterales;
    @FXML
    private ListView<String> listaOperadores;
    @FXML
    private ListView<String> listaDelimitadores;
    @FXML
    private ListView<String> listaComentarios;
    @FXML
    private TableColumn<Token, Integer> columnaNumero;

    private final Analizador analizador = new Analizador();

    @FXML
    public void initialize() {

        columnaLexema.setCellValueFactory(new PropertyValueFactory<>("palabra"));
        columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnaNumero.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getNumeroToken()).asObject()
        );
    }

    private void llenarPila (Stack<String> pila, ListView<String> listaVisual){
        //pasamos la pila a lista
        List<String> elementos = new ArrayList<>(pila);
        //invertimos
        Collections.reverse(elementos);

        //mostramsop
        listaVisual.setItems(FXCollections.observableArrayList(elementos));
    }

    @FXML
    protected void analizarCodigo() {
        String instruccion = txtEntrada.getText();

        if (instruccion == null || instruccion.trim().isEmpty()) {
            return;
        }

        //analisis general
        List<Token> resultados = analizador.analizar(instruccion);
        ObservableList<Token> datosTabla = FXCollections.observableArrayList(resultados);
        tablaTokens.setItems(datosTabla);
        lblTotalTokens.setText("Total Tokens: " + resultados.size());

        //pilas
        ControlPilas pilas = analizador.getPilas();

        llenarPila(pilas.pilaReservadas, listaReservadas);
        llenarPila(pilas.pilaIdentificadores, listaIdentificadores);
        llenarPila(pilas.pilaLiterales, listaLiterales);
        llenarPila(pilas.pilaOperadores, listaOperadores);
        llenarPila(pilas.pilaDelimitadores, listaDelimitadores);
        llenarPila(pilas.pilaComentarios, listaComentarios);

    }
}