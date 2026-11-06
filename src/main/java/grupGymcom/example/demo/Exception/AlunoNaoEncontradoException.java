package grupGymcom.example.demo.Exception;

import java.io.Serial;

public class AlunoNaoEncontradoException extends  RuntimeException{

    @Serial
    private static final long serialVersionUID  = 1l;

    public AlunoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
