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
    
    Map<String, Freezer> freezer;
    public Sangue sangue;
    
    public BancoDeSangue() {
        //Função para usar o hashMap, é de uso obrigatório.
        this.freezer = new HashMap<>();
        bancoDeSangue();
    }
    public void bancoDeSangue(){
        // Esta função estar Criando cada Freezer com seu respectivo tipo,
        //e preenchendo a compatibilidade de sangue de cada um dos Freezers.
        
        /**
         * ALTERADO
         */
        
        freezer.put("A+", new Freezer());
        freezer.get("A+").setQuantidade(15);  
        freezer.put("B+", new Freezer());
        freezer.get("B+").setQuantidade(15);  
        freezer.put("O+", new Freezer());
        freezer.get("O+").setQuantidade(15);  
        freezer.put("AB+", new Freezer());
        freezer.get("AB+").setQuantidade(15);  
        freezer.put("O-", new Freezer());
        freezer.get("O-").setQuantidade(15);  
        freezer.put("A-", new Freezer());
        freezer.get("A-").setQuantidade(15);  
        freezer.put("B-", new Freezer());
        freezer.get("B-").setQuantidade(15);  
        freezer.put("AB-", new Freezer());
        freezer.get("AB-").setQuantidade(15);  
        
        for (String key : freezer.keySet()){
            //Capturamos o valor a partir da chave
            freezer.get(key).setCompatibilidade(key);
        }
        

    }   

    public void colocarNoFreezer(Sangue sangue) { 
        //  Neste argumento de função poderia colocar o Objeto Doador ao invés do Objeto Sangue.
        
        this.freezer.get(sangue.tipagemSanguinea).setQuantidade(sangue.quantidade);  
    }
    
    public void retirarDoFreezer(Sangue sangue){
        // Neste argumento de função poderia colocar o Objeto Receptor ao invés do Objeto Sangue.
        if(this.freezer.get(sangue.tipagemSanguinea).getQuantidade() < sangue.quantidade )
            System.out.println("Não contém esta quantidade de sangue");  
        else
            this.freezer.get(sangue.tipagemSanguinea).doarQuantidade(sangue.quantidade);
    }
    public void atualizarRepositorio(CadastroFrezer f){
        f.clear();
        for (String key : freezer.keySet()){
            //Capturamos o valor a partir da chave
            f.insert(this.freezer.get(key));
        }
    }
    public boolean compativelFreezer(Freezer f ,Sangue sangue){
            // pegar tamanho do array compatibilidade
            for (String compatibilidade : f.compatibilidade) {               
                if (compatibilidade != null && compatibilidade.equals(sangue.getTipagemSanguinea()) &&
                        f.getQuantidade() >= sangue.quantidade) {    
                    return true;
                }
            }
        return false;
    }
    
    public void listarFreezer(){
        for (String key : this.freezer.keySet())
            System.out.println("Frezer do tipo " +key+":"+this.freezer.get(key).getQuantidade()+"bolsas");             
    }
    
    
}
