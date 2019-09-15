package tela.controlador;

import Complementares.CapData;
import Gerenciador.GeradorID;
import Log.GerenciadorLog;
import Log.Log;
import classes.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import persistencias.UsuarioDAO;
import tela.main.TelaLogin;
import tela.main.TelaPrincipal;

public class ControladorLogin implements Initializable{

    private String arquivoUsuario = "\\TelaControleAcesso\\src\\arquivosDados\\ArquivoUsuario";

    @FXML
    private Button btnEntrar;

    @FXML
    private Label label;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtSenha;

    @FXML
    private Label lblEsqueceuSenha;

    @FXML
    void handleEntrarAction(ActionEvent event) throws Exception {
        try {
            UsuarioDAO userDAO = new UsuarioDAO(arquivoUsuario);
            Usuario user;

            user = userDAO.buscar(txtUsuario.getText());
            System.setProperty("login", txtUsuario.getText());
            System.setProperty("password", txtUsuario.getText());
            if (user.getSenha().equals(txtSenha.getText())) {

                Stage stage = new Stage();
                TelaPrincipal tp = new TelaPrincipal();
                tp.start(stage);
                TelaLogin.getStage().close();

                /**
                 * criando log
                 */
                String login = System.getProperty("login");
                GeradorID gerador = new GeradorID();
                CapData data = new CapData();

                Log log = new Log(gerador.geraIDSessao(),"", System.getProperty("login"), "Inicio Sessão", "", data.capturarData());

                GerenciadorLog.getInstancia().capturarLogs(log);
             

                // SessaoAtual sessao = SessaoAtual.getInstance();
                //sessao.setUser(user);
                // GeradorID gerador = new GeradorID();
                //sessao.setId(gerador.geraIDSessao());
                //Rotina r = new Rotina();
                //r.start();
            } else {
                GeradorID gerador = new GeradorID();
                CapData data = new CapData();
                JOptionPane.showMessageDialog(null, "Senha invalida!");
                Log log = new Log(gerador.geraIDSessao(), "", System.getProperty("login"), "Tentativa de Login", "", data.capturarData());
                GerenciadorLog.getInstancia().capturarLogs(log);
                

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "Senha invalida!");
            GeradorID gerador = new GeradorID();
            CapData data = new CapData();
            Log log = new Log(gerador.geraIDSessao(), "", System.getProperty("login"), "Tentativa de Login", ex.getMessage(), data.capturarData());
            GerenciadorLog.getInstancia().capturarLogs(log);
          
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
             GerenciadorLog.getInstancia().start();
             
             
    }
}
