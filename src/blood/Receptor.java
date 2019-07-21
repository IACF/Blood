/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author IACF
 */
public class Receptor extends Apessoa {
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Receptor(){
        this.statusClinico = true;
        this.ultimaTransfusao = LocalDate.parse("01/01/0001", formatador);
        this.nome = null;
        this.cpf = null;
        this.idade = 0;
        this.genero = null;
        this.sangue = null;
        this.peso = 0;
    }
    public Receptor(String nome, String cpf, int idd, float peso, String gen, Sangue blood){
        setNome(nome);
         setCPF(cpf);
         setIdade(idd);
         setPeso(peso);
         setStatusClinico(true);
         setGenero(gen);
         this.sangue = blood;
         this.ultimaTransfusao = LocalDate.parse("01/01/0001", formatador);
    }
    
    @Override
    public boolean examinar(){
        return true;
           
        
    }
    
    public void receberSangue(BancoDeSangue b, int quantidadeDeSangue){
        LocalDate hoje = LocalDate.now();
        setUltimaTransfusao(hoje);
        Sangue s = new Sangue();
        s.setQuantidade(quantidadeDeSangue);
        
        this.sangue.setQuantidade(quantidadeDeSangue);
        for(String key : b.freezer.keySet()){
            if(b.compativelFreezer(b.freezer.get(key), this.sangue)){
                s.setTipagemSanguinea(key);
                b.retirarDoFreezer(s); 
                return;
            }
        }
        System.out.println("Quantidade insuficiente para recepção");
    }  
    
}
