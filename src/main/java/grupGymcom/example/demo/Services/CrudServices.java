package grupGymcom.example.demo.Services;

import grupGymcom.example.demo.Domain.Aluno;
import grupGymcom.example.demo.Domain.Professor;
import grupGymcom.example.demo.Domain.Usuario;
import grupGymcom.example.demo.Exception.ProfessorNaoEncontradoException;

import java.util.List;

public interface CrudServices <T, ID> {



    //Lista - GET
    List<T> listaUsuarios();
    T mostrarId(ID id);

    T mostrarId(Long id);

    //POST
    T cadastrar (T entity);
    //PUT
    T atualizar (ID id ,T entity);
    //DELETE
    Usuario excluir (ID id) throws ProfessorNaoEncontradoException;

}
