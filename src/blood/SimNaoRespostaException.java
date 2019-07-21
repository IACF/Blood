/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

/**
 *
 * @author Yara C. Morais
 */
public class SimNaoRespostaException extends Exception {
 
    @Override
    public String toString(){
        
        return "Entrada inválida. Responda [SIM] ou [NAO]";
    }
    
            
}
