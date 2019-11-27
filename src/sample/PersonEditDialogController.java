package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonEditDialogController extends TableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button orderHistoryButton;

    @FXML
    private Button backButton;

    @FXML
    private Button createNewOrderButton;

    @FXML
    private Button currentOrderButton;

    @FXML
    private TextArea currentClientField;

    @FXML
    void initialize() {
        currentClientField.setText(client);

        backButton.setOnAction(event -> {
            openNewScene(backButton, "/sample/view/sample.fxml");
        });

        createNewOrderButton.setOnAction(event -> {
            openNewScene(createNewOrderButton, "/sample/view/createOrderFrame.fxml");
        });
        currentOrderButton.setOnAction(event -> {
            searchOrder(Const.ORDERS_TABLE);
        });
        orderHistoryButton.setOnAction(event -> {
            searchOrder(Const.ORDERS_HISTORY_TABLE);
        });

        orderTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    orderTableView.getSelectionModel().getSelectedItem();
                    id = orderTableView.getSelectionModel().getSelectedItem().getOrderId();
                    openNewScene(orderTableView, "/sample/view/currentOrderDetails.fxml");
                }
            }

        });
    }
}


