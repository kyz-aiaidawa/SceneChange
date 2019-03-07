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
public class SceneMainController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private void onBtnQuit(ActionEvent event) {
        MainApp.quitAll();
    }
    @FXML
    private void onBtnTask1(ActionEvent event) throws IOException {
        MainApp.data = "FromSceneMain";
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneSub.fxml"));
        Scene sceneSub = new Scene(root);
        //  
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("SceneSub from SceneMainController");
        stage.setScene(sceneSub);
        stage.show();
    }
    @FXML
    private void onBtnTask2(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText(MainApp.data);
    }
}
