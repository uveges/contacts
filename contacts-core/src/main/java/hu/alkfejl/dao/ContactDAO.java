package hu.alkfejl.dao;

import hu.alkfejl.model.Contact;

import java.util.List;

public interface ContactDAO {

    //Mivel webes környezetben nem is tudjuk, mi az az ObservableList, ezért simát használunk
    List<Contact> findall();
    Contact save(Contact contact);
    void delete(Contact contact);

}
