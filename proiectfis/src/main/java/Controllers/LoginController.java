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
import java.util.ResourceBundle;

import static Services.UserService.encodePassword;
import static Services.UserService.verifyLogin;


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
    private boolean isActive;
    @FXML
    public void handleLoginAction(ActionEvent event) throws Exception {
        try {
            if(verifyLogin(usernameField.getText(), encodePassword(usernameField.getText(),passwordField.getText()), role.getValue())) {
                loginMessage.setText("Login successfully!");
                isActive=true;
            }
            else throw new UsernameOrPasswordIncorrect();
        } catch (UsernameOrPasswordIncorrect e) {
            loginMessage.setText(e.getMessage());
        }
    }
    public void changeScreenButtonPushed() throws IOException {
        if(isActive) {
            Parent search = FXMLLoader.load(getClass().getClassLoader().getResource("search.fxml"));
            Scene newScene = new Scene(search);
            Stage window = new Stage();
            window.setScene(newScene);
            window.show();
        }
    }

}
