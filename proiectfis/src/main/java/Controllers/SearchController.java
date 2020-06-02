package Controllers;
import Exceptions.ComponentAlreadyExistsException;
import Exceptions.UsernameAlreadyExistsException;
import Model.Item;
import Services.UserService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;

import Services.ComponentService;
import javafx.scene.text.Text;

import java.util.List;

public class SearchController extends ComponentService{


    @FXML private ListView<Item> itemListView;
    @FXML private Button addButton;
    @FXML private TextField nameTextField;
    @FXML private TextField priceTextField;
    @FXML private TextField grdTextField;
    @FXML private Text addMessage;

    private ObservableList<Item> itemList = FXCollections.observableArrayList(ComponentService.items);

    public void initialize(){
        itemList = FXCollections.observableArrayList();
        adauga();
        itemListView.setItems(itemList);
        //registerEventHandlers();
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
    public void adauga(){
        for(Item current:items){
            itemList.add(current);
        }
    }
/*
    private void registerEventHandlers() {
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                itemList.add(new Item(nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(grdTextField.getText())));
                try {
                    ComponentService.addComp(nameTextField.getText(), Integer.parseInt(priceTextField.getText()), Integer.parseInt(grdTextField.getText()));
                    addMessage.setText("Account created successfully!");
                } catch (ComponentAlreadyExistsException e) {
                    addMessage.setText(e.getMessage());
                }
            }
        });

        nameTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if( event.getCode() == KeyCode.ENTER ){
                    itemList.add(new Item(nameTextField.getText()));
                }
            }
        });

        quitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.SHORTCUT_DOWN));
        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }

        });
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N,KeyCombination.SHORTCUT_DOWN));
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                itemList.clear();
            }
        });

        removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Item item = itemListView.getSelectionModel().getSelectedItem();
                itemList.remove(item);
            }
        });
    }

 */
}