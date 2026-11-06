package grupGymcom.example.demo.Services;

import grupGymcom.example.demo.Domain.Aluno;

import java.util.List;

public interface CrudServices <T, ID> {



    //Lista - GET
    List<T> listaAlunos();
    T mostrarId(ID id);
    //POST
    T cadastrar (T entity);
    //PUT
    T atualizar (ID id ,T entity);
    //DELETE
    Aluno excluir (ID id);


}
