package ma.emsi.projet.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty profession;
    private final StringProperty address;
    private final IntegerProperty psotalCode;
    private final ObjectProperty<LocalDate> birthday;

    public Person() {
//        2002-02-01
        firstName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        profession = new SimpleStringProperty();
        address = new SimpleStringProperty();
        psotalCode = new SimpleIntegerProperty();
        birthday = new SimpleObjectProperty<>();
    }


    public StringProperty firstNameProperty() {
        return firstName;
    }


    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getProfession() {
        return profession.get();
    }

    public StringProperty professionProperty() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession.set(profession);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public int getPsotalCode() {
        return psotalCode.get();
    }

    public IntegerProperty psotalCodeProperty() {
        return psotalCode;
    }

    public void setPsotalCode(int psotalCode) {
        this.psotalCode.set(psotalCode);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public Person(String firstName, String lastName, String profession, String address, Integer postalCode, LocalDate birthday) {
        this.firstName = new SimpleStringProperty(firstName) ;
        this.lastName =new SimpleStringProperty(lastName);
        this.profession = new SimpleStringProperty(profession);
        this.address = new SimpleStringProperty(address);
        this.psotalCode = new SimpleIntegerProperty(postalCode);
        this.birthday =  new SimpleObjectProperty<>(birthday) ;
    }

//    public Person(String firstName, String lastName, String profession, String address, Integer psotalCode, ObjectProperty<LocalDate> birthday) {
//        this.firstName = new SimpleStringProperty(firstName) ;
//        this.lastName = new SimpleStringProperty(lastName);
//        this.profession = new SimpleStringProperty(profession);
//        this.address = new SimpleStringProperty(address);
//        this.psotalCode = new SimpleIntegerProperty(psotalCode);
//        this.birthday = birthday;
//    }
}
