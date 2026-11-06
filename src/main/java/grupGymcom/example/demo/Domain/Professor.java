package grupGymcom.example.demo.Domain;

public class Professor extends Usuario{

    //definir os atributos da classe professor (que o professor terá de diferente e somente dele). - FEITO

    private int matricula;
    private boolean personal;
    private double salario;
    private int cref;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s" ,
                super.toString(),
                matricula,
                cref,
                personal ? "TRUE" : "FALSE",
                salario
        );
    }

    public int getMatricula(){
        return matricula;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public boolean getPersonal(){return personal;}

    public void setPersonal(boolean personal){this.personal = personal;}

    public double getSalario(){return salario;}

    public void setSalario(double salario){this.salario = salario;}

    public int getCref(){ return cref;}

    public void setCref(int cref){this.cref = cref;}

}