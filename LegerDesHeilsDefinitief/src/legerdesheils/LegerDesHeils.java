/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Raoul Pragt
 */
public class LegerDesHeils extends JFrame implements ActionListener {

    private JTable datatable = new JTable();
    private JTextField textbox;
    private QueryList querylist = new QueryList();

    //Constructor: Init de screenlayout
    public LegerDesHeils() {

        setTitle("Database Leger Des Heils");

        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        datatable.setFont(new Font("Font", 0, 18));
        

        for (int i = 1; i < 16; i++) {
            JButton query = new JButton();
            query.setText("BR " + i);        //BR = Business Rule
            query.addActionListener(this);
            jp1.add(query);
        }

        textbox = new JTextField(30);
        textbox.setEditable(false);
        textbox.setBackground(Color.white);
        jp1.add(textbox);
        jp2.setLayout(new BorderLayout());
        JScrollPane tableContainer = new JScrollPane(datatable);
        jp2.add(tableContainer, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jp1, jp2);

        splitPane.setEnabled(false);
        getContentPane().add(splitPane);
    }

    //Toon querytitel in bovenste panel
    public void ShowQuery(String title) {

        textbox.setText(title);
    }

    //Main entry point van het programma
    public static void main(String[] args) {

        LegerDesHeils Frame = new LegerDesHeils();
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
        Frame.setExtendedState(Frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    //Behandeld alle knoppen en voert queries uit
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            PerformQuery pq = null;
        if (action.equals("BR 1")) {
            ShowQuery(querylist.getQueryTitle(0));
             pq = new PerformQuery(querylist.getQueryText(0), datatable);
        }
        if (action.equals("BR 2")) {
            ShowQuery(querylist.getQueryTitle(1));
             pq = new PerformQuery(querylist.getQueryText(1), datatable);
        }
        if (action.equals("BR 3")) {
            ShowQuery(querylist.getQueryTitle(2));
             pq = new PerformQuery(querylist.getQueryText(2), datatable);
        }
        if (action.equals("BR 4")) {
            ShowQuery(querylist.getQueryTitle(3));
             pq = new PerformQuery(querylist.getQueryText(3), datatable);
        }
        if (action.equals("BR 5")) {
            ShowQuery(querylist.getQueryTitle(4));
             pq = new PerformQuery(querylist.getQueryText(4), datatable);
        }
        if (action.equals("BR 6")) {
            ShowQuery(querylist.getQueryTitle(5));
             pq = new PerformQuery(querylist.getQueryText(5), datatable);
        }
        if (action.equals("BR 7")) {
            ShowQuery(querylist.getQueryTitle(6));
             pq = new PerformQuery(querylist.getQueryText(6), datatable);
        }
        if (action.equals("BR 8")) {
            ShowQuery(querylist.getQueryTitle(7));
             pq = new PerformQuery(querylist.getQueryText(7), datatable);
        }
        if (action.equals("BR 9")) {
            ShowQuery(querylist.getQueryTitle(8));
             pq = new PerformQuery(querylist.getQueryText(8), datatable);
        }
        if (action.equals("BR 10")) {
            ShowQuery(querylist.getQueryTitle(9));
             pq = new PerformQuery(querylist.getQueryText(9), datatable);
        }
        if (action.equals("BR 11")) {
            ShowQuery(querylist.getQueryTitle(10));
             pq = new PerformQuery(querylist.getQueryText(10), datatable);
        }
        if (action.equals("BR 12")) {
            ShowQuery(querylist.getQueryTitle(11));
             pq = new PerformQuery(querylist.getQueryText(11), datatable);
        }
        if (action.equals("BR 13")) {
            ShowQuery(querylist.getQueryTitle(12));
             pq = new PerformQuery(querylist.getQueryText(12), datatable);
        }
        if (action.equals("BR 14")) {
            ShowQuery(querylist.getQueryTitle(13));
             pq = new PerformQuery(querylist.getQueryText(13), datatable);
        }
        if (action.equals("BR 15")) {
            ShowQuery(querylist.getQueryTitle(14));
             pq = new PerformQuery(querylist.getQueryText(14), datatable);
        }
        
       
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}
