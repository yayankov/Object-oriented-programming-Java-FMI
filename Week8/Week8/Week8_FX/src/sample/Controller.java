package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    private static Alert messageBox;

    @FXML
    private Button btnReadName;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField txtNameinput;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnReadNameOnAction(ActionEvent event) {
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        String input = txtNameinput.getText();
        input = input.equals("")? "Unknown person" : input;
        String output = String.format("Hello, %s!", input);

        messageBox.setTitle("Greeting");
        messageBox.setContentText(output);
        messageBox.showAndWait();
    }

}
