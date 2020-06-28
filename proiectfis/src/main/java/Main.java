import Services.ComponentService;
import Services.ReviewService;
import Services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.loadUsersFromFile();
        ComponentService.loadCompsFromFile();
        ReviewService.loadReviewsFromFile();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("review.fxml")));
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
