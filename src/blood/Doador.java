/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;



/**
 *
 * @author IACF
 */
public class Doador extends Apessoa {
    
     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     
     public Doador(String nome, String cpf, int idd, float peso, boolean statusClin, String gen, Sangue blood, LocalDate data){
         setNome(nome);
         setCPF(cpf);
         setIdade(idd);
         this.peso = peso;
         setStatusClinico(statusClin);
         setGenero(gen);
         this.sangue = blood;
         this.ultimaTransfusao = data;
     }
     public Doador(){
        this.statusClinico = true;
        this.ultimaTransfusao = LocalDate.parse("01/01/0001", formatador);
        this.nome = null;
        this.cpf = null;
        this.idade = 0;
        this.genero = null;
        this.sangue = null;
        this.peso = 0;
     }
    
     // Substituir o tipo string por DATE ; Tratar possiveis erros do tipo
     public int calculoUltimaTransfusao(){
        // esse metodo é feito para capturarmos a data atual quando o doador vai doar sangue, e logo faz
        // a diferenca entre a data do dia e a ultima doacao.
        int diferencaEmMes;
        LocalDate hoje = LocalDate.now();
        LocalDate aux = LocalDate.parse("01/01/0001", formatador);
        if(!this.ultimaTransfusao.equals(aux)){
            diferencaEmMes = (int) ChronoUnit.MONTHS.between(this.ultimaTransfusao, hoje); // retorna o numero de meses entre a ultima doacao e a data atual
            return diferencaEmMes;
        }
        else{
            diferencaEmMes = (int) ChronoUnit.MONTHS.between(this.ultimaTransfusao, hoje);
            return diferencaEmMes;
        }
    }
    public void doarSangue(BancoDeSangue b){
        LocalDate aux = LocalDate.parse("01/01/0001", formatador);
                this.sangue.setQuantidade(1);
                b.colocarNoFreezer(this.sangue);
                System.out.println("***Doou***");
                
    }
     
    @Override
    public boolean examinar() {
        this.setStatusClinico(true);
        Scanner input = new Scanner(System.in);
            
        
        
        if (this.getIdade() > 17){
            System.out.println("Menor de idade. Exigir autorização e formulários de responsabilidade.");
            return false;
        }
        
        if (this.getIdade() > 69){
            System.out.println("Idade máxima.");
            return false;
        }
        
        if (this.getPeso() < 50){
            System.out.println("Massa corporal insuficiente.");
            System.out.println(getPeso());
            return false;
        }
        
        String perguntas[] = {"Teve Hepatite após os 10 anos de idade? [S/N] ", "Teve Hepatite B e/ou C? [S/N]", 
         "Tem HIV? [S/N]","Teve Doença de Chagas? [S/N]", "Teve doenças aos virus HTLV I e II? [S/N]","Teve Malaria? [S/N]",
         "Usou Drogas Ilicitas Injetaveis? [S/N]", "Teve sintomas de resfriado nos ultimos 7 dias? [S/N]", "Amamentação? (se o parto ocorreu há menos de 12 meses) [S/N]",
         "Ingestão de bebida alcoólica nas 12 horas que antecedem a doação? [S/N]", "Tatuagem / maquiagem definitiva nos últimos 12 meses? [S/N]"};
        int i =0;
        String a;
         
        while(!this.statusClinico || i < 11){
            System.out.println(perguntas[i]);
            a = input.nextLine();
                if(a.equals("S")|| a.equals("s")){
                    this.setStatusClinico(false);
                    return false;
                } else { if(a.equals("N")||a.equals("n")){
                           i++;
                            } else { 
                                System.out.println("Entrada incorreta.");
                               
                                }
                   
                }
        
        }    
           return (this.statusClinico); 
    };
}
