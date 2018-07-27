package projeto_poo_grupo5.basica;

/** 
 * @author João Gilberto
 * Classe básica, objeto Usuario;
 * Contém o objeto Pessoa, as informações de identificação do usuário e status.
 */
public class Usuario {
    
    private int id_usuario;
    private char status; 
    private Pessoa pessoa = new Pessoa();

    /**
     * @return - retorna um objeto Pessoa;
     */
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    /**
     * @param pessoa - seta o objeto pessoa com as informações retornadas no método anterior.
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    /**
     * @return - retorna uma identificação de usuario disponível.
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario - seta a identificação retornada no método anterior ao objeto Usuario criado.
     */
    public void setId_usuario(int id_usuario) {
        if (id_usuario > 0)
        this.id_usuario = id_usuario;
    }

    /**
     * @return - retorna um status para o objeto Usuario.
     */
    public char getStatus() {
        return status;
    }

    /**
     * @param status - seta o status retornado no método anterior ao objeto Usuario criado.
     */ 
    public void setStatus(char status) {
        this.status = status;
    }

    
    
}
