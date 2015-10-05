package arbolBinario;

import java.io.Serializable;

public class NodoBinario
        implements Serializable {

    private NodoBinario RI;
    private NodoBinario RD;
    private Persona dato;
//    private String nombre;
//    private String FechaNac;
    private int FB;

    public NodoBinario() {
        dato = new Persona();
//        nombre="";
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

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
        this.dato = dato;
    }

    public int getFB() {
        return FB;
    }

    public void setFB(int FB) {
        this.FB = FB;
    }
}
