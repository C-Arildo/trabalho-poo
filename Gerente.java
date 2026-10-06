class Gerente extends Funcionario {

    private int id;
    private String departamento;

    public Gerente(int id, String nome, String cpf,
                   String datadenascimento, String telefone,
                   double salario, String departamento) {

        super(nome, cpf, datadenascimento, telefone, salario);
        this.id = id;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("ID: " + id);
        System.out.println("Departamento: " + departamento);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.20;
    }
}