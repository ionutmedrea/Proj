package Controllers;

import Exceptions.ReviewAlreadyExistsException;
import Model.ReviewItem;
import Services.ReviewService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ReviewController extends ReviewService{

    @FXML private TextField revNameTextField;
    @FXML private ListView<ReviewItem> reviewListView;
    @FXML private TextField nameTextField;
    @FXML private TextField priceTextField;
    @FXML private TextField grdTextField;
    @FXML private TextField reviewTextField;
    @FXML private Text addMessage;
    @FXML private Text addReviewMessage;
    @FXML private Text deleteMessage;

    private ObservableList<ReviewItem> reviewList = FXCollections.observableArrayList(ReviewService.reviews);

    public ReviewController() {
    }
    @FXML
    public void initialize(){
        reviewList = FXCollections.observableArrayList();
        adauga();
        reviewListView.setItems(reviewList);
    }
    @FXML
    public void handleAddReviewAction() {

        reviewList.add(new ReviewItem(revNameTextField.getText(), reviewTextField.getText()));
        try {
            ReviewService.addReview(revNameTextField.getText(), reviewTextField.getText());
            addReviewMessage.setText("Review added successfully!");
        } catch ( ReviewAlreadyExistsException e) {
            addReviewMessage.setText(e.getMessage());
        }
    }
    private void adauga() {
        reviewList.addAll(reviews);
    }

    public void handleSearchReviewAction(){
        for(ReviewItem current: reviews){
            if(!current.getName().equals(revNameTextField.getText()) ){
                reviewList.remove(current);
                reviewListView.getItems().remove(current);
            }
        }
    }

    @FXML
    public void changeToSearch() throws IOException {
        Parent search = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("search.fxml")));
        Scene newScene = new Scene(search);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();

    }
}