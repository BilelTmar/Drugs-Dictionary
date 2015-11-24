/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tmar bilel
 */
public class Drugs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/rxnorm"; // a JDBC url
            String username = "root";
            String password = "";
            FileWriter ffw;
            try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
                File ff = new File("C:\\Users\\Tmar bilel\\Desktop\\drugs.txt"); // définir l'arborescence
                ff.createNewFile();
                ffw = new FileWriter(ff);
                try (Statement stat = (Statement) connection.createStatement(); ResultSet resultat = stat.executeQuery("SELECT * FROM RXNCONSO WHERE SAB = \"RXNORM\" AND TTY = \"BN\"")) {
                    while (resultat.next()) {
                        System.out.println(resultat.getString("str"));
                        ffw.write(resultat.getString("str"));
                        ffw.write("\n");
                        
                    }                  }
            } // définir l'arborescence // définir l'arborescence
            ffw.close(); 

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | IOException ex) {

            System.out.println(ex.toString());
        }
    }

}
