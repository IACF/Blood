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
public class Doador extends Apessoa {
    
    private String ultimaDoacao; // Substituir o tipo string por DATE ; Tratar possiveis erros do tipo
    
    
    public void doarSangue(BancoDeSangue b, float v){
        
        this.sangue.setQuantidade(v);
        b.colocarNoFreezer(this.sangue);
        //this.ultimaDoacao = "DataAtual"
    }

    public String getUltimaDoacao() {
        return ultimaDoacao;
    }

    public void setUltimaDoacao(String ultimaDoacao) {
        this.ultimaDoacao = ultimaDoacao;
    }

    
    
    @Override
    public void examinar(){
        System.out.println("Doador examinado");
    }
}
