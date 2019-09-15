/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencias;

import Complementares.CapData;
import Gerenciador.GeradorID;
import Log.GerenciadorLog;
import Log.Log;
import classes.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author WAGDSON
 */
public class UsuarioDAO {

    FileWriter fw = null;
    BufferedWriter bw = null;
    private String arquivo = "";

    public UsuarioDAO(String dirArquivo) {
        arquivo = dirArquivo;

    }

    public void incluir(Usuario objeto) throws Exception {
      
        //cria o arquivo
        FileWriter fw = new FileWriter(arquivo, true);
        //Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        //Escreve no arquivo
        bw.write(objeto.desmaterializar() + "\n");
        //fecha o arquivo
        bw.close();
        GeradorID geradorID = new GeradorID();
        int id = geradorID.geraIDSessao();
        CapData cp = new CapData();
        Log log = new Log(id, "Tbl Usúario", System.getProperty("login"), "insert", "", cp.capturarData());
        GerenciadorLog.getInstancia().capturarLogs(log);

    }

    public void alterar(Usuario objeto) throws Exception {

        ArrayList<Usuario> listaDeVistorias = this.recuperar();
        // cria o arquivo
        FileWriter fw = new FileWriter(arquivo);
        // Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);

        for (int pos = 0; pos < listaDeVistorias.size(); pos++) {

            Usuario aux = listaDeVistorias.get(pos);

            if (aux.getNomeUsuario().equals(objeto.getNomeUsuario())) {

                aux = objeto;

            }
            bw.write(aux.desmaterializar() + "\n");
        }

        bw.close();
        
         GeradorID geradorID = new GeradorID();
        int id = geradorID.geraIDSessao();
        CapData cp = new CapData();
        Log log = new Log(id, "Tbl Usúario", System.getProperty("login"), "Update", "", cp.capturarData());
        GerenciadorLog.getInstancia().capturarLogs(log);

    }

    public ArrayList<Usuario> recuperar() throws Exception {

        ArrayList<Usuario> listaDeUsuario = new ArrayList<Usuario>();
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {

            Usuario usuario = new Usuario();
            usuario.materializar(linha);
            listaDeUsuario.add(usuario);
        }
        br.close();

        return listaDeUsuario;

    }

    public Usuario buscar(String nomeUsuario) throws Exception {
        try {
            ArrayList<Usuario> listaUsuario = this.recuperar();
            for (int pos = 0; pos < listaUsuario.size(); pos++) {
                Usuario aux = listaUsuario.get(pos);
                if (aux.getNomeUsuario().equals(nomeUsuario)) {
                    return aux;
                }
            }
            throw new Exception("Usuario informado é invalido!");

        } catch (Exception erro) {
            throw erro;
        }
    }

    public void excluir(String nomeUsuario) throws Exception {

        ArrayList<Usuario> listaUsuario = this.recuperar();
        //cria o arquivo
        FileWriter fw = new FileWriter(arquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        for (int pos = 0; pos < listaUsuario.size(); pos++) {
            Usuario aux = listaUsuario.get(pos);
            if (!(aux.getNomeUsuario().equals(nomeUsuario))) {
                bw.write(aux.desmaterializar() + "\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
        bw.close();
            
        
        GeradorID geradorID = new GeradorID();
        int id = geradorID.geraIDSessao();
         CapData cp = new CapData();
        Log log = new Log(id, "Tbl Usúario", System.getProperty("login"), "Delet", "", cp.capturarData());
        GerenciadorLog.getInstancia().capturarLogs(log);

    }

    public List<Usuario> recuperarList() throws Exception {

        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {

            Usuario objetoUsuario = new Usuario();

            objetoUsuario.materializar(linha);
            listaUsuario.add(objetoUsuario);
        }
        br.close();
        
        
        

        return listaUsuario;
       
        
 

    }

}
