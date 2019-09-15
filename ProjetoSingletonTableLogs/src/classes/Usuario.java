/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.TratamentoDeDados;

/**
 *
 * @author WAGDSON
 */
public class Usuario implements TratamentoDeDados{
    
    private String nome = "";
    private long CPF= 0;
    private String nomeUsuario;
    private String senha = "";
    private String permissao = "";

    public Usuario(String nome, Long CPF, String nomeUsuario, String senha, String permissao) {
        this.nome = nome;
        this.CPF = CPF; 
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.permissao = permissao;
    }
    public Usuario(){
        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the CPF
     */
    public long getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void materializar(String dados) throws Exception {
    String saida[] = dados.split(";");
    if (saida.length != 5){
        throw new Exception("erro na String usuario");
    }
    this.nome = saida[0];
    this.CPF = Long.parseLong(saida[1]);
    this.nomeUsuario = saida[2];
    this.senha = saida[3];
    this.permissao = saida[4];
    }

    @Override
    public String desmaterializar() {
      String saida = nome+";"+CPF+";"+nomeUsuario+";"+senha+";"+permissao;
      return  saida;
    }

    /**
     * @return the permissao
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    
    
    
}
