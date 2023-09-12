
package model;

/**
 *
 * @author Naty
 */
public class Exame {
    private int id;
    private String nome;
    private int id_consulta;

    public Exame(int id, String nome, int id_consulta) {
        this.id = id;
        this.nome = nome;
        this.id_consulta = id_consulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }
    
    @Override
    public String toString() {        
        String desc = "Cliente{" + "nome=" + nome + ", id_consulta=" + id_consulta + '}';
        return desc;
    }    
    
    
}
