/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Raoul Pragt Gebaseerd op DemoDB 8 & 13 Variabelen Query en JTable toegevoegd
 */
public class PerformQuery {
    
    private static ResultSet res;
    
    public PerformQuery(String query, JTable datatable) {

        String propertiesFile = "MSSQL.properties";

        try {
            DataSource.init(propertiesFile);
            Connection conn = DataSource.getConnection();
            System.out.println("verbinding gemaakt middels " + propertiesFile + "...");

            try {
                Statement stat = conn.createStatement();
                String qryUse = "USE AuditBlackBox;";

                stat.execute(qryUse);
                System.out.println("database gevonden...");

                String qryPrepStat = query;
                PreparedStatement prepStat = conn.prepareStatement(qryPrepStat);

                 res = prepStat.executeQuery();

                // uncomment one of the following two lines
                DisplayTable.setTableSimple(res, datatable);
//                setTable(res, tabel);


            } finally {
                conn.close();
                System.out.println("... verbinding afgesloten.");
            }
        } catch (SQLException e) {
            System.out.println("Fout: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Fout: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Fout: kan " + propertiesFile + " niet openen.");
            JOptionPane.showMessageDialog(null, "Fout: kan " + propertiesFile + " niet openen.");

        } catch (ClassNotFoundException e) {
            System.out.println("Fout: JDBC-driver niet gevonden.");
            JOptionPane.showMessageDialog(null, "Fout: JDBC-driver niet gevonden.");

        }

    }
    
    public ResultSet getResultSet(){
        return this.res;
    }

}
