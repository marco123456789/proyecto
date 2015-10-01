package arbolBinario;

import java.io.Serializable;

/**
 * Es una estructura de datos recursiva no lineal
 * que permite guardar datos de forma ordenada
 * y con tiempo de acceso logar&iacute;tmico.
 * 
 * Esta clase implementa sus m&eacute;todos <code>insertar()</code>
 * y <code>eliminar()</code> utilizando el concepto de &aacute;rbol
 
 * @param T el tipo de dato de los elementos 
 *      de &eacute;ste &aacute;rbol binario.
 * 
 * @see modelo.tda.Navegador
 */
/**
 *
 * @author TANIA
 */

public class ArbolBinario implements Serializable{


    private NodoBinario  Raiz;
        private int n;

     public ArbolBinario() {
        Raiz =null;
        n=0;
    }



    public ArbolBinario(NodoBinario Raiz) {
        this.Raiz = Raiz;
    }



    public NodoBinario getRaiz() {
        return Raiz;
    }

    public int getN() {
        return n;
    }

    public Navegador getNavegador() {
        return new Navegador(Raiz);
    }

   public boolean EsHoja(NodoBinario T){
       if (T==null){
           return false;
       }else{
           if(T.getRI()==null && T.getRD()==null)
               return true;
       }
       return false;

   }
  //modificar
 


   public void InsertarN(int  Dato){
             if(Raiz==null){
           Raiz=new NodoBinario ();
           Raiz.setDato(Dato);
           n++;
       }
       else{
           NodoBinario  p=Raiz;
           NodoBinario  ant=null;
           while(p!=null){
               ant=p;
             // comp=Dato.compareTo(p.getDato());
               if( Dato > p.getDato())
                   p=p.getRD();
               else{
                    //comp=Dato.compareTo(p.getDato());
                   if( Dato < p.getDato() )
                       p=p.getRI();
                   else
                       return;
               }

           }
           NodoBinario Aux=new NodoBinario();
           Aux.setDato(Dato);
           //comp=Dato.compareTo(ant.getDato());
           if(Dato >ant.getDato() )
               ant.setRD(Aux);
           else
               ant.setRI(Aux);
               n++;

       }


   }


   public void eliminar(int e) {
       if(Raiz!=null){
        Raiz = eliminarrec(Raiz, e);
       }
    }

    public NodoBinario eliminarrec(NodoBinario r, int e) {
        if (r != null) {
            if (r.getDato() == e) {
                if ((r.getRI() == null) && (r.getRD() == null))
                    return null;
                else {
                    if (r.getRI() == null)
                        //&&(r.get_RD()!=null))
                        return r.getRD();
                    else {
                        if (r.getRD() == null)
                            //&&(r.get_RI()!=null))
                            return r.getRI();
                        else {
                            if (r.getRI() != null && r.getRD() != null) {
                                int x = mayorizq(r.getRI());
                                r.setDato(x);
                                r.setRI(eliminarrec(r.getRI(), x));
                                return r;
                            }
                        }
                    }
                }

            } else {
                if (r.getDato() > e)
                    r.setRI(eliminarrec(r.getRI(), e));
                else
                    r.setRD(eliminarrec(r.getRD(), e));
                  //  r.setRD(eliminarrec(r.getRD()),e));
            }
        }
        return r;
    }

    public int mayorizq(NodoBinario r) {
        while (r.getRD() != null)
            r = r.getRD();
        return r.getDato();
    }



 public void InOrden(){
           InOrden1(Raiz);

       }
 public void InOrden1 (NodoBinario  P){
     if(P == null){
         return ;
     }
     else
         if(EsHoja(P))
          System.out.print(P.getDato()+ ",");
         else{
           InOrden1(P.getRI());
           System.out.print(P.getDato()+ ",");
           InOrden1(P.getRD());
         }
 }

public int Altura(){
    return Altura1(Raiz);
}

public int Altura1(NodoBinario P){
    if(P == null){
        return 0;
    }
    else
        if(EsHoja(P))
            return 1;
        else{
           int a=Altura1(P.getRI());
           int b=Altura1(P.getRD());
           if(a > b){
               return a + 1;
           }
           else{
               return b + 1;
           }
        }

}

// escribir la funciÃ³n exite un elemento x en el Ã¡rbol binario

public boolean Existe(int Dato){
    return Existe1(Dato,Raiz);

}

public boolean Existe1(int Dato, NodoBinario P){

   if(P == null){
       return false;
   }
   else
       if(EsHoja(P))
           return P.getDato()==Dato;
       else{
       if(P.getDato()== Dato)
           return true;

       else{


         boolean a=Existe1(Dato,P.getRD());
         boolean b=Existe1(Dato, P.getRI());
         if(a==true || b==true)
             return true;
         else
             return false;

       }


    }

}

//Escribir una funcion que devuelva la cantidad de hojas de un arbol
public int cantHojas(){
    return cantHojas1(Raiz);
}

public int cantHojas1(NodoBinario P){
    if(P == null){
        return 0;
    }else
        if(EsHoja(P))
            return 1;
        else{
           int a=cantHojas1(P.getRD());
           int b=cantHojas1(P.getRI());
           return a + b;
        }
}


public int busqueda( NodoBinario P , char c){

    return 0;

}

// ArbolBinario a=new ArbolBinario();
//        
//        a.InsertarN(20);
//        a.InsertarN(25);
//        a.InsertarN(40);
//        a.InsertarN(30);
//        a.InsertarN(50);
//        a.InsertarN(60);
//        a.InsertarN(55);
//        a.InsertarN(4);
//        a.InsertarN(2);
//        //m=a.getInOrden();
//       a.InOrden();
//       System.out.println();
//     //  System.out.println(a.peso());
//       System.out.println(a.Altura());


}
