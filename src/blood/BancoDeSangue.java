/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author IACF
 */
public class BancoDeSangue {
    
    private Map<String, Freezer> freezer;
    public Sangue sangue;
    
    public BancoDeSangue() {
        //Função para usar o hashMap, é de uso obrigatório.
        this.freezer = new HashMap<>();
    }
    public void bancoDeSangue(){
        // Esta função estar Criando cada Freezer com seu respectivo tipo,
        //e preenchendo a compatibilidade de sangue de cada um dos Freezers.
        
        freezer.put("A+", new Freezer());
        freezer.get("A+").setQuantidade(0);  
        freezer.put("B+", new Freezer());
        freezer.get("B+").setQuantidade(0);  
        freezer.put("O+", new Freezer());
        freezer.get("O+").setQuantidade(0);  
        freezer.put("O+", new Freezer());
        freezer.get("AB+").setQuantidade(0);  
        freezer.put("AB+", new Freezer());
        freezer.get("O-").setQuantidade(0);  
        freezer.put("A-", new Freezer());
        freezer.get("A-").setQuantidade(0);  
        freezer.put("B-", new Freezer());
        freezer.get("B-").setQuantidade(0);  
        freezer.put("AB-", new Freezer());
        freezer.get("AB-").setQuantidade(0);  
        
        for (String key : freezer.keySet()){
            //Capturamos o valor a partir da chave
            freezer.get(key).setCompatibilidade(key);
        }
        

    }   

    public void colocarNoFreezer(Sangue sangue) { 
        //  Neste argumento de função poderia colocar o Objeto Doador ao invés do Objeto Sangue.
        freezer.get(sangue.tipagemSanguinea).setQuantidade(sangue.quantidade);  
    }
    
    public void retirarDoFreezer(Sangue sangue){
        // Neste argumento de função poderia colocar o Objeto Receptor ao invés do Objeto Sangue.
        freezer.get(sangue.tipagemSanguinea).doarQuantidade(sangue.quantidade);  
    }
    
}
