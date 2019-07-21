/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

/**
 *
 * @author IACF
 */
public class Sangue {
    public String tipagemSanguinea;
    public int quantidade;

    public int getQuantidade() {
        return quantidade;
    }
    
    public Sangue(String tipagem, int quantidade){
        setTipagemSanguinea(tipagem);
        setQuantidade(quantidade);
    }
    public Sangue(){
        this.quantidade = 0;
        this.tipagemSanguinea = null;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        
    }
    
    


    public String getTipagemSanguinea() {
        return tipagemSanguinea;
    }

    public void setTipagemSanguinea(String tipagemSanguinea) {
        this.tipagemSanguinea = tipagemSanguinea;
    }

    
    
    
}
