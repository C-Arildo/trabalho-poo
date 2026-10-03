// criação da classe funcionario //
class Funcionario {

//atributos da classe funcionario//
   protected String nome;
   protected String cpf;
   protected String datadenascimento;
   protected String telefone;
   protected float salario;

//metodos construtores da classe funcionario//
   public Funcionario(String nome, String cpf, String datadenascimento, String telefone, float salario) {
       this.nome = nome;
       this.cpf = cpf;
       this.datadenascimento = datadenascimento;
       this.telefone = telefone;
       this.salario = salario;
   }

//metodos GET da classe funcionario//
   public String getNome() {
       return nome;
   }
   public String getCpf() {
       return cpf;
   }
   public String getDatadenascimento() {
       return datadenascimento;
   }
   public String getTelefone() {
       return telefone;
   }
   public float getSalario() {
       return salario;
   }


    // métodos SET da classe funcionario//
   public void setNome(String nome) {
       this.nome = nome;
   }
   public void setCpf(String cpf) {
       this.cpf = cpf;
   }
   public void setDatadenascimento(String datadenascimento) {
       this.datadenascimento = datadenascimento;
   }
   public void setTelefone(String telefone) {
       this.telefone = telefone;
   }
   public void setSalario(float salario) {
       this.salario = salario;
   }


    //método de exibir dados da classe funcionario//
   public void exibirDados() {
       System.out.println("Nome: " + nome);
       System.out.println("Cpf: " + cpf);
       System.out.println("Data de Nascimento: " + datadenascimento);
       System.out.println("Telefone: " + telefone);
       System.out.println("Salário: " + salario);

   }

    //método de calcular bonus da classe funcionario//
   public double calcularBonus() {
   return salario * 0.10;

   }
}
