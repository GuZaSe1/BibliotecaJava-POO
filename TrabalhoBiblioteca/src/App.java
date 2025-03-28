import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();      
        Scanner in = new Scanner(System.in);
        int opcao;

        do {    // Menu da Biblioteca:
            System.out.println("\n===== Biblioteca =====\n");
            System.out.println("1. Cadastrar novo livro");
            System.out.println("2. Mostrar livros cadastrados");
            System.out.println("3. Remover livro");
            System.out.println("4. Cadastrar usuário");
            System.out.println("5. Listar usuários");
            System.out.println("6. Remover usuário");
            System.out.println("7. Retirar livro (empréstimo)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {       // P/ permitir entrada apenas de numeros validos;
                opcao = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1; // Opção inválida
            }

            switch (opcao) {
                case 1:     // 1. Cadastrar novo livro;
                    System.out.print("\nTítulo: ");
                    String titulo = in.nextLine();

                    System.out.print("Autor: ");
                    String autor = in.nextLine();

                    System.out.print("Gênero: ");
                    String genero = in.nextLine();

                    System.out.print("Quantidade: ");
                    
                    int quantidade = lerQuantidade(in);

                    Livro novoLivro = new Livro(titulo, autor, genero, quantidade);
                    biblioteca.adicionarLivro(novoLivro);
                    break;

                case 2:     // 2. Mostrar livros cadastrados;
                    biblioteca.listarLivros();
                    break;
                
                case 3:     // 3. Remover livro do acervo;
                    if (biblioteca.estaVazia()) {
                    System.out.println("\nNão há livros cadastrados. Remoção cancelada.\n");
                    break;
                    }
                    System.out.print("\nDigite o título do livro que deseja remover: ");
                    String tituloRemover = in.nextLine();
                    biblioteca.removerLivro(tituloRemover);
                    break;

                case 4:     // 4. Cadastrar usuário;
                    System.out.print("\nNome do usuário: ");
                    String nome = in.nextLine();
                    System.out.print("\nCPF do usuário: ");
                    String cpf = in.nextLine();

                    Usuario novoUsuario = new Usuario(nome, cpf);
                    biblioteca.adicionarUsuario(novoUsuario);
                    break;

                case 5:     // 5. Listar usuários;
                    biblioteca.listarUsuarios();
                    break;

                case 6:     // 6. Remover usuário;
                    if (biblioteca.temUsuarios()) {
                        System.out.print("\nCPF do usuário: ");
                        String cpfRemover = in.nextLine();
                        biblioteca.removerUsuario(cpfRemover);
                    } else {
                        System.out.println("\nNenhum usuário cadastrado.\n");
                    }
                    break;

                case 7:     // 7. Retirar livro (empréstimo);
                    if (biblioteca.temUsuarios() && !biblioteca.estaVazia()) {
                        System.out.print("\nCPF do usuário: ");
                        String cpfUsuario = in.nextLine();
                        Usuario usuario = biblioteca.buscarUsuario(cpfUsuario);
                        if (usuario != null) {
                            System.out.print("\nTítulo do livro para retirar: ");
                            String tituloRetirar = in.nextLine();
                            biblioteca.retirarLivro(tituloRetirar, usuario);
                        } else {
                            System.out.println("\nUsuário não encontrado.\n");
                        }
                    } else {
                        System.out.println("\nNecessário ter livros e usuários cadastrados.\n");
                    }
                    break;
                
                case 0:     // 0. Sair
                    System.out.println("\nEncerrando...\n");
                    break;

                default:    // Opção Invalida.
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }

        } while (opcao != 0);
        
        in.close();
    }

    public static int lerQuantidade(Scanner in) { // Função p/ informar quantidade valida p/ cadastro de livros;
        int quantidade;
        while (true) {
            System.out.print("Quantidade: ");
            try {
                quantidade = Integer.parseInt(in.nextLine());
                if (quantidade >= 0) {
                    return quantidade;  // Quantidade valida;
                } else {
                    System.out.println("Digite uma quantidade positiva!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
            }
        }
    }
}