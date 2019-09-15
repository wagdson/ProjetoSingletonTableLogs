/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela.controlador;

import Complementares.CapData;
import Gerenciador.GeradorID;
import Log.GerenciadorLog;
import Log.Log;
import classes.Usuario;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import persistencias.UsuarioDAO;
import tela.model.Permissao;

public class ControladorCadastroUsuario implements Initializable {

    private static String arquivoUsuario = "D:\\Faculdade\\3 semestre\\Padrão de Projetos\\Projetos\\Padrao Singleton\\TelaControleAcesso\\src\\arquivosDados\\ArquivoUsuario";

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUsuario;

    @FXML
    private Button btnIncluir;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnExcluir;

    @FXML
    private TextField txtCPF;

       @FXML
    private Button btnAlterar;

    @FXML
    private ComboBox<Permissao> cbxPermissao;
    @FXML
    private List<Permissao> listaPermissao = new ArrayList<>();

    @FXML
    private ObservableList<Permissao> obsPermissao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        preencherCbxPermissao();
    }

    public void preencherCbxPermissao() {
        //Permissao vario = new Permissao(0, "");
        Permissao admin = new Permissao(1, "Admin");
        Permissao cadastro = new Permissao(2, "Cadastro");
        Permissao outros = new Permissao(3, "Outros");

        listaPermissao.add(admin);
        listaPermissao.add(cadastro);
        listaPermissao.add(outros);

        obsPermissao = FXCollections.observableArrayList(listaPermissao);

        cbxPermissao.setItems(obsPermissao);

    }

    public void limparTela() {
        txtCPF.setText("");
        txtNome.setText("");
        txtSenha.setText("");
        txtUsuario.setText("");
        cbxPermissao.selectionModelProperty().get().clearSelection();
    }

        @FXML
    void alterar() throws Exception {
    
        try {
            Permissao c = cbxPermissao.getSelectionModel().getSelectedItem();
            Usuario user = new Usuario(txtNome.getText(), Long.parseLong(txtCPF.getText()), txtUsuario.getText(), txtSenha.getText(), c.getPermissao());
            UsuarioDAO userDAO = new UsuarioDAO(arquivoUsuario);
            userDAO.alterar(user);
            limparTela();
            GeradorID gerador = new GeradorID();
            CapData data = new CapData();
            Log log = new Log(gerador.geraIDSessao(), "tbl Usuário", System.getProperty("login"), "Update", "", data.capturarData());
            GerenciadorLog.getInstancia().capturarLogs(log);
        } catch (Exception erro) {
            GeradorID gerador = new GeradorID();
            CapData data = new CapData();
            Log log = new Log(gerador.geraIDSessao(), "tbl Usuário", System.getProperty("login"), "Tentativa Update", erro.getMessage(), data.capturarData());
            GerenciadorLog.getInstancia().capturarLogs(log);
            JOptionPane.showMessageDialog(null, erro.getMessage());

        }
    }

    @FXML
    void buscar() {
        try {

            UsuarioDAO userDAO = new UsuarioDAO(arquivoUsuario);
            Usuario user = userDAO.buscar(txtUsuario.getText());
            txtCPF.setText(user.getCPF() + "");
            txtNome.setText(user.getNome());
            txtUsuario.setText(user.getNomeUsuario());
            txtSenha.setText(user.getSenha());

            Permissao p = new Permissao(5, user.getPermissao());
            cbxPermissao.getSelectionModel().select(p);

            GeradorID geradorID = new GeradorID();
            int id = geradorID.geraIDSessao();
            CapData cp = new CapData();
            Log log = new Log(id, "Tbl Usúario", System.getProperty("login"), "Select", "", cp.capturarData());
            GerenciadorLog.getInstancia().capturarLogs(log);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    void excluir() {
        try {

            UsuarioDAO userDAO = new UsuarioDAO(arquivoUsuario);
            userDAO.excluir(txtUsuario.getText());
            limparTela();
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }

    @FXML
    void incluirUsuario() throws Exception {
        try {
            Permissao c = cbxPermissao.getSelectionModel().getSelectedItem();
            Usuario user = new Usuario(txtNome.getText(), Long.parseLong(txtCPF.getText()), txtUsuario.getText(), txtSenha.getText(), c.getPermissao());
            UsuarioDAO userDAO = new UsuarioDAO(arquivoUsuario);
            userDAO.incluir(user);
            limparTela();
            JOptionPane.showMessageDialog(null, "Usuario criado com sucesso!");
        } catch (Exception erro) {
            GeradorID gerador = new GeradorID();
            CapData data = new CapData();
            Log log = new Log(gerador.geraIDSessao(), "tbl Usuário", System.getProperty("login"), "Tentativa Insert", erro.getMessage(), data.capturarData());
            GerenciadorLog.getInstancia().capturarLogs(log);
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }

}
