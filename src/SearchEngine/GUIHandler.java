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

    //variables
    JPanel searchTerms = new JPanel();
    JPanel searchBar = new JPanel();
    ButtonGroup choice = new ButtonGroup();
    JPanel crimes = new JPanel();
    JComboBox crimeTypes;
    String[] options = {"Choose a type", "Anti-social behaviour", "Bicycle theft", "Burglary", "Criminal damage and arson", "Drugs", "Other crime", "Other theft", "Possession of weapons", "Public order", "Robbery", "Shoplifting", "Theft from the person", "Vehicle crime", "Violence and sexual offences"};
    JTable resultsTable = null;
    JScrollPane tableScrollPane = new JScrollPane(resultsTable);
    JPanel searchButtonPanel = new JPanel();

    private GUIHandler getme() {
        return this;
    }

    public GUIHandler() {
        super("Crime Search Engine");
        setSize(820, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchTerms.setLayout(new BoxLayout(searchTerms, BoxLayout.PAGE_AXIS));
        searchButtonPanel.setLayout(new BoxLayout(searchButtonPanel, BoxLayout.PAGE_AXIS));
        JRadioButton longLat = new JRadioButton("Long/Lat");
        searchTerms.add(longLat);
        choice.add(longLat);
        JRadioButton lsoa = new JRadioButton("LSOA");
        searchTerms.add(lsoa);
        choice.add(lsoa);
        JRadioButton crimeType = new JRadioButton("Crime Type");
        searchTerms.add(crimeType);
        choice.add(crimeType);
        JLabel searchBar1Label = new JLabel();
        JTextField search = new JTextField("Click a button to select search");
        search.setColumns(50);
        searchBar.add(searchBar1Label);
        searchBar.add(search);
        search.setMinimumSize(new Dimension(50, 25));
        search.setPreferredSize(new Dimension(50, 25));
        search.setVisible(true);
        JLabel searchBar2Label = new JLabel();
        JTextField search2 = new JTextField();
        search2.setColumns(50);
        searchBar.add(searchBar2Label);
        searchBar.add(search2);
        search2.setMinimumSize(new Dimension(50, 25));
        search2.setPreferredSize(new Dimension(50, 25));
        search2.setVisible(false);

        crimeTypes = new JComboBox(options);
        crimeTypes.setPreferredSize(new Dimension(250, 50));
        crimeTypes.setVisible(false);
        crimes.add(crimeTypes);

        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 25));
        searchButtonPanel.add(searchButton);

        JLabel qcLabel = new JLabel("Quality Check");
        qcLabel.setPreferredSize(new Dimension(100, 25));
        searchButtonPanel.add(qcLabel);

        JButton qcNoCrimeID = new JButton("No ID");
        qcNoCrimeID.setPreferredSize(new Dimension(100, 25));
        searchButtonPanel.add(qcNoCrimeID);

        JButton qcDupCrimeID = new JButton("Dupe ID");
        qcDupCrimeID.setPreferredSize(new Dimension(100, 25));
        searchButtonPanel.add(qcDupCrimeID);

        getContentPane().add(searchTerms, BorderLayout.WEST);
        getContentPane().add(searchBar, BorderLayout.CENTER);
        getContentPane().add(crimes, BorderLayout.NORTH);
        getContentPane().add(tableScrollPane, BorderLayout.SOUTH);
        getContentPane().add(searchButtonPanel, BorderLayout.EAST);

        longLat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search.setText("");
                searchBar1Label.setText("Longitude:");
                searchBar1Label.setVisible(true);
                search.setVisible(true);
                searchBar2Label.setText("Latitude:");
                searchBar2Label.setVisible(true);
                search2.setVisible(true);
                crimeTypes.setVisible(false);
            }

        });

        lsoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search.setText("");
                searchBar1Label.setText("LSOA Name:");
                searchBar1Label.setVisible(true);
                search.setVisible(true);
                searchBar2Label.setVisible(false);
                search2.setVisible(false);
                crimeTypes.setVisible(false);

            }

        });

        crimeType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBar1Label.setVisible(false);
                search.setVisible(false);
                searchBar2Label.setVisible(false);
                search2.setVisible(false);
                crimeTypes.setVisible(true);
            }

        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //do stuff
            GUIImplementation gui = new GUIImplementation();
            String activeButton = null;
              if(longLat.isSelected()){
               resultsTable = gui.longLatSearch(search.getText(), search2.getText());
               resultsTable.setVisible(true);
              }  
              else if(lsoa.isSelected()){
               resultsTable = gui.lsoaSearch(search.getText());
               resultsTable.setVisible(true);
              }
              if(crimeType.isSelected()){
               resultsTable = gui.crimeTypeSearch(crimeTypes.getSelectedItem().toString());
               resultsTable.setVisible(true);
              }
                    
            }

        });

        qcNoCrimeID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //do stuff
            }

        });
        qcDupCrimeID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //do stuff
            }

        });

    }

    //doesnt work until data passed into it.
    /* public JTable createTable( data ){
        JTable table = new JTable(Object[][] rowData, Object[] columnNames);
        return table;
    }
     */
    private GUIImplementation gui = new GUIImplementation();

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
