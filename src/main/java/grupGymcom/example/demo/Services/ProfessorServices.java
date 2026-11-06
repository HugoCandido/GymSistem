package grupGymcom.example.demo.Services;

import grupGymcom.example.demo.Domain.Professor;
import grupGymcom.example.demo.Domain.Usuario;
import grupGymcom.example.demo.Exception.ProfessorNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProfessorServices implements CrudServices<Professor,Long> {

    private final Map<Long, Professor> mapa = new ConcurrentHashMap<>();

    private final AtomicLong incrementar = new AtomicLong(1);

    private void validarProfessorNome(Professor professor){
        if (professor.getNome() == null){
            throw new IllegalArgumentException("Preencher nome!");
        }if (professor == null || professor.getNome().trim().isEmpty()){
            throw new IllegalArgumentException("CAMPO OBRIGATORIO");
        }
    }

    //TODO regras de negocios
    @Override
    public List listaUsuarios() {
        return new ArrayList<Professor>(mapa.values());
    }

    @Override
    public Professor mostrarId(Long id) {
        Professor professor = mapa.get(id);

        if (professor == null){
            throw new IllegalArgumentException("ID do professor não encontrado");
        }
        return professor;
    }

    @Override
    public Professor cadastrar(Professor professor) {
        validarProfessorNome(professor);

        professor.setId(incrementar.getAndIncrement());

        mapa.put(professor.getId(),professor);

        return professor;
    }

    @Override
    public Professor atualizar(Long id, Professor professor) {
    if(id == null || id == 0 ){
        throw new IllegalArgumentException("Id não pode ser nulo");
    }
        validarProfessorNome(professor);

        mostrarId(id);

        return professor;
    }


    @Override
    public Professor excluir(Long id) throws ProfessorNaoEncontradoException {
        if (id == 0 || id == null) {
        throw new IllegalArgumentException("O id não pode estar preenchido");
        }

        if (!mapa.containsKey(id)){
            throw new ProfessorNaoEncontradoException("Não encontrado o ID:" +id + "informe novamente.");
        }

        return mapa.remove(id);
    }

}