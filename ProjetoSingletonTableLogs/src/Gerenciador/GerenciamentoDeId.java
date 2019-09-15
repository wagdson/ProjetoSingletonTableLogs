/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciador;

import interfaces.TratamentoDeDados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author WAGDSON
 */
public class GerenciamentoDeId implements TratamentoDeDados {

    private int idSessao = 0;

   private  String nomeDoArquivo ="";

    /**
     * @return the idCliente
     */
    public GerenciamentoDeId(String nomeDoArquio) throws Exception {
  this.nomeDoArquivo = nomeDoArquio;
         GerenciamentoDeId gerenciamento = recuperar();
         this.idSessao = gerenciamento.getIdSessao();
         
       
    }
    public GerenciamentoDeId(){
        
    }

   

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) throws Exception {
        if (idSessao <= this.idSessao) {
            throw new Exception("Id cliente já cadastrado!");
        }
        this.idSessao = idSessao;
    }

   

   
    

    public void materializar(String dados) throws Exception {

        String vetorString[] = dados.split(";");
        if (vetorString.length != 1) {
            throw new Exception("Faltam dados na String de Gerenciamento de ID");
        }
        this.idSessao = Integer.parseInt(vetorString[0]);
   

    }

 
    public String desmaterializar() {
        String saida = idSessao + ";";
        return saida;
    }

    public GerenciamentoDeId recuperar() throws Exception {
        try {

            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";

            GerenciamentoDeId objeto = new GerenciamentoDeId();
            if ((linha = br.readLine()) != null) {
            
                objeto.materializar(linha);
            }
            br.close();
            return objeto;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public void SalvarID(GerenciamentoDeId objeto) throws Exception {
        //cria o arquivo
        //System.out.println("medito salvaAD: "+ objeto.idSessao());
        FileWriter fw = new FileWriter(nomeDoArquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        //Escreve no arquivo
        bw.write(objeto.desmaterializar() + "\n");
        //fecha o arquivo
        bw.close();

    }

}
