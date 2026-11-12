package grupGymcom.example.demo.Domain;

import java.time.LocalDate;

public class Matricula {

    private long id;
    private long aluno;
    private final LocalDate dataDeInicio = LocalDate.now();
    private  LocalDate dataFim;
    private boolean matriculaAtiva;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAluno() {
        return this.aluno;
    }

    public void setAluno(long aluno) {
        this.aluno = aluno;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public boolean isMatriculaAtiva() {
        return matriculaAtiva;
    }

    public void setMatriculaAtiva(boolean matriculaAtiva) {
        this.matriculaAtiva = matriculaAtiva;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Matricula(Aluno aluno) {

        this.aluno = this.aluno;
        this.setMatriculaAtiva(true);
    }

}
