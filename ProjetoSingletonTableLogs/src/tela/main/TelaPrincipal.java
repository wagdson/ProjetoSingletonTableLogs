/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tela.main.TelaLogin;

/**
 *
 * @author WAGDSON
 */
public class TelaPrincipal extends Application{

    private static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/tela/FXML/FXMLTelaPrincipal.fxml"));
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
        setStage(stage);
    
    }
     public static Stage getStage(){
        return stage;
    }
    public static void setStage(Stage stage){
        TelaPrincipal.stage = stage;
    }
    
    
    
}
