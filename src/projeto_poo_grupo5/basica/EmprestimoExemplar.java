/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.basica;

/**
 *
 * @author BrunoTiCaVini
 */
public class EmprestimoExemplar {
    
    private Exemplar exemplar;
    
    public EmprestimoExemplar(){
        exemplar = new Exemplar();
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
    
}
