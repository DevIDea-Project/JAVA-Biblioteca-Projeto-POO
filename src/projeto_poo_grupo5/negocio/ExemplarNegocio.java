/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Exemplar;
import projeto_poo_grupo5.interfaces.CrudExemplarInterface;
import projeto_poo_grupo5.repositorio.ExemplarRepositorio;
import projeto_poo_grupo5.validacao.ExceptionMessage;

/**
 *
 * @author Hyago
 */
public class ExemplarNegocio implements CrudExemplarInterface {

    private final ExemplarRepositorio exemplarRepositorio;

    public ExemplarNegocio() {
        exemplarRepositorio = new ExemplarRepositorio();
    }

    @Override
    public boolean insert(Exemplar exemplar) throws SQLException, Exception {
        if (exemplar.getIdioma() == null) {
            throw new Exception(ExceptionMessage.Exemplar.IDIOMA_NULL);
        }
        if (exemplar.getIdioma().isEmpty()) {
            throw new Exception(ExceptionMessage.Exemplar.IDIOMA_VAZIO);
        }
        if (exemplar.getLivro().getId_livro() == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageLivro.ID_IGUAL_ZERO);
        }
        return exemplarRepositorio.insert(exemplar);
    }

    @Override
    public boolean update(Exemplar exemplar) throws SQLException, Exception {
        if (exemplar.getIdioma() == null) {
            throw new Exception(ExceptionMessage.Exemplar.IDIOMA_NULL);
        }
        if (exemplar.getIdioma().isEmpty()) {
            throw new Exception(ExceptionMessage.Exemplar.IDIOMA_VAZIO);
        }
        if (exemplar.getLivro().getId_livro() == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageLivro.ID_IGUAL_ZERO);
        }
        if (exemplar.getId_exemplar() == 0) {
            throw new Exception(ExceptionMessage.Exemplar.ID_IGUAL_ZERO);
        }
        return exemplarRepositorio.update(exemplar);
    }

    @Override
    public boolean delete(int id) throws SQLException, Exception {
        if (id == 0) {
            throw new Exception(ExceptionMessage.Exemplar.ID_IGUAL_ZERO);
        }
        return exemplarRepositorio.delete(id);
    }

    @Override
    public List<Exemplar> selectAll() throws SQLException, Exception {
        return exemplarRepositorio.selectAll();
    }

    @Override
    public List<Exemplar> selectByLivro(int idLivro) throws SQLException, Exception {
        if(idLivro == 0){
            throw new Exception(ExceptionMessage.ExceptionMessageLivro.ID_IGUAL_ZERO);
        }
        return exemplarRepositorio.selectByLivro(idLivro);
    }

    @Override
    public List<Exemplar> selectByIdioma(String idioma) throws SQLException, Exception {
        if (idioma == null) {
            throw new Exception(ExceptionMessage.Exemplar.IDIOMA_NULL);
        }
        if (idioma.isEmpty()) {
            throw new Exception(ExceptionMessage.Exemplar.IDIOMA_VAZIO);
        }
        return exemplarRepositorio.selectByIdioma(idioma);
    }

}
