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

/**
 *
 * @author lisa
 */
public class SceneSubController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        MainApp.data = "FromSceneSub";
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneMain.fxml"));
        Scene sceneSub = new Scene(root);
        //  
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(sceneSub);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(MainApp.data);
    }

}
