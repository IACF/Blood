/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * ****** ALTERAÇÕES ********
 * CONSTRUTORES: SANGUE, DOADOR
 */



package blood;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author IACF
 */
public abstract class Apessoa implements Ipessoa {
    protected String nome;
    protected String cpf;
    protected int idade;
    protected float peso;
    protected String genero;
    protected boolean statusClinico;
    protected Sangue sangue;
    protected LocalDate ultimaTransfusao;

    public void setUltimaTransfusao(LocalDate ultimaTransfusao) {
        this.ultimaTransfusao = ultimaTransfusao;
    }

    public LocalDate getUltimaTransfusao() {
        return ultimaTransfusao;
    }
    
    
    
    @Override
    abstract public boolean examinar();
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
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
