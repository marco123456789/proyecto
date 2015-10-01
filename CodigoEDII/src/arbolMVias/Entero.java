/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolMVias;

/**
 *
 * @author Vallejos Rojas
 */
public class Entero implements Comparable{
      Integer data;

    public Entero(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public int compareTo(Object valor) {
//        Entero valorAct = (Entero) valor;
//        return this.data.compareTo(valorAct.data);
        Integer valorInt=(Integer) valor;
        int numInt= valorInt.intValue();
        int numIntAct= this.data.intValue();
        if(numIntAct < numInt){
            return -1;
        }else if (numIntAct > numInt){
            return 1;
        }else{
            return 0;
        }   
    }
}
