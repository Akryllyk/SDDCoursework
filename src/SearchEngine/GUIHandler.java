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
    //global variables
    JPanel searchTerms = new JPanel();
    JPanel titleBar = new JPanel();
    JPanel searchBar = new JPanel();
    ButtonGroup choice = new ButtonGroup();
    
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
        setSearchBar();
        getContentPane().add(titleBar, BorderLayout.NORTH);
        getContentPane().add(searchTerms, BorderLayout.WEST);
        getContentPane().add(searchBar, BorderLayout.CENTER);
        
    }


    public void setSearchTerms() {
        JRadioButton but1 = new JRadioButton("Long/Lat");
        searchTerms.add(but1);
        choice.add(but1);
        JRadioButton but2 = new JRadioButton("LSOA");
        searchTerms.add(but2);
        choice.add(but2);
        JRadioButton but3 = new JRadioButton("Crime");
        searchTerms.add(but3);
        choice.add(but3);
    }

    public void setTitleBar(){
        JLabel title = new JLabel("Crime Stats Search Engine");
        titleBar.add(title);
    }
    
    public void setSearchBar(){
        JLabel searchBar1Label = new JLabel();
        JTextField search = new JTextField();
        search.setColumns(50);
        searchBar.add(searchBar1Label);
        searchBar.add(search);
        JLabel searchBar2Label = new JLabel();
        JTextField search2 = new JTextField();
        search2.setColumns(50);
        searchBar.add(searchBar2Label);
        searchBar.add(search2);
        search.setVisible(false);
        search2.setVisible(false);
        
        
    }
    private GUIImplementation gui = new GUIImplementation();

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
