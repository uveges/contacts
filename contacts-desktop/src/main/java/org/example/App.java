package org.example;

import hu.alkfejl.dao.ContactDAO;
import hu.alkfejl.dao.ContactDAOImpl;
import hu.alkfejl.model.Contact;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        ContactDAO contactDAO = new ContactDAOImpl();
        for (Contact contact: contactDAO.findall()
             ) {
            System.out.println(contact);

        }


        var scene = new Scene(new StackPane(new Label("Teszt")), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}