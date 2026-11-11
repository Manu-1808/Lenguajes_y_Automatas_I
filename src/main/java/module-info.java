module principal.analisadorlexico {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens Control to javafx.base, javafx.fxml;

    opens Practica3 to javafx.fxml;
    exports Practica3;
}