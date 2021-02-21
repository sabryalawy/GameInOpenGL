/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameopengl2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @Dr. Iyad Jaber
 */
public class GameOpenGL extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("..\\Interfaces\\Start.fxml"));
        primaryStage.setTitle("Start");
        primaryStage.setScene(new Scene(root, 590, 320));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        
 
        launch(args);
System.out.println("gameopengl2.GameOpenGL.main() "+ System.getProperty("user.dir"));
        
    }

}
