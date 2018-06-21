import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class DBHepler {

    private Connection conn;
    private PreparedStatement pstmt;

    public DBHepler(String schemaName, String propertiesPath) {
        // initialize
        Properties properties = new Properties();
        try(Reader reader = Files.newBufferedReader(Paths.get(propertiesPath))) {
            properties.load(reader);

            // DB configuration
            String DB_DRIVER = properties.getProperty("DB_DRIVER");

            // Option(): &serverTimezone=GMT
            String DB_URL = properties.getProperty("DB_URL");
            String DB_URL_CONFIG = properties.getProperty("DB_URL_CONFIG");
            String DB_USER = properties.getProperty("DB_USER");
            String DB_PWD = properties.getProperty("DB_PWD");

            connectRemoteMachine(propertiesPath);

            if (schemaName == null) {
                throw new IllegalArgumentException();
            }

            System.out.println("DB demo");
            // load DB driver
            Class.forName(DB_DRIVER);
            System.out.println("Connecting.....");
            String curUrl = DB_URL + schemaName + DB_URL_CONFIG;
            conn = DriverManager.getConnection(curUrl, DB_USER, DB_PWD);
            System.out.println("Succeed");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public PreparedStatement prepareStatement(String sql) {
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }


    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void connectRemoteMachine(String propertiesPath) {
        Properties properties = new Properties();
        try(Reader reader = Files.newBufferedReader(Paths.get(propertiesPath))) {
            properties.load(reader);

            String HOST = properties.getProperty("HOST");
            int PORT = Integer.valueOf(properties.getProperty("PORT"));
            String USER = properties.getProperty("USER");
            String PWD = properties.getProperty("PWD");

            int LOCAL_PORT = Integer.valueOf(properties.getProperty("LOCAL_PORT"));
            // remote DB
            String RM_HOST = properties.getProperty("RM_HOST");
            int RM_PORT = Integer.valueOf(properties.getProperty("RM_PORT"));


            JSch jsch = new JSch();

            // Step1: connect host
            Session session = jsch.getSession(USER, HOST, PORT);
            session.setPassword(PWD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            // Step2: connect local with remote DB
            int assignedPort = session.setPortForwardingL(LOCAL_PORT, RM_HOST, RM_PORT);
            System.out.println("LocalHost: " + assignedPort + " " + "->" + RM_HOST + " " + RM_PORT);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
