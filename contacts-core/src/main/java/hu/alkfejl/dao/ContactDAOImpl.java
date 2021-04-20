package hu.alkfejl.dao;

import hu.alkfejl.model.Contact;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ContactDAOImpl implements ContactDAO {

    private static final String SELECT_ALL_CONTACTS = "SELECT * FROM CONTACT";
    Properties props = new Properties();
    private static String connectionURL;

    public ContactDAOImpl(){
        try {
            props.load(getClass().getResourceAsStream("/application.properties"));
            connectionURL = props.getProperty("db.ural");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> findall() {

        List<Contact> result = new ArrayList<>();

        // jdbc: egységes absztrakció adatbázisműveletek lebonyolítására, ezért a konkrét megvalósításkor
        // adni kell neki egy drivert majd

        //try with resources - a resources blokkba olyan dlgok mehetnek, amelyek implemetálják az
        // Autocloseable interfészt
        try (Connection c = DriverManager.getConnection(connectionURL);
             Statement statement = c.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_CONTACTS);
        ){

            while (resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setEmail(resultSet.getString("email"));
                contact.setAddress(resultSet.getString("address"));

                Date date = Date.valueOf(resultSet.getString("dateOfBirth"));
                if(date == null) contact.setDateOfBirth(LocalDate.now());
                else contact.setDateOfBirth(date.toLocalDate());

                contact.setCompany(resultSet.getString("company"));
                contact.setPosition(resultSet.getString("position"));

                result.add(contact);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    @Override
    public Contact save(Contact contact) {
        return null;
    }

    @Override
    public void delete(Contact contact) {

    }
}
