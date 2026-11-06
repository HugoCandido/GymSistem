package grupGymcom.example.demo.Controller;

import grupGymcom.example.demo.Domain.Aluno;
import grupGymcom.example.demo.Services.AlunoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//https://localhost:8080/api/aluno
@RequestMapping("api/aluno")
public class AlunoController  {
    //Fazer o Controller (Envio de informações por HTTP).

    //Injeção de dependencia
    private final AlunoServices alunoServices;

    public AlunoController(AlunoServices alunoServices) {
        this.alunoServices = alunoServices;
    }

    //GET - lista completa
    @GetMapping
    public List<Aluno> lista(){
        return alunoServices.listaAlunos();
    }
    //GET - mostrar pelo ID
    @GetMapping(value = "/{id}")
    public Aluno mostrarId(@PathVariable long id){
        return alunoServices.mostrarId(id);
    }

    //POST
    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno){
        return alunoServices.cadastrar(aluno);
    }

    //PUT
    @PutMapping(value = "/{id}")
    public Aluno atualizar(@PathVariable long id, @RequestBody Aluno aluno){
        return alunoServices.atualizar(id, aluno);
    }
    //PATH
    @PatchMapping(value = "/{id}/inativar")
    public Aluno inativar(@PathVariable long id){
        return alunoServices.inativar(id);
    }
    //DELETE
    @DeleteMapping(value = "/{id}")
    public Aluno excluir(@PathVariable long id){
        return alunoServices.excluir(id);
    }

}