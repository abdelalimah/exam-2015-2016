package org.mql.java.models;

import org.mql.java.threads.TableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SwingPrinter extends JFrame implements Runnable {

    private JTable table;
    private TableModel tm;

    public SwingPrinter(){

        //tm = new TableModel();
        table = new JTable();

        table.setModel(new DefaultTableModel(new Object[][]{{"id","nom","prenom"}},new String[]{"blah"}));

        add(table);

        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    void addElement(String value){
        tm.setValueAt(value,0,0);
        System.out.println(tm.getColumnCount());
        table.repaint();
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        new SwingPrinter();
    }

}
