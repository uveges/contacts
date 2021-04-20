package hu.alkfejl.model;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Contact {

    //ezek kellenek majd az adatbázisban. Property alapon akarunk dolgozni, ezért ezeket biztosítani
    //az asztali megoldásban, de hogy a webes is normálisan működhessen, kellenek rendes getter/setter -ek is.

    //Dependency-k közé:
    // <dependency>
    //            <groupId>org.openjfx</groupId>
    //            <artifactId>javafx-base</artifactId>
    //            <version>11</version>
    //        </dependency>

    // this - jelezzük, hogy konkrétan melyik osztályhoz tartzoik a property
    private StringProperty name = new SimpleStringProperty(this, "name");
    private StringProperty email = new SimpleStringProperty(this, "email");
    //lista telefonszámoknak: Objectproperty, ami referencikat fog tárolni egy Observable List formájában
    private ObjectProperty<ObservableList<Phone>> phones = new SimpleObjectProperty<>(this, "phones");

    //adatbázisból visszajövő egyedi ID -k
    private IntegerProperty id = new SimpleIntegerProperty(this, "id");

    private StringProperty address = new SimpleStringProperty(this, "address");

    //Datumhoz nincs külön saját peroperty, ezért objectproperty-be kerül bele
    //LocalDate, mert a Datepicker a JavaFx-ben localdate-et használ!
    private ObjectProperty<LocalDate> dateOfBirth = new SimpleObjectProperty<>(this, "dateOfBirth");
    private StringProperty company = new SimpleStringProperty(this, "company");
    private StringProperty position = new SimpleStringProperty(this, "position");


    //GEtter / setterek


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ObservableList<Phone> getPhones() {
        return phones.get();
    }

    public ObjectProperty<ObservableList<Phone>> phonesProperty() {
        return phones;
    }

    public void setPhones(ObservableList<Phone> phones) {
        this.phones.set(phones);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public String getCompany() {
        return company.get();
    }

    public StringProperty companyProperty() {
        return company;
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}
