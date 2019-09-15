/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import java.util.ArrayList;

/**
 *
 * @author WAGDSON
 */
public interface IGerenciamentoLogs {
  
    public void capturarLogs(Log log);
    public void armazenarLogs()throws Exception;
    public ArrayList<Log> recuperarLogs()throws Exception;
}
