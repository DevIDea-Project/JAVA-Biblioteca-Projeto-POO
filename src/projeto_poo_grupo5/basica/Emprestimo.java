package projeto_poo_grupo5.basica;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Gilberto
 */
public class Emprestimo {
    
    private int id_emprestimo;
    private Date data_devolucao;
    private Date data_aquisicao;
    private Date data_entrega;
    private double multa; 
    private Usuario usuario = new Usuario();
    private Funcionario funcionario = new Funcionario();

    
    private List<EmprestimoExemplar> emprestimoExemplares = new ArrayList<>();
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }  
    
    /**
     * @return the id_emprestimo
     */
    public int getId_emprestimo() {
        return id_emprestimo;
    }

    /**
     * @param id_emprestimo the id_emprestimo to set
     */
    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    /**
     * @return the data_devolucao
     */
    public Date getData_devolucao() {
        return data_devolucao;
    }

    /**
     * @param data_devolucao the data_devolucao to set
     */
    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    /**
     * @return the data_aquisicao
     */
    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    /**
     * @param data_aquisicao the data_aquisicao to set
     */
    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    /**
     * @return the data_entrega
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * @param data_entrega the data_entrega to set
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * @return the multa
     */
    public double getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(double multa) {
        this.multa = multa;
    }   
    
        /**
     * @return the emprestimoExemplares
     */
    public List<EmprestimoExemplar> getEmprestimoExemplares() {
        return emprestimoExemplares;
    }

    /**
     * @param emprestimoExemplares the emprestimoExemplares to set
     */
    public void setEmprestimoExemplares(List<EmprestimoExemplar> emprestimoExemplares) {
        this.emprestimoExemplares = emprestimoExemplares;
    }
    
        /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
 