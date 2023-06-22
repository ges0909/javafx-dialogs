package com.valantic.sti.tutorial;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private StringProperty firstNameProperty;
    private StringProperty lastNameProperty;
    private StringProperty emailProperty;

    public User(final String firstName, final String lastName, final String email) {
        firstNameProperty = new SimpleStringProperty(firstName);
        lastNameProperty = new SimpleStringProperty(lastName);
        emailProperty = new SimpleStringProperty(email);
    }
}
