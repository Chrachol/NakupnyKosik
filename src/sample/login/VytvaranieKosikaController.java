package sample.login;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Entity.NakupnyKosik;
import sample.Entity.PolozkaVKosiku;
import sample.Hl_stranka.Hl_str;
import java.net.URL;
import java.util.*;

public class VytvaranieKosikaController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField tf_MenoKosika;

    @FXML
    private TextField tf_NazovPolozky;

    @FXML
    private TextField tf_Pocet;

    @FXML
    private ListView <String> lv_Polozky;

    public void setCaller(Hl_str caller) {
        Caller = caller;
    }

    private Hl_str Caller;

    private List<PolozkaVKosiku> polozkyVKosiku = new LinkedList<>();

   public void btn_VytvoritKosik() {
       String NazovKosiku = tf_MenoKosika.getText();
       NazovKosiku+=najCena;
       boolean Uz_existuje = false;
       for (NakupnyKosik n :
               Hl_str.nakupneKosiky) {
           if (n.getNazovKos().equals(NazovKosiku)){
               Uz_existuje = true;
           }
       }
       if (Uz_existuje) {
           Alert a = new Alert(Alert.AlertType.WARNING);
           a.setTitle("Warovanie");
           a.setHeaderText(null);
           a.setContentText("Máš rovnaké meno s nejakým košíkom !");
           a.show();
           return;
       }
       NakupnyKosik nk = new NakupnyKosik(NazovKosiku,polozkyVKosiku);
       Caller.PridajNakupnyKosik(nk);
       Stage stage = (Stage) tf_MenoKosika.getScene().getWindow();
       stage.close();
    }
    public float kaufland;
    public float tesco;
    public float lidl;
    public String najCena="";
    public void btn_PridatPolozku() {
        String Nazov = tf_NazovPolozky.getText();
        tf_NazovPolozky.clear();
        int Pocet;
        switch (Nazov.toLowerCase()){
            case "vysočina saláma" : Pocet=1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.47);
                kaufland+=(Pocet*0.50);
                lidl+=(Pocet*0.52);
                break;

            case "slanina" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.47);
                kaufland+=(Pocet*0.50);
                lidl+=(Pocet*0.52);
                break;

            case "kurča" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.59);
                kaufland+=(Pocet*1.63);
                lidl+=(Pocet*1.59);
                break;
            case "bravčová hruď" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*3.29);
                kaufland+=(Pocet*3.39);
                lidl+=(Pocet*3.35);
                break;
            case "bravčové karé" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*4.19);
                kaufland+=(Pocet*4.10);
                lidl+=(Pocet*4.20);
                break;
            case "klobása" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, počet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.99);
                kaufland+=(Pocet*2);
                lidl+=(Pocet*2.05);
                break;
            case "bôčik" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*5.29);
                kaufland+=(Pocet*5.18);
                lidl+=(Pocet*5.19);
                break;
            case "stehno" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*7.99);
                kaufland+=(Pocet*7.99);
                lidl+=(Pocet*8);
                break;
            case "párky" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.29);
                kaufland+=(Pocet*1.35);
                lidl+=(Pocet*1.35);
                break;
            case "pikantná saláma" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*3.19);
                kaufland+=(Pocet*2.99);
                lidl+=(Pocet*3);
                break;
            case "šunková saláma" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.35);
                kaufland+=(Pocet*0.4);
                lidl+=(Pocet*0.4);
                break;
            case "morčacia šunka" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.55);
                kaufland+=(Pocet*0.56);
                lidl+=(Pocet*0.49);
                break;
            case "paradajky" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.29);
                kaufland+=(Pocet*1.35);
                lidl+=(Pocet*1.22);
                break;
            case "biele hrozno" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.99);
                kaufland+=(Pocet*2.05);
                lidl+=(Pocet*2.00);
                break;
            case "ananás" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.79);
                kaufland+=(Pocet*1.99);
                lidl+=(Pocet*1.69);
                break;
            case "cibuľka lahôdková" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.35);
                kaufland+=(Pocet*0.36);
                lidl+=(Pocet*0.36);
                break;
            case "hrušky" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.79);
                kaufland+=(Pocet*0.75);
                lidl+=(Pocet*0.78);
                break;
            case "biela kapusta" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.89);
                kaufland+=(Pocet*0.93);
                lidl+=(Pocet*0.90);
                break;
            case "dyňa červená" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.99);
                kaufland+=(Pocet*1.00);
                lidl+=(Pocet*0.89);
                break;
            case "ľadový šalát" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.59);
                kaufland+=(Pocet*1.50);
                lidl+=(Pocet*1.51);
                break;
            case "šampiňóny biele" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.59);
                kaufland+=(Pocet*1.60);
                lidl+=(Pocet*1.59);
                break;
            case "ochutený tvaroh" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.99);
                kaufland+=(Pocet*0.88);
                lidl+=(Pocet*0.95);
                break;
            case "zrejúci syr" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.55);
                kaufland+=(Pocet*1.60);
                lidl+=(Pocet*1.52);
                break;
            case "tavený syr" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.45);
                kaufland+=(Pocet*0.45);
                lidl+=(Pocet*0.46);
                break;
            case "mlieko plnotučné" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.85);
                kaufland+=(Pocet*0.83);
                lidl+=(Pocet*0.85);
                break;
            case "karička" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.99);
                kaufland+=(Pocet*1.05);
                lidl+=(Pocet*0.98);
                break;
            case "liptov parenica" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.85);
                kaufland+=(Pocet*0.84);
                lidl+=(Pocet*0.85);
                break;
            case "niva" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.66);
                kaufland+=(Pocet*0.69);
                lidl+=(Pocet*0.66);
                break;
            case "magnum" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*2.49);
                kaufland+=(Pocet*2.49);
                lidl+=(Pocet*2.40);
                break;
            case "donut" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.26);
                kaufland+=(Pocet*0.35);
                lidl+=(Pocet*0.31);
                break;
            case "praclík" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.23);
                kaufland+=(Pocet*0.21);
                lidl+=(Pocet*0.23);
                break;
            case "chlieb tmavý" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.75);
                kaufland+=(Pocet*0.76);
                lidl+=(Pocet*0.70);
                break;
            case "rohlík" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.04);
                kaufland+=(Pocet*0.04);
                lidl+=(Pocet*0.03);
                break;
            case "bon pari" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.55);
                kaufland+=(Pocet*0.49);
                lidl+=(Pocet*0.50);
                break;
            case "sójové rezy" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.22);
                kaufland+=(Pocet*0.23);
                lidl+=(Pocet*0.20);
                break;
            case "miňonky" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.29);
                kaufland+=(Pocet*0.31);
                lidl+=(Pocet*0.30);
                break;
            case "budiš" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.25);
                kaufland+=(Pocet*0.24);
                lidl+=(Pocet*0.25);
                break;
            case "šariš 12%" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.55);
                kaufland+=(Pocet*0.50);
                lidl+=(Pocet*0.53);
                break;
            case "zlatý bažant 12%" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.44);
                kaufland+=(Pocet*0.46);
                lidl+=(Pocet*0.41);
                break;
            case "borec borovička" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*5.99);
                kaufland+=(Pocet*6.00);
                lidl+=(Pocet*6.19);
                break;
            case "rajec" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*0.59);
                kaufland+=(Pocet*0.60);
                lidl+=(Pocet*0.72);
                break;
            case "aviváž lenor" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.49);
                kaufland+=(Pocet*1.40);
                lidl+=(Pocet*1.50);
                break;
            case "vajcia" : Pocet = 1;
                try {
                    Pocet = Integer.parseInt(tf_Pocet.getText());
                }
                catch (Exception e){
                    System.out.println("Chyba, pocet nastavený na 1");
                }
                tf_Pocet.clear();

                lv_Polozky.getItems().add(Nazov.toLowerCase()+" "+Pocet+"x");
                polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));
                tesco+=(Pocet*1.05);
                kaufland+=(Pocet*1.10);
                lidl+=(Pocet*1.04);
                break;


            default:
                System.out.println("kkkkt");


        }
        System.out.println(tesco+" "+lidl+" "+kaufland);



     /*       String Nazov = tf_NazovPolozky.getText().toString();
        tf_NazovPolozky.clear();
        int Pocet=1;
           try {
            Pocet = Integer.parseInt(tf_Pocet.getText());
        }
        catch (Exception e){
            System.out.println("Chyba, pocet nastavený na 1");
        }
        tf_Pocet.clear();

        lv_Polozky.getItems().add(Nazov+" "+Pocet+"x");
        polozkyVKosiku.add(new PolozkaVKosiku(Nazov, Pocet));*/
        if (kaufland<lidl&&kaufland<tesco){
            najCena= "("+kaufland+" v Kauflande)";
        }else if (lidl<kaufland&&lidl<tesco){
            najCena= ("("+lidl+" v Lidli)");
        }else if (tesco<lidl&&tesco<kaufland){
            najCena= ("("+tesco+" v Tescu)");
        }else
            najCena= "("+kaufland+" v Kauflande)";



    }

    @FXML
    private Button b_odstranenie;
    public void btn_OdstranPolozku() {
        if (mazem==false){
            b_odstranenie.setText("Vypni vymazavanie");
            mazem=true;
        }
        else {
            b_odstranenie.setText("Zapni vymazavanie");
            mazem=false;}
    }
    private boolean mazem=false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems();
        lv_Polozky.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (mazem==false){
                    return;
                }
                String stlacenyRiadok = lv_Polozky.getSelectionModel().getSelectedItem().split(" ")[0];
                for(int i=0;i<polozkyVKosiku.size();i++){
                    if (polozkyVKosiku.get(i).getNazovPol().equals(stlacenyRiadok)){
                        polozkyVKosiku.remove(i);
                    }
                }
                String[] tmp=new String[polozkyVKosiku.size()];
                for(int i=0;i<polozkyVKosiku.size();i++){
                    tmp[i]=(polozkyVKosiku.get(i).getNazovPol()+" "+polozkyVKosiku.get(i).getPocet()+"x");
                }
                lv_Polozky.getItems().clear();
                lv_Polozky.getItems().addAll(tmp);
            }
        });
    }
}
