package arbolBinario;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import Pila.Pila;

public class ArbolBinario implements Serializable{

//int edad =0;
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

//
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
 


   public void InsertarN(Persona Pe){
       if(Raiz==null){
           
           Raiz=new NodoBinario ();
           Raiz.setDato(Pe);
//           Raiz.setFechaNac(FechaNac);
//           Raiz.setNombre(Nombre);
           n++;
       }else{
           NodoBinario  p=Raiz;
           NodoBinario  ant=null;
           while(p!=null){
               ant=p;
             // comp=Dato.compareTo(p.getDato());
               if( Pe.getEdad() > p.getDato().getEdad())
                   p=p.getRD();
               else{
                    //comp=Dato.compareTo(p.getDato());
                   if( Pe.getEdad() < p.getDato().getEdad() )
                       p=p.getRI();
                   else
                       return;
               }

           }
           NodoBinario Aux=new NodoBinario();
           Aux.setDato(Pe);
//           Aux.setFechaNac(FechaNac);
//           Aux.setNombre(Nombre);
           //comp=Dato.compareTo(ant.getDato());
           if(Pe.getEdad() >ant.getDato().getEdad() )
               ant.setRD(Aux);
           else
               ant.setRI(Aux);
               n++;

       }


   }
 public void PreOrden(){
           PreOrden1(Raiz);

  }
 
 public void PreOrden1 (NodoBinario  P){
     if(P == null){
         return ;
     }
     else
         if(EsHoja(P))
          System.out.println(P.getDato()); //+"-"+ P.getNombre()+"-"+P.getFechaNac() + ",");
         else{
           System.out.println(P.getDato());//+"-"+ P.getNombre()+"-"+P.getFechaNac() + ",");
           PreOrden1(P.getRI());
           PreOrden1(P.getRD()); 
         }
 }
 
////// version primera
public void PreOrdenI(){
           PreOrdenI1(Raiz);
}

public void PreOrdenI1(NodoBinario  A){ 
  NodoBinario aux;
  Pila pila=new Pila(); // pila de nodos
  pila.poner(A);
  while(!pila.estaVacia()) // mientras la pila no este vacia
  {
    aux=(NodoBinario)pila.sacar();
    while (aux!=null)
    {
      System.out.println(aux.getDato().getEdad());
      pila.poner(aux.getRD());
      aux=aux.getRI();
    }
  }
} 
////version segunda
public void V2PreOrdenI(){
           PreOrdenI2(Raiz);
}
void PreOrdenI2(NodoBinario nodo)
{
  NodoBinario aux;
  Pila pila=new Pila(); // pila de nodos
  pila.poner(nodo);
  while(!pila.estaVacia()) // mientras la pila no este vacia
  {
    aux=(NodoBinario)pila.sacar();
    if (aux!=null)
    {
      System.out.print(aux.getDato());
      // primero se apila el nodo derecho y luego el izquierdo
      // para mantener el orden correcto del recorrido
      // al desapilar los nodos
      pila.poner(aux.getRD());
      pila.poner(aux.getRI());
    }
  }
}
public static void main(String[] args) {
   ArbolBinario a=new ArbolBinario();
     Persona p=new Persona();
     
     
     System.out.println();
//      a.InsertarN("12-08-30",10,"pedro");
//      a.InsertarN("12-08-30",5,"juan");
//      a.InsertarN("12-08-30",15,"maria");
//      a.InsertarN("12-08-30",7,"marco1");
//      a.InsertarN("12-08-30",14,"maisel");
//      a.InsertarN("12-08-30",17,"monica");
//      a.InsertarN("12-08-30",1,"juan1");
//      a.InsertarN("12-08-30",4,"maria 2");
//      a.InsertarN("12-08-30",9,"marco 3");
//      a.InsertarN("12-08-30",16,"maisel 4");
//      a.InsertarN("12-08-30",20,"monica 5");
     p.Insertar("rodrigo", 23, "3/1/89");
     a.InsertarN(p);
     p=new Persona();
     p.Insertar("rodrigo", 35, "3/1/89");
     
     a.InsertarN(p);
//      a.PreOrden();
//      a.getRaiz();
      a.PreOrdenI();
//      a.V2PreOrdenI();
//      a.inorden();
//        a.InsertarN(2);
        //m=a.getInOrden();
        //a.InOrden();
   //     System.out.println();
     //  System.out.println(a.peso());
       // System.out.println(a.Altura());
      


}
}

