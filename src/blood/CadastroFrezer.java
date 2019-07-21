/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

import java.util.ArrayList;

/**
 *
 * @author IACF
 */
public class CadastroFrezer extends ArepositorioArray<Freezer> {
     private static CadastroFrezer instancia = null;
    static CadastroFrezer getInstancia() {
        if (CadastroFrezer.instancia == null)
           instancia = new CadastroFrezer();
       return instancia;
    }

    @Override
    public void insert(Freezer e) {
        super.insert(e);
    }
    
    
    
    
    
}
