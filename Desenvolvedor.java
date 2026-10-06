//criação da classe desenvolvedor herdendo atributos da classe funcionario//

public class Desenvolvedor extends Funcionario {

//herdando atributos da classe funcionario e adicionando mais um atributo proprio da classe desenvolvedor(linguagem principal)//

    private String linguagemPrincipal;
    private int id;

//metodos construtores//
    public Desenvolvedor(int id, String nome, String cpf,
                         String datadenascimento, String telefone,
                         double salario, String linguagemPrincipal) {

        super(nome, cpf, datadenascimento, telefone, salario);

        this.id = id;
        this.linguagemPrincipal = linguagemPrincipal;
    }

//retorna o id//

    public int getId() {
        return id;
    }

//metodos get e set para ler e alterar//

    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    public void setLinguagemPrincipal(String linguagemPrincipal) {
        this.linguagemPrincipal = linguagemPrincipal;
    }

///metodo exibir dados sobrescrito com (linguagemprincipal)//

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("ID: " + id);
        System.out.println("Linguagem principal: " + linguagemPrincipal);
    }

//metodo bonus sobrescrito com bonus de quinze por cento//

    @Override
    public double calcularBonus() {
        return salario * 0.15;
    }
}