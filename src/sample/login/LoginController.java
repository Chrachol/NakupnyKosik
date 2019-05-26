package sample.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Controller;
import sample.User;
import sample.connectivity.ConnectionClass;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.text.Element;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

public class LoginController extends Controller {
    private static final String encryptionKey           = "ABCDEFGHIJKLMNOP";
    private static final String characterEncoding       = "UTF-8";
    private static final String cipherTransformation    = "AES/CBC/PKCS5PADDING";
    private static final String aesEncryptionAlgorithem = "AES";

    @FXML
    private Pane PPPpane;

    @FXML
    private TextField lRegisterName;

    @FXML
    private TextField lRegisterPassword1;

    @FXML
    private TextField lLoginName;

    @FXML
    private TextField lLoginPassword;

    @FXML
    private TextField lRegisterEmail;

    @FXML
    private TextField lRegisterPassword2;

    @FXML
    private Text lWarrning;

    @FXML
    private Text lWarrningRegister;


    @FXML
    public void login(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("RegistrationFile"));
            String line = br.readLine();
            boolean wrUser = false;
            while(line != null){
                String []udaje = line.split(";");
                if (udaje[0].equals(lLoginName.getText())&&decrypt(udaje[2]).equals(lLoginPassword.getText())){
                    wrUser = true;
                    User user = new User(lLoginName.getText(),udaje[1],lLoginPassword.getText());
                    br.close();
                    try {

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Hl_stranka/sample.fxml"));
                        Parent root = loader.load();
                        Stage stage = new Stage();
                        Controller controller = loader.getController();
                        controller.setUser(user);

                        stage.setTitle("Menu");
                        stage.setScene(new Scene(root, 1080, 720));
                        stage.setResizable(true);
                        stage.show();

                    }catch(IOException e){
                        e.printStackTrace();
                        System.out.println("Nepodarilo sa otvorit scenu!!");
                    }
                    return;
                }
                line = br.readLine();
            }
            if(!wrUser) {
                System.out.println("Uzivatel sa nenasiel.");
            }

            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    public  void register(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("RegistrationFile", true));
            String addUser = (lRegisterName.getText().trim() + ";" + lRegisterEmail.getText().trim() + ";" + encrypt(lRegisterPassword1.getText().trim()));
            User user = new User(lRegisterName.getText().trim(),lRegisterEmail.getText().trim(),lRegisterPassword1.getText().trim());
            bw.write(addUser);
            bw.newLine();
            bw.close();
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../Hl_stranka/sample.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                Controller controller = loader.getController();
                controller.setUser(user);

                stage.setTitle("Menu");
                stage.setScene(new Scene(root, 720, 460));
                stage.setResizable(true);
                stage.show();
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("Nepodarilo sa otvorit scenu!!");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        }

    private String encrypt(String password){
        String encryptedText = "";
        try {
            Cipher cipher   = Cipher.getInstance(cipherTransformation);
            byte[] key      = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);
            byte[] cipherText = cipher.doFinal(password.getBytes("UTF8"));
            Base64.Encoder encoder = Base64.getEncoder();
            encryptedText = encoder.encodeToString(cipherText);
            System.out.println(encryptedText);

        } catch (Exception E) {
            System.err.println("Encrypt Exception : "+E.getMessage());
        }
        return encryptedText;
    }
    private String decrypt(String password) {
        String decryptedText = "";
        try {
            Cipher cipher = Cipher.getInstance(cipherTransformation);
            byte[] key = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(key);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivparameterspec);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] cipherText = decoder.decode(password.getBytes("UTF8"));
            decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");

        } catch (Exception E) {
            System.err.println("decrypt Exception : "+E.getMessage());
        }
        return decryptedText;
    }
}



