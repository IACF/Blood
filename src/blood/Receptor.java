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
import java.util.Scanner;
public class Receptor extends Apessoa {
    
    
    @Override
    public Freezer examinar(BancoDeSangue b)throws BloodTypeNotFoundException,BloodNotEnoughException {
        
        try {
            System.out.println("Tipo Sanguineo");
            String tipo= entrada.nextLine();
            if(!tipo.contains("A+") || !tipo.contains("A-") || !tipo.contains("B+") || !tipo.contains("B-")| !tipo.contains("AB+") | !tipo.contains("AB-") | !tipo.contains("O+") | !tipo.contains("O-"))
                throw new BloodTypeNotFoundException("Tipo Sanguineo inválido");
            else 
                this.sangue.setTipagemSanguinea(tipo);      
        } catch (RuntimeException e) {
           System.out.println("Aconteceu um erro");
           System.out.println(e);
        }
        
        Freezer f = b.findFreezer(this.sangue);
        if(f != null)
           return f;
           
     throw new BloodNotEnoughException("erro LGU");
        
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
