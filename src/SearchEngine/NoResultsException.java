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
public class NoResultsException extends Exception {

    public NoResultsException() {
        System.err.println("The database has no data, please try again.");

    }

}
