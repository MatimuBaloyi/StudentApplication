/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut;

/**
 *
 * @author Matimu Baloyi 219059802
 */
public class DuplicateException extends Exception {

    /**
     * Creates a new instance of <code>DuplicateException</code> without detail
     * message.
     */
    public DuplicateException() {
    }

    /**
     * Constructs an instance of <code>DuplicateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicateException(String msg) {
        super(msg);
    }
}
