package grupGymcom.example.demo.Domain;

import java.util.concurrent.atomic.AtomicLong;

public class Aluno extends Usuario {

    //definir os atributos da classe aluno (que o aluno terá de diferente e somente dele).
    private long id;
    private int matricula;
    private boolean ativo;
    private String objetivo;
    private String email;

    //ToString
    @Override
    public String toString() {
        return String.format( " %s - %d - %b - %s - %s",
             super.toString(),
                matricula,
                ativo ? "PRESENTE" : "AUSENTE",
                objetivo,
                email);
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMatricula() {
    return matricula;
}

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}