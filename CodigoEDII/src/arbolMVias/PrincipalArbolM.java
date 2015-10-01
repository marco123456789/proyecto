/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolMVias;

/**
 *
 * @author Vallejos Rojas
 */
public class PrincipalArbolM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolMVias arbolm = new ArbolMVias();
        arbolm.insertar(20);
        arbolm.insertar(30);
        arbolm.insertar(40);
        arbolm.insertar(10);
        arbolm.insertar(15);
        arbolm.insertar(18);
        arbolm.insertar(22);
        arbolm.insertar(25);
        arbolm.insertar(27);
        arbolm.insertar(50);
        arbolm.insertar(70);
        arbolm.insertar(90);
        arbolm.insertar(7);
        arbolm.insertar(9);
        arbolm.insertar(16);
        arbolm.insertar(24);
        arbolm.insertar(55);
        arbolm.insertar(60);
        arbolm.insertar(66);
        arbolm.insertar(92);
        arbolm.insertar(96);
        arbolm.insertar(100);
        arbolm.insertar(91);
        System.out.println("Existe el dato en el arbol ?? "+arbolm.existe(100));
        arbolm.inOrden();
        arbolm.preOrden();
        arbolm.recPorNiveles();
        arbolm.mayor();
        arbolm.cantidadLlaves();
        System.out.println("La cantidad maxima de hijos en el arbol es: "+arbolm.gradoArbolMIterativo());
        System.out.println("La cantidad de ramas en el arbol es: "+arbolm.ramasIter());
        System.out.println("La altura del arbol es: "+arbolm.Altura());
        System.out.println("El dato minimo del arbol es: "+arbolm.minimo());
        
    }
}
