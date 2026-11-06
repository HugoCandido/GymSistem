package grupGymcom.example.demo.Loader;

import grupGymcom.example.demo.Domain.Professor;
import grupGymcom.example.demo.Domain.Usuario;
import grupGymcom.example.demo.Services.ProfessorServices;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class ProfessorLoader extends Usuario implements ApplicationRunner {

    private final ProfessorServices professorServices;

    public ProfessorLoader(ProfessorServices professorServices) {
        this.professorServices = professorServices;
    }

    public void run(ApplicationArguments args) throws Exception{

    //ler o arquivo que responderar em um array
    InputStream input = getClass().getClassLoader().getResourceAsStream("professores.txt");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

    if(input == null){
        throw new RuntimeException("Arquivo não encontrado");
    }

    //referenciar o array com o objeto
    String linha;
    while((linha = bufferedReader.readLine()) != null){
        String[] campo = linha.split(",");

        Professor professor = new Professor();
        professor.setId(Long.parseLong(campo[0]));
        professor.setNome(campo[1]);
        professor.setMatricula(Integer.parseInt(campo[2]));
        professor.setCpf(campo[3]);
        professor.setCref(Integer.parseInt(campo[4]));
        professor.setPersonal(Boolean.parseBoolean(campo[5]));
        professor.setSalario(Double.parseDouble(campo[6]));

        System.out.println(professor);
        professorServices.cadastrar(professor);
    }

}}
