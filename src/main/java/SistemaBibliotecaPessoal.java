import java.util.List;

public interface SistemaBibliotecaPessoal {
    void adicionarLivro(Livro livro) throws LivroJaExisteException;
    void removerLivro(String titulo) throws LivroNaoEncontradoException;
    Livro pesquisarLivrosPorTitulo(String titulo);
    List<Livro> pesquisarLivrosPorAutor(String autor);
    List<Livro> pesquisarLivrosPorGenero(String genero);
    List<Livro> listarTodosLivros();
}



