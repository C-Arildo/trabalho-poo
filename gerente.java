//criaçao da classe gerente herdando atributos da classe funcionario//
class Gerente extends Funcionario{


//herdando atributos da classe funcionario e adicionando mais um atributo proprio da classe gerente(departamento)//
    private String  departamento;

   public Gerente(String nome, String cpf, String datadenascimento, String telefone, float salario, String departamento) {
       super(nome, cpf, datadenascimento, telefone, salario);
        this.departamento=departamento;

//metodos get e set//
   }
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento=departamento;
    }
///metodo exibir dados sobrescrito com departamento//
    @Override
    public void exibirDados(){
        super.exibirDados
System.out.println("departamneto: " + departamento);
    }
//metodo bonus sobrescrito com bonus de vinte por cento//
    @Override
    public double calcularBonus(){
        return salario*0.20;
    }
}
