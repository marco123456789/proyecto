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
public class Arbol {
    private Nodo raiz;
    public Arbol(){
        raiz= null;}
    
    public Nodo obtenerRaiz(){
        return raiz;
    }
    // buscar
    
    public Nodo buscar (int d,Nodo r){
    if(raiz==null){
        return null;
    }else
       if(r.dato==d){
       return r;
       }else 
           if (r.dato<d){
               return buscar (d,r.HD);
     }else {
               return  buscar(d, r.HI);
           }
           
    }
    
    // obtener el Factor de equilibrio
    
    public int obtenerFE(Nodo x){
        if(x==null){
            return -1;
        }else {
            return x.fe;        
        }
    }
    //Rotacion simple a la izquierda
    
    public  Nodo RotacionIzquierda(Nodo c){
        Nodo aux = c.HI;
        c.HI = aux.HD;
        aux.HD = c;
        c.fe=Math.max(obtenerFE(c.HI), obtenerFE(c.HD))+1;
        aux.fe=Math.max(obtenerFE(aux.HI), obtenerFE(aux.HD))+1;
        return aux;
  }
     //Rotacion simple a la dereha
    
    public  Nodo RotacionDerecha(Nodo c){
        Nodo aux = c.HD;
        c.HD = aux.HI;
        aux.HI = c;
        c.fe=Math.max(obtenerFE(c.HI), obtenerFE(c.HD))+1;
    aux.fe=Math.max(obtenerFE(aux.HI), obtenerFE(aux.HD))+1;
    return aux;
  }
    // Rotacion doble a la derecha
    
    public Nodo RotacionDobleIzqui(Nodo c){
        Nodo temporal;
        c.HI=RotacionDerecha(c.HI);
        temporal= RotacionIzquierda(c);
        return temporal;
    }
    // Rotacoion doble ala izquierda
    public Nodo RotacionDobleDere(Nodo c){
        Nodo temporal;
        c.HD = RotacionIzquierda(c.HD);
          temporal= RotacionDerecha(c);
          return temporal;
    }
    // Metodo para insertar AVL
    
    public Nodo insertarAVL(Nodo nuevo, Nodo subAr) {
        Nodo nuevoPadre = subAr;
        if (nuevo.dato < subAr.dato) {
            if (subAr.HI == null) {
                subAr.HI = nuevo;
            } else {
                subAr.HI = insertarAVL(nuevo, subAr.HI);
                if ((obtenerFE(subAr.HI)) - obtenerFE(subAr.HD)==2) {
                    if (nuevo.dato < subAr.HI.dato) {
                        nuevoPadre = RotacionIzquierda(subAr);
                    } else {
                        nuevoPadre = RotacionDobleIzqui(subAr);
                    }
                }
            }
        } else if (nuevo.dato > subAr.dato) {
            if (subAr.HD == null) {
                subAr.HD = nuevo;
            } else {
                subAr.HD = insertarAVL(nuevo, subAr.HD);
                if ((obtenerFE(subAr.HD) - obtenerFE(subAr.HI) == 2)) {

                    if (nuevo.dato > subAr.HD.dato) {
                        nuevoPadre = RotacionDerecha(subAr);
                    } else {
                        nuevoPadre = RotacionDobleDere(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo Duplicado");
        }
        
//Actualizando la Altura
        
        if ((subAr.HI == null) && (subAr.HD != null)) {
            subAr.fe = subAr.HD.fe + 1;
        } else if ((subAr.HD == null) && (subAr.HI != null)) {
            subAr.fe = subAr.HI.fe + 1;

        } else {
            subAr.fe = Math.max(obtenerFE(subAr.HI), obtenerFE(subAr.HD)) + 1;
        }
        return nuevoPadre;
    }
    
    //Metodo para inserta;
    public void insertar (int d){
    Nodo nuevo= new Nodo(d);
    if (raiz == null){
         raiz = nuevo;         
    }else {
       raiz= insertarAVL(nuevo, raiz);
    }
   }
    
   // Recorridos
   // Metodos para recorrer el Arbol InOrden
    public void inOrden (Nodo r ){
        if (r != null){
            inOrden(r.HI);
            System.out.println(r.dato+", ");
            inOrden(r.HD);
          }
}
    public void preOrden(Nodo r) {
        if (r != null) {
            System.out.println(r.dato + ", ");
            preOrden(r.HI);
            preOrden(r.HD);
        }
    }
     public void postOrden(Nodo r) {
        if (r != null) {
            postOrden(r.HI);
            postOrden(r.HD);
            System.out.println(r.dato + ", ");
        }
    }

}//FIN
  
    
    
    
     

