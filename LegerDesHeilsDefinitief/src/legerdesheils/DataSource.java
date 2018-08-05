/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Raoul Pragt
 */
public class DataSource {

    /**
     * A simple data source for getting database connections.
*
     */

    private static String url;

    /**
     * Initializes the data source.
     *
     * @param fileName the name of the property file that contains the database driver, URL, username, and password source: BJLO modified by W. Pijnacker Hordijk
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    //Code uit DemoDB 8 & 13 met toevoeging van integratedSecurity voor Windows Authentication
    public static void init(String fileName)
            throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(fileName);

        Properties props = new Properties();
        props.load(in);

        url = props.getProperty("jdbc.url");
        url = url + ";integratedSecurity=true";

        String driver = props.getProperty("jdbc.driver");
        if (driver != null) {
            Class.forName(driver);  // load the specified JDBC-driver
        }
    }

    /**
     * Gets a connection to the database.
     *
     * @return the database connection
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
