package grupGymcom.example.demo.Loader;


import grupGymcom.example.demo.Domain.Aluno;
import grupGymcom.example.demo.Domain.Usuario;
import grupGymcom.example.demo.Services.AlunoServices;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class AlunoLoader extends Usuario implements ApplicationRunner{

    private final AlunoServices alunoServices;
    public AlunoLoader(AlunoServices alunoServices) {
        this.alunoServices = alunoServices;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //ler um arquivo com dados - momento
        InputStream input = getClass().getClassLoader().getResourceAsStream("alunos.txt");
        BufferedReader arquivo = new BufferedReader(new InputStreamReader(input));

        //Conferencia se o arquivo existe
        if (arquivo == null){
            throw new RuntimeException("Arquivo não localizado");
        }

        String linha;
        while ((linha = arquivo.readLine())!=null){

        String[] campo = linha.split(";");

            //1 Entidade principal
            Aluno aluno = new Aluno();
            aluno.setId(Long.parseLong(campo[0]));
            aluno.setNome(campo[1]);
            aluno.setCpf(campo[2]);
            aluno.setMatricula(Integer.parseInt(campo[3]));
            aluno.setAtivo(Boolean.parseBoolean(campo[4]));
            aluno.setObjetivo(campo[5]);
            aluno.setEmail(campo[6]);

            alunoServices.cadastrar(aluno);
            System.out.println(aluno);
        }
    }
}
