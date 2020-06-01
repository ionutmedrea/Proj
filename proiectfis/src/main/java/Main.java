import Services.ComponentService;
import Services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

 /*   @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
        //Scene scene = new Scene(root);
        primaryStage.setTitle("Registration ");
        primaryStage.setScene(new Scene(root, 720, 380));
        primaryStage.show();

    }
  */
 @Override
 public void start(Stage primaryStage) throws Exception{
     UserService.loadUsersFromFile();
     ComponentService.loadCompsFromFile();

     Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("search.fxml")));
     primaryStage.setTitle("Componente PC");
     primaryStage.setScene(new Scene(root, 1200, 375));
     primaryStage.setMinHeight(400);
     primaryStage.setMinWidth(600);
     primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
