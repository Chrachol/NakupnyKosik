package sample.Hl_stranka;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Controller;
import sample.Entity.NakupnyKosik;
import sample.connectivity.ConnectionClass;
import sample.login.KosikInfController;
import sample.login.VytvaranieKosikaController;

import javax.swing.table.TableColumn;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.util.*;

public class Hl_str extends Controller implements Initializable {

   /* ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();*/

    @FXML
    private Button btn;

    @FXML
    private Button kys;

    @FXML
    private Pane shape;

    @FXML
    private Text text;

    @FXML
    private ListView<String> lv_nakupneKosiky;

    @FXML
    private TableColumn C1;

    public static List<NakupnyKosik> nakupneKosiky = new LinkedList<>();

    int pdm = 1;

    public void click() {
        if (pdm == 1) {
            TranslateTransition tt = new TranslateTransition(Duration.millis(250), shape);
            tt.setByX(233);
            tt.setAutoReverse(true);

            tt.play();
            pdm--;
        }
        else {
            TranslateTransition tt = new TranslateTransition(Duration.millis(250), shape);
            tt.setByX(-233);
            tt.setAutoReverse(true);

            tt.play();
            pdm++;

        }
    }

    public void btn_OpenPridajKosikWindow() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../login/VytvaranieKosika.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            VytvaranieKosikaController controller = loader.getController();
            controller.setCaller(this);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void PridajNakupnyKosik(NakupnyKosik nk) {
        nakupneKosiky.add(nk);
        lv_nakupneKosiky.getItems().clear();
        String[] tmp = new String[nakupneKosiky.size()];
        for (int i = 0; i < nakupneKosiky.size(); i++) {
            tmp[i] = "Kosik '" + nakupneKosiky.get(i).getNazovKos() + "' s " + nakupneKosiky.get(i).getPolozkyVKosiku().size() + " polozkami";
        }
        lv_nakupneKosiky.getItems().addAll(tmp);
    }

    @FXML
    public void btnInfoOKosiku(){

    }

    final Hl_str caller = this;

    public void LogOut() throws IOException {

        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream("Save.kosiky",false);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(nakupneKosiky);
        objectOutputStream.close();

        Stage stage = (Stage) shape.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../login/login.fxml"));
        Parent root = loader.load();


        Scene scene = new Scene(root);

        stage.setTitle("Main Page");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void deleteKosik(NakupnyKosik nakupnyKosik){
        nakupneKosiky.remove(nakupnyKosik);
        lv_nakupneKosiky.getItems().clear();
        String[] tmp = new String[nakupneKosiky.size()];
        for (int i = 0; i < nakupneKosiky.size(); i++) {
            tmp[i] = "Kosik '" + nakupneKosiky.get(i).getNazovKos() + "' s " + nakupneKosiky.get(i).getPolozkyVKosiku().size() + " polozkami";
        }
        lv_nakupneKosiky.getItems().addAll(tmp);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(()->{
            text.setText(getUser().getUsername());
        });

        lv_nakupneKosiky.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               // System.out.println("Otvorime nove okno s kosikom "+lv_nakupneKosiky.getSelectionModel().getSelectedItem());
                String stlacenyRiadok = lv_nakupneKosiky.getSelectionModel().getSelectedItem().split("'")[1];
                NakupnyKosik tmp = null;
                for (NakupnyKosik n :
                        nakupneKosiky) {
                    if (n.getNazovKos().equals(stlacenyRiadok)){
                        tmp = n;
                    }
                }
                System.out.println(stlacenyRiadok);
                if (tmp == null)
                    return;

                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../login/KosikInf.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                KosikInfController controller = loader.getController();
                controller.setNakupnyKosik(tmp);

                controller.setCaller(caller);


                stage.setTitle("Main Page");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            }
        });
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("Save.kosiky");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            nakupneKosiky = (List<NakupnyKosik>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lv_nakupneKosiky.getItems().clear();
        String[] tmp = new String[nakupneKosiky.size()];
        for (int i = 0; i < nakupneKosiky.size(); i++) {
            tmp[i] = "Kosik '" + nakupneKosiky.get(i).getNazovKos() + "' s " + nakupneKosiky.get(i).getPolozkyVKosiku().size() + " polozkami";
        }
        lv_nakupneKosiky.getItems().addAll(tmp);

    }
}
