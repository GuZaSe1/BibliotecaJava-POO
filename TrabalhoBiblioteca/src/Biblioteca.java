import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        livros = new ArrayList<>();     // Adicionando os Livros dentro de um Array;
        usuarios = new ArrayList<>();   // Adicionando os Usuarios dentro de um Array;
    }

    //FUNÇÕES PARA OS LIVROS:

    public void adicionarLivro(Livro livro) {       // Função p/ adicionar os livros;
        livros.add(livro);
        System.out.println("\nLivro cadastrado com sucesso!\n");
    }

    public void listarLivros() {        // Função p/ listar os livros;
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado.\n");
            return;
        }

        System.out.println("\n--- Livros cadastrados ---");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
        System.out.println("--------------------------\n");
    }

    public boolean removerLivro(String titulo) {        // Função p/ remover um livro da biblioteca;
        for (int i=0; i<livros.size(); i++) {
            Livro livroAtual = livros.get(i);
            if (livroAtual.getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(i);
                System.out.println("\nLivro removido com sucesso.\n");
                return true;
            }
        }
        System.out.println("\nLivro não encontrado.\n");
        return false;
    }

    public boolean retirarLivro(String titulo) {        //Função p/ retirar um livro para leitura;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.getQuantidade() > 0) {
                    livro.setQuantidade(livro.getQuantidade() - 1);
                    System.out.println("\nLivro retirado com sucesso. Restam agora: " + livro.getQuantidade());
                    return true;
                } else {
                    System.out.println("\nEste livro não está disponível para retirada (quantidade = 0).\n");
                    return false;
                }
            }
        }
        System.out.println("\nLivro não encontrado.\n");
        return false;
    }

    public boolean estaVazia() {        // Função p/ caso lista estar vazia ñ remover/retirar livros;
        return livros.isEmpty();
    }

    // FUNÇÕES PARA OS USUARIOS:

    public void adicionarUsuario(Usuario usuario) {     // Função p/ adicionar usuarios;
        usuarios.add(usuario);
        System.out.println("\nUsuário cadastrado com sucesso!\n");
    }

    public void listarUsuarios() {      // Função p/ listar usuarios;
        if (usuarios.isEmpty()) {
            System.out.println("\nNenhum usuário cadastrado.\n");
            return;
        }

        System.out.println("\n--- Usuários cadastrados ---");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
        System.out.println("----------------------------\n");
    }

    public boolean removerUsuario(String cpf) {     // Função p/ remover usuarios;
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                usuarios.remove(usuario);
                System.out.println("\nUsuário removido com sucesso.\n");
                return true;
            }
        }
        System.out.println("Usuário não encontrado.");
        return false;
    }

    public Usuario buscarUsuario(String cpf) {      // Função p/ buscar usuarios;
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean temUsuarios() {      // Função p/ caso lista estar vazia ñ remover usuarios;
        return !usuarios.isEmpty();
    }

    public boolean retirarLivro(String titulo, Usuario usuario) {       // Função p/ atribuir a retirada de um livro a um usuario;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.getQuantidade() > 0) {
                    livro.setQuantidade(livro.getQuantidade() - 1);
                    System.out.println("Livro retirado por " + usuario.getNome() + 
                                       ". Restam agora: " + livro.getQuantidade());
                    return true;
                } else {
                    System.out.println("Livro indisponível.");
                    return false;
                }
            }
        }
        System.out.println("Livro não encontrado.");
        return false;
    }   
}