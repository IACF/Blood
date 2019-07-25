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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Igor
 */
public class FXMLRetirarBolsasController implements Initializable {

    private static Label lblAMenos, lblAMais, lblANull,
                         lblBMenos, lblBMais, lblBNull,
                         lblABMenos, lblABMais, lblABNull,
                         lblOMenos, lblOMais, lblONull;
    private static ChoiceBox cbTipo, cbRH;
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void voltarTelaInincial(ActionEvent event) throws Exception{
        BloodManagement.mudarTela("principal");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
