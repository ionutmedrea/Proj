package Controllers;

import Exceptions.UsernameAlreadyExistsException;
import Exceptions.UsernameOrPasswordIncorrect;
import Services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static Services.UserService.verifyLogin;


public class LoginController {

    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox<String> role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }

    @FXML
    public void handleLoginAction() {
        if(verifyLogin(usernameField.getText(),passwordField.getText(), role.getValue()))
            loginMessage.setText("Login successfully!");
    }
}
