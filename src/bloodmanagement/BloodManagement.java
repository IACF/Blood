/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Igor
 */
public class BloodManagement extends Application {
    private static Stage stage;
    
    private static Scene main;
    private static Scene cadastro;
    private static Scene retirar;
    private static Scene CPF;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        stage = primaryStage;
        
        FXMLLoader telaPrincipal = new FXMLLoader(this.getClass().getResource("FXMLTelaPrincipal.fxml"));
        main = new Scene(telaPrincipal.load());
        
        FXMLLoader telaCadastro = new FXMLLoader(this.getClass().getResource("FXMLCadastrar_User.fxml"));
        cadastro = new Scene(telaCadastro.load());
        
        FXMLLoader telaRetirar = new FXMLLoader(this.getClass().getResource("FXMLRetirarBolsas.fxml"));
        retirar = new Scene(telaRetirar.load());
        
        FXMLLoader telaCPF = new FXMLLoader(this.getClass().getResource("FXMLValidarUser.fxml"));
        CPF = new Scene(telaCPF.load());
        
        
        primaryStage.setTitle("Gerenciador de Hemocentro");
        primaryStage.setScene(main);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    public static void mudarTela(String s){
        switch(s){
            case "principal":
                stage.setScene(main);
                break;
            case "cadastro":
                stage.setScene(cadastro);
                break;
            case "retirar":
                stage.setScene(retirar);
                break;
            case "CPF":
                stage.setScene(CPF);
                break;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
