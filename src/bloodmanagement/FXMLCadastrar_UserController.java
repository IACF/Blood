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
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Igor
 */
public class FXMLCadastrar_UserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private static TextField txtNome, txtCPF, txtRG, txtOrgao, txtAltura, txtPeso, txtTel;
    private static ChoiceBox cbTipo, cbRH;
    private static TextArea txtbAdc;
    private static Spinner spUF;
    private static DatePicker dpNasc;
    private static CheckBox chDoador, chCheckup;
    
    
    @FXML
    private void voltarTelaInincial(ActionEvent event) throws Exception{
        BloodManagement.mudarTela("principal");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
