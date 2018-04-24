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
        setSearchTerms();
        getContentPane().add(searchTerms, BorderLayout.WEST);
    }
    JPanel searchTerms = new JPanel();

    public void setSearchTerms() {

        JLabel longLatLabel = new JLabel("Long/Lat");
        searchTerms.add(longLatLabel);
        JRadioButton but1 = new JRadioButton();
        searchTerms.add(but1);
    }

    private GUIImplementation gui = new GUIImplementation();

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
