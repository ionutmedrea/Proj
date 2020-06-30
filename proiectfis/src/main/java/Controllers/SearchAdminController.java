package Controllers;

import Exceptions.ComponentAlreadyExistsException;
import Model.Item;
import Services.ComponentService;
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


public class SearchAdminController extends ComponentService{


    @FXML private ListView<Item> itemListView;
    @FXML private TextField nameTextField;
    @FXML private TextField priceTextField;
    @FXML private TextField grdTextField;
    @FXML private Text addMessage;
    @FXML private Text deleteMessage;

    private ObservableList<Item> itemList = FXCollections.observableArrayList(ComponentService.items);

    public SearchAdminController() {
    }

    public void initialize(){
        itemList = FXCollections.observableArrayList();
        adauga();
        itemListView.setItems(itemList);
    }
    @FXML
    public void handleAddAction() {

        itemList.add(new Item(nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(grdTextField.getText())));
        try {
            ComponentService.addComp(nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(grdTextField.getText()));
            addMessage.setText("Item added successfully!");
        } catch (ComponentAlreadyExistsException e) {
            addMessage.setText(e.getMessage());
        }
    }
    private void adauga() {
        for (Item current : items) {
            itemList.add(current);
        }
    }

    @FXML
    public void handleDeleteButton() {
        {
            final int selectedIdx = itemListView.getSelectionModel().getSelectedIndex();
            if (selectedIdx != -1) {
                Item itemToRemove = itemListView.getSelectionModel().getSelectedItem();

                final int newSelectedIdx =
                        (selectedIdx == itemListView.getItems().size() - 1)
                                ? selectedIdx - 1
                                : selectedIdx;

                itemListView.getItems().remove(selectedIdx);
                itemListView.getSelectionModel().select(newSelectedIdx);

                itemList.remove(itemToRemove);
                items.remove(itemToRemove);
                persistAllComps(items);
            }
        }
    }
    @FXML
    public void changeToReviews() throws IOException {
        Parent search = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("review.fxml")));
        Scene newScene = new Scene(search);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();

    }
}