package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.connectivity.ConnectionClass;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField textInsert;
    @FXML
    private Button button;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user = new User();



    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    public void onClickInsert(){

        ConnectionClass connectionClass= new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        System.out.println("Pripojene");



    }



}
