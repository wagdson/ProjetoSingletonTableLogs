/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WAGDSON
 */
public class TableLog {

    private SimpleStringProperty id;
    private SimpleStringProperty local;
    private SimpleStringProperty nomeUsuario;
    private SimpleStringProperty operacao;
    private SimpleStringProperty erro;
    private SimpleStringProperty dataHora;
 

    public TableLog(String id, String local, String nomeUsuario, String operacao, String erro, String dataHora) {

        this.id = new SimpleStringProperty(id);
        this.local = new SimpleStringProperty(local);
        this.nomeUsuario = new SimpleStringProperty(nomeUsuario);
        this.operacao = new SimpleStringProperty(operacao);
        this.erro = new SimpleStringProperty(erro);
        this.dataHora = new SimpleStringProperty(dataHora);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {

        this.id = new SimpleStringProperty(id);
    }

     
    public String getLocal() {
        return local.get();
    }


    public void setLocal(String local) {
        this.local  = new SimpleStringProperty(local);
    }


    public String getNomeUsuario() {
        return nomeUsuario.get();
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario  = new SimpleStringProperty(nomeUsuario);
    }

    public String getOperacao() {
        return operacao.get();
    }

   
    public void setOperacao(String operacao) {
        this.operacao = new SimpleStringProperty(operacao);
    }

    /**
     * @return the erro
     */
    public String getErro() {
        return erro.get();
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = new SimpleStringProperty(erro);
    }

    /**
     * @return the dataHora
     */
    public String getDataHora() {
        return dataHora.get();
    }

    /**
     * @param dataHora the dataHora to set
     */
    public void setDataHora(String dataHora) {
        this.dataHora = new SimpleStringProperty(dataHora);
    }

}
