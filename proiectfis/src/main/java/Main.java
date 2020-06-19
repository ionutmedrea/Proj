import Services.ComponentService;
import Services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

/*
 @Override
 public void start(Stage primaryStage) throws Exception {
     UserService.loadUsersFromFile();
     ComponentService.loadCompsFromFile();

     Parent login = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
     //Parent search = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("search.fxml")));
     primaryStage.setTitle("Componente PC");
     primaryStage.setScene(new Scene(login, 1200, 375));
     primaryStage.setMinHeight(400);
     primaryStage.setMinWidth(600);
     primaryStage.show();
 }

 */
    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.loadUsersFromFile();
        ComponentService.loadCompsFromFile();
        start1(primaryStage, "login.fxml");
    }
    public void start1(Stage primaryStage, String screen) throws Exception {

        Parent a = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource(screen)));
        primaryStage.setTitle("Componente PC");
        primaryStage.setScene(new Scene(a, 1200, 375));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
