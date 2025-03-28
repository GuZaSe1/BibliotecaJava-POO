public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private int quantidade;
    
    public Livro(String titulo, String autor, String genero, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.quantidade = quantidade;    
    }
    
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Gênero: " + genero + ", Quantidade: " + quantidade;       
    }
    
    // Get e Set da classe Livro;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}