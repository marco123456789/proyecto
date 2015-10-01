/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolMVias;

/**
 *
 * @author Vallejos Rojas
 */
public class NodoM {

    private NodoM hijo[]=new NodoM[m];
    private Comparable data[]=new Comparable[m-1];
    static final int m=4;
  
    public NodoM(NodoM[] h) {
        this.hijo = h;
    }
    public NodoM(Comparable[] dato) {
        this.data = dato;
    }
    public NodoM(Comparable dato){
        this.data[0]=dato;
    }
    public void setHijo(int pos,NodoM h) {
       if (pos>0 && pos<=m){ 
             hijo[pos-1]=h;
       }
    }
    public void setData(int pos,Comparable d) {
      if(pos>0 && pos<m){  
         data[pos-1]=d;
      }
    }
    public NodoM getHijo(int pos) {
      if(pos>0 && pos<=m){  
          pos--;
          return hijo[pos];
      }else{
          return null;
      }
    }
    public Comparable getData(int pos) {
      if(pos>0 && pos<m){  
        return data[pos-1];
      }else{
          return null;
      }  
    }
    public boolean vacia(int pos){
      
        return data[pos-1]==null;
     
    }
    public void setVacia(int pos){
      
        data[pos-1]=null;  
       
    }
}
