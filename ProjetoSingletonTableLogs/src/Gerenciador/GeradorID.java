/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciador;

/**
 *
 * @author WAGDSON
 */
public class GeradorID {
       private String nomeArquivo = "D:\\Faculdade\\3 semestre\\Padrão de Projetos\\Projetos\\Padrao Singleton\\TelaControleAcesso\\src\\arquivosDados\\ArquivoID";

     public int geraIDSessao() throws Exception {

        GerenciamentoDeId gerenciamento = new GerenciamentoDeId(nomeArquivo);
        int codigo = gerenciamento.getIdSessao()+ 1;
        gerenciamento.setIdSessao(codigo);
        gerenciamento.SalvarID(gerenciamento);
        return codigo;
    }

        
    
}
