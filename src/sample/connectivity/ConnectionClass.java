package sample.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public Connection connection;

    public Connection getConnection(){

        String dbName="nakup_k";
        String userName="root";
        String password="";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nakup_k?serverTimezone=Europe/Bratislava",userName,password);

        }catch (Exception e){
            e.printStackTrace();
        }


        return connection;
    }

        private static final String USERNAME = "";

        private static final String PASSWORD = "";

        private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";

        private static final String URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Users\\jety2\\Desktop\\Zadanie.accdb;}";

        public static void AccConnection(String[] args) throws Exception {

            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Serus accdb");

            connection.close();
        }
    }



