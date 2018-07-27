
package projeto_poo_grupo5.basica;

/**
 *
 * @author João Gilberto
 */
public class Exemplar {
    
    private int id_exemplar;
    private String idioma;
    private Livro livro = new Livro();

    /**
     * @return the id_exemplar
     */
    public int getId_exemplar() {
        return id_exemplar;
    }

    /**
     * @param id_exemplar the id_exemplar to set
     */
    public void setId_exemplar(int id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }    
    
}
