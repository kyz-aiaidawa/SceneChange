/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.miki.maya.scenechange;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author lisa
 */
public class SceneSubController implements Initializable {

    @FXML
    private Label label = new Label("");

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        preStatus(event);
        MainApp.data = "FromSceneSub";
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneMain.fxml"));
        Scene sceneSub = new Scene(root);
        //  
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSub);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(MainApp.data);

    }

    private void saveStatus() {
        System.out.println("SceneSubController... saveStatus() ");
    }

    private void preStatus(ActionEvent event) {
        Node name = (Node) event.getSource();
        Scene scene = name.getScene();
        if (scene != null) {
            Stage stage = (Stage) scene.getWindow();
            if (stage != null) {
                stage.showingProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("oldValue = " + oldValue + " newValue = " + newValue);
                    if (oldValue == true && newValue == false) {
                        saveStatus();
                    }
                });
            } else {
                System.out.println("preStatus stage is null ");
            }
        } else {
            System.out.println("preStatus scene is null");
        }
    }
}
