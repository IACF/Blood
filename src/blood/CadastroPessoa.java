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
   private static Apessoa pessoa;
   private String ultimaDoacao;
   private Irepositorio<Apessoa> repositorio;
   private static CadastroPessoa instancia;
   
   private CadastroPessoa(){};
   
   public static CadastroPessoa getInstancia(){
       if (CadastroPessoa.instancia == null)
           instancia = new CadastroPessoa();
       return instancia;
   }
   
    public void setPessoa(Doador pessoa) {
        ultimaDoacao = pessoa.getUltimaDoacao();
        CadastroPessoa.pessoa = pessoa;
    }
    
    public void setPessoa(Receptor pessoa){
        this.ultimaDoacao = null;
        CadastroPessoa.pessoa = pessoa;
    }
   
   public void insert(){
       repositorio =  new BDRepositorio("pessoa");
       repositorio.insert(pessoa);
   }
   
}
