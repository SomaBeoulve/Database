/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

import java.io.File;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raoul Pragt
 */
//Code uit DemoDB 8 & 13
public class DisplayTable {

    public static void setTableSimple(ResultSet rs, JTable table) throws SQLException {
        try {
            String outputfilename = System.getProperty("user.home") + "/datatabel.csv";
            PrintWriter pw = new PrintWriter(new File(outputfilename));
            StringBuilder sb = new StringBuilder();
            ResultSetMetaData metaData = rs.getMetaData();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.getDataVector().removeAllElements();

            // names of columns
            // Haalt de header uit de tabel en verwerkt deze tegelijk in CSV formaat binnen de gebruikersmap

            Vector<String> columns = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columns.add(metaData.getColumnName(column));
                sb.append(metaData.getColumnName(column));
                if (column != columnCount) {
                    sb.append(',');
                }

            }

            sb.append("\r\n");
                    

            // data of the table
            // Haalt de data uit de tabel en verwerkt deze tegelijk in CSV formaat binnen de gebruikersmap
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                    if (rs.getObject(columnIndex) == null)
                        sb.append(" ");
                                else
                    sb.append(rs.getObject(columnIndex).toString());
                    if (columnIndex != columnCount) {
                        sb.append(',');

                    }

                }

                sb.append("\r\n");
                        
                

                data.add(vector);
            }
            pw.write(sb.toString());
            pw.close();
            table.setModel(new DefaultTableModel(data, columns));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
