package Src;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class Controller_Conversor implements Initializable {

    @FXML
    private Label titulo;
    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private ChoiceBox<String> myChoicebox1;

    @FXML
    private ChoiceBox<String> myChoicebox2;

    @FXML
    private Button btn;
    @FXML
    private Label mylabel;

    @FXML
    private TextField mytxt;

    private String temperatura[] = { "Celsius", "Fahrenheit" };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        myChoicebox1.getItems().addAll(temperatura);
        myChoicebox2.getItems().addAll(temperatura);

    }

    public void Converter(ActionEvent event) {
        Alert errorAlert = new Alert(AlertType.ERROR);
        try {

            if (myChoicebox1.getValue() == null || myChoicebox2.getValue() == null) {

                errorAlert.setHeaderText("Informações inválidas");
                errorAlert.setContentText("Escolha as temperaturas que deseja fazer a conversão");
                errorAlert.showAndWait();
            } else {
                String medida1 = myChoicebox1.getValue();
                String medida2 = myChoicebox2.getValue();
                if ((medida1 == "Celsius" && medida2 == "Celsius")
                        || (medida1 == "Fahrenheit" && medida2 == "Fahrenheit")) {

                    errorAlert.setHeaderText("Informações inválidas");
                    errorAlert.setContentText("Escolha tipos de temperaturas diferentes para concluir a ação");
                    errorAlert.showAndWait();
                } else if (mytxt.getText().isEmpty()) {

                    errorAlert.setHeaderText("Informações inválidas");
                    errorAlert.setContentText("Prencha o campo corretamente para ver o resultado");
                    errorAlert.showAndWait();
                } else {
                    float temp = Float.parseFloat(mytxt.getText());
                    float tempfinal = 0;

                    if (medida1 == "Celsius") {
                        tempfinal = (float) 1.8 * temp + 32;
                        float resposta = (float) Math.round(tempfinal * 100) / 100;
                        mylabel.setText(resposta + " °F ");
                    } else {
                        tempfinal = (float) ((temp - 32) / 1.8);
                        float resposta = (float) Math.round(tempfinal * 100) / 100;
                        mylabel.setText(resposta + " °C ");
                    }

                }

            }
        } catch (Exception ex) {
            errorAlert.setHeaderText("Erro");
            errorAlert.setContentText("Algo deu errado no funcionamento do programa");
            errorAlert.showAndWait();
        }
    }
}
