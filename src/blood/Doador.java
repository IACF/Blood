/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author IACF
 */
public class Doador extends Apessoa {
    
     private LocalDate ultimaDoacao;
     private long diferencaemMes;
    
     // Substituir o tipo string por DATE ; Tratar possiveis erros do tipo
     public void CalculoDoacao(){
        // esse metodo é feito para capturarmos a data atual quando o doador vai doar sangue, e logo faz
        // a diferenca entre a data do dia e a ultima doacao.
        
        LocalDate hoje = LocalDate.now();
        diferencaemMes = ChronoUnit.MONTHS.between(hoje,ultimaDoacao); // retorna o numero de meses entre a ultima doacao e a data atual
     
    };
    public void doarSangue(BancoDeSangue b, float v){
        
        this.sangue.setQuantidade(v);
        b.colocarNoFreezer(this.sangue);
        //this.ultimaDoacao = "DataAtual" [[[ ??? ]]]
    }
    
//    public void doarSangue(BancoDeSangue b, float v){
//        
//        if(diferencaemMes>=3){ // se a diferença entre a data atual e a ultima doacao for >=3 ( onde está tratando isso? 
//        this.sangue.setQuantidade(v);
//        ultimaDoacao= LocalDate.now(); // pega a data atual para ser agora a ultima doacao
//        
//        if(statusSangue=true) // isso está na fachada ( examinar sangue ) ?
//        b.colocarNoFreezer(this.sangue);
//        }
//    }

    public String getUltimaDoacao() {
        return ultimaTransfusao;
    }

    public void setUltimaDoacao(String ultimaDoacao) {
        this.ultimaTransfusao = ultimaDoacao;
    }

    
    
    @Override
    public Freezer examinar(BancoDeSangue b){
        System.out.println("Peso");
        peso = entrada.nextFloat();
         try {
          // se nao for float
          // throw new NumberFormatException("Entrada do peso inválida!");
               
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    
         
        try {
            System.out.println("Tipo Sanguineo");
            String tipo= entrada.nextLine();
             if(!tipo.contains("A+") || !tipo.contains("A-") || !tipo.contains("B+") || !tipo.contains("B-")| !tipo.contains("AB+") | !tipo.contains("AB-") | !tipo.contains("O+") | !tipo.contains("O-"))
                                
                    throw new RuntimeException("Tipo Sanguineo inválido");
             
             else 
                 this.sangue.setTipagemSanguinea(tipo); 
                 
             
        } catch (RuntimeException e) {
           System.out.println("Aconteceu um erro");
           System.out.println(e);                             
        }
        return b.freezer.get(this.sangue.tipagemSanguinea);
    }
  

    
}
