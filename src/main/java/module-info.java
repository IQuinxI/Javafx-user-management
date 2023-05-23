module ma.emsi.projet {
    requires javafx.controls;
    requires javafx.fxml;


    opens ma.emsi.projet to javafx.fxml;
    exports ma.emsi.projet;
    exports ma.emsi.projet.controllers;
    opens ma.emsi.projet.controllers to javafx.fxml;

}