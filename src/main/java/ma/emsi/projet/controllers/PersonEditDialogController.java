package ma.emsi.projet.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ma.emsi.projet.misc.DateUtil;
import ma.emsi.projet.models.Person;

public class PersonEditDialogController {
    @FXML
    private TextField lastName;

    @FXML
    private TextField firstName;

    @FXML
    private TextField birthDate;

    @FXML
    private TextField profession;

    @FXML
    private TextField address;

    @FXML
    private TextField postalCode;

    private boolean okClicked = false;

    private Person person = new Person();

    public void setPerson(Person person) {
        this.person = person;

        firstName.setText(person.getFirstName());
        lastName.setText(person.getLastName());
        profession.setText(person.getProfession());
        postalCode.setText(String.valueOf(person.getPsotalCode()));
        address.setText(person.getAddress());
        birthDate.setText(DateUtil.formatLY(person.getBirthday()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }


    private void close(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    @FXML
    protected void onOkClick(ActionEvent event) {
        if(isInputValid()) {
            System.out.println("fn:" + firstName.getText());
            person.setFirstName(firstName.getText());
            person.setLastName(lastName.getText());
            person.setAddress(address.getText());
            person.setPsotalCode(Integer.parseInt(postalCode.getText()));
            person.setProfession(profession.getText());
            person.setBirthday(DateUtil.parseLY(birthDate.getText()));
            if(okClicked) System.out.println("Changed");
            close(event);
        }
    }

    @FXML
    private void onCancelClick(ActionEvent event) {
        close(event);
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if(firstName.getText() == null ||firstName.getText().length() == 0)
            errorMessage += "No valid first name !\n";

        if(lastName.getText() == null || lastName.getText().length() == 0)
            errorMessage += "No valid last name !\n";

        if(profession.getText() == null || profession.getText().length() == 0)
            errorMessage += "No valid profession !\n";

        if(postalCode.getText() == null || postalCode.getText().length() == 0)
            errorMessage += "No valid postal code !\n";
        else {
            try{
                Integer.parseInt(postalCode.getText());
            }catch (NumberFormatException e){
                errorMessage += "No valid postal code (must be an integer)\n";
            }
        }
        if(address.getText() == null || address.getText().length() == 0)
            errorMessage += "No valid address!\n";

        if(birthDate.getText() == null || birthDate.getText().length() == 0)
            errorMessage += "No valid birth date!\n";
        else{
            if(!DateUtil.validDate(birthDate.getText()))
                errorMessage+= "No valid birthday. Use the format dd/MM/yyyy\n";
        }

        if(errorMessage.length() == 0) {
           return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText(null);
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }

    }

}
