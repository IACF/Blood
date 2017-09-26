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
public abstract class Apessoa implements Ipessoa {
    protected String nome;
    protected String Rg;
    protected int idade;
    protected float peso;
    protected String genero;
    protected boolean statusClinico;
    protected Sangue sangue;
    
    abstract public void  examinar();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean getStatusClinico() {
        return statusClinico;
    }

    public void setStatusClinico(boolean statusClinico) {
        this.statusClinico = statusClinico;
    }

    
    
    
    
    
    
    
    
}
