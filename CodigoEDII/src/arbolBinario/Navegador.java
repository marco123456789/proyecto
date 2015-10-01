
package arbolBinario;

import java.io.Serializable;

/**
 * Permite navegar a trav&eacute;s de un <code>ArbolBinario</code>.
 *
 * @param T representa el mismo tipo de dato del <code>ArbolBinario</code>
 *      que se quiere navegar.
 * 
 * @see modelo.tda.ArbolBinario
 */
public class Navegador implements  Serializable {

    private NodoBinario R;
    
    public Navegador(NodoBinario R) {
        this.R = R;
    }
    
    /* este metodo es temporal - ELIMINARLO DESPUES */
    
    public int getFB() {
        int fb = 0;
        
        if (R != null) {
            fb = R.getFB();
        }
        
        return fb;
    }
    
    /* este metodo es temporal - ELIMINARLO DESPUES */
    
    public int getDato() {
        int dato = 0;
        
        if (R != null) {
            dato = R.getDato();
        }
        
        return dato;
    }
    
    public Navegador getNavIzq() {
        Navegador  nav = null;
        
        if (R != null) {
            nav = new Navegador(R.getRI());
        }
        
        return nav;
    }
    
    public Navegador getNavDer() {
        Navegador nav = null;
        
        if (R != null) {
            nav = new Navegador(R.getRD());
        }
        
        return nav;
    }
    
    public boolean vacio() {
        return (R == null);
    }
}
