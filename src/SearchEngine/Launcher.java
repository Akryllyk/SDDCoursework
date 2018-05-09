/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

/**
 * This is the launcher for the program. it calls the GUI handler and does
 * stuff.
 *
 * @author arvmayes
 */
public class Launcher {

    public static void main(String[] args) {
        GUIHandler gui = new GUIHandler();
        gui.setVisible(true);
    }
}
