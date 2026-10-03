//criação da classe desenvolvedor herdendo atributos da classe funcionario//
class Desenvolvedor extends Funcionario {

//herdando atributos da classe funcionario e adicionando mais um atributo proprio da classe desenvolvedor(linguagem principal)//
    private String  Linguagemprincipal;

   public Gerente(String nome, String cpf, String datadenascimento, String telefone, float salario, String Linguagemprincipal) {
       super(nome, cpf, datadenascimento, telefone, salario);
        this.Linguagemprincipal=Linguagemprincipal;
}
//metodos get e set//
     public String getLinguagemprincipal(){
        return Linguagemprincipal;
    }
    public void setLinguagemprincipal(String Linguagemprincipal){
        this.Linguagemprincipal=Linguagemprincipal;
}
///metodo exibir dados sobrescrito com (linguagemprincipal)//
    @Override
    public void exibirDados(){
        super.exibirDados();
        
        System.out.println("linguagem principal: " + Linguagemprincipal);
    }
//metodo bonus sobrescrito com bonus de quinze por cento//
    @Override
    public void double calcularBonus(){
        return salario*0.15;
    }
    
}
