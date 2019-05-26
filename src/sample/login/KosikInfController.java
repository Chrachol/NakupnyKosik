package sample.login;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Entity.NakupnyKosik;
import sample.Entity.PolozkaVKosiku;
import sample.Hl_stranka.Hl_str;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class KosikInfController implements Initializable {

    @FXML
    private Text t_Nazov;

    @FXML
    private ListView<String> lv_Polozky;

    public sample.Entity.NakupnyKosik getNakupnyKosik() {
        return NakupnyKosik;
    }

    public void setNakupnyKosik(sample.Entity.NakupnyKosik nakupnyKosik) {
        NakupnyKosik = nakupnyKosik;
    }

    private NakupnyKosik NakupnyKosik;

    @FXML
    public void btn_Delete() {
        caller.deleteKosik(NakupnyKosik);
        btn_Exit();
    }

    @FXML
    public void btn_Exit() {
        Stage stage = (Stage) t_Nazov.getScene().getWindow();
        stage.close();
    }

    private Hl_str caller;

    public void setCaller(Hl_str caller){
        this.caller = caller;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(()->{
            String[] polozky = new String[NakupnyKosik.getPolozkyVKosiku().size()];

            for (int i = 0; i < polozky.length; i++) {
                polozky[i] = NakupnyKosik.getPolozkyVKosiku().get(i).getNazovPol() + " " + NakupnyKosik.getPolozkyVKosiku().get(i).getPocet() + "x";
            }
            lv_Polozky.getItems().setAll(polozky);
            t_Nazov.setText(NakupnyKosik.getNazovKos());
        });
    }
}


