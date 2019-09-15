/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import classes.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WAGDSON
 */
public class GerenciadorLog extends Thread implements IGerenciamentoLogs {

    private static GerenciadorLog instancia = null;
    private String arquivo = "D:\\Faculdade\\3 semestre\\Padrão de Projetos\\Projetos\\Padrao Singleton\\TelaControleAcesso\\src\\arquivosDados\\arquivoLog";
    private ArrayList<Log> arrayLogs = new ArrayList<Log>();
    private static int cont = 0;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter buffered;

    private GerenciadorLog() {

    }

    public static GerenciadorLog getInstancia() {
     
        if (instancia == null) {
            setInstancia(new GerenciadorLog());

        }
        return instancia;
    }

    public static void setInstancia(GerenciadorLog aInstancia) {
        instancia = aInstancia;
    }

    @Override
    public void capturarLogs(Log log) {

    
        arrayLogs.add(log);

    }

    @Override
    public void armazenarLogs() throws IOException {
    

        //cria o arquivo
        FileWriter fw = new FileWriter(arquivo, true);
        //Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        //Escreve no arquivo
        bw.write(arrayLogs.get(cont).desmaterializar() + "\n");
        //fecha o arquivo
        bw.close();
        cont++;
        System.out.println("armazenou logs");

    }

    @Override
    public ArrayList<Log> recuperarLogs() throws Exception {

        ArrayList<Log> listaLogs = new ArrayList<Log>();
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        while ((linha = br.readLine()) != null) {

            Log log = new Log();
            log.materializar(linha);
            listaLogs.add(log);
        }
        br.close();

        return listaLogs;

    }

    @Override
    public void run() {
     
        while (true) {
           
            try {
                if (cont < arrayLogs.size()) {
            
          
                    armazenarLogs();
                  
                }
            } catch (Exception ex) {
                Logger.getLogger(GerenciadorLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
