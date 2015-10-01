package arbolBinario;

import java.io.Serializable;

public class NodoBinario
        implements Serializable {

    private NodoBinario RI;
    private NodoBinario RD;
    private int dato;
    private String nombre;
    private String FechaNac;
    private int FB;

    public NodoBinario() {
        dato = 0;
        nombre="";
        RI = null;
        RD = null;
        FB = 0;
    }

    public NodoBinario(int dato,String nomb) {
        this.dato = dato;
        this.nombre=nomb;
        RI = null;
        RD = null;
        FB = 0;
    }

    public NodoBinario getRI() {
        return RI;
    }

    public void setRI(NodoBinario RI) {
        this.RI = RI;
    }

    public NodoBinario getRD() {
        return RD;
    }

    public void setRD(NodoBinario RD) {
        this.RD = RD;
    }

    public int getDato() {
        return dato;
    }
    public String getNombre() {
        return nombre;
    }
    public String getFechaNac() {
        return FechaNac;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }
    public void setFechaNac(String fech) {
        this.FechaNac = fech;
    }
    public int getFB() {
        return FB;
    }

    public void setFB(int FB) {
        this.FB = FB;
    }
}
