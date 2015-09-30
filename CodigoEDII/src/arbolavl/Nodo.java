/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

/**
 *
 * @author Marcos
 */
public class Nodo {
    int dato,fe;
    Nodo HI,HD ;
    

    public Nodo(int d) {
        this.dato= d;
        this.fe=0;
        this.HI=null;
        this.HD=null;                   
    }        
}
