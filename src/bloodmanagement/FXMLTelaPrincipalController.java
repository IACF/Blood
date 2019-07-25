/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodmanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Igor
 */
public class FXMLTelaPrincipalController implements Initializable {
    
    
    @FXML
    private void abrirTelaCadastro(ActionEvent event) throws Exception{
        BloodManagement.mudarTela("cadastro");
    }
    
    @FXML
    private void abrirTelaRetirada(ActionEvent event){
        BloodManagement.mudarTela("retirar");
    }
    
    @FXML
    private void abrirTelaAdd(ActionEvent event){
        BloodManagement.mudarTela("CPF");
    }
    
    @FXML
    private void abrirTelaUpdate(ActionEvent event){
        BloodManagement.mudarTela("CPF");
    }
    
    @FXML
    private void sairPrograma(ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
