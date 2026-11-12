package grupGymcom.example.demo.Services;

import grupGymcom.example.demo.Domain.Aluno;
import grupGymcom.example.demo.Domain.Matricula;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MatriculaServices {

    //SALVA SERÁ COM O MAP
    private final Map<Long, Matricula> mapa = new ConcurrentHashMap<>();
    private final AtomicLong geradorId = new AtomicLong(1);


    //alunos não podem ter a mesma matricula
    //aluno saiu a matricula é excluida
    //validar se a matricula não esta nula ou zerada

    public Matricula criarMatricula(Aluno aluno){

        Matricula matricula = new Matricula(aluno);

        matricula.setId(geradorId.getAndIncrement());

        mapa.put(matricula.getId(), matricula);

        return matricula;
    }

    public Collection<Matricula> consultaMatricula(){
        return mapa.values();
    }
    public Matricula consultaDeMatricula(long matricula){
       Matricula matriculaEncontrada =  mapa.get(matricula);

        if (matriculaEncontrada == null){
            throw new IllegalArgumentException("Matricula não encontrada");
        }
        return matriculaEncontrada;
    }

    public Matricula encerrarMatricula(long matricula){
        Matricula matriculaEncerrada = mapa.get(matricula);

        if (matriculaEncerrada == null){
            throw new RuntimeException("Matricula inexistente");
        }
        if (!matriculaEncerrada.isMatriculaAtiva()){
            throw new RuntimeException("A matricula já está inativada");
        }

        matriculaEncerrada.setMatriculaAtiva(false);

        matriculaEncerrada.setDataFim(LocalDate.now());

        return matriculaEncerrada;
    }



}
