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
public class Freezer {
    public Sangue sangue;
    private float quantidade;
    String[] compatibilidade = new String[8];
    
    
    public void setCompatibilidade(String tipagemSanguinea){
        switch(tipagemSanguinea){
            case "A+": 
                this.compatibilidade[0] = "AB+";
                this.compatibilidade[1] = "A+";
                break;
            case "A-": 
                this.compatibilidade[0] = "A+";
                this.compatibilidade[1] = "A-";    
                this.compatibilidade[2] = "AB+";    
                this.compatibilidade[3] = "AB-";   
                break;
            case "B+": 
                this.compatibilidade[0] = "B+";
                this.compatibilidade[1] = "AB+";    
                break;
            case "B-": 
                this.compatibilidade[0] = "B+";
                this.compatibilidade[1] = "B-";    
                this.compatibilidade[2] = "AB+";    
                this.compatibilidade[3] = "AB-";    
                break;
            case "AB+": 
                this.compatibilidade[0] = "AB+";
                break;
            case "AB-": 
                this.compatibilidade[0] = "AB+";
                this.compatibilidade[1] = "AB-";    
                break;
            case "O+": 
                this.compatibilidade[0] = "A+";
                this.compatibilidade[1] = "B+";    
                this.compatibilidade[2] = "O+";    
                this.compatibilidade[3] = "AB+";    
                break;
            case "O-": 
                this.compatibilidade[0] = "A+";
                this.compatibilidade[1] = "A-";
                this.compatibilidade[2] = "B+";
                this.compatibilidade[3] = "B-";    
                this.compatibilidade[4] = "AB+";    
                this.compatibilidade[5] = "AB-";    
                this.compatibilidade[6] = "O+";
                this.compatibilidade[7] = "O-";
                break;
        }
    }
    public Freezer() {
        this.sangue = new Sangue();
    }
    
    
    public Sangue getSangue() {
        return sangue;
    }

    public void setSangue(Sangue sangue) {
        //if(this.sangue == )
        this.sangue = sangue;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade += quantidade;
    }
    
    public void doarQuantidade(float quantidade) {
        this.quantidade -= quantidade;
    }

    
    
}
