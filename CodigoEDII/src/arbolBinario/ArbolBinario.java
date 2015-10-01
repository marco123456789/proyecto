package arbolBinario;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;


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
 


   public void InsertarN(String Nombre,int Dato,String FechaNac){
       if(Raiz==null){
           
           Raiz=new NodoBinario ();
           Raiz.setDato(Dato);
           Raiz.setFechaNac(FechaNac);
           Raiz.setNombre(Nombre);
           n++;
       }else{
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
           Aux.setFechaNac(FechaNac);
           Aux.setNombre(Nombre);
           //comp=Dato.compareTo(ant.getDato());
           if(Dato >ant.getDato() )
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
          System.out.println(P.getDato()+"-"+ P.getNombre()+"-"+P.getFechaNac() + ",");
         else{
           PreOrden1(P.getRD());
           System.out.println(P.getDato()+"-"+ P.getNombre()+"-"+P.getFechaNac() + ",");
           PreOrden1(P.getRI());
           
         }
 }

public int busqueda( NodoBinario P , char c){

    return 0;

}

public static void main(String[] args) {
   ArbolBinario a=new ArbolBinario();
      
     System.out.println();
      a.InsertarN("12-08-30",35,"pedro");
      a.InsertarN("12-08-30",20,"juan");
      a.InsertarN("12-08-30",40,"maria");
      a.InsertarN("12-08-30",18,"marco");
      a.PreOrden();

//        a.InsertarN(2);
        //m=a.getInOrden();
        //a.InOrden();
   //     System.out.println();
     //  System.out.println(a.peso());
       // System.out.println(a.Altura());
    
}


}
