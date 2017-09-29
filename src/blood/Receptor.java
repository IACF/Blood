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
public class Receptor extends Apessoa {
    
    @Override
    public void examinar(){
        System.out.println("examinou");
    }
    
    public void receberSangue(BancoDeSangue b, float quantidadeDeSangue, String tipagemSanguinea){
        
        this.sangue.setQuantidade(quantidadeDeSangue);
        b.retirarDoFreezer(this.sangue, tipagemSanguinea);
    }
    public String getUltimaTransfusao() {
        return ultimaTransfusao;
    }

    public void setUltimaTransfusao(String ultimaTransfusao) {
        this.ultimaTransfusao = ultimaTransfusao;
    }
    
}
