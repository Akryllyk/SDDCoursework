package SearchEngine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arvmayes
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIHandler extends JFrame implements ActionListener {

    private GUIHandler getme() {
        return this;
    }

    public GUIHandler() {
        super("Crime Search Engine");
        setSize(820, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchTerms.setLayout(new BoxLayout(searchTerms, BoxLayout.PAGE_AXIS));
        setSearchTerms();
        setTitleBar();
        getContentPane().add(titleBar, BorderLayout.NORTH);
        getContentPane().add(searchTerms, BorderLayout.WEST);
        
    }
    JPanel searchTerms = new JPanel();
    JPanel titleBar = new JPanel();

    public void setSearchTerms() {
        JRadioButton but1 = new JRadioButton("Long/Lat");
        searchTerms.add(but1);
        JRadioButton but2 = new JRadioButton("LSOA");
        searchTerms.add(but2);
        JRadioButton but3 = new JRadioButton("Crime");
        searchTerms.add(but3);
    }

    public void setTitleBar(){
        JLabel title = new JLabel("Crime Stats Search Engine");
        titleBar.add(title);
    }
    private GUIImplementation gui = new GUIImplementation();

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
