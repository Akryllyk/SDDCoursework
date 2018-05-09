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
    ButtonGroup optionChoice = new ButtonGroup();
    JPanel crimes = new JPanel();
    JComboBox crimeTypes;
    String[] options = {"Choose a type", "Anti-social behaviour", "Bicycle theft", "Burglary", "Criminal damage and arson", "Drugs", "Other crime", "Other theft", "Possession of weapons", "Public order", "Robbery", "Shoplifting", "Theft from the person", "Vehicle crime", "Violence and sexual offences"};
    JTable resultsTable = null;
    JScrollPane tableScrollPane = new JScrollPane();
    JPanel searchButtonPanel = new JPanel();

    public GUIHandler getMe() {
        return this;
    }

    public GUIHandler() {
        //setting up the JFrame
        super("Crime Search Engine");
        setSize(820, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Box Layouts
        searchTerms.setLayout(new BoxLayout(searchTerms, BoxLayout.PAGE_AXIS));
        searchButtonPanel.setLayout(new BoxLayout(searchButtonPanel, BoxLayout.PAGE_AXIS));

        //radio buttons
        JRadioButton longLat = new JRadioButton("Long/Lat");
        searchTerms.add(longLat);
        choice.add(longLat);
        JRadioButton lsoa = new JRadioButton("LSOA");
        searchTerms.add(lsoa);
        choice.add(lsoa);
        JRadioButton crimeType = new JRadioButton("Crime Type");
        searchTerms.add(crimeType);
        choice.add(crimeType);
        JRadioButton ascend = new JRadioButton("Ascending");
        searchTerms.add(ascend);
        optionChoice.add(ascend);
        JRadioButton descend = new JRadioButton("Descending");
        searchTerms.add(descend);
        optionChoice.add(descend);

        //search bars
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

        //crime types combo box
        crimeTypes = new JComboBox(options);
        crimeTypes.setPreferredSize(new Dimension(250, 50));
        crimeTypes.setVisible(false);
        crimes.add(crimeTypes);

        //action buttons
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

        //setting things into place.
        getContentPane().add(searchTerms, BorderLayout.WEST);
        getContentPane().add(searchBar, BorderLayout.CENTER);
        getContentPane().add(crimes, BorderLayout.NORTH);
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
                search2.setText("");
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
                if (longLat.isSelected()) {
                    if (descend.isSelected()) {
                        resultsTable = gui.longLatSearch(search.getText(), search2.getText(), "DESC");
                    } else {
                        resultsTable = gui.longLatSearch(search.getText(), search2.getText(), "ASC");
                    }
                    resultsTable.setVisible(true);
                    resultsTable.setVisible(true);
                    tableScrollPane.setViewportView(resultsTable);
                    getContentPane().add(tableScrollPane, BorderLayout.SOUTH);
                    tableScrollPane.setVisible(true);
                    getContentPane().revalidate();
                } else if (lsoa.isSelected()) {
                    if (descend.isSelected()) {
                        resultsTable = gui.lsoaSearch(search.getText(), "DESC");
                    } else {
                        resultsTable = gui.lsoaSearch(search.getText(), "ASC");
                    }
                    resultsTable.setVisible(true);
                    tableScrollPane.setViewportView(resultsTable);
                    getContentPane().add(tableScrollPane, BorderLayout.SOUTH);
                    tableScrollPane.setVisible(true);
                    getContentPane().revalidate();

                } else if (crimeType.isSelected()) {
                    if (descend.isSelected()) {
                        resultsTable = gui.crimeTypeSearch(crimeTypes.getSelectedItem().toString(), "DESC");
                    } else {
                        resultsTable = gui.crimeTypeSearch(crimeTypes.getSelectedItem().toString(), "ASC");
                    }
                    resultsTable.setVisible(true);
                    tableScrollPane.setViewportView(resultsTable);
                    getContentPane().add(tableScrollPane, BorderLayout.SOUTH);
                    tableScrollPane.setVisible(true);
                    getContentPane().revalidate();
                } else {
                    try {
                        JFrame noOption = new JFrame();
                        //create new thread
                        JDialog j;
                        //new text box
                        JPanel pan = new JPanel();
                        pan.setLayout(new FlowLayout());
                        pan.add(new JLabel("No, don't do that."));
                        //new dialog
                        j = new JDialog(noOption, "Stop", false);
                        j.setLocation(new Point(1090, 240));
                        j.setSize(160, 74);
                        j.add(pan);
                        j.setVisible(true);

                        noOption.toFront();

                        if (j.isVisible() == false) {
                            throw new GUIBrokeException();
                        }

                    } catch (GUIBrokeException gbe) {
                        System.err.println("no");
                    }
                }
            }
        });

        qcNoCrimeID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataQualityCheck dqc = new DataQualityCheck();
                dqc.noCrimeIDCheck();
                System.out.println("Written to file.");
            }

        });

        qcDupCrimeID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataQualityCheck dqc = new DataQualityCheck();
                dqc.dupeCrimeIDCheck();
                System.out.println("written to file.");
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
