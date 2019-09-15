package tela.controlador;

import Gerenciador.GeradorID;
import Log.GerenciadorLog;
import Log.Log;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import tela.model.TableLog;


public class ControladorCosultaLog implements Initializable {

   @FXML
    private TableView<TableLog> tblSessao;

    @FXML
    private TableColumn<TableLog, String> cId;

    @FXML
    private TableColumn<TableLog, String> cLocal;

    @FXML
    private TableColumn<TableLog, String> cUsuario;

    @FXML
    private TableColumn<TableLog, String> cOperacao;

    @FXML
    private TableColumn<TableLog, String> cErro;

    @FXML
    private TableColumn<TableLog, String> cDataHora;

   

    private List<Log> listaDeLog = null;

    private ObservableList<TableLog> obsLog = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencherTabela();
    }

    public void setListaLog() {
        try {
            
            listaDeLog = GerenciadorLog.getInstancia().recuperarLogs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void preencherTabela() {

        if (!(obsLog.isEmpty())) {
            obsLog.clear();
        }
        setListaLog();
        int cont = -1;
        for (Log log : listaDeLog) {
            cont++;


                TableLog ts = new TableLog(String.valueOf(log.getId()), log.getLocal(), log.getNomeUsuario(), log.getOperacao(), log.getErro(), log.getDataHora());

                obsLog.add(ts);
        }
        
        
        cId.setCellFactory(TextFieldTableCell.forTableColumn());
        cId.setCellValueFactory(new PropertyValueFactory<TableLog, String>("id"));

        cLocal.setCellFactory(TextFieldTableCell.forTableColumn());
        cLocal.setCellValueFactory(new PropertyValueFactory<TableLog, String>("local"));

        cUsuario.setCellFactory(TextFieldTableCell.forTableColumn());
        cUsuario.setCellValueFactory(new PropertyValueFactory<TableLog, String>("nomeUsuario"));

        cOperacao.setCellFactory(TextFieldTableCell.forTableColumn());
        cOperacao.setCellValueFactory(new PropertyValueFactory<TableLog, String>("operacao"));

        cErro.setCellFactory(TextFieldTableCell.forTableColumn());
        cErro.setCellValueFactory(new PropertyValueFactory<TableLog, String>("erro"));
        
         cDataHora.setCellFactory(TextFieldTableCell.forTableColumn());
        cDataHora.setCellValueFactory(new PropertyValueFactory<TableLog, String>("dataHora"));
        
        tblSessao.setItems(obsLog);

    }

}
