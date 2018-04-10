/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_simulacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.lang.Integer;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import numero_generado.NumeroGenerado;



/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FX_tp1SimulacionController implements Initializable {

    @FXML
    private ComboBox<?> cmb_metodos;
    
    ObservableList items = FXCollections.observableArrayList("Método Congrencial Mixto", "Método Congrencial Multiplicativo");
    @FXML
    private TextField tf_semilla;
    @FXML
    private TextField tf_modulo;
    @FXML
    private TextField tf_ctemult;
    @FXML
    private TextField tf_cteadi;
    @FXML
    private Label lbl_semilla;
    @FXML
    private Label lbl_modulo;
    @FXML
    private Label lbl_ctemult;
    @FXML
    private Label lbl_cteadi;
    @FXML
    private Button btn_ejecutar;
    @FXML
    private TableColumn colValor;
    @FXML
    private TableColumn colN;
    @FXML
    private TableView<NumeroGenerado> tablaMetodo;
    
    ObservableList<NumeroGenerado> numero;
    
    private int n;
    @FXML
    private Button btn_nuevo;
    @FXML
    private Button btn_siguiente;
    @FXML
    private ComboBox<?> cb_metodo;
    @FXML
    private TextField tf_elementos;
    @FXML
    private TextField tf_intervalos;
    @FXML
    private TableColumn col1;
    @FXML
    private TableColumn col2;
    @FXML
    private Button bt_ejecutarChi;
    @FXML
    private Label lbl_intervalos;
    @FXML
    private Label lbl_elementos;
    @FXML
    private Label lbl_metodo;
    @FXML
    @FXML
    private void seleccionarMetodo(ActionEvent event)
    {
        if(cmb_metodos.getValue()=="Método Congrencial Mixto")
        {
            tf_semilla.setDisable(false);
            lbl_semilla.setDisable(false);
            tf_modulo.setDisable(false);
            lbl_modulo.setDisable(false);
            tf_ctemult.setDisable(false);
            lbl_ctemult.setDisable(false);
            tf_cteadi.setDisable(false);
            lbl_cteadi.setDisable(false);
            
            tf_semilla.clear();
            tf_modulo.clear();
            tf_ctemult.clear();
            tf_cteadi.clear();
           
        }
        else
        {
            tf_semilla.setDisable(false);
            lbl_semilla.setDisable(false);
            tf_modulo.setDisable(false);
            lbl_modulo.setDisable(false);
            tf_ctemult.setDisable(false);
            lbl_ctemult.setDisable(false);
            tf_cteadi.setDisable(true);
            lbl_cteadi.setDisable(true);
            
            tf_semilla.clear();
            tf_modulo.clear();
            tf_ctemult.clear();
            tf_cteadi.clear();
        }
    }
    
    @FXML 
    private void accionNuevo(ActionEvent event)
    {
        btn_ejecutar.setDisable(false);
        
        tablaMetodo.getItems().remove(0, tablaMetodo.getItems().size());
        
        tf_semilla.clear();
        tf_modulo.clear();
        tf_ctemult.clear();
        tf_cteadi.clear();
        
    }
    @FXML
    private void ejecutarMetodo(ActionEvent event) throws IOException
    {
        double[] v = new double [200000];
        if (cmb_metodos.getValue()=="Método Congrencial Multiplicativo"){
            
            v = generadorMCMu(Integer.parseInt(tf_semilla.getText()), Integer.parseInt(tf_ctemult.getText()), Integer.parseInt(tf_modulo.getText()), 200000);
        }
        else
        {
            v = generadorMCM(Integer.parseInt(tf_semilla.getText()), Integer.parseInt(tf_ctemult.getText()), Integer.parseInt(tf_cteadi.getText()), Integer.parseInt(tf_modulo.getText()), 200000);
        }
        for (int i = 0; i < 200000; i++) {
            NumeroGenerado num = new NumeroGenerado(i+1, v[i]);
            numero.add(num);
        }
        btn_ejecutar.setDisable(true);
        
    }
   public static double[] generadorMCM(int x0, int a, int c, int mod, int n){
        
        double x1 = ((a * x0) + c) % mod;
        double[] vector;
        vector = new double [n];
        double r; 
        r = x1 /(mod);//se saca el menos uno para que no incluya el 1 
        vector[0]= r; 
        for (int i = 1 ; i <n ; i++) {

            x1 = ((a * x1)+ c ) % mod;
    
            r = x1 /(mod); // se saca el menos uno para que no incluya el 1
            
            vector[i]= r; 
        }
        
        
        return vector;
    }
    public static double[] generadorMCMu(int x0, int a, int mod, int n){
        
        double x1 = (a * x0) % mod;
        double[] vector;
        vector = new double [n];
        double r; 
        r = x1 /(mod);//se saca el menos uno para que no incluya el 1 
        vector[0]= r; 
        for (int i = 1 ; i <n ; i++) {

            x1 = (a * x1) % mod;
    
            r = x1 /(mod); // se saca el menos uno para que no incluya el 1
            
            vector[i]= r; 
        }
        
        
        return vector;
    }
    
    private final ListChangeListener<NumeroGenerado> selectorTablaMetodo = new ListChangeListener<NumeroGenerado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends NumeroGenerado> c) {
             //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmb_metodos.setItems(items);
        colN.setCellValueFactory(new PropertyValueFactory<NumeroGenerado, Integer>("n"));
        colValor.setCellValueFactory(new PropertyValueFactory<NumeroGenerado, Double>("valor"));
        numero = FXCollections.observableArrayList();
        tablaMetodo.setItems(numero);
        
        final ObservableList<NumeroGenerado> tablaMetodoSel = tablaMetodo.getSelectionModel().getSelectedItems();
        tablaMetodoSel.addListener(selectorTablaMetodo);
        
    }    

    @FXML
    private void accionSiguiente(ActionEvent event) {
        int index = tablaMetodo.getItems().size();
        double lastR= (double)colValor.getCellData(index-1);
        double semilla = lastR*Double.parseDouble(tf_modulo.getText());
        double xsig=0.0;
        double r=0.0;
        if (cmb_metodos.getValue()=="Método Congrencial Multiplicativo"){ 
            xsig = ( Integer.parseInt(tf_ctemult.getText()) * semilla) % Integer.parseInt(tf_modulo.getText()); 
            r= xsig/Integer.parseInt(tf_modulo.getText());
        }
        else
        {
            xsig = (( Integer.parseInt(tf_ctemult.getText()) * semilla) + Integer.parseInt(tf_cteadi.getText())) % Integer.parseInt(tf_modulo.getText()); 
            r= xsig/Integer.parseInt(tf_modulo.getText());
        }
        NumeroGenerado num = new NumeroGenerado((int)colN.getCellData(index-1)+1, r);
        numero.add(num);
    }

}
