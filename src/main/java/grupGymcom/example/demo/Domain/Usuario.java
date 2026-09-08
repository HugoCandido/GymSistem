package grupGymcom.example.demo.Domain;

public class Usuario {

    // definir as caracteristicas de um usuario normal
    private long id;
    private String nome;
    private String cpf;

    //NÃO DEU CERTO
    @Override
    public String toString() {
        return String.format("%d - %s - %s" ,
        id,nome, cpf);
    }

    // fazer os getters e setters das caracteristicas


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
