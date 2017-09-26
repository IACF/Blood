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
public class Blood {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        String Nome;
//        Doador doar = new Doador();
//        Receptor receber = new Receptor();
//        
//        receber.examinar();
//        doar.examinar();
//        doar.setNome("NomeTeste");
//        
//        System.out.println(doar.getNome());
        
       
        
    }
    
    
    public static void cadastro(){
        Doador p = new Doador();
        p.setGenero("M");
        p.setNome("fasfa");
        
//...
        CadastroPessoa bdPessoa = new CadastroPessoa();
        bdPessoa.setPessoa(p);
        
    }
    
}
