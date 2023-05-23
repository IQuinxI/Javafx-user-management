package ma.emsi.projet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ma.emsi.projet.controllers.PersonEditDialogController;
import ma.emsi.projet.controllers.PersonOverviewController;
import ma.emsi.projet.models.Person;

import java.io.IOException;
import java.time.LocalDate;

public class MainApp extends Application {
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp() {
        personData.add(new Person("user1", "luser1", "profession", "address",1, LocalDate.now()));
        personData.add(new Person("user2", "luser2", "profession2", "address2",2, LocalDate.now()));
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 440);

        PersonOverviewController controller = fxmlLoader.getController();
        controller.initLY(this);

        stage.setTitle("Address App");
        stage.setScene(scene);
        stage.show();
    }



    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public boolean showPersonEditDialog(Person person)  {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PersonEditDialog.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Pop-Up Window");
            popupStage.setScene(new Scene(root));

            popupStage.show();

            PersonEditDialogController controller = loader.getController();
            controller.setPerson(person);
            return controller.isOkClicked();
        }catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        launch();
    }
}