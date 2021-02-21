/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static Interfaces.cont.g;
import static Interfaces.cont.q;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class CourrectController implements Initializable {

    @FXML
    private Button OkBt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void OkBtact(ActionEvent event) throws InterruptedException, IOException {
        OkBt.getScene().getWindow().hide();

        int i = 0;
        Stage primaryStage1 = new Stage();

        while (i == 0) {

            //System.out.println("Interfaces.cont.submitBTact()");
            Thread.sleep(400);
            if (g) {
                cont.stateu=1;
                Parent root = FXMLLoader.load(getClass().getResource("Questions.fxml"));
                primaryStage1.setTitle("Questions");
                primaryStage1.setScene(new Scene(root, 590, 380));
                primaryStage1.show();
                break;
            }
            if (gameopengl2.TheGame.widthTime <= 0) {
                Parent root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
                primaryStage1.setTitle("GameOver");
                primaryStage1.setScene(new Scene(root, 590, 320));
                primaryStage1.show();
                gameopengl2.TheGame.fram.destroy();
                break;
            }

        }
    }

}
