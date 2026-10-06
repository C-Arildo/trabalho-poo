import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//ler os dados digitados pelo usuario//
    static Scanner sc = new Scanner(System.in);

//lista para armazenar os gerentes//
    static ArrayList<Gerente> gerentes = new ArrayList<>();

//lista para armazenar os desenvolvedores//
    static ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();

//numero para gerar id automatico//
    static int proximoId = 1;

    public static void main(String[] args) {

        int opcao = 0;

//while para rodar até o usuario escolher o 6//
        while (opcao != 6) {

            System.out.println("Menu Principal. Escolha a opção abaixo:  ");
            System.out.println("1 - Administrar Gerentes");
            System.out.println("2 - Administrar Desenvolvedores");
            System.out.println("3 - Consultar informações de um funcionário");
            System.out.println("4 - Calcular e exibir bônus de um funcionario");
            System.out.println("5 - Imprimir dados de todos funcionários de uma categoria específica");
            System.out.println("6 - Sair do programa");
         

            opcao = sc.nextInt();
            sc.nextLine();


//olhar qual opção o usuario escolheu/
            if (opcao == 1) {
                administrarGerentes();

            } else if (opcao == 2) {
                administrarDesenvolvedores();

            } else if (opcao == 3) {
                consultarFuncionario();

            } else if (opcao == 4) {
                consultarBonus();

            } else if (opcao == 5) {
                relatorio();

            } else if (opcao == 6) {
                System.out.println("Saindo do programa");

            } else {
                System.out.println("inválido");
            }
        }
    }


    //  GERENTES    //

    static void administrarGerentes() {

        int opcao = 0;

//menu dos gerentes//
        while (opcao != 5) {

            System.out.println("\n -GERENTES- ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Ler");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Voltar");
            

            opcao = sc.nextInt();
            sc.nextLine();


//para cadastrar um gerente//
            if (opcao == 1) {

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                System.out.print("Data de nascimento: ");
                String data = sc.nextLine();

                System.out.print("Telefone: ");
                String telefone = sc.nextLine();

                System.out.print("Salário: ");
                double salario = sc.nextDouble();
                sc.nextLine();

                System.out.print("Departamento: ");
                String departamento = sc.nextLine();

// cria um novo gerente e gera o id automatico//
                Gerente gerente = new Gerente(
                        proximoId,
                        nome,
                        cpf,
                        data,
                        telefone,
                        salario,
                        departamento
                );

//coloca o gerente na lista//
                gerentes.add(gerente);

                proximoId++;

                System.out.println("Gerente cadastrado!");
                System.out.println("ID: " + gerente.getId());

//para listar///
            } else if (opcao == 2) {

                if (gerentes.size() == 0) {

                    System.out.println("Não tem nenhum gerente");

                } else {

                    System.out.println("\n-GERENTES-");

                    int i = 0;

//while para percorrer a lista//
                    while (i < gerentes.size()) {

                        Gerente gerente = gerentes.get(i);

                        System.out.println("ID: " + gerente.getId());
                        System.out.println("Nome: " + gerente.getNome());
                        System.out.println("CPF: " + gerente.getCpf());
                        System.out.println();

                        i++;
                    }

//escolher gerente pelo id//
                    System.out.print("Digite o ID para ver os dados completos ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (id != 0) {

                        i = 0;
                        boolean encontrado = false;

                        while (i < gerentes.size()) {

                            Gerente gerente = gerentes.get(i);

//comparar os ids//
                            if (gerente.getId() == id) {

                                gerente.exibirDados();
                                encontrado = true;
                            }

                            i++;
                        }

                        if (!encontrado) {
                            System.out.println("ID não encontrado.");
                        }
                    }
                }



            } else if (opcao == 3) {

                System.out.print("Digite o CPF do gerente: ");
                String cpf = sc.nextLine();

                Gerente gerente = buscarGerente(cpf);

                if (gerente == null) {

                    System.out.println("Gerente não encontrado");

                } else {

                    gerente.exibirDados();

                    System.out.println("\nDigite os novos dados:");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Data de nascimento: ");
                    String data = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Departamento: ");
                    String departamento = sc.nextLine();

                    System.out.print("Salvar alterações? (S sim / N não): ");
                    String resposta = sc.nextLine();

                    if (resposta.equalsIgnoreCase("S")) {

                        gerente.setNome(nome);
                        gerente.setDataNascimento(data);
                        gerente.setTelefone(telefone);
                        gerente.setSalario(salario);
                        gerente.setDepartamento(departamento);

                        System.out.println("Alterações salvas");

                    } else {

                        System.out.println("Alterações canceladas");
                    }
                }

            } else if (opcao == 4) {

                System.out.print("Digite o CPF do gerente: ");
                String cpf = sc.nextLine();

                Gerente gerente = buscarGerente(cpf);

                if (gerente == null) {

                    System.out.println("Gerente não encontrado");

                } else {

                    gerente.exibirDados();

                    System.out.print("  S sim / N não  ");
                    String resposta = sc.nextLine();

                    if (resposta.equalsIgnoreCase("S")) {

                        gerentes.remove(gerente);

                        System.out.println("Gerente excluído");

                    } else {

                        System.out.println("Exclusão cancelada");
                    }
                }

            } else if (opcao == 5) {

                System.out.println("voltando");

            } else {

                System.out.println("Opção inválida");
            }
        }
    }

    // DESENVOLVEDORES //

    static void administrarDesenvolvedores() {

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n DESENVOLVEDORES ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Ler");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Voltar");
          

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                System.out.print("Data de nascimento: ");
                String data = sc.nextLine();

                System.out.print("Telefone: ");
                String telefone = sc.nextLine();

                System.out.print("Salário: ");
                double salario = sc.nextDouble();
                sc.nextLine();

                System.out.print("Linguagem principal: ");
                String linguagem = sc.nextLine();

                Desenvolvedor desenvolvedor = new Desenvolvedor(
                        proximoId,
                        nome,
                        cpf,
                        data,
                        telefone,
                        salario,
                        linguagem
                );

                desenvolvedores.add(desenvolvedor);
                proximoId++;

                System.out.println("Desenvolvedor cadastrado");
                System.out.println("ID: " + desenvolvedor.getId());

            } else if (opcao == 2) {

                if (desenvolvedores.size() == 0) {

                    System.out.println("Nenhum desenvolvedor cadastrado");

                } else {

                    System.out.println("\n-DESENVOLVEDORES-");

                    int i = 0;

                    while (i < desenvolvedores.size()) {

                        Desenvolvedor desenvolvedor = desenvolvedores.get(i);

                        System.out.println("ID: " + desenvolvedor.getId());
                        System.out.println("Nome: " + desenvolvedor.getNome());
                        System.out.println("CPF: " + desenvolvedor.getCpf());
                        System.out.println();

                        i++;
                    }

                    System.out.print("Digite o ID para ver os dados completos ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (id != 0) {

                        i = 0;
                        boolean encontrado = false;

                        while (i < desenvolvedores.size()) {

                            Desenvolvedor desenvolvedor = desenvolvedores.get(i);

                            if (desenvolvedor.getId() == id) {

                                desenvolvedor.exibirDados();
                                encontrado = true;
                            }

                            i++;
                        }

                        if (!encontrado) {
                            System.out.println("ID não encontrad");
                        }
                    }
                }

            } else if (opcao == 3) {

                System.out.print("Digite o CPF do desenvolvedor ");
                String cpf = sc.nextLine();

                Desenvolvedor desenvolvedor = buscarDesenvolvedor(cpf);

                if (desenvolvedor == null) {

                    System.out.println("Desenvolvedor não encontrado");

                } else {

                    desenvolvedor.exibirDados();

                    System.out.println("\nDigite os novos dados");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Data de nascimento: ");
                    String data = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Linguagem principal: ");
                    String linguagem = sc.nextLine();

                    System.out.print("Salvar alterações?  S sim / N não: ");
                    String resposta = sc.nextLine();

                    if (resposta.equalsIgnoreCase("S")) {

                        desenvolvedor.setNome(nome);
                        desenvolvedor.setDataNascimento(data);
                        desenvolvedor.setTelefone(telefone);
                        desenvolvedor.setSalario(salario);
                        desenvolvedor.setLinguagemPrincipal(linguagem);

                        System.out.println("Alterações salvas");

                    } else {

                        System.out.println("Alterações canceladas");
                    }
                }

            } else if (opcao == 4) {

                System.out.print("Digite o CPF do desenvolvedor: ");
                String cpf = sc.nextLine();

                Desenvolvedor desenvolvedor = buscarDesenvolvedor(cpf);

                if (desenvolvedor == null) {

                    System.out.println("Desenvolvedor não encontrado");

                } else {

                    desenvolvedor.exibirDados();

                    System.out.print("Deseja excluir?  S sim / N não: ");
                    String resposta = sc.nextLine();

                    if (resposta.equalsIgnoreCase("S")) {

                        desenvolvedores.remove(desenvolvedor);

                        System.out.println("Desenvolvedor excluído");

                    } else {

                        System.out.println("Exclusão Cancelada");
                    }
                }

            } else if (opcao == 5) {

                System.out.println("Voltando");

            } else {

                System.out.println("Opção inválida");
            }
        }
    }

    //  buscar gerente//

    static Gerente buscarGerente(String cpf) {

        int i = 0;

        while (i < gerentes.size()) {

            Gerente gerente = gerentes.get(i);

            if (gerente.getCpf().equals(cpf)) {
                return gerente;
            }

            i++;
        }

        return null;
    }

    // buscar desenvolvedor//

    static Desenvolvedor buscarDesenvolvedor(String cpf) {

        int i = 0;

        while (i < desenvolvedores.size()) {

            Desenvolvedor desenvolvedor = desenvolvedores.get(i);

            if (desenvolvedor.getCpf().equals(cpf)) {
                return desenvolvedor;
            }

            i++;
        }

        return null;
    }

    // consultar funcionario//

    static void consultarFuncionario() {

        System.out.print("Digite o CPF: ");
        String cpf = sc.nextLine();

        Gerente gerente = buscarGerente(cpf);

        if (gerente != null) {

            gerente.exibirDados();
            return;
        }

        Desenvolvedor desenvolvedor = buscarDesenvolvedor(cpf);

        if (desenvolvedor != null) {

            desenvolvedor.exibirDados();

        } else {

            System.out.println("Funcionário não encontrado.");
        }
    }

    // consultar o bonus/

    static void consultarBonus() {

        System.out.print("Digite o CPF: ");
        String cpf = sc.nextLine();

        Gerente gerente = buscarGerente(cpf);

        if (gerente != null) {

            System.out.println("Funcionário: " + gerente.getNome());
            System.out.println("Bônus: R$ " + gerente.calcularBonus());
            return;
        }

        Desenvolvedor desenvolvedor = buscarDesenvolvedor(cpf);

        if (desenvolvedor != null) {

            System.out.println("Funcionário: " + desenvolvedor.getNome());
            System.out.println("Bônus: R$ " + desenvolvedor.calcularBonus());

        } else {

            System.out.println("Funcionário não encontrado");
        }
    }

    //relatório//

    static void relatorio() {

        System.out.println("\n RELATÓRIO ");
        System.out.println("1 - Gerentes");
        System.out.println("2 - Desenvolvedores");
       

        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1) {

            if (gerentes.size() == 0) {

                System.out.println("Nenhum gerente cadastrado");

            } else {

                int i = 0;

                while (i < gerentes.size()) {

                    gerentes.get(i).exibirDados();

                  

                    i++;
                }
            }

        } else if (opcao == 2) {

            if (desenvolvedores.size() == 0) {

                System.out.println("Nenhum desenvolvedor cadastrado");

            } else {

                int i = 0;

                while (i < desenvolvedores.size()) {

                    desenvolvedores.get(i).exibirDados();

                    

                    i++;
                }
            }

        } else {

            System.out.println("Opção inválida");
        }
    }
}
