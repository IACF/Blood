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
public class CadastroPessoa {
   private Apessoa pessoa;
   private String ultimaDoacao;
   private Irepositorio<Apessoa> repositorio;

    public void setPessoa(Doador pessoa) {
        ultimaDoacao = pessoa.getUltimaDoacao();
        this.pessoa = pessoa;
    }
    
    public void setPessoa(Receptor pessoa){
        this.ultimaDoacao = null;
        this.pessoa = pessoa;
    }
   
   public void insert(){
       repositorio =  new BDRepositorio("pessoa");
       repositorio.insert(pessoa);
   }
   
}
