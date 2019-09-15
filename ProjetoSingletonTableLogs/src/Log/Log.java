/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

/**
 *
 * @author WAGDSON
 */
public class Log {

    private int id = 0;
    private String local = "";
    private String nomeUsuario = "";
    private String operacao = "";
    private String erro = "";
    private String dataHora = "";

    public Log( int id, String local, String nomeUsuario, String operacao, String erro, String dataHora) {
        this.id = id;
        this.local = local;
        this.nomeUsuario = nomeUsuario;
        this.operacao = operacao;
        this.erro = erro;
        this.dataHora = dataHora;
    }
    public Log(){
        
    }

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipoDeOperacao
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param tipoDeOperacao the tipoDeOperacao to set
     */
    public void setLocal(String local) {
        this.local = local;
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
     * @return the operacao
     */
    public String getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the mensagem
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    }

    /**
     * @return the dataHora
     */
    public String getDataHora() {
        return dataHora;
    }

    /**
     * @param dataHora the dataHora to set
     */
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String desmaterializar() {
        String saida = this.id + ";"
                + this.local + ";"
                + this.nomeUsuario + ";"
                + this.operacao + ";"
                + this.erro + ";"
                + this.dataHora;
        return saida;
    }
    public void materializar(String dados) throws Exception{
      String saida[]=dados.split(";");
      
        if(saida.length != 6){
            throw new  Exception("Erro da String log");
        }
       this.id = Integer.parseInt(saida[0]);
       this.local = saida[1];
       this.nomeUsuario = saida[2];
       this.operacao = saida[3];
       this.erro = saida[4];
       this.dataHora = saida[5];
           
    }

}
