/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchEngine;

/**
 *
 * @author arvmayes
 */
public class GUIBrokeException extends Exception {

    public GUIBrokeException() {
        System.err.println("The GUI hasn't loaded something, please try again.");
    }
}
