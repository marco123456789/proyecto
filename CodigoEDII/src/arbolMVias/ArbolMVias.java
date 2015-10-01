/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolMVias;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Vallejos Rojas
 */
public class ArbolMVias {

    private NodoM raiz;

    public ArbolMVias() {
        raiz = null;
    }

    public boolean vacia() {
        return vacia(raiz);
    }

    private boolean vacia(NodoM nodoAct) {
        if (nodoAct == null) {
            return true;
        }
        for (int i = 1; i <= NodoM.m; i++) {
            if (!nodoAct.vacia(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean esHoja() {
        return esHoja(raiz);
    }

    private boolean esHoja(NodoM nodoAct) {
        if (nodoAct == null) {
            return false;
        }
        for (int i = 1; i <= NodoM.m; i++) {
            if (nodoAct.getHijo(i) != null) {
                return false;
            }
        }
        return true;
    }

    private boolean nodoLleno(NodoM nodoAct) {
        return !nodoAct.vacia(NodoM.m - 1);
    }
    //METODOS DE ARBOL M-VIAS ITERATIVOS

    public int ramasIter() {
        Queue<NodoM> cola = new LinkedList<NodoM>();
        cola.offer(this.raiz);
        int cr = 0;
        while (!cola.isEmpty()) {
            NodoM nodoAct = cola.poll();
            if (!esHoja(nodoAct)) {
                for (int i = 1; i <= NodoM.m; i++) {

                    if (!vacia(nodoAct.getHijo(i))) {
                        cola.offer(nodoAct.getHijo(i));
                    }
                }
            } else {
                cr++;
            }
        }
        return cr;
    }

    public void recPorNiveles() {
        System.out.println("Recorrido Por Niveles");
        Queue<NodoM> cola = new LinkedList<NodoM>();
        cola.offer(this.raiz);

        while (!cola.isEmpty()) {
            NodoM nodoAct = cola.poll();
            for (int i = 1; i <= NodoM.m - 1 && !nodoAct.vacia(i); i++) {
                System.out.print(nodoAct.getData(i) + " ");
            }
            if (!esHoja(nodoAct)) {
                for (int i = 1; i <= NodoM.m; i++) {
                    if (!vacia(nodoAct.getHijo(i))) {
                        cola.offer(nodoAct.getHijo(i));
                    }
                }
            }
        }
        System.out.println();
    }

    public int gradoArbolMIterativo() {
        /*El grado del árbol es la cantidad mayor de hijos
         que tenga algún nodo del árbol*/
        Queue<NodoM> cola = new LinkedList<NodoM>();
        cola.offer(this.raiz);

        int maxh = 0;
        while (!cola.isEmpty()) {
            NodoM nodoAct = cola.poll();

            if (!esHoja(nodoAct)) {
                int ch = 0;
                for (int i = 1; i <= NodoM.m; i++) {
                    if (!vacia(nodoAct.getHijo(i))) {
                        ch++;
                        cola.offer(nodoAct.getHijo(i));
                    }
                }
                if (ch > maxh) {
                    maxh = ch;
                }
            }
        }
        return maxh;
    }
    //METODOS DE ARBOL M-VIAS RECURSIVO

    public boolean existe(Comparable valor) {

        return existe(valor, raiz);
    }

    private boolean existe(Comparable valor, NodoM nodoActual) {

        if (vacia(nodoActual)) {
            return false;
        }
        int i = 1;
        for (i = 1; i <= NodoM.m - 1 && !nodoActual.vacia(i); i++) {

            if (valor.compareTo(nodoActual.getData(i)) == 0) {
                return true;
            } else {
                if (valor.compareTo(nodoActual.getData(i)) < 0) {
                    return existe(valor, nodoActual.getHijo(i));
                }
            }
        }
        return existe(valor, nodoActual.getHijo(NodoM.m));
    }

    private void insertarOrdenadoNodo(NodoM nodoAct, Comparable dato) {
        int i = 1;
        for (i = 1; i <= NodoM.m - 1 && !nodoAct.vacia(i); i++) {
            if (nodoAct.getData(i).compareTo(dato) > 0) {
                esta(nodoAct, i);
                nodoAct.setData(i, dato);
                return;
            }
        }
        nodoAct.setData(i, dato);
        return;
    }

    private void esta(NodoM nodoAct, int indice) {
        for (int i = NodoM.m - 2; i >= indice; i--) {
            nodoAct.setData(i + 1, nodoAct.getData(i));
        }
    }

    private int enQueHijo(NodoM nodoAct, Comparable dato) {
        int i = 1;
        for (i = 1; i <= NodoM.m - 1 && !nodoAct.vacia(i); i++) {
            if (nodoAct.getData(i).compareTo(dato) > 0) {
                return i;
            } else if (nodoAct.getData(i).compareTo(dato) == 0) {
                System.out.println("El dato ya existe en el arbol");
            }

        }
        return i;
    }

    public void insertar(Comparable dato) {
        if (vacia(raiz)) {
            raiz = new NodoM(dato);
            return;
        }
        NodoM nodoAct = raiz;
        while (!vacia(nodoAct)) {
            if (esHoja(nodoAct)) {
                if (!nodoLleno(nodoAct)) {
                    insertarOrdenadoNodo(nodoAct, dato);
                    return;
                } else {
                    int dondeIr = enQueHijo(nodoAct, dato);
                    NodoM nodoNuevo = new NodoM(dato);
                    nodoAct.setHijo(dondeIr, nodoNuevo);
                    return;
                }
            } else {
                int dondeIr = enQueHijo(nodoAct, dato);
                if (vacia(nodoAct.getHijo(dondeIr))) {
                    NodoM nodoNuevo = new NodoM(dato);
                    nodoAct.setHijo(dondeIr, nodoNuevo);
                    return;
                } else {
                    nodoAct = nodoAct.getHijo(dondeIr);

                }
            }
        }
    }

    public void inOrden() {
        System.out.println("Recorrido InOrden");
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(NodoM nodoAct) {
        if (vacia(nodoAct)) {//if raiz == null
            return;
        }
        for (int i = 1; i <= NodoM.m - 1 && !nodoAct.vacia(i); i++) {
            inOrden(nodoAct.getHijo(i));
            System.out.print(nodoAct.getData(i).toString() + " ");
        }
        inOrden(nodoAct.getHijo(NodoM.m));

    }

    public void preOrden() {
        System.out.println("Recorrido PreOrden");
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(NodoM nodoAct) {
        if (vacia(nodoAct)) {//if raiz == null
            return;
        }
        for (int i = 1; i <= NodoM.m - 1 && !nodoAct.vacia(i); i++) {
            System.out.print(nodoAct.getData(i).toString() + " ");
            preOrden(nodoAct.getHijo(i));
        }
        preOrden(nodoAct.getHijo(NodoM.m));
    }
    public void mayor() {
        System.out.println("El dato mayor del arbol es: " + mayor(raiz));
    }

    private Comparable mayor(NodoM nodoAct) {
        if (vacia(nodoAct)) {
            return null;
        }
        int posMayor = posMayorMet(nodoAct);
        if (tieneHijoDer(nodoAct, posMayor)) {
            return mayor(nodoAct.getHijo(posMayor + 1));
        } else {
            return nodoAct.getData(posMayor);
        }
    }

    private int posMayorMet(NodoM nodoAct) {
        int i = 1;
        for (i = 1; i < NodoM.m && !nodoAct.vacia(i); i++) {
        }
        return --i;
    }

    private boolean tieneHijoDer(NodoM nodoAct, int posMayor) {
        return nodoAct.getHijo(posMayor + 1) != null;
    }

    public void cantidadLlaves() {
        System.out.println("La cantidad de llaves en el arbol es: "+cantidadLlaves(raiz));
    }

    private int cantidadLlaves(NodoM nodoAct) {
        if (vacia(nodoAct)) {
            return 0;
        }
        if (esHoja(nodoAct)) {
            return cantidadDatas(nodoAct);
        }
        int c = 0;
        for (int i = 1; i <= NodoM.m; i++) {
            c = c + cantidadLlaves(nodoAct.getHijo(i));

        }
        return c + NodoM.m - 1;
    }

    private int cantidadDatas(NodoM nodoAct) {
        int i = 1;
        for (i = 1; i < NodoM.m && !nodoAct.vacia(i); i++) {
        }
        return --i;
    }

    public int Altura() {
        return Altura(raiz);
    }

    private int Altura(NodoM nodoAct) {
        if (nodoAct == null) {
            return 0;
        }
        int i = 0;
        int max = 0;
        while (i <= NodoM.m) {
            int n = Altura(nodoAct.getHijo(i));
            if (n >= max) {
                max = n;
            }

            i = i + 1;
        }
        return max + 1;
    }

    public Comparable minimo() {
        return minimo(raiz);
    }

    private Comparable minimo(NodoM nodoAct) {
        if (vacia(nodoAct)) {
            return null;
        }
        if (vacia(nodoAct.getHijo(1))) {
            return nodoAct.getData(1);
        } else {
            return minimo(nodoAct.getHijo(1));
        }
    }
}
