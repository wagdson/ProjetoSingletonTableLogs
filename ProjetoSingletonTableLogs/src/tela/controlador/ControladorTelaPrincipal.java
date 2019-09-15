/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tela.main.TelaCadastroUsuario;
import tela.main.TelaConsultaLog;


/**
 *
 * @author WAGDSON
 */
public class ControladorTelaPrincipal {

    @FXML
    private AnchorPane acpPrincipal;

    @FXML
    private Button btnCadastroUsuario;

    @FXML
    private Button btnCadastroCliente;

    @FXML
    private Button btnSair;

    @FXML
    void cadastrarUsuario(ActionEvent event) throws Exception {

        Stage stage = new Stage();
        TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
        telaCadastroUsuario.start(stage);
    }

    @FXML
    void gerenciarSessao(ActionEvent event) {
        try {
            Stage stage = new Stage();
            TelaConsultaLog telaConsultaLog = new TelaConsultaLog();
            telaConsultaLog.start(stage);
        } catch (Exception ex) {
            Logger.getLogger(ControladorTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void sair(ActionEvent event) {

        System.exit(0);

    }
}
