package grupGymcom.example.demo.Services;

import grupGymcom.example.demo.Domain.Aluno;
import grupGymcom.example.demo.Exception.AlunoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AlunoServices implements CrudServices <Aluno,Long > {

    //SALVAR NA MEMORIA COM O MAP
    private final Map< Long, Aluno > mapa = new ConcurrentHashMap<>();

    private final AtomicLong incrementa = new AtomicLong(1);

private void validarAlunoNome(Aluno aluno){
    if(aluno == null){
        throw new IllegalArgumentException("O nome é um campo obrigatorio para ser preenchido");
    }if(aluno.getNome() == null || aluno.getNome().trim().isEmpty()){
        throw new IllegalArgumentException("CAMPO OBRIGATORIO");
    }
}

    @Override
    public Aluno cadastrar(Aluno aluno) {
        //O campo aluno não pode ser um campo em branco
        validarAlunoNome(aluno);

        //incrementa o ID
        aluno.setId(incrementa.getAndIncrement());

        //armazena na memoria o objeto
        mapa.put(aluno.getId(), aluno);

        return aluno;
    }

    @Override
    public Aluno atualizar(Long id,  Aluno aluno) {
        //Validação do ID
        if (id ==0 || id ==null){
            throw new IllegalArgumentException("O ID não pode ser zero ou não estar preenchido");
        }

        //o campo aluno não pode ser um campo em branco
        validarAlunoNome(aluno);

        mostrarId(id);

        mapa.put(aluno.getId(), aluno);
        return aluno;
    }

    @Override
    public Aluno excluir(Long id) {
        if (id ==0 || id ==null){
            throw new IllegalArgumentException("O ID para excluir não pode ser zero ou não estar preenchido");
        }

        if(!mapa.containsKey(id)){
            throw new AlunoNaoEncontradoException("O aluno com o ID: " + id + "não foi encontrado");
        }

        return mapa.remove(id);
    }

    public Aluno inativar(long id){

    if( id == 0){
        throw new IllegalArgumentException("O Id não pode estar zerado");
    }
    Aluno aluno = mostrarId(id);

    if(!aluno.isAtivo()){
        System.out.println("Aluno já está ativo");
    }
    aluno.setAtivo(false);

    return aluno;
    }

    //GET - mostrar a lista por completo
    // @Override
    //  public List<Aluno> listaAlunos() {
    //      return new ArrayList<Aluno>(mapa.values());
    //  }

    @Override
    public List<Aluno> listaUsuarios() {
        return new ArrayList<Aluno>(mapa.values());
    }

    //GET - mostrar por ID
    @Override
    public Aluno mostrarId(Long id) {
        Aluno aluno = mapa.get(id);

        if(aluno == null){
            throw new IllegalArgumentException("Não foi possivel obter o aluno pelo seu ID" +id);
        }
        return aluno;
    }


}
