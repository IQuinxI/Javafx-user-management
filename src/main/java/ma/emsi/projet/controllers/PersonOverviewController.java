package ma.emsi.projet.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ma.emsi.projet.MainApp;
import ma.emsi.projet.misc.DateUtil;
import ma.emsi.projet.models.Person;

import java.io.IOException;


public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label professionLabel;

    @FXML
    private Label codePostalLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label birthdayLabel;

    private MainApp mainApp;

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        showPersnalDetailsLY(null);

        personTable.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->showPersnalDetailsLY(newValue));
    }

    public void initLY(MainApp mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }

    private void showPersnalDetailsLY(Person person) {
        if(person != null) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            professionLabel.setText(person.getProfession());
            codePostalLabel.setText(String.valueOf(person.getPsotalCode()));
            addressLabel.setText(person.getAddress());
            birthdayLabel.setText(DateUtil.formatLY(person.getBirthday()));
        }else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            professionLabel.setText("");
            codePostalLabel.setText("");
            addressLabel.setText("");
            birthdayLabel.setText("");

        }
    }

    @FXML
    protected void deleteOnClick() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex != -1) personTable.getItems().remove(selectedIndex);
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING );

            alert.setTitle("No selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a person in the table");

            alert.showAndWait();
        }
    }



    @FXML
    protected void addNewPersonOnCLick() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        // TODO: FIX THIS
        if(true) {
            System.out.println("entered");
            mainApp.getPersonData().add(tempPerson);
        }else {
            System.out.println("not cliked");
        }
    }

    @FXML
    protected void editPersonOnClick() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if(selectedPerson != null)   {
            boolean okCliked = mainApp.showPersonEditDialog(selectedPerson);
            if(okCliked)
                showPersnalDetailsLY(selectedPerson);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText(null);
            alert.setContentText("A person should be selected to continue");

            alert.showAndWait();
        }
    }

}
