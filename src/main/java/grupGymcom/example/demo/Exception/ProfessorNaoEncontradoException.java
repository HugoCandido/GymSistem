package grupGymcom.example.demo.Exception;

import java.io.Serial;

public class ProfessorNaoEncontradoException extends Throwable {

    @Serial
    private static final long serialVersionUID = 1L;

    public ProfessorNaoEncontradoException(String mensagem){
        super();
    }
}
