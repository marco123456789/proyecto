/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Pila;

/**
 * La clase NodoSimple representa un elemento de una lista.
 * Este nodo se compone de dos campos, que son:
 * dato: almacena el dato del nodo.
 * link: almacena la direccion de otro nodo.
 * @author Ronald Galarza
 */
public class NodoSimple {
    private Object data;
    private NodoSimple link;

    /**
     * construye un nodo vacío.
     */
    public NodoSimple(){
          this.link = null;
    }

    /**
     * guarda un dato en el nodo.
     * @param data un objeto.
     */
    public void setData(Object data){
        this.data = data;
    }

    /**
     * Pone la direccion de otro nodo.
     * @param link es otro nodo.
     */
    public void setLink(NodoSimple link){
        this.link = link;
    }

    /**
     * @return el dato que contiene el nodo.
     */
    public Object getData(){
        return this.data;
    }
     /**
      * @return devuelve la direccion del link.
      */
    public NodoSimple getLink(){
        return this.link;
    }
}
