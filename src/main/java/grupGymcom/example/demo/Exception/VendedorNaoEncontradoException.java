package grupGymcom.example.demo.Exception;

import java.io.Serial;

public class VendedorNaoEncontradoException extends  RuntimeException{

    @Serial
    private static final long serialVersionUID  = 1l;

    public VendedorNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
