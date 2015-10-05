/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

/**
 * Pilas: son un tipo especial de lista, conocidas como listas LIFO
 * (Last In, First Out: el último en entrar es el primero en salir).
 * Los elementos se "amontonan" o apilan, de modo que sólo el elemento que
 * está encima de la pila puede ser leído, y sólo pueden añadirse elementos
 * encima de la pila.
 * @author Ronald Galarza
 */
public class Pila {

    private NodoSimple P;// es el primer nodo
    private int n;//cantidad de datos que tiene la pila

    /**
     * Construye una pila vacía.
     */
    public Pila() {
        P = null;
        n = 0;
    }

    /**
     * Pone un dato en la pila.
     * @param dato Es el dato que se desea poner en la pila.
     */
    public void poner(Object dato) {
        if (P == null) {
            P = new NodoSimple();
            P.setData(dato);
        } else {
            NodoSimple aux = new NodoSimple();
            aux.setData(dato);
            aux.setLink(P);
            P = aux;
        }
        n++;
    }

    /**
     * Metodo que devuelve el ultimo dato puesto en la pila, y luego lo elimina.
     * @return el último dato que se puso en la pila.
     */
    public Object sacar() {
        Object aux = P.getData();
        P = P.getLink();
        n--;
        return aux;
    }

    public int canDatos(){
        return n;
    }

    public boolean existe(Object dato){
        if(P == null){
            return true;
        }else{
            NodoSimple A = P;
            while(A != null){
                if(A.getData() == dato){
                    return true;
                }else{
                    A = A.getLink();
                }
            }
            return false;
        }
    }

    @Override
    public String toString(){
       String s1 = "{ ";
       NodoSimple A = P;
       while(A != null){
           s1 = s1 + A.getData() + ", ";
           A = A.getLink();
       }
       return (s1.length() == 0)? s1: s1.substring(0,s1.length() - 2) + " }";

    }
       public boolean estaVacia() {
        if (P==null) {
            return true;
        } else {
    	    return false; 
        }
    }
}
