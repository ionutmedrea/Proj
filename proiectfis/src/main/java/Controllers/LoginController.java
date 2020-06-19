package Controllers;

import Exceptions.UsernameOrPasswordIncorrect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static Services.UserService.*;


public class LoginController implements Initializable {

    private Scene secondScene;
    @FXML
    private Text loginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox<String> role;

    @FXML @Override
    public void initialize(URL location, ResourceBundle resources) {
        role.getItems().addAll("Client", "Admin");
    }
    private boolean isActive=false;
    private boolean isAdmin=false;
    @FXML
    public void handleLoginAction(ActionEvent event) {
        try {
            if(verifyLogin(usernameField.getText(), encodePassword(usernameField.getText(),passwordField.getText()), role.getValue())) {
                loginMessage.setText("Login successfully!");
                isActive=true;
                if(isAdmin(role.getValue()))
                    isAdmin = true;
            }
            else throw new UsernameOrPasswordIncorrect();
        } catch (UsernameOrPasswordIncorrect e) {
            loginMessage.setText(e.getMessage());
        }
    }
    public void changeScreenButtonPushed() throws IOException {
        if(isActive && !isAdmin) {
            Parent search = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("search.fxml")));
            Scene newScene = new Scene(search);
            Stage window = new Stage();
            window.setScene(newScene);
            window.show();
        }
        if(isActive && isAdmin) {
            Parent search = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("searchAdmin.fxml")));
            Scene newScene = new Scene(search);
            Stage window = new Stage();
            window.setScene(newScene);
            window.show();
        }
    }

}
