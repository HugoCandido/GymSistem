package grupGymcom.example.demo.Controller;


import grupGymcom.example.demo.Domain.Professor;
import grupGymcom.example.demo.Exception.ProfessorNaoEncontradoException;
import grupGymcom.example.demo.Services.ProfessorServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//localhost:8080/api/professor
@RequestMapping("api/professor")
public class ProfessorController {

    private final ProfessorServices professorServices;

    public ProfessorController(ProfessorServices professorServices) {
        this.professorServices = professorServices;
    }

    //TODO TERMINAL O CONTROLLER E TESTAR NO POSTAMAN
    //TODO - PENSAR SOBRE O NOVO DOMÍNIO E COMO SERÁ! TREINO ? ADMINISTRADOR ? API ?

    //GET - LISTA
    @GetMapping
    public List lista(){
        return professorServices.listaUsuarios();
    }

    //GET - ID
    @GetMapping(value = "{id}")
    public Professor mostrarId(@PathVariable long id){
        return professorServices.mostrarId(id);
    }

    //POST
    @PostMapping
    public Professor cadastrar(@RequestBody Professor professor){
        return professorServices.cadastrar(professor);
    }

    //PUT
    @PutMapping(value = "{id}")
    public Professor atualizar(@PathVariable long id, @RequestBody Professor professor){
        return professorServices.atualizar(id, professor);
    }

    //DELETE
    @DeleteMapping(value = "{id}")
    public Professor excluir(@PathVariable long id) throws ProfessorNaoEncontradoException {
        return professorServices.excluir(id);
    }

}
