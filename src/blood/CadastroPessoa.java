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
public class CadastroPessoa extends ArepositorioArray<Apessoa> {
   private static Apessoa pessoa;
   private static CadastroPessoa instancia;
   
   private CadastroPessoa(){};
   
   public static CadastroPessoa getInstancia(){
       if (CadastroPessoa.instancia == null)
           instancia = new CadastroPessoa();
       return instancia;
   }
    
   public boolean contido(Apessoa pessoa){
       return this.table.contains(pessoa);
       
   }
    
   @Override
   public void insert(Apessoa pessoa){
       super.insert(pessoa); 
   }
   
   
}
