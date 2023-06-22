package com.valantic.sti.tutorial;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    public void setUser(final User user) {
        firstNameTextField.textProperty().bindBidirectional(user.getFirstNameProperty());
        lastNameTextField.textProperty().bindBidirectional(user.getLastNameProperty());
        emailTextField.textProperty().bindBidirectional(user.getEmailProperty());
    }
}
