package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import zad1.CipherGenerator;
import zad1.Result;
import zad1.Wrapper;

public class Controller {

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    private Button btnGenerateRandom;

    @FXML
    private Button btnRandomSubset;

    @FXML
    private Button btnQuit;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private void displayAlert(String title, int size, String content){
        alert.setTitle(title);
        alert.setHeaderText(
                String.format("Count distinct characters out of %d", size));
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void btnGenerateRandomOnAction(ActionEvent event) {
        try {
            CipherGenerator cipher = new CipherGenerator();
            int size = Integer.parseInt(txtSize.getText());
            int seed = Integer.parseInt(txtSeed.getText());

            Result result =
                    cipher.countDistinct(
                            new Wrapper(size).makeFixedSelection(), seed);

            displayAlert(btnGenerateRandom.getText(), size, result.toString());
        } catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error message");
            error.setHeaderText("Wrong number format");
            error.setContentText("Provide integer number");
            error.showAndWait();
        }
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        System.exit(0);
        //Platform.exit();
    }

    @FXML
    void btnRandomSubsetOnAction(ActionEvent event) {
        try{
            CipherGenerator cipher = new CipherGenerator();
            int size = Integer.parseInt(txtSize.getText());
            int seed = Integer.parseInt(txtSeed.getText());

            Result result =
                cipher.countDistinct(
                        new Wrapper(size).makeFixedRandom(), seed);

            displayAlert(btnRandomSubset.getText(), size, result.toString());
        } catch (NumberFormatException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error message");
            error.setHeaderText("Wrong number format");
            error.setContentText("Provide integer number");
            error.showAndWait();
        }
    }

}
