package arbolBinario;

import java.io.Serializable;

public class NodoBinario
        implements Serializable {

    private NodoBinario RI;
    private NodoBinario RD;
    private int dato;
    private int FB;

    public NodoBinario() {
        dato = 0;
        RI = null;
        RD = null;
        FB = 0;
    }

    public NodoBinario(int dato) {
        this.dato = dato;
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

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFB() {
        return FB;
    }

    public void setFB(int FB) {
        this.FB = FB;
    }
}
