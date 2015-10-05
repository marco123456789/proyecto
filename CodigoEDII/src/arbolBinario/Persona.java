/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arbolBinario;

/**
 *
 * @author Rodrigo
 */
public class Persona {
    String Nombre;
    int Edad;
    String FechaNac;
    public Persona() {
      Nombre="";
      Edad=0;
      FechaNac="1/1/1900";
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }
     
    public void Insertar (String nom,int ed ,String fnac){
        Nombre=nom;
        Edad=ed;
        FechaNac=fnac;
    }
}
